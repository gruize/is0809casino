package comunicaciones.conexion;

public interface InterfazConexion {
	//TODO: Crear clase conexion
	void crearConexion();
	void eliminarConexion();

	public String getId();
	
	void enviarMensaje(Mensaje message, String idDestino);
	//TODO:Mascaras
	Mensaje obtenerMensaje(String mascara);
	
	int estadoConexion();
}

