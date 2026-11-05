package questao01;

/** Responsabilidade única: cálculo de médias. */
public class CalculadoraMedias {

    public double calcular(Aluno aluno) {
        if (aluno.getNotas().isEmpty()) {
            return 0;
        }
        double soma = 0;
        for (double nota : aluno.getNotas()) {
            soma += nota;
        }
        return soma / aluno.getNotas().size();
    }
}
