package br.com.alura.agenda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Lista de alunos");

        ArrayList<String> alunos = new ArrayList<>(Arrays.asList("Anderson", "Laila", "Dina", "Maria", "Marcos"));

        setContentView(R.layout.activity_main);

        ListView listaDeAlunos = findViewById(R.id.activity_main_lista_de_alunos);

        listaDeAlunos.setAdapter(
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alunos));

    }
}