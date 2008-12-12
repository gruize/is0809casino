package comunicaciones.conexion;

import comunicaciones.demonio.*;

public class MensajeConector extends Mensaje{
	
	private Conectores contenido;
	
	public MensajeConector() {
		super();
		this.contenido = null;
	}
	public MensajeConector(MensajeConector otro) {
		super(otro);
		this.contenido = otro.contenido;
	}
	
	public Conectores getContenido() {
		return contenido;
	}
	public void setContenido(Conectores nuevoContenido) {
		this.contenido = nuevoContenido;	
	}
	public Mensaje clon() {
		return new MensajeConector (this);
	}
	public String getClassName() {
		return "MensajeConector";
	}
}