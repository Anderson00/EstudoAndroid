package com.example.atividadesala02;

public class Livro {
    private static int idCount = 0;
    private int id;
    private int isbn;
    private String titulo;
    private String autor;

    public Livro(String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
        this.id = idCount++;
    }

    public int getId() {
        return id;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    private String editora;


}
