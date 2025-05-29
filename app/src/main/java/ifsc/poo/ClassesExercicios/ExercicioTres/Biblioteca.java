package ifsc.poo.ClassesExercicios.ExercicioTres;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Biblioteca {
    private final static List<Livro> livros = new ArrayList<>();
    private final static List<Leitor> leitores = new ArrayList<>();
    private final static List<Autor> autores = new ArrayList<>();
    private final static List<Emprestimo> emprestimos = new ArrayList<>();

    public Livro buscarLivroPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(titulo)) {
                return livro;
            }
        }
        return null;
    }


    public void cadastrarAutor(String nome, String idiomaNativo) {
        Autor autor = new Autor(nome, idiomaNativo);
        autores.add(autor);
    }

    public void cadastrarLivro(String titulo, String isbn, List<Autor> autores, int quantidadeExemplares) {
        Livro livro = new Livro(titulo, isbn, autores, quantidadeExemplares);
        livros.add(livro);
    }

    public void cadastrarLeitor(String nome, String endereco, String telefone) {
        int novoId = leitores.size() + 1;
        Leitor leitor = new Leitor(novoId, nome, endereco, telefone);
        leitores.add(leitor);
    }

    public boolean registrarEmprestimo(Leitor leitor, Livro livro, String dataEmprestimo) {
        if (!livro.temCopiaDisponivel()) return false;
        if (leitor.jaEmprestouLivro(livro)) return false;
        if (leitor.quantidadeEmprestimosAtivos() >= 5) return false;

        Emprestimo emprestimo = new Emprestimo(dataEmprestimo, leitor, livro);
        emprestimos.add(emprestimo);
        leitor.getEmprestimosRealizados().add(emprestimo);
        livro.setQuantidadeExemplares(livro.getQuantidadeExemplares() - 1);
        return true;
    }

    public List<Autor> listarAutoresOrdenados() {
        List<Autor> lista = new ArrayList<>(autores);
        lista.sort(Comparator.comparing(Autor::getNome));
        return lista;
    }

    public List<Leitor> listarLeitoresOrdenadosPorNome() {
        List<Leitor> lista = new ArrayList<>(leitores);
        lista.sort(Comparator.comparing(Leitor::getNome));
        return lista;
    }

    public List<Leitor> listarLeitoresOrdenadosPorId() {
        List<Leitor> lista = new ArrayList<>(leitores);
        lista.sort(Comparator.comparingInt(Leitor::getId));
        return lista;
    }

    public List<Livro> listarLivrosPorTitulo() {
        List<Livro> lista = new ArrayList<>(livros);
        lista.sort(Comparator.comparing(Livro::getTitulo));
        return lista;
    }

    public List<Livro> listarLivrosPorAutor() {
        List<Livro> lista = new ArrayList<>(livros);
        lista.sort(Comparator.comparing(livro -> livro.getAutores().get(0).getNome()));
        return lista;
    }

    public List<Livro> listarLivrosPorISBN() {
        List<Livro> lista = new ArrayList<>(livros);
        lista.sort(Comparator.comparing(Livro::getIsbn));
        return lista;
    }

    public List<Emprestimo> listarEmprestimosPorData() { // arrumar função quando trocar data String -> DateTime
        List<Emprestimo> lista = new ArrayList<>(emprestimos);
        lista.sort(Comparator.comparing(Emprestimo::getDataEmprestimo));
        return lista;
    }

    public List<Emprestimo> listarEmprestimosDeLeitor(Leitor leitor) {
        List<Emprestimo> lista = new ArrayList<>();
        for (Emprestimo e : emprestimos) {
            if (e.getLeitor().equals(leitor)) {
                lista.add(e);
            }
        }
        lista.sort(Comparator.comparing(Emprestimo::getDataEmprestimo));
        return lista;
    }
}