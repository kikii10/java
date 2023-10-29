package models;

import java.time.LocalDateTime;

public class Compra {
	private int cantidad;
	private Articulo articulo;
	private LocalDateTime fechaHora;
	
	
	
	
	public Compra(int cantidad, Articulo articulo, LocalDateTime fechaHora) {
	
		try {
			setCantidad(cantidad);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.articulo = articulo;
		this.fechaHora = fechaHora;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) throws Exception {
       if(cantidad <= 0) {
			
			throw new Exception("la cantidad es invalida");
		}else {
		this.cantidad = cantidad;
		
		}
	}
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
	
	public double precioTotal() {
		
		return articulo.getDescuento().aplicarDescuento(cantidad, articulo.getPrecio());
	}
	
	@Override
	public String toString() {
		return "Compra [cantidad=" + cantidad + ", articulo detalle=" + articulo.getDetalle() + ", fechaHora=" + fechaHora + "]\n";
	}
	
	




}
