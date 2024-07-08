package desafio.Simulador;

public class GuinchoReboqueIntegrado implements Guincho {

    private static final double CUSTO_POR_KM = 10.0;

    @Override
    public double calcularCustoDeslocamento(Trajeto trajeto) {
        return CUSTO_POR_KM;
    }
}
