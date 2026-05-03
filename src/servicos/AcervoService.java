package servicos;

import entidades.Ebook;
import entidades.ItemAcervo;
import entidades.RevistaDigital;
import excecoes.ItemNaoDisponivelException;
import excecoes.ItemNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class AcervoService {
    private List<ItemAcervo> itensAcervo = new ArrayList<>();

    public List<ItemAcervo> obterTodosItensDoAcervo() {
        return itensAcervo;
    }

    public void inserirItem(ItemAcervo item) {
        itensAcervo.add(item);
    }

    public void abrirItem(ItemAcervo item) throws ItemNaoDisponivelException {
        if(!item.isDisponivel()) {
            throw new ItemNaoDisponivelException(
                    String.format("O item %s não encontra-se disponível", item.getTitulo())
            );
        }

        item.abrirItem();
    }

    public void fecharItem(ItemAcervo item) {
        item.fecharItem();
    }

    public void cadastrarEbook(Ebook ebook) {
        inserirItem(ebook);
    }

    public void cadastrarRevistaDigital(RevistaDigital revistaDigital) {
        inserirItem(revistaDigital);
    }

    public ItemAcervo obterItemPeloTitulo(String titulo) throws ItemNaoEncontradoException {
        for (ItemAcervo item : itensAcervo) {
            if (item.getTitulo().equalsIgnoreCase(titulo)) {
                return item;
            }
        }

        throw new ItemNaoEncontradoException(String.format("Não existe um item com o título %s", titulo));
    }

    public void removerItemPeloTitulo(String titulo) throws ItemNaoEncontradoException {
        ItemAcervo itemEncontrado = obterItemPeloTitulo(titulo);

        itensAcervo.remove(itemEncontrado);
    }
}
