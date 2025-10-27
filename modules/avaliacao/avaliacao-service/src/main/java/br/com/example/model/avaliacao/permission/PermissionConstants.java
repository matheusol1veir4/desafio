package br.com.example.model.avaliacao.permission;

/**
 * Constantes relacionadas a permissões e ROLES DO SISTEMA de avaliação.
 *
 * @author SEA TECNOLOGIA
 */
public class PermissionConstants {

    /** Role de Administrador do sistema */
    public static final String ROLE_ADMINISTRATOR = "Administrator";

    /** Role de RH - Pode criar e editar tudo */
    public static final String ROLE_RH = "Avaliador_RH";

    /** Role de Tech Lead - Pode editar apenas detalhe tipo 1 */
    public static final String ROLE_TECH_LEAD = "Avaliador_TechLead";

    /** Role de Gerente - Pode editar apenas detalhe tipo 2 */
    public static final String ROLE_GERENTE = "Avaliador_Gerente";

    /** Tipo de avaliador: Tech Lead */
    public static final int TIPO_TECH_LEAD = 1;

    /** Tipo de avaliador: Gerente */
    public static final int TIPO_GERENTE = 2;

    /** Tipo de avaliador: RH */
    public static final int TIPO_RH = 3;

    /** Tipo de avaliador: Nenhum/Desconhecido */
    public static final int TIPO_DESCONHECIDO = -1;

    // ============ NOMES DOS TIPOS ============

    /** Nome amigável do tipo Tech Lead */
    public static final String NOME_TECH_LEAD = "Tech Lead";

    /** Nome amigável do tipo Gerente */
    public static final String NOME_GERENTE = "Gerente";

    /** Nome amigável do tipo RH */
    public static final String NOME_RH = "RH";

    /** Nome amigável do tipo Desconhecido */
    public static final String NOME_DESCONHECIDO = "Desconhecido";

    // ============ RESOURCE NAMES (para integração com Liferay) ============

    /** Nome do portlet para permissões */
    public static final String PORTLET_NAME = "com_example_avaliacao_web_AvaliacaoWebPortlet";

    /** Nome do recurso do portlet */
    public static final String PORTLET_RESOURCE_NAME = "br.com.example.model.avaliacao";

    /** Nome do modelo para permissões */
    public static final String MODEL_NAME = "br.com.example.model.avaliacao.model.Avaliacao";

    /**
     * Retorna o nome amigável do tipo de avaliador.
     *
     * @param tipoAvaliador Código do tipo (1, 2, 3 ou -1)
     * @return Nome amigável
     */
    public static String getNomeTipoAvaliador(int tipoAvaliador) {
        switch (tipoAvaliador) {
            case TIPO_TECH_LEAD: return NOME_TECH_LEAD;
            case TIPO_GERENTE: return NOME_GERENTE;
            case TIPO_RH: return NOME_RH;
            default: return NOME_DESCONHECIDO;
        }
    }

    private PermissionConstants() {
        // Classe utilitária - não deve ser instanciada
    }
}
