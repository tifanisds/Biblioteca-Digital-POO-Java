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


