package modulo;

import java.util.Objects;


public class Profesor {

	private int cuil;
	private String nombreCompleto;
	@Override
	public String toString() {
		return "Profesor [cuil=" + cuil + ", nombreCompleto=" + nombreCompleto + "]";
	}
	public Profesor(int cuil, String nombreCompleto) {
		super();
		this.cuil = cuil;
		this.nombreCompleto = nombreCompleto;
	}
	public int getCuil() {
		return cuil;
	}
	public void setCuil(int cuil) {
		this.cuil = cuil;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	

}
