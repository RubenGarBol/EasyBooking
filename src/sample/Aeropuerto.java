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
	public Aeropuerto(){
		this.codigo = 0;
		this.ciudad = "";
		this.pais = "";
		this.nombre = "";
	}

	//Getters y Setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
