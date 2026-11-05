package questao02;

public class CarrinhoDeCompras {

    private final FreteService freteService;

    public CarrinhoDeCompras(FreteService freteService) {
        this.freteService = freteService;
    }

    public double calcularFrete(double pesoKg, double distanciaKm) {
        return freteService.calcular(pesoKg, distanciaKm);
    }
}
