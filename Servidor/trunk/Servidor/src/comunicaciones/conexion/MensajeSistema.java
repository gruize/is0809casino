package comunicaciones.conexion;

public class MensajeSistema extends Mensaje{
		
	public MensajeSistema() {
		super();
	}
	public MensajeSistema(MensajeSistema otro) {
		super(otro);
	}
	
	public Mensaje clon() {
		return new MensajeSistema(this);
	}
	public String getClassName() {
		return "MensajeSistema";
	}
}
