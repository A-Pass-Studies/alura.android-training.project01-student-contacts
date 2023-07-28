package apass.studies.alura.androidtraining.project01studentcontacts.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Student implements Serializable {

    private String lastName;
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String phone;

    private String email;

    public Student(final String name, final String phone, final String email, final String lastName) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.lastName = lastName;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
    @NonNull
    @Override
    public String toString() {
        return name;
    }


}
