package com.thehotel;

import java.util.ArrayList;
import java.util.List;

// Classe base Pessoa
abstract class Pessoa {
    protected int id;
    protected String nome;

    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}