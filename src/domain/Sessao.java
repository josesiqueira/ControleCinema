package domain;

public class Sessao {

	   private String nome;

	    public Sessao(String nome) {
	        this.nome = nome;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    @Override
	    public String toString() {
	        return this.nome;
	    }
	

}
