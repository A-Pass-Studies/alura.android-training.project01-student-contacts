package br.com.alura.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.model.Aluno;

public class AlunoDAOImpl implements AlunoDAO {

    private static List<Aluno> alunos = new ArrayList<>();

    @Override
    public void salva(Aluno aluno) {
        alunos.add(aluno);
    }

    @Override
    public List<Aluno> getAll() {
        return new ArrayList<>(alunos);
    }
}
