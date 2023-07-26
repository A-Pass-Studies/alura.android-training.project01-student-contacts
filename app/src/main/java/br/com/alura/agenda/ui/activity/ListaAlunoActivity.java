package br.com.alura.agenda.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.R;
import br.com.alura.agenda.dao.AlunoDAO;
import br.com.alura.agenda.dao.AlunoDAOImpl;
import br.com.alura.agenda.model.Aluno;

public class ListaAlunoActivity extends AppCompatActivity {

    private AlunoDAO alunoDAO = new AlunoDAOImpl();

    private List<Aluno> alunos = new ArrayList();

    private ListView alunosListVw;

    private FloatingActionButton fabAdicionaAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Lista de alunos");
        setContentView(R.layout.activity_lista_alunos);
        initViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        alunos.clear();
        alunos.addAll(alunoDAO.getAll());
    }

    private void initViews() {
        alunosListVw = findViewById(R.id.activity_lista_alunos_listview);
        alunosListVw.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alunos));

        fabAdicionaAluno = findViewById(R.id.activity_lista_alunos_fab_adiciona_aluno);
        fabAdicionaAluno.setOnClickListener(this::onBtnAdicionaAluno);
    }

    private void onBtnAdicionaAluno(View view) {
        startActivity(new Intent(this, FormularioAlunoActivity.class));
    }
}