const BASE_URL = '/o/avaliacao-headless/v1.0';


export const getHeaders = () => {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
    };
};

export const API_ENDPOINTS = {
    createCompleta: () => `${BASE_URL}/avaliacoes/completa`,
    getByFuncionario: (id) => `${BASE_URL}/avaliacoes/funcionario/${id}`,
    getCompletaById: (id) => `${BASE_URL}/avaliacoes/${id}/completa`,
    search: () => `${BASE_URL}/avaliacoes/search`
};