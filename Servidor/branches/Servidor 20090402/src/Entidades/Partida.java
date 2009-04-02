package Entidades;

/**
 * Clase Mesa.
 * Clase que contiene los atributos y métodos que modelan a una partida.
 * @author Joaquín López Cabezas
 * @version 1.0
 *
 */
public class Partida {
	
	/**
	 * Atributo de tipo int que almacena el codigo de la partida
	 */
	private int codigo;
	
	/**
	 * Atributo de tipo int que almacena la mesa de la partida
	 */
	private int mesa;
	
	/**
	 * Atributo de tipo int que almacena el nummero de jugadores de la partida
	 */
	private int numJugadores;
	
	/**
	 * Atributo de tipo int que almacena el ganador de la partida
	 */
	private int ganador;
	
	/**
	 * Constructor por defecto.
	 *
	 */
	public Partida(){}
	
	/**
	 * Constructor.
	 * @param codigo Un int con el codigo de la partida.
	 * @param mesa Un String con la mesa de la partida.
	 * @param numJugadores Un String con el numero de jugadores de la partida.
	 * @param ganador Un int con el ganador de la partida.
	 *
	 */
	public Partida(int codigo, int mesa, int numJugadores,int ganador)
	{
		this.codigo=codigo;
		this.mesa=mesa;
		this.numJugadores=numJugadores;
		this.ganador=ganador;
		
	}
	
	/**
	 * Constructor.
	 * @param mesa Un String con la mesa de la partida.
	 * @param numJugadores Un String con el numero de jugadores de la partida.
	 * @param ganador Un int con el ganador de la partida.
	 *
	 */
	public Partida(int mesa, int numJugadores,int ganador)
	{
		this.mesa=mesa;
		this.numJugadores=numJugadores;
		this.ganador=ganador;
		
	}

	/**
	 * Metodo que devuelve el valor del atributo codigo de la partida.
	 * @return Un int con el codigo de la partida
	 */
	public int getCodigo() {
		return codigo;
	}
	
	/**
	 * Metodo que devuelve el valor del atributo mesa de la partida.
	 * @return Un int con la mesa de la partida
	 */
	public int getMesa() {
		return mesa;
	}
	
	/**
	 * Metodo que devuelve el valor del atributo ganador de la partida.
	 * @return Un int con el ganador de la partida
	 */
	public int getGanador() {
		return ganador;
	}
	
	/**
	 * Metodo que devuelve el valor del atributo numJugadores de la partida.
	 * @return Un int con numero de jugadores de la partida
	 */
	public int getNumJugadores() {
		return numJugadores;
	}

	
	/**
	 * Metodo que establece el valor del atributo codigo de la partida.
	 * @param codigo Un int con el codigo de la partida.
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Metodo que establece el valor del atributo mesa de la partida.
	 * @param mesa Un int con la mesa de la partida.
	 */
	public void setMesa(int mesa) {
		this.mesa = mesa;
	}
	
	/**
	 * Metodo que establece el valor del atributo jugador de la partida.
	 * @param jugador Un int con el jugador de la partida.
	 */
	public void setGanador(int jugador) {
		this.ganador = jugador;
	}
	
	/**
	 * Metodo que establece el valor del atributo jugadoresMin de la partida.
	 * @param jugadoresMin Un int con el numeor de juegadores de la partida.
	 */
	public void setNumJugadores(int numJugadores) {
		this.numJugadores = numJugadores;
	}
	
	
}
