package modules;

import java.time.LocalDateTime;

public class Viaje {
	private Tarjeta tarjeta;
	private String linea;
	private String medio;
	private LocalDateTime fechaYHora;
	double precio;
	public Viaje(Tarjeta tarjeta, String linea, String medio, LocalDateTime fechaYHora, double precio) {
		super();
		this.tarjeta = tarjeta;
		this.linea = linea;
		this.medio = medio;
		this.fechaYHora = fechaYHora;
		this.precio = precio;
	}
	public Tarjeta getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	public String getLinea() {
		return linea;
	}
	public void setLinea(String linea) {
		this.linea = linea;
	}
	public String getMedio() {
		return medio;
	}
	public void setMedio(String medio) {
		this.medio = medio;
	}
	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}
	public void setFechaYHora(LocalDateTime fechaYHora) {
		this.fechaYHora = fechaYHora;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double totalAPagar() {
		
		if (tarjeta.getUsuario().isTieneDescuento()) {
			
			return precio - precio * 0.15;
		}else {return precio;}
	}
	@Override
	public String toString() {
		return "Viaje [tarjeta=" + tarjeta.getCodigo() + ", linea=" + linea + ", medio=" + medio + ", fechaYHora=" + fechaYHora
				+ ", precio=" + precio + "]\n";
	}

	
	
}
