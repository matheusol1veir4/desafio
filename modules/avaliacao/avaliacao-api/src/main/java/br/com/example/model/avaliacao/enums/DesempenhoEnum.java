package br.com.example.model.avaliacao.enums;

public enum DesempenhoEnum {
    OTIMO("Ótimo", 5),
    BOM("Bom", 4),
    REGULAR("Regular", 3),
    RUIM("Ruim", 2),
    PESSIMO("Péssimo", 1);

    private final String descricao;

    private final int id;

    DesempenhoEnum(String descricao, int id) {
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
     * Converte um valor inteiro do banco para a constante enum correspondente.
     * @param id valor armazenado no banco
     * @return constante DesempenhoEnum correspondente
     * @throws IllegalArgumentException se o id for inválido
     */
    public static DesempenhoEnum fromId(int id) {
        for (DesempenhoEnum e : values()) {
            if (e.id == id) {
                return e;
            }
        }
        throw new IllegalArgumentException("ID inválido para DesempenhoEnum: " + id);
    }

    /**
     * Converte uma descrição legível para a constante enum correspondente.
     * @param descricao texto recebido de formulários ou APIs
     * @return constante DesempenhoEnum correspondente
     * @throws IllegalArgumentException se a descrição for inválida
     */
    public static DesempenhoEnum fromDescricao(String descricao) {
        for (DesempenhoEnum e : values()) {
            if (e.descricao.equalsIgnoreCase(descricao)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Descrição inválida para DesempenhoEnum: " + descricao);
    }


}