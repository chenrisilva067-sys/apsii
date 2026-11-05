package questao04;

/**
 * ANTES: condicionais aninhadas com regras de negócio misturadas.
 */
public class FuncionarioAntes {

    private final String cargo;
    private final int tempoDeServico;
    private final String departamento;
    private final double salario;

    public FuncionarioAntes(String cargo, int tempoDeServico, String departamento, double salario) {
        this.cargo = cargo;
        this.tempoDeServico = tempoDeServico;
        this.departamento = departamento;
        this.salario = salario;
    }

    public double calcularBonus() {
        double bonus = 0;
        if (cargo.equals("Gerente")) {
            if (tempoDeServico > 5) {
                if (departamento.equals("Financeiro")) {
                    bonus = salario * 0.30; // bônus especial
                }
            }
        }
        return bonus;
    }
}
