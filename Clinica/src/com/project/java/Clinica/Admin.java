package clinica;

public class Admin extends Pessoa {

	private String login = "admin";
	private String senha = "admin";
	
	
	public Admin() {
		
	}
	
	public Admin(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
