package modulo;

public class Club {
String nombre;
	Administracion adm;
	public Club(String nombre) {
		super();
		this.nombre = nombre;
		this.adm = new Administracion();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Administracion getAdm() {
		return adm;
	}
	public void setAdm(Administracion adm) {
		this.adm = adm;
	}
	@Override
	public String toString() {
		return "Club [nombre=" + nombre + ", adm=" + adm + "]";
	}

}
