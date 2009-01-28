package comunicaciones.demonio;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;
import java.util.Vector;
import comunicaciones.conexion.*;

/**
 * Class that extends from Thread whose manages a specific connection
 * @author Francisco Huertas and Gabriela Ruiz
 * @version 0.1.228
 */
public class hiloConexion extends Thread{
	
	private Socket canal;
	private boolean servidor;
	private TablaMensajes tablaMensajes;
	
	//FIXME
	/**
	 * Semilla para el id
	 */
	static Long semilla = new Long(0);
	private Vector<Conectores> tablaConectores;
	
	/**
	 * Constructor Parameterized
	 * @param canal Channel through which retransmitted
	 * @param esServidor Indicates if is working from a client or a server
	 * @param tablaConectores Table of connectors
	 * @param tablaMensajes Table of messages
	 */
	public hiloConexion(Socket canal, boolean servidor, Vector<Conectores> tablaConectores, TablaMensajes tablaMensajes) {
		super();
		this.canal = canal;
		this.servidor = servidor;
		this.tablaConectores = tablaConectores;
		this.tablaMensajes = tablaMensajes;
	}
	/**
	 * Method that starts when the thread runs and manages a connection
	 */
	public void run ()
	{
		try {
			// TODO close all sockets
			
			Mensaje msg = this.receive(null);
			// FIXME corregir los procesos que envian al propio servidor
			if (msg.getTipo() == msg.CREATE_CONNECTION)
				this.CREATE_CONNECTION(msg);

			else if (msg.getTipo() == msg.READ_MESSAGE_NO_WAIT)
				this.READ_MESSAGE_NO_WAIT(msg);
			
			else if (msg.getTipo() == msg.READ_MESSAGE_WAIT)
				this.READ_MESSAGE_WAIT(msg);
			else {
				// Message type NO CREATE CONNECTION
				Conectores destino = this.buscarConector(msg.getDestino());
				/*
				 * If is processed in the client or in the server and don't find it, it doesn't exist
				 */
				if ((msg.procesado || this.servidor) && destino == null)
				{
					Mensaje respuesta = new MensajeSistema ();
					respuesta.setTipo(respuesta.CLIENT_NOT_FOUND);
					this.send(null,respuesta);
			
				}
				/*
				 * Being in a client which doesn't have destination, and hasn't passed by the server
				 */
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
				/**
				 * If is a server and exist the destination
				 */
				else if ((this.servidor) && (destino != null))
				{
					/**
					 * If the message comes to me
					 */
					//FIXME
					//if (destino.getHost().getAddress())
					//if (this.compareIp(destino.getHost().getAddress(), InetAddress.getLocalHost().getAddress()))
					{	
						this.tablaMensajes.altaMensaje(msg.clon());
						msg.setTipo(msg.OK);
						this.send(null, msg);
					}
					
					// 
						// XXX esto es pa cuando el demonio este en todos
					/*else
					{
						
						// * If the message goes to another

						msg.procesado = true;
						Socket socketServidor = new Socket(destino.getHost(),msg.PUERTO);
	
						this.send(socketServidor, msg);
						msg = this.receive(socketServidor);
						socketServidor.close();
						if (msg.getTipo() == msg.OK)
							this.send(null, msg);
					}*/
					
				}
				/**
				 * The last step is to be in your list, is left in the message queue
				 */
				else
				{
					this.tablaMensajes.altaMensaje(msg.clon());
					Mensaje respuesta = new MensajeSistema();
					respuesta.setTipo(respuesta.OK);
	
					this.send(null, respuesta);
					
				}
				this.canal.close();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
	/**
	 * If is null, use the channel of the object
	 */
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
	
	private void CREATE_CONNECTION (Mensaje msg) throws IOException {
		if (this.servidor)
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
		else 
		{
			Socket clientSocket = new Socket(msg.HOST_SERVER,msg.PUERTO);
			this.send(clientSocket,msg);
			// FIXME �lo puedo reenviar tal cual?
			
			
			msg = this.receive(clientSocket);
			/**
			 * Get the answer with the id (possible message of configuration)
			 */
			// TODO: implementar OK_ANSWER
			if (msg.getTipo() == msg.OK)
				this.tablaConectores.add(new Conectores(((MensajeString)msg).getContenido(),this.canal.getLocalAddress()));
				
			else
			{
				//TODO tratamiento de errores
			}
			
			clientSocket.close();
			/**
			 * Send the answer to the process
			 */
			this.send(null,msg);
			// TODO cerrar subcanales
			this.canal.close();
			
		}
	}
	private void READ_MESSAGE_NO_WAIT(Mensaje msg) throws IOException
	{
		Mensaje respuesta = this.tablaMensajes.consultaMensaje(msg.getOrigen(), msg.getMascara());
		if (respuesta == null)
		{
			msg.setTipo(msg.NOT_MESSAGE);
			this.send(null, msg);
		}
		else
			this.send(null, respuesta);
		
		this.canal.close();
		
	}
	private void READ_MESSAGE_WAIT(Mensaje msg) throws IOException
	{
		// TODO meter espera y timeout
		Mensaje respuesta;
		do {
			try {
				Thread.sleep(25L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			respuesta = this.tablaMensajes.consultaMensaje(msg.getOrigen(), msg.getMascara());
		} while (respuesta == null);
		this.send(null, respuesta);
			
		this.canal.close();
		
	}


}

