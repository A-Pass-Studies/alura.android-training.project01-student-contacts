package br.com.alura.agenda.model;

import android.text.Editable;

public class Aluno {

    public Aluno(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    private String nome;

    private String telefone;

    private String email;


}
