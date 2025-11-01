import React from 'react';
import Autocomplete from '../components/Autocomplete';
import Modal from '../utils/Modal';
import apiService from '../services/api';
import { AREA_ATUACAO_OPTIONS, PERIODO_DESAFIO_OPTIONS, VALIDATION_MESSAGES, PLACEHOLDERS } from '../constants/formConstants';
import { MESSAGES } from '../constants/apiConstants';

class NovaAvaliacao extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      funcionario: null,
      dataAvaliacao: '',
      periodoDesafio: '',
      areaAtuacao: '',
      observacoes: '',
      submitting: false,
      showModal: false,
      modalType: 'success',
      modalMessage: ''
    };
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleSubmit(e) {
    e.preventDefault();
    var self = this;

    if (!this.state.funcionario) {
      alert(VALIDATION_MESSAGES.FUNCIONARIO_OBRIGATORIO);
      return;
    }

    if (!this.state.dataAvaliacao || !this.state.periodoDesafio || !this.state.areaAtuacao) {
      alert(VALIDATION_MESSAGES.DATA_OBRIGATORIA);
      return;
    }

    this.setState({ submitting: true });

    var payload = {
      funcionarioId: this.state.funcionario.id,
      dataAvaliacao: this.state.dataAvaliacao,
      periodoDesafio: parseInt(this.state.periodoDesafio),
      areaAtuacao: parseInt(this.state.areaAtuacao),
      observacoesGerais: this.state.observacoes || '',
      avaliacaoDetalhes: [
        { tipoAvaliador: 1, nomeAvaliador: '', observacoesAvaliador: '', desempenho: null },
        { tipoAvaliador: 2, nomeAvaliador: '', observacoesAvaliador: '', desempenho: null },
        { tipoAvaliador: 3, nomeAvaliador: '', observacoesAvaliador: '', desempenho: null }
      ]
    };

    apiService.createAvaliacaoCompleta(payload)
      .then(function(response) {
        self.setState({
          showModal: true,
          modalType: 'success',
          modalMessage: MESSAGES.EMAIL_ENVIADO,
          submitting: false
        });

        setTimeout(function() {
          self.setState({
            funcionario: null,
            dataAvaliacao: '',
            periodoDesafio: '',
            areaAtuacao: '',
            observacoes: '',
            showModal: false
          });
          self.props.onNavigate('minhas-avaliacoes-rh');
        }, 2000);
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

  render() {
    var self = this;

    return React.createElement('div', { className: 'nova-avaliacao-container' },
      React.createElement('h1', { className: 'page-title' }, '➕ Nova Avaliação'),
      React.createElement('p', { className: 'page-subtitle' },
        'Crie uma nova avaliação e os 3 detalhes (TechLead, Gerente, RH) serão enviados automaticamente'
      ),

      React.createElement(Modal, {
        isOpen: this.state.showModal,
        onClose: function() { self.setState({ showModal: false }); },
        title: this.state.modalType === 'success' ? '✅ Sucesso!' : '❌ Erro',
        message: this.state.modalMessage,
        type: this.state.modalType,
        autoClose: 2500
      }),

      React.createElement('form', {
        className: 'form-avaliacao',
        onSubmit: this.handleSubmit
      },
        React.createElement('div', { className: 'form-group' },
          React.createElement('label', null, 'Funcionário *'),
          React.createElement(Autocomplete, {
            placeholder: PLACEHOLDERS.FUNCIONARIO,
            onSelect: function(user) { self.setState({ funcionario: user }); },
            selectedUser: this.state.funcionario
          })
        ),

        React.createElement('div', { className: 'form-row' },
          React.createElement('div', { className: 'form-group' },
            React.createElement('label', null, 'Data da Avaliação *'),
            React.createElement('input', {
              type: 'datetime-local',
              className: 'form-control',
              value: this.state.dataAvaliacao,
              onChange: function(e) { self.setState({ dataAvaliacao: e.target.value }); },
              required: true
            })
          ),

          React.createElement('div', { className: 'form-group' },
            React.createElement('label', null, 'Período *'),
            React.createElement('select', {
              className: 'form-control',
              value: this.state.periodoDesafio,
              onChange: function(e) { self.setState({ periodoDesafio: e.target.value }); },
              required: true
            },
              PERIODO_DESAFIO_OPTIONS.map(function(opt) {
                return React.createElement('option', { key: opt.value, value: opt.value }, opt.label);
              })
            )
          )
        ),

        React.createElement('div', { className: 'form-group' },
          React.createElement('label', null, 'Área de Atuação *'),
          React.createElement('select', {
            className: 'form-control',
            value: this.state.areaAtuacao,
            onChange: function(e) { self.setState({ areaAtuacao: e.target.value }); },
            required: true
          },
            AREA_ATUACAO_OPTIONS.map(function(opt) {
              return React.createElement('option', { key: opt.value, value: opt.value }, opt.label);
            })
          )
        ),

        React.createElement('div', { className: 'form-group' },
          React.createElement('label', null, 'Observações Gerais'),
          React.createElement('textarea', {
            className: 'form-control',
            rows: 4,
            placeholder: PLACEHOLDERS.OBSERVACOES_GERAIS,
            value: this.state.observacoes,
            onChange: function(e) { self.setState({ observacoes: e.target.value }); }
          })
        ),

        React.createElement('div', { className: 'form-actions' },
          React.createElement('button', {
            type: 'button',
            className: 'btn btn-secondary',
            onClick: function() { self.props.onNavigate('dashboard'); },
            disabled: this.state.submitting
          }, 'Cancelar'),

          React.createElement('button', {
            type: 'submit',
            className: 'btn btn-primary',
            disabled: this.state.submitting
          }, this.state.submitting ? '⏳ Criando...' : '✅ Criar Avaliação')
        )
      )
    );
  }
}

export default NovaAvaliacao;
