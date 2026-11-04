package questao06;

import java.util.List;

/**
 * ANTES: o mesmo cálculo do valor total copiado em três classes.
 */
class PedidoAntes {
    double calcularValorTotal(List<ItemPedido> itens) {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getPreco() * item.getQuantidade();
        }
        return total;
    }
}

class CarrinhoDeComprasAntes {
    double calcularValorTotal(List<ItemPedido> itens) {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getPreco() * item.getQuantidade();
        }
        return total;
    }
}

class RelatorioFinanceiroAntes {
    double calcularValorTotal(List<ItemPedido> itens) {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getPreco() * item.getQuantidade();
        }
        return total;
    }
}
