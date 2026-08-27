package aula03;

public class Gerente extends FuncionarioCLT {

	private int tamanhoEquipe;
	private double percentualBonus;

	public Gerente(String nome, String matricula, double salarioBase,
			String dataAdmissao, double valeTransporte, double valeAlimentacao,
			int tamanhoEquipe, double percentualBonus) {
		super(nome, matricula, salarioBase, dataAdmissao, valeTransporte, valeAlimentacao);
		this.tamanhoEquipe = tamanhoEquipe;
		this.percentualBonus = percentualBonus;
	}

	public int getTamanhoEquipe() {
		return tamanhoEquipe;
	}

	public double getPercentualBonus() {
		return percentualBonus;
	}

	@Override
	public double calcularSalario() {
		// salário do CLT (base + benefícios) + bônus (salarioBase * percentualBonus)
		return super.calcularSalario() + (getSalarioBase() * percentualBonus);
	}

	@Override
	public double calcularDesconto() {
		// desconto do CLT (8% + R$ 50,00)
		double desconto = super.calcularDesconto();

		// se a equipe tiver mais de 10 pessoas, acrescenta R$ 100,00
		if (tamanhoEquipe > 10) {
			desconto += 100.00;
		}

		return desconto;
	}
}