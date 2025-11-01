import React, { useState, useEffect } from 'react';
import { getAvaliacaoCompletaById, updateAvaliacaoDetalhe } from '../services/avaliacaoService';

const PreencherAvaliacao = ({ avaliacaoId, onVoltar }) => {
  const [avaliacao, setAvaliacao] = useState(null);
  const [meuDetalhe, setMeuDetalhe] = useState(null);
  const [loading, setLoading] = useState(true);
  const [saving, setSaving] = useState(false);
  const [message, setMessage] = useState({ text: '', type: '' });

  const [formData, setFormData] = useState({
    nomeAvaliador: '',
    observacoesAvaliador: '',
    desempenho: ''
  });

  useEffect(() => {
    carregarAvaliacao();
  }, [avaliacaoId]);

  const carregarAvaliacao = async () => {
    try {
      setLoading(true);
      const data = await getAvaliacaoCompletaById(avaliacaoId);
      setAvaliacao(data);

      // Identificar qual detalhe pertence ao usuário logado
      // Aqui assumimos que o backend já filtra pelo tipo correto
      // Encontrar o detalhe com desempenho = 0 (pendente)
      const detalhePendente = data.avaliacaoDetalhes?.find(d => d.desempenho === 0);

      if (detalhePendente) {
        setMeuDetalhe(detalhePendente);
        setFormData({
          nomeAvaliador: detalhePendente.nomeAvaliador || '',
          observacoesAvaliador: detalhePendente.observacoesAvaliador || '',
          desempenho: detalhePendente.desempenho || ''
        });
      }
    } catch (error) {
      setMessage({ text: `Erro ao carregar avaliação: ${error.message}`, type: 'error' });
    } finally {
      setLoading(false);
    }
  };

  const handleChange = (e) => {
    const { id, value } = e.target;
    setFormData(prev => ({ ...prev, [id]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setSaving(true);
    setMessage({ text: '', type: '' });

    try {
      const payload = {
        nomeAvaliador: formData.nomeAvaliador,
        observacoesAvaliador: formData.observacoesAvaliador,
        desempenho: parseInt(formData.desempenho)
      };

      await updateAvaliacaoDetalhe(meuDetalhe.avaliacaoDetalheId, payload);

      setMessage({
        text: 'Avaliação preenchida com sucesso!',
        type: 'success'
      });

      // Aguardar 2 segundos e voltar
      setTimeout(() => {
        if (onVoltar) onVoltar();
      }, 2000);

    } catch (error) {
      setMessage({ text: `Erro ao salvar: ${error.message}`, type: 'error' });
    } finally {
      setSaving(false);
    }
  };

  const obterNomeTipoAvaliador = (tipo) => {
    const tipos = { 1: 'Tech Lead', 2: 'Gerente', 3: 'RH' };
    return tipos[tipo] || 'Desconhecido';
  };

  const obterNomePeriodo = (periodo) => {
    const periodos = { 30: '30 dias', 60: '60 dias', 90: '90 dias' };
    return periodos[periodo] || `${periodo} dias`;
  };

  const obterNomeArea = (area) => {
    const areas = { 1: 'Analista Projeto', 2: 'Tester', 3: 'UI/UX', 4: 'Frontend', 5: 'Backend' };
    return areas[area] || 'Não especificada';
  };

  if (loading) {
    return (
      <div className="loading-container">
        <div className="spinner"></div>
        <p>Carregando avaliação...</p>
      </div>
    );
  }

  if (!avaliacao || !meuDetalhe) {
    return (
      <div className="error-container">
        <h3>Erro</h3>
        <p>Não foi possível carregar a avaliação ou você não tem permissão para preenchê-la.</p>
        <button onClick={onVoltar} className="btn-secondary">Voltar</button>
      </div>
    );
  }

  return (
    <div className="preencher-avaliacao-container">
      <div className="header">
        <button onClick={onVoltar} className="btn-back">← Voltar</button>
        <h2>Preencher Avaliação</h2>
      </div>

      {message.text && (
        <div className={`message ${message.type}`}>
          {message.text}
        </div>
      )}

      {/* Informações da Avaliação (somente leitura) */}
      <div className="avaliacao-info">
        <h3>Informações da Avaliação</h3>
        <div className="info-grid">
          <div className="info-item">
            <span className="label">Funcionário ID:</span>
            <span className="value">{avaliacao.funcionarioId}</span>
          </div>
          <div className="info-item">
            <span className="label">Período:</span>
            <span className="value">{obterNomePeriodo(avaliacao.periodoDesafio)}</span>
          </div>
          <div className="info-item">
            <span className="label">Área:</span>
            <span className="value">{obterNomeArea(avaliacao.areaAtuacao)}</span>
          </div>
          <div className="info-item">
            <span className="label">Tipo de Avaliação:</span>
            <span className="value tipo-badge">{obterNomeTipoAvaliador(meuDetalhe.tipoAvaliador)}</span>
          </div>
        </div>

        {avaliacao.observacoesGerais && (
          <div className="observacoes-gerais">
            <strong>Observações Gerais (RH):</strong>
            <p>{avaliacao.observacoesGerais}</p>
          </div>
        )}
      </div>

      {/* Formulário de Preenchimento */}
      <form onSubmit={handleSubmit} className="form-preenchimento">
        <fieldset>
          <legend>Sua Avaliação - {obterNomeTipoAvaliador(meuDetalhe.tipoAvaliador)}</legend>

          <div className="form-group">
            <label htmlFor="nomeAvaliador">Seu Nome *</label>
            <input
              type="text"
              id="nomeAvaliador"
              value={formData.nomeAvaliador}
              onChange={handleChange}
              placeholder="Digite seu nome completo"
              required
            />
          </div>

          <div className="form-group">
            <label htmlFor="observacoesAvaliador">Observações sobre o Desempenho *</label>
            <textarea
              id="observacoesAvaliador"
              value={formData.observacoesAvaliador}
              onChange={handleChange}
              rows="5"
              placeholder="Descreva o desempenho do funcionário durante este período..."
              required
            />
          </div>

          <div className="form-group">
            <label htmlFor="desempenho">Avaliação de Desempenho *</label>
            <select
              id="desempenho"
              value={formData.desempenho}
              onChange={handleChange}
              required
            >
              <option value="">Selecione...</option>
              <option value="1">1 - Insatisfatório</option>
              <option value="2">2 - Abaixo da expectativa</option>
              <option value="3">3 - Adequado</option>
              <option value="4">4 - Acima da expectativa</option>
              <option value="5">5 - Excepcional</option>
            </select>
          </div>
        </fieldset>

        <div className="form-actions">
          <button type="button" onClick={onVoltar} className="btn-secondary" disabled={saving}>
            Cancelar
          </button>
          <button type="submit" className="btn-primary" disabled={saving}>
            {saving ? 'Salvando...' : 'Enviar Avaliação'}
          </button>
        </div>
      </form>
    </div>
  );
};

export default PreencherAvaliacao;
