package questao07;

/**
 * ANTES: "Inveja dos dados" (Feature Envy).
 * O relatório puxa os dados do Funcionario e faz os cálculos que
 * deveriam pertencer a ele.
 */
public class RelatorioFinanceiroAntes {

    public double calcularLiquido(Funcionario f) {
        double bonus = f.getSalario() * f.getPercentualBonus();
        double descontos = f.getSalario() * f.getPercentualDesconto();
        return f.getSalario() + bonus - descontos;
    }
}
