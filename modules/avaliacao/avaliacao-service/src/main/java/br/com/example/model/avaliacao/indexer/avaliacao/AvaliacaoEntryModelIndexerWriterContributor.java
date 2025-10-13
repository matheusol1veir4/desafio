package br.com.example.model.avaliacao.indexer.avaliacao;

import br.com.example.model.avaliacao.model.Avaliacao;
import br.com.example.model.avaliacao.service.AvaliacaoLocalService;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        property = "indexer.class.name=br.com.example.model.avaliacao.model.Avaliacao",
        service = ModelIndexerWriterContributor.class
)
public class AvaliacaoEntryModelIndexerWriterContributor
        implements ModelIndexerWriterContributor<Avaliacao> {

    @Override
    public void customize(
            BatchIndexingActionable batchIndexingActionable,
            ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
        batchIndexingActionable.setPerformActionMethod(
                (Avaliacao avaliacao) -> batchIndexingActionable.addDocuments(
                        modelIndexerWriterDocumentHelper.getDocument(avaliacao)));
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory.
                getBatchIndexingActionable(
                        _avaliacaoLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(Avaliacao baseModel) {
        return baseModel.getCompanyId();
    }

    @Reference
    protected DynamicQueryBatchIndexingActionableFactory
            dynamicQueryBatchIndexingActionableFactory;

    @Reference
    protected AvaliacaoLocalService _avaliacaoLocalService;

}
