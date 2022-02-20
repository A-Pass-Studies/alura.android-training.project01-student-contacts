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
        Aluno alunoSalvo = getById(aluno.getId());
        if(alunoSalvo != null)  {
            alunos.set(alunos.indexOf(alunoSalvo), aluno);
        }
    }

    @Override
    public Aluno getById(int id) {
        for (Aluno aluno: alunos) {
            if(aluno.getId() == id) {
                return aluno;
            }
        }
        return null;
    }

    @Override
    public void remove(Aluno aluno) {
        Aluno alunoSalvo = getById(aluno.getId());
        if(alunoSalvo != null) {
            alunos.remove(alunoSalvo);
        }
    }

    @Override
    public List<Aluno> getAll() {
        return new ArrayList<>(alunos);
    }
}
