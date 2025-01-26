package com.thehotel;

import java.util.ArrayList;
import java.util.List;

// Classe Quarto
class Quarto {
    private int numero;
    private int capacidadeMaxima;
    private boolean ocupado;
    private List<Manutencao> manutencoes;

    public Quarto(int numero, int capacidadeMaxima) {
        this.numero = numero;
        this.capacidadeMaxima = capacidadeMaxima;
        this.ocupado = false;
        this.manutencoes = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public void adicionarManutencao(Manutencao manutencao) {
        manutencoes.add(manutencao);
    }

    public List<Manutencao> getManutencoes() {
        return manutencoes;
    }
}

// Classe Manutencao
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

    public String getDescricao() {
        return descricao;
    }

    public Quarto getQuarto() {
        return quarto;
    }
} 
