package questao01;

import java.util.ArrayList;
import java.util.List;

/** Responsabilidade única: cadastro e consulta de alunos. */
public class GestaoAlunos {

    private final List<Aluno> alunos = new ArrayList<>();

    public Aluno cadastrar(String nome, String email) {
        Aluno aluno = new Aluno(nome, email);
        alunos.add(aluno);
        return aluno;
    }

    public List<Aluno> listar() {
        return new ArrayList<>(alunos);
    }
}
