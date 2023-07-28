package apass.studies.alura.androidtraining.project01studentcontacts.data.database;

import static apass.studies.alura.androidtraining.project01studentcontacts.data.database.Migrations.migrate_00001_00002;
import static apass.studies.alura.androidtraining.project01studentcontacts.data.database.Migrations.migrate_00002_00003;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import apass.studies.alura.androidtraining.project01studentcontacts.data.dao.StudentDao;
import apass.studies.alura.androidtraining.project01studentcontacts.model.Student;

@Database(entities = {Student.class}, version = 3, exportSchema = false)
public abstract class StudentContactsDatabase extends RoomDatabase {
    private static StudentContactsDatabase instance;

    public abstract StudentDao getStudentDao();

    public static StudentContactsDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, StudentContactsDatabase.class, "project01studentcontacts")
                    .allowMainThreadQueries() // TODO: remove, implement assync
                    .addMigrations(
                            migrate_00001_00002(),
                            migrate_00002_00003()
                    )
                    .build();
        }

        return instance;
    }
}
