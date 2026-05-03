package entidades;

import contratos.Acessavel;

public abstract class ItemAcervo implements Acessavel {
    private String titulo;
    private String autor;
    private boolean disponivel = true;
    private String conteudo;

    @Override
    public void abrirItem() {
        System.out.println("### LEITURA INICIADA ###");
        System.out.println(String.format("Título: %s", titulo));
        System.out.println(String.format("Autor: %s", autor));
        System.out.println(String.format("Conteúdo: %s", conteudo));
    }

    @Override
    public void fecharItem() {
        System.out.println(String.format("O item %s foi fechado", titulo));
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
