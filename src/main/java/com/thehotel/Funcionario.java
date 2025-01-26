package com.thehotel;

// Classe Funcionário
class Funcionario extends Pessoa {
    public Funcionario(int id, String nome) {
        super(id, nome);
    }

    public void registrarManutencao(Quarto quarto, String descricao, int idManutencao) {
        Manutencao manutencao = new Manutencao(idManutencao, descricao, quarto);
        quarto.adicionarManutencao(manutencao);
        System.out.println("Manutenção registrada com sucesso para o quarto " + quarto.getNumero());
    }

    public void confirmarReserva(Reserva reserva) {
        reserva.setEstado("Confirmada");
        System.out.println("Reserva confirmada com sucesso para o hóspede " + reserva.getHospede().getNome());
    }

    public void realizarManutencao(int idManutencao, Quarto quarto) {
        Manutencao manutencao = quarto.getManutencoes().stream()
            .filter(m -> m.getId() == idManutencao)
            .findFirst()
            .orElse(null);

        if (manutencao != null) {
            quarto.getManutencoes().remove(manutencao);
            System.out.println("Manutenção de ID " + idManutencao + " concluída no quarto " + quarto.getNumero());
        } else {
            System.out.println("Manutenção de ID " + idManutencao + " não encontrada no quarto " + quarto.getNumero());
        }
    }
}
