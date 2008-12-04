package Entidades;


/**
 * Clase Mesa.
 * Clase que contiene los atributos y métodos que modelan a un participante.
 * @author Joaquín López Cabezas
 * @version 1.0
 *
 */
public class Participante {
	
	/**
	 * Atributo de tipo int que almacena el partida del participante
	 */
	private int partida;
	
	/**
	 * Atributo de tipo int que almacena el jugador del participante
	 */
	private int jugador;
	
	/**
	 * Constructor por defecto.
	 *
	 */
	public Participante(){}
	
	/**
	 * Constructor.
	 * @param partida Un int con la partida del participante.
	 * @param jugador Un String con el jugador del participante.
	 * 
	 */
	public Participante(int partida, int jugador)
	{
		this.partida=partida;
		this.jugador=jugador;
	}
	
	/**
	 * Metodo que devuelve el valor del atributo partida del participante.
	 * @return Un int con la partida del participante
	 */
	public int getPartida() {
		return partida;
	}
	
	/**
	 * Metodo que devuelve el valor del atributo jugador del participante.
	 * @return Un int con el jugador del participante
	 */
	public int getJugador() {
		return jugador;
	}
	
	/**
	 * Metodo que establece el valor del atributo partida del participante.
	 * @param partida Un int con la partida del participante.
	 */
	public void setPartida(int partida) {
		this.partida = partida;
	}
	
	/**
	 * Metodo que establece el valor del atributo jugador del participante.
	 * @param jugador Un int con el jugador del participante.
	 */
	public void setJugador(int jugador) {
		this.jugador = jugador;
	}
	
}
