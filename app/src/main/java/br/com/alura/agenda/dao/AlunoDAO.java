package br.com.alura.agenda.dao;

import java.util.List;

import br.com.alura.agenda.model.Aluno;

public interface AlunoDAO {
    void salva(Aluno aluno);

    void edita(Aluno aluno);

    void remove(Aluno aluno);

    Aluno getById(int id);

    List<Aluno> getAll();

}
