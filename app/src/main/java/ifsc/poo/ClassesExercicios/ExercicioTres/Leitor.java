package ifsc.poo.ClassesExercicios.ExercicioTres;

import java.util.ArrayList;
import java.util.List;

public class Leitor {
    private int id;
    private String nome;
    private String endereco;
    private String telefone;
    private List<Emprestimo> emprestimosRealizados = new ArrayList<>();

    public Leitor(int id, String nome, String endereco, String telefone) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public boolean jaEmprestouLivro(Livro livro){
        for (Emprestimo e : emprestimosRealizados) {
            if (e.getLivro().equals(livro)) {
                return true;
            }
        }
        return false;
    }

    public int quantidadeEmprestimosAtivos(){
        return emprestimosRealizados.size();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Emprestimo> getEmprestimosRealizados() {
        return emprestimosRealizados;
    }

    public void setEmprestimosRealizados(List<Emprestimo> emprestimosRealizados) {
        this.emprestimosRealizados = emprestimosRealizados;
    }
}