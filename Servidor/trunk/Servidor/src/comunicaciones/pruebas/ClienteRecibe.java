package comunicaciones.pruebas;

import comunicaciones.conexion.*;
import comunicaciones.demonio.Demonio;
public class ClienteRecibe {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		InterfazConexion conexion = new Conexion(false);
		Mensaje msg = new MensajeString();
		((MensajeString)msg).setContenido("hola caracola");
		while(true)
		{
			System.out.println("A la espera de recibir un mensaje String");
			msg = conexion.obtenerMensaje(true);
			System.out.println("El mensaje String obtenido es el siguiente\n\t"
					+((MensajeString)msg).getContenido());
			
		
		}
		
		
		//conexion.eliminarConexion();
	}

}
