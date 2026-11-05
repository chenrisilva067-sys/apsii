package questao06;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private final List<ItemPedido> itens = new ArrayList<>();
    private final CalculadoraPedidos calculadora;

    public CarrinhoDeCompras(CalculadoraPedidos calculadora) {
        this.calculadora = calculadora;
    }

    public void adicionar(ItemPedido item) {
        itens.add(item);
    }

    public double getValorTotal() {
        return calculadora.calcularValorTotal(itens);
    }
}
