package entidades;

public class Ebook extends ItemAcervo {
    private String tamanhoArquivoMB;

    public Ebook(String titulo, String autor, String conteudo, String tamanhoArquivoMB) {
        setAutor(autor);
        setTitulo(titulo);
        setConteudo(conteudo);

        this.tamanhoArquivoMB = tamanhoArquivoMB;
    }

    public String getTamanhoArquivoMB() {
        return tamanhoArquivoMB;
    }

    public void setTamanhoArquivoMB(String tamanhoArquivoMB) {
        this.tamanhoArquivoMB = tamanhoArquivoMB;
    }
}
