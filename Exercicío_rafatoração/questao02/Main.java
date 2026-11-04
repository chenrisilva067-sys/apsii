package questao02;

public class Main {

    public static void main(String[] args) {
        FreteService frete = new FreteService();
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras(frete);
        PrecoFinal precoFinal = new PrecoFinal(frete);
        RelatorioFrete relatorio = new RelatorioFrete(frete);

        System.out.println("Carrinho: " + carrinho.calcularFrete(35, 120));
        System.out.println("Preço final: " + precoFinal.calcular(200, 35, 120));
        System.out.println(relatorio.gerar(35, 120));
    }
}
