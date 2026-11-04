package questao06;

public class ItemPedido {

    private final String produto;
    private final double preco;
    private final int quantidade;

    public ItemPedido(String produto, double preco, int quantidade) {
        this.produto = produto;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getProduto() {
        return produto;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
