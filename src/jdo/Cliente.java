package jdo;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Cliente {
	
	//Atributos
	@PrimaryKey
	private String email;
	private SisReg sistemaRegistro;
	
	//Constructor
	public Cliente() {
		super();
		this.email = "";
		this.sistemaRegistro = null;
	}
	
	//Getters y Setters
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public SisReg getsistemaRegistro() {
		return sistemaRegistro;
	}
	public void setsistemaRegistro(SisReg sistemaRegistro) {
		this.sistemaRegistro = sistemaRegistro;
	}
}
