package com.thehotel;

import java.util.ArrayList;
import java.util.List;

public // Classe Hóspede
class Hospede extends Pessoa {
    private List<String> historicoEstadias;

    public Hospede(int id, String nome) {
        super(id, nome);
        this.historicoEstadias = new ArrayList<>();
    }

    public void registrarDados(String estadia) {
        historicoEstadias.add(estadia);
    }

    public List<String> getHistoricoEstadias() {
        return historicoEstadias;
    }
} 

