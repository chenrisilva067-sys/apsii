package questao04;

/**
 * Gerente do departamento Financeiro: o "departamento" deixou de ser um
 * if com String e virou um tipo. A regra do bônus especial fica aqui,
 * sem condicionais aninhadas (Decompose Conditional + guard clause).
 */
public class GerenteFinanceiro extends Gerente {

    private static final int ANOS_PARA_BONUS_ESPECIAL = 5;

    public GerenteFinanceiro(String nome, double salario, int tempoDeServico) {
        super(nome, salario, tempoDeServico);
    }

    @Override
    public double calcularBonus() {
        if (!temDireitoAoBonusEspecial()) {
            return super.calcularBonus();
        }
        return getSalario() * 0.30;
    }

    private boolean temDireitoAoBonusEspecial() {
        return getTempoDeServico() > ANOS_PARA_BONUS_ESPECIAL;
    }
}
