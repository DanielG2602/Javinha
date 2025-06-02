package com.AprendendoJava.Javinha.Alunos;

import jakarta.persistence.*;

@Entity
@Table( name = "TABALUNO")
public class AlunoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String nome,email,turma;
    private int idade;

    public AlunoModel() {
    }

    public AlunoModel(String email, int idade, String nome, String turma) {
        this.email = email;
        this.idade = idade;
        this.nome = nome;
        this.turma = turma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
}
