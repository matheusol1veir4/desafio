import React from 'react';
import apiService from '../services/api';

class Autocomplete extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            inputValue: '',
            suggestions: [],
            showSuggestions: false,
            loading: false
        };
        this.debounceTimer = null;
    }

    handleInputChange(e) {
        const value = e.target.value;
        this.setState({ inputValue: value });

        clearTimeout(this.debounceTimer);

        if (value.length >= 2) {
            const self = this;
            this.setState({ loading: true });

            this.debounceTimer = setTimeout(function() {
                apiService.searchUsers(value)
                    .then(function(users) {
                        self.setState({
                            suggestions: users,
                            showSuggestions: true,
                            loading: false
                        });
                    })
                    .catch(function(error) {
                        console.error('Erro ao buscar usuários:', error);
                        self.setState({ loading: false });
                    });
            }, 300);
        } else {
            this.setState({ suggestions: [], showSuggestions: false });
        }
    }

    handleSelectSuggestion(user) {
        this.setState({
            inputValue: user.name,
            showSuggestions: false,
            suggestions: []
        });
        this.props.onSelect(user);
    }

    render() {
        const { inputValue, suggestions, showSuggestions, loading } = this.state;
        const self = this;

        return React.createElement(
            'div',
            { className: 'autocomplete' },
            React.createElement('input', {
                type: 'text',
                value: inputValue,
                onChange: this.handleInputChange.bind(this),
                placeholder: 'Digite o nome do funcionário...',
                autoComplete: 'off'
            }),
            loading && React.createElement('div', { className: 'autocomplete-loading' }, 'Buscando...'),
            showSuggestions && suggestions.length > 0 && React.createElement(
                'ul',
                { className: 'autocomplete-suggestions' },
                suggestions.map(function(user) {
                    return React.createElement(
                        'li',
                        {
                            key: user.id,
                            onClick: function() { self.handleSelectSuggestion(user); }
                        },
                        React.createElement('div', { className: 'user-name' }, user.name),
                        React.createElement('div', { className: 'user-email' }, user.email)
                    );
                })
            )
        );
    }
}

export default Autocomplete;
