package models;

public class DescuentoPorCantidad extends Descuento {

	private int cadaNUnidades;	
	private int unidadesGratis;
	
	
	public DescuentoPorCantidad(boolean activo, int cadaNUnidades, int unidadesGratis) {
		super(activo);
		this.cadaNUnidades = cadaNUnidades;
		this.unidadesGratis = unidadesGratis;
	}


	public int getCadaNUnidades() {
		return cadaNUnidades;
	}


	public void setCadaNUnidades(int cadaNUnidades) {
		this.cadaNUnidades = cadaNUnidades;
	}


	public int getUnidadesGratis() {
		return unidadesGratis;
	}


	public void setUnidadesGratis(int unidadesGratis) {
		this.unidadesGratis = unidadesGratis;
	}
	@Override
	public double calcularDescuentoParticular(int cantidad,double precio) {
		if(cantidad > cadaNUnidades ) {
		int aux = cantidad / cadaNUnidades;
		
		return (cantidad-aux)*precio;
		}else {
			
			
			return cantidad*precio;
		
		
		}
	}


	@Override
	public String toString() {
		return "DescuentoPorCantidad ["+ super.toString() +"cadaNUnidades=" + cadaNUnidades + ", unidadesGratis=" + unidadesGratis + "]";
	}
	
	
	
}
