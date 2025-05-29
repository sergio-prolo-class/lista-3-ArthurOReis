package ifsc.poo.ClassesExercicios.ExercicioDois;

public class MainDois {
    public static void main(String[] args) {
        // instanciando atendimento e filas
        Atendimento atendimento = new Atendimento();

        Fila filaTecnica = new Fila();
        Fila filaFinanceira = new Fila();
        Fila filaComercial = new Fila();

        atendimento.criaFila(filaTecnica);
        atendimento.criaFila(filaFinanceira);
        atendimento.criaFila(filaComercial);

        System.out.println("filas criadas: " + atendimento.listarFilas().size());

        // gerando clientes
        Cliente arthur = new Cliente("Arthur", "02002-1111");
        Cliente eduardo = new Cliente("Eduardo", "01995-2222");
        Cliente sergio = new Cliente("Sérgio", "01991-3333");
        Cliente germano = new Cliente("Germano", "99999-4444");

        // criando solicitações a partir dos clientes
        Solicitacao s1 = arthur.criaSolicitacao("Internet lenta", "Técnica", "Aberto");
        Solicitacao s2 = eduardo.criaSolicitacao("Cobrança indevida", "Financeira", "Aberto");
        Solicitacao s3 = sergio.criaSolicitacao("Dúvida sobre plano", "Comercial", "Aberto");
        Solicitacao s4 = germano.criaSolicitacao("Troca de equipamento", "Técnica", "Aberto");
        Solicitacao s5 = arthur.criaSolicitacao("2ª via de boleto", "Financeira", "Aberto");

        filaTecnica.adicionarSolicitacao(s1);
        filaFinanceira.adicionarSolicitacao(s2);
        filaComercial.adicionarSolicitacao(s3);
        filaTecnica.adicionarSolicitacao(s4);
        filaFinanceira.adicionarSolicitacao(s5);

        System.out.println("\nSolicitações na fila técnica:");
        for (Solicitacao s : filaTecnica.listarSolicitacoes()) {
            System.out.println(s.getDescricao() + " - cliente: " + s.getCliente().getNome());
        }

        System.out.println("\nSolicitações na fila financeira:");
        for (Solicitacao s : filaFinanceira.listarSolicitacoes()) {
            System.out.println(s.getDescricao() + " - cliente: " + s.getCliente().getNome());
        }

        System.out.println("\nSolicitações na fila comercial:");
        for (Solicitacao s : filaComercial.listarSolicitacoes()) {
            System.out.println(s.getDescricao() + " - cliente: " + s.getCliente().getNome());
        }

        // testando funcionalidade de adicionar mais uma solicitação do mesmo cliente
        Solicitacao s6 = arthur.criaSolicitacao("Alteração de endereço", "Comercial", "Aberto");
        filaComercial.adicionarSolicitacao(s6);

        System.out.println("\nApós adicionar nova solicitação do Arthur na fila comercial:");
        for (Solicitacao s : filaComercial.listarSolicitacoes()) {
            System.out.println(s.getDescricao() + " - cliente: " + s.getCliente().getNome());
        }

        // atendendo (removendo) uma solicitação da fila técnica
        Solicitacao atendida = filaTecnica.atendeSolicitacao();
        System.out.println("\nsolicitação atendida da fila técnica: " + atendida.getDescricao());

        System.out.println("\nsolicitações restantes na fila técnica:");
        for (Solicitacao s : filaTecnica.listarSolicitacoes()) {
            System.out.println(s.getDescricao() + " - cliente: " + s.getCliente().getNome());
        }

        // removendo uma fila
        atendimento.removeFila(filaComercial);
        System.out.println("\nfilas restantes após remover fila comercial: " + atendimento.listarFilas().size());
    }
}
