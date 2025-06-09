package ifsc.poo.ClassesExercicios.ExercicioDois;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Atendimento {
    private static final List<Fila> filas = new ArrayList<>();
    
    public Atendimento(Fila... novas_filas) {
        filas.addAll(Arrays.asList(novas_filas));
    }

    public boolean criaFila(Fila fila){
        for (Object fila_existente : filas) {
            if(fila_existente.equals(fila)){
                return false;
            }
        }

        filas.add(fila);
        return true;
    }

    public List<Fila> listarFilas(){
        return Atendimento.filas;
    }

    public boolean removeFila(Fila fila){
        if(!filas.contains(fila)){
            return false;
        }
        filas.remove(fila);
        return true;
    }
}
