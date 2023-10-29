package modulo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Servicio {
private int codigo;
private String nombre;
private ArrayList<LocalDate> reservas;
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public ArrayList<LocalDate> getFechas() {
	return reservas;
}
@Override
public String toString() {
	return "Servicio [nombre=" + nombre + ", reservas=" + reservas + "]";
}
public void setFechas(ArrayList<LocalDate> fechas) {
	this.reservas = fechas;
}

public Servicio(String nombre, int codigo) {
	super();
	this.nombre = nombre;
	this.codigo = codigo;
	this.reservas = new ArrayList<LocalDate>();
}
public boolean agregarHorario(LocalDate fe) {
	
	return this.reservas.add(fe);
}
public boolean reservado() {
	return reservas.isEmpty();
}
public int getCodigo() {
	return codigo;
}
public void setCodigo(int codigo) {
	this.codigo = codigo;
}
public ArrayList<LocalDate> getReservas() {
	return reservas;
}
public void setReservas(ArrayList<LocalDate> reservas) {
	this.reservas = reservas;
}

}
