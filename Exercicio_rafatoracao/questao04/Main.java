package questao04;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Funcionario> funcionarios = Arrays.asList(
                new Analista("Bruno", 4000, 3),
                new Gerente("Carla", 8000, 7),
                new GerenteFinanceiro("Diego", 10000, 8),
                new GerenteFinanceiro("Elisa", 10000, 2));

        for (Funcionario f : funcionarios) {
            System.out.println(f.getNome() + " -> bônus: R$ " + f.calcularBonus());
        }
    }
}
