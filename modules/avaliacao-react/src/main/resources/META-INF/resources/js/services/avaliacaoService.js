// ============================================
// CONSTANTE BASE DA API
// ============================================
const API_BASE_URL = '/o/avaliacao-headless/v1.0';

// ============================================
// FUNÇÃO: Buscar funcionários por nome
// ============================================
export const buscarFuncionarios = async (nome) => {
    return new Promise((resolve, reject) => {
        const url = `/o/avaliacao-headless/v1.0/funcionarios?nome=${encodeURIComponent(nome)}`;
        const token = typeof Liferay !== 'undefined' && Liferay.authToken ? Liferay.authToken : '';

        const xhr = new XMLHttpRequest();
        xhr.open('GET', url, true);
        xhr.withCredentials = true;  // ✅ ADICIONE ISSO!
        xhr.setRequestHeader('Accept', 'application/json');

        if (token) {
            xhr.setRequestHeader('x-csrf-token', token);
        }

        xhr.onload = function() {
            if (xhr.status >= 200 && xhr.status < 300) {
                try {
                    const response = JSON.parse(xhr.responseText);
                    resolve(response.items || []);
                } catch (e) {
                    reject(new Error('Failed to parse response: ' + xhr.responseText));
                }
            } else {
                reject(new Error(`HTTP ${xhr.status}: ${xhr.responseText}`));
            }
        };

        xhr.onerror = function() {
            reject(new Error('Network error'));
        };

        xhr.send();
    });
};

// ============================================
// FUNÇÃO: Criar avaliação completa
// ============================================
export const createAvaliacaoCompleta = async (avaliacaoData) => {
    return new Promise((resolve, reject) => {
        const url = '/o/avaliacao-headless/v1.0/avaliacoes/completa';
        const token = typeof Liferay !== 'undefined' && Liferay.authToken ? Liferay.authToken : '';

        const xhr = new XMLHttpRequest();
        xhr.open('POST', url, true);
        xhr.withCredentials = true;  // ✅ ADICIONE ISSO!
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.setRequestHeader('Accept', 'application/json');

        if (token) {
            xhr.setRequestHeader('x-csrf-token', token);
        }

        xhr.onload = function() {
            if (xhr.status >= 200 && xhr.status < 300) {
                try {
                    const response = JSON.parse(xhr.responseText);
                    resolve(response);
                } catch (e) {
                    reject(new Error('Failed to parse response: ' + xhr.responseText));
                }
            } else {
                reject(new Error(`HTTP ${xhr.status}: ${xhr.responseText}`));
            }
        };

        xhr.onerror = function() {
            reject(new Error('Network error'));
        };

        xhr.send(JSON.stringify(avaliacaoData));
    });
};

// ============================================
// FUNÇÃO: Buscar avaliações por funcionário
// ============================================
export const getAvaliacoesByFuncionario = async (funcionarioId) => {
    return new Promise((resolve, reject) => {
        const url = `/o/avaliacao-headless/v1.0/avaliacoes/funcionario/${funcionarioId}`;
        const token = typeof Liferay !== 'undefined' && Liferay.authToken ? Liferay.authToken : '';

        const xhr = new XMLHttpRequest();
        xhr.open('GET', url, true);
        xhr.withCredentials = true;  // ✅ ADICIONE ISSO!
        xhr.setRequestHeader('Accept', 'application/json');

        if (token) {
            xhr.setRequestHeader('x-csrf-token', token);
        }

        xhr.onload = function() {
            if (xhr.status >= 200 && xhr.status < 300) {
                try {
                    const response = JSON.parse(xhr.responseText);
                    resolve(response);
                } catch (e) {
                    reject(new Error('Failed to parse response: ' + xhr.responseText));
                }
            } else {
                reject(new Error(`HTTP ${xhr.status}: ${xhr.responseText}`));
            }
        };

        xhr.onerror = function() {
            reject(new Error('Network error'));
        };

        xhr.send();
    });
};

// ============================================
// FUNÇÃO: Buscar avaliação completa por ID
// ============================================
export const getAvaliacaoCompletaById = async (avaliacaoId) => {
    return new Promise((resolve, reject) => {
        const url = `/o/avaliacao-headless/v1.0/avaliacoes/${avaliacaoId}/completa`;
        const token = typeof Liferay !== 'undefined' && Liferay.authToken ? Liferay.authToken : '';

        const xhr = new XMLHttpRequest();
        xhr.open('GET', url, true);
        xhr.withCredentials = true;  // ✅ ADICIONE ISSO!
        xhr.setRequestHeader('Accept', 'application/json');

        if (token) {
            xhr.setRequestHeader('x-csrf-token', token);
        }

        xhr.onload = function() {
            if (xhr.status >= 200 && xhr.status < 300) {
                try {
                    const response = JSON.parse(xhr.responseText);
                    resolve(response);
                } catch (e) {
                    reject(new Error('Failed to parse response: ' + xhr.responseText));
                }
            } else {
                reject(new Error(`HTTP ${xhr.status}: ${xhr.responseText}`));
            }
        };

        xhr.onerror = function() {
            reject(new Error('Network error'));
        };

        xhr.send();
    });
};

// ============================================
// FUNÇÃO: Buscar avaliações com filtros
// ============================================
export const searchAvaliacoes = async (filters) => {
  return new Promise((resolve, reject) => {
    const params = new URLSearchParams();

    // CORREÇÃO: Usar os nomes corretos dos parâmetros
    if (filters.nome) params.append('nome', filters.nome);
    if (filters.email) params.append('email', filters.email);
    if (filters.area) params.append('area', filters.area);
    if (filters.periodo) params.append('periodo', filters.periodo);

    const url = `/o/avaliacao-headless/v1.0/avaliacoes/search?${params.toString()}`;
    const token = typeof Liferay !== 'undefined' && Liferay.authToken ? Liferay.authToken : '';

    const xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);
    xhr.setRequestHeader('Accept', 'application/json');

    if (token) {
      xhr.setRequestHeader('x-csrf-token', token);
    }

    xhr.onload = function() {
      if (xhr.status >= 200 && xhr.status < 300) {
        try {
          const response = JSON.parse(xhr.responseText);
          resolve(response);  // Retorna o objeto completo, não só items
        } catch (e) {
          reject(new Error('Failed to parse response: ' + xhr.responseText));
        }
      } else {
        reject(new Error(`HTTP ${xhr.status}: ${xhr.responseText}`));
      }
    };

    xhr.onerror = function() {
      reject(new Error('Network error'));
    };

    xhr.send();
  });
};


// ============================================
// FUNÇÃO: Buscar avaliações pendentes (já está correta!)
// ============================================
export const buscarAvaliacoesPendentes = async () => {
    try {
        const response = await fetch(
            `${API_BASE_URL}/avaliacoes/pendentes-para-mim`,
            {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                },
                credentials: 'include'  // ✅ JÁ TEM!
            }
        );

        if (!response.ok) {
            if (response.status === 401) {
                throw new Error('Usuário não autenticado');
            }
            if (response.status === 403) {
                throw new Error('Usuário não possui papel de avaliador');
            }
            throw new Error(`Erro ao buscar avaliações pendentes: ${response.status}`);
        }

        const data = await response.json();
        return data.items || [];
    } catch (error) {
        console.error('Erro ao buscar avaliações pendentes:', error);
        throw error;
    }
};

// ============================================
// FUNÇÃO: Atualizar detalhe de avaliação
// ============================================
export const updateAvaliacaoDetalhe = async (detalheId, detalheData) => {
    return new Promise((resolve, reject) => {
        const url = `/o/avaliacao-headless/v1.0/detalhes/${detalheId}`;
        const token = typeof Liferay !== 'undefined' && Liferay.authToken ? Liferay.authToken : '';

        const xhr = new XMLHttpRequest();
        xhr.open('PUT', url, true);
        xhr.withCredentials = true;  // ✅ ADICIONE ISSO!
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.setRequestHeader('Accept', 'application/json');

        if (token) {
            xhr.setRequestHeader('x-csrf-token', token);
        }

        xhr.onload = function() {
            if (xhr.status >= 200 && xhr.status < 300) {
                try {
                    const response = JSON.parse(xhr.responseText);
                    resolve(response);
                } catch (e) {
                    reject(new Error('Failed to parse response: ' + xhr.responseText));
                }
            } else {
                reject(new Error(`HTTP ${xhr.status}: ${xhr.responseText}`));
            }
        };

        xhr.onerror = function() {
            reject(new Error('Network error'));
        };

        xhr.send(JSON.stringify(detalheData));
    });
};
