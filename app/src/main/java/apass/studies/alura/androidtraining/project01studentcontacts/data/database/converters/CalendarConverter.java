package apass.studies.alura.androidtraining.project01studentcontacts.data.database.converters;

import androidx.room.TypeConverter;

import java.util.Calendar;

public final class CalendarConverter {
    @TypeConverter
    public Long toLong(final Calendar value) {
        if(value == null) {
            return null;
        }
        return value.getTimeInMillis();
    }

    @TypeConverter
    public Calendar toCalendar(final Long value) {
        if(value == null) {
            return null;
        }
        final Calendar dateTime = Calendar.getInstance();
        dateTime.setTimeInMillis(value);
        return dateTime;
    }
}
