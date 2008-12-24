package comunicaciones.demonio;

import java.util.Vector;
import comunicaciones.conexion.*;

/**
 * Estructura que almacena y gestiona los mensajes
 * @author Francisco Huertas y Gabriela Ruiz
 * @version 0.1.228
 */
public class TablaMensajes {
	private Vector<Mensaje> tablaMensajes;
	/**
	 * Contructor por defecto
	 */
	public TablaMensajes ()
	{
		this.tablaMensajes = new Vector<Mensaje>();
	}
	
	/**
	 * Da de alta un mensaje en la estructura
	 * @param msg
	 */
	public void altaMensaje(Mensaje msg)
	{
		this.tablaMensajes.add(msg);
	}
	
	/**
	 * Coje un mensaje de la tabla y lo elimina de la misma
	 * @param id del destino 
	 * @param tipo tipo de mensaje que se busca
	 * @param mascara si esta a true, no se hace caso del tipo
	 * @return
	 */
	public Mensaje consultaMensaje(String id, int tipo, boolean mascara)
	{
		// true es una mascara para todos
		Mensaje msg;
		for (int i = 0; i < this.tablaMensajes.size();i++)
		{
			msg = this.tablaMensajes.elementAt(i);
			if (msg.getDestino().compareTo(id) == 0)
				if ((msg.getTipo() == tipo))
				{
					msg = this.tablaMensajes.get(i).clon();
					this.tablaMensajes.remove(i);
					return msg;
					
				}
		}
		return null;
	}
}
