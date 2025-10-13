package br.com.example.model.avaliacao.indexer.avaliacao;

import br.com.example.model.avaliacao.indexer.Constants;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=br.com.example.model.avaliacao.model.Avaliacao",
        service = KeywordQueryContributor.class
)
public class AvaliacaoKeywordQueryContributor implements KeywordQueryContributor {

    @Override
    public void contribute(
            String keywords, BooleanQuery booleanQuery,
            KeywordQueryContributorHelper keywordQueryContributorHelper) {
        SearchContext searchContext = keywordQueryContributorHelper.getSearchContext();

        queryHelper.addSearchTerm(booleanQuery, searchContext, Constants.AVALIACAO_ID, false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, Constants.FUNCIONARIO_ID, false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, Constants.PERIODO_DESAFIO, false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, Constants.AREA_ATUACAO, false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, Constants.OBSERVACOES_GERAIS, true);
        queryHelper.addSearchTerm(booleanQuery, searchContext, Constants.OBSERVACOES_AVALIADORES, true);
        queryHelper.addSearchTerm(booleanQuery, searchContext, Constants.NOMES_AVALIADORES, true);
        queryHelper.addSearchTerm(booleanQuery, searchContext, Constants.TIPOS_AVALIADORES, false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, Constants.DESEMPENHOS, false);
        queryHelper.addSearchTerm(booleanQuery, searchContext, Constants.NOME_FUNCIONARIO, true);
        queryHelper.addSearchTerm(booleanQuery, searchContext, Constants.EMAIL_FUNCIONARIO, false);
    }

    @Reference
    protected QueryHelper queryHelper;

}
