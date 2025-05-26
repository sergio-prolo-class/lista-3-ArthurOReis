package ifsc.poo.ClassesExercicios.ExercicioDois;

import java.util.ArrayList;
import java.util.List;

public class Fila {
    private final List<Solicitacao> solicitacoes = new ArrayList<>();

    public boolean adicionarSolicitacao(Solicitacao solicitacao) {
        for (Solicitacao solicitacao_elemento : solicitacoes) {
            if(solicitacao.equals(solicitacao_elemento)){
                return false;
            }
        }

        solicitacoes.add(solicitacao);
        return true;
    }

    public Solicitacao atendeSolicitacao(){
        if (solicitacoes.isEmpty() || solicitacoes.size() == 1) {
            return null;
        }

        solicitacoes.removeFirst();
        return solicitacoes.getFirst();
    }

    public List<Solicitacao> listarSolicitacoes(){
        return this.solicitacoes;
    }
}