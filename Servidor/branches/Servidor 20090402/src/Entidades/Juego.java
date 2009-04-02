package Entidades;

/**
 * Clase Juego.
 * Clase que contiene los atributos y métodos que modelan a un juego.
 * @author Joaquín López Cabezas
 * @version 1.0
 *
 */
public class Juego {
	
	/**
	 * Atributo de tipo int que almacena el codigo del juego
	 */
	private int codigo;
	
	/**
	 * Atributo de tipo String que almacena el nombre del juego
	 */
	private String nombre;
	
	/**
	 * Atributo de tipo int que almacena el número mínimo de jugadores del juego
	 */
	private int jugadoresMin;
	
	/**
	 * Atributo de tipo String que almacena las reglas del juego
	 */
	private String reglas;
	
	/**
	 * Constructor por defecto.
	 *
	 */
	public Juego()	{}
	
	
	/**
	 * Constructor.
	 * @param codigo Un int con el codigo del juego.
	 * @param nombre Un String con el el nombre del juego.
	 * @param jugadoresMin Un int con el número mínimo de jugadores del juego.
	 * @param reglas Un String con las reglas del juego.
	 *
	 */
	public Juego(int codigo, String nombre, int jugadoresMin, String reglas)
	{
		this.codigo=codigo;
		this.nombre=nombre;
		this.jugadoresMin=jugadoresMin;
		this.reglas=reglas;
		
	}
	
	/**
	 * Constructor sin codigo porque se lo asigna la base de datos automáticamente.
	 * @param nombre Un String con el el nombre del juego.
	 * @param jugadoresMin Un int con el número mínimo de jugadores del juego.
	 * @param reglas Un String con las reglas del juego.
	 *
	 */
	public Juego(String nombre, int jugadoresMin, String reglas)
	{
		this.nombre=nombre;
		this.jugadoresMin=jugadoresMin;
		this.reglas=reglas;
		
	}
	
	/**
	 * Metodo que devuelve el valor del atributo codigo del juego.
	 * @return Un int con el codigo del juego
	 */
	public int getCodigo() {
		return codigo;
	}
	
	/**
	 * Metodo que devuelve el valor del atributo jugadoresMin del juego.
	 * @return Un int con el número mínimo de jugadores del juego
	 */
	public int getJugadoresMin() {
		return jugadoresMin;
	}
	
	/**
	 * Metodo que devuelve el valor del atributo nombre del juego.
	 * @return Un String con el nombre del juego
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Metodo que devuelve el valor del atributo reglas del juego.
	 * @return Un String con las reglas del juego
	 */
	public String getReglas() {
		return reglas;
	}
	
	
	
	/**
	 * Metodo que establece el valor del atributo codigo del juego.
	 * @param codigo Un int con el codigo del juego.
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Metodo que establece el valor del atributo jugadoresMin del juego.
	 * @param jugadoresMin Un int con el numero de jugadores minimos del juego.
	 */
	public void setJugadoresMin(int jugadoresMin) {
		this.jugadoresMin = jugadoresMin;
	}
	
	/**
	 * Metodo que establece el valor del atributo nombre del juego.
	 * @param nombre Un String con el nombre del juego.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Metodo que establece el valor del atributo reglas del juego.
	 * @param reglas Un String con las reglas del juego.
	 */
	public void setReglas(String reglas) {
		this.reglas = reglas;
	}
	

}
