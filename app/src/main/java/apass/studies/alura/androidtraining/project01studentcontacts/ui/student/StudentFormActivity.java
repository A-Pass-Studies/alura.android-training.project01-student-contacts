package apass.studies.alura.androidtraining.project01studentcontacts.ui.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.EditText;

import apass.studies.alura.androidtraining.project01studentcontacts.R;
import apass.studies.alura.androidtraining.project01studentcontacts.data.dao.StudentDao;
import apass.studies.alura.androidtraining.project01studentcontacts.data.database.StudentContactsDatabase;
import apass.studies.alura.androidtraining.project01studentcontacts.model.Student;

public class StudentFormActivity extends AppCompatActivity {

    public static final String BUNDLE_STUDENT_TO_EDIT = "BUNDLE_STUDENT";
    private EditText nameEdt;

    private EditText lastnameEdt;
    private EditText phoneEdt;
    private EditText emailEdt;

    private StudentDao studentDao = null;
    private Student studentToEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        studentDao = StudentContactsDatabase.getInstance(getApplicationContext()).getStudentDao();

        setTitle((isEditMode() ? getString(R.string.student_form_update_title) : getString(R.string.student_form_new_title)));
        setContentView(R.layout.activity_student_form);
        initViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_student_form, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_student_form_save) {
            finishForm();
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean isEditMode() {
        return getIntent().hasExtra(BUNDLE_STUDENT_TO_EDIT);
    }

    private void setupBundles() {
        if(getIntent().hasExtra(BUNDLE_STUDENT_TO_EDIT)) {
            studentToEdit = (Student) getIntent().getSerializableExtra(BUNDLE_STUDENT_TO_EDIT);
            setFieldsValuesBy(studentToEdit);
        }
    }

    private void setFieldsValuesBy(Student student) {
        nameEdt.setText(student.getName());
        lastnameEdt.setText(student.getLastName());
        emailEdt.setText(student.getEmail());
        phoneEdt.setText(student.getPhone());
    }

    private void initViews() {
        nameEdt = findViewById(R.id.activity_student_form_name_edt);
        lastnameEdt = findViewById(R.id.activity_student_form_lastname_edt);
        phoneEdt = findViewById(R.id.activity_student_form_phone_etd);
        emailEdt = findViewById(R.id.activity_student_form_email_edt);

        setupBundles();
    }

    private void finishForm() {
        if(studentToEdit == null) {
            studentDao.insert(new Student(getNameFieldValue(), getPhoneFieldValue(), getEmailFieldValue(), getLastnameFieldValue()));
        } else  {
            studentToEdit.setEmail(getEmailFieldValue());
            studentToEdit.setName(getNameFieldValue());
            studentToEdit.setPhone(getPhoneFieldValue());
            studentToEdit.setLastName(getLastnameFieldValue());
            studentDao.update(studentToEdit);
        }
        finish();
    }

    private String getLastnameFieldValue() {
        return lastnameEdt.getText().toString();
    }

    @NonNull
    private String getNameFieldValue() {
        return nameEdt.getText().toString();
    }

    @NonNull
    private String getPhoneFieldValue() {
        return phoneEdt.getText().toString();
    }

    @NonNull
    private String getEmailFieldValue() {
        return emailEdt.getText().toString();
    }
}
