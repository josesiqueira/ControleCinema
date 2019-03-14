package transacao;

public interface CatalogoSessoes {

	public void inserirSessao(String nomeSessao, String nomeArquivoSessoes);
	// tirar Filme e deixar soh inserir (...)
	public void listarSessoes(String nomeArquivoSessoes);

	public void buscaSessao(String nomeArquivoSessao, String busca);

	public void iniciarArquivo(String nomeArquivoSessao);

	
}
