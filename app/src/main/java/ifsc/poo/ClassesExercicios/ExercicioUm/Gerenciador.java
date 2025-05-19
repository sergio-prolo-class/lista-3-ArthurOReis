package ifsc.poo.ClassesExercicios.ExercicioUm;

import java.util.ArrayList;
import java.util.List;


public class Gerenciador {

    private final static List<Usuario> usuarios = new ArrayList<>();

    public static boolean cadastrarUsuario(String login, String senha){
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getLogin().equals(login)){ // Iteração para verificar cópia de login de mesmo nome
                return false;
            }
        }

        usuarios.add(new Usuario(login, senha));
        return true;
    }

    public static boolean removerUsuario(String login){
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getLogin().equals(login)){ // Iteração para verificar cópia de login de mesmo nome
                usuarios.remove(i);
                return true;
            }
        }

        return false;
    }

    public static List<Usuario> listarLogins(){
        return usuarios;
    }

    public static boolean autenticar(String login, String senha){
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getLogin().equals(login) && usuarios.get(i).getSenha().equals(senha)){ // Iteração para verificar se há login e senha iguais
                return true;
            }
        }

        return false;
    }

}