package com.thehotel;

class Manutencao {
    private int id;
    private String descricao;
    private Quarto quarto;

    public Manutencao(int id, String descricao, Quarto quarto) {
        this.id = id;
        this.descricao = descricao;
        this.quarto = quarto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }
}
