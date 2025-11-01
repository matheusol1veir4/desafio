/**
 * 📁 src/services/api.js
 *
 * Serviço centralizado de API
 * Todos os endpoints do backend em um único lugar
 * React 16 compatible - sem async/await
 */

var BASE_URL = '/o/avaliacao-rest/v1.0';

var apiService = {

  getHeaders: function() {
    return {
      'Content-Type': 'application/json',
      'Accept': 'application/json'
    };
  },

  handleResponse: function(response) {
    if (!response.ok) {
      throw new Error('HTTP Error ' + response.status);
    }
    return response.json();
  },

  // ============================================
  // AVALIAÇÃO ENDPOINTS
  // ============================================

  createAvaliacaoCompleta: function(payload) {
    return fetch(BASE_URL + '/avaliacoes/completa', {
      method: 'POST',
      headers: this.getHeaders(),
      credentials: 'same-origin',
      body: JSON.stringify(payload)
    }).then(this.handleResponse);
  },

  getAllAvaliacoes: function() {
    return fetch(BASE_URL + '/avaliacoes', {
      method: 'GET',
      headers: this.getHeaders(),
      credentials: 'same-origin'
    }).then(this.handleResponse)
      .then(function(data) {
        return data.items || [];
      });
  },

  getAvaliacaoById: function(avaliacaoId) {
    return fetch(BASE_URL + '/avaliacoes/' + avaliacaoId, {
      method: 'GET',
      headers: this.getHeaders(),
      credentials: 'same-origin'
    }).then(this.handleResponse);
  },

  getAvaliacaoCompleta: function(avaliacaoId) {
    return fetch(BASE_URL + '/avaliacoes/' + avaliacaoId + '/completa', {
      method: 'GET',
      headers: this.getHeaders(),
      credentials: 'same-origin'
    }).then(this.handleResponse);
  },

  updateAvaliacao: function(avaliacaoId, payload) {
    return fetch(BASE_URL + '/avaliacoes/' + avaliacaoId, {
      method: 'PUT',
      headers: this.getHeaders(),
      credentials: 'same-origin',
      body: JSON.stringify(payload)
    }).then(this.handleResponse);
  },

  deleteAvaliacao: function(avaliacaoId) {
    return fetch(BASE_URL + '/avaliacoes/' + avaliacaoId, {
      method: 'DELETE',
      headers: this.getHeaders(),
      credentials: 'same-origin'
    }).then(this.handleResponse);
  },

  // ============================================
  // DETALHE ENDPOINTS
  // ============================================

  getAvaliacaoDetalhes: function(avaliacaoId) {
    return fetch(BASE_URL + '/avaliacoes/' + avaliacaoId + '/detalhes', {
      method: 'GET',
      headers: this.getHeaders(),
      credentials: 'same-origin'
    }).then(this.handleResponse)
      .then(function(data) {
        return data.items || [];
      });
  },

  getAvaliacaoDetalheById: function(detalheId) {
    return fetch(BASE_URL + '/detalhes/' + detalheId, {
      method: 'GET',
      headers: this.getHeaders(),
      credentials: 'same-origin'
    }).then(this.handleResponse);
  },

  updateAvaliacaoDetalhe: function(detalheId, payload) {
    return fetch(BASE_URL + '/detalhes/' + detalheId, {
      method: 'PUT',
      headers: this.getHeaders(),
      credentials: 'same-origin',
      body: JSON.stringify(payload)
    }).then(this.handleResponse);
  },

  deleteAvaliacaoDetalhe: function(detalheId) {
    return fetch(BASE_URL + '/detalhes/' + detalheId, {
      method: 'DELETE',
      headers: this.getHeaders(),
      credentials: 'same-origin'
    }).then(this.handleResponse);
  },

  // ============================================
  // MÉTODOS AUXILIARES
  // ============================================

  getDetalheByTipo: function(avaliacaoId, tipoAvaliador) {
    return this.getAvaliacaoDetalhes(avaliacaoId)
      .then(function(detalhes) {
        var detalhe = detalhes.find(function(d) {
          return d.tipoAvaliador === tipoAvaliador;
        });

        if (!detalhe) {
          throw new Error('Detalhe tipo ' + tipoAvaliador + ' não encontrado');
        }

        return detalhe;
      });
  },

  isDetalhePreenchido: function(detalhe) {
    return detalhe &&
           detalhe.nomeAvaliador &&
           detalhe.observacoesAvaliador &&
           detalhe.desempenho !== null;
  },

  calcularStatusAvaliacao: function(detalhes) {
    if (!detalhes || !Array.isArray(detalhes)) {
      return 'PENDENTE';
    }

    var preenchidos = detalhes.filter(function(d) {
      return apiService.isDetalhePreenchido(d);
    }).length;

    if (preenchidos === 0) return 'PENDENTE';
    if (preenchidos === 3) return 'COMPLETA';
    return 'EM_ANDAMENTO';
  }
};

export default apiService;