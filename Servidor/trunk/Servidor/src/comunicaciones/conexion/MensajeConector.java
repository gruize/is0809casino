package comunicaciones.conexion;

import comunicaciones.demonio.*;

/**
 * Extension of the Class Mensaje which sends the other person information (ID and IP)  
 * @author Francisco Huertas and Gabriela Ruiz
 * @version 0.1.227
 */
public class MensajeConector extends Mensaje{
	
	private Conectores contenido;
	/**
	 * Default Message Constructor 
	 */
	public MensajeConector() {
		super();
		this.contenido = null;
	}
	/**
	 * Copy constructor
	 * @param msg Message from where copy
	 */
	public MensajeConector(MensajeConector msg) {
		super(msg);
		this.contenido = msg.contenido;
	}
	/**
	 * Get the content
	 * @return
	 */
	public Conectores getContenido() {
		return contenido;
	}
	/**
	 * Set the content
	 * @param nuevoContenido
	 */
	public void setContenido(Conectores nuevoContenido) {
		this.contenido = nuevoContenido;	
	}
	
	@Override
	public Mensaje clon() {
		return new MensajeConector (this);
	}
	
	@Override
	public String getClassName() {
		return "MensajeConector";
	}
}