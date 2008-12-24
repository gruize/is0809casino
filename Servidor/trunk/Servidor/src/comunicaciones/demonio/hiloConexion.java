package comunicaciones.demonio;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;
import java.util.Vector;
import comunicaciones.conexion.*;

/**
 * Clase que extiende de Thread que gestiona una conexión concreta
 * @author Francisco Huertas y Gabriela Ruiz
 * @version 0.1.228
 */
public class hiloConexion extends Thread{
	
	private Socket canal;
	private boolean esServidor;
	private TablaMensajes tablaMensajes;
	
	//FIXME
	/**
	 * Semilla para el id
	 */
	static Long semilla = new Long(0);
	private Vector<Conectores> tablaConectores;
	
	/**
	 * Contructor parametrizado
	 * @param canal canal por el cual se retrasmite
	 * @param esServidor indica si se trabaja desde un cliente o un servidor
	 * @param tablaConectores Tablad de conectores
	 * @param tablaMensajes Tabla de mensajes
	 */
	public hiloConexion(Socket canal, boolean esServidor, Vector<Conectores> tablaConectores, TablaMensajes tablaMensajes) {
		super();
		this.canal = canal;
		this.esServidor = esServidor;
		this.tablaConectores = tablaConectores;
		this.tablaMensajes = tablaMensajes;
	}
	/**
	 * Metodo que se inicia al ejecutar el thead y que gestiona una conexion
	 */
	public void run ()
	{
		try {
			// TODO close all sockets
			
			Mensaje msg = this.receive(null);
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
			
					msg = new MensajeString();
					msg.setTipo(msg.OK);
					((MensajeString)msg).setContenido(id);
					this.send(null, msg);
					this.canal.close();
					return;
					
				}
				// CREATE_CONNECTION no servidor
				else 
				{
					Socket clientSocket = new Socket(msg.HOST_SERVER,msg.PUERTO);
					this.send(clientSocket,msg);
					// FIXME �lo puedo reenviar tal cual?
					
					
					msg = this.receive(clientSocket);
					
					// obtenemos la respuesta con el id (posible mensaje de configuracion)
					// TODO: implementar OK_ANSWER
					if (msg.getTipo() == msg.OK)
						this.tablaConectores.add(new Conectores(((MensajeString)msg).getContenido(),this.canal.getLocalAddress()));
						
					else
					{
						//TODO tratamiento de errores
					}
					
					clientSocket.close();
					//enviamos la respuesta al proceso
					this.send(null,msg);
					// TODO cerrar subcanales
					this.canal.close();
					return;
				}
			}
			if (msg.getTipo() == msg.READ_MESSAGE_NO_WAIT)
			{
				Mensaje respuesta = this.tablaMensajes.consultaMensaje(msg.getOrigen(), msg.getTipo(), msg.getMascara());
				if (respuesta == null)
				{
					msg.setTipo(msg.NOT_MESSAGE);
					this.send(null, msg);
				}
				else
					this.send(null, respuesta);
					
				
			}
			if (msg.getTipo() == msg.READ_MESSAGE_WAIT)
			{
				// TODO timeout
				Mensaje respuesta;
				do {
					respuesta = this.tablaMensajes.consultaMensaje(msg.getOrigen(), msg.getTipo(), msg.getMascara());
				} while (respuesta == null);
				this.send(null, respuesta);
					
				
			}
			// Mensaje de tipo NO CREATE CONNECTION
			Conectores destino = this.buscarConector(msg.getDestino());
			// si esta procesado en el cliente, o en el servidor y no lo encuentra
			// es que no existe
			if ((msg.procesado || this.esServidor) && destino == null)
			{
				Mensaje respuesta = new MensajeSistema ();
				respuesta.setTipo(respuesta.CLIENT_NOT_FOUND);
				this.send(null,respuesta);
		
			}
			// estando en un cliente que no tiene el destino y no ha pasado por el servidor
			else if ((msg.procesado == false) && (destino == null))
			{
				Socket clientSocket = new Socket (msg.HOST_SERVER,msg.PUERTO);
				

				this.send(clientSocket, msg);
				
				
				msg = this.receive(clientSocket);
				if (msg.getTipo()== msg.OK)
				{
					Conectores nuevo = new Conectores();
					nuevo.setId(((MensajeString)msg).getContenido());
					this.tablaConectores.add(nuevo);
					this.send(null, msg);
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
				//FIXME
				//if (destino.getHost().getAddress())
				if (this.compareIp(destino.getHost().getAddress(), InetAddress.getLocalHost().getAddress()))
				{	
					this.tablaMensajes.altaMensaje(msg.clon());
					msg.setTipo(msg.OK);
					this.send(null, msg);
				}
				
				// TODO espera de respueesta OK

				else
				{
					// el mensaje la va pa otro
					msg.procesado = true;
					Socket socketServidor = new Socket(destino.getHost(),msg.PUERTO);

					this.send(socketServidor, msg);
					msg = this.receive(socketServidor);
					socketServidor.close();
					if (msg.getTipo() == msg.OK)
						this.send(null, msg);
				}
				
			}
			// el ultimo paso es que este en tu lista, se lo dejas en la cola de mensajes
			else
			{
				this.tablaMensajes.altaMensaje(msg.clon());
				Mensaje respuesta = new MensajeSistema();
				respuesta.setTipo(respuesta.OK);

				this.send(null, respuesta);
				
			}

			this.canal.close();
			return; //FIXME hacer la correcta salida
			

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		return;
	}
	
	private Conectores buscarConector(String id)
	{
		for (int i = 0; i < this.tablaConectores.size();i++)
		{
			if (this.tablaConectores.elementAt(i).getId().compareTo(id)==0 )
			{
				return this.tablaConectores.elementAt(i);
			}
		}
		
		return null;
	}
	
	private String cadenaAleatoria(int n)
	{
		semilla++;
		Random rnd = new Random();
		String cadena ="";
		for (int i = 0;i<n;i++)
		{
			cadena = cadena + (char)((rnd.nextDouble( ) * 25)+65);

		}
		cadena = semilla.toString();
		return cadena;
	}
	// Si es null utilizar el del objeto
	private void send(Socket canal, Mensaje msg)
	{
		
		ObjectOutputStream salidaDatos;
		try {
			
			if (canal == null)
				canal = this.canal;
			salidaDatos = new ObjectOutputStream(canal.getOutputStream());
			salidaDatos.writeObject(msg);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		
	}
	private Mensaje receive (Socket canal)
	{
		ObjectInputStream entradaDatos;
		
		try {
			if (canal == null)
				canal = this.canal;
			entradaDatos = new ObjectInputStream(canal.getInputStream());
			return (Mensaje)entradaDatos.readObject();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	private boolean compareIp(byte addr1[],byte addr2[])
	{
		for (int i = 0;i<4;i++)
			if (addr1[i] !=addr2[i])
				return false;
		return true;
	}

}

