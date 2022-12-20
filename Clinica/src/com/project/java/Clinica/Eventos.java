package clinica;
import java.util.ArrayList;
import java.util.Scanner;


public abstract class Eventos {
	
	static Scanner sc = new Scanner(System.in);
	public static ArrayList<Cliente> clientes = new ArrayList<>();
	public static ArrayList<Cliente> fila = new ArrayList<>();
	public static ArrayList<Veterinario> veterinarios = new ArrayList<>();
	static int index;
	
	public  void menuInicial() {
		while (true) {
			System.out.println("Menu Inicial");
			System.out.println("1 - Admin");
			System.out.println("2 - Veterinario");
			System.out.println("3 - Cliente");
			System.out.println("0 - Sair");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				menuAdmin();
				break;
			case 2:
				loginVetCheck();
				break;
			case 3:
				menuClienteInicial();
				break;
			case 0:
				break;
			default:
				System.out.println("Escolha invalida!");
			}
			if (choice == 0) {
				break;
			}
		}
	}


		//Funçoes ADMIN
		public  void menuAdmin() {
			Admin admin = new Admin();
			sc.nextLine();
			System.out.println("Login:");
			String login = sc.nextLine();
			System.out.println("Senha:");
			String senha = sc.nextLine();
			
			if (login.equals(admin.getLogin()) & senha.equals(admin.getSenha())){
				
				while(true) {
					System.out.println("**Menu Admin**");
					System.out.println("1 - Cadastrar Veterinario");
					System.out.println("2 - Demitir Veterinario");
					System.out.println("3 - Lista de Clientes");
					System.out.println("0 - Sair");
					int choice = sc.nextInt();
					
					switch(choice) {
					case 1:
						cadastroVeterinario();
						break;
					case 2:
						demitir();
						break;
					case 3:
						listaClientes();
						break;
					case 0:
						break;
					default:
						System.out.println("Escolha invalida!");
					}
					if (choice ==0) {
						break;
					}
					
				}
			} else {
				System.out.println("Dados invalidos!");
			}
			
		}
		public  void cadastroVeterinario() {
			System.out.println("Nome:");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.println("Idade:");
			int idade = sc.nextInt();
			System.out.println("Senha:");
			sc.nextLine();
			String senha = sc.nextLine();
			
			
			veterinarios.add(new Veterinario(nome, idade, senha));
			
		}
		
		public void demitir() {
			for(int i = 0;i<veterinarios.size();i++) {
				System.out.println("["+i+"]"+veterinarios.get(i).getNome());
			}
			System.out.println("Escolha o index do veterinarios que deseja demitir");
			int index = sc.nextInt();
			
			try {
				veterinarios.remove(index);
			} catch(IndexOutOfBoundsException e) {
				System.out.println("ERRO!");
			}
		}
		public void listaClientes() {
			for (int i=0;i<clientes.size();i++) {
				System.out.println("["+i+"]"
						+"Nome: "+clientes.get(i).getNome()
						+" Idade: "+clientes.get(i).getIdade()
						+" CPF: "+clientes.get(i).getCPF());
				System.out.println();
			}
		}
		
		//Funçoes Veterinario
		public void loginVetCheck() {
			sc.nextLine();
			System.out.println("Digite seu nome: ");
			String nome = sc.nextLine();
			System.out.println("Digite sua senha: ");
			String senha = sc.nextLine();
			
			
			for(int i = 0; i< veterinarios.size();i++) {
				if (nome.equals(veterinarios.get(i).getNome()) & senha.equals(veterinarios.get(i).getSenha())){  
					System.out.println("Bem Vindo "+veterinarios.get(i).getNome());
					index = i;
					menuVet();
				}else{
					System.out.println("Dados Invalidos");
				}
					
				}
			} 
		
		public void menuVet() {
			while(true) {
				if(fila.size()>=1) {
					System.out.println("Fila de consultas:");
					for(int i = 0;i<fila.size();i++) {
						System.out.println("["+i+"]"+"- Cliente: "+fila.get(i).getNome());
					}
					System.out.println("**Menu Veterinario**");
					System.out.println("1 - Atender proximo cliente");
					System.out.println("0 - Sair");
					int choice = sc.nextInt();
					
					switch(choice) {
					case 1:
						System.out.println("Atendimento atual: "+fila.get(0).getNome());
						fila.remove(0);
						break;
					case 0:
						break;
					default:
						System.out.println("Escolha Invalida");
					}
					if (choice == 0) {
						break;
					}
					
				}else {
					System.out.println("Sem consultas marcadas");
					break;
				}
			}
		}
		//Funçoes Cliente

		public void menuClienteInicial() {
			
			System.out.println("**Menu Cliente**");
				while(true) {
				System.out.println("1 - Login");
				System.out.println("2 - Novo Cadastro");
				System.out.println("0 - Voltar");
				int choice = sc.nextInt();
				
				switch(choice) {
				case 1:
					loginClientCheck();
					break;
				case 2:
					cadastrarCliente();
					break;
				case 0:
					break;
				default:
					System.out.println("Escolha invalida!");
				}
				if (choice ==0) {
					break;
				}
			}
			
		}
		public void cadastrarCliente() {
			sc.nextLine();
			System.out.println("Nome:");
			String nome = sc.nextLine();
			System.out.println("Idade:");
			int idade = sc.nextInt();
			sc.nextLine();
			System.out.println("CPF:");
			String CPF = sc.nextLine();
			System.out.println("Senha: ");
			String senha = sc.nextLine();
			
			clientes.add(new Cliente(nome, idade, CPF, senha));
		
		}
		
		public void loginClientCheck() {
			sc.nextLine();
			System.out.println("Digite seu nome: ");
			String nome = sc.nextLine();
			System.out.println("Digite sua senha: ");
			String senha = sc.nextLine();
			
			
			for(int i = 0; i< clientes.size();i++) {
				if (nome.equals(clientes.get(i).getNome()) & senha.equals(clientes.get(i).getSenha())){  
					System.out.println("Bem Vindo "+clientes.get(i).getNome());
					index = i;
					menuClienteFinal();
				}else{
					System.out.println("Dados Invalidos");
				}
					
				}
			} 
		
			public void menuClienteFinal() {
				while (true) {
					System.out.println("1 - Nova Consulta");
					System.out.println("2 - Cadastrar PET");
					System.out.println("0 - Sair ");
					int choice = sc.nextInt();
					
					switch(choice) {
					case 1:
						novaConsulta(index);
						break;
					case 2:
						cadastrarPET(index);
						break;
					case 0:
						break;
					default:
						System.out.println("Escolha Invalida");
					}
					if (choice == 0) {
						break;
					}
				}
				
		}
			public void cadastrarPET(int index) {
				System.out.println("Nome do PET:");
				sc.nextLine();
				String nome = sc.nextLine();
				System.out.println("Tipo do PET:");
				String tipo = sc.nextLine();
				System.out.println("Raça do PET:");
				String raça = sc.nextLine();
				System.out.println("Idade do PET:");
				int idade = sc.nextInt();
				
				ArrayList<Animal> animal = clientes.get(index).getAnimais();
				
				if (animal == null || animal.isEmpty()) {
					animal = new ArrayList<>();
				}
				
				animal.add(new Animal(nome, tipo, raça, idade));
				clientes.get(index).setAnimais(animal);
				
				for (int i = 0; i<clientes.get(index).getAnimais().size(); i++) {
					System.out.println("Nome do PET: "+clientes.get(index).getAnimais().get(i).getNome());
					System.out.println("Raça: "+clientes.get(index).getAnimais().get(i).getRaca());
					System.out.println("Idade: "+clientes.get(index).getAnimais().get(i).getIdade());
					}
			
			}
			
			public void novaConsulta(int index) {
				if(fila.contains(clientes.get(index))) {
					System.out.println("Sua Consulta ja foi marcada, Aguarde na fila");
				}else {
				System.out.println("Você foi colocado na fila de consultas, Aguarde sua vez!");
				fila.add(clientes.get(index));
			}
			}
}
