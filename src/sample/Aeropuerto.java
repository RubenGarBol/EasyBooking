package sample;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Aeropuerto {

	//Atributos 
	private int codigo;
	private String ciudad;
	private String pais;
	private String nombre;
	//Constructor
	public Aeropuerto(int codigo, String ciudad, String pais, String nombre) {
		this.codigo = codigo;
		this.ciudad = ciudad;
		this.pais = pais;
		this.nombre = nombre;
	}

	//Getters y Setters
	public int getCodigo() {
		return codigo;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		pais = pais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
