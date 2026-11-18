import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Serviço principal do sistema.
 *
 * Responsabilidade: coordenar as regras de empréstimo e devolução.
 *
 * Todas as dependências chegam pelo construtor como abstrações ou objetos
 * recebidos de fora (injeção de dependência). Quem decide usar os Singletons
 * é a classe Main. A Biblioteca em si não chama getInstancia(), o que mantém
 * o código testável e respeita o Princípio da Inversão de Dependência.
 */
public class Biblioteca {

    private final ConfiguracaoBiblioteca config;
    private final Registrador registrador;
    private final CalculadoraMulta calculadoraMulta;

    private final Map<Integer, Item> acervo = new LinkedHashMap<>();
    private final Map<Integer, Usuario> usuarios = new LinkedHashMap<>();
    private final List<Emprestimo> emprestimos = new ArrayList<>();

    public Biblioteca(ConfiguracaoBiblioteca config, Registrador registrador, CalculadoraMulta calculadoraMulta) {
        this.config = config;
        this.registrador = registrador;
        this.calculadoraMulta = calculadoraMulta;
    }

    public void adicionarItem(Item item) {
        acervo.put(item.getId(), item);
        registrador.registrar("Item adicionado ao acervo: " + item.getTitulo());
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
        registrador.registrar("Usuário cadastrado: " + usuario.getNome());
    }

    public List<Item> listarAcervo() {
        return new ArrayList<>(acervo.values());
    }

    public List<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios.values());
    }

    public Emprestimo emprestar(int itemId, int usuarioId) {
        Item item = acervo.get(itemId);
        Usuario usuario = usuarios.get(usuarioId);
        if (item == null) {
            throw new IllegalArgumentException("Item " + itemId + " não encontrado.");
        }
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário " + usuarioId + " não encontrado.");
        }
        if (!item.isDisponivel()) {
            throw new IllegalStateException("O item \"" + item.getTitulo() + "\" já está emprestado.");
        }

        int prazo = Math.max(1, (int) Math.round(config.getDiasEmprestimo() * item.getFatorPrazo()));
        Emprestimo emprestimo = new Emprestimo(item, usuario, LocalDate.now(), prazo);
        item.setDisponivel(false);
        emprestimos.add(emprestimo);

        registrador.registrar("Empréstimo: \"" + item.getTitulo() + "\" para " + usuario.getNome()
                + " (prazo: " + prazo + " dias)");
        return emprestimo;
    }

    /** Devolve o item e retorna o valor da multa (0 se estiver em dia). */
    public double devolver(int itemId, LocalDate dataDevolucao) {
        Emprestimo emprestimo = emprestimos.stream()
                .filter(e -> e.isAtivo() && e.getItem().getId() == itemId)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Não há empréstimo ativo para o item " + itemId + "."));

        long atraso = emprestimo.diasDeAtraso(dataDevolucao);
        double multa = calculadoraMulta.calcular(atraso);

        emprestimo.devolver(dataDevolucao);
        emprestimo.getItem().setDisponivel(true);

        registrador.registrar("Devolução: \"" + emprestimo.getItem().getTitulo() + "\" por "
                + emprestimo.getUsuario().getNome() + " (atraso: " + atraso + " dias, multa: R$ "
                + String.format("%.2f", multa) + ")");
        return multa;
    }

    public void atualizarConfiguracao(int diasEmprestimo, double multaPorDia) {
        config.setDiasEmprestimo(diasEmprestimo);
        config.setMultaPorDia(multaPorDia);
        registrador.registrar("Configuração alterada: prazo = " + diasEmprestimo
                + " dias, multa = R$ " + String.format("%.2f", multaPorDia) + " por dia");
    }
}
