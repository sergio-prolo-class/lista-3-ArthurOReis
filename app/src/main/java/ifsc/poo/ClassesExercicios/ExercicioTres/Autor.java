package ifsc.poo.ClassesExercicios.ExercicioTres;

public class Autor {
    private String nome;
    private String idiomaNativo;

    public Autor(String nome, String idiomaNativo) {
        this.nome = nome;
        this.idiomaNativo = idiomaNativo;
    }

        public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdiomaNativo() {
        return idiomaNativo;
    }

    public void setIdiomaNativo(String idiomaNativo) {
        this.idiomaNativo = idiomaNativo;
    }
}