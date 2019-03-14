package dados;

import java.util.List;
import domain.*;
import excecoes.*;

public interface  AcessoDadosSessao {
    boolean existe(String nomeArquivoSessoes) throws AcessoDadosEx;
    public List <Sessao> listar(String nomeArquivoSessoes) throws LeituraDadosEx;
    void escrever(Sessao sessao, String nombeArquivoSessoes, boolean inserir) throws EscrituraDedadosEx;
    public String busca(String nomeeArquivoSessoes, String buca) throws LeituraDadosEx;
    public void criar(String nomeArquivoSessoes) throws AcessoDadosEx;
    public void apagar(String nomeArquivoSessoes) throws AcessoDadosEx;
}
