package questao01;

/** Responsabilidade única: processamento de pagamentos. */
public class PagamentoService {

    public void processar(Aluno aluno, double valor) {
        System.out.println("Pagamento de R$ " + valor + " processado para " + aluno.getNome());
    }
}
