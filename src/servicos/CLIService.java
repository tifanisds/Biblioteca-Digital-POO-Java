package servicos;

import entidades.Ebook;
import entidades.ItemAcervo;
import entidades.RevistaDigital;
import excecoes.ItemNaoDisponivelException;
import excecoes.ItemNaoEncontradoException;
import excecoes.OperacaoInvalidaException;
import excecoes.SistemaFinalizadoException;

import java.util.List;
import java.util.Scanner;

public class CLIService {
    private Scanner scanner = new Scanner(System.in);
    private List<String> operacoesDisponiveis = List.of("1", "2", "3", "4", "5");
    private List<String> operacoesDisponiveisCadastro = List.of("1", "2", "3");
    private AcervoService acervoService = new AcervoService();
    private String opcaoSelecionada;

    public CLIService() {
        exibirBoasVindas();
    }

    public void exibirBoasVindas() {
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        System.out.println("Seja bem-vindo(a) à Biblioteca Digital");
    }

    public void exibirMenu() {
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        System.out.println("Digite 1 para exibir o acervo");
        System.out.println("Digite 2 para inserir um novo item");
        System.out.println("Digite 3 para remover um item");
        System.out.println("Digite 4 para abrir um item do acervo");
        System.out.println("Digite 5 para sair");
    }

    public void navegar() throws OperacaoInvalidaException, ItemNaoEncontradoException, SistemaFinalizadoException, ItemNaoDisponivelException {
        opcaoSelecionada = scanner.nextLine();

        if(!operacoesDisponiveis.contains(opcaoSelecionada)) {
            throw new OperacaoInvalidaException("Essa operação não é válida");
        }

        switch (opcaoSelecionada) {
            case "1":
                listarAcervo();
                break;

            case "2":
                cadastrarItemAcervo();
                break;

            case "3":
                removerItemAcervo();
                break;

            case "4":
                abrirItem();
                break;

            case "5":
                throw new SistemaFinalizadoException();
        }
    }

    public void exibirMenuCadastro() {
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        System.out.println("Digite 1 para cadastrar um Ebook");
        System.out.println("Digite 2 para cadastrar uma revista digital");
        System.out.println("Digite 3 para sair");
    }

    public void cadastrarItemAcervo() throws OperacaoInvalidaException {
        exibirMenuCadastro();

        opcaoSelecionada = scanner.nextLine();

        if(!operacoesDisponiveisCadastro.contains(opcaoSelecionada)) {
            throw new OperacaoInvalidaException("Essa operação não é válida");
        }

        if(opcaoSelecionada.equals("1")) {
            cadastrarEbook();
        } else if(opcaoSelecionada.equals("2")) {
            cadastrarRevistaDigital();
        }
    }

    public void cadastrarEbook() {
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        String titulo = receberValor("Digite o título: ");
        String autor = receberValor("Digite o nome do autor: ");
        String conteudo = receberValor("Digite o conteúdo do item: ");
        String disponivel = receberValor("Digite S para disponível e outra letra para indisponível: ");
        String tamanhoArquivoMB = receberValor("Digite o peso em MB: ");

        Ebook ebook = new Ebook(titulo, autor, conteudo, tamanhoArquivoMB);
        ebook.setDisponivel(disponivel.equalsIgnoreCase("S"));

        acervoService.cadastrarEbook(ebook);

        System.out.println("Ebook cadastrado com sucesso!");
    }

    public void cadastrarRevistaDigital() {
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        String titulo = receberValor("Digite o título: ");
        String autor = receberValor("Digite o nome do autor: ");
        String conteudo = receberValor("Digite o conteúdo do item: ");
        String disponivel = receberValor("Digite S para disponível e outra letra para indisponível: ");
        String numeroEdicao = receberValor("Digite o número da edição: ");

        RevistaDigital revistaDigital = new RevistaDigital(titulo, autor, conteudo, numeroEdicao);
        revistaDigital.setDisponivel(disponivel.equalsIgnoreCase("S"));

        acervoService.cadastrarRevistaDigital(revistaDigital);

        System.out.println("Ebook cadastrado com sucesso!");
    }

    public void listarAcervo() {
        List<ItemAcervo> itens = acervoService.obterTodosItensDoAcervo();

        if(itens.isEmpty()) {
            System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
            System.out.println("Ainda não foram cadastrados itens no acervo.");
            return;
        }

        for(ItemAcervo item : itens) {
            System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
            System.out.println(String.format("Livro: %s", item.getTitulo()));
            System.out.println(String.format("Autor: %s", item.getAutor()));
            System.out.println(String.format("Disponibilidade: %s", item.isDisponivel() ? "Disponivel" : "Indisponivel"));
        }
    }

    public void removerItemAcervo() throws ItemNaoEncontradoException {
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");

        String titulo = receberValor("Digite o título do livro que deseja remover: ");

        acervoService.removerItemPeloTitulo(titulo);

        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        System.out.println("Item removido com sucesso");
    }

    public void abrirItem() throws ItemNaoEncontradoException, ItemNaoDisponivelException {
        String titulo = receberValor("Digite o título do livro que deseja abrir: ");

        ItemAcervo item = acervoService.obterItemPeloTitulo(titulo);

        acervoService.abrirItem(item);

        receberValor("Digite qualquer valor para finalizar leitura: ");
        acervoService.fecharItem(item);
    }

    public String receberValor(String mensagem) {
        String valor = "";

        while(valor.trim().isEmpty()) {
            System.out.println(mensagem + "\n");
            valor = scanner.nextLine();
        }

        return valor;
    }
}
