package clinica;

public class Animal {

	private String nome;
	private String tipo;
	private String raca;
	private int idade;
	
	public Animal() {
		
	}
	
	public Animal(String nome, String tipo,String raca, int idade) {
		this.nome = nome;
		this.tipo = tipo;
		this.raca = raca;
		this.idade = idade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getRaca() {
		return raca;
	}
	
	public void setRaca(String raca) {
		this.raca = raca;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getTipoAnimal() {
		return tipo;
	}

	public void setTipoAnimal(String tipoAnimal) {
		this.tipo = tipoAnimal;
	}
	
	
}

