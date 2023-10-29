package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Articulo> articulos;
	private List<Compra> compras;
	
	
	
	public Sistema() {
		
		this.articulos = new ArrayList<Articulo>();
		this.compras = new ArrayList<Compra>();
	}
	public List<Articulo> getArticulos() {
		return articulos;
	}
	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}
	public List<Compra> getCompras() {
		return compras;
	}
	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	@Override
	public String toString() {
		return "Sistema [articulos=" + articulos + ", compras=" + compras + "]";
	}

	public Articulo traerArticulo(String detalle) {
		
		int i = 0;
		Articulo aux = null;
	    boolean encontrado = false;
	    
	    while (articulos.size()>i && !encontrado) {
	    	
	    	if (articulos.get(i).getDetalle().equalsIgnoreCase(detalle)){
	    		
	    		
	    		aux = articulos.get(i);
	    		encontrado = true;
	    	}
	    	i++;
	    	
	    }
	    return aux;
	}
	public boolean agregarArticulo(String detalle, double precio, Descuento descuento) throws Exception {
	
		if(traerArticulo(detalle) ==null) {
			
			int id = 1;
			
			if(articulos.size()> 0){
				
				id = articulos.get(articulos.size()-1).getId() +1;
				
			}
			
			Articulo a = new Articulo(id, detalle, precio, descuento);
			return articulos.add(a);
		}else {
			throw new Exception("el articulo ya existe");
		}
		
		
		
		
	}
	public boolean agregarCompra(int cantidad, Articulo articulo, LocalDateTime fechaHora) throws Exception {
		
		
			Compra c = new Compra(cantidad, articulo, fechaHora);
			return compras.add(c);
		
		
	}
	public List<Compra> traerCompras(LocalDateTime desde,LocalDateTime hasta ){
		List<Compra> aux = new ArrayList<Compra>();
		for (Compra c : compras) {
			
		if (c.getFechaHora().isEqual(desde)||c.getFechaHora().isAfter(desde) && c.getFechaHora().isBefore(hasta)||c.getFechaHora().isEqual(hasta)) {
			
			aux.add(c);
			
		}
		
		}
		return aux;
	}
	
	public List<Compra> traerComprasDescuentoPorCantidad(LocalDateTime desde,LocalDateTime hasta){
		
		List<Compra> retornar = new ArrayList<Compra>();
		
		List<Compra> aux = traerCompras( desde, hasta );
		
		for (Compra c : aux){
			
			if (c.getArticulo().getDescuento() instanceof DescuentoPorCantidad) {
				
				retornar.add(c);
			}
		}
		return retornar;
	}
	public List<Articulo> traerArticulosConDescuento(boolean activo){
		
		List<Articulo> aux = new ArrayList<Articulo>();
		
		for (Articulo a : articulos) {
			
			if(a.getDescuento().isActivo() == activo) {
				
				aux.add(a);
			}
			
		}
return aux;
}
}
