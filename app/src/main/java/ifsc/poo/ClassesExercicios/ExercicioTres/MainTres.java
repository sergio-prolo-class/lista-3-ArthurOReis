package ifsc.poo.ClassesExercicios.ExercicioTres;

import java.util.ArrayList;
import java.util.List;

public class MainTres {
    public static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {
        // cadastrando autores
        biblioteca.cadastrarAutor("Odilson", "Português");
        biblioteca.cadastrarAutor("Sérgio", "Inglês");
        biblioteca.cadastrarAutor("Lois", "Francês");

        List<Autor> autores = biblioteca.listarAutoresOrdenados();
        Autor odilson = autores.get(0);
        Autor sergio = autores.get(1);
        Autor lois = autores.get(2);

        // cadastrando livros
        List<Autor> autoresLivro1 = new ArrayList<>();
        autoresLivro1.add(odilson);
        autoresLivro1.add(sergio);
        biblioteca.cadastrarLivro("POO Avançada", "123-456", autoresLivro1, 2);

        List<Autor> autoresLivro2 = new ArrayList<>();
        autoresLivro2.add(lois);
        biblioteca.cadastrarLivro("Estruturas de Dados", "789-101", autoresLivro2, 1);

        // cadastrando leitores
        biblioteca.cadastrarLeitor("Arthur", "Brasil", "123123-2121");
        biblioteca.cadastrarLeitor("Ygor", "Brasil", "321321-8181");

        List<Leitor> leitores = biblioteca.listarLeitoresOrdenadosPorNome();
        Leitor arthur = leitores.get(0);
        Leitor ygor = leitores.get(1);

        Livro pooAvancada = biblioteca.buscarLivroPorTitulo("POO Avançada");
        Livro estruturasDados = biblioteca.buscarLivroPorTitulo("Estruturas de Dados");

        // fazendo empréstimos
        boolean emprestimo1 = biblioteca.registrarEmprestimo(arthur, pooAvancada, "2025-05-28");

        if (emprestimo1){
            System.out.println("Empréstimo de 'POO Avançada' para Arthur realizado! :)");
        } else {
            System.out.println("Não foi possível emprestar para Arthur. :(");
        }

        boolean emprestimo2 = biblioteca.registrarEmprestimo(ygor, pooAvancada, "2025-05-28");

        if (emprestimo2){
            System.out.println("Empréstimo de 'POO Avançada' para Ygor realizado! :)");
        } else {
            System.out.println("Não foi possível emprestar para Ygor. :(");
        }

        boolean emprestimo3 = biblioteca.registrarEmprestimo(arthur, estruturasDados, "2025-05-28");

        if (emprestimo3){
            System.out.println("Empréstimo de 'Estruturas de Dados' para Arthur realizado! :)");
        } else {
            System.out.println("Não foi possível emprestar para Arthur. :(");
        }

        // tentando emprestar livro sem exemplares
        boolean emprestimo4 = biblioteca.registrarEmprestimo(ygor, estruturasDados, "2025-05-28");

        if (emprestimo4){
            System.out.println("Empréstimo de 'Estruturas de Dados' para Ygor realizado! :)");
        } else {
            System.out.println("Não foi possível emprestar para Ygor. :(");
        }

        // listando autores ordenados por nome
        System.out.println("\nAutores ordenados:");
        for (Autor autor : biblioteca.listarAutoresOrdenados()) {
            System.out.println(autor.getNome() + " - Língua nativa: " + autor.getIdiomaNativo());
        }

        // listando leitores ordenados por nome
        System.out.println("\nLeitores ordenados por nome:");
        for (Leitor leitor : biblioteca.listarLeitoresOrdenadosPorNome()) {
            System.out.println(leitor.getNome());
        }

        // listando livros por título
        System.out.println("\nLivros ordenados por título:");
        for (Livro leitor : biblioteca.listarLivrosPorTitulo()) {
            System.out.println(leitor.getTitulo() + " - Quantidaed de exemplares: " + leitor.getQuantidadeExemplares());
        }

        // listando empréstimos por data
        System.out.println("\nEmpréstimos por data:");
        for (Emprestimo emprestimo : biblioteca.listarEmprestimosPorData()) {
            System.out.println(emprestimo.getDataEmprestimo() + " -> " + emprestimo.getLeitor().getNome() + " pegou " + emprestimo.getLivro().getTitulo());
        }

        // listando empréstimos do Arthur
        System.out.println("\nEmpréstimos feitos por Arthur:");
        for (Emprestimo emprestimo : biblioteca.listarEmprestimosDeLeitor(arthur)) {
            System.out.println(emprestimo.getLivro().getTitulo() + " no dia " + emprestimo.getDataEmprestimo());
        }
    }
}
