package sample;
public class Aerolinea {

	//Atributos 
	private int codigo;
	private String nombre;
	
	//Constructor
	public Aerolinea(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	//Getters y Setters
	public int getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
}
