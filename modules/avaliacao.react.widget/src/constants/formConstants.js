/**
 * 📁 src/constants/formConstants.js
 */

export var PERIODO_DESAFIO_OPTIONS = [
  { value: 1, label: '30 dias' },
  { value: 2, label: '60 dias' },
  { value: 3, label: '90 dias' }
];

export var AREA_ATUACAO_OPTIONS = [
  { value: 1, label: 'Analista' },
  { value: 2, label: 'Tester' },
  { value: 3, label: 'UI Designer' },
  { value: 4, label: 'Front-end' },
  { value: 5, label: 'Back-end' }
];

export var DESEMPENHO_OPTIONS = [
  { value: 1, label: '⭐ 1 - Insatisfatório' },
  { value: 2, label: '⭐⭐ 2 - Abaixo do Esperado' },
  { value: 3, label: '⭐⭐⭐ 3 - Satisfatório' },
  { value: 4, label: '⭐⭐⭐⭐ 4 - Bom' },
  { value: 5, label: '⭐⭐⭐⭐⭐ 5 - Excelente' }
];

export var PERIODO_DESAFIO_LABEL = {
  1: '30 dias',
  2: '60 dias',
  3: '90 dias'
};

export var AREA_ATUACAO_LABEL = {
  1: 'Analista',
  2: 'Tester',
  3: 'UI Designer',
  4: 'Front-end',
  5: 'Back-end'
};

export var DESEMPENHO_LABEL = {
  1: 'Insatisfatório',
  2: 'Abaixo do Esperado',
  3: 'Satisfatório',
  4: 'Bom',
  5: 'Excelente'
};

export var PLACEHOLDERS = {
  FUNCIONARIO: 'Digite o nome do funcionário...',
  NOME_AVALIADOR: 'Ex: Carlos Roberto Silva (Tech Lead)',
  OBSERVACOES_GERAIS: 'Observações iniciais sobre o funcionário...',
  OBSERVACOES_AVALIADOR: 'Descreva o desempenho do colaborador...',
  BUSCAR: 'Buscar avaliação...'
};

export var VALIDATION_MESSAGES = {
  FUNCIONARIO_OBRIGATORIO: 'Por favor, selecione um funcionário',
  DATA_OBRIGATORIA: 'Por favor, informe a data da avaliação',
  PERIODO_OBRIGATORIO: 'Por favor, selecione o período do desafio',
  AREA_OBRIGATORIA: 'Por favor, selecione a área de atuação',
  NOME_OBRIGATORIO: 'Por favor, informe seu nome',
  OBSERVACAO_OBRIGATORIA: 'Por favor, informe suas observações',
  DESEMPENHO_OBRIGATORIO: 'Por favor, selecione uma nota de desempenho'
};