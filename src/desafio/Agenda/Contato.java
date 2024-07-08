package desafio.Agenda;

public class Contato {
    private String nome;
    private String numeroDeTelefone;

    public Contato(String nome, String numeroDeTelefone) {
        this.nome = nome;
        this.numeroDeTelefone = numeroDeTelefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroDeTelefone() {
        return numeroDeTelefone;
    }

    public void setNumeroDeTelefone(String numeroDeTelefone) {
        this.numeroDeTelefone = numeroDeTelefone;
    }
}
