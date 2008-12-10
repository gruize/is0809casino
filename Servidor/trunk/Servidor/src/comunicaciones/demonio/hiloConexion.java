package comunicaciones.demonio;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;
import java.util.Vector;
import comunicaciones.conexion.*;

public class hiloConexion extends Thread{
	private Socket canal;
	private boolean esServidor;
	private TablaMensajes tablaMensajes;
	
	private Vector<Conectores> tablaConectores;
	public hiloConexion(Socket canal, boolean esServidor, Vector<Conectores> vector, TablaMensajes tablaMensajes) {
		super();
		this.canal = canal;
		this.esServidor = esServidor;
		this.tablaConectores = vector;
		this.tablaMensajes = tablaMensajes;
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
			// FIXME corregir los procesos que envian al propio servidor
			if (msg.getTipo() == msg.CREATE_CONNECTION)
			{
				if (this.esServidor)
				{
					String id;
					do {
						id = this.cadenaAleatoria(10);
					}while (this.buscarConector(id) != null);
					
					this.tablaConectores.add(new Conectores(id,canal.getInetAddress()));

					ObjectOutputStream salidaDatos = new ObjectOutputStream (this.canal.getOutputStream());
					msg = new MensajeString();
					msg.setTipo(msg.OK);
					((MensajeString)msg).setContenido(id);
					salidaDatos.writeObject(msg);
					this.canal.close();
					this.canal.close();
					return;
					
				}
				// CREATE_CONNECTION no servidor
				else 
				{
					Socket clientSocket = new Socket(msg.HOST_SERVER,msg.PUERTO);
					ObjectOutputStream salidaDatos = new ObjectOutputStream (clientSocket.getOutputStream());
					// FIXME ¿lo puedo reenviar tal cual?
					
					salidaDatos.writeObject(msg);
					salidaDatos.close();
					
					ObjectInputStream entradaDatos = new ObjectInputStream (clientSocket.getInputStream());
					// obtenemos la respuesta con el id (posible mensaje de configuracion)
					msg = (Mensaje) entradaDatos.readObject(); 
					if (msg.getTipo() == msg.OK)
						this.tablaConectores.add(new Conectores(((MensajeString)msg).getContenido(),this.canal.getLocalAddress()));
					else
					{
						//TODO tratamiento de errores
					}
					entradaDatos.close();
					clientSocket.close();
					//enviamos la respuesta al proceso
					salidaDatos = new ObjectOutputStream (this.canal.getOutputStream());
					salidaDatos.writeObject(msg);
					salidaDatos.close();
					this.canal.close();
					return;
				}
			}
			// Mensaje de tipo NO CREATE CONNECTION
			Conectores destino = this.buscarConector(msg.getDestino());
			// si esta procesado en el cliente, o en el servidor y no lo encuentra
			// es que no existe
			if ((msg.procesado) || ((this.esServidor)) && (destino == null))
			{
				Mensaje respuesta = new MensajeSistema ();
				respuesta.setTipo(respuesta.CLIENT_NOT_FOUND);
				ObjectOutputStream salidaDatos = new ObjectOutputStream(this.canal.getOutputStream());
				salidaDatos.writeObject(respuesta);
				salidaDatos.close();
		
			}
			// estando en un cliente que no tiene el destino y no ha pasado por el servidor
			else if ((msg.procesado == false) && (destino == null))
			{
				Socket clientSocket = new Socket (msg.HOST_SERVER,msg.PUERTO);
				
				ObjectOutputStream salidaDatos = new ObjectOutputStream(clientSocket.getOutputStream());
				salidaDatos.writeObject(msg);
				salidaDatos.close();
				ObjectInputStream entradaDatos = new ObjectInputStream(clientSocket.getInputStream());
				entradaDatos.close();
				clientSocket.close();
				msg = (Mensaje)entradaDatos.readObject();
				if (msg.getTipo()== msg.OK)
				{
					Conectores nuevo = new Conectores();
					nuevo.setId(((MensajeString)msg).getContenido());
					this.tablaConectores.add(nuevo);
					salidaDatos = new ObjectOutputStream(this.canal.getOutputStream());
					salidaDatos.writeObject(msg);
					salidaDatos.close();
				}
				
				
			
				else 
				{
					// TODO tratamiento de errores
				}
				
			}
			// Si es servidor y existe destino
			else if ((this.esServidor) && (destino != null))
			{
				// si el mensaje me viene a mi
				if (destino.getHost() == InetAddress.getLocalHost())
					this.tablaMensajes.altaMensaje(msg.clon());

				else
				{
					// el mensaje la va pa otro
					msg.procesado = true;
					Socket socketServidor = new Socket(destino.getHost(),msg.PUERTO);
					ObjectOutputStream salidaDatos = new ObjectOutputStream(socketServidor.getOutputStream());
					
					salidaDatos.writeObject(msg);
					salidaDatos.close();
					ObjectInputStream entradaDatos = new ObjectInputStream(socketServidor.getInputStream());
					msg = (Mensaje)entradaDatos.readObject();
					entradaDatos.close();
					socketServidor.close();
					if (msg.getTipo() == msg.OK)
					{
						salidaDatos = new ObjectOutputStream(this.canal.getOutputStream());
						salidaDatos.writeObject(msg);
						salidaDatos.close();
					}
				}
				
			}
			// el ultimo paso es que este en tu lista, se lo dejas en la cola de mensajes
			else
			{
				this.tablaMensajes.altaMensaje(msg.clon());
				Mensaje respuesta = new MensajeSistema();
				respuesta.setTipo(respuesta.OK);
				ObjectOutputStream salidaDatos = new ObjectOutputStream(this.canal.getOutputStream());
				salidaDatos.writeObject(respuesta);
				salidaDatos.close();
				
			}

			this.canal.close();
			return; //FIXME hacer la correcta salida
			

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
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

