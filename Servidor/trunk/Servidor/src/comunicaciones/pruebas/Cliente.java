package comunicaciones.pruebas;

import comunicaciones.conexion.*;
import comunicaciones.demonio.Demonio;
public class Cliente {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int a = 0;
		InterfazConexion conexion = new Conexion(false);
		
		Mensaje msg = new MensajeString();
		((MensajeString)msg).setContenido("hola caracola");
		while(true)
		{
			msg.setDestino("1");
			msg.setTipo(1);
			msg = conexion.enviarMensaje(msg);	
			((MensajeString)msg).setContenido("adiooooos");
			msg = conexion.obtenerMensaje();
		
		}
		
		
		//conexion.eliminarConexion();
	}

}
