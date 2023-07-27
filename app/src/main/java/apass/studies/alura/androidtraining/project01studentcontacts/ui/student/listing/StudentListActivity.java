package apass.studies.alura.androidtraining.project01studentcontacts.ui.student.listing;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import apass.studies.alura.androidtraining.project01studentcontacts.R;
import apass.studies.alura.androidtraining.project01studentcontacts.data.dao.StudentDao;
import apass.studies.alura.androidtraining.project01studentcontacts.data.database.StudentContactsDatabase;
import apass.studies.alura.androidtraining.project01studentcontacts.model.Student;
import apass.studies.alura.androidtraining.project01studentcontacts.ui.student.StudentFormActivity;

public class StudentListActivity extends AppCompatActivity {

    private  StudentDao studentDao = null;

    private StudentListAdapter studentListVwAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getString(R.string.activity_student_listing_title));
        setContentView(R.layout.activity_student_listing);

        studentDao = StudentContactsDatabase.getInstance(getApplicationContext()).getStudentDao();
        initViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        studentListVwAdapter.update(studentDao.getAll());
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_student_listing, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_student_listing) {
            setupRemoveConfirmationDialog(item);
        }
        return super.onContextItemSelected(item);
    }

    private void setupRemoveConfirmationDialog(MenuItem item) {
        AdapterView.AdapterContextMenuInfo adapterInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Student student = studentListVwAdapter.getItem(adapterInfo.position);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle(R.string.dialog_confirmation_of_remove_student_title)
                .setMessage(getString(R.string.message_dialog_remove_student, student.getName()))
                .setPositiveButton(R.string.yes, (dialogInterface, i) -> {
                    studentDao.delete(student);
                    studentListVwAdapter.remove(student);
                })
                .setNegativeButton(R.string.not, null).create();
        dialog.show();
    }

    private void initViews() {

        configureStudentListView();

        FloatingActionButton addStudentFab = findViewById(R.id.activity_student_listing_add_student_fab);
        addStudentFab.setOnClickListener(this::onClickBtnAddStudent);
    }

    private void configureStudentListView() {
        ListView studentLv = findViewById(R.id.activity_student_listing_lv);
        studentListVwAdapter = new StudentListAdapter();
        studentLv.setAdapter(studentListVwAdapter);
        studentLv.setOnItemClickListener(this::onClickStudentItem);
        registerForContextMenu(studentLv);
    }

    private void onClickStudentItem(final AdapterView<?> adapterView, View view, final int position, final long id) {
        startActivity(
                new Intent(this, StudentFormActivity.class)
                        .putExtra(StudentFormActivity.BUNDLE_STUDENT_TO_EDIT, (Student) adapterView.getItemAtPosition(position)));

    }

    private void onClickBtnAddStudent(final View view) {
        startActivity(new Intent(this, StudentFormActivity.class));
    }
}