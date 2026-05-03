package entidades;

public class RevistaDigital extends ItemAcervo {
    private String numeroEdicao;

    public RevistaDigital(String titulo, String autor, String conteudo, String numeroEdicao) {
        setAutor(autor);
        setTitulo(titulo);
        setConteudo(conteudo);

        this.numeroEdicao = numeroEdicao;
    }

    public String getNumeroEdicao() {
        return numeroEdicao;
    }

    public void setNumeroEdicao(String numeroEdicao) {
        this.numeroEdicao = numeroEdicao;
    }
}
