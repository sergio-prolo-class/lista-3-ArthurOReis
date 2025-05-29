package ifsc.poo.ClassesExercicios.ExercicioDois;

public class Solicitacao {
    private String descricao;
    private String categoria;
    private String status;
    private final Cliente cliente;

    public Solicitacao(String categoria, String descricao, String status, Cliente cliente){
        this.categoria = categoria;
        this.descricao = descricao;
        this.status = status;
        this.cliente = cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cliente getCliente(){
        return this.cliente;
    }

}