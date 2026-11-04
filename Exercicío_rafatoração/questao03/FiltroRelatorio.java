package questao03;

/**
 * DEPOIS: Introduce Parameter Object + Builder.
 * Cada opção tem nome, valor padrão e pode ser informada em qualquer ordem.
 */
public class FiltroRelatorio {

    private final int mes;
    private final int ano;
    private final String usuario;
    private final String departamento;
    private final FormatoRelatorio formato;
    private final boolean detalhado;
    private final boolean incluirImpostos;
    private final boolean ordenarPorData;

    private FiltroRelatorio(Builder b) {
        this.mes = b.mes;
        this.ano = b.ano;
        this.usuario = b.usuario;
        this.departamento = b.departamento;
        this.formato = b.formato;
        this.detalhado = b.detalhado;
        this.incluirImpostos = b.incluirImpostos;
        this.ordenarPorData = b.ordenarPorData;
    }

    public int getMes() { return mes; }
    public int getAno() { return ano; }
    public String getUsuario() { return usuario; }
    public String getDepartamento() { return departamento; }
    public FormatoRelatorio getFormato() { return formato; }
    public boolean isDetalhado() { return detalhado; }
    public boolean isIncluirImpostos() { return incluirImpostos; }
    public boolean isOrdenarPorData() { return ordenarPorData; }

    public static Builder periodo(int mes, int ano) {
        return new Builder(mes, ano);
    }

    public static class Builder {
        private final int mes;
        private final int ano;
        private String usuario = "";
        private String departamento = "";
        private FormatoRelatorio formato = FormatoRelatorio.PDF;
        private boolean detalhado = false;
        private boolean incluirImpostos = false;
        private boolean ordenarPorData = false;

        private Builder(int mes, int ano) {
            this.mes = mes;
            this.ano = ano;
        }

        public Builder usuario(String usuario) { this.usuario = usuario; return this; }
        public Builder departamento(String departamento) { this.departamento = departamento; return this; }
        public Builder formato(FormatoRelatorio formato) { this.formato = formato; return this; }
        public Builder detalhado() { this.detalhado = true; return this; }
        public Builder comImpostos() { this.incluirImpostos = true; return this; }
        public Builder ordenadoPorData() { this.ordenarPorData = true; return this; }

        public FiltroRelatorio build() { return new FiltroRelatorio(this); }
    }
}
