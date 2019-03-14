package transacao;

import java.util.List;
import dados.*;
import domain.*;
import excecoes.*;

public class CatalogoSessoesImpl implements CatalogoSessoes {
    private final AcessoDadosSessao dados;
    
    public CatalogoSessoesImpl() {
        this.dados = new AcessoDadosSessaoImpl();
    }
    
 
    //tem q ser o mesmo metodo da interface
    public void inserirSessao(String nomeSessao, String nomeArquivoSessoes) {
        Sessao sessao = new Sessao(nomeSessao);
        boolean inserir = false;
        try {
            inserir = dados.existe(nomeArquivoSessoes);
            dados.escrever(sessao, nomeArquivoSessoes, inserir);
        } catch (AcessoDadosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    }
    
    

    public void listarSessoes(String nomeArquivoSessoes) {
        try {
            List <Sessao> sessoes = dados.listar(nomeArquivoSessoes);
            for (Sessao sessao : sessoes) {
                System.out.println("Sessao:" + sessao);
            }
        } catch (AcessoDadosEx ex) {
            System.out.println("Erro de acesso a dados");
            ex.printStackTrace();
        }
    }
    
    

    public void buscaSessao(String nomeArquivo, String busca) {
        String resultado = null;
        try {
            resultado = dados.busca(busca, nomeArquivo);
        } catch (LeituraDadosEx ex) {
            System.out.println("Erro ao procurar o filme");
            ex.printStackTrace();
        }
        System.out.println("Resultado da pesquisa:" + resultado);
    }
    

    public void iniciarArquivo(String nomeArquivo) {
        try {
            if (dados.existe(nomeArquivo)) {
                dados.apagar(nomeArquivo);
                dados.criar(nomeArquivo);
            } else {
                //creamos archivo
                dados.criar(nomeArquivo);
            }
        } catch (AcessoDadosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    }

}

  