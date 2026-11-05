package questao02;

public class PrecoFinal {

    private final FreteService freteService;

    public PrecoFinal(FreteService freteService) {
        this.freteService = freteService;
    }

    public double calcular(double subtotal, double pesoKg, double distanciaKm) {
        return subtotal + freteService.calcular(pesoKg, distanciaKm);
    }
}
