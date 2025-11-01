import React from 'react';
import LoadingSpinner from '../components/LoadingSpinner';
import Modal from '../utils/Modal';
import apiService from '../services/api';
import { TIPO_AVALIADOR_LABEL, DESEMPENHO_LABEL } from '../constants/formConstants';

class DetalhesAvaliacao extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      avaliacaoId: props.avaliacaoId,
      avaliacaoCompleta: null,
      loading: true,
      error: null,
      showModal: false,
      modalMessage: ''
    };
  }

  componentDidMount() {
    this.loadAvaliacaoCompleta();
  }

  loadAvaliacaoCompleta() {
    var self = this;
    self.setState({ loading: true, error: null });

    apiService.getAvaliacaoCompleta(this.state.avaliacaoId)
      .then(function(data) {
        self.setState({
          avaliacaoCompleta: data,
          loading: false
        });
      })
      .catch(function(error) {
        console.error('Erro:', error);
        self.setState({
          loading: false,
          error: error.message
        });
      });
  }

  formatarData(dataStr) {
    if (!dataStr) return 'N/A';
    try {
      var data = new Date(dataStr);
      return data.toLocaleDateString('pt-BR');
    } catch (e) {
      return 'N/A';
    }
  }

  render() {
    var self = this;

    if (this.state.loading) {
      return React.createElement(LoadingSpinner, { fullScreen: true });
    }

    if (this.state.error || !this.state.avaliacaoCompleta) {
      return React.createElement('div', { className: 'error-container' },
        React.createElement('p', null, '❌ ' + (this.state.error || 'Avaliação não encontrada')),
        React.createElement('button', {
          className: 'btn btn-primary',
          onClick: function() { self.props.onNavigate('dashboard'); }
        }, 'Voltar')
      );
    }

    var aval = this.state.avaliacaoCompleta;

    return React.createElement('div', { className: 'detalhes-avaliacao-container' },
      React.createElement('h1', { className: 'page-title' }, '📋 Detalhes da Avaliação #' + aval.avaliacaoId),

      React.createElement('div', { className: 'detalhes-content' },
        // Seção: Dados Principais
        React.createElement('div', { className: 'section' },
          React.createElement('h2', null, 'Informações Principais'),
          React.createElement('div', { className: 'info-grid' },
            React.createElement('div', { className: 'info-item' },
              React.createElement('label', null, 'Funcionário ID:'),
              React.createElement('span', null, aval.funcionarioId)
            ),
            React.createElement('div', { className: 'info-item' },
              React.createElement('label', null, 'Data:'),
              React.createElement('span', null, this.formatarData(aval.dataAvaliacao))
            ),
            React.createElement('div', { className: 'info-item' },
              React.createElement('label', null, 'Período:'),
              React.createElement('span', null, aval.periodoDesafio + ' dias')
            ),
            React.createElement('div', { className: 'info-item' },
              React.createElement('label', null, 'Área:'),
              React.createElement('span', null, aval.areaAtuacao)
            )
          )
        ),

        // Seção: Observações Gerais
        aval.observacoesGerais ?
          React.createElement('div', { className: 'section' },
            React.createElement('h2', null, 'Observações Gerais'),
            React.createElement('p', { className: 'observacoes-text' }, aval.observacoesGerais)
          ) : null,

        // Seção: Detalhes dos Avaliadores
        aval.avaliacaoDetalhes && aval.avaliacaoDetalhes.length > 0 ?
          React.createElement('div', { className: 'section' },
            React.createElement('h2', null, 'Avaliações'),
            aval.avaliacaoDetalhes.map(function(detalhe) {
              var isPreenchido = detalhe.nomeAvaliador && detalhe.desempenho;
              return React.createElement('div', {
                key: detalhe.avaliacaoDetalheId,
                className: 'detalhe-card ' + (isPreenchido ? 'preenchido' : 'vazio')
              },
                React.createElement('div', { className: 'detalhe-header' },
                  React.createElement('h3', null, TIPO_AVALIADOR_LABEL[detalhe.tipoAvaliador] || 'Avaliador'),
                  isPreenchido ?
                    React.createElement('span', { className: 'badge badge-success' }, '✅ Preenchido') :
                    React.createElement('span', { className: 'badge badge-warning' }, '⏳ Pendente')
                ),
                isPreenchido ?
                  React.createElement('div', { className: 'detalhe-body' },
                    React.createElement('div', { className: 'info-row' },
                      React.createElement('strong', null, 'Avaliador:'),
                      React.createElement('span', null, detalhe.nomeAvaliador)
                    ),
                    React.createElement('div', { className: 'info-row' },
                      React.createElement('strong', null, 'Desempenho:'),
                      React.createElement('span', null, DESEMPENHO_LABEL[detalhe.desempenho] || 'N/A')
                    ),
                    detalhe.observacoesAvaliador ?
                      React.createElement('div', { className: 'info-row' },
                        React.createElement('strong', null, 'Observações:'),
                        React.createElement('p', { className: 'obs-text' }, detalhe.observacoesAvaliador)
                      ) : null
                  ) :
                  React.createElement('p', { className: 'empty-message' }, 'Aguardando preenchimento...')
              );
            })
          ) : null
      ),

      React.createElement('div', { className: 'form-actions' },
        React.createElement('button', {
          className: 'btn btn-secondary',
          onClick: function() { self.props.onNavigate('dashboard'); }
        }, 'Voltar')
      )
    );
  }
}

export default DetalhesAvaliacao;