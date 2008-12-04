package comunicaciones.conexion;

public class MensajeString extends Mensaje{
	
	private String contenido;
	
	public MensajeString(MensajeString otro) {
		super(otro);
		this.contenido = otro.contenido;
	}
	
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String nuevoContenido) {
		this.contenido = nuevoContenido;	
	}
	public Mensaje clon() {
		return new MensajeString(this);
	}
	public String getClassName() {
		return "MensajeString";
	}
}
