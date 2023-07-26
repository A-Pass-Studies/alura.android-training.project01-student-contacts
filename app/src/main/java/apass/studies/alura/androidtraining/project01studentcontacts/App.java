package apass.studies.alura.androidtraining.project01studentcontacts;

import android.app.Application;

import apass.studies.alura.androidtraining.project01studentcontacts.dao.AlunoDAO;
import apass.studies.alura.androidtraining.project01studentcontacts.dao.AlunoDAOImpl;
import apass.studies.alura.androidtraining.project01studentcontacts.model.Aluno;

public class App extends Application {

    private AlunoDAO alunoDAO = new AlunoDAOImpl();

    @Override
    public void onCreate() {
        super.onCreate();

        mockAlunos();
    }

    private void mockAlunos() {
        alunoDAO.salva(new Aluno("Jão", "1234455678", "joao@email.com"));
        alunoDAO.salva(new Aluno("Maria", "1234455678", "joao@email.com"));
        alunoDAO.salva(new Aluno("Jose", "1234455678", "joao@email.com"));
        alunoDAO.salva(new Aluno("mateus", "1234455678", "joao@email.com"));
    }
}
