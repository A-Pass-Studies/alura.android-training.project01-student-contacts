package apass.studies.alura.androidtraining.project01studentcontacts;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.core.os.HandlerCompat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import apass.studies.alura.androidtraining.project01studentcontacts.data.dao.StudentDao;
import apass.studies.alura.androidtraining.project01studentcontacts.data.database.StudentContactsDatabase;
import apass.studies.alura.androidtraining.project01studentcontacts.model.Student;

public final class App extends Application {

    private StudentDao studentDao;

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final Handler mainThreadHandler = HandlerCompat.createAsync(Looper.getMainLooper());
    @Override
    public void onCreate() {
        super.onCreate();

        studentDao = StudentContactsDatabase.getInstance(this.getApplicationContext()).getStudentDao();
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }

    public Handler getMainThreadHandler() {
        return mainThreadHandler;
    }
}
