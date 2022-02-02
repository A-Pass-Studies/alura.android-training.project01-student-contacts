package br.com.alura.agenda.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.alura.agenda.R;

public class ListaAlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Lista de alunos");

        ArrayList<String> alunos = new ArrayList<>(Arrays.asList("Anderson", "Laila", "Dina", "Maria", "Marcos"));

        setContentView(R.layout.activity_lista_alunos);

        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);

        listaDeAlunos.setAdapter(
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alunos));

    }
}