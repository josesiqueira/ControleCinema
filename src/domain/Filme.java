package domain;

public class Filme {

	   private String nome;

	    public Filme(String nome) {
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
