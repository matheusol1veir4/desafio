import React from 'react';

function NavBar(props) {
  var items = {
    rh: [
      { id: 'dash', label: '📊 Dashboard', view: 'dashboard' },
      { id: 'nova', label: '➕ Nova', view: 'nova-avaliacao' },
      { id: 'minhas', label: '📋 Minhas', view: 'minhas-avaliacoes-rh' },
      { id: 'rel', label: '📈 Relatórios', view: 'relatorios' }
    ],
    techlead: [
      { id: 'dash', label: '📊 Dashboard', view: 'dashboard' },
      { id: 'minhas', label: '📋 Minhas', view: 'minhas-avaliacoes-techlead' },
      { id: 'rel', label: '📈 Relatórios', view: 'relatorios' }
    ],
    gerente: [
      { id: 'dash', label: '📊 Dashboard', view: 'dashboard' },
      { id: 'minhas', label: '📋 Minhas', view: 'minhas-avaliacoes-gerente' },
      { id: 'rel', label: '📈 Relatórios', view: 'relatorios' }
    ]
  };
  var menu = items[props.userRole] || items.rh;
  return React.createElement('nav', { className: 'navbar' },
    React.createElement('div', { className: 'navbar-container' },
      React.createElement('div', { className: 'navbar-brand' },
        React.createElement('h1', { className: 'brand-title' }, '🎯 Avaliações')
      ),
      React.createElement('ul', { className: 'navbar-menu' },
        menu.map(function(item) {
          var isActive = props.currentView === item.view;
          return React.createElement('li', { key: item.id, className: 'nav-item' + (isActive ? ' nav-item-active' : '') },
            React.createElement('button', { className: 'nav-link', onClick: function() { props.onNavigate(item.view); } }, item.label)
          );
        })
      ),
      props.userName ? React.createElement('div', { className: 'navbar-user' }, React.createElement('span', null, '👤 ' + props.userName)) : null
    )
  );
}
export default NavBar;