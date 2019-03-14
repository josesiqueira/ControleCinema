
package transacao;

import java.util.List;
import dados.*;
import domain.*;
import excecoes.*;

public class CatalogoSalasImpl implements CatalogoSalas {
    private final AcessoDadosSala dados;
    
    public CatalogoSalasImpl() {
        this.dados = new AcessoDadosSalaImpl();
    }
    
 
    //tem q ser o mesmo metodo da interface
    public void inserirSala(String nomeSala, String nomeArquivoSalas) {
        Sala sala = new Sala(nomeSala);
        boolean inserir = false;
        try {
            inserir = dados.existe(nomeArquivoSalas);
            dados.escrever(sala, nomeArquivoSalas, inserir);
        } catch (AcessoDadosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    }
    
    

    public void listarSalas(String nomeArquivoSalas) {
        try {
            List <Sala> salas = dados.listar(nomeArquivoSalas);
            for (Sala sala : salas) {
                System.out.println("Sala:" + sala);
            }
        } catch (AcessoDadosEx ex) {
            System.out.println("Erro de acesso a dados da sala");
            ex.printStackTrace();
        }
    }
    
    

    public void buscaSala(String nomeArquivoSalas, String busca) {
        String resultado = null;
        try {
            resultado = dados.busca(busca, nomeArquivoSalas);
        } catch (LeituraDadosEx ex) {
            System.out.println("Erro ao procurar a sala");
            ex.printStackTrace();
        }
        System.out.println("Resultado da pesquisa:" + resultado);
    }
    

    public void iniciarArquivo(String nomeArquivoSalas) {
        try {
            if (dados.existe(nomeArquivoSalas)) {
                dados.apagar(nomeArquivoSalas);
                dados.criar(nomeArquivoSalas);
            } else {
                //creamos archivo
                dados.criar(nomeArquivoSalas);
            }
        } catch (AcessoDadosEx ex) {
            System.out.println("Error de acceso a dados das Salas");
            ex.printStackTrace();
        }
    }

}

  