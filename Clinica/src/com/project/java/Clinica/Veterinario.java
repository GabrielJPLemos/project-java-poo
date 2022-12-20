package clinica;

public class Veterinario extends Pessoa {
	
	private String senha;
	
	
	public Veterinario() {
		
	}
	
	public Veterinario(String nome, int idade, String senha) {
		super(nome,idade);
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
