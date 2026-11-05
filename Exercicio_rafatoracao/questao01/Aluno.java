package questao01;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

    private final String nome;
    private final String email;
    private final List<Double> notas = new ArrayList<>();

    public Aluno(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void adicionarNota(double nota) {
        notas.add(nota);
    }
}
