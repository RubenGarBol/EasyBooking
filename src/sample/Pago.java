package sample;
public abstract class Pago {
	//Atributos 
	private int cod_pago;

	//Constructor
	public Pago(int cod_pago) {
		this.cod_pago = cod_pago;
	}

	//Gettters y Setters
	public int getCod_pago() {
		return cod_pago;
	}
}
