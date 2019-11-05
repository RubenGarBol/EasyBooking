package sample;
public class Aerolinea {

	//Atributos 
	private int codigo;
	private String name;
	
	//Constructor
	public Aerolinea(int codigo, String name) {
		super();
		this.codigo = codigo; //Hola
		this.name = name;
	}
	
	//Getters y Setters
	public int getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return name;
	}
}
