package apass.studies.alura.androidtraining.project01studentcontacts.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import apass.studies.alura.androidtraining.project01studentcontacts.model.Student;
import apass.studies.alura.androidtraining.project01studentcontacts.model.StudentWithMainPhone;

@Dao
public interface StudentDao {
    @Insert
    Long insert(Student student);

    @Update
    void update(Student student);

    @Delete
    void delete(Student student);

    @Transaction
    @Query("SELECT * FROM Student")
    List<StudentWithMainPhone> getStudentsWithMainPhone();

}
