import React from 'react';

const AvaliacaoCard = ({ avaliacao }) => {
    const periodoLabel = avaliacao.periodoDesafio === 30 ? '30 dias' :
                        avaliacao.periodoDesafio === 60 ? '60 dias' :
                        avaliacao.periodoDesafio === 90 ? '90 dias' : `${avaliacao.periodoDesafio} dias`;

    const areaLabel = ['', 'Analista', 'Tester', 'UI/UX', 'Front-end', 'Back-end'][avaliacao.areaAtuacao] || 'N/A';

    const formatDate = (dateString) => {
        return new Date(dateString).toLocaleDateString('pt-BR');
    };

    const getTipoAvaliadorLabel = (tipo) => {
        switch(tipo) {
            case 1: return 'Tech Lead';
            case 2: return 'Gerente';
            case 3: return 'RH';
            default: return 'Desconhecido';
        }
    };

    const getTipoClass = (tipo) => {
        switch(tipo) {
            case 1: return 'techlead';
            case 2: return 'gerente';
            case 3: return 'rh';
            default: return '';
        }
    };

    const getDesempenhoLabel = (desempenho) => {
        const labels = ['', 'Insatisfatorio', 'Regular', 'Bom', 'Otimo', 'Excelente'];
        return labels[desempenho] || 'N/A';
    };

    const getDesempenhoClass = (desempenho) => {
        const classes = ['', 'insatisfatorio', 'regular', 'bom', 'otimo', 'excelente'];
        return classes[desempenho] || '';
    };

    return (
        <div className="avaliacao-card">
            <div className="avaliacao-header">
                <div className="avaliacao-id">Avaliacao #{avaliacao.avaliacaoId}</div>
                <div className="periodo-badge">{periodoLabel}</div>
            </div>

            <div className="avaliacao-info">
                <div className="info-item">
                    <span className="info-label">Funcionario ID:</span>
                    <span className="info-value">{avaliacao.funcionarioId}</span>
                </div>
                <div className="info-item">
                    <span className="info-label">Data da Avaliacao:</span>
                    <span className="info-value">{formatDate(avaliacao.dataAvaliacao)}</span>
                </div>
                <div className="info-item">
                    <span className="info-label">Area de Atuacao:</span>
                    <span className="info-value">{areaLabel}</span>
                </div>
                <div className="info-item">
                    <span className="info-label">Observacoes Gerais:</span>
                    <span className="info-value">{avaliacao.observacoesGerais || 'N/A'}</span>
                </div>
            </div>

            {avaliacao.avaliacaoDetalhes && avaliacao.avaliacaoDetalhes.length > 0 && (
                <div className="detalhes-section">
                    <h4>Detalhes das Avaliacoes:</h4>
                    {avaliacao.avaliacaoDetalhes.map((detalhe, index) => (
                        <div key={index} className={`detalhe-card ${getTipoClass(detalhe.tipoAvaliador)}`}>
                            <div className="detalhe-header">
                                <span className="detalhe-tipo">{getTipoAvaliadorLabel(detalhe.tipoAvaliador)}</span>
                                <span className={`detalhe-desempenho ${getDesempenhoClass(detalhe.desempenho)}`}>
                                    {getDesempenhoLabel(detalhe.desempenho)}
                                </span>
                            </div>
                            <p><strong>Avaliador:</strong> {detalhe.nomeAvaliador}</p>
                            <p><strong>Observacoes:</strong> {detalhe.observacoesAvaliador}</p>
                        </div>
                    ))}
                </div>
            )}
        </div>
    );
};

export default AvaliacaoCard;