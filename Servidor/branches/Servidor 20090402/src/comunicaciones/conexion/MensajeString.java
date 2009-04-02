package comunicaciones.conexion;
/**
 * Message whose content is a String
 * @author Francisco Huertas and Gabriela Ruiz
 * @version 0.2.269
 */
public class MensajeString extends Mensaje{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4646770899219647512L;
	private String contenido;
	/**
	 * Default constructor of the message, the default content is empty.
	 */
	public MensajeString() {
		super();
		this.contenido = "";
	}
	
	/**
	 * Copy constructor
	 * @param msg
	 */
	public MensajeString(MensajeString msg) {
		super(msg);
		this.contenido = msg.contenido;
	}
	/**
	 * Get the content
	 * @return el String Content of the mesage
	 */
	public String getContenido() {
		return contenido;
	}
	/**
	 * Set the content
	 * @param nuevoContenido
	 */
	public void setContenido(String nuevoContenido) {
		this.contenido = nuevoContenido;	
	}
	@Override
	public Mensaje clon() {
		return new MensajeString(this);
	}
	
}


