package apass.studies.alura.androidtraining.project01studentcontacts.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;


@Entity(foreignKeys = {
        @ForeignKey(entity = Student.class, parentColumns = "id", childColumns = "studentId")
})
public final class Phone {

    @PrimaryKey
    @NonNull
    private Long id;
    @NonNull
    public final Long studentId;
    @NotNull
    private final PhoneType type;
    @NonNull
    private final String number;

    @NonNull
    private boolean isMain = false;

    public Phone(@NonNull final Long studentId, @NonNull final PhoneType type, final String number) {
        this.studentId = studentId;
        this.type = type;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PhoneType getType() {
        return type;
    }

    @NonNull
    public String getNumber() {
        return number;
    }

    public boolean isMain() {
        return isMain;
    }

    public void setMain(final boolean main) {
        isMain = main;
    }
}
