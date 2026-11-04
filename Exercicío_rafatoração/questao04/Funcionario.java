package questao04;

/**
 * DEPOIS: Replace Conditional with Polymorphism.
 * Cada cargo/benefício vira uma subclasse com sua própria regra.
 */
public abstract class Funcionario {

    private final String nome;
    private final double salario;
    private final int tempoDeServico;

    protected Funcionario(String nome, double salario, int tempoDeServico) {
        this.nome = nome;
        this.salario = salario;
        this.tempoDeServico = tempoDeServico;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public int getTempoDeServico() {
        return tempoDeServico;
    }

    public abstract double calcularBonus();
}
