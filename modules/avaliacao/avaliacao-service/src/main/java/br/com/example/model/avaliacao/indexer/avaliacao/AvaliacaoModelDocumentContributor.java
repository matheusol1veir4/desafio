package br.com.example.model.avaliacao.indexer.avaliacao;

import br.com.example.model.avaliacao.indexer.Constants;
import br.com.example.model.avaliacao.model.Avaliacao;
import br.com.example.model.avaliacao.model.AvaliacaoDetalhe;
import br.com.example.model.avaliacao.service.AvaliacaoDetalheLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(
        immediate = true,
        property = "indexer.class.name=br.com.example.model.avaliacao.model.Avaliacao",
        service = ModelDocumentContributor.class
)
public class AvaliacaoModelDocumentContributor implements ModelDocumentContributor<Avaliacao> {

    @Override
    public void contribute(Document document, Avaliacao avaliacao) {
        if (avaliacao == null) return;

// Campos principais da avaliação
        document.addKeyword(Constants.AVALIACAO_ID, avaliacao.getAvaliacaoId());
        document.addKeyword(Constants.FUNCIONARIO_ID, avaliacao.getFuncionarioId());
        document.addKeyword(Constants.PERIODO_DESAFIO, avaliacao.getPeriodoDesafio());
        document.addKeyword(Constants.AREA_ATUACAO, avaliacao.getAreaAtuacao());
        document.addDate(Constants.DATA_AVALIACAO, avaliacao.getDataAvaliacao());
        document.addText(Constants.OBSERVACOES_GERAIS, avaliacao.getObservacoesGerais());

// Indexar dados do funcionário
        _contributeUserFields(document, avaliacao.getFuncionarioId());

// Campos agregados dos detalhes
        List<AvaliacaoDetalhe> detalhes = _avaliacaoDetalheLocalService.findByAvaliacaoId(avaliacao.getAvaliacaoId());
        StringBuilder observacoes = new StringBuilder();
        StringBuilder nomes = new StringBuilder();
        StringBuilder tipos = new StringBuilder();
        StringBuilder desempenhos = new StringBuilder();

        for (AvaliacaoDetalhe detalhe : detalhes) {
            if (Validator.isNotNull(detalhe.getObservacoesAvaliador())) {
                observacoes.append(detalhe.getObservacoesAvaliador()).append(" ");
            }
            if (Validator.isNotNull(detalhe.getNomeAvaliador())) {
                nomes.append(detalhe.getNomeAvaliador()).append(" ");
            }
            tipos.append(detalhe.getTipoAvaliador()).append(" ");
            desempenhos.append(detalhe.getDesempenho()).append(" ");
        }
        document.addText(Constants.OBSERVACOES_AVALIADORES, observacoes.toString().trim());
        document.addText(Constants.NOMES_AVALIADORES, nomes.toString().trim());
        document.addText(Constants.TIPOS_AVALIADORES, tipos.toString().trim());
        document.addText(Constants.DESEMPENHOS, desempenhos.toString().trim());
    }

    // Método para indexar dados do User
    private void _contributeUserFields(Document document, long funcionarioId) {
        try {
            User user = _userLocalService.getUser(funcionarioId);
            document.addText(Constants.NOME_FUNCIONARIO, user.getFullName());
            document.addKeyword(Constants.EMAIL_FUNCIONARIO, user.getEmailAddress());
        } catch (PortalException e) {
            if (_log.isDebugEnabled()) {
                _log.debug("User não encontrado para funcionarioId: " + funcionarioId, e);
            }
        }
    }

    private static final Log _log = LogFactoryUtil.getLog(AvaliacaoModelDocumentContributor.class);

    @Reference
    private AvaliacaoDetalheLocalService _avaliacaoDetalheLocalService;

    @Reference
    private UserLocalService _userLocalService;

}
