package br.com.alura.agenda.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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

    private ArrayAdapter alunosListVwAdapter;

    /**
     * Cadastra alguns alunos para testes.
     */


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
        alunosListVwAdapter.clear();
        alunosListVwAdapter.addAll(alunoDAO.getAll());
    }

    private void initViews() {

        setupAlunosListView();

        FloatingActionButton fabAdicionaAluno = findViewById(R.id.activity_lista_alunos_fab_adiciona_aluno);
        fabAdicionaAluno.setOnClickListener(this::onBtnAdicionaAluno);
    }

    private void setupAlunosListView() {
        ListView alunosListVw = findViewById(R.id.activity_lista_alunos_listview);
        alunosListVwAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        alunosListVw.setAdapter(alunosListVwAdapter);
        alunosListVw.setOnItemClickListener(this::onAlunoClick);
        alunosListVw.setOnItemLongClickListener(this::onAlunoLongClick);
    }

    private boolean onAlunoLongClick(AdapterView<?> adapterView, View view, int position, long id) {
        Aluno aluno = (Aluno) adapterView.getItemAtPosition(position);
        alunoDAO.remove(aluno);
        alunosListVwAdapter.remove(aluno);
        return true;
    }

    private void onAlunoClick(AdapterView<?> adapterView, View view, int posicao, long id) {
        Log.i("lista_aluno", "clique no aluno de posição: " + posicao);

        startActivity(
                new Intent(this, FormularioAlunoActivity.class)
                        .putExtra(FormularioAlunoActivity.BUNDLE_ALUNO_TO_EDIT, (Aluno) adapterView.getItemAtPosition(posicao)));

    }

    private void onBtnAdicionaAluno(View view) {
        startActivity(new Intent(this, FormularioAlunoActivity.class));
    }
}