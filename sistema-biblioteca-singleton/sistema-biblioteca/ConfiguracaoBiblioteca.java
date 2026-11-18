/**
 * SINGLETON #1 - Configuração global da biblioteca.
 *
 * Garante que exista uma única fonte de verdade para as regras do sistema
 * (prazo de empréstimo e valor da multa). Se houvesse várias instâncias,
 * cada parte do sistema poderia enxergar regras diferentes.
 *
 * Implementação: "Initialization-on-demand holder" (Bill Pugh).
 *  - Lazy: a instância só é criada quando getInstancia() é chamado pela 1ª vez.
 *  - Thread-safe: a JVM garante a inicialização segura da classe Holder.
 *  - Sem synchronized no acesso, então não há custo de desempenho.
 */
public class ConfiguracaoBiblioteca {

    private volatile int diasEmprestimo = 7;
    private volatile double multaPorDia = 2.0;

    // Construtor privado: ninguém de fora consegue fazer "new".
    private ConfiguracaoBiblioteca() {
    }

    private static class Holder {
        private static final ConfiguracaoBiblioteca INSTANCIA = new ConfiguracaoBiblioteca();
    }

    public static ConfiguracaoBiblioteca getInstancia() {
        return Holder.INSTANCIA;
    }

    public int getDiasEmprestimo() {
        return diasEmprestimo;
    }

    public void setDiasEmprestimo(int diasEmprestimo) {
        if (diasEmprestimo <= 0) {
            throw new IllegalArgumentException("O prazo de empréstimo deve ser maior que zero.");
        }
        this.diasEmprestimo = diasEmprestimo;
    }

    public double getMultaPorDia() {
        return multaPorDia;
    }

    public void setMultaPorDia(double multaPorDia) {
        if (multaPorDia < 0) {
            throw new IllegalArgumentException("A multa por dia não pode ser negativa.");
        }
        this.multaPorDia = multaPorDia;
    }
}
