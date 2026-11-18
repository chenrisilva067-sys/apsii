# Sistema de Biblioteca com Padrão Singleton

Projeto de Programação Orientada a Objetos em Java que aplica o padrão de projeto **Singleton** e os princípios **SOLID**.

## 1. Sobre o projeto

Sistema de console para gerenciar o acervo de uma biblioteca. Ele permite:

- listar o acervo (livros e revistas);
- emprestar itens a usuários cadastrados;
- devolver itens, calculando multa em caso de atraso;
- alterar as regras globais (prazo de empréstimo e valor da multa);
- consultar o log de auditoria de tudo o que aconteceu;
- provar, na prática, que o Singleton garante uma única instância (inclusive com várias threads).

Regras do sistema:

- Livros têm o prazo padrão de empréstimo; revistas têm metade desse prazo.
- A multa é cobrada por dia de atraso, com valor definido na configuração global.
- Um item emprestado não pode ser emprestado novamente até ser devolvido.

### Como executar

Requisito: JDK 11 ou superior.

```bash
javac *.java
java Main
```

Na opção 3 (devolver), informe um número de dias maior que o prazo para simular um atraso e ver a multa.

### Estrutura

| Arquivo | Papel |
|---|---|
| `ConfiguracaoBiblioteca.java` | **Singleton**: regras globais (prazo e multa) |
| `LogSistema.java` | **Singleton**: histórico único de eventos |
| `Registrador.java` | Interface para registrar eventos |
| `CalculadoraMulta.java` / `MultaPorDia.java` | Interface e regra de cálculo de multa |
| `Item.java`, `Livro.java`, `Revista.java` | Hierarquia dos itens do acervo |
| `Usuario.java`, `Emprestimo.java` | Entidades do domínio |
| `Biblioteca.java` | Serviço com as regras de empréstimo e devolução |
| `Main.java` | Menu de console; ponto onde os Singletons são obtidos |

## 2. Como o Singleton foi aplicado

O padrão garante que uma classe tenha **uma única instância** e fornece um ponto de acesso global a ela. Foi usado em duas classes:

- **`ConfiguracaoBiblioteca`**: guarda o prazo e a multa. Todo o sistema precisa enxergar as mesmas regras.
- **`LogSistema`**: guarda o histórico de eventos. Todos os eventos devem ir para o mesmo registro.

Implementação (Bill Pugh / *initialization-on-demand holder*):

- construtor `private`, para impedir `new` fora da classe;
- classe interna estática `Holder` que guarda a instância;
- método estático `getInstancia()` como ponto de acesso;
- criação **lazy** (só quando for usada) e **thread-safe**, garantida pela JVM, sem `synchronized` no acesso.

## 3. Justificativa do padrão escolhido

**Por que o Singleton é adequado aqui:**

- Configuração e log são exemplos clássicos de recurso compartilhado: precisam ser **únicos e consistentes**. Duas instâncias de configuração poderiam aplicar prazos diferentes em partes diferentes do sistema, e dois logs dividiriam o histórico.
- Alterar a configuração em um ponto do sistema passa a valer imediatamente em todos os outros.
- O acesso é simples, sem precisar passar o objeto por todas as classes.

**Outros padrões que também poderiam ser usados:**

- **Injeção de Dependência (com um contêiner)**: criaria uma única instância e a entregaria a quem precisa, evitando o acesso global. Seria mais flexível para testes.
- **Factory / Abstract Factory**: poderia criar os itens do acervo (`Livro`, `Revista`) e as calculadoras de multa.
- **Strategy**: já está presente de forma natural em `CalculadoraMulta`, permitindo trocar a regra de multa.
- **Facade**: a classe `Biblioteca` funciona como uma fachada simples para o resto do sistema.

**Cuidados com o Singleton (limitações):**

O padrão cria estado global, o que pode dificultar testes e aumentar o acoplamento. Para reduzir esse problema, a `Biblioteca` **não chama `getInstancia()`**: recebe as dependências pelo construtor, e só a `Main` obtém os Singletons.

## 4. Princípios SOLID aplicados

| Princípio | Onde aparece |
|---|---|
| **S**: Responsabilidade Única | `Biblioteca` cuida das regras de empréstimo; `LogSistema` só do log; `ConfiguracaoBiblioteca` só das regras globais; `MultaPorDia` só do cálculo da multa |
| **O**: Aberto/Fechado | Novas regras de multa implementam `CalculadoraMulta` e novos tipos de item estendem `Item`, sem alterar `Biblioteca` |
| **L**: Substituição de Liskov | `Livro` e `Revista` podem ser usados onde se espera um `Item`, e a `Biblioteca` funciona com qualquer um deles |
| **I**: Segregação de Interfaces | `Registrador` e `CalculadoraMulta` têm um único método cada, sem forçar implementações a métodos que não usam |
| **D**: Inversão de Dependência | `Biblioteca` depende de `Registrador` e `CalculadoraMulta` (abstrações) e recebe tudo pelo construtor, sem depender diretamente das classes Singleton |

## 5. Integrantes

- Carlos Henrique
- Lucas Heitor
- Emanuel Costa
