package comunicaciones.conexion;
/**
 * Message whose content is a String
 * @author Francisco Huertas and Gabriela Ruiz
 * @version 0.1.227
 */
public class MensajeString extends Mensaje{
	
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
	
	@Override
	public String getClassName() {
		return "MensajeString";
	}
}


