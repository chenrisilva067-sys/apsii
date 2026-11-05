package questao03;

public class RelatorioFinanceiro {

    public String gerar(FiltroRelatorio filtro) {
        StringBuilder sb = new StringBuilder();
        sb.append("Relatório ").append(filtro.getMes()).append("/").append(filtro.getAno());
        sb.append(" [").append(filtro.getFormato()).append("]");
        sb.append(" usuário=").append(filtro.getUsuario());
        sb.append(" depto=").append(filtro.getDepartamento());
        if (filtro.isDetalhado()) {
            sb.append(" | detalhado");
        }
        if (filtro.isIncluirImpostos()) {
            sb.append(" | com impostos");
        }
        if (filtro.isOrdenarPorData()) {
            sb.append(" | ordenado por data");
        }
        return sb.toString();
    }
}
