# POR FAVOR, ESTA DOCUMENTACIÓN ES POCO ADECUADA AQUÍ. #
# USAR JAVADOC EN CÓDIGO #

# Implementaci�n de la clase Mensaje #

Las clases que se implementen que hereden de la clase Mensaje deben estar situadas en el paquete comunicaciones.conexion

## Atributos heredados ##

  * private int tipo; Tipo de mensaje enviado, el tipo 1 est� reservado por/para el sistema
  * private String origen; Proceso que envia el mensaje, este valor ser� facilitado por el sistema de comunicaci�n
  * private String destino; Proceso que recibe el mensaje.
  * private int prioridad; TODO

## Procedimientos que se deben reimplementar ##

  * public Mensaje clon(); Para versiones futuras. Devuelve una copia del mensaje.
  * public String getClassName(); Devuelve el nombre de la clase por un String.

## Ejemplo de una posible implementaci�n ##
```
package comunicaciones.conexion;

public class MensajeString extends Mensaje{
	
	private String contenido;
	
	public MensajeString(MensajeString otro) {
		super(otro);
		this.contenido = otro.contenido;
	}
	
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String nuevoContenido) {
		this.contenido = nuevoContenido;	
	}
	public Mensaje clon() {
		return new MensajeString(this);
	}
	public String getClassName() {
		return "MensajeString";
	}
}
```