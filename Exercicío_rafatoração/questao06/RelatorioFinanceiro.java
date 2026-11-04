package questao06;

public class RelatorioFinanceiro {

    private final CalculadoraPedidos calculadora;

    public RelatorioFinanceiro(CalculadoraPedidos calculadora) {
        this.calculadora = calculadora;
    }

    public String gerar(Pedido pedido) {
        return "Total do pedido: R$ " + calculadora.calcularValorTotal(pedido.getItens());
    }
}
