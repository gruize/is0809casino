package comunicaciones.conexion;

public abstract class Mensaje{

	
	// TIPOS DE MENSAJES
	public final int CREATE_CONNECTION = 0;
	public final int OK = -1;
	public final int CLIENT_NOT_FOUND = -2;
	public final int GET_MESSAGE = -3;
	
	// CONFIGURACION
	public final int PUERTO = 10809;
	public final String HOST_SERVER = "127.0.0.1"; 

	private int tipo;
	private String origen;
	private String destino;
	private int prioridad;
	private boolean mascara;
	// indica si el mensaje ha pasado por el servidor
	// si el mensaje ha pasado por el servidor no tiene
	// volver a el
	// TODO put procesado how protected
	public boolean procesado;
	
	public Mensaje() {
		this.procesado = false;
		// TODO inicializar SIEMPRE el origen

	}
	public Mensaje(Mensaje otro) {
		this.tipo = otro.tipo;
		this.origen = otro.origen;
		this.destino = otro.destino;
		this.prioridad = otro.prioridad;
		this.mascara = otro.mascara;
		this.procesado = otro.procesado;
	}


	public boolean getMascara() {
		return mascara;
	}
	public void setMascara(boolean mascara) {
		this.mascara = mascara;
	}
	public int getTipo() {
		return tipo;
	}


	public String getOrigen() {
		return origen;
	}

	public String getDestino() {
		return destino;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	public abstract Mensaje clon();
	public abstract String getClassName();
}
