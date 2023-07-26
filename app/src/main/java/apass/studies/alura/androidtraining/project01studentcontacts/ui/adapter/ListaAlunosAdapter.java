package apass.studies.alura.androidtraining.project01studentcontacts.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import apass.studies.alura.androidtraining.project01studentcontacts.R;
import apass.studies.alura.androidtraining.project01studentcontacts.model.Aluno;

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
    public View getView(int position, View view, @NonNull ViewGroup viewGroup) {
        View vw = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.item_aluno, viewGroup, false);

        Aluno aluno = alunos.get(position);

        ((TextView)vw.findViewById(R.id.item_aluno_nome)).setText(aluno.getNome());
        ((TextView)vw.findViewById(R.id.item_aluno_telefone)).setText(aluno.getTelefone());

        return vw;
    }

    public void atualiza(List<Aluno> alunos) {
        this.alunos.clear();
        this.alunos.addAll(alunos);
        notifyDataSetChanged();
    }

    public void remove(Aluno aluno) {
        alunos.remove(aluno);
        notifyDataSetChanged();
    }
}
