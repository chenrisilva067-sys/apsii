package questao02;

/**
 * DEPOIS: regra de frete em um único lugar (serviço de domínio).
 * Técnicas: Extract Method + Move Method para uma classe central.
 */
public class FreteService {

    private static final double TAXA_BASE = 10;
    private static final double VALOR_POR_KG = 2;
    private static final double VALOR_POR_KM = 0.5;
    private static final double LIMITE_PESO_PESADO = 30;
    private static final double ADICIONAL_PESADO = 20;

    public double calcular(double pesoKg, double distanciaKm) {
        double frete = TAXA_BASE + pesoKg * VALOR_POR_KG + distanciaKm * VALOR_POR_KM;
        return frete + adicionalPorPeso(pesoKg);
    }

    private double adicionalPorPeso(double pesoKg) {
        return pesoKg > LIMITE_PESO_PESADO ? ADICIONAL_PESADO : 0;
    }
}
