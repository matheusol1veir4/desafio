import React, { useState } from 'react';
import { getAvaliacoesByFuncionario, getAvaliacaoCompletaById } from '../services/avaliacaoService';
import AvaliacaoCard from '../components/AvaliacaoCard';

const ListarAvaliacoes = () => {
    const [funcionarioId, setFuncionarioId] = useState('');
    const [avaliacoes, setAvaliacoes] = useState([]);
    const [loading, setLoading] = useState(false);
    const [message, setMessage] = useState({ text: '', type: '' });

    const handleBuscar = async (e) => {
        e.preventDefault();
        if (!funcionarioId) {
            setMessage({ text: 'Por favor, informe o ID do funcionario', type: 'error' });
            return;
        }

        setLoading(true);
        setMessage({ text: '', type: '' });
        setAvaliacoes([]);

        try {
            const response = await getAvaliacoesByFuncionario(funcionarioId);
            const listaAvaliacoes = response.items || response || [];

            if (listaAvaliacoes.length === 0) {
                setMessage({ text: 'Nenhuma avaliacao encontrada para este funcionario', type: 'error' });
                return;
            }

            const avaliacoesCompletas = await Promise.all(
                listaAvaliacoes.map(av => getAvaliacaoCompletaById(av.avaliacaoId))
            );

            setAvaliacoes(avaliacoesCompletas);
            setMessage({ text: `${avaliacoesCompletas.length} avaliacao(oes) encontrada(s)`, type: 'success' });
        } catch (error) {
            setMessage({ text: `Erro ao buscar avaliacoes: ${error.message}`, type: 'error' });
        } finally {
            setLoading(false);
        }
    };

    return (
        <div className="card">
            <h2>Listar Avaliacoes por Funcionario</h2>

            <form onSubmit={handleBuscar}>
                <div className="form-group">
                    <label htmlFor="listarFuncionarioId">ID do Funcionario</label>
                    <input
                        type="number"
                        id="listarFuncionarioId"
                        placeholder="Ex: 34029"
                        value={funcionarioId}
                        onChange={(e) => setFuncionarioId(e.target.value)}
                    />
                </div>

                <button type="submit" className="btn-primary" disabled={loading}>
                    {loading ? 'Buscando...' : 'Buscar'}
                </button>
            </form>

            {message.text && (
                <div className={`message ${message.type}`}>
                    {message.text}
                </div>
            )}

            <div className="resultado">
                {avaliacoes.length > 0 && (
                    <>
                        <h3>Avaliacoes Encontradas:</h3>
                        {avaliacoes.map(avaliacao => (
                            <AvaliacaoCard key={avaliacao.avaliacaoId} avaliacao={avaliacao} />
                        ))}
                    </>
                )}
            </div>
        </div>
    );
};

export default ListarAvaliacoes;
