package apass.studies.alura.androidtraining.project01studentcontacts.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
public class Student implements Serializable {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String name;

    private String email;

    @Nullable
    private Calendar createdAt;

    public Student(final String name, final String email) {
        this.name = name;
        this.email = email;
        this.createdAt = Calendar.getInstance();
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(@Nullable final Calendar createdAt) {
        this.createdAt = createdAt;
    }

    public String getFormattedCreatedAt() {
        if(createdAt == null) {
            return null;
        }
        return new SimpleDateFormat("dd/MM/yyyy").format(createdAt.getTime());
    }
}
