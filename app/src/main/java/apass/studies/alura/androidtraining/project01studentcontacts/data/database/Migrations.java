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

    static Migration migrate_00003_00004() {
        return new Migration(3, 4) {
            @Override
            public void migrate(@NonNull SupportSQLiteDatabase db) {
                db.execSQL("CREATE TABLE `StudentTmp` (" +
                        "`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                        "`name` TEXT, " +
                        "`phone` TEXT, " +
                        "`email` TEXT," +
                        "`createdAt` INTEGER)");
                db.execSQL("INSERT INTO StudentTmp(id, name, phone, email, createdAt)" +
                        "SELECT id, name, phone, email, CURRENT_TIMESTAMP FROM Student");
                db.execSQL("DROP TABLE Student");
                db.execSQL("ALTER TABLE StudentTmp RENAME TO Student");
            }
        };
    }

    static Migration migrate_00004_00005() {
        return new Migration(4, 5) {
            @Override
            public void migrate(@NonNull SupportSQLiteDatabase db) {
                db.execSQL("ALTER TABLE Student RENAME TO StudentOld");

                db.execSQL("CREATE TABLE `Student` (" +
                        "`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                        "`name` TEXT, " +
                        "`email` TEXT," +
                        "`createdAt` INTEGER);");

                db.execSQL("INSERT INTO Student(id, name, email, createdAt)" +
                        "SELECT id, name, email, createdAt " +
                        "FROM StudentOld;");

                db.execSQL("CREATE TABLE IF NOT EXISTS `Phone` (" +
                        "`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                        "`studentId` INTEGER NOT NULL, " +
                        "`type` TEXT NOT NULL, " +
                        "`number` TEXT NOT NULL, " +
                        "`isMain` INTEGER NOT NULL DEFAULT 0, " +
                        "CONSTRAINT `phone_student_fk` FOREIGN KEY(`studentId`) REFERENCES `Student`(`id`) " +
                            "ON UPDATE CASCADE ON DELETE CASCADE);");

                db.execSQL("INSERT INTO `Phone` (`id`, `studentId`, `type`, `number`, `isMain`) " +
                        "SELECT null, id, 'UNKNOW', phone, 1 FROM `StudentOld`" +
                        "ORDER BY id ASC;");

                db.execSQL("DROP TABLE StudentOld");
            }
        };
    }
}
