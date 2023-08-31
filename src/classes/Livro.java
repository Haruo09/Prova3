package classes;

import java.time.LocalDate;

public class Livro {
    // Atributos:
    private int registro;
    private String nome;
    private String autor;
    private LocalDate dataPublicacao;

    // Construtor:
    public Livro(int registro, String nome, String autor, LocalDate dataPublicacao) {
        this.registro = registro;
        this.nome = nome;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
    }

    public Livro() {
        // Construtor vazio;
    }


    // Método toString():
    public String toString() {
        return String.format(
            """
            N° Registro: %d
            Nome: %s
            Autor: %s
            Data de Publicação: %s
            """, registro, nome, autor, dataPublicacao
        );
    }

    // Getters & Setters:
    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
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

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
}
