package desafio.Simulador;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o estado do veículo (NOVO ou QUEBRADO):");
        EstadoConservacao estado = EstadoConservacao.valueOf(scanner.nextLine().toUpperCase());

        System.out.println("Informe o tipo de veículo (CARRO, MINIVAN, ONIBUS ou CAMINHAO):");
        TipoVeiculo tipo = TipoVeiculo.valueOf(scanner.nextLine().toUpperCase());

        System.out.println("Informe o trajeto (A_B, C_C, C_A ou C_B):");
        Trajeto trajeto = Trajeto.valueOf(scanner.nextLine().toUpperCase());

        Guincho guincho;
        switch (tipo) {
            case CARRO:
            case MINIVAN:
                guincho = new GuinchoComPlataforma();
                break;
            case ONIBUS:
            case CAMINHAO:
                guincho = new GuinchoReboqueIntegrado();
                break;
            default:
                throw new IllegalArgumentException("Tipo de veiculo não é aceito");
        }

        SimuladorDeOrcamento simulador = new SimuladorDeOrcamentoImpl(guincho);
        Veiculo veiculo = new VeiculoImpl(tipo, estado);
        double custoTotal = simulador.calcularCustoTotal(veiculo, trajeto);

        System.out.printf("O custo total do orçamento é de R$ %.2f%n", custoTotal);

        scanner.close();
    }
}
