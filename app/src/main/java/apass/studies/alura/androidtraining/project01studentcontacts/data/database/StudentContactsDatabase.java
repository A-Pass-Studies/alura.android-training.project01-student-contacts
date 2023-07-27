package apass.studies.alura.androidtraining.project01studentcontacts.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import apass.studies.alura.androidtraining.project01studentcontacts.data.dao.StudentDao;
import apass.studies.alura.androidtraining.project01studentcontacts.model.Student;

@Database(entities = {Student.class}, version = 1, exportSchema = false)
public abstract class StudentContactsDatabase extends RoomDatabase {
    private static StudentContactsDatabase instance;

    public abstract StudentDao getStudentDao();

    public static StudentContactsDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, StudentContactsDatabase.class, "project01studentcontacts")
                    .allowMainThreadQueries() // TODO: remove, implement assync
                    .fallbackToDestructiveMigration() // TODO: remove to prod
                    .build();
        }

        return instance;
    }
}
