package questao07;

public class Main {

    public static void main(String[] args) {
        Funcionario f = new Funcionario("Fernanda", 5000, 0.10, 0.08);

        System.out.println("Antes : " + new RelatorioFinanceiroAntes().calcularLiquido(f));
        System.out.println("Depois: " + new RelatorioFinanceiro().gerar(f));
    }
}
