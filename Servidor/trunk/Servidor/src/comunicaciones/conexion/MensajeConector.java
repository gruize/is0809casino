package comunicaciones.conexion;

import comunicaciones.demonio.*;

/**
 * Extension de la Clase mensaje que envia la informacion de otra persona (ID y IP)
 * @author Francisco Huertas y Gabriela Ruiz
 * @version 0.1.227
 */
public class MensajeConector extends Mensaje{
	
	private Conectores contenido;
	/**
	 * Contructor del mensaje predeterminado
	 */
	public MensajeConector() {
		super();
		this.contenido = null;
	}
	/**
	 * Constructor de copia
	 * @param msg mensaje desde donde copia
	 */
	public MensajeConector(MensajeConector msg) {
		super(msg);
		this.contenido = msg.contenido;
	}
	/**
	 * Acedente del contenido
	 * @return
	 */
	public Conectores getContenido() {
		return contenido;
	}
	/**
	 * Mutador del contenido
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