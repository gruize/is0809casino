package comunicaciones.conexion;
/**
 * Class that describes the interface of a connection
 * @author Francisco Huertas and Gabriela Ruiz
 * @version 0.2.269
 */
public interface InterfazConexion {
	//TODO: Crear clase conexion

	/**
	 * Remove the connection
	 */
	void eliminarConexion();
	/**
	 * Return the id of the connection
	 * @return el ID de la conexion
	 */
	public String getId();
	
	/**
	 * Send a message 
	 * @param message The message that is sent
	 * @return The message returned is null in error case
	 */
	public Mensaje enviarMensaje(Mensaje message);
	
	/**
	 * Call to obtenerMensaje with mascara = -1
	 * @param espera Indica si a la hora de obtener el mensaje tiene que esperar <br>
	 * 			a que exista un mensaje en la cola de espera
	 * @return Message
	 */
	public Mensaje obtenerMensaje(boolean espera);

	/**
	 * Gets a message that is waiting of being read
	 * @param espera Indica si a la hora de obtener el mensaje tiene que esperar <br>
	 * 			a que exista un mensaje en la cola de espera
	 * @param mascara Mask to recive the message (not implemented)
	 * @return Message
	 */
	public Mensaje obtenerMensaje(int mascara, boolean espera);
	
	/**
	 * Gets the connection state with a integer representative of the connection
	 * (not implemented)
	 * @return The integer representativo of the state connection
	 */
	int estadoConexion();

	/**
	 * Gets the configuration parameters of the network 
	 * (not implemented)
	 * @return The configuration parameters or null in error case
	 */
	public Config getConfig();
}

