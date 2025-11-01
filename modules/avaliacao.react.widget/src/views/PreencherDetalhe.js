import React from 'react';
import Modal from '../utils/Modal';
import apiService from '../services/api';
import { DESEMPENHO_OPTIONS, VALIDATION_MESSAGES, PLACEHOLDERS } from '../constants/formConstants';
import { TIPO_AVALIADOR_LABEL, MESSAGES } from '../constants/apiConstants';

class PreencherDetalhe extends React.Component {
  constructor(props) {
    super(props);

    var detalhe = props.detalhe || {};

    this.state = {
      nomeAvaliador: detalhe.nomeAvaliador || '',
      observacoesAvaliador: detalhe.observacoesAvaliador || '',
      desempenho: detalhe.desempenho || '',
      submitting: false,
      loading: !props.detalhe,
      showModal: false,
      modalType: 'success',
      modalMessage: ''
    };

    this.handleSubmit = this.handleSubmit.bind(this);
  }

  componentDidMount() {
    if (!this.props.detalhe && this.props.detalheId) {
      this.loadDetalhe();
    }
  }

  loadDetalhe() {
    var self = this;

    apiService.getAvaliacaoDetalheById(this.props.detalheId)
      .then(function(detalhe) {
        self.setState({
          nomeAvaliador: detalhe.nomeAvaliador || '',
          observacoesAvaliador: detalhe.observacoesAvaliador || '',
          desempenho: detalhe.desempenho || '',
          loading: false
        });
      })
      .catch(function(error) {
        console.error('Erro:', error);
        self.setState({
          loading: false,
          showModal: true,
          modalType: 'error',
          modalMessage: 'Erro ao carregar detalhe: ' + error.message
        });
      });
  }

  handleSubmit(e) {
    e.preventDefault();
    var self = this;

    if (!this.state.nomeAvaliador.trim()) {
      alert(VALIDATION_MESSAGES.NOME_OBRIGATORIO);
      return;
    }

    if (!this.state.observacoesAvaliador.trim()) {
      alert(VALIDATION_MESSAGES.OBSERVACAO_OBRIGATORIA);
      return;
    }

    if (!this.state.desempenho) {
      alert(VALIDATION_MESSAGES.DESEMPENHO_OBRIGATORIO);
      return;
    }

    this.setState({ submitting: true });

    var payload = {
      tipoAvaliador: this.props.tipoAvaliador,
      nomeAvaliador: this.state.nomeAvaliador,
      observacoesAvaliador: this.state.observacoesAvaliador,
      desempenho: parseInt(this.state.desempenho)
    };

    apiService.updateAvaliacaoDetalhe(this.props.detalheId, payload)
      .then(function(response) {
        console.log('Detalhe atualizado:', response);
        self.setState({
          showModal: true,
          modalType: 'success',
          modalMessage: MESSAGES.SUCESSO_ATUALIZAR_DETALHE,
          submitting: false
        });

        setTimeout(function() {
          self.handleCancel();
        }, 1500);
      })
      .catch(function(error) {
        console.error('Erro:', error);
        self.setState({
          showModal: true,
          modalType: 'error',
          modalMessage: MESSAGES.ERRO_SALVAR,
          submitting: false
        });
      });
  }

  handleCancel() {
    this.props.onNavigate('dashboard');
  }

  getTipoLabel() {
    return TIPO_AVALIADOR_LABEL[this.props.tipoAvaliador] || 'Avaliador';
  }

  render() {
    var self = this;

    if (this.state.loading) {
      return React.createElement('div', { className: 'loading' },
        '⏳ Carregando...'
      );
    }

    return React.createElement('div', { className: 'preencher-detalhe-container' },
      React.createElement('h1', { className: 'page-title' },
        '✏️ Preencher Avaliação - ' + this.getTipoLabel()
      ),
      React.createElement('p', { className: 'page-subtitle' },
        'Avaliação #' + this.props.avaliacaoId
      ),

      React.createElement(Modal, {
        isOpen: this.state.showModal,
        onClose: function() { self.setState({ showModal: false }); },
        title: this.state.modalType === 'success' ? '✅ Sucesso!' : '❌ Erro',
        message: this.state.modalMessage,
        type: this.state.modalType,
        autoClose: 1500
      }),

      React.createElement('form', {
        className: 'form-preencher',
        onSubmit: this.handleSubmit
      },
        React.createElement('div', { className: 'form-group' },
          React.createElement('label', null, 'Seu Nome *'),
          React.createElement('input', {
            type: 'text',
            className: 'form-control',
            placeholder: PLACEHOLDERS.NOME_AVALIADOR,
            value: this.state.nomeAvaliador,
            onChange: function(e) { self.setState({ nomeAvaliador: e.target.value }); },
            required: true
          })
        ),

        React.createElement('div', { className: 'form-group' },
          React.createElement('label', null, 'Nota de Desempenho *'),
          React.createElement('select', {
            className: 'form-control',
            value: this.state.desempenho,
            onChange: function(e) { self.setState({ desempenho: e.target.value }); },
            required: true
          },
            DESEMPENHO_OPTIONS.map(function(opt) {
              return React.createElement('option', { key: opt.value, value: opt.value }, opt.label);
            })
          )
        ),

        React.createElement('div', { className: 'form-group' },
          React.createElement('label', null, 'Observações *'),
          React.createElement('textarea', {
            className: 'form-control',
            rows: 6,
            placeholder: PLACEHOLDERS.OBSERVACOES_AVALIADOR,
            value: this.state.observacoesAvaliador,
            onChange: function(e) { self.setState({ observacoesAvaliador: e.target.value }); },
            required: true
          }),
          React.createElement('small', null, this.state.observacoesAvaliador.length + ' caracteres')
        ),

        React.createElement('div', { className: 'form-actions' },
          React.createElement('button', {
            type: 'button',
            className: 'btn btn-secondary',
            onClick: this.handleCancel,
            disabled: this.state.submitting
          }, 'Cancelar'),

          React.createElement('button', {
            type: 'submit',
            className: 'btn btn-primary',
            disabled: this.state.submitting
          }, this.state.submitting ? '⏳ Salvando...' : '💾 Salvar Avaliação')
        )
      )
    );
  }
}

export default PreencherDetalhe;
