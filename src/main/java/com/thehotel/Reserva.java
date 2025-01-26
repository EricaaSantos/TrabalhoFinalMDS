package com.thehotel;

import java.util.ArrayList;
import java.util.List;

class Reserva {
    private int id;
    private String dataEntrada;
    private String dataSaida;
    private String estado;
    private Hospede hospede;
    private List<Quarto> listaQuartos;

    public Reserva(int id, String dataEntrada, String dataSaida, Hospede hospede) {
        this.id = id;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.estado = "Pendente";
        this.hospede = hospede;
        this.listaQuartos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public List<Quarto> getListaQuartos() {
        return listaQuartos;
    }

    public void adicionarQuarto(Quarto quarto) {
        listaQuartos.add(quarto);
    }

    public void removerQuarto(Quarto quarto) {
        listaQuartos.remove(quarto);
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Reserva [id=" + id + ", dataEntrada=" + dataEntrada + ", dataSaida=" + dataSaida + ", estado=" + estado +
                ", hospede=" + hospede.getNome() + ", quartos=" + listaQuartos.size() + "]";
    }
}
 
