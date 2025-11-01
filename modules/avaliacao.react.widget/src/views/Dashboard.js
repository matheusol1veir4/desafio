import React from 'react';
import DashboardStats from '../components/DashboardStats';
import LoadingSpinner from '../components/LoadingSpinner';
import apiService from '../services/api';

class Dashboard extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      stats: {
        total: 0,
        pendentes: 0,
        emAndamento: 0,
        completas: 0
      },
      avaliacoes: [],
      loading: true,
      error: null
    };
  }

  componentDidMount() {
    this.loadDashboardData();
  }

  loadDashboardData() {
    var self = this;
    self.setState({ loading: true, error: null });

    apiService.getAllAvaliacoes()
      .then(function(avaliacoes) {
        var stats = self.calcularStats(avaliacoes);
        self.setState({
          avaliacoes: avaliacoes,
          stats: stats,
          loading: false
        });
      })
      .catch(function(error) {
        console.error('Erro ao carregar dashboard:', error);
        self.setState({
          loading: false,
          error: error.message
        });
      });
  }

  calcularStats(avaliacoes) {
    var total = avaliacoes.length;
    var pendentes = avaliacoes.filter(function(a) {
      return a.status === 'PENDENTE';
    }).length;
    var emAndamento = avaliacoes.filter(function(a) {
      return a.status === 'EM_ANDAMENTO';
    }).length;
    var completas = avaliacoes.filter(function(a) {
      return a.status === 'COMPLETA';
    }).length;

    return {
      total: total,
      pendentes: pendentes,
      emAndamento: emAndamento,
      completas: completas
    };
  }

  render() {
    var self = this;

    if (this.state.loading) {
      return React.createElement(LoadingSpinner, { fullScreen: true });
    }

    if (this.state.error) {
      return React.createElement('div', { className: 'error-container' },
        React.createElement('p', { className: 'error-message' }, '❌ ' + this.state.error),
        React.createElement('button', {
          className: 'btn btn-primary',
          onClick: function() { self.loadDashboardData(); }
        }, 'Tentar Novamente')
      );
    }

    return React.createElement('div', { className: 'dashboard-container' },
      React.createElement('h1', { className: 'page-title' }, '📊 Dashboard'),
      React.createElement('p', { className: 'page-subtitle' },
        'Visão geral do sistema de avaliações'
      ),

      React.createElement(DashboardStats, {
        total: this.state.stats.total,
        pendentes: this.state.stats.pendentes,
        emAndamento: this.state.stats.emAndamento,
        completas: this.state.stats.completas
      }),

      React.createElement('div', { className: 'dashboard-content' },
        React.createElement('h2', null, 'Avaliações Recentes'),
        this.state.avaliacoes.length === 0 ?
          React.createElement('p', { className: 'empty-message' },
            'Nenhuma avaliação encontrada'
          ) :
          React.createElement('div', { className: 'dashboard-list' },
            this.state.avaliacoes.slice(0, 5).map(function(avaliacao) {
              return React.createElement('div', {
                key: avaliacao.avaliacaoId,
                className: 'dashboard-item'
              },
                React.createElement('span', null, 'Avaliação #' + avaliacao.avaliacaoId),
                React.createElement('span', { className: 'status-badge' },
                  avaliacao.status || 'PENDENTE'
                )
              );
            })
          )
      )
    );
  }
}

export default Dashboard;
