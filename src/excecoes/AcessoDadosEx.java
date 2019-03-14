package excecoes;

@SuppressWarnings("serial")
public class AcessoDadosEx extends Exception{
	  String mensagem ;

	   public AcessoDadosEx(String mensagem) {
	        this.mensagem = mensagem;
	    }
	            	  
}
