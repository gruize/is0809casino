package comunicaciones.conexion;

public interface InterfazConexion {
	//TODO: Crear clase conexion

	void eliminarConexion();

	public String getId();
	
	public Mensaje enviarMensaje(Mensaje message);
	//TODO:Mascaras
	public Mensaje obtenerMensaje( boolean mascara);
	
	int estadoConexion();
}

