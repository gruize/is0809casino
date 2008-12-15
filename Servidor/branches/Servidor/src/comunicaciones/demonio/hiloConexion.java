package comunicaciones.demonio;

import java.io.*;
import java.net.Socket;
import java.util.Random;
import java.util.Vector;
import comunicaciones.conexion.*;

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
			// FIXME close all sockets
			ObjectInputStream canalDeEntrada;
			canalDeEntrada = new ObjectInputStream(canal.getInputStream());
			Object datos;
			datos = canalDeEntrada.readObject();
			canalDeEntrada.close();
			Mensaje msg = (Mensaje)datos;
			if (msg.getTipo() == msg.CREATE_CONNECTION)
			{
				if (this.esServidor)
				{
					// TODO deberíamos comprobar si el InetAddress esta repe?
					
					String id;
					do {
						id = this.cadenaAleatoria(10);
					}while (this.buscarConector(id) != null);
					
					this.tablaConectores.add(new Conectores(id,canal.getInetAddress()));
					// TODO send OK to cliente con el conector creado de manera que lo identifique
					// mensaje con tipo conector
					ObjectOutputStream salidaDatos = new ObjectOutputStream (this.canal.getOutputStream());
					msg = new MensajeString();
					msg.setTipo(msg.OK);
					((MensajeString)msg).setContenido(id);
					salidaDatos.writeObject(msg);
					this.canal.close();
					this.canal.close();
					return;
					
				}
				else 
				{
					Socket clientSocket = new Socket(msg.HOST_SERVER,msg.PUERTO);
					ObjectOutputStream salidaDatos = new ObjectOutputStream (clientSocket.getOutputStream());
					// FIXME ¿lo puedo reenviar tal cual?
					
					salidaDatos.writeObject(msg);
					salidaDatos.close();
					
					ObjectInputStream entradaDatos = new ObjectInputStream (clientSocket.getInputStream());
					msg = (Mensaje) entradaDatos.readObject(); 
					if (msg.getTipo() == msg.OK)
						this.tablaConectores.add(new Conectores(((MensajeString)msg).getContenido(),this.canal.getLocalAddress()));
					else
					{
						//TODO tratamiento de errores
					}
					entradaDatos.close();
					clientSocket.close();
					
					salidaDatos = new ObjectOutputStream (this.canal.getOutputStream());
					salidaDatos.writeObject(msg);
					salidaDatos.close();
					this.canal.close();
					//TODO conectar con el servidor para solicitar la conexion
				}
			}
			if (this.buscarConector(msg.getDestino()) == null)
			{
				Conectores destino = this.buscarConector(msg.getDestino());
				if ((this.esServidor) && (destino != null))
				{
					msg.procesado = true;
				}
				// si el mensaje ya paso por el servidor o estando en el servidor no 
				// existe como host
				else if ((msg.procesado) || ((this.esServidor) && (destino == null)))
				{
					Mensaje respuesta = new MensajeSistema ();
					respuesta.setTipo(respuesta.CLIENT_NOT_FOUND);
					ObjectOutputStream salidaDatos = new ObjectOutputStream(this.canal.getOutputStream());
					salidaDatos.writeObject(respuesta);
					salidaDatos.close();
			
				}
				// estando en un cliente quie no tiene el destino y no ha pasado por el servidor
				else if ((msg.procesado == false) && (destino == null))
				{
					// TODO reenviar el mensaje al servidor y esperar su respuesta
				}
				// el ultimo paso es que este en tu lista, se lo dejas en la cola de mensajes
				else
				{
					// TODO put message in the list of messages and send OK ¿siempre?
					Mensaje respuesta = new MensajeSistema();
					respuesta.setTipo(respuesta.OK);
					ObjectOutputStream salidaDatos = new ObjectOutputStream(this.canal.getOutputStream());
					salidaDatos.writeObject(respuesta);
					salidaDatos.close();
					
				}
				// TODO unificar las respuestas en unas solas lineas

				this.canal.close();
				return; //FIXME hacer la correcta salida
				
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
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// FIXME conrregir buscar por id no pormensaje
	private Conectores buscarConector(String id)
	{
		for (int i = 0; i < this.tablaConectores.size();i++)
		{
			if (this.tablaConectores.elementAt(i).getId() == id)
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
			cadena = cadena + (char)(rnd.nextDouble( ) * 255);

		}
		return cadena;
	}
	

}

