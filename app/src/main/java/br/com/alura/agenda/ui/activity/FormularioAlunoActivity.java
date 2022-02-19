package br.com.alura.agenda.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.alura.agenda.R;
import br.com.alura.agenda.dao.AlunoDAO;
import br.com.alura.agenda.dao.AlunoDAOImpl;
import br.com.alura.agenda.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    static String BUNDLE_ALUNO_TO_EDIT = "BUNDLE_ALUNO";
    private EditText edtNome;
    private EditText edtTelefone;
    private EditText edtEmail;
    private Button btnSalvar;

    private AlunoDAO alunoDAO = new AlunoDAOImpl();
    private Aluno alunoToEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle((isEditMode() ? "Atualiza" : "Novo") + " Aluno");
        setContentView(R.layout.activity_formulario_aluno);
        initViews();
    }

    private boolean isEditMode() {
        return getIntent().hasExtra(BUNDLE_ALUNO_TO_EDIT);
    }

    private void setupBundles() {
        if(getIntent().hasExtra(BUNDLE_ALUNO_TO_EDIT)) {
            alunoToEdit = (Aluno) getIntent().getSerializableExtra(BUNDLE_ALUNO_TO_EDIT);
            setFieldsValuesBy(alunoToEdit);
        }
    }

    private void setFieldsValuesBy(Aluno aluno) {
        edtNome.setText(aluno.getNome());
        edtEmail.setText(aluno.getEmail());
        edtTelefone.setText(aluno.getTelefone());
    }

    private void initViews() {
        edtNome = findViewById(R.id.activity_formulario_aluno_nome);
        edtTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        edtEmail = findViewById(R.id.activity_formulario_aluno_email);
        btnSalvar = findViewById(R.id.activity_formulario_aluno_btn_salvar);
        btnSalvar.setOnClickListener(this::onClickBtnSalvar);

        setupBundles();
    }

    private void onClickBtnSalvar(View view) {
        if(alunoToEdit == null) {
            alunoDAO.salva(new Aluno(getNome(), getTelefone(), getEmail()));
        } else  {
            alunoToEdit.setEmail(getEmail());
            alunoToEdit.setNome(getNome());
            alunoToEdit.setTelefone(getTelefone());
            alunoDAO.edita(alunoToEdit);
        }
        finish();
    }

    @NonNull
    private String getNome() {
        return edtNome.getText().toString();
    }

    @NonNull
    private String getTelefone() {
        return edtTelefone.getText().toString();
    }

    @NonNull
    private String getEmail() {
        return edtEmail.getText().toString();
    }
}