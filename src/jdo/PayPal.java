package jdo;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class PayPal extends Pago{
	
	//Atributos
	private String email;

	//Constructor
	public PayPal(int cod_pago, String email) {
		super(cod_pago);
		this.email = email;
	}

	//Getters y Setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
