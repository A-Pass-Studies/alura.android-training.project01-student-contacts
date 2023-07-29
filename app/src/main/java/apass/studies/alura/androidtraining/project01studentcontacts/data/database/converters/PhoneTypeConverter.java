package apass.studies.alura.androidtraining.project01studentcontacts.data.database.converters;

import androidx.annotation.NonNull;
import androidx.room.TypeConverter;

import apass.studies.alura.androidtraining.project01studentcontacts.model.PhoneType;

public final class PhoneTypeConverter {

    @TypeConverter
    public String toString(final PhoneType type) {
        return type.name();
    }

    @TypeConverter
    public PhoneType toPhoneType(final String typeName) {
        return PhoneType.valueOf(typeName);
    }
}
