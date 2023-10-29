package models;

public abstract class Descuento {

	protected boolean activo;
	
	
	

	public Descuento(boolean activo) {
		super();
		this.activo = activo;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public abstract double calcularDescuentoParticular(int cantidad,double precio);
	
  public double aplicarDescuento(int cantidad, double precio){
		
		if(isActivo()) {
			
			return calcularDescuentoParticular(cantidad, precio);
			
		}
		else return cantidad * precio;
		
	}

	@Override
	public String toString() {
		return " [activo=" + activo + "]";
	}
	
	
	
	
}
