public class Revista extends Item {

    private final int edicao;

    public Revista(int id, String titulo, int edicao) {
        super(id, titulo);
        this.edicao = edicao;
    }

    public int getEdicao() {
        return edicao;
    }

    /** Revistas têm prazo de empréstimo menor: metade do prazo padrão. */
    @Override
    public double getFatorPrazo() {
        return 0.5;
    }

    @Override
    public String getTipo() {
        return "Revista";
    }

    @Override
    public String toString() {
        return super.toString() + " (edição: " + edicao + ")";
    }
}
