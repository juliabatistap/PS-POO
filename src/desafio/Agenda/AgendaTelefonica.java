package desafio.Agenda;

import java.util.ArrayList;
import java.util.List;

public class AgendaTelefonica {
    private List<Contato> contatos;

    public AgendaTelefonica() {
        this.contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        if (!contatos.contains(contato)) {
            contatos.add(contato);
        } else {
            System.out.println("Erro: Contato já existe.");
        }
    }

    public void removerContato(String nome) {
        contatos.removeIf(c -> c.getNome().equals(nome));
    }

    public Contato buscarContato(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equals(nome)) {
                return contato;
            }
        }
        return null;
    }

    public void atualizarContato(String nome, Contato novoContato) {
        int index = contatos.indexOf(buscarContato(nome));
        if (index != -1) {
            contatos.set(index, novoContato);
        } else {
            System.out.println("Erro: Contato não encontrado");
        }
    }

    public void listarContatos() {
        for (Contato contato : contatos) {
            System.out.println("Nome: " + contato.getNome() + ", numero: " + contato.getNumeroDeTelefone());
        }
    }
}
