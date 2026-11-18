/**
 * Abstração para registrar eventos do sistema.
 *
 * Interface pequena e específica (ISP) que permite à Biblioteca depender de
 * uma abstração (DIP) e não diretamente da classe Singleton LogSistema.
 */
public interface Registrador {
    void registrar(String mensagem);
}
