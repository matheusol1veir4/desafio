package br.com.example.model.avaliacao.enums;

public enum PeriodoDesafioEnum {

    DIAS_30("Desafio 30 dias", 30),
    DIAS_60("Desafio 60 dias", 60),
    DIAS_90("Desafio 90 dias", 90);

    private final String descricao;
    private final int id;

    PeriodoDesafioEnum(String descricao, int id) {
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

    public static PeriodoDesafioEnum fromId(int id) {
        for (PeriodoDesafioEnum periodo : values()) {
            if (periodo.id == id) {
                return periodo;
            }
        }
        throw new IllegalArgumentException("ID inválido para PeriodoDesafioEnum: " + id);
    }

    public static PeriodoDesafioEnum fromDescricao(String descricao) {
        for (PeriodoDesafioEnum periodo : values()) {
            if (periodo.descricao.equalsIgnoreCase(descricao)) {
                return periodo;
            }
        }
        throw new IllegalArgumentException("Descrição inválida para PeriodoDesafioEnum: " + descricao);
    }
}
