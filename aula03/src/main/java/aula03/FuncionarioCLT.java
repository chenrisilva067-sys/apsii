package aula03;

public class FuncionarioCLT extends Funcionario {

	private double valeTransporte;
	private double valeAlimentacao;

	public FuncionarioCLT(String nome, String matricula, double salarioBase,
			String dataAdmissao, double valeTransporte, double valeAlimentacao) {
		super(nome, matricula, salarioBase, dataAdmissao);
		this.valeTransporte = valeTransporte;
		this.valeAlimentacao = valeAlimentacao;
	}

	public double getValeTransporte() {
		return valeTransporte;
	}

	public double getValeAlimentacao() {
		return valeAlimentacao;
	}

	@Override
	public double calcularSalario() {
		// salário-base + valeTransporte + valeAlimentacao
		return super.calcularSalario() + valeTransporte + valeAlimentacao;
	}

	@Override
	public double calcularDesconto() {
		// desconto padrão (8% do salário-base) + R$ 50,00 fixo
		return super.calcularDesconto() + 50.00;
	}
}