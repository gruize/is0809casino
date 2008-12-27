package comunicaciones.demonio;

import java.util.Vector;
import comunicaciones.conexion.*;

/**
 * Structure that stores and manages the messages
 * @author Francisco Huertas and Gabriela Ruiz
 * @version 0.1.228
 */
public class TablaMensajes {
	private Vector<Mensaje> tablaMensajes;
	/**
	 * Default constructor
	 */
	public TablaMensajes ()
	{
		this.tablaMensajes = new Vector<Mensaje>();
	}
	
	/**
	 * A message is registered in the structure.
	 * @param msg
	 */
	public void altaMensaje(Mensaje msg)
	{
		this.tablaMensajes.add(msg);
	}
	
	/**
	 * Take a message from the table and it erases of the same
	 * @param Destination ID 
	 * @param tipo Message type searched
	 * @param mascara If is true, the type is irrelevant
	 * @return
	 */
	public Mensaje consultaMensaje(String id, int tipo, boolean mascara)
	{
		/**
		 * TRUE is a mask for everyone
		 */
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
