# 📚 Biblioteca Digital - Java (POO)

Projeto desenvolvido para a disciplina de **Programação Orientada a Objetos**, com o objetivo de aplicar conceitos como **herança, abstração, interfaces, exceções e serviços**.

---

## Funcionalidades

- Listar itens do acervo  
- Cadastrar Ebook  
- Cadastrar Revista Digital  
- Remover item pelo título  
- Buscar item pelo título  
- Abrir e fechar item  
- Tratamento de erros com exceções personalizadas  

---

## Estrutura do Projeto

### 📦 entidades
Classes que representam o domínio do sistema:

- `ItemAcervo` (classe abstrata)
- `Ebook`
- `RevistaDigital`

---

### 📜 contratos
Define regras que devem ser seguidas:

- `Acessavel` (interface)

---

### ⚠️ excecoes
Exceções personalizadas:

- `ItemNaoDisponivelException`
- `ItemNaoEncontradoException`
- `OperacaoInvalidaException`
- `SistemaFinalizadoException`

---

### ⚙️ servicos
Regras de negócio e interação:

- `AcervoService` → lógica do acervo  
- `CLIService` → interface via terminal  

---

## Conceitos de POO aplicados

- **Abstração** → `ItemAcervo`  
- **Herança** → `Ebook` e `RevistaDigital`  
- **Encapsulamento** → getters e setters  
- **Polimorfismo** → interface `Acessavel`  
- **Exceções** → controle de erros  
- **Separação de responsabilidades** → Services  

## 🖥️ Exemplo de uso

Seja bem-vindo(a) à Biblioteca Digital

1 - Exibir acervo

2 - Inserir novo item

3 - Remover item

4 - Abrir item

5 - Sair





