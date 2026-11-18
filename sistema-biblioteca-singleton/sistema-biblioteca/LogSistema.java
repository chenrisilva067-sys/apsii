import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * SINGLETON #2 - Log de auditoria do sistema.
 *
 * Todos os eventos (empréstimos, devoluções, mudanças de configuração) precisam
 * ir para o MESMO histórico. Se cada classe criasse seu próprio log, o histórico
 * ficaria fragmentado. Por isso uma única instância compartilhada faz sentido.
 *
 * Mesma técnica de ConfiguracaoBiblioteca (holder) e métodos synchronized,
 * pois a lista interna pode ser acessada por várias threads.
 */
public class LogSistema implements Registrador {

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private final List<String> registros = new ArrayList<>();

    private LogSistema() {
    }

    private static class Holder {
        private static final LogSistema INSTANCIA = new LogSistema();
    }

    public static LogSistema getInstancia() {
        return Holder.INSTANCIA;
    }

    @Override
    public synchronized void registrar(String mensagem) {
        registros.add("[" + LocalDateTime.now().format(FORMATO) + "] " + mensagem);
    }

    public synchronized List<String> getRegistros() {
        return Collections.unmodifiableList(new ArrayList<>(registros));
    }
}
