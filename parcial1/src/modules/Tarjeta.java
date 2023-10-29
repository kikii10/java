package modules;

public class Tarjeta {
	private String codigo;
	private Usuario usuario;
	public Tarjeta(String codigo, Usuario usuario) throws Exception {
		super();
		setCodigo(codigo);
		this.usuario = usuario;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) throws Exception {
		if (codigo.length() >= 10) {
		this.codigo = codigo;
		}else {
			throw new Exception ("el codigo es invalido");
		}
			
		
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "Tarjeta [codigo=" + codigo + ", usuario=" + usuario.getDni() + "]\n";
	}
	
	

}


