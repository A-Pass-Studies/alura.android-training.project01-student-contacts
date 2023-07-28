package apass.studies.alura.androidtraining.project01studentcontacts.data.database;

import static apass.studies.alura.androidtraining.project01studentcontacts.data.database.Migrations.migrate_00001_00002;
import static apass.studies.alura.androidtraining.project01studentcontacts.data.database.Migrations.migrate_00002_00003;
import static apass.studies.alura.androidtraining.project01studentcontacts.data.database.Migrations.migrate_00003_00004;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import apass.studies.alura.androidtraining.project01studentcontacts.data.dao.StudentDao;
import apass.studies.alura.androidtraining.project01studentcontacts.data.database.converters.CalendarConverter;
import apass.studies.alura.androidtraining.project01studentcontacts.model.Student;

@Database(entities = {Student.class}, version = 4, exportSchema = false)
@TypeConverters({CalendarConverter.class})
public abstract class StudentContactsDatabase extends RoomDatabase {
    private static StudentContactsDatabase instance;

    public abstract StudentDao getStudentDao();

    public static StudentContactsDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, StudentContactsDatabase.class, "project01studentcontacts")
                    .allowMainThreadQueries() // TODO: remove, implement async
                    .addMigrations(
                            migrate_00001_00002(),
                            migrate_00002_00003(),
                            migrate_00003_00004()
                    )
                    .build();
        }

        return instance;
    }
}
