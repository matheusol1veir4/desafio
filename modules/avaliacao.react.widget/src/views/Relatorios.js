import React from 'react';
import LoadingSpinner from '../components/LoadingSpinner';
import apiService from '../services/api';

class Relatorios extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      avaliacoes: [],
      loading: true,
      error: null,
      filtroStatus: 'todos'
    };
    this.handleFiltro = this.handleFiltro.bind(this);
  }

  componentDidMount() {
    this.loadRelatorios();
  }

  loadRelatorios() {
    var self = this;
    self.setState({ loading: true, error: null });

    apiService.getAllAvaliacoes()
      .then(function(avaliacoes) {
        self.setState({
          avaliacoes: avaliacoes,
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

  handleFiltro(status) {
    this.setState({ filtroStatus: status });
  }

  getAvaliacoesFiltradas() {
    var filtro = this.state.filtroStatus;

    if (filtro === 'todos') {
      return this.state.avaliacoes;
    }

    return this.state.avaliacoes.filter(function(a) {
      return a.status === filtro;
    });
  }

  calcularEstatisticas() {
    var avaliacoes = this.state.avaliacoes;

    return {
      total: avaliacoes.length,
      pendentes: avaliacoes.filter(function(a) { return a.status === 'PENDENTE'; }).length,
      emAndamento: avaliacoes.filter(function(a) { return a.status === 'EM_ANDAMENTO'; }).length,
      completas: avaliacoes.filter(function(a) { return a.status === 'COMPLETA'; }).length,
      percentualCompleta: Math.round((avaliacoes.filter(function(a) { return a.status === 'COMPLETA'; }).length / (avaliacoes.length || 1)) * 100)
    };
  }

  render() {
    var self = this;

    if (this.state.loading) {
      return React.createElement(LoadingSpinner, { fullScreen: true });
    }

    if (this.state.error) {
      return React.createElement('div', { className: 'error-container' },
        React.createElement('p', null, '❌ ' + this.state.error),
        React.createElement('button', {
          className: 'btn btn-primary',
          onClick: function() { self.loadRelatorios(); }
        }, 'Tentar Novamente')
      );
    }

    var stats = this.calcularEstatisticas();
    var filtradas = this.getAvaliacoesFiltradas();

    return React.createElement('div', { className: 'relatorios-container' },
      React.createElement('h1', { className: 'page-title' }, '📈 Relatórios'),
      React.createElement('p', { className: 'page-subtitle' }, 'Visualize estatísticas e relatórios de avaliações'),

      // Estatísticas
      React.createElement('div', { className: 'stats-section' },
        React.createElement('h2', null, 'Resumo Geral'),
        React.createElement('div', { className: 'stats-grid' },
          React.createElement('div', { className: 'stat-item' },
            React.createElement('div', { className: 'stat-value' }, stats.total),
            React.createElement('div', { className: 'stat-label' }, 'Total de Avaliações')
          ),
          React.createElement('div', { className: 'stat-item' },
            React.createElement('div', { className: 'stat-value' }, stats.completas),
            React.createElement('div', { className: 'stat-label' }, 'Completas')
          ),
          React.createElement('div', { className: 'stat-item' },
            React.createElement('div', { className: 'stat-value' }, stats.emAndamento),
            React.createElement('div', { className: 'stat-label' }, 'Em Andamento')
          ),
          React.createElement('div', { className: 'stat-item' },
            React.createElement('div', { className: 'stat-value' }, stats.pendentes),
            React.createElement('div', { className: 'stat-label' }, 'Pendentes')
          )
        ),
        React.createElement('div', { className: 'progress-bar-section' },
          React.createElement('label', null, 'Taxa de Conclusão'),
          React.createElement('div', { className: 'progress-bar' },
            React.createElement('div', {
              className: 'progress-fill',
              style: { width: stats.percentualCompleta + '%' }
            })
          ),
          React.createElement('span', null, stats.percentualCompleta + '%')
        )
      ),

      // Filtros
      React.createElement('div', { className: 'filtros-section' },
        React.createElement('h2', null, 'Filtrar por Status'),
        React.createElement('div', { className: 'filter-buttons' },
          React.createElement('button', {
            className: 'btn ' + (this.state.filtroStatus === 'todos' ? 'btn-primary' : 'btn-secondary'),
            onClick: function() { self.handleFiltro('todos'); }
          }, 'Todas'),
          React.createElement('button', {
            className: 'btn ' + (this.state.filtroStatus === 'PENDENTE' ? 'btn-primary' : 'btn-secondary'),
            onClick: function() { self.handleFiltro('PENDENTE'); }
          }, 'Pendentes'),
          React.createElement('button', {
            className: 'btn ' + (this.state.filtroStatus === 'EM_ANDAMENTO' ? 'btn-primary' : 'btn-secondary'),
            onClick: function() { self.handleFiltro('EM_ANDAMENTO'); }
          }, 'Em Andamento'),
          React.createElement('button', {
            className: 'btn ' + (this.state.filtroStatus === 'COMPLETA' ? 'btn-primary' : 'btn-secondary'),
            onClick: function() { self.handleFiltro('COMPLETA'); }
          }, 'Completas')
        )
      ),

      // Tabela de Avaliações
      React.createElement('div', { className: 'tabela-section' },
        React.createElement('h2', null, 'Avaliações (' + filtradas.length + ')'),
        filtradas.length === 0 ?
          React.createElement('p', { className: 'empty-message' }, 'Nenhuma avaliação encontrada com este filtro') :
          React.createElement('table', { className: 'relatorios-table' },
            React.createElement('thead', null,
              React.createElement('tr', null,
                React.createElement('th', null, 'ID'),
                React.createElement('th', null, 'Funcionário'),
                React.createElement('th', null, 'Período'),
                React.createElement('th', null, 'Status'),
                React.createElement('th', null, 'Data')
              )
            ),
            React.createElement('tbody', null,
              filtradas.map(function(avaliacao) {
                return React.createElement('tr', { key: avaliacao.avaliacaoId },
                  React.createElement('td', null, '#' + avaliacao.avaliacaoId),
                  React.createElement('td', null, avaliacao.funcionarioNome || 'ID ' + avaliacao.funcionarioId),
                  React.createElement('td', null, avaliacao.periodoDesafio + ' dias'),
                  React.createElement('td', null,
                    React.createElement('span', { className: 'badge badge-' + (avaliacao.status || 'PENDENTE').toLowerCase() },
                      avaliacao.status || 'PENDENTE'
                    )
                  ),
                  React.createElement('td', null,
                    avaliacao.dataAvaliacao ? new Date(avaliacao.dataAvaliacao).toLocaleDateString('pt-BR') : 'N/A'
                  )
                );
              })
            )
          )
      )
    );
  }
}

export default Relatorios;
