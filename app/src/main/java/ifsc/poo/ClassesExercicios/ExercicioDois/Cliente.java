package ifsc.poo.ClassesExercicios.ExercicioDois;

public class Cliente {
    private String nome;
    private String telefone;
    
    public Cliente(String nome, String telefone){
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getTelefone(){
        return this.telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public Solicitacao criaSolicitacao(String descricao, String categoria, String status){
        Solicitacao solicitacao = new Solicitacao(descricao, categoria, status, this);
        return solicitacao;
    }
}