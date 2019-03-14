package dados;

import java.util.List;
import domain.*;
import excecoes.*;

public interface  AcessoDadosSala {
    boolean existe(String nomeArquivoSalas) throws AcessoDadosEx;
    public List <Sala> listar(String nomeArquivoSalas) throws LeituraDadosEx;
    void escrever(Sala sala, String nomeArquivoSalas, boolean inserir) throws EscrituraDedadosEx;
    public String busca(String nomeeArquivoSalas, String buca) throws LeituraDadosEx;
    public void criar(String nomeArquivoSalas) throws AcessoDadosEx;
    public void apagar(String nomeArquivoSalas) throws AcessoDadosEx;
}
