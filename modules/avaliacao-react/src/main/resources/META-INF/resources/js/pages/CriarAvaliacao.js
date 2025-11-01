import React, { useState } from 'react';
import { buscarFuncionarios } from '../services/avaliacaoService';

const CriarAvaliacao = () => {
  const [formData, setFormData] = useState({
    funcionarioId: '',
    periodoDesafio: '',
    areaAtuacao: '',
    observacoesGerais: ''
  });

  // Estados para busca de funcionários
  const [funcionarioSearch, setFuncionarioSearch] = useState('');
  const [funcionarioOptions, setFuncionarioOptions] = useState([]);
  const [showFuncionarioDropdown, setShowFuncionarioDropdown] = useState(false);
  const [loadingFuncionarios, setLoadingFuncionarios] = useState(false);
  const [funcionarioSelecionado, setFuncionarioSelecionado] = useState(null);

  const [message, setMessage] = useState({ text: '', type: '' });
  const [loading, setLoading] = useState(false);

  // Função para buscar funcionários
  const handleFuncionarioSearch = async (searchTerm) => {
    setFuncionarioSearch(searchTerm);
    if (searchTerm.length < 2) {
      setFuncionarioOptions([]);
      setShowFuncionarioDropdown(false);
      return;
    }

    setLoadingFuncionarios(true);
    try {
      const funcionarios = await buscarFuncionarios(searchTerm);
      setFuncionarioOptions(funcionarios);
      setShowFuncionarioDropdown(true);
    } catch (error) {
      console.error('Erro ao buscar funcionários:', error);
      setFuncionarioOptions([]);
    } finally {
      setLoadingFuncionarios(false);
    }
  };

  const handleSelectFuncionario = (funcionario) => {
    setFormData(prev => ({ ...prev, funcionarioId: funcionario.funcionarioId }));
    setFuncionarioSelecionado(funcionario);
    setFuncionarioSearch(funcionario.nome);
    setShowFuncionarioDropdown(false);
  };

  const handleClearFuncionario = () => {
    setFormData(prev => ({ ...prev, funcionarioId: '' }));
    setFuncionarioSelecionado(null);
    setFuncionarioSearch('');
    setFuncionarioOptions([]);
  };

  const handleChange = (e) => {
    const { id, value } = e.target;
    setFormData(prev => ({ ...prev, [id]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    setMessage({ text: '', type: '' });

    try {
      // Payload simplificado - backend cria os 3 detalhes vazios
      const payload = {
        funcionarioId: parseInt(formData.funcionarioId),
        dataAvaliacao: new Date().toISOString(),
        periodoDesafio: parseInt(formData.periodoDesafio),
        observacoesGerais: formData.observacoesGerais || '',
        areaAtuacao: parseInt(formData.areaAtuacao)
      };

      const response = await fetch('/o/avaliacao-headless/v1.0/avaliacoes/completa', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Accept': 'application/json',
          'x-csrf-token': typeof Liferay !== 'undefined' && Liferay.authToken ? Liferay.authToken : ''
        },
        credentials: 'include',
        body: JSON.stringify(payload)
      });

      if (!response.ok) {
        throw new Error(`Erro ${response.status}: ${await response.text()}`);
      }

      const result = await response.json();
      setMessage({
        text: `Avaliação criada com sucesso! ID: ${result.avaliacaoId}. Emails enviados para os avaliadores.`,
        type: 'success'
      });

      // Limpar formulário
      setFormData({
        funcionarioId: '',
        periodoDesafio: '',
        areaAtuacao: '',
        observacoesGerais: ''
      });
      handleClearFuncionario();

    } catch (error) {
      setMessage({ text: `Erro ao criar avaliação: ${error.message}`, type: 'error' });
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="criar-avaliacao-container">
      <h2>Criar Nova Avaliação</h2>
      <p className="subtitle">RH cria a avaliação inicial. Sistema enviará emails para Tech Lead, Gerente e RH preencherem suas partes.</p>

      {message.text && (
        <div className={`message ${message.type}`}>
          {message.text}
        </div>
      )}

      <form onSubmit={handleSubmit}>
        <fieldset>
          <legend>Dados do Funcionário</legend>

          {/* Autocomplete de Funcionário */}
          <div className="form-group autocomplete-wrapper">
            <label htmlFor="funcionario">Funcionário *</label>
            <input
              type="text"
              value={funcionarioSearch}
              onChange={(e) => handleFuncionarioSearch(e.target.value)}
              onFocus={() => funcionarioOptions.length > 0 && setShowFuncionarioDropdown(true)}
              placeholder="Digite o nome do funcionário..."
              required
              disabled={funcionarioSelecionado !== null}
            />

            {funcionarioSelecionado && (
              <button
                type="button"
                onClick={handleClearFuncionario}
                className="clear-button"
              >
                ✕
              </button>
            )}

            {loadingFuncionarios && <div className="loading-spinner">Buscando...</div>}

            {showFuncionarioDropdown && funcionarioOptions.length > 0 && (
              <ul className="autocomplete-dropdown">
                {funcionarioOptions.map(funcionario => (
                  <li
                    key={funcionario.funcionarioId}
                    onClick={() => handleSelectFuncionario(funcionario)}
                  >
                    <strong>{funcionario.nome}</strong>
                    <small>{funcionario.email}</small>
                  </li>
                ))}
              </ul>
            )}
          </div>

          <div className="form-row">
            <div className="form-group">
              <label htmlFor="periodoDesafio">Período do Desafio *</label>
              <select
                id="periodoDesafio"
                value={formData.periodoDesafio}
                onChange={handleChange}
                required
              >
                <option value="">Selecione...</option>
                <option value="30">30 dias</option>
                <option value="60">60 dias</option>
                <option value="90">90 dias</option>
              </select>
            </div>

            <div className="form-group">
              <label htmlFor="areaAtuacao">Área de Atuação *</label>
              <select
                id="areaAtuacao"
                value={formData.areaAtuacao}
                onChange={handleChange}
                required
              >
                <option value="">Selecione...</option>
                <option value="5">Backend</option>
                <option value="4">Frontend</option>
                <option value="3">UI/UX</option>
                <option value="2">Tester</option>
                <option value="1">Analista Projeto</option>
              </select>
            </div>
          </div>

          <div className="form-group">
            <label htmlFor="observacoesGerais">Observações Gerais</label>
            <textarea
              id="observacoesGerais"
              value={formData.observacoesGerais}
              onChange={handleChange}
              rows="3"
              placeholder="Observações sobre o funcionário e o período de avaliação..."
            />
          </div>
        </fieldset>

        <div className="form-actions">
          <button
            type="submit"
            disabled={loading || !formData.funcionarioId}
          >
            {loading ? 'Criando...' : 'Criar Avaliação e Notificar Avaliadores'}
          </button>
        </div>
      </form>
    </div>
  );
};

export default CriarAvaliacao;
