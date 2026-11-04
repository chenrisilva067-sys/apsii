package questao05;

public class Main {

    public static void main(String[] args) {
        NomesRuinsAntes antes = new NomesRuinsAntes();
        CalculadoraImposto depois = new CalculadoraImposto();

        // Mesmo resultado nas duas versões: a refatoração não muda o comportamento.
        System.out.println("Antes : " + antes.process(100));
        System.out.println("Depois: " + depois.calcularPrecoComImposto(100));
    }
}
