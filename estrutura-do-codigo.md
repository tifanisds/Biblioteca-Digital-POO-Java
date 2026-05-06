# ESTRUTURA DO CÓDIGO

## 1.1 Situação da Atividade
O projeto desenvolvido refere-se ao Grupo 2: Biblioteca Digital, com os seguintes requisitos:

- **Classe Abstrata:** *ItemAcervo*
  - Atributos: titulo, autor, disponivel
    

- **Subclasses (Herança):**
  - Ebook → atributo específico: tamanhoArquivoMB
  - RevistaDigital → atributo específico: numeroEdicao
        

- **Interface (Contrato):** *Acessavel*
  - Métodos: abrirItem() e fecharItem()
        
  
- **Regras de Negócio:**
  - Um laço de repetição permite buscar um item pelo título
  - Uma estrutura condicional impede a execução do método abrirItem() caso o item não esteja disponível (disponivel = false)


## 1.2 Motivo da Escolha da Estrutura

Para atender aos requisitos da atividade, foi necessária a criação de:


- **Entidades**, representando os itens do acervo
- **Contrato (interface)**, garantindo padronização de comportamento

Além disso, para melhorar a organização e qualidade do projeto, foram adicionadas:


- **Camada de serviços (Service)** → responsável pelas regras de negócio
- **Camada de exceções** → responsável pelo tratamento de erros


Essa separação torna o código mais modular, organizado e de fácil manutenção.

## 1.3 O que é um Contrato (Interface)

Um contrato define um conjunto de regras que uma classe deve seguir.

Ou seja:

- Define **o que deve ser feito**
- Não define **como será feito**


No projeto, o contrato é representado pela interface:

```java
package contratos;

public interface Acessavel {
    void abrirItem();
    void fecharItem();
}
```

Qualquer classe que implemente essa interface é obrigada a implementar esses métodos.


## 1.4 O que é um Serviço (Service)
Um serviço é uma classe responsável por executar ações e regras de negócio, geralmente utilizando outras classes.


No projeto, foram utilizados:

- **AcervoService:**
Responsável pelas operações relacionadas às entidades (itens do acervo)


- **CLIService:**
Responsável pela interação com o usuário
Atua como intermediário entre:
  - o usuário
  - e o serviço do acervo


Essa separação melhora a organização e evita concentração de responsabilidades em uma única classe.

<img src="./Assets/img/image1.png" width="700">


## 1.5 O que é uma Exceção
Uma exceção é um
mecanismo utilizado para tratar erros ou situações inesperadas durante a execução do programa.


Ela funciona como um aviso de erro, interrompendo o fluxo normal da aplicação quando algo incorreto acontece.


### 1.5.1 Hierarquia das Exceções em Java

Todas as exceções derivam da classe principal:

<img src="./Assets/img/image2.jpg" width="700">

Exemplo de uso utilizados no projeto

#### Try/Catch:

```java
public class ExemploTryCatch {
    public static void main(String[] args) {

        try {
            int resultado = 10 / 0; // erro
            System.out.println(resultado);

        } catch (ArithmeticException e) {
            System.out.println("Erro: divisão por zero");
        }

        System.out.println("Programa continua normalmente");
    }
}
```

#### throw new Exception

```java
throw new Error("Algo deu errado");
```
