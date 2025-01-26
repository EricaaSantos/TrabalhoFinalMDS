package com.thehotel;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private List<Quarto> quartos;
    private List<Reserva> reservas;
    private List<Manutencao> manutencoes;
    private Gestor gestor;
    private Funcionario funcionario;

    @BeforeEach
    void setUp() {
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();
        manutencoes = new ArrayList<>();
        gestor = new Gestor(1, "Gestor");
        funcionario = new Funcionario(2, "Funcionário");
    }

    @Test
    void testCriarQuarto() {
        Main.criarQuarto(InputHelper.createScanner("101\n2\n"), quartos);
        assertEquals(1, quartos.size());
        assertEquals(101, quartos.get(0).getNumero());
        assertEquals(2, quartos.get(0).getCapacidadeMaxima());
    }

    @Test
    void testEditarQuarto() {
        Quarto quarto = new Quarto(101, 2);
        quartos.add(quarto);
        Main.editarQuarto(InputHelper.createScanner("101\n3\n"), quartos);
        assertEquals(3, quartos.get(0).getCapacidadeMaxima());
    }

    @Test
    void testRemoverQuarto() {
        Quarto quarto = new Quarto(101, 2);
        quartos.add(quarto);
        Main.removerQuarto(InputHelper.createScanner("101\n"), quartos);
        assertTrue(quartos.isEmpty());
    }

    @Test
    void testRegistrarQuartoOcupado() {
        Quarto quarto = new Quarto(101, 2);
        quartos.add(quarto);
        Main.registrarQuartoOcupado(InputHelper.createScanner("101\n"), quartos);
        assertTrue(quartos.get(0).isOcupado());
    }

    @Test
    void testRegistrarManutencao() {
        Quarto quarto = new Quarto(101, 2);
        quartos.add(quarto);
        Main.registrarManutencao(InputHelper.createScanner("101\n1\nTrocar lâmpada\n"), quartos, manutencoes);
        assertEquals(1, manutencoes.size());
        assertEquals("Trocar lâmpada", manutencoes.get(0).getDescricao());
    }

    @Test
    void testFazerReserva() {
        Quarto quarto = new Quarto(101, 2);
        quartos.add(quarto);
        Main.fazerReserva(InputHelper.createScanner("Carlos\n2023-01-01\n2023-01-03\n2\n101\n"), reservas, quartos);
        assertEquals(1, reservas.size()); // Verificar se a reserva foi criada
        assertEquals("Carlos", reservas.get(0).getHospede().getNome());
        assertTrue(quartos.get(0).isOcupado()); // Verificar se o quarto foi marcado como ocupado
    }
    

    @Test
    void testConfirmarReserva() {
        Hospede hospede = new Hospede(1, "Carlos");
        Reserva reserva = new Reserva(1, "2023-01-01", "2023-01-03", hospede);
        reservas.add(reserva);
        Main.confirmarReserva(InputHelper.createScanner("1\n"), reservas);
        assertEquals("Confirmada", reservas.get(0).getEstado());
    }

    @Test
    void testMarcarManutencaoRealizada() {
        Quarto quarto = new Quarto(101, 2);
        Manutencao manutencao = new Manutencao(1, "Trocar lâmpada", quarto);
        manutencoes.add(manutencao);
        Main.marcarManutencaoRealizada(InputHelper.createScanner("1\n"), manutencoes);
        assertTrue(manutencoes.isEmpty());
    }

    @Test
    void testExtensaoVoltarMenu() {
        Quarto quarto = new Quarto(101, 2);
        quartos.add(quarto);
        reservas.add(new Reserva(1, "2023-01-01", "2023-01-03", new Hospede(1, "Carlos")));

        Scanner mockScannerGestor = InputHelper.createScanner("7\n");
        Main.menuGestor(mockScannerGestor, gestor, quartos, manutencoes);
        assertEquals(1, quartos.size());

        Scanner mockScannerFuncionario = InputHelper.createScanner("5\n");
        Main.menuFuncionario(mockScannerFuncionario, funcionario, quartos, reservas, manutencoes);
        assertEquals(1, reservas.size());
    }

    public static class InputHelper {
        public static Scanner createScanner(String input) {
            ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
            return new Scanner(in);
        }
    }
}
