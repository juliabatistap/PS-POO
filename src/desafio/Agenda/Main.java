package desafio.Agenda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AgendaTelefonica agenda = new AgendaTelefonica();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Remover contato");
            System.out.println("3. Buscar contato");
            System.out.println("4. Atualizar contato");
            System.out.println("5. Listar contatos");
            System.out.println("6. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do contato: ");
                    String nome = scanner.next();
                    System.out.print("Digite o número de telefone do contato: ");
                    String numero = scanner.next();
                    Contato novoContato = new Contato(nome, numero);
                    agenda.adicionarContato(novoContato);
                    System.out.println("Contato adicionado com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o nome do contato a ser removido: ");
                    String nomeParaRemover = scanner.next();
                    agenda.removerContato(nomeParaRemover);
                    System.out.println("Contato removido com sucesso!");
                    break;
                case 3:
                    System.out.print("Digite o nome do contato a ser buscado: ");
                    String nomeParaBuscar = scanner.next();
                    Contato contatoEncontrado = agenda.buscarContato(nomeParaBuscar);
                    if (contatoEncontrado != null) {
                        System.out.println("Nome: " + contatoEncontrado.getNome() + ", numero: " + contatoEncontrado.getNumeroDeTelefone());
                    } else {
                        System.out.println("Contato não encontrado");
                    }
                    break;
                case 4:
                    System.out.print("Digite o nome do contato a ser atualizado: ");
                    String nomeParaAtualizar = scanner.next();
                    System.out.print("Digite o novo nome do contato: ");
                    String novoNome = scanner.next();
                    System.out.print("Digite o novo numero de telefone do contato: ");
                    String novoNumero = scanner.next();
                    Contato contatoAtualizado = new Contato(novoNome, novoNumero);
                    agenda.atualizarContato(nomeParaAtualizar, contatoAtualizado);
                    System.out.println("Contato atualizado com sucesso!");
                    break;
                case 5:
                    agenda.listarContatos();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Opção invalida.");
            }
        }
    }
}
