package apass.studies.alura.androidtraining.project01studentcontacts.data.database;

import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

final class Migrations {

    static Migration migrate_00001_00002() {
        return new Migration(1, 2) {
            @Override
            public void migrate(@NonNull SupportSQLiteDatabase db) {
                db.execSQL("CREATE TABLE `StudentTmp` (" +
                        "`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                        "`name` TEXT, " +
                        "`lastName` TEXT, " +
                        "`phone` TEXT, " +
                        "`email` TEXT)");
                db.execSQL("INSERT INTO StudentTmp(id, name, lastName, phone, email)" +
                        "SELECT id, name, null, phone, email FROM Student");
                db.execSQL("DROP TABLE Student");
                db.execSQL("ALTER TABLE StudentTmp RENAME TO Student");
            }
        };
    }

    static Migration migrate_00002_00003() {
        return new Migration(2, 3) {
            @Override
            public void migrate(@NonNull SupportSQLiteDatabase db) {
                db.execSQL("CREATE TABLE `StudentTmp` (" +
                        "`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                        "`name` TEXT, " +
                        "`phone` TEXT, " +
                        "`email` TEXT)");
                db.execSQL("INSERT INTO StudentTmp(id, name, phone, email)" +
                        "SELECT id, name, phone, email FROM Student");
                db.execSQL("DROP TABLE Student");
                db.execSQL("ALTER TABLE StudentTmp RENAME TO Student");
            }
        };
    }
}
