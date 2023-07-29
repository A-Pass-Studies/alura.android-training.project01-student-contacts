package apass.studies.alura.androidtraining.project01studentcontacts.ui.student;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import apass.studies.alura.androidtraining.project01studentcontacts.R;
import apass.studies.alura.androidtraining.project01studentcontacts.data.dao.PhoneDao;
import apass.studies.alura.androidtraining.project01studentcontacts.data.dao.StudentDao;
import apass.studies.alura.androidtraining.project01studentcontacts.data.database.StudentContactsDatabase;
import apass.studies.alura.androidtraining.project01studentcontacts.model.Phone;
import apass.studies.alura.androidtraining.project01studentcontacts.model.PhoneType;
import apass.studies.alura.androidtraining.project01studentcontacts.model.Student;

public class StudentFormActivity extends AppCompatActivity {

    public static final String BUNDLE_STUDENT_TO_EDIT = "BUNDLE_STUDENT";
    private EditText nameEdt;

    private EditText phoneEdt;
    private EditText emailEdt;

    private StudentDao studentDao = null;

    private PhoneDao phoneDao = null;
    private Student studentToEdit;
    private List<Phone> phonesOfstudentToEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        studentDao = StudentContactsDatabase.getInstance(this).getStudentDao();
        phoneDao = StudentContactsDatabase.getInstance(this).getPhoneDao();

        setTitle((isEditMode() ? getString(R.string.student_form_update_title) : getString(R.string.student_form_new_title)));
        setContentView(R.layout.activity_student_form);
        initViews();
        retriveDataOfStudentToEdit();
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

    private void retriveDataOfStudentToEdit() {
        if (getIntent().hasExtra(BUNDLE_STUDENT_TO_EDIT)) {
            studentToEdit = (Student) getIntent().getSerializableExtra(BUNDLE_STUDENT_TO_EDIT);
            phonesOfstudentToEdit = phoneDao.getPhonesByStudent(studentToEdit.getId());
            setFieldsValuesBy(studentToEdit);
        }
    }

    private void setFieldsValuesBy(Student student) {
        nameEdt.setText(student.getName());
        emailEdt.setText(student.getEmail());
        if (phonesOfstudentToEdit != null && phonesOfstudentToEdit.size() > 0) {
            phoneEdt.setText(phonesOfstudentToEdit.get(0).getNumber());
        }
    }

    private void initViews() {
        nameEdt = findViewById(R.id.activity_student_form_name_edt);
        phoneEdt = findViewById(R.id.activity_student_form_phone_etd);
        emailEdt = findViewById(R.id.activity_student_form_email_edt);
    }

    private void finishForm() {
        if (studentToEdit == null) {
            // creating new student

            final Student newStudent = new Student(getNameFieldValue(), getEmailFieldValue());

            StudentContactsDatabase.getInstance(this).runInTransaction(() -> {
                newStudent.setId(studentDao.insert(newStudent));
                Phone phone = new Phone(newStudent.getId(), PhoneType.UNKNOW, getPhoneFieldValue());
                phoneDao.insert(phone);
            });

        } else {
            // editing student
            studentToEdit.setEmail(getEmailFieldValue());
            studentToEdit.setName(getNameFieldValue());

            final Phone phone;
            if (!phonesOfstudentToEdit.isEmpty()) {
                phone = new Phone(studentToEdit.getId(), PhoneType.UNKNOW, getPhoneFieldValue());
                phone.setMain(true);
                phone.setId(phonesOfstudentToEdit.get(0).getId());
            } else {
                phone = null;
            }

            StudentContactsDatabase.getInstance(this).runInTransaction(() -> {
                studentDao.update(studentToEdit);
                if (phone != null)
                    phoneDao.insert(phone);
            });
        }
        finish();
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
