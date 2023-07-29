package apass.studies.alura.androidtraining.project01studentcontacts.ui.student.listing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import apass.studies.alura.androidtraining.project01studentcontacts.R;
import apass.studies.alura.androidtraining.project01studentcontacts.model.Student;
import apass.studies.alura.androidtraining.project01studentcontacts.model.StudentWithMainPhone;

public class StudentListAdapter extends BaseAdapter {

    private final List<StudentWithMainPhone> students = new ArrayList<>();

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public StudentWithMainPhone getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return students.get(position).student.getId();
    }

    @Override
    public View getView(int position, View view, @NonNull ViewGroup viewGroup) {
        View vw = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_student, viewGroup, false);

        final StudentWithMainPhone studentAndMainPhone = students.get(position);

        ((TextView) vw.findViewById(R.id.item_student_name_tv))
                .setText(studentAndMainPhone.student.getName());

        if (studentAndMainPhone.phone != null) {
            ((TextView) vw.findViewById(R.id.item_student_phone_tv))
                    .setText(studentAndMainPhone.phone.getNumber());
        }
        return vw;
    }

    public void update(List<StudentWithMainPhone> studentsAndMainPhone) {
        this.students.clear();
        this.students.addAll(studentsAndMainPhone);
        notifyDataSetChanged();
    }

    public void remove(Student student) {
        students.remove(student);
        notifyDataSetChanged();
    }
}
