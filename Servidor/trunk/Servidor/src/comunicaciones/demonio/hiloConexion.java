package comunicaciones.demonio;

import java.io.*;
import java.net.Socket;
import java.util.Vector;

public class hiloConexion extends Thread{
	private Socket canal;
	private boolean esServidor;
	public Vector<Conectores> tablaDeConectores;
	public hiloConexion(Socket canal, boolean esServidor) {
		super();
		this.canal = canal;
		this.esServidor = esServidor;
	}
	public void run ()
	{
		try {
			ObjectInputStream canalDeEntrada;
			canalDeEntrada = new ObjectInputStream(canal.getInputStream());
			Object datos = canalDeEntrada.read();
			
			if(esServidor)
			{
				//buscarConector()
				
			}
			// TODO: Cast to message
			// TODO: find destiny in the table
			// if is not in the table we must check if the daemon is a server or 
			// a client
			// SERVER: we must send to reject
			// CLIENT: send to server
			// Si es tipo crear conexion añadir la entrada a la tabla 
			// si es un cliente asignarle también un id preguntandoselo al servidor

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
