package br.com.example.model.avaliacao.service.search;

import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;

/**
 * Helper com métodos auxiliares para busca de avaliações.
 * Contém validações, conversões e mapeamentos.
 */
@Component(service = AvaliacaoSearchHelper.class)
public class AvaliacaoSearchHelper {

    /**
     * Valida se pelo menos um filtro foi fornecido.
     */
    public boolean hasAnyFilter(
            String nome, String email, String data,
            Integer area, Integer periodo) {

        return Validator.isNotNull(nome) ||
                Validator.isNotNull(email) ||
                Validator.isNotNull(data) ||
                area != null ||
                periodo != null;
    }

    /**
     * Normaliza email removendo espaços e convertendo para lowercase.
     */
    public String normalizeEmail(String email) {
        if (Validator.isNull(email)) {
            return null;
        }
        return email.trim().toLowerCase();
    }

    /**
     * Valida formato de data (yyyy-MM-dd).
     */
    public boolean isValidDateFormat(String data) {
        if (Validator.isNull(data)) {
            return true; // null é válido (sem filtro)
        }
        return data.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    /**
     * Valida valores de área de atuação.
     */
    public boolean isValidArea(Integer area) {
        if (area == null) {
            return true;
        }
        // 1=Analista, 2=Tester, 3=Designer, 4=Frontend, 5=Backend
        return area >= 1 && area <= 5;
    }

    /**
     * Valida valores de período de desafio.
     */
    public boolean isValidPeriodo(Integer periodo) {
        if (periodo == null) {
            return true;
        }
        // 1=30 dias, 2=60 dias, 3=90 dias
        return periodo >= 1 && periodo <= 3;
    }

}
