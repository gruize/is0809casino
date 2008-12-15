package Entidades;


/**
 * Clase Mesa.
 * Clase que contiene los atributos y métodos que modelan a una mesa.
 * @author Joaquín López Cabezas
 * @version 1.0
 *
 */
public class Mesa {
	
	
	/**
	 * Atributo de tipo int que almacena el codigo de la mesa
	 */
	private int codigo;
	
	/**
	 * Atributo de tipo int que almacena la sala de la mesa
	 */
	private int sala;
	
	/**
	 * Atributo de tipo int que almacena el puesto de la mesa
	 */
	private int puestos;
	
	/**
	 * Atributo de tipo int que almacena el numero de jugadores de la mesa
	 */
	private int jugadores;
	
	/**
	 * Atributo de tipo Number que almacena el valor de la apuesta minima de la mesa
	 */
	private Number apuestaMin;
	
	/**
	 * Atributo de tipo Number que almacena el valor de la apuesta maxima de la mesa
	 */
	private Number apuestaMax;
	
	/**
	 * Constructor por defecto.
	 *
	 */
	public Mesa(){}
	
	
	/**
	 * Constructor.
	 * @param codigo Un int con el codigo de la mesa.
	 * @param sala Un String con la sala de la mesa.
	 * @param puestos Un String con el puesto de la mesa.
	 * @param jugadores Un int con el número de jugadores de la mesa.
	 * @param apuestaMin Un Number con la apuesta minima.
	 * @param apuestaMax Un Number con la apuesta maxima.
	 *
	 */
	public Mesa(int codigo, int sala, int puestos, int jugadores, Number apuestaMin, Number apuestaMax)
	{
		this.codigo=codigo;
		this.sala=sala;
		this.puestos=puestos;
		this.jugadores=jugadores;
		this.apuestaMin=apuestaMin;
		this.apuestaMax=apuestaMax;
	}
	
	/**
	 * Constructor.
	 * @param sala Un String con la sala de la mesa.
	 * @param puestos Un String con el puesto de la mesao.
	 * @param jugadores Un int con el número de jugadores de la mesa.
	 * @param apuestaMin Un Number con la apuesta minima.
	 * @param apuestaMax Un Number con la apuesta maxima.
	 *
	 */
	public Mesa(int sala, int puestos, int jugadores, Number apuestaMin, Number apuestaMax)
	{
		this.sala=sala;
		this.puestos=puestos;
		this.jugadores=jugadores;
		this.apuestaMin=apuestaMin;
		this.apuestaMax=apuestaMax;
	}

	/**
	 * Metodo que devuelve el valor del atributo codigo de la mesa.
	 * @return Un int con el codigo de la mesa
	 */
	public int getCodigo() {
		return codigo;
	}
	
	/**
	 * Metodo que devuelve el valor del atributo codigo de la mesa.
	 * @return Un int con el codigo de la mesa
	 */
	public int getSala() {
		return sala;
	}
	
	/**
	 * Metodo que devuelve el valor del atributo puestos de la mesa.
	 * @return Un int con los puestos de la mesa
	 */
	public int getPuesto() {
		return puestos;
	}
	
	/**
	 * Metodo que devuelve el valor del atributo jugadores de la mesa.
	 * @return Un int con los jugadores de la mesa
	 */
	public int getJugadores() {
		return jugadores;
	}
	
	/**
	 * Metodo que devuelve el valor del atributo apuestaMax de la mesa.
	 * @return Un int con la apuesta maxima de la mesa
	 */
	public Number getApuestaMax() {
		return apuestaMax;
	}
	
	/**
	 * Metodo que devuelve el valor del atributo apuestaMin de la mesa.
	 * @return Un int con la apuesta minima de la mesa
	 */
	public Number getApuestaMin() {
		return apuestaMin;
	}
	
	/**
	 * Metodo que establece el valor del atributo codigo de la mesa.
	 * @param codigo Un int con el codigo de la mesa.
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Metodo que establece el valor del atributo sala de la mesa.
	 * @param sala Un int con la sala de la mesa.
	 */
	public void setSala(int sala) {
		this.sala = sala;
	}
	
	/**
	 * Metodo que establece el valor del atributo puesto de la mesa.
	 * @param puesto Un int con el puesto de la mesa.
	 */
	public void setPuesto(int puesto) {
		this.puestos = puesto;
	}
	
	/**
	 * Metodo que establece el valor del atributo jugadores de la mesa.
	 * @param jugadores Un int con los jugadores de la mesa.
	 */
	public void setJugadores(int jugadores) {
		this.jugadores = jugadores;
	}
	
	/**
	 * Metodo que establece el valor del atributo apuestaMin de la mesa.
	 * @param apuestaMin Un int con la apuesta minima de la mesa.
	 */
	public void setApuestaMin(Number apuestaMin) {
		this.apuestaMin = apuestaMin;
	}
	
	/**
	 * Metodo que establece el valor del atributo apuestaMax de la mesa.
	 * @param apuestaMax Un int con la apuesta maxima de la mesa.
	 */
	public void setApuestaMax(Number apuestaMax) {
		this.apuestaMax = apuestaMax;
	}
	
	
}
