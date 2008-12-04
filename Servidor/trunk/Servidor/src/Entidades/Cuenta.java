package Entidades;

/**
 * Clase Cuentas.
 * Clase que contiene los atributos y métodos que modelan a una cuenta.
 * @author Joaquín López Cabezas
 * @version 1.0
 *
 */
public class Cuenta {
	
	/**
	 * Atributo de tipo String que almacena el numero de la cuenta
	 */
	private String numero;
	
	/**
	 * Atributo de tipo int que almacena el codigo del cliente titular
	 * de la cuenta
	 */
	private int cliente;
	

	/**
	 * Atributo de tipo Number que almacena el saldo inicial de la cuenta
	 */
	private Number saldoIni;
	
	/**
	 * Atributo de tipo Number que almacena el saldo actual de la cuenta
	 */
	private Number saldoAct;
	
	
	/**
	 * Constructor por defecto.
	 *
	 */
	public Cuenta(){}
	
	/**
	 * Constructor.
	 * @param numero Un String con el numero de la cuenta.
	 * @param cliente Un int con el codigo del cliente titular.
	 * @param saldoIni Un Number con el saldo inicial.
	 * @param saldoAct Un Number con el saldo actual.
	 *
	 */
	public Cuenta(String numero, int cliente,Number saldoIni, Number saldoAct)
	{
		this.numero=numero;
		this.cliente=cliente;
		this.saldoIni=saldoIni;
		this.saldoAct=saldoAct;
	}

	
	/**
	 * Metodo que devuelve el valor del atributo del numero de cuenta.
	 * @return Un String con el numero de cuenta.
	 */
	public String getNumero() {
		return numero;
	}
	
	/**
	 * Metodo que devuelve el valor del codigo del cliente titular.
	 * @return Un int con el codigo del cliente titular.
	 */
	public int getCliente() {
		return cliente;
	}
	
	/**
	 * Metodo que devuelve el valor del atributo saldo inicial de la cueta.
	 * @return Un Number con el saldo inicial de la cuenta
	 */
	public Number getSaldoIni() {
		return saldoIni;
	}
	
	/**
	 * Metodo que devuelve el valor del atributo saldo actual de la cuenta.
	 * @return Un Number con el saldo actual de la cuenta
	 */
	public Number getSaldoAct() {
		return saldoAct;
	}

	/**
	 * Metodo que establece el valor del atributo numero de cuenta.
	 * @param numero Un String con el numero de cuenta.
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	/**
	 * Metodo que establece el valor del atributo codigo de cliente.
	 * @param cliente Un int con el numero de cliente.
	 */
	public void setCliente(int cliente) {
		this.cliente = cliente;
	}
	
	/**
	 * Metodo que establece el valor del atributo saldo inicial de la cuenta.
	 * @param saldoIni Un double con el numero de cuenta.
	 */
	public void setSaldoIni(Number saldoIni) {
		this.saldoIni = saldoIni;
	}
	
	/**
	 * Metodo que establece el valor del atributo saldo actual de la cuenta.
	 * @param saldoAct Un double con el numero de cuenta.
	 */
	public void setSaldoAct(Number saldoAct) {
		this.saldoAct = saldoAct;
	}

	
}
