package questao06;

import java.util.List;

/**
 * DEPOIS: Extract Class. O cálculo existe em um único lugar.
 */
public class CalculadoraPedidos {

    public double calcularValorTotal(List<ItemPedido> itens) {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getPreco() * item.getQuantidade();
        }
        return total;
    }
}
