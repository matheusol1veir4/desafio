import React, { useState } from 'react';
import { searchAvaliacoes, getAvaliacaoCompletaById } from '../services/avaliacaoService';
import AvaliacaoCard from '../components/AvaliacaoCard';

const BuscarAvaliacoes = () => {
  const [filters, setFilters] = useState({
    nome: '',
    email: '',
    area: '',
    periodo: ''
  });
  const [avaliacoes, setAvaliacoes] = useState([]);
  const [loading, setLoading] = useState(false);
  const [message, setMessage] = useState({ text: '', type: '' });

  // ============================================
  // FUNÇÃO: Converter período de dias para código
  // ============================================
  const convertPeriodoParaCodigo = (dias) => {
    if (!dias) return undefined;

    const conversion = {
      '30': 1,
      '60': 2,
      '90': 3
    };

    return conversion[dias] || undefined;
  };

  // ============================================
  // FUNÇÃO: Atualizar filtros
  // ============================================
  const handleChange = (e) => {
    const { id, value } = e.target;
    setFilters(prev => ({
      ...prev,
      [id]: value
    }));
  };

  // ============================================
  // FUNÇÃO: Buscar avaliações
  // ============================================
  const handleBuscar = async (e) => {
    e.preventDefault();
    setLoading(true);
    setMessage({ text: '', type: '' });
    setAvaliacoes([]);

    try {
      // Converte o período de dias (30, 60, 90) para código (1, 2, 3)
      const filtrosConvertidos = {
        ...filters,
        periodo: convertPeriodoParaCodigo(filters.periodo)
      };

      const response = await searchAvaliacoes(filtrosConvertidos);
      const listaAvaliacoes = response.items || response || [];

      if (listaAvaliacoes.length === 0) {
        setMessage({
          text: 'Nenhuma avaliacao encontrada com os filtros informados',
          type: 'error'
        });
        return;
      }

      // Busca os detalhes completos para cada avaliação
      const avaliacoesCompletas = await Promise.all(
        listaAvaliacoes.map(av => getAvaliacaoCompletaById(av.avaliacaoId))
      );

      setAvaliacoes(avaliacoesCompletas);
      setMessage({
        text: `Resultados (${avaliacoesCompletas.length})`,
        type: 'success'
      });
    } catch (error) {
      setMessage({
        text: `Erro ao buscar avaliacoes: ${error.message}`,
        type: 'error'
      });
    } finally {
      setLoading(false);
    }
  };

  // ============================================
  // RENDERIZAÇÃO
  // ============================================
  return (
    <div className="buscar-avaliacoes">
      <h2>Buscar e Filtrar Avaliacoes</h2>

      <form onSubmit={handleBuscar}>
        <div className="form-group">
          <label htmlFor="nome">Nome:</label>
          <input
            id="nome"
            type="text"
            placeholder="Digite o nome do funcionário"
            value={filters.nome}
            onChange={handleChange}
          />
        </div>

        <div className="form-group">
          <label htmlFor="email">Email:</label>
          <input
            id="email"
            type="text"
            placeholder="email@empresa.com"
            value={filters.email}
            onChange={handleChange}
          />
        </div>

        <div className="form-group">
          <label htmlFor="area">Area:</label>
          <select id="area" value={filters.area} onChange={handleChange}>
            <option value="">Todas</option>
            <option value="1">Frontend</option>
            <option value="2">Backend</option>
            <option value="3">Fullstack</option>
            <option value="4">QA</option>
            <option value="5">DevOps</option>
          </select>
        </div>

        <div className="form-group">
          <label htmlFor="periodo">Periodo:</label>
          <select id="periodo" value={filters.periodo} onChange={handleChange}>
            <option value="">Todos</option>
            <option value="30">30 DIAS</option>
            <option value="60">60 DIAS</option>
            <option value="90">90 DIAS</option>
          </select>
        </div>

        <button type="submit" disabled={loading}>
          {loading ? 'Buscando...' : 'BUSCAR'}
        </button>
      </form>

      {message.text && (
        <div className={`message ${message.type}`}>
          {message.text}
        </div>
      )}

      <div className="resultados">
        {avaliacoes.map(av => (
          <AvaliacaoCard key={av.avaliacaoId} avaliacao={av} />
        ))}
      </div>
    </div>
  );
};

export default BuscarAvaliacoes;
