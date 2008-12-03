package Comunicacion.InterfazConexion;

public interface InterfazConexion {
	//TODO: Crear clase conexion
	void crearConexion();
	void eliminarConexion();

	String getId();
	void setId(String id);
	
	void enviarMensaje(Mensaje message, String idDestino);
	//TODO:Mascaras
	Mensaje obtenerMensaje();
	
	int estadoConexion();
}

