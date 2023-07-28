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

public class StudentListAdapter extends BaseAdapter {

    private final List<Student> students = new ArrayList<>();

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Student getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return students.get(position).getId();
    }

    @Override
    public View getView(int position, View view, @NonNull ViewGroup viewGroup) {
        View vw = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.item_student, viewGroup, false);

        Student student = students.get(position);

        ((TextView)vw.findViewById(R.id.item_student_name_tv)).setText(student.getName() + " " + student.getFormattedCreatedAt());
        ((TextView)vw.findViewById(R.id.item_student_phone_tv)).setText(student.getPhone());

        return vw;
    }

    public void update(List<Student> students) {
        this.students.clear();
        this.students.addAll(students);
        notifyDataSetChanged();
    }

    public void remove(Student student) {
        students.remove(student);
        notifyDataSetChanged();
    }
}
