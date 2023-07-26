package apass.studies.alura.androidtraining.project01studentcontacts.dao;

import java.util.List;

import apass.studies.alura.androidtraining.project01studentcontacts.model.Aluno;

public interface AlunoDAO {
    void salva(Aluno aluno);

    void edita(Aluno aluno);

    void remove(Aluno aluno);

    Aluno getById(int id);

    List<Aluno> getAll();

}
