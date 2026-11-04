package questao02;

public class RelatorioFrete {

    private final FreteService freteService;

    public RelatorioFrete(FreteService freteService) {
        this.freteService = freteService;
    }

    public String gerar(double pesoKg, double distanciaKm) {
        return "Frete: R$ " + freteService.calcular(pesoKg, distanciaKm);
    }
}
