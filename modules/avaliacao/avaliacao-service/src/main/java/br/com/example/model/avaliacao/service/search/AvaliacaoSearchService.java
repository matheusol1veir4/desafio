package br.com.example.model.avaliacao.service.search;

import br.com.example.model.avaliacao.indexer.Constants;
import br.com.example.model.avaliacao.model.Avaliacao;
import br.com.example.model.avaliacao.service.AvaliacaoLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service de busca para Avaliacao - Liferay 7.4 compatível.
 */
@Component(service = AvaliacaoSearchService.class)
public class AvaliacaoSearchService {

    private static final Log _log = LogFactoryUtil.getLog(AvaliacaoSearchService.class);

    public Page<Avaliacao> searchAvaliacoes(
            String nome,
            String email,
            String data,
            Integer area,
            Integer periodo,
            long companyId,
            Pagination pagination
    ) throws Exception {

        SearchContext searchContext = _createSearchContext(
                nome, email, data, area, periodo, companyId, pagination
        );

        Indexer<Avaliacao> indexer = IndexerRegistryUtil.nullSafeGetIndexer(Avaliacao.class);
        Hits hits = indexer.search(searchContext);

        List<Avaliacao> results = _convertHitsToAvaliacoes(hits);

        return Page.of(results, pagination, hits.getLength());
    }

    private SearchContext _createSearchContext(
            String nome, String email, String data,
            Integer area, Integer periodo,
            long companyId, Pagination pagination
    ) {
        SearchContext searchContext = new SearchContext();
        searchContext.setCompanyId(companyId);
        searchContext.setStart(pagination.getStartPosition());
        searchContext.setEnd(pagination.getEndPosition());

        Map<String, Serializable> attributes = new HashMap<>();

        if (Validator.isNotNull(nome)) {
            attributes.put(Constants.NOME_FUNCIONARIO, nome.toLowerCase());
        }
        if (Validator.isNotNull(email)) {
            attributes.put(Constants.EMAIL_FUNCIONARIO, email.toLowerCase());
        }
        if (Validator.isNotNull(data)) {
            attributes.put(Constants.DATA_AVALIACAO, data);
        }
        if (area != null) {
            attributes.put(Constants.AREA_ATUACAO, area);
        }
        if (periodo != null) {
            attributes.put(Constants.PERIODO_DESAFIO, periodo);
        }

        searchContext.setAttributes(attributes);

        return searchContext;
    }

    private List<Avaliacao> _convertHitsToAvaliacoes(Hits hits) {
        List<Avaliacao> avaliacoes = new ArrayList<>();

        for (Document document : hits.getDocs()) {
            try {
                long avaliacaoId = GetterUtil.getLong(document.get(Constants.AVALIACAO_ID));
                Avaliacao avaliacao = _avaliacaoLocalService.getAvaliacao(avaliacaoId);
                avaliacoes.add(avaliacao);
            } catch (Exception e) {
                _log.debug("Erro ao converter documento para Avaliacao", e);
            }
        }

        return avaliacoes;
    }

    @Reference
    private AvaliacaoLocalService _avaliacaoLocalService;

}
