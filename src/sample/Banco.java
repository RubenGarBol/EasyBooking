package sample;
import java.util.Date;

public class Banco extends Pago{

	//Atributos
	private long num_cuenta;
	private Date fecha_caducidad; // TODO �Es mejor usar un string con formato?

	//Constructor
	public Banco(int cod_pago, long num_cuenta, Date fecha_caducidad) {
		super(cod_pago);
		this.num_cuenta = num_cuenta;
		this.fecha_caducidad = fecha_caducidad;
	}
	
	//Getters y Setters
	public long getNum_cuenta() {
		return num_cuenta;
	}
	public void setNum_cuenta(long num_cuenta) {
		this.num_cuenta = num_cuenta;
	}
	public Date getFecha_caducidad() {
		return fecha_caducidad;
	}
	public void setFecha_caducidad(Date fecha_caducidad) {
		this.fecha_caducidad = fecha_caducidad;
	}
}
