import React from 'react';
import NavBar from './components/NavBar';
import Dashboard from './views/Dashboard';
import NovaAvaliacao from './views/NovaAvaliacao';
import MinhasAvaliacoesTechLead from './views/MinhasAvaliacoesTechLead';
import MinhasAvaliacoesGerente from './views/MinhasAvaliacoesGerente';
import MinhasAvaliacoesRH from './views/MinhasAvaliacoesRH';
import DetalhesAvaliacao from './views/DetalhesAvaliacao';
import PreencherDetalhe from './views/PreencherDetalhe';
import Relatorios from './views/Relatorios';

/**
 * 📁 src/AppComponent.js
 *
 * Router Central da Aplicação
 * Gerencia navegação entre views
 *
 * MÍNIMAS ALTERAÇÕES do original - apenas adiciona novos cases
 */

export default function AppComponent(props) {
  var [currentView, setCurrentView] = React.useState('dashboard');
  var [user, setUser] = React.useState(null);
  var [userRole, setUserRole] = React.useState('rh');
  var [navigationParams, setNavigationParams] = React.useState({});

  React.useEffect(function() {
    if (typeof Liferay !== 'undefined' && Liferay.ThemeDisplay) {
      var userId = Liferay.ThemeDisplay.getUserId();
      var userName = Liferay.ThemeDisplay.getUserName();

      setUser({
        id: userId,
        name: userName,
        email: Liferay.ThemeDisplay.getUserEmailAddress()
      });

      // Determinar papel do usuário (simplificado - você pode melhorar isso)
      // Por padrão, trata como RH. Você pode adicionar lógica de grupos/roles aqui
      setUserRole('rh');
    }
  }, []);

  function handleNavigate(view, params) {
    setCurrentView(view);
    setNavigationParams(params || {});
    window.scrollTo(0, 0);
  }

  // Renderizar view baseado no currentView
  var viewComponent;

  switch(currentView) {
    case 'dashboard':
      viewComponent = React.createElement(Dashboard, {
        onNavigate: handleNavigate
      });
      break;

    case 'nova-avaliacao':
      viewComponent = React.createElement(NovaAvaliacao, {
        onNavigate: handleNavigate
      });
      break;

    case 'minhas-avaliacoes-techlead':
      viewComponent = React.createElement(MinhasAvaliacoesTechLead, {
        onNavigate: handleNavigate
      });
      break;

    case 'minhas-avaliacoes-gerente':
      viewComponent = React.createElement(MinhasAvaliacoesGerente, {
        onNavigate: handleNavigate
      });
      break;

    case 'minhas-avaliacoes-rh':
      viewComponent = React.createElement(MinhasAvaliacoesRH, {
        onNavigate: handleNavigate
      });
      break;

    case 'detalhes-avaliacao':
      viewComponent = React.createElement(DetalhesAvaliacao, {
        avaliacaoId: navigationParams.avaliacaoId,
        onNavigate: handleNavigate
      });
      break;

    case 'preencher-detalhe':
      viewComponent = React.createElement(PreencherDetalhe, {
        avaliacaoId: navigationParams.avaliacaoId,
        detalheId: navigationParams.detalheId,
        tipoAvaliador: navigationParams.tipoAvaliador,
        detalhe: navigationParams.detalhe,
        onNavigate: handleNavigate
      });
      break;

    case 'relatorios':
      viewComponent = React.createElement(Relatorios, {
        onNavigate: handleNavigate
      });
      break;

    default:
      viewComponent = React.createElement(Dashboard, {
        onNavigate: handleNavigate
      });
  }

  return React.createElement('div', { className: 'app-container' },
    React.createElement(NavBar, {
      currentView: currentView,
      userRole: userRole,
      userName: user ? user.name : 'Usuário',
      onNavigate: handleNavigate
    }),

    React.createElement('main', { className: 'app-main' },
      React.createElement('div', { className: 'app-content' },
        viewComponent
      )
    )
  );
}