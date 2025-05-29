package ifsc.poo.ClassesExercicios.ExercicioDois;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Fila {
    private final Queue<Solicitacao> solicitacoes = new ArrayDeque<>();

    public Fila(Solicitacao... novas_solicitacoes) {
        solicitacoes.addAll(Arrays.asList(novas_solicitacoes));
    }

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
        return solicitacoes.poll();
    }

    public Queue<Solicitacao> listarSolicitacoes(){
        return this.solicitacoes;
    }
}