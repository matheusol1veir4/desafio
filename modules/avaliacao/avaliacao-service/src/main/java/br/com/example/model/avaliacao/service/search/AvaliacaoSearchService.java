package br.com.example.model.avaliacao.service.search;

import br.com.example.model.avaliacao.model.Avaliacao;
import br.com.example.model.avaliacao.service.AvaliacaoLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Serviço de busca e filtragem de avaliações.
 * Realiza busca manual com múltiplos critérios e validação de dados do funcionário.
 */
@Component(service = AvaliacaoSearchService.class)
public class AvaliacaoSearchService {

    private static final Log _log = LogFactoryUtil.getLog(AvaliacaoSearchService.class);

    /**
     * Busca avaliações aplicando múltiplos filtros e retorna resultado paginado.
     *
     * @param nome nome do funcionário para busca parcial (case-insensitive)
     * @param email email do funcionário para busca parcial (case-insensitive)
     * @param data data da avaliação no formato yyyy-MM-dd
     * @param area código da área de atuação (1-5)
     * @param periodo código do período de desafio (1-3)
     * @param companyId ID da empresa para filtro de contexto
     * @param start índice inicial para paginação
     * @param end índice final para paginação
     * @return SearchResult contendo lista paginada e total de registros
     * @throws Exception se houver erro na busca ou validação
     */
    public SearchResult searchAvaliacoes(
            String nome,
            String email,
            String data,  // ← CORRIGIDO: String, não Date
            Integer area,
            Integer periodo,
            long companyId,
            int start,
            int end
    ) throws Exception {
        _log.info("=== INÍCIO BUSCA AVALIAÇÕES ===");
        _log.info("Parâmetros recebidos:");
        _log.info(" - nome: " + nome);
        _log.info(" - email: " + email);
        _log.info(" - data: " + data);
        _log.info(" - area: " + area);
        _log.info(" - periodo: " + periodo);
        _log.info(" - companyId: " + companyId);
        _log.info(" - start: " + start + ", end: " + end);

        // Busca TODAS as avaliações
        List<Avaliacao> todasAvaliacoes = _avaliacaoLocalService.getAvaliacaos(0, Integer.MAX_VALUE);
        _log.info("Total de avaliações no banco: " + todasAvaliacoes.size());

        // Filtrar manualmente por companyId E critérios
        List<Avaliacao> filtradas = new ArrayList<>();
        int rejeitadasCompany = 0;
        int rejeitadasCriterios = 0;

        for (Avaliacao avaliacao : todasAvaliacoes) {
            // Filtro por companyId
            if (avaliacao.getCompanyId() != companyId) {
                rejeitadasCompany++;
                continue;
            }

            boolean match = _matchesCriteria(avaliacao, nome, email, data, area, periodo);
            if (!match) {
                rejeitadasCriterios++;
                continue;
            }

            filtradas.add(avaliacao);
            _log.info("Avaliação aceita: ID=" + avaliacao.getAvaliacaoId());
        }

        _log.info("Resultado da filtragem:");
        _log.info(" - Rejeitadas por companyId: " + rejeitadasCompany);
        _log.info(" - Rejeitadas por critérios: " + rejeitadasCriterios);
        _log.info(" - Total filtradas: " + filtradas.size());

        // Paginação
        int total = filtradas.size();
        int fromIndex = Math.max(0, Math.min(start, total));
        int toIndex = Math.min(end, total);
        if (toIndex < fromIndex) {
            toIndex = fromIndex;
        }

        List<Avaliacao> paginadas = (fromIndex < total) ?
                filtradas.subList(fromIndex, toIndex) :
                new ArrayList<>();

        _log.info("Paginação: retornando " + paginadas.size() + " de " + total);
        _log.info("=== FIM BUSCA AVALIAÇÕES ===");

        return new SearchResult(paginadas, total);
    }

    /**
     * Verifica se uma avaliação corresponde aos critérios de busca especificados.
     *
     * @param avaliacao entidade a ser verificada
     * @param nome critério de nome do funcionário
     * @param email critério de email do funcionário
     * @param data critério de data da avaliação
     * @param area critério de área de atuação
     * @param periodo critério de período de desafio
     * @return true se a avaliação atende todos os critérios não nulos
     */
    private boolean _matchesCriteria(
            Avaliacao avaliacao,
            String nome,
            String email,
            String data,
            Integer area,
            Integer periodo
    ) {
        long avaliacaoId = avaliacao.getAvaliacaoId();
        _log.info(">>> Analisando avaliação ID=" + avaliacaoId);
        _log.info(" - areaAtuacao=" + avaliacao.getAreaAtuacao());
        _log.info(" - periodoDesafio=" + avaliacao.getPeriodoDesafio());
        _log.info(" - funcionarioId=" + avaliacao.getFuncionarioId());

        // Filtro por área
        if (area != null) {
            if (avaliacao.getAreaAtuacao() != area) {
                _log.info(" ❌ Rejeitada por área. Esperado: " + area + ", Real: " + avaliacao.getAreaAtuacao());
                return false;
            }
            _log.info(" ✅ Passou no filtro de área");
        }

        // Filtro por período - CORRIGIDO: Converte código para dias
        if (periodo != null) {
            int periodoEmDias = convertCodigoParaDias(periodo);
            _log.info(" 🔄 Convertendo período: código " + periodo + " → " + periodoEmDias + " dias");  // ← ADICIONE ESTA LINHA
            _log.info(" 🔍 Comparando: periodoDesafio do banco=" + avaliacao.getPeriodoDesafio() + " vs filtro=" + periodoEmDias);  // ← ADICIONE ESTA LINHA
            if (avaliacao.getPeriodoDesafio() != periodoEmDias) {
                _log.info(" ❌ Rejeitada por período. Esperado: " + periodo + " (" + periodoEmDias + " dias), Real: " + avaliacao.getPeriodoDesafio());
                return false;
            }
            _log.info(" ✅ Passou no filtro de período");
        }

        // Filtro por data
        if (Validator.isNotNull(data)) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date dataFiltro = sdf.parse(data);
                String dataAvaliacao = sdf.format(avaliacao.getDataAvaliacao());
                String dataFiltroStr = sdf.format(dataFiltro);
                if (!dataAvaliacao.equals(dataFiltroStr)) {
                    _log.info(" ❌ Rejeitada por data. Esperado: " + dataFiltroStr + ", Real: " + dataAvaliacao);
                    return false;
                }
                _log.info(" ✅ Passou no filtro de data");
            } catch (ParseException e) {
                _log.warn(" Erro ao parse data: " + data, e);
                return false;
            }
        }

        // Filtro por nome ou email
        if (Validator.isNotNull(nome) || Validator.isNotNull(email)) {
            try {
                User user = _userLocalService.getUser(avaliacao.getFuncionarioId());
                _log.info(" User encontrado: " + user.getFullName() + " <" + user.getEmailAddress() + ">");

                if (Validator.isNotNull(nome)) {
                    String nomeCompleto = user.getFullName().toLowerCase();
                    String nomeBusca = nome.toLowerCase();
                    boolean match = nomeCompleto.contains(nomeBusca);
                    _log.info(" Filtro nome: '" + nomeBusca + "' contains em '" + nomeCompleto + "' = " + match);
                    if (!match) {
                        _log.info(" ❌ Rejeitada por nome");
                        return false;
                    }
                    _log.info(" ✅ Passou no filtro de nome");
                }

                if (Validator.isNotNull(email)) {
                    String emailUser = user.getEmailAddress().toLowerCase();
                    String emailBusca = email.toLowerCase();
                    boolean match = emailUser.contains(emailBusca);
                    _log.info(" Filtro email: '" + emailBusca + "' contains em '" + emailUser + "' = " + match);
                    if (!match) {
                        _log.info(" ❌ Rejeitada por email");
                        return false;
                    }
                    _log.info(" ✅ Passou no filtro de email");
                }

            } catch (Exception e) {
                _log.warn(" ERRO: User não encontrado para funcionarioId=" + avaliacao.getFuncionarioId(), e);
                return false;
            }
        }

        _log.info(" ✅✅✅ Avaliação ACEITA!");
        return true;
    }

    /**
     * Converte código de período da API para dias correspondentes no banco.
     *
     * @param codigoPeriodo código do período (1, 2 ou 3)
     * @return dias correspondentes (30, 60 ou 90)
     */
    private int convertCodigoParaDias(int codigoPeriodo) {
        switch (codigoPeriodo) {
            case 1: return 30;  // 30 dias
            case 2: return 60;  // 60 dias
            case 3: return 90;  // 90 dias
            default:
                _log.warn("Código de período inválido: " + codigoPeriodo);
                return codigoPeriodo; // fallback
        }
    }

    /**
     * Encapsula o resultado de uma busca paginada com contagem total.
     */
    public static class SearchResult {
        private final List<Avaliacao> items;
        private final int totalCount;

        /**
         * Constrói um resultado de busca.
         *
         * @param items lista de avaliações da página atual
         * @param totalCount total de registros encontrados (sem paginação)
         */
        public SearchResult(List<Avaliacao> items, int totalCount) {
            this.items = items;
            this.totalCount = totalCount;
        }

        /**
         * Retorna a lista de avaliações da página atual.
         *
         * @return lista de avaliações
         */
        public List<Avaliacao> getItems() {
            return items;
        }

        /**
         * Retorna o total de registros encontrados.
         *
         * @return contagem total de avaliações
         */
        public int getTotalCount() {
            return totalCount;
        }
    }

    @Reference
    private AvaliacaoLocalService _avaliacaoLocalService;

    @Reference
    private UserLocalService _userLocalService;
}
