package transacao;

public interface CatalogoSalas {

	public void inserirSala(String nomeSala, String nomeArquivoSalas);
	
	public void listarSalas(String nomeArquivoSalas);

	public void buscaSala(String nomeArquivoSalas, String busca);

	public void iniciarArquivo(String nomeArquivoSalas);

	
}
