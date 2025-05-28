package ifsc.poo.ClassesExercicios.ExercicioTres;

import java.util.List;

public class Livro {
    private String titulo;
    private String isbn;
    private List<Autor> autores;
    private int quantidadeExemplares;

    public Livro(String titulo, String isbn, List<Autor> autores, int quantidadeExemplares) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autores = autores;
        this.quantidadeExemplares = quantidadeExemplares;
    }

    public boolean temCopiaDisponivel(){
        return this.quantidadeExemplares > 0;
    }

        public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public int getQuantidadeExemplares() {
        return quantidadeExemplares;
    }

    public void setQuantidadeExemplares(int quantidadeExemplares) {
        this.quantidadeExemplares = quantidadeExemplares;
    }

}