package questao06;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private final List<ItemPedido> itens = new ArrayList<>();
    private final CalculadoraPedidos calculadora;

    public Pedido(CalculadoraPedidos calculadora) {
        this.calculadora = calculadora;
    }

    public void adicionar(ItemPedido item) {
        itens.add(item);
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public double getValorTotal() {
        return calculadora.calcularValorTotal(itens);
    }
}
