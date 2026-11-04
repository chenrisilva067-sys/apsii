package questao04;

public class Analista extends Funcionario {

    public Analista(String nome, double salario, int tempoDeServico) {
        super(nome, salario, tempoDeServico);
    }

    @Override
    public double calcularBonus() {
        return getSalario() * 0.05;
    }
}
