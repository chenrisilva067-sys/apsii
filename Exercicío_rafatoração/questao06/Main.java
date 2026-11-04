package questao06;

public class Main {

    public static void main(String[] args) {
        CalculadoraPedidos calculadora = new CalculadoraPedidos();

        Pedido pedido = new Pedido(calculadora);
        pedido.adicionar(new ItemPedido("Teclado", 120.0, 2));
        pedido.adicionar(new ItemPedido("Mouse", 60.0, 1));

        CarrinhoDeCompras carrinho = new CarrinhoDeCompras(calculadora);
        carrinho.adicionar(new ItemPedido("Teclado", 120.0, 2));

        System.out.println("Pedido  : " + pedido.getValorTotal());
        System.out.println("Carrinho: " + carrinho.getValorTotal());
        System.out.println(new RelatorioFinanceiro(calculadora).gerar(pedido));
    }
}
