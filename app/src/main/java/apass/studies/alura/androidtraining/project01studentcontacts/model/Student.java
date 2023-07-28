package apass.studies.alura.androidtraining.project01studentcontacts.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
public class Student implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String phone;

    private String email;

    @Nullable
    private Calendar createdAt;

    public Student(final String name, final String phone, final String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.createdAt = Calendar.getInstance();
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
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
        return new SimpleDateFormat("dd/MM/yyyy").format(createdAt.getTime());
    }
}
