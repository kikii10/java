package modules;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SistemaSube {
	
	List<Usuario> usuarios;
	List<Tarjeta> tarjetas;
	List<Viaje> viajes;
	public SistemaSube() {
		super();
		this.usuarios = new ArrayList<Usuario>();
		this.tarjetas = new ArrayList<Tarjeta>();
		this.viajes = new ArrayList<Viaje>();
	}

	@Override
	public String toString() {
		return "SistemaSube [usuarios=" + usuarios + ", tarjetas=" + tarjetas + ", viajes=" + viajes + "]";
	}
	

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	

	public List<Tarjeta> getTarjetas() {
		return tarjetas;
	}

	

	public List<Viaje> getViajes() {
		return viajes;
	}

	

	public Usuario traerUsuario(long dni) {
		Usuario aux = null;
	int i = 0;
	boolean encontrado = false;
	
	while(i<usuarios.size() && !encontrado) {
		
		if(usuarios.get(i).getDni() == dni){ 
			
			aux= usuarios.get(i);
			encontrado = true;
		}
		
		i++;
	}
		
		
	return aux;	
		
	}
	public boolean agregarUsuario(long dni,String nombre,String apellido,boolean tieneDescuento) throws Exception {
		
		if (traerUsuario(dni) == null) {
			
			int id = 1;
			
			if (usuarios.size()>0) {
				
				id = usuarios.get(usuarios.size()-1).getId()+1;
				
				
			}
			Usuario u = new Usuario(id, dni, nombre, apellido, tieneDescuento);
			return usuarios.add(u);
			
			
		}else {
			throw new Exception ("el usuario ya existe");
		}
		
		
		
		
	}
public Tarjeta traerTarjeta(String codigo) {
	
	Tarjeta aux = null;
	int i = 0;
	boolean encontrado = false;
	
	while(i<tarjetas.size() && !encontrado) {
		
		if(tarjetas.get(i).getCodigo().equalsIgnoreCase(codigo)){ 
			
			aux= tarjetas.get(i);
			encontrado = true;
		}
		
		i++;
	}
		
		
	return aux;	
		
	}
	

public boolean agregarTarjeta(String codigo,Usuario usuario) throws Exception {
	
	
		
		Tarjeta t = new Tarjeta(codigo, usuario);
		
		return tarjetas.add(t);
	
	
}
public boolean agregarViaje(Tarjeta t, String linea,String medio, LocalDateTime fechaHoraViaje, Double precio) {
	
	Viaje v = new Viaje(t, linea, medio, fechaHoraViaje, precio);
	return viajes.add(v);
	
}
public List<Viaje> traerViaje(LocalDateTime desde, LocalDateTime hasta){
	
	List<Viaje> viajesAux = new ArrayList<Viaje>();
	
	for(Viaje v : viajes) {
		
		if (v.getFechaYHora().isEqual(desde) || v.getFechaYHora().isAfter(desde)  && v.getFechaYHora().isBefore(hasta) || v.getFechaYHora().isEqual(hasta)) {
			viajesAux.add(v);
		}
		
		
	}
	
	return viajesAux;
}
public double calcularTotalFacturadoEntreFechas(LocalDateTime desde, LocalDateTime hasta) {
	double total = 0;
	List<Viaje> v = traerViaje(desde, hasta);
    for(int i = 0; i<v.size(); i++) {
  	  
  	  System.out.println(v.get(i).toString());
  	  total = total + v.get(i).totalAPagar();
    }
    return total;
	
	
}
}
