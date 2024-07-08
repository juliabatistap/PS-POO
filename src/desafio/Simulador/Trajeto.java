package desafio.Simulador;

public enum Trajeto {
    A_B(8),
    C_C(5),
    C_A(10),
    C_B(15);

    private final Integer distanciaEmKM;

    Trajeto(Integer distanciaEmKM) {
        this.distanciaEmKM = distanciaEmKM;
    }

    public Integer getDistanciaEmKM() {
        return distanciaEmKM;
    }
}
