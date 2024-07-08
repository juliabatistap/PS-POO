package desafio.Atacado;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CaixaDoAtacado {
    private List<String[]> produtos = new ArrayList<>();
    private double total = 0;

    public void adicionarProduto(Produto produto, int quantidade) {
        produtos.add(new String[]{produto.getId(), String.valueOf(quantidade)});
        total += produto.getPreco() * quantidade;
    }

    public double calcularTotal() {
        return total;
    }

    public int getTotalItens() {
        return produtos.size();
    }

    public void salvarCompra(String metodoPagamento) throws IOException {
        FileWriter writer = new FileWriter("compras.csv");
        writer.write(metodoPagamento + "\n");

        for (String[] produto : produtos) {
            writer.write(produto[0] + "," + produto[1] + "\n");
        }

        writer.close();
    }
}


