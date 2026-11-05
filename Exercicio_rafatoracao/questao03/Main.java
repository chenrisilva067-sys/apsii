package questao03;

public class Main {

    public static void main(String[] args) {
        FiltroRelatorio filtro = FiltroRelatorio.periodo(3, 2026)
                .usuario("ana")
                .departamento("TI")
                .formato(FormatoRelatorio.PDF)
                .detalhado()
                .ordenadoPorData()
                .build();

        System.out.println(new RelatorioFinanceiro().gerar(filtro));
    }
}
