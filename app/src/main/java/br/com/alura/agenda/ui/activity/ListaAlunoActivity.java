package br.com.alura.agenda.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.R;
import br.com.alura.agenda.dao.AlunoDAO;
import br.com.alura.agenda.dao.AlunoDAOImpl;
import br.com.alura.agenda.model.Aluno;
import br.com.alura.agenda.ui.adapter.ListaAlunosAdapter;

public class ListaAlunoActivity extends AppCompatActivity {

    private final AlunoDAO alunoDAO = new AlunoDAOImpl();

    private ListaAlunosAdapter alunosListVwAdapter;

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
        alunosListVwAdapter.atualiza(alunoDAO.getAll());
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.activity_lista_aluno_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.activity_lista_aluno_menu_remove:
                setupRemoveConfirmationDialog(item);
                break;
        }

        return super.onContextItemSelected(item);
    }

    private void setupRemoveConfirmationDialog(MenuItem item) {
        AdapterView.AdapterContextMenuInfo adapterInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Aluno aluno = (Aluno) alunosListVwAdapter.getItem(adapterInfo.position);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Removendo o aluno")
                .setMessage("Tem certeza eu deseja remover o aluno " + aluno.getNome() + "?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        alunoDAO.remove(aluno);
                        alunosListVwAdapter.remove(aluno);
                    }
                })
                .setNegativeButton("Não", null).create();
        dialog.show();
    }

    private void initViews() {

        setupAlunosListView();

        FloatingActionButton fabAdicionaAluno = findViewById(R.id.activity_lista_alunos_fab_adiciona_aluno);
        fabAdicionaAluno.setOnClickListener(this::onBtnAdicionaAluno);
    }

    private void setupAlunosListView() {
        ListView alunosListVw = findViewById(R.id.activity_lista_alunos_listview);
        alunosListVwAdapter = new ListaAlunosAdapter();
        alunosListVw.setAdapter(alunosListVwAdapter);
        alunosListVw.setOnItemClickListener(this::onAlunoClick);
        registerForContextMenu(alunosListVw);
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