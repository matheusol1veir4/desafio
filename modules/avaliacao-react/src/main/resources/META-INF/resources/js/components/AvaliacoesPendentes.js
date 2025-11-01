import React, { useState, useEffect } from 'react';
import { buscarAvaliacoesPendentes } from '../services/avaliacaoService';

const AvaliacoesPendentes = ({ onPreencherAvaliacao }) => {
  const [avaliacoes, setAvaliacoes] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    carregarAvaliacoesPendentes();
  }, []);

  const carregarAvaliacoesPendentes = async () => {
    try {
      setLoading(true);
      setError(null);

      console.log('🔍 Chamando buscarAvaliacoesPendentes...');
      const data = await buscarAvaliacoesPendentes();

      console.log('✅ Resposta do backend:', data);
      console.log('📊 Número de avaliações:', data.length);

      setAvaliacoes(data);
    } catch (err) {
      console.error('❌ Erro ao carregar avaliações pendentes:', err);
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  const obterNomePeriodo = (periodo) => {
    const periodos = {
      30: '30 dias',
      60: '60 dias',
      90: '90 dias'
    };
    return periodos[periodo] || `${periodo} dias`;
  };

  const obterNomeArea = (area) => {
    const areas = {
      1: 'Analista Projeto',
      2: 'Tester',
      3: 'UI/UX',
      4: 'Frontend',
      5: 'Backend'
    };
    return areas[area] || 'Não especificada';
  };

  const obterNomeTipoAvaliador = (tipo) => {
    const tipos = {
      1: 'Tech Lead',
      2: 'Gerente',
      3: 'RH'
    };
    return tipos[tipo] || 'Desconhecido';
  };

  const formatarData = (dataString) => {
    if (!dataString) return 'N/A';
    const data = new Date(dataString);
    return data.toLocaleDateString('pt-BR');
  };

  const contarDetalhesPendentes = (avaliacaoDetalhes) => {
    if (!avaliacaoDetalhes) return 0;
    return avaliacaoDetalhes.filter(d => d.desempenho === 0).length;
  };

  const obterMeuTipoAvaliador = (avaliacaoDetalhes) => {
    if (!avaliacaoDetalhes) return null;
    const pendente = avaliacaoDetalhes.find(d => d.desempenho === 0);
    return pendente ? pendente.tipoAvaliador : null;
  };

  if (loading) {
    return (
      <div className="loading-container">
        <div className="spinner"></div>
        <p>Carregando avaliações pendentes...</p>
      </div>
    );
  }

  if (error) {
    return (
      <div className="error-container">
        <h3>Erro ao carregar pendências</h3>
        <p>{error}</p>
        <button onClick={carregarAvaliacoesPendentes} className="btn-retry">
          Tentar Novamente
        </button>
      </div>
    );
  }

  if (avaliacoes.length === 0) {
    return (
      <div className="empty-state">
        <div className="empty-icon">✓</div>
        <h3>Nenhuma Avaliação Pendente</h3>
        <p>Você não possui avaliações aguardando preenchimento no momento.</p>
      </div>
    );
  }

  return (
    <div className="avaliacoes-pendentes-container">
      <div className="pendentes-header">
        <h2>Minhas Avaliações Pendentes</h2>
        <p className="subtitle">
          Você tem <strong>{avaliacoes.length}</strong> {avaliacoes.length === 1 ? 'avaliação' : 'avaliações'} aguardando preenchimento
        </p>
      </div>

      <div className="avaliacoes-grid">
        {avaliacoes.map(avaliacao => {
          const pendentes = contarDetalhesPendentes(avaliacao.avaliacaoDetalhes);
          const meuTipo = obterMeuTipoAvaliador(avaliacao.avaliacaoDetalhes);

          return (
            <div key={avaliacao.avaliacaoId} className="avaliacao-card pendente">
              <div className="card-header">
                <div className="card-title">
                  <span className="badge badge-pendente">Pendente</span>
                  <h3>Avaliação #{avaliacao.avaliacaoId}</h3>
                </div>
                {meuTipo && (
                  <span className={`badge-tipo tipo-${meuTipo}`}>
                    {obterNomeTipoAvaliador(meuTipo)}
                  </span>
                )}
              </div>

              <div className="card-body">
                <div className="info-row">
                  <span className="label">Funcionário ID:</span>
                  <span className="value">{avaliacao.funcionarioId}</span>
                </div>

                <div className="info-row">
                  <span className="label">Período:</span>
                  <span className="value">{obterNomePeriodo(avaliacao.periodoDesafio)}</span>
                </div>

                <div className="info-row">
                  <span className="label">Área:</span>
                  <span className="value">{obterNomeArea(avaliacao.areaAtuacao)}</span>
                </div>

                <div className="info-row">
                  <span className="label">Data:</span>
                  <span className="value">{formatarData(avaliacao.dataAvaliacao)}</span>
                </div>

                {avaliacao.observacoesGerais && (
                  <div className="observacoes">
                    <span className="label">Observações:</span>
                    <p className="observacoes-text">{avaliacao.observacoesGerais}</p>
                  </div>
                )}

                <div className="detalhes-status">
                  <span className="label">Status dos Detalhes:</span>
                  <div className="detalhes-list">
                    {avaliacao.avaliacaoDetalhes && avaliacao.avaliacaoDetalhes.map(detalhe => (
                      <div
                        key={detalhe.avaliacaoDetalheId}
                        className={`detalhe-item ${detalhe.desempenho === 0 ? 'pendente' : 'preenchido'}`}
                      >
                        <span className="detalhe-tipo">
                          {obterNomeTipoAvaliador(detalhe.tipoAvaliador)}
                        </span>
                        <span className={`detalhe-status ${detalhe.desempenho === 0 ? 'status-pendente' : 'status-ok'}`}>
                          {detalhe.desempenho === 0 ? '⏳ Pendente' : '✓ Preenchido'}
                        </span>
                      </div>
                    ))}
                  </div>
                </div>
              </div>

              <div className="card-footer">
                <button
                  className="btn-primary btn-block"
                  onClick={() => onPreencherAvaliacao(avaliacao.avaliacaoId)}
                >
                  Preencher Minha Avaliação
                </button>
              </div>
            </div>
          );
        })}
      </div>
    </div>
  );
};

export default AvaliacoesPendentes;
