package modulo;

import java.util.Objects;


public class Socio {
	private int dni;
	private String nombreCompleto;
	@Override
	public String toString() {
		return "Socio [dni=" + dni + ", nombreCompleto=" + nombreCompleto + "]";
	}
	public Socio(int dni, String nombreCompleto) {
		super();
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	

	

}
