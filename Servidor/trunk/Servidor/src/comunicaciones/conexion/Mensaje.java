package comunicaciones.conexion;

import java.io.Serializable;
/**
 * 
 * Class Mensaje, abstract, which makes the inteface functions.
 * @author Francisco Huertas and Gabriela Ruiz
 * @version 0.1.227
 */
public abstract class Mensaje implements Serializable
{

	
	// TIPOS DE MENSAJES


	private static final long serialVersionUID = 1L;
	public final int CREATE_CONNECTION = 0;
	public final int OK = -1;
	public final int CLIENT_NOT_FOUND = -2;
	
	public final int SEND_MESSAGE = -7;
	public final int READ_MESSAGE_NO_WAIT = -14;
	public final int READ_MESSAGE_WAIT = -15;
	public final int NOT_MESSAGE = -16;
	
	// CONFIGURACION
	public final int PUERTO = 40809;
	public final String HOST_SERVER = "147.96.82.202"; 

	/**
	 * Message type (See the constants for the default types)
	 */
	private int tipo;
	/**
	 * ID of the origin of the message
	 */
	private String origen;
	/**
	 * ID of the destination of the message
	 */
	private String destino;
	/**
	 * Priority message
	 * TODO:
	 * (Not implemented)
	 */
	private int prioridad;
	/**
	 * Mask of the message
	 * TODO:
	 * (Not implemented)
	 */
	private boolean mascara;
	/**
	 * Indicates if the message had passed by the server
	 * If the message had passed by the server,it doesn't have to pass again
	 * TODO put procesado how protected
	 */
	public boolean procesado;
	/**
	 * Default constructor
	 */
	public Mensaje() {
		this.procesado = false;
		// TODO inicializar SIEMPRE el origen

	}
	
	/**
	 * Constructor's message. Clone the message passed.
	 * @param otro Message to be cloned
	 */
	public Mensaje(Mensaje otro) {
		this.tipo = otro.tipo;
		this.origen = otro.origen;
		this.destino = otro.destino;
		this.prioridad = otro.prioridad;
		this.mascara = otro.mascara;
		this.procesado = otro.procesado;
	}

	/**
	 * Get the mask
	 * @return The mask of the message
	 */
	public boolean getMascara() {
		return mascara;
	}
	/**
	 * Set the mask
	 * @param mascara Te mask of the message 
	 */
	public void setMascara(boolean mascara) {
		this.mascara = mascara;
	}
	
	/**
	 * Get the type of the message
	 * @return The type of the message
	 */
	public int getTipo() {
		return tipo;
	}

	/**
	 * Get the origin
	 * @return The origin since where the message is sent
	 */
	public String getOrigen() {
		return origen;
	}
	/**
	 * Get the destination
	 * @return Destination of the message
	 */
	public String getDestino() {
		return destino;
	}
	
	/**
	 * Get the priority
	 * @return priority of the message
	 */
	public int getPrioridad() {
		return prioridad;
	}
	
	/**
	 * Set the type
	 * @param Type
	 */
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	/**
	 * Set the origin
	 * @param Origin
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	/**
	 * Set the destination
	 * @param destino Destination
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}
	/**
	 * Set the priority
	 * @param prioridad
	 */
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	/**
	 * Generates a clone of himself
	 * @return The message cloned
	 */
	public abstract Mensaje clon();
	
	/**
	 * Get the name of the class
	 * @return The name of the class
	 */
	public abstract String getClassName();
}
