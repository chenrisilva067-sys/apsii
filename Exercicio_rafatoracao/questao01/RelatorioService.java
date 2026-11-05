package questao01;

import java.util.List;

/** Responsabilidade única: emissão de relatórios. */
public class RelatorioService {

    private final CalculadoraMedias calculadora;

    public RelatorioService(CalculadoraMedias calculadora) {
        this.calculadora = calculadora;
    }

    public String emitir(List<Aluno> alunos) {
        StringBuilder sb = new StringBuilder("RELATÓRIO\n");
        for (Aluno a : alunos) {
            sb.append(a.getNome())
              .append(" - média: ")
              .append(calculadora.calcular(a))
              .append("\n");
        }
        return sb.toString();
    }
}
