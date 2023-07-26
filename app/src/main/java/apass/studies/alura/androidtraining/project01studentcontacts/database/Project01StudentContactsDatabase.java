package apass.studies.alura.androidtraining.project01studentcontacts.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import apass.studies.alura.androidtraining.project01studentcontacts.model.Aluno;

@Database(entities = {Aluno.class}, version = 1)
public abstract class Project01StudentContactsDatabase extends RoomDatabase {
}
