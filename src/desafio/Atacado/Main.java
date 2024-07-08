package desafio.Atacado;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Método de Pagamento:");
        String metodoPagamento = scanner.nextLine();

        Produto[] produtos = {
                new Produto("1", "Café 1kg", 53.00),
                new Produto("2", "Sabão em pó", 36.00),
                new Produto("3", "Caixa de Leite", 82.00),
                new Produto("4", "Refrigerante", 8.50)
        };

        System.out.println("Produtos Disponiveis:");
        for (Produto produto : produtos) {
            System.out.printf("%s - %s - R$ %.2f\n", produto.getId(), produto.getNome(), produto.getPreco());
        }

        System.out.println("Insira os produtos e suas quantidades no formato \"ID do produto\", quantidade:");
        System.out.println("Insira \"concluir\" para concluir sua compra");
        CaixaDoAtacado caixa = new CaixaDoAtacado();
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("concluir")) {
                break;
            }
            String[] produtoDados = input.split(",");
            if (produtoDados.length == 2) {
                Produto produto = null;
                for (Produto prod : produtos) {
                    if (prod.getId().equals(produtoDados[0].trim())) {
                        produto = prod;
                        break;
                    }
                }
                if (produto != null) {
                    try {
                        int quantidade = Integer.parseInt(produtoDados[1].trim());
                        caixa.adicionarProduto(produto, quantidade);
                    } catch (NumberFormatException e) {
                        System.out.println("Quantidade invalida. Por favor, insira um numero inteiro.");
                    }
                } else {
                    System.out.println("Produto não encontrado. Por favor, insira um ID valido.");
                }
            } else {
                System.out.println("Entrada invalida. Por favor, insira o ID do produto seguido pela quantidade.");
            }
        }

        double total = caixa.calcularTotal();
        if ("debito".equals(metodoPagamento)) {
        } else if ("dinheiro".equals(metodoPagamento)) {
            total *= 0.95;
        } else if ("credito".equals(metodoPagamento)) {
            total *= 1.03;
        }

        if (total > 0) {
            if (caixa.getTotalItens() <= 5) {
            } else if (caixa.getTotalItens() <= 15) {
                total *= 0.9;
            } else if (caixa.getTotalItens() <= 25) {
                total *= 0.8;
            } else {
                total *= 0.75;
            }
        }

        System.out.println("Valor total: " + total);

        try {
            caixa.salvarCompra(metodoPagamento);
            System.out.println("Informações de compra salvas com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar informações de compra: " + e.getMessage());
        }
    }
}
