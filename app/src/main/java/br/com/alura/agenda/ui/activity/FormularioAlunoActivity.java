package br.com.alura.agenda.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.alura.agenda.R;
import br.com.alura.agenda.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtTelefone;
    private EditText edtEmail;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);

        initViews();
    }

    private void initViews() {
        edtNome = findViewById(R.id.activity_formulario_aluno_nome);

        edtTelefone = findViewById(R.id.activity_formulario_aluno_telefone);

        edtEmail = findViewById(R.id.activity_formulario_aluno_email);

        btnSalvar = findViewById(R.id.activity_formulario_aluno_btn_salvar);
        btnSalvar.setOnClickListener(this::onClickBtnSalvar);
    }

    private void onClickBtnSalvar(View view) {
        Aluno alunoCriado = new Aluno(getNome(), getTelefone(), getEmail());
        Toast.makeText(
                this,
                "Nome: " + alunoCriado.getNome() +
                "\nTelefone: " + alunoCriado.getTelefone() +
                "\nE-mail: " + alunoCriado.getEmail(),
                Toast.LENGTH_LONG)
        .show();
    }

    private String getNome() {
        return edtNome.getText().toString();
    }

    private String getTelefone() {
        return edtTelefone.getText().toString();
    }

    private String getEmail() {
        return edtEmail.getText().toString();
    }
}