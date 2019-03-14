package dados;

import java.io.*;
import java.util.ArrayList;
import java.util.*;
import domain.*;
import excecoes.*;

public class AcessoDadosSalaImpl implements AcessoDadosSala {

  //@Override
    public boolean existe(String nomeArquivoSalas) throws AcessoDadosEx {
        File arquivo = new File(nomeArquivoSalas);
        return arquivo.exists();
    }

    public List <Sala> listar(String nomeArquivoSalas) throws LeituraDadosEx {
        File arquivo = new File(nomeArquivoSalas);
        List <Sala> salas = new ArrayList<Sala>();

        
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(arquivo));
            String linha = null;
            linha = entrada.readLine();
            while (linha != null) {
                Sala sala = new Sala(linha);
                salas.add (sala);
                linha = entrada.readLine();
            }
            entrada.close();
        } catch (IOException execao) {
            execao.printStackTrace();
        }
        return salas;
    }

    public void escrever(Sala sala, String nomeArquivoSalas, boolean inserir) throws EscrituraDedadosEx {
        File arquivo = new File(nomeArquivoSalas);
        try {
            PrintWriter saida = new PrintWriter(new FileWriter(arquivo, inserir));
            saida.println(sala.toString());
            saida.close();
            System.out.println("Sala inserida corretamente no arquivo ");
        } catch (IOException excecoes) {
            excecoes.printStackTrace();
        }
    }
        

    public String busca(String busca, String nomeArquivoSalas) {
        File archivo = new File(nomeArquivoSalas);
        String resultado = null;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            int i = 0;
            linea = entrada.readLine();
            while (linea != null) {
                if (busca != null && busca.equalsIgnoreCase(linea)) {
                    resultado = "Sala " + linea + " encontrada no indice " + i;
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
    
    public void criar(String nomeArquivoSalas) {
        File arquivo = new File(nomeArquivoSalas);
        try {
            PrintWriter saida = new PrintWriter(new FileWriter(arquivo));
            saida.close();
            System.out.println("O arquivo de Salas foi criado corretamente");
        } catch (IOException excecao) {
            excecao.printStackTrace();
        }
    }


    public void apagar(String nomeArquivoSalas) throws AcessoDadosEx {
        File archivo = new File(nomeArquivoSalas);
        archivo.delete();
        System.out.println("O arquivo foi apagado corretamente");
    }
}