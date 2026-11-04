package questao03;

/**
 * ANTES: 8 parâmetros, vários booleanos.
 * Na chamada, gerarRelatorioFinanceiro(3, 2026, "ana", "TI", "PDF", true, false, true)
 * ninguém sabe o que cada true/false significa e é fácil trocar a ordem.
 */
public class RelatorioFinanceiroAntes {

    public String gerarRelatorioFinanceiro(int mes, int ano, String usuario,
            String departamento, String formato, boolean detalhado,
            boolean incluirImpostos, boolean ordenarPorData) {
        return "Relatório " + mes + "/" + ano + " (" + usuario + ", " + departamento + ")";
    }
}
