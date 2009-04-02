package comunicaciones.conexion;
/**
 * Message Sistema, it doesn't have content
 * @author Francisco Huertas and Gabriela Ruiz
 * @version 0.2.269
 */
public class MensajeSistema extends Mensaje{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 4458722895040865845L;
	/**
	 * Constructor of a message-type system
	 */
	public MensajeSistema() {
		super();
	}
	/**
	 * Copy constructor
	 * @param otro
	 */
	public MensajeSistema(MensajeSistema msg) {
		super(msg);
	}
	@Override
	public Mensaje clon() {
		return new MensajeSistema(this);
	}

}
