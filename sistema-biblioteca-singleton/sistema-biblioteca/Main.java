import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Ponto de entrada (menu de console).
 *
 * É aqui, e somente aqui, que os Singletons são obtidos e entregues à
 * Biblioteca por injeção de dependência.
 */
public class Main {

    public static void main(String[] args) {
        ConfiguracaoBiblioteca config = ConfiguracaoBiblioteca.getInstancia();
        Registrador log = LogSistema.getInstancia();
        Biblioteca biblioteca = new Biblioteca(config, log, new MultaPorDia(config));
        popularDadosIniciais(biblioteca);

        Scanner in = new Scanner(System.in);
        int opcao;
        do {
            exibirMenu();
            opcao = lerInt(in, "Escolha uma opção: ");
            try {
                executar(opcao, in, biblioteca, config);
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (opcao != 0);
    }

    private static void popularDadosIniciais(Biblioteca b) {
        b.adicionarItem(new Livro(1, "Padrões de Projeto", "Gamma et al."));
        b.adicionarItem(new Livro(2, "Código Limpo", "Robert C. Martin"));
        b.adicionarItem(new Revista(3, "Revista Programar", 42));
        b.cadastrarUsuario(new Usuario(1, "Ana"));
        b.cadastrarUsuario(new Usuario(2, "Bruno"));
    }

    private static void exibirMenu() {
        System.out.println();
        System.out.println("===== BIBLIOTECA =====");
        System.out.println("1 - Listar acervo");
        System.out.println("2 - Emprestar item");
        System.out.println("3 - Devolver item");
        System.out.println("4 - Alterar configurações (prazo e multa)");
        System.out.println("5 - Ver log do sistema");
        System.out.println("6 - Provar que o Singleton é único");
        System.out.println("0 - Sair");
    }

    private static void executar(int opcao, Scanner in, Biblioteca b, ConfiguracaoBiblioteca config) {
        switch (opcao) {
            case 1:
                b.listarAcervo().forEach(System.out::println);
                break;
            case 2:
                System.out.println("Usuários: " + b.listarUsuarios());
                int itemId = lerInt(in, "ID do item: ");
                int usuarioId = lerInt(in, "ID do usuário: ");
                System.out.println("Empréstimo realizado: " + b.emprestar(itemId, usuarioId));
                break;
            case 3:
                int id = lerInt(in, "ID do item: ");
                int dias = lerInt(in, "Quantos dias a partir de hoje? (0 = hoje; use um valor alto para simular atraso): ");
                double multa = b.devolver(id, LocalDate.now().plusDays(dias));
                System.out.printf("Item devolvido. Multa: R$ %.2f%n", multa);
                break;
            case 4:
                System.out.println("Atual: prazo = " + config.getDiasEmprestimo()
                        + " dias, multa = R$ " + String.format("%.2f", config.getMultaPorDia()));
                int novoPrazo = lerInt(in, "Novo prazo (dias): ");
                double novaMulta = lerDouble(in, "Nova multa por dia (R$): ");
                b.atualizarConfiguracao(novoPrazo, novaMulta);
                System.out.println("Configurações atualizadas.");
                break;
            case 5:
                LogSistema.getInstancia().getRegistros().forEach(System.out::println);
                break;
            case 6:
                provarSingleton();
                break;
            case 0:
                System.out.println("Até logo!");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    /** Demonstra que várias chamadas, inclusive de threads diferentes, devolvem o mesmo objeto. */
    private static void provarSingleton() {
        ConfiguracaoBiblioteca a = ConfiguracaoBiblioteca.getInstancia();
        ConfiguracaoBiblioteca b = ConfiguracaoBiblioteca.getInstancia();
        System.out.println("a == b ? " + (a == b));
        System.out.println("hash de a: " + System.identityHashCode(a));
        System.out.println("hash de b: " + System.identityHashCode(b));

        Set<Integer> hashes = ConcurrentHashMap.newKeySet();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> hashes.add(System.identityHashCode(ConfiguracaoBiblioteca.getInstancia())));
            threads.add(t);
            t.start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("10 threads obtiveram " + hashes.size() + " instância(s) distinta(s).");
    }

    private static int lerInt(Scanner in, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String linha = in.nextLine().trim();
            try {
                return Integer.parseInt(linha);
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    private static double lerDouble(Scanner in, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String linha = in.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(linha);
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }
    }
}
