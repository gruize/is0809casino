package comunicaciones.conexion;

public interface InterfazConexion {
	//TODO: Crear clase conexion
	void crearConexion();
	void eliminarConexion();

	String getId();
	void setId(String id);
	
	void enviarMensaje(Mensaje message, String idDestino);
	//TODO:Mascaras
	Mensaje obtenerMensaje(String mascara);
	
	int estadoConexion();
}

