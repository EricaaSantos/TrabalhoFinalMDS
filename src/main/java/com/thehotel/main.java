package com.thehotel;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Quarto> quartos = new ArrayList<>();
        List<Reserva> reservas = new ArrayList<>();
        List<Manutencao> manutencoes = new ArrayList<>();
        Gestor gestor = new Gestor(1, "João Gestor");
        Funcionario funcionario = new Funcionario(2, "Maria Funcionária");

        // Menu interativo
        while (true) {
            try {
                System.out.println("\n--- Menu Principal ---");
                System.out.println("1. Ações do Gestor");
                System.out.println("2. Ações do Funcionário");
                System.out.println("3. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();

                if (opcao == 1) {
                    menuGestor(scanner, gestor, quartos, manutencoes);
                } else if (opcao == 2) {
                    menuFuncionario(scanner, funcionario, quartos, reservas, manutencoes);
                } else if (opcao == 3) {
                    System.out.println("Saindo do sistema...");
                    break;
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine(); // Limpar o buffer
            }
        }

        scanner.close();
    }

    private static void menuGestor(Scanner scanner, Gestor gestor, List<Quarto> quartos, List<Manutencao> manutencoes) {
        System.out.println("\n--- Ações do Gestor ---");
        System.out.println("1. Criar Quarto");
        System.out.println("2. Editar Quarto");
        System.out.println("3. Remover Quarto");
        System.out.println("4. Listar Quartos");
        System.out.println("5. Registrar Quarto Ocupado");
        System.out.println("6. Registrar Necessidade de Manutenção");
        System.out.print("Escolha uma ação: ");

        try {
            int acaoGestor = scanner.nextInt();
            switch (acaoGestor) {
                case 1 -> {
                    System.out.print("Número do quarto: ");
                    int numero = scanner.nextInt();
                    System.out.print("Capacidade máxima do quarto: ");
                    int capacidade = scanner.nextInt();
                    Quarto novoQuarto = new Quarto(numero, capacidade);
                    quartos.add(novoQuarto);
                    System.out.println("Quarto criado com sucesso!");
                }
                case 2 -> {
                    System.out.print("Número do quarto a editar: ");
                    int numero = scanner.nextInt();
                    Quarto quarto = buscarQuarto(quartos, numero);
                    if (quarto != null) {
                        System.out.print("Nova capacidade máxima: ");
                        int capacidade = scanner.nextInt();
                        quarto.setCapacidadeMaxima(capacidade);
                        System.out.println("Capacidade do quarto atualizada com sucesso!");
                    } else {
                        System.out.println("Quarto não encontrado.");
                    }
                }
                case 3 -> {
                    System.out.print("Número do quarto a remover: ");
                    int numero = scanner.nextInt();
                    Quarto quarto = buscarQuarto(quartos, numero);
                    if (quarto != null) {
                        quartos.remove(quarto);
                        System.out.println("Quarto removido com sucesso!");
                    } else {
                        System.out.println("Quarto não encontrado.");
                    }
                }
                case 4 -> {
                    System.out.println("\n--- Lista de Quartos ---");
                    quartos.forEach(q -> System.out.println("ID: " + q.getNumero() + ", Capacidade: " + q.getCapacidadeMaxima()));
                }
                case 5 -> {
                    System.out.print("ID do quarto a registrar como ocupado: ");
                    int numero = scanner.nextInt();
                    Quarto quarto = buscarQuarto(quartos, numero);
                    if (quarto != null) {
                        quarto.setOcupado(true);
                        System.out.println("Quarto registrado como ocupado!");
                    } else {
                        System.out.println("Quarto não encontrado.");
                    }
                }
                case 6 -> {
                    System.out.print("ID do quarto: ");
                    int numero = scanner.nextInt();
                    Quarto quarto = buscarQuarto(quartos, numero);
                    if (quarto != null) {
                        System.out.print("ID da manutenção: ");
                        int idManutencao = scanner.nextInt();
                        System.out.print("Descrição da manutenção: ");
                        scanner.nextLine(); // Limpar o buffer
                        String descricao = scanner.nextLine();
                        Manutencao manutencao = new Manutencao(idManutencao, descricao, quarto);
                        manutencoes.add(manutencao);
                        System.out.println("Manutenção registrada com sucesso!");
                    } else {
                        System.out.println("Quarto não encontrado.");
                    }
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, insira um número.");
            scanner.nextLine(); // Limpar o buffer
        }
    }

    private static void menuFuncionario(Scanner scanner, Funcionario funcionario, List<Quarto> quartos, List<Reserva> reservas, List<Manutencao> manutencoes) {
        System.out.println("\n--- Ações do Funcionário ---");
        System.out.println("1. Fazer Reserva");
        System.out.println("2. Confirmar Reserva");
        System.out.println("3. Registrar Necessidade de Manutenção");
        System.out.println("4. Marcar Manutenção como Realizada");
        System.out.print("Escolha uma ação: ");

        try {
            int acaoFuncionario = scanner.nextInt();
            switch (acaoFuncionario) {
                case 1 -> fazerReserva(scanner, reservas, quartos);
                case 2 -> {
                    System.out.print("ID da reserva a confirmar: ");
                    int idReserva = scanner.nextInt();
                    Reserva reserva = buscarReserva(reservas, idReserva);
                    if (reserva != null) {
                        reserva.setEstado("Confirmada");
                        System.out.println("Reserva confirmada com sucesso!");
                    } else {
                        System.out.println("Reserva não encontrada.");
                    }
                }
                case 3 -> {
                    System.out.print("Número do quarto para manutenção: ");
                    int numero = scanner.nextInt();
                    Quarto quarto = buscarQuarto(quartos, numero);
                    if (quarto != null) {
                        System.out.print("Descrição da manutenção: ");
                        scanner.nextLine(); // Limpar o buffer
                        String descricao = scanner.nextLine();
                        int idManutencao = gerarIdManutencao();
                        Manutencao manutencao = new Manutencao(idManutencao, descricao, quarto);
                        manutencoes.add(manutencao);
                        System.out.println("Manutenção registrada com sucesso!");
                    } else {
                        System.out.println("Quarto não encontrado.");
                    }
                }
                case 4 -> {
                    System.out.print("ID da manutenção realizada: ");
                    int idManutencao = scanner.nextInt();
                    Manutencao manutencao = buscarManutencao(manutencoes, idManutencao);
                    if (manutencao != null) {
                        manutencoes.remove(manutencao);
                        System.out.println("Manutenção marcada como realizada e removida!");
                    } else {
                        System.out.println("Manutenção não encontrada.");
                    }
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, insira um número.");
            scanner.nextLine(); // Limpar o buffer
        }
    }

    private static void fazerReserva(Scanner scanner, List<Reserva> reservas, List<Quarto> quartos) {
        System.out.print("Nome do hóspede: ");
        scanner.nextLine(); // Limpar o buffer
        String nomeHospede = scanner.nextLine();
        System.out.print("Data de entrada (YYYY-MM-DD): ");
        String dataEntrada = scanner.nextLine();
        System.out.print("Data de saída (YYYY-MM-DD): ");
        String dataSaida = scanner.nextLine();
        System.out.print("Número de pessoas: ");
        int numeroPessoas = scanner.nextInt();

        System.out.println("\n--- Quartos Disponíveis ---");
        List<Quarto> disponiveis = quartos.stream()
                .filter(q -> !q.isOcupado() && q.getCapacidadeMaxima() >= numeroPessoas)
                .toList();
        disponiveis.forEach(q -> System.out.println("ID: " + q.getNumero() + ", Capacidade: " + q.getCapacidadeMaxima()));

        if (disponiveis.isEmpty()) {
            System.out.println("Nenhum quarto disponível para a capacidade informada.");
            return;
        }

        System.out.print("Escolha o ID do quarto: ");
        int idQuartoEscolhido = scanner.nextInt();
        Quarto quartoEscolhido = buscarQuarto(disponiveis, idQuartoEscolhido);

        if (quartoEscolhido != null) {
            quartoEscolhido.setOcupado(true);
            Hospede hospede = new Hospede(reservas.size() + 1, nomeHospede);
            Reserva novaReserva = new Reserva(reservas.size() + 1, dataEntrada, dataSaida, hospede);
            novaReserva.adicionarQuarto(quartoEscolhido);
            reservas.add(novaReserva);
            System.out.println("Reserva criada com sucesso!");
        } else {
            System.out.println("Quarto escolhido não encontrado ou indisponível.");
        }
    }

    private static Quarto buscarQuarto(List<Quarto> quartos, int numero) {
        return quartos.stream().filter(q -> q.getNumero() == numero).findFirst().orElse(null);
    }

    private static Reserva buscarReserva(List<Reserva> reservas, int id) {
        return reservas.stream().filter(r -> r.getId() == id).findFirst().orElse(null);
    }

    private static Manutencao buscarManutencao(List<Manutencao> manutencoes, int id) {
        return manutencoes.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }
     private static int gerarIdManutencao() {
            return (int) (Math.random() * 1000); // Gera um ID aleatório
    }
}
