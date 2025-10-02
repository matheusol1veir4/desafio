package br.com.example.model.avaliacao.enums;

public enum AreaAtuacaoEnum {
    BACK_END("BackEnd", 5),
    FRONT_END("FrontEnd", 4),
    UI("Regular", 3),
    TESTER("Tester", 2),
    ANALISTA_PROJETO("AnalistaProjeto", 1);

    private final String descricao;
    private final int id;

    AreaAtuacaoEnum(String descricao, int id) {
        this.descricao = descricao;
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getId() {
        return id;
    }

    //validar com o Marc

    /**
     * Converte o valor inteiro do banco para a constante do enum.
     * @param id Valor salvo em banco
     * @return Área de atuação correspondente
     * @throws IllegalArgumentException se o id for inválido
     */
    public static AreaAtuacaoEnum fromId(int id) {
        for (AreaAtuacaoEnum area : values()) {
            if (area.id == id) {
                return area;
            }
        }
        throw new IllegalArgumentException("ID inválido para AreaAtuacaoEnum: " + id);
    }

    /**
     * Converte a descrição recebida de formulários ou APIs para a constante do enum.
     * @param descricao Texto recebido
     * @return Área de atuação correspondente
     * @throws IllegalArgumentException se a descrição for inválida
     */
    public static AreaAtuacaoEnum fromDescricao(String descricao) {
        for (AreaAtuacaoEnum area : values()) {
            if (area.descricao.equalsIgnoreCase(descricao)) {
                return area;
            }
        }
        throw new IllegalArgumentException("Descrição inválida para AreaAtuacaoEnum: " + descricao);
    }


}
