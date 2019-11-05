package sample;
import java.util.Date;

public class Vuelo {
	//Atributos
	private int codigo;
	private Date fecha_hora_salida;// TODO �Es mejor usar un string con formato?
	private Date fecha_hora_llegada;// TODO �Es mejor usar un string con formato?
	private int cod_aeropuerto_orig;
	private int cod_aeropuerto_dest;
	private int cod_aerolinea;	
	private int asientos_totales;
	private int asientos_libres;
	
	//Constructor
	public Vuelo(int codigo, Date fecha_hora_salida, Date fecha_hora_llegada, int asientos_totales,
			int asientos_libres) {
		this.codigo = codigo;
		this.fecha_hora_salida = fecha_hora_salida;
		this.fecha_hora_llegada = fecha_hora_llegada;
		this.asientos_totales = asientos_totales;
		this.asientos_libres = asientos_libres;
	}
	
	//Getters y Setters
	public int getCodigo() {
		return codigo;
	}
	
	public Date getFecha_hora_salida() {
		return fecha_hora_salida;
	}

	public void setFecha_hora_salida(Date fecha_hora_salida) {
		this.fecha_hora_salida = fecha_hora_salida;
	}

	public Date getFecha_hora_llegada() {
		return fecha_hora_llegada;
	}

	public void setFecha_hora_llegada(Date fecha_hora_llegada) {
		this.fecha_hora_llegada = fecha_hora_llegada;
	}	

	public int getCod_aeropuerto_orig() {
		return cod_aeropuerto_orig;
	}

	public void setCod_aeropuerto_orig(int cod_aeropuerto_orig) {
		this.cod_aeropuerto_orig = cod_aeropuerto_orig;
	}

	public int getCod_aeropuerto_dest() {
		return cod_aeropuerto_dest;
	}

	public void setCod_aeropuerto_dest(int cod_aeropuerto_dest) {
		this.cod_aeropuerto_dest = cod_aeropuerto_dest;
	}

	public int getCod_aerolinea() {
		return cod_aerolinea;
	}

	public void setCod_aerolinea(int cod_aerolinea) {
		this.cod_aerolinea = cod_aerolinea;
	}

	public int getAsientos_totales() {
		return asientos_totales;
	}

	public void setAsientos_totales(int asientos_totales) {
		this.asientos_totales = asientos_totales;
	}

	public int getAsientos_libres() {
		return asientos_libres;
	}

	public void setAsientos_libres(int asientos_libres) {
		this.asientos_libres = asientos_libres;
	}
	
	
	

}
