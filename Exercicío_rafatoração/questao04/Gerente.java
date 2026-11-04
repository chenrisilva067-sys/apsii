package questao04;

public class Gerente extends Funcionario {

    public Gerente(String nome, double salario, int tempoDeServico) {
        super(nome, salario, tempoDeServico);
    }

    @Override
    public double calcularBonus() {
        return getSalario() * 0.10;
    }
}
