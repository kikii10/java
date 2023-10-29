package models;

public class Articulo {
	private int id;
	private String detalle;
	private double precio;
	private Descuento descuento;
	
	
	public Articulo(int id, String detalle, double precio, Descuento descuento) {
		
		this.id = id;
		this.detalle = detalle;
		this.precio = precio;
		this.descuento = descuento;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Descuento getDescuento() {
		return descuento;
	}
	public void setDescuento(Descuento descuento) {
		this.descuento = descuento;
	}
	@Override
	public String toString() {
		return "Articulo [id=" + id + ", detalle=" + detalle + ", precio=" + precio +  descuento + "]\n";
	}

	
	
}
