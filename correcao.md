# Correção

| Questão     | Legibilidade | Diagramas | P1 | P2 | P3 | Total |
|-------------|--------------|-----------|----|----|----|-------|
| Nota máxima | 10           | 10        | 20 | 25 | 35 | 100   |
| Nota        | 10           | 8         | 17 | 7  | 28 | 70    |

## Diagramas

- falta dois pontos nos atributos
- coleções precisam de tils para aparecer certo em mermaid, assim eu não sei os tipos dos elementos
- P1: Os membros estáticos não estão sublinhados
- P2: Associação Cliente-Solicitacao sem multiplicidade aparente e direcionalidade invertida (é a solicitação que conhece o cliente)
- P2: Atendimento.filas é uma lista?
- P3: Biblioteca tem um registro de autores, mas não aparece no diagrama de classes
- P3: Leitor pode ter quantos empréstimos quiser?

## P1

- lista de usuários? pode ter duplicata? teve que implementar verificações na mão.
- setLogin e setSenha desnecessários

### Requisitos Funcionais
- [x] Cadastrar novos usuários
- [x] Remover usuários
- [x] Listar os logins
- [x] Autenticar usuários

## P2 

- sua solução segrega pedidos, o que não foi a proposta do exercício
- não existe restrição de repetição em fila, mas sua implementação impede
- o sistema deveria manter um registro das solicitações já atendidas

### Requisitos Funcionais
- [x] Registrar novas solicitações
- [ ] Listar os telefones dos clientes registrados
- [ ] Imprimir o nome do próximo cliente
- [x] Atender o próximo cliente
- [ ] Listar os nomes dos clientes já atendidos
- [ ] Listar os telefones dos clientes em espera
- [ ] Gerar um relatório estatístico
- [ ] ... total de solicitações registradas, atendidas, em espera
- [ ] ... distribuição percentual das solicitações por categoria

## P3

- a quantidade de exemplares disponíveis de um Livro não é atributo do Livro, e sim da Biblioteca
- livros com o mesmo ISBN podem ser cadastrados, mas deveria ser identificador único
- MainTres não testa várias das funcionalidades, apesar de implementadas.
- tudo é lista? autores, livros, leitores duplicados.
- acoplamento em excesso:
  - seu método de listar empréstimos de um leitor depende do objeto Leitor ao qual o empréstimo foi registrado
  - portanto, MainTres() depende de Leitor, o que não aparece no diagrama
- Livro.equals() só compara o endereço de memória de dois objetos.
  - Veja MainTres.testeIgualdadeLivros()
  - Logo, o mesmo livro pode ser entregue ao mesmo leitor.

### Requisitos Funcionais
- [x] Cadastrar autores
- [x] Cadastrar livros
- [x] Cadastrar leitores
- [x] Registrar empréstimos de livros para leitores
- [x] ... pelo menos uma cópia
- [ ] ... leitor não tenha esse livro
- [x] ... leitor possua no máximo 5 livros emprestados
- [x] Listar autores em ordem alfabética
- [x] Listar leitores em ordem alfabética
- [x] Listar leitores por id
- [x] Listar livros por título
- [x] Listar livros por autor
- [x] Listar livros por ISBN
- [x] Listar empréstimos por data
- [x] Listar empréstimos de um leitor, por data