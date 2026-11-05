package questao01;

/** Responsabilidade única: notificações por e-mail. */
public class NotificacaoService {

    public void enviarEmail(Aluno aluno, String mensagem) {
        System.out.println("E-mail para " + aluno.getEmail() + ": " + mensagem);
    }
}
