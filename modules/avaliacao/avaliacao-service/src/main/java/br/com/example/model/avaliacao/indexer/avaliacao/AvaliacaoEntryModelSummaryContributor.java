package br.com.example.model.avaliacao.indexer.avaliacao;

import br.com.example.model.avaliacao.indexer.Constants;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import org.osgi.service.component.annotations.Component;
import java.util.Locale;

@Component(
        property = "indexer.class.name=br.com.example.model.avaliacao.model.Avaliacao",
        service = ModelSummaryContributor.class
)
public class AvaliacaoEntryModelSummaryContributor implements ModelSummaryContributor {

    @Override
    public Summary getSummary(Document document, Locale locale, String snippet) {
        Summary summary = createSummary(document);
        summary.setMaxContentLength(150);
        return summary;
    }

    private Summary createSummary(Document document) {
        String prefix = Field.SNIPPET + StringPool.UNDERLINE;
        String title = buildTitle(document);
        String content = getContent(document, prefix);
        return new Summary(title, content);
    }

    private String buildTitle(Document document) {
// MODIFICADO: Usa nome do funcionário se disponível
        String nomeFuncionario = document.get(Constants.NOME_FUNCIONARIO);
        String funcionarioId = document.get(Constants.FUNCIONARIO_ID);
        String periodo = document.get(Constants.PERIODO_DESAFIO);

        StringBuilder title = new StringBuilder("Avaliação - ");

        if (Validator.isNotNull(nomeFuncionario)) {
            title.append(nomeFuncionario);
        } else if (Validator.isNotNull(funcionarioId)) {
            title.append("Funcionário ").append(funcionarioId);
        } else {
            title.append("ID ").append(document.get(Constants.AVALIACAO_ID));
        }

        if (Validator.isNotNull(periodo)) {
            title.append(" (").append(formatPeriodo(periodo)).append(" dias)");
        }

        return title.toString();
    }

    private String getContent(Document document, String prefix) {
        String content = document.get(prefix + Constants.OBSERVACOES_GERAIS);
        if (Validator.isNotNull(content)) {
            return content;
        }

        content = document.get(Constants.OBSERVACOES_GERAIS);
        if (Validator.isNotNull(content)) {
            return content;
        }

        return document.get(Constants.OBSERVACOES_AVALIADORES, "");
    }

    private String formatPeriodo(String periodo) {
        switch (periodo) {
            case "1": return "30";
            case "2": return "60";
            case "3": return "90";
            default: return periodo;
        }
    }

}
