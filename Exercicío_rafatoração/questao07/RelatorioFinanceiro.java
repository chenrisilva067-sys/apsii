package questao07;

/** Agora o relatório só delega e formata; a regra de cálculo está em Funcionario. */
public class RelatorioFinanceiro {

    public String gerar(Funcionario funcionario) {
        return funcionario.getNome()
                + " | bônus: " + funcionario.calcularBonus()
                + " | descontos: " + funcionario.calcularDescontos()
                + " | líquido: " + funcionario.calcularSalarioLiquido();
    }
}
