package sample;
import java.util.ArrayList;
import java.util.Date;


public class Reserva {

	//Atributos
	private int codigo;
	private Date fecha_reserva; // TODO �Es mejor usar un string con formato?
	private int cod_vuelo;
	private float importe;
	private SisPago metodo_pago;
	private ArrayList<String> nombrepasajeros;
	
	//Constructor
	public Reserva(int codigo, Date fecha_reserva, int cod_vuelo, float importe, SisPago metodo_pago,
			ArrayList<String> nombrepasajeros) {
		super();
		this.codigo = codigo;
		this.fecha_reserva = fecha_reserva;
		this.cod_vuelo = cod_vuelo;
		this.importe = importe;
		this.metodo_pago = metodo_pago;
		this.nombrepasajeros = nombrepasajeros;
	}
	//Getters y Setters
	public int getCodigo() {
		return codigo;
	}

	public Date getFecha_reserva() {
		return fecha_reserva;
	}

	public void setFecha_reserva(Date fecha_reserva) {
		this.fecha_reserva = fecha_reserva;
	}

	public int getCod_vuelo() {
		return cod_vuelo;
	}

	public void setCod_vuelo(int cod_vuelo) {
		this.cod_vuelo = cod_vuelo;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}
	
	public int getNumPasajeros() {
		return this.getNombrepasajeros().size();
	}

	public ArrayList<String> getNombrepasajeros() {
		return nombrepasajeros;
	}

	public void setNombrepasajeros(ArrayList<String> nombrepasajeros) {
		this.nombrepasajeros = nombrepasajeros;
	}
	
	
}
