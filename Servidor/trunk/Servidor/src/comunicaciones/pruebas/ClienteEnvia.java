package comunicaciones.pruebas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import comunicaciones.conexion.*;
public class ClienteEnvia {

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
            try {
    			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Escribe el ID del proceso al que deseas enviar el mensaje: ");
				String destino = in.readLine();
				msg.setDestino(destino);
				msg.setTipo(1);
				msg = conexion.enviarMensaje(msg);	
				System.out.println("El mensaje a sido enviado con el siguiente resultado: \n\t"+msg.getTipo());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		}
		
		
		//conexion.eliminarConexion();
	}

}