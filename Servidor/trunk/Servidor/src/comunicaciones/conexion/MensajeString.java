package comunicaciones.conexion;
/**
 * Mensaje cuyo contenido es un String
 * @author Francisco Huertas y Gabriela Ruiz
 * @version 0.1.227
 */
public class MensajeString extends Mensaje{
	
	private String contenido;
	/**
	 * Contructor por defecto del mensaje, el contenido por defecto es vacío
	 */
	public MensajeString() {
		super();
		this.contenido = "";
	}
	
	/**
	 * Contructor de copia del mensaje
	 * @param msg
	 */
	public MensajeString(MensajeString msg) {
		super(msg);
		this.contenido = msg.contenido;
	}
	/**
	 * Accedente del contenido
	 * @return el String contenido del mensaje
	 */
	public String getContenido() {
		return contenido;
	}
	/**
	 * Mutador del contenido
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


