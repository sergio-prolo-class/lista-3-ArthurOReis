package ifsc.poo.ClassesExercicios.ExercicioTres;


public class Emprestimo {
    private String dataEmprestimo;
    private Leitor leitor;
    private Livro livro;

    public Emprestimo(String dataEmprestimo, Leitor leitor, Livro livro) {
        this.dataEmprestimo = dataEmprestimo;
        this.leitor = leitor;
        this.livro = livro;
    }

        public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
