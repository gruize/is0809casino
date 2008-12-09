package comunicaciones.conexion;

public abstract class Mensaje{

	public final int CREAR_CONEXION = 0;
	public final int OK = -1;

	private int tipo;
	private String origen;
	private String destino;
	private int prioridad;
	private int mascara;
	public Mensaje() {
		
	}
	public Mensaje(Mensaje otro) {
		this.tipo = otro.tipo;
		this.origen = otro.origen;
		this.destino = otro.destino;
		this.prioridad = otro.prioridad;
		this.mascara = otro.mascara;
	}


	public int getMascara() {
		return mascara;
	}
	public void setMascara(int mascara) {
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
