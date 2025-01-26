package com.thehotel;

import java.util.List;

// Classe Gestor
class Gestor extends Pessoa {
    public Gestor(int id, String nome) {
        super(id, nome);
    }

    public Quarto criarQuarto(int numero, int capacidadeMaxima) {
        return new Quarto(numero, capacidadeMaxima);
    }

    public void editarQuarto(Quarto quarto, int novaCapacidade) {
        quarto.setCapacidadeMaxima(novaCapacidade);
    }

    public void removerQuarto(List<Quarto> quartos, Quarto quarto) {
        quartos.remove(quarto);
    }
}