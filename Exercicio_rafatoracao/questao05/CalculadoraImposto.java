package questao05;

/**
 * DEPOIS: Rename Method / Rename Variable.
 * O comportamento é idêntico; o código agora se explica sozinho.
 */
public class CalculadoraImposto {

    private static final double ALIQUOTA_PADRAO = 0.18;

    public double calcularImposto(double valorProduto, double aliquota) {
        double valorImposto = valorProduto * aliquota;
        return valorImposto;
    }

    public double calcularPrecoComImposto(double valorProduto) {
        double valorImposto = calcularImposto(valorProduto, ALIQUOTA_PADRAO);
        return valorProduto + valorImposto;
    }
}
