package apass.studies.alura.androidtraining.project01studentcontacts.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Embedded;
import androidx.room.Relation;

import org.jetbrains.annotations.NotNull;

public class StudentWithMainPhone {

    @NonNull
    @Embedded
    public final Student student;

    @Nullable
    @Relation(entityColumn = "studentId", parentColumn = "id")
    public final Phone phone;

    public StudentWithMainPhone(@NotNull final Student student, @Nullable final Phone phone) {
        this.student = student;
        this.phone = phone;
    }
}
