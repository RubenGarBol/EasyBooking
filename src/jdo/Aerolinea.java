package jdo;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Aerolinea {

	//Atributos
	@PrimaryKey
	private int codigo;
	private String nombre;
	
	//Constructor
	public Aerolinea() {
		super();
		this.codigo = 0;
		this.nombre = "";
	}
	
	//Getters y Setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
}
