/**
 * Regra padrão de multa: valor fixo por dia de atraso, lido da configuração
 * global (Singleton), que é recebida pelo construtor.
 */
public class MultaPorDia implements CalculadoraMulta {

    private final ConfiguracaoBiblioteca config;

    public MultaPorDia(ConfiguracaoBiblioteca config) {
        this.config = config;
    }

    @Override
    public double calcular(long diasDeAtraso) {
        if (diasDeAtraso <= 0) {
            return 0.0;
        }
        return diasDeAtraso * config.getMultaPorDia();
    }
}
