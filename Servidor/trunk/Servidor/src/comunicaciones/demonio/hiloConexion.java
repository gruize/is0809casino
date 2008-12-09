package comunicaciones.demonio;

import java.io.*;
import java.net.Socket;
import java.util.Random;
import java.util.Vector;
import comunicaciones.conexion.Mensaje;

public class hiloConexion extends Thread{
	private Socket canal;
	private boolean esServidor;
	public Vector<Conectores> tablaConectores;
	public hiloConexion(Socket canal, boolean esServidor, Vector<Conectores> vector) {
		super();
		this.canal = canal;
		this.esServidor = esServidor;
		this.tablaConectores = vector;
	}
	public void run ()
	{
		try {
			
			ObjectInputStream canalDeEntrada;
			canalDeEntrada = new ObjectInputStream(canal.getInputStream());
			Object datos = canalDeEntrada.read();
			Mensaje msg = (Mensaje)datos;
			if (this.buscarConector(msg) == null)
			{
				// TODO: tratamiento de menajes que no estan en la lista
				// TODO: send message
				this.canal.close();
				return; //FIXME hacer la correcta salida
				
			}
			if (msg.getTipo() == msg.CREAR_CONEXION)
			{
				if (this.esServidor)
				{
					// TODO comprobar id repetido
					this.tablaConectores.add(new Conectores(this.cadenaAleatoria(10),canal.getInetAddress()));
					// TODO send OK to cliente con el conector creado de manera que lo identifique
					// mensaje con tipo conector
				}
				else 
				{
					
				}
			}
			
			else 
			{
				// TODO: enviar el mensaje al destino en la lista
			}
			this.canal.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	// FIXME conrregir buscar por id no pormensaje
	private Conectores buscarConector(Mensaje datos)
	{
		for (int i = 0; i < this.tablaConectores.size();i++)
		{
			if (this.tablaConectores.elementAt(i).getId() == ((Mensaje)datos).getDestino())
			{
				return this.tablaConectores.elementAt(i);
			}
		}
		
		return null;
	}
	
	private String cadenaAleatoria(int n)
	{
		Random rnd = new Random();
		String cadena ="";
		for (int i = 0;i<n;i++)
		{
			cadena = cadena + (char)(rnd.nextDouble() * 255);

		}
		return cadena;
	}
	

}

