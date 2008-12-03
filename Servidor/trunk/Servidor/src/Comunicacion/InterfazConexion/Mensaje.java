package Comunicacion.InterfazConexion;

public class Mensaje{

	private int tipo;
	private String contenido;
	private String origen;
	private String destino;
	private int prioridad;
	
	
	public int getTipo() {
		return tipo;
	}

	public String getContenido() {
		return contenido;
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

	public void setContenido(String contenido) {
		this.contenido = contenido;
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
}
