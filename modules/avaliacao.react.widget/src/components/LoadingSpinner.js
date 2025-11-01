import React from 'react';

function LoadingSpinner(props) {
  var size = props.size || 'medium';
  var message = props.message || 'Carregando...';
  var fullScreen = props.fullScreen || false;
  var className = 'loading-spinner loading-spinner-' + size;
  if (fullScreen) className += ' loading-spinner-fullscreen';

  return React.createElement('div', { className: className },
    React.createElement('div', { className: 'spinner-circle' }),
    message ? React.createElement('p', { className: 'spinner-message' }, message) : null
  );
}

export default LoadingSpinner;