package domain;

public class Sala {

	   private String nome;

	    public Sala(String nome) {
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
