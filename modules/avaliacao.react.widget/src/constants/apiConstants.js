/**
 * 📁 src/constants/apiConstants.js
 *
 * Constantes de API e Endpoints
 * Centraliza URLs e configurações para manutenção fácil
 */

// Base URL da API REST
export var BASE_URL = '/o/avaliacao-rest/v1.0';

// Endpoints de Avaliação
export var ENDPOINTS = {
  AVALIACOES: BASE_URL + '/avaliacoes',
  AVALIACOES_COMPLETA: BASE_URL + '/avaliacoes/completa',
  AVALIACOES_SEARCH: BASE_URL + '/avaliacoes/search',
  AVALIACOES_BY_ID: function(id) { return BASE_URL + '/avaliacoes/' + id; },
  AVALIACOES_COMPLETA_BY_ID: function(id) { return BASE_URL + '/avaliacoes/' + id + '/completa'; },
  AVALIACOES_BY_FUNCIONARIO: function(funcionarioId) {
    return BASE_URL + '/avaliacoes/funcionario/' + funcionarioId;
  },

  DETALHES_BY_AVALIACAO: function(avaliacaoId) {
    return BASE_URL + '/avaliacoes/' + avaliacaoId + '/detalhes';
  },
  DETALHES_BY_ID: function(detalheId) { return BASE_URL + '/detalhes/' + detalheId; }
};

// Tipos de Avaliador
export var TIPO_AVALIADOR = {
  TECHLEAD: 1,
  GERENTE: 2,
  RH: 3
};

// Labels de Tipo de Avaliador
export var TIPO_AVALIADOR_LABEL = {
  1: 'Tech Lead',
  2: 'Gerente',
  3: 'RH'
};

// Status de Avaliação
export var STATUS_AVALIACAO = {
  PENDENTE: 'PENDENTE',
  EM_ANDAMENTO: 'EM_ANDAMENTO',
  COMPLETA: 'COMPLETA'
};

// Classes CSS para Status
export var STATUS_CLASS = {
  PENDENTE: 'status-pendente',
  EM_ANDAMENTO: 'status-em-andamento',
  COMPLETA: 'status-completa'
};

// Mensagens padrão
export var MESSAGES = {
  SUCESSO_CRIAR_AVALIACAO: 'Avaliação criada com sucesso!',
  SUCESSO_ATUALIZAR_DETALHE: 'Avaliação salva com sucesso!',
  SUCESSO_DELETAR: 'Avaliação deletada com sucesso!',

  ERRO_CARREGAR: 'Erro ao carregar dados. Tente novamente.',
  ERRO_SALVAR: 'Erro ao salvar. Verifique os dados e tente novamente.',
  ERRO_DELETAR: 'Erro ao deletar. Tente novamente.',
  ERRO_BUSCAR_DETALHE: 'Erro ao buscar detalhes da avaliação.',

  ALERTA_DETALHE_NAO_ENCONTRADO: 'Detalhe não encontrado para esta avaliação!',
  ALERTA_CAMPOS_OBRIGATORIOS: 'Por favor, preencha todos os campos obrigatórios',

  EMAIL_ENVIADO: 'E-mails de notificação enviados para os avaliadores!'
};