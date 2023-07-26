package br.com.alura.agenda.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.R;
import br.com.alura.agenda.model.Aluno;

public class ListaAlunosAdapter extends BaseAdapter {

    private final List<Aluno> alunos = new ArrayList<>();

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Aluno getItem(int posicao) {
        return alunos.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return alunos.get(posicao).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View vw = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.item_aluno, viewGroup, false);

        Aluno aluno = alunos.get(position);

        ((TextView)vw.findViewById(R.id.item_aluno_nome)).setText(aluno.getNome());
        ((TextView)vw.findViewById(R.id.item_aluno_telefone)).setText(aluno.getTelefone());

        return vw;
    }

    public void clear() {
        alunos.clear();
    }

    public void addAll(List<Aluno> alunos) {
        this.alunos.addAll(alunos);
    }

    public void remove(Aluno aluno) {
        alunos.remove(aluno);
    }
}
