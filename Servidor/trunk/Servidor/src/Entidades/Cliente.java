package Entidades;

import java.util.Date;

/**
 * Clase Clientes.
 * Clase que contiene los atributos y métodos que modelan a un cliente.
 * @author Joaquín López Cabezas
 * @version 1.0
 *
 */
public class Cliente {

	/**
	 * Atributo de tipo int que almacena el codigo del cliente
	 */
	private int codgo;
	
	/**
	 * Atributo de tipo String que almacena el nombre del cliente
	 */
	private String nombre;
	
	/**
	 * Atributo de tipo String que almacena los apellidos del cliente
	 */
	private String apellidos;
	
	/**
	 * Atributo de tipo String que almacena el dni del cliente
	 */
	private String dni;
	
	/**
	 * Atributo de tipo String que almacena el usuario del cliente
	 */
	private String usuario;
	
	/**
	 * Atributo de tipo String que almacena el password del cliente
	 */
	private String password;
	
	/**
	 * Atributo de tipo String que almacena la direccion del cliente
	 */
	private String direccion;
	
	/**
	 * Atributo de tipo String que almacena el telefono del cliente
	 */
	private String telefono;
	
	/**
	 * Atributo de tipo Date que almacena la fecha de ingreso del cliente
	 */
	private Date fechaIngreso;
	
	/**
	 * Constructor por defecto.
	 *
	 */
	public Cliente(){}
	
	/**
	 * Constructor.
	 * @param codigo Un int con el codigo del cliente.
	 * @param nombre Un String con el nombre del cliente.
	 * @param apellidos Un String con los apellidos del cliente.
	 * @param dni Un String con el dni del cliente.
	 * @param usuario Un String con el usuario del cliente.
	 * @param password Un String con el password del cliente.
	 * @param direccion Un String con la direccion del cliente.
	 * @param telefono Un String con el telefono del cliente.
	 * @param fechaIngreso Un Date con la fecha de ingreso del cliente.
	 *
	 */
	public Cliente(int codigo, String nombre, String apellidos, String dni, String usuario, String password, String direccion, String telefono, Date fechaIngreso)
	{
		this.codgo=codigo;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.dni=dni;
		this.usuario=usuario;
		this.password=password;
		this.direccion=direccion;
		this.telefono=telefono;
		this.fechaIngreso=fechaIngreso;		
	}
	
	/**
	 * Constructor sin codigo porque se lo asigna la base de datos automáticamente.
	 * @param nombre Un String con el nombre del cliente.
	 * @param apellidos Un String con los apellidos del cliente.
	 * @param dni Un String con el dni del cliente.
	 * @param usuario Un String con el usuario del cliente.
	 * @param password Un String con el password del cliente.
	 * @param direccion Un String con la direccion del cliente.
	 * @param telefono Un String con el telefono del cliente.
	 * @param fechaIngreso Un Date con la fecha de ingreso del cliente.
	 *
	 */
	public Cliente(String nombre, String apellidos, String dni, String usuario, String password, String direccion, String telefono, Date fechaIngreso)
	{
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.dni=dni;
		this.usuario=usuario;
		this.password=password;
		this.direccion=direccion;
		this.telefono=telefono;
		this.fechaIngreso=fechaIngreso;		
	}

	/**
	 * Metodo que devuelve el valor del atributo codigo del cliente.
	 * @return Un int con el codigo del cliente
	 */
	public int getCodgo() {
		return codgo;
	}
	
	/**
	 * Metodo que devuelve el valor del atributo nombre del cliente.
	 * @return Un String con el nombre del cliente
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Metodo que devuelve el valor del atributo apellidos del cliente.
	 * @return Un String con los apellidos del cliente
	 */
	public String getApellidos() {
		return apellidos;
	}
	
	/**
	 * Metodo que devuelve el valor del atributo dni del cliente.
	 * @return Un String con el dni del cliente
	 */
	public String getDni() {
		return dni;
	}
	
	/**
	 * Metodo que devuelve el valor del atributo usuario del cliente.
	 * @return Un String con el usuario del cliente
	 */
	public String getUsuario() {
		return usuario;
	}
	
	/**
	 * Metodo que devuelve el valor del atributo password del cliente.
	 * @return Un String con el password del cliente
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Metodo que devuelve el valor del atributo direccion del cliente.
	 * @return Un String con la direccion del cliente
	 */
	public String getDireccion() {
		return direccion;
	}
	
	/**
	 * Metodo que devuelve el valor del atributo telefono del cliente.
	 * @return Un String con el telefono del cliente
	 */
	public String getTelefono() {
		return telefono;
	}
	
	/**
	 * Metodo que devuelve el valor del atributo fechaIngreso del cliente.
	 * @return Un Date con la fecha de ingreso del cliente
	 */
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	
	/**
	 * Metodo que establece el valor del atributo codigo al que recibe por parametro
	 * @param codgo Un int con el codigo del cliente.
	 */
	public void setCodigo(int codgo) {
		this.codgo = codgo;
	}
	
	/**
	 * Metodo que establece el valor del atributo nombre al que recibe por parametro
	 * @param nombre Un String con el nombre del cliente.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Metodo que establece el valor del atributo apellidos al que recibe por parametro
	 * @param apellidos Un String con los apellidos del cliente.
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Metodo que establece el valor del atributo dni al que recibe por parametro
	 * @param dni Un String con el dni del cliente.
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	/**
	 * Metodo que establece el valor del atributo usuario al que recibe por parametro
	 * @param usuario Un String con el usuario del cliente.
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * Metodo que establece el valor del atributo password al que recibe por parametro
	 * @param password Un String con el password del cliente.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Metodo que establece el valor del atributo direccion al que recibe por parametro
	 * @param direccion Un String con la direccion del cliente.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	/**
	 * Metodo que establece el valor del atributo telefono al que recibe por parametro
	 * @param telefono Un String con el telefono del cliente.
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * Metodo que establece el valor del atributo fechaIngreo al que recibe por parametro
	 * @param fechaIngreso Un Date con la fecha de ingreso del cliente.
	 */
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
}
