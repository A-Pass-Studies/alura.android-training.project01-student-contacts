package apass.studies.alura.androidtraining.project01studentcontacts.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import apass.studies.alura.androidtraining.project01studentcontacts.model.Student;

@Dao
public interface StudentDao {
    @Insert
    void insert(Student student);

    @Update
    void update(Student student);

    @Delete
    void delete(Student student);

    @Query("SELECT * FROM student")
    List<Student> getAll();

}
