import React, { useState } from 'react';
import CriarAvaliacao from './pages/CriarAvaliacao';
import ListarAvaliacoes from './pages/ListarAvaliacoes';
import BuscarAvaliacoes from './pages/BuscarAvaliacoes';
import AvaliacoesPendentes from './components/AvaliacoesPendentes';
import PreencherAvaliacao from './pages/PreencherAvaliacao';

const App = () => {
  const [activeTab, setActiveTab] = useState('criar');
  const [avaliacaoParaPreencher, setAvaliacaoParaPreencher] = useState(null);

  const handlePreencherAvaliacao = (avaliacaoId) => {
    setAvaliacaoParaPreencher(avaliacaoId);
    setActiveTab('preencher');
  };

  const handleVoltarDePreencher = () => {
    setAvaliacaoParaPreencher(null);
    setActiveTab('pendentes');
  };

  return (
    <div className="avaliacao-container">
      <div className="avaliacao-header">
        <h1>Sistema de Avaliação de Desafio</h1>
        <p className="subtitle">Gerenciamento de avaliações 30/60/90 dias</p>
      </div>

      {avaliacaoParaPreencher ? (
        <PreencherAvaliacao
          avaliacaoId={avaliacaoParaPreencher}
          onVoltar={handleVoltarDePreencher}
        />
      ) : (
        <>
          <div className="tabs">
            <button
              className={`tab-button ${activeTab === 'criar' ? 'active' : ''}`}
              onClick={() => setActiveTab('criar')}
            >
              Criar Avaliação
            </button>
            <button
              className={`tab-button ${activeTab === 'pendentes' ? 'active' : ''}`}
              onClick={() => setActiveTab('pendentes')}
            >
              Minhas Pendentes
            </button>
            <button
              className={`tab-button ${activeTab === 'listar' ? 'active' : ''}`}
              onClick={() => setActiveTab('listar')}
            >
              Listar Avaliações
            </button>
            <button
              className={`tab-button ${activeTab === 'buscar' ? 'active' : ''}`}
              onClick={() => setActiveTab('buscar')}
            >
              Buscar Avaliações
            </button>
          </div>

          <div className="tab-content">
            {activeTab === 'criar' && <CriarAvaliacao />}
            {activeTab === 'pendentes' && (
              <AvaliacoesPendentes onPreencherAvaliacao={handlePreencherAvaliacao} />
            )}
            {activeTab === 'listar' && <ListarAvaliacoes />}
            {activeTab === 'buscar' && <BuscarAvaliacoes />}
          </div>
        </>
      )}
    </div>
  );
};

export default App;
