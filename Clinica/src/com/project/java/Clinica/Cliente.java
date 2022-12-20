package clinica;

import java.util.ArrayList;



public class Cliente extends Pessoa {

	private String senha;
	private String CPF;
	private ArrayList<Animal> animais;
	
	public Cliente() {
		
	}
	
	public Cliente(String nome,int idade, String CPF,String senha) {
		super(nome,idade);
		this.CPF = CPF;
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public ArrayList<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(ArrayList<Animal> animais) {
		this.animais = animais;
	}
}
