package questao01;

import java.util.ArrayList;
import java.util.List;

/**
 * ANTES: "God Class" / "Long Class".
 * Uma única classe concentra cadastro, cálculo de médias, relatórios,
 * e-mails e pagamentos (na vida real, mais de 3.000 linhas).
 */
public class SistemaAcademicoAntes {

    private final List<Aluno> alunos = new ArrayList<>();

    public void cadastrarAluno(String nome, String email) {
        alunos.add(new Aluno(nome, email));
    }

    public double calcularMedia(Aluno aluno) {
        double soma = 0;
        for (double nota : aluno.getNotas()) {
            soma += nota;
        }
        return aluno.getNotas().isEmpty() ? 0 : soma / aluno.getNotas().size();
    }

    public String emitirRelatorio() {
        StringBuilder sb = new StringBuilder("RELATÓRIO\n");
        for (Aluno a : alunos) {
            sb.append(a.getNome()).append(" - média: ").append(calcularMedia(a)).append("\n");
        }
        return sb.toString();
    }

    public void enviarEmail(Aluno aluno, String mensagem) {
        System.out.println("E-mail para " + aluno.getEmail() + ": " + mensagem);
    }

    public void processarPagamento(Aluno aluno, double valor) {
        System.out.println("Pagamento de R$ " + valor + " processado para " + aluno.getNome());
    }
}
