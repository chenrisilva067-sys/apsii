package questao01;

public class Main {

    public static void main(String[] args) {
        GestaoAlunos gestao = new GestaoAlunos();
        CalculadoraMedias calculadora = new CalculadoraMedias();
        RelatorioService relatorio = new RelatorioService(calculadora);
        NotificacaoService notificacao = new NotificacaoService();
        PagamentoService pagamento = new PagamentoService();

        Aluno ana = gestao.cadastrar("Ana", "ana@email.com");
        ana.adicionarNota(8.0);
        ana.adicionarNota(9.0);

        System.out.println(relatorio.emitir(gestao.listar()));
        notificacao.enviarEmail(ana, "Suas notas foram publicadas.");
        pagamento.processar(ana, 850.0);
    }
}
