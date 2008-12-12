package Entidades;

public class Sala {
	
	private int codigo;
	private int juego;
	private String nombre;
	
	public Sala(){}
	
	public Sala(int codigo, int juego, String nombre)
	{
		this.codigo=codigo;
		this.juego=juego;
		this.nombre=nombre;
	}
	
	public Sala(int juego, String nombre)
	{
		this.juego=juego;
		this.nombre=nombre;
	}
	//Accedentes
	public int getCodigo() {
		return codigo;
	}
	
	public int getJuego() {
		return juego;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	//Mutadores
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public void setJuego(int juego) {
		this.juego = juego;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
