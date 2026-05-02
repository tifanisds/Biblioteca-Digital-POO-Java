package entidades;

import contratos.Acessavel;

public abstract class ItemAcervo implements Acessavel {
    private String titulo;
    private String autor;
    private boolean disponivel = true;

    @Override
    public void abrirItem() {
        System.out.println(String.format("Título: %s", titulo));
        System.out.println(String.format("Autor: %s", autor));
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
}
