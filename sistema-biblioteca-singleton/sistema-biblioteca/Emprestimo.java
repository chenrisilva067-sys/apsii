import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {

    private final Item item;
    private final Usuario usuario;
    private final LocalDate dataEmprestimo;
    private final LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucao;

    public Emprestimo(Item item, Usuario usuario, LocalDate dataEmprestimo, int prazoEmDias) {
        this.item = item;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevistaDevolucao = dataEmprestimo.plusDays(prazoEmDias);
    }

    public Item getItem() {
        return item;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public boolean isAtivo() {
        return dataDevolucao == null;
    }

    public void devolver(LocalDate data) {
        this.dataDevolucao = data;
    }

    public long diasDeAtraso(LocalDate dataReferencia) {
        long dias = ChronoUnit.DAYS.between(dataPrevistaDevolucao, dataReferencia);
        return Math.max(dias, 0);
    }

    @Override
    public String toString() {
        return String.format("%s emprestado a %s em %s (devolver até %s)",
                item.getTitulo(), usuario.getNome(), dataEmprestimo, dataPrevistaDevolucao);
    }
}
