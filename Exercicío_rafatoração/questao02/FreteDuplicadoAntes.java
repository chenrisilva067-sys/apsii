package questao02;

/**
 * ANTES: a mesma regra de frete copiada em três módulos.
 * Se a regra mudar, é preciso lembrar de alterar os três lugares.
 */
class CarrinhoDeComprasAntes {
    double calcularFrete(double pesoKg, double distanciaKm) {
        double frete = 10 + pesoKg * 2 + distanciaKm * 0.5;
        if (pesoKg > 30) {
            frete += 20;
        }
        return frete;
    }
}

class PrecoFinalAntes {
    double calcularFrete(double pesoKg, double distanciaKm) {
        double frete = 10 + pesoKg * 2 + distanciaKm * 0.5;
        if (pesoKg > 30) {
            frete += 20;
        }
        return frete;
    }
}

class RelatorioFreteAntes {
    double calcularFrete(double pesoKg, double distanciaKm) {
        double frete = 10 + pesoKg * 2 + distanciaKm * 0.5;
        if (pesoKg > 30) {
            frete += 20;
        }
        return frete;
    }
}
