package desafio.Simulador;

public class VeiculoImpl implements Veiculo {

    private TipoVeiculo tipo;
    private EstadoConservacao estado;

    public VeiculoImpl(TipoVeiculo tipo, EstadoConservacao estado) {
        this.tipo = tipo;
        this.estado = estado;
    }

    @Override
    public TipoVeiculo getTipo() {
        return tipo;
    }

    @Override
    public EstadoConservacao getEstado() {
        return estado;
    }
}
