package comunicaciones.conexion;
/**
 * Mensaje sistema no tiene contenido
 * @author Francisco Huertas y Gabriela Ruiz
 * @version 0.1.227
 */
public class MensajeSistema extends Mensaje{
		
	/**
	 * Constructor de un mensaje de tipo sistema
	 */
	public MensajeSistema() {
		super();
	}
	/**
	 * Contructor de copia
	 * @param otro
	 */
	public MensajeSistema(MensajeSistema msg) {
		super(msg);
	}
	@Override
	public Mensaje clon() {
		return new MensajeSistema(this);
	}
	@Override
	public String getClassName() {
		return "MensajeSistema";
	}
}
