import React from 'react';

function Modal(props) {
  var isOpen = props.isOpen;
  var onClose = props.onClose;
  var title = props.title;
  var message = props.message;
  var type = props.type || 'info';
  var autoClose = props.autoClose || 0;

  React.useEffect(function() {
    if (isOpen && autoClose > 0) {
      var timer = setTimeout(function() {
        onClose();
      }, autoClose);
      return function() { clearTimeout(timer); };
    }
  }, [isOpen, autoClose, onClose]);

  React.useEffect(function() {
    function handleEsc(e) {
      if (e.keyCode === 27 && isOpen) {
        onClose();
      }
    }
    if (isOpen) {
      document.addEventListener('keydown', handleEsc);
      document.body.style.overflow = 'hidden';
    }
    return function() {
      document.removeEventListener('keydown', handleEsc);
      document.body.style.overflow = 'auto';
    };
  }, [isOpen, onClose]);

  if (!isOpen) return null;

  var icons = { success: '✅', error: '❌', warning: '⚠️', info: 'ℹ️' };

  return React.createElement('div', { className: 'modal-backdrop' },
    React.createElement('div', { className: 'modal-container modal-' + type },
      React.createElement('div', { className: 'modal-header' },
        React.createElement('div', { className: 'modal-icon' }, icons[type]),
        React.createElement('h3', { className: 'modal-title' }, title),
        React.createElement('button', {
          className: 'modal-close-btn',
          onClick: onClose
        }, '×')
      ),
      React.createElement('div', { className: 'modal-body' },
        React.createElement('p', { className: 'modal-message' }, message)
      )
    )
  );
}

export default Modal;