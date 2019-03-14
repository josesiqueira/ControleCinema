package transacao;

public interface CatalogoFilmes {

    public void inserirFilme(String nomeFilme, String nomeArquivo);
// tirar Filme e deixar soh inserir (...)
    public void listarFilmes(String nomeArquivo);

    public void buscaFilme(String nomeArquivo, String busca);

    public void iniciarArquivo(String nomeArquivo);

}