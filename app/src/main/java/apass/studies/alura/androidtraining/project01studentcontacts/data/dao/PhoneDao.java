package apass.studies.alura.androidtraining.project01studentcontacts.data.dao;

import androidx.annotation.Nullable;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import apass.studies.alura.androidtraining.project01studentcontacts.model.Phone;

@Dao
public interface PhoneDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Phone phone);

    @Nullable
    @Query("SELECT * FROM Phone WHERE studentId = :studentId ORDER BY id")
    List<Phone> getPhonesByStudent(Long studentId);
}
