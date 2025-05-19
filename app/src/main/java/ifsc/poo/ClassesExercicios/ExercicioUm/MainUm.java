package ifsc.poo.ClassesExercicios.ExercicioUm;

public class MainUm {
    public static void main(String[] args) {
        System.out.println("Criando uma lista de Usuários com Gerenciador, e printando-os: ");
        Gerenciador.cadastrarUsuario("usuario1", "senha1");
        Gerenciador.cadastrarUsuario("usuario2", "senha2");
        Gerenciador.cadastrarUsuario("usuario3", "senha3");

        String[] Listalogins = Gerenciador.listarLogins();

        for (int i = 0; i < Listalogins.length; i++) {
            System.out.println(Listalogins[i]);
        }

        System.out.println();
        System.out.println("Tentando criar um login existente (usuario2)");

        if (Gerenciador.cadastrarUsuario("usuario2", "senha2")) {
            System.out.println("Usuário 'usuario2' cadastrado!");
        } else {
            System.out.println("Não foi possível cadastrar 'usuario2'");
        }

        System.out.println();
        System.out.println("Removendo 'usuario3': ");

        if (Gerenciador.removerUsuario("usuario3")) {
            System.out.println("Usuário 3 removido com sucesso!");
        } else {
            System.out.println("Não foi possível remover usuário");
        }

        Listalogins = Gerenciador.listarLogins();

        System.out.println();
        System.out.println("Lista atual de usuários: ");

        for (int i = 0; i < Listalogins.length; i++) {
            System.out.println(Listalogins[i]);
        }

        System.out.println();
        System.out.println("Autenticando e verificando se 'usuário1' é um Usuário existente na lista");

        if (Gerenciador.autenticar("usuario1", "senha1")) {
            System.out.println("'usuario1' é um Usuário existente");
        } else {
            System.out.println("O Usuário não existe");
        }

        System.out.println();
    }
}
