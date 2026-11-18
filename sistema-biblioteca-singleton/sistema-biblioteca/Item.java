/**
 * Item do acervo (classe abstrata).
 *
 * Cada tipo de item define o seu fator de prazo. Assim, novos tipos podem ser
 * criados sem mudar a Biblioteca (OCP), e qualquer subclasse pode ser usada
 * no lugar de Item sem quebrar o sistema (LSP).
 */
public abstract class Item {

    private final int id;
    private final String titulo;
    private boolean disponivel = true;

    protected Item(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    /** Multiplicador aplicado ao prazo padrão de empréstimo (1.0 = prazo normal). */
    public abstract double getFatorPrazo();

    public abstract String getTipo();

    @Override
    public String toString() {
        return String.format("#%d [%s] %s - %s", id, getTipo(), titulo,
                disponivel ? "disponível" : "emprestado");
    }
}
