public class Livro extends Item {

    private final String autor;

    public Livro(int id, String titulo, String autor) {
        super(id, titulo);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public double getFatorPrazo() {
        return 1.0;
    }

    @Override
    public String getTipo() {
        return "Livro";
    }

    @Override
    public String toString() {
        return super.toString() + " (autor: " + autor + ")";
    }
}
