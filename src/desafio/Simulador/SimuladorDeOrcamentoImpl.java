package desafio.Simulador;

public class SimuladorDeOrcamentoImpl implements SimuladorDeOrcamento {

    private Guincho guincho;

    public SimuladorDeOrcamentoImpl(Guincho guincho) {
        this.guincho = guincho;
    }

    @Override
    public double calcularCustoTotal(Veiculo veiculo, Trajeto trajeto) {
        double custoDeslocamento = guincho.calcularCustoDeslocamento(trajeto);
        return custoDeslocamento * trajeto.getDistanciaEmKM();
    }
}
