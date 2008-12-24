package comunicaciones.conexion;
/**
 * Clase que describe la interfaz de una conexión
 * @author Francisco Huertas y Gabriela Ruiz
 * @version 0.1.227
 */
public interface InterfazConexion {
	//TODO: Crear clase conexion

	void eliminarConexion();
	/**
	 * Te devuelve el ID de una conexión
	 * @return el ID de la conexion
	 */
	public String getId();
	
	/**
	 * Envia un mensaje 
	 * @param message El mensaje que se envia
	 * @return El mensaje de retorno null en caso de error
	 */
	public Mensaje enviarMensaje(Mensaje message);
	
	/**
	 * Obtiene un mensaje que se encuentre en espera de ser leido
	 * @param mascara Mascara para recibir el mensaje (no implementado)
	 * @return
	 */
	public Mensaje obtenerMensaje( boolean mascara);
	
	/**
	 * obtiene el estado de la conexión con un entero representativo de la conexino
	 * (no implementada)
	 * @return El entero representativo del estado de la conexion
	 */
	int estadoConexion();

	/**
	 * Obtiene los parametros de configuración de la red 
	 * (no implementada)
	 * @return Los parametros de configuración o null en caso de que halla error
	 */
	public Config getConfig();
}

