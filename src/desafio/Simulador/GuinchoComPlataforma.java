package desafio.Simulador;

public class GuinchoComPlataforma implements Guincho {

    private static final double CUSTO_POR_KM = 5.0;

    @Override
    public double calcularCustoDeslocamento(Trajeto trajeto) {
        return CUSTO_POR_KM;
    }
}
