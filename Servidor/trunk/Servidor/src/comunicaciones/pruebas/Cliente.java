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
		InterfazConexion conexion1 = new Conexion(false);
		InterfazConexion conexion2 = new Conexion(false);
		Mensaje msg = new MensajeString();
		((MensajeString)msg).setContenido("hola caracola");
		while(true)
		{
			msg.setDestino("2");
			msg.setTipo(1);
			msg = conexion1.enviarMensaje(msg);	
			((MensajeString)msg).setContenido("adiooooos");
			msg = conexion2.obtenerMensaje();
		
		}
		
		
		//conexion.eliminarConexion();
	}

}
