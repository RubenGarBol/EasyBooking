package sample;
import java.util.ArrayList;
import java.util.Date;

import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reserva {

	//Atributos
	@PrimaryKey
	private int codigo;
	@NotPersistent
	private Date fechaReserva;
	@NotPersistent
	private Vuelo vuelo;
	@NotPersistent
	private float importe;
	@NotPersistent
	private SisPago metodoPago;
	@NotPersistent
	private ArrayList<String> nombrePasajeros;
	
	//Constructor
	public Reserva() {
		this.codigo = 0;
		this.fechaReserva = null;
		this.vuelo = new Vuelo();
		this.importe = 0;
		this.metodoPago = null;
		this.nombrePasajeros = new ArrayList<String>();
	}

	//Getters y Setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}
	
	public int getNumPasajeros() {
		return this.getNombrePasajeros().size();
	}

	public ArrayList<String> getNombrePasajeros() {
		return nombrePasajeros;
	}

	public void addNombrePasajero(String nom){
		this.getNombrePasajeros().add(nom);
	}

	public void removeNombrePasajero(String nom){
		this.getNombrePasajeros().remove(nom);
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public SisPago getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(SisPago metodoPago) {
		this.metodoPago = metodoPago;
	}

	public void setNombrePasajeros(ArrayList<String> nombrePasajeros) {
		this.nombrePasajeros = nombrePasajeros;
	}
}
