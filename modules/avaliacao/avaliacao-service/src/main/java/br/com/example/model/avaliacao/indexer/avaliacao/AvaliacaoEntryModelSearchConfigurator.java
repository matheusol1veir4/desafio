package br.com.example.model.avaliacao.indexer.avaliacao;

import br.com.example.model.avaliacao.indexer.Constants;
import br.com.example.model.avaliacao.model.Avaliacao;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchConfigurator;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = ModelSearchConfigurator.class)
public class AvaliacaoEntryModelSearchConfigurator implements ModelSearchConfigurator<Avaliacao> {

    @Override
    public String getClassName() {
        return Avaliacao.class.getName();
    }

    @Override
    public String[] getDefaultSelectedFieldNames() {
        return new String[] {
                Field.COMPANY_ID, Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK,
                Field.SCOPE_GROUP_ID, Field.GROUP_ID, Field.UID,
                Constants.AVALIACAO_ID, Constants.FUNCIONARIO_ID,
                Constants.PERIODO_DESAFIO, Constants.AREA_ATUACAO,
                Constants.NOME_FUNCIONARIO, Constants.EMAIL_FUNCIONARIO
        };
    }

    @Override
    public String[] getDefaultSelectedLocalizedFieldNames() {
        return new String[] {Field.CONTENT, Field.TITLE};
    }

    @Override
    public ModelIndexerWriterContributor<Avaliacao> getModelIndexerWriterContributor() {
        return modelIndexWriterContributor;
    }

    @Override
    public ModelSummaryContributor getModelSummaryContributor() {
        return modelSummaryContributor;
    }

    @Override
    public boolean isSelectAllLocales() {
        return true;
    }

    @Reference(target = "(indexer.class.name=br.com.example.model.avaliacao.model.Avaliacao)")
    protected ModelIndexerWriterContributor<Avaliacao> modelIndexWriterContributor;

    @Reference(target = "(indexer.class.name=br.com.example.model.avaliacao.model.Avaliacao)")
    protected ModelSummaryContributor modelSummaryContributor;

}
