package br.com.example.model.avaliacao.enums;

public enum TipoAvaliadorEnum {

    TECH_LEAD("Tech-Lead", 1),
    GERENTE("Gerente", 2),
    RH("RH", 3);

    private final String descricao;

    private final int id;

    TipoAvaliadorEnum(String descricao, int id) {
        this.descricao = descricao;
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getId() {
        return id;
    }

    /**
     * Converte um valor inteiro para a constante enum correspondente.
     * @param id valor armazenado no banco
     * @return constante TipoAvaliadorEnum correspondente
     * @throws IllegalArgumentException se o id for inválido
     */
    public static TipoAvaliadorEnum fromId(int id) {
        for (TipoAvaliadorEnum tipo : values()) {
            if (tipo.id == id) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("ID inválido para TipoAvaliadorEnum: " + id);
    }

    /**
     * Converte uma descrição para a constante enum correspondente.
     * @param descricao texto recebido
     * @return constante TipoAvaliadorEnum correspondente
     * @throws IllegalArgumentException se a descrição for inválida
     */
    public static TipoAvaliadorEnum fromDescricao(String descricao) {
        for (TipoAvaliadorEnum tipo : values()) {
            if (tipo.descricao.equalsIgnoreCase(descricao)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Descrição inválida para TipoAvaliadorEnum: " + descricao);
    }

}
