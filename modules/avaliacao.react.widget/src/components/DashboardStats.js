import React from 'react';

function DashboardStats(props) {
  var stats = [
    { id: 'total', label: 'Total', value: props.total || 0, icon: '📋', cls: 'stat-card-total' },
    { id: 'pend', label: 'Pendentes', value: props.pendentes || 0, icon: '⏳', cls: 'stat-card-pendente' },
    { id: 'and', label: 'Em Andamento', value: props.emAndamento || 0, icon: '📝', cls: 'stat-card-andamento' },
    { id: 'comp', label: 'Completas', value: props.completas || 0, icon: '✅', cls: 'stat-card-completa' }
  ];

  return React.createElement('div', { className: 'dashboard-stats' },
    stats.map(function(s) {
      return React.createElement('div', { key: s.id, className: 'stat-card ' + s.cls },
        React.createElement('div', { className: 'stat-icon' }, s.icon),
        React.createElement('div', { className: 'stat-content' },
          React.createElement('div', { className: 'stat-value' }, s.value),
          React.createElement('div', { className: 'stat-label' }, s.label)
        )
      );
    })
  );
}

export default DashboardStats;