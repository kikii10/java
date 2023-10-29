package models;

public class DescuentoPorSubTotal extends Descuento {
	private int aplicarDesdeVAlor;
	private int porcentajeDescuento;
	
	
	public DescuentoPorSubTotal(boolean activo, int aplicarDesdeVAlor, int porcentajeDescuento) {
		super(activo);
		this.aplicarDesdeVAlor = aplicarDesdeVAlor;
		this.porcentajeDescuento = porcentajeDescuento;
	}


	public int getAplicarDesdeVAlor() {
		return aplicarDesdeVAlor;
	}


	public void setAplicarDesdeVAlor(int aplicarDesdeVAlor) {
		this.aplicarDesdeVAlor = aplicarDesdeVAlor;
	}


	public int getPorcentajeDescuento() {
		return porcentajeDescuento;
	}


	public void setPorcentajeDescuento(int porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}
	@Override
	public double calcularDescuentoParticular(int cantidad,double precio) {
		
		double aux = cantidad * precio;
		
		if ( aux > aplicarDesdeVAlor) {
			
		aux = (porcentajeDescuento / 100) * aux ;
			
		}
		return aux;
	}


	@Override
	public String toString() {
		return "DescuentoPorSubTotal ["+ super.toString() +"aplicarDesdeVAlor=" + aplicarDesdeVAlor + ", porcentajeDescuento="
				+ porcentajeDescuento + "]";
	}
	
	
	

	

}
