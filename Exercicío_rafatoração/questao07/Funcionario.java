package questao07;

/**
 * DEPOIS: Move Method. Os cálculos de bônus, descontos e salário líquido
 * foram para a classe que possui os dados.
 */
public class Funcionario {

    private final String nome;
    private final double salario;
    private final double percentualBonus;
    private final double percentualDesconto;

    public Funcionario(String nome, double salario, double percentualBonus, double percentualDesconto) {
        this.nome = nome;
        this.salario = salario;
        this.percentualBonus = percentualBonus;
        this.percentualDesconto = percentualDesconto;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public double getPercentualBonus() {
        return percentualBonus;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public double calcularBonus() {
        return salario * percentualBonus;
    }

    public double calcularDescontos() {
        return salario * percentualDesconto;
    }

    public double calcularSalarioLiquido() {
        return salario + calcularBonus() - calcularDescontos();
    }
}
