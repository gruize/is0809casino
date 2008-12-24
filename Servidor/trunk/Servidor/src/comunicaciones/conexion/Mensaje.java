package comunicaciones.conexion;

import java.io.Serializable;
/**
 * Clase Mensaje abstracta que hace las funciones de interfaz
 * @author Francisco Huertas Y Gabriela Ruiz
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
	 * tipo del mensaje (ver las constantes para los tipos predeterminados)
	 */
	private int tipo;
	/**
	 * ID del origen del mensaje
	 */
	private String origen;
	/**
	 * ID del destino del mensaje
	 */
	private String destino;
	/**
	 * Prioridad del mesane TODO:no implementada
	 */
	private int prioridad;
	/**
	 * mascara del mesane TODO:no implementado
	 */
	private boolean mascara;
	// indica si el mensaje ha pasado por el servidor
	// si el mensaje ha pasado por el servidor no tiene
	// volver a el
	// TODO put procesado how protected
	public boolean procesado;
	/**
	 * Conctructor por defecto
	 */
	public Mensaje() {
		this.procesado = false;
		// TODO inicializar SIEMPRE el origen

	}
	
	/**
	 * Contructor del mensaje. Clona el mensaje pasado
	 * @param otro Mensaje que va a clonar
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
	 * Accedente de la mascara
	 * @return la mascara del mensaje
	 */
	public boolean getMascara() {
		return mascara;
	}
	/**
	 * Mutador de la mascara
	 * @param mascara 
	 */
	public void setMascara(boolean mascara) {
		this.mascara = mascara;
	}
	
	/**
	 * Accedente del tipo
	 * @return el tipo del mensaje
	 */
	public int getTipo() {
		return tipo;
	}

	/**
	 * Accedente del origen
	 * @return el origen a quien va a ser enviado el mesaje
	 */
	public String getOrigen() {
		return origen;
	}
	/**
	 * Accedente del destino
	 * @return destino del mensaje
	 */
	public String getDestino() {
		return destino;
	}
	
	/**
	 * Accedente de la prioridad
	 * @return prioridad del mensaje
	 */
	public int getPrioridad() {
		return prioridad;
	}
	
	/**
	 * Mutador del tipo
	 * @param tipo
	 */
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	/**
	 * Mutador del origen
	 * @param origen
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	/**
	 * Mutador del destino
	 * @param destino
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}
	/**
	 * Mutador de la prioridad
	 * @param prioridad
	 */
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	/**
	 * se clona a si mismo
	 * @return el mensaje clonado
	 */
	public abstract Mensaje clon();
	
	/**
	 * String del nombre de la clase
	 * @return El nombre de la clase
	 */
	public abstract String getClassName();
}
