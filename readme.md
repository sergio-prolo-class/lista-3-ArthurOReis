# Lista 3: Diagramas de classe

## Engenharia de Telecomunicações - Prof. Sergio Prolo

## Programação Orientada a Objetos sergio.prolo@ifsc.edu.br

#### _05/15/2025_
#### _Aluno: Arthur Oliveira dos Reis_

---

### (i). Informações Gerais

- A implementação das soluções deve seguir os princípios da Programação Orientada a Objetos,
com especial atenção à identificação correta de classes, atributos, métodos e relações (agregação,
composição, dependência).

- No repositório fornecido há um projeto Gradle padrão. Todas as soluções devem ser implementadas
nesse projeto, organizadas em pacotes distintos.

- Utilize o Git de forma adequada: commits frequentes, README.md informativo e .gitignore funcional.

- A avaliação considerará critérios de legibilidade, clareza e organização do código. Valor total: [10
pontos]

### (!) Importante!

- Cada exercício deve ser implementado em seu próprio pacote Java (package), com nomes coerentes
com a aplicação. Sugestões:

1. Login
2. Atendimento
3. Biblioteca

- Você deve entregar também os diagramas de classe (perspectiva de implementação), inseridos no
README.md do repositório.

- Pelo menos uma classe de cada pacote deve conter um método main executável que demonstre os
requisitos funcionais.

## Pacote 1 - Sistema de Login

Descrição: O Sistema de Login é composto por duas classes principais: `Gerenciador` e `Usuário`.

- O sistema é inicializado pelo `App`, que cria um único `Gerenciador` e permite o cadastro de múltiplos `Usuários` vinculados a ele.
- Cada instância de `Usuário` está associada a exatamente um `Gerenciador`.
- O `Gerenciador` pode estar associado a zero ou mais instâncias de `Usuário`.

```mermaid
classDiagram
    App "1" --> "1" Gerenciador
    Gerenciador "1" *-- "0..*" Usuario

    App : -g Gerenciador
    App : +MainUm()
    class Gerenciador{
      -usuarios List<Usuario>
      +cadastrarUsuario(login, senha) boolean
      +removerUsuario(login) boolean
      +listarLogins() String[]
      +autenticar(login, senha) boolean
    }
    class Usuario{
        -login String
        -senha String
        +Usuario(login, senha)
        +setLogin(login) void
        +getLogin() String
        +setSenha(senha) void
        +getSenha() String
    }
```

## Pacote 2 - Fila de Atendimento

Descrição: A Fila de Atendimento é composto por quatro classes principais: `Atendimento`, `Fila`, `Solicitação` e `Cliente`.

- O sistema é inicializado pelo `App`, que cria uma única instância de `Atendimento`. O atendimento pode gerenciar várias instâncias de `Fila`, cada fila é composta por múltiplas instâncias de `Solicitação`, e cada solicitação está associada a um `Cliente`.
- Sem `Atendimento`, não é possível criar `Fila`, e sem fila, não é possível criar `Solicitação`. Instâncias do tipo `Cliente` podem existir no sistema, mas apenas participam da fila de atendimento quando possuem pelo menos uma solicitação registrada.
- Todas as filas registradas estão associadas a um único `Atendimento`, enquanto este pode ser associado de zero a n filas.
- A existência de uma `Fila` depende da existência de pelo menos uma `Solicitação`, pois as filas só existem se houver solicitações a serem atendidas.
- Por fim, um `Cliente` pode ter de zero a n solicitações, enquanto cada solicitação precisa estar associada a um único cliente.

```mermaid
classDiagram
    App "1" --> "1" Atendimento
    Atendimento "1" *-- "0..*" Fila
    Fila "1" *-- "1..*" Solicitacao
    Cliente "1" --> "0..*" Solicitacao

    App : -a Atendimento
    App : +MainDois()
    class Atendimento{
      -filas List<Fila>
      +criaFila(fila: Fila) boolean
      +listarFilas() List<Fila>
      +removeFila(fila: Fila) boolean
    }
    class Fila{
        -solicitacoes List<Solicitacao>
        +adicionarSolicitacao(solicitacao: Solicitacao) boolean
        +atendeSolicitacao() Solicitacao
        +listarSolicitacoes() List<Solicitacao>
    }
    class Solicitacao{
        -descricao String
        -categoria String
        -status String
        -cliente Cliente
        +Solicitacao(descricao: String, categoria: String, cliente: Cliente) Solicitacao
    }
    class Cliente{
        -nome String
        -telefone String
        +Cliente(nome: String, telefone: String) Cliente
        +criaSolicitacao(descricao: String, categoria: String) Solicitacao
    }
```

## Pacote 3 - Biblioteca de Livros

Descrição: A Biblioteca de Livros é composto por cinco classes principais: `Biblioteca`, `Livro`, `Autor`, `Leitor` e `Emprestimo`.

- O sistema é inicializado pelo `App`, que cria uma única instância de `Biblioteca`. A biblioteca pode gerenciar várias instâncias de `Livro` e `Leitor`. Cada livro é composto por um ou mais autores, e cada autor pode estar associado a um ou mais livros.
- Sem a `Biblioteca`, não é possível criar livros ou leitores, pois ambos dependem dela para existir. Autores só podem ser cadastrados se estiverem associados a pelo menos um livro.
- Todos os livros e leitores registrados estão associados a uma única `Biblioteca`, enquanto esta pode ser associada de zero a n livros e leitores.
- O sistema mantém um registro de todos os empréstimos realizados, sendo que cada empréstimo está obrigatoriamente associado a um único livro e a um único leitor.
- Por fim, um leitor pode ter de zero a n empréstimos, enquanto cada empréstimo precisa estar associado a um único livro e a um único leitor.

```mermaid
classDiagram
    App "1" --> "1" Biblioteca
    Biblioteca "1" *-- "0..*" Livro
    Biblioteca "1" *-- "0..*" Leitor
    Livro "1" -- "1..*" Autor
    Leitor "1" -- "0..*" Emprestimo
    Emprestimo "1" --> "1" Livro

    App : -a Biblioteca
    App : +MainTres()
    class Biblioteca{
        -livros List<Livro>
        -leitores List<Leitor>
        -autores List<Autor>
        -emprestimos List<Emprestimo>
        +cadastrarAutor(nome: String, idiomaNativo: String)
        +cadastrarLivro(titulo: String, isbn: String, autores: List<Autor>, quantidadeExemplares: int)
        +cadastrarLeitor(nome: String, endereco: String, telefone: String)
        +registrarEmprestimo(leitor: Leitor, livro: Livro, dataEmprestimo: Date) boolean
        +listarAutoresOrdenados() List<Autor>
        +listarLeitoresOrdenadosPorNome() List<Leitor>
        +listarLeitoresOrdenadosPorId() List<Leitor>
        +listarLivrosPorTitulo() List<Livro>
        +listarLivrosPorAutor() List<Livro>
        +listarLivrosPorISBN() List<Livro>
        +listarEmprestimosPorData() List<Emprestimo>
        +listarEmprestimosDeLeitor(leitor: Leitor) List<Emprestimo>
    }
    class Livro{
        -titulo String
        -isbn String
        -autores List<Autor>
        -quantidadeExemplares int
        +Livro(titulo: String, isbn: String, autores: List<Autor>, quantidadeExemplares: int)
        +temCopiaDisponivel() boolean
    }
    class Autor{
        -nome String
        -idiomaNativo String
        +Autor(nome: String, idiomaNativo: String)
    }
    class Leitor{
        -id int
        -nome String
        -endereco String
        -telefone String
        +Leitor(nome: String, endereco: String, telefone: String)
        +jaEmprestouLivro(livro: Livro) boolean
        +quantidadeEmprestimosAtivos() int
    }
    class Emprestimo{
        -dataEmprestimo Date
        -leitor Leitor
        -livro Livro
        +Emprestimo(leitor: Leitor, livro: Livro, dataEmprestimo: Date)
    }
```