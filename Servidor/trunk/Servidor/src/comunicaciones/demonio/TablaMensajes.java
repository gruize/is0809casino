package comunicaciones.demonio;

import java.util.Vector;
import comunicaciones.conexion.*;


public class TablaMensajes {
	private Vector<Mensaje> tablaMensajes;
	public TablaMensajes ()
	{
		this.tablaMensajes = new Vector<Mensaje>();
	}
	
	public void altaMensaje(Mensaje msg)
	{
		this.tablaMensajes.add(msg);
	}
	// true es una mascara para todos
	public Mensaje consultaMensaje(String id, int tipo, boolean mascara)
	{
		Mensaje msg;
		for (int i = 0; i < this.tablaMensajes.size();i++)
		{
			msg = this.tablaMensajes.elementAt(i);
			if (msg.getDestino() == id)
				if ((msg.getTipo() == tipo) || (msg.getMascara() == mascara))
				{
					msg = this.tablaMensajes.get(i).clon();
					this.tablaMensajes.remove(i);
					return msg;
					
				}
		}
		return null;
	}
}
