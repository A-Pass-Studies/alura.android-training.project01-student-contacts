package br.com.alura.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.model.Aluno;

public class AlunoDAOImpl implements AlunoDAO {

    private static List<Aluno> alunos = new ArrayList<>();
    private static Integer contatorDeIds = 1;

    @Override
    public void salva(Aluno aluno) {
        aluno.setId(contatorDeIds);
        alunos.add(aluno);
        contatorDeIds++;
    }

    @Override
    public void edita(Aluno aluno) {
        for (Aluno alunoSalvo: alunos) {
            if(alunoSalvo.getId() == aluno.getId()) {
                alunos.set(alunos.indexOf(alunoSalvo), aluno);
            }
        }
    }

    @Override
    public List<Aluno> getAll() {
        return new ArrayList<>(alunos);
    }
}
