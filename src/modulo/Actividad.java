package modulo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import java.util.ArrayList;


public class Actividad {
	
String nombre;
int codigo;
ArrayList<Profesor> profes;
ArrayList<Socio> socios;
String horario ;

public Actividad(String nombre, int codigo,String horario) {
	super();
	this.nombre = nombre;
	this.codigo = codigo;
	this.profes = new ArrayList<Profesor>();
	this.socios = new ArrayList<Socio>();
	this.horario = horario;
}
public boolean agregarProfe(Profesor p) {
	if(profes.size()+1 <= 10) {
	return this.profes.add(p);}else {
	System.out.println("maximo de profesores alcanzado ");
}
	return false;	
}
public int getCodigo() {
	return codigo;
}
public void setCodigo(int codigo) {
	this.codigo = codigo;
}
public boolean agregarSocio(Socio s)  {
return socios.add(s);
}	   
public void agregarHorario(String fe) {

	 this.horario = fe;	
}
@Override
public String toString() {
	return "Actividad [nombre=" + nombre + "codigo=" + codigo + ", profes=" + profes + ", socios=" + socios + ", horario=" + horario + "]";
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public ArrayList<Profesor> getProfes() {
	return profes;
}
public void setProfes(ArrayList<Profesor> profes) {
	this.profes = profes;
}
public ArrayList<Socio> getSocios() {
	return socios;
}
public void setSocios(ArrayList<Socio> socios) {
	this.socios = socios;
}
public String getHorario() {
	return horario;
}
public void setHorarios(String horario) {
	this.horario = horario;
}

public void eliminarSocio(int buscar)throws Exception {

	
	for(int i = 0 ; i < socios.size() ; i++) {
		if(socios.get(i).getDni() == buscar) {
			socios.remove(i);
		}
	}
	
	
}
public void eliminarProfesor(int buscar)throws Exception {

	
	for(int i = 0 ; i < profes.size() ; i++) {
		if(profes.get(i).getCuil() == buscar) {
			profes.remove(i);
		}
	}
	
	
}
}
