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
