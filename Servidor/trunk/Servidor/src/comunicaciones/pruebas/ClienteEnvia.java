package comunicaciones.pruebas;
/**
 * @version 0.2.269
 */
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
		while(true)
		{
            try {
    			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Escribe el ID del proceso al que deseas enviar el mensaje: ");
				String cadena = in.readLine();
				msg.setDestino(cadena);
				System.out.println("Escribe el texto que quieres enviar");
				cadena = in.readLine();
				((MensajeString)msg).setContenido(cadena);
				msg.setTipo(1);
				msg = conexion.enviarMensaje(msg);	
				System.out.println("El mensaje a sido enviado con el siguiente codigo de resultado: \n\t"+msg.getTipo());
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