package com.crud.meuprimeirocrud.models;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_LIVRO")
public class LivroModel {

    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String autor;

    public LivroModel(){
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
