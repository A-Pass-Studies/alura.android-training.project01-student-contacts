package apass.studies.alura.androidtraining.project01studentcontacts;

import android.app.Application;

import apass.studies.alura.androidtraining.project01studentcontacts.data.dao.StudentDao;
import apass.studies.alura.androidtraining.project01studentcontacts.data.database.StudentContactsDatabase;
import apass.studies.alura.androidtraining.project01studentcontacts.model.Student;

public class App extends Application {

    private StudentDao studentDao;

    @Override
    public void onCreate() {
        super.onCreate();

        studentDao = StudentContactsDatabase.getInstance(this.getApplicationContext()).getStudentDao();

        mockStudents();
    }

    private void mockStudents() {
        studentDao.insert(new Student("Jão", "1234455678", "joao@email.com"));
        studentDao.insert(new Student("Maria", "1234455678", "joao@email.com"));
        studentDao.insert(new Student("Jose", "1234455678", "joao@email.com"));
        studentDao.insert(new Student("mateus", "1234455678", "joao@email.com"));
    }
}
