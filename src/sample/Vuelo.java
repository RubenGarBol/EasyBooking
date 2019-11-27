package sample;
import java.util.Date;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Vuelo {
	//Atributos
	@PrimaryKey
	private int codigo;
	@NotPersistent
	private Date fechaHoraSalida;
	@NotPersistent
	private Date fechaHoraLlegada;
	@NotPersistent
	private Aeropuerto aOrig;
	@NotPersistent
	private Aeropuerto aDest;
	@NotPersistent
	private Aerolinea aerolinea;
	@NotPersistent
	private int sistemaRegistro;
	@NotPersistent
	private int asientosLibres;

	//Constructor
	public Vuelo() {
		this.codigo = 0;
		this.fechaHoraSalida = null;
		this.fechaHoraLlegada = null;
		this.aDest = new Aeropuerto();
		this.aOrig = new Aeropuerto();
		this.sistemaRegistro = 0;
		this.asientosLibres = 0;
	}
	
	//Getters y Setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Aeropuerto getaOrig() {
		return aOrig;
	}

	public void setaOrig(Aeropuerto aOrig) {
		this.aOrig = aOrig;
	}

	public Aeropuerto getaDest() {
		return aDest;
	}

	public void setaDest(Aeropuerto aDest) {
		this.aDest = aDest;
	}

	public Aerolinea getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}
	
	public Date getFechaHoraSalida() {
		return fechaHoraSalida;
	}

	public void setFechaHoraSalida(Date fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}

	public Date getFechaHoraLlegada() {
		return fechaHoraLlegada;
	}

	public void setFechaHoraLlegada(Date fechaHoraLlegada) {
		this.fechaHoraLlegada = fechaHoraLlegada;
	}

	public int getSistemaRegistro() {
		return sistemaRegistro;
	}

	public void setSistemaRegistro(int sistemaRegistro) {
		this.sistemaRegistro = sistemaRegistro;
	}

	public int getAsientosLibres() {
		return asientosLibres;
	}

	public void setAsientosLibres(int asientosLibres) {
		this.asientosLibres = asientosLibres;
	}
}
