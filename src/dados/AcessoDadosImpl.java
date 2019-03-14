package dados;

import java.io.*;
import java.util.ArrayList;
import java.util.*;
import domain.*;
import excecoes.*;

public class AcessoDadosImpl implements AcessoDados {

  //@Override
    public boolean existe(String nomeArquivo) throws AcessoDadosEx {
        File arquivo = new File(nomeArquivo);
        return arquivo.exists();
    }

    public List <Filme> listar(String nomeArquivo) throws LeituraDadosEx {
        File arquivo = new File(nomeArquivo);
        List <Filme> filmes = new ArrayList<Filme>();

        
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(arquivo));
            String linha = null;
            linha = entrada.readLine();
            while (linha != null) {
                Filme filme = new Filme(linha);
                filmes.add (filme);
                linha = entrada.readLine();
            }
            entrada.close();
        } catch (IOException execao) {
            execao.printStackTrace();
        }
        return filmes;
    }

    public void escrever(Filme filme, String nomeArquivo, boolean inserir) throws EscrituraDedadosEx {
        File arquivo = new File(nomeArquivo);
        try {
            PrintWriter saida = new PrintWriter(new FileWriter(arquivo, inserir));
            saida.println(filme.toString());
            saida.close();
            System.out.println("Registro inserido corretamente no arquivo ");
        } catch (IOException excecoes) {
            excecoes.printStackTrace();
        }
    }
        

    public String busca(String busca, String nomeArquivo) {
        File archivo = new File(nomeArquivo);
        String resultado = null;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            int i = 0;
            linea = entrada.readLine();
            while (linea != null) {
                if (busca != null && busca.equalsIgnoreCase(linea)) {
                    resultado = "Pelicula " + linea + " encontrada en indice " + i;
                    break;
                }
                linea = entrada.readLine();
                i++;
            }
            entrada.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }
    
    public void criar(String nomeArquivo) {
        File arquivo = new File(nomeArquivo);
        try {
            PrintWriter saida = new PrintWriter(new FileWriter(arquivo));
            saida.close();
            System.out.println("O arquivo foi criado corretamente");
        } catch (IOException excecao) {
            excecao.printStackTrace();
        }
    }


    public void apagar(String nomeArquivo) throws AcessoDadosEx {
        File archivo = new File(nomeArquivo);
        archivo.delete();
        System.out.println("Se ha borrado el archivo correctamente");
    }
}