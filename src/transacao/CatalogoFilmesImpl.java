package transacao;

import java.util.List;
import dados.*;
import domain.*;
import excecoes.*;

public class CatalogoFilmesImpl implements CatalogoFilmes {
    private final AcessoDados dados;
    
    public CatalogoFilmesImpl() {
        this.dados = new AcessoDadosImpl();
    }
    
 
    //tem q ser o mesmo metodo da interface
    public void inserirFilme(String nomeFilme, String nomeArquivo) {
        Filme filme = new Filme(nomeFilme);
        boolean inserir = false;
        try {
            inserir = dados.existe(nomeArquivo);
            dados.escrever(filme, nomeArquivo, inserir);
        } catch (AcessoDadosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    }
    
    

    public void listarFilmes(String nomeArquivo) {
        try {
            List <Filme> filmes = dados.listar(nomeArquivo);
            for (Filme filme : filmes) {
                System.out.println("Filme:" + filme);
            }
        } catch (AcessoDadosEx ex) {
            System.out.println("Erro de acesso a dados");
            ex.printStackTrace();
        }
    }
    
    

    public void buscaFilme(String nomeArquivo, String busca) {
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

  