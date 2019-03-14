package transacao;

public interface CatalogoGeral {

    public void inserir(String nome, String nomeArquivo);

    public void listar(String nomeArquivo);

    public void buscar(String nomeArquivo, String busca);

    public void iniciarArquivo(String nomeArquivo);

}