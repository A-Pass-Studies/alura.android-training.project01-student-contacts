package br.com.alura.agenda;

import android.app.Application;

import br.com.alura.agenda.dao.AlunoDAO;
import br.com.alura.agenda.dao.AlunoDAOImpl;
import br.com.alura.agenda.model.Aluno;

public class App extends Application {

    private AlunoDAO alunoDAO = new AlunoDAOImpl();

    @Override
    public void onCreate() {
        super.onCreate();

        for(int i =0; i < 10; i++)
            mockAlunos();
    }

    private void mockAlunos() {
        alunoDAO.salva(new Aluno("Jão", "1234455678", "joao@email.com"));
        alunoDAO.salva(new Aluno("Maria", "1234455678", "joao@email.com"));
        alunoDAO.salva(new Aluno("Jose", "1234455678", "joao@email.com"));
        alunoDAO.salva(new Aluno("mateus", "1234455678", "joao@email.com"));
    }
}
