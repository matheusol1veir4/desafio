import React from 'react';
import { PERIODO_DESAFIO_LABEL, AREA_ATUACAO_LABEL } from '../constants/formConstants';

function AvaliacaoCard(props) {
  var av = props.avaliacao;
  if (!av) return null;

  return React.createElement('div', { className: 'avaliacao-card' },
    React.createElement('div', { className: 'card-header' },
      React.createElement('h3', null, 'Avaliação #' + av.avaliacaoId),
      React.createElement('span', { className: 'status-badge status-' + (av.status || 'PENDENTE').toLowerCase() },
        av.status || 'PENDENTE'
      )
    ),
    React.createElement('div', { className: 'card-body' },
      React.createElement('div', { className: 'info-row' },
        React.createElement('span', { className: 'info-label' }, 'Funcionário:'),
        React.createElement('span', { className: 'info-value' }, 'ID ' + av.funcionarioId)
      ),
      React.createElement('div', { className: 'info-row' },
        React.createElement('span', { className: 'info-label' }, 'Período:'),
        React.createElement('span', { className: 'info-value' }, PERIODO_DESAFIO_LABEL[av.periodoDesafio] || 'N/A')
      ),
      React.createElement('div', { className: 'info-row' },
        React.createElement('span', { className: 'info-label' }, 'Área:'),
        React.createElement('span', { className: 'info-value' }, AREA_ATUACAO_LABEL[av.areaAtuacao] || 'N/A')
      )
    ),
    React.createElement('div', { className: 'card-actions' },
      React.createElement('button', {
        className: 'btn btn-primary',
        onClick: function() { props.onPreencher(av.avaliacaoId); }
      }, '✏️ Preencher'),
      React.createElement('button', {
        className: 'btn btn-secondary',
        onClick: function() { props.onVerDetalhes(av.avaliacaoId); }
      }, '👁️ Detalhes')
    )
  );
}

export default AvaliacaoCard;