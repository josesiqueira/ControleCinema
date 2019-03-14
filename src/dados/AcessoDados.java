package dados;

import java.util.List;
import domain.*;
import excecoes.*;

public interface  AcessoDados {
    boolean existe(String nomeArquivo) throws AcessoDadosEx;
    public List <Filme> listar(String nomeArquivo) throws LeituraDadosEx;
    void escrever(Filme filme, String nombeArquivo, boolean inserir) throws EscrituraDedadosEx;
    public String busca(String nomeeArquivo, String buca) throws LeituraDadosEx;
    public void criar(String nomeArquivo) throws AcessoDadosEx;
    public void apagar(String nomeArquivo) throws AcessoDadosEx;
}
