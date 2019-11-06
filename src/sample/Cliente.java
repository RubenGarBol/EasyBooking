package sample;
public class Cliente {
	
	//Atributos
	private String email;
	private SisReg sistema_registro;
	
	//Constructor
	public Cliente(String email, SisReg sistema_registro) {
		super();
		this.email = email;
		this.sistema_registro = sistema_registro;
	}
	
	//Getters y Setters
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public SisReg getSistema_registro() {
		return sistema_registro;
	}
	public void setSistema_registro(SisReg sistema_registro) {
		this.sistema_registro = sistema_registro;
	}
}

//  D:<
