package comunicaciones.conexion;


import java.net.*;
import java.io.*;

/**
 * Implementation of the InterfaceConnection based on sockets
 * @author Francisco Huertas and Gabriela Ruiz
 * @version 0.1.227
 */
public class Conexion implements InterfazConexion{
	
	private String id;
	private Socket conexion;
	//private boolean creada;
	/**
	 * Constructor of the class Connection
	 * @param esServidor indicates if is a server
	 */
	public Conexion(boolean esServidor)
	{
        
		// Set connection
		if (!this.establecer())
        {
        	// TODO Check wrong connection
        }
		Mensaje msg = new MensajeSistema();
        

        
        // Configure the message connection
		
        msg.setTipo(msg.CREATE_CONNECTION);
        // FIXME esto no se sabe muy bien
        // It's not neccesary set connection because there is id
        //datos.setOrigen("");
       
        // Send the message connection

        this.send(null,msg);
        // Recive the answer
        msg = this.receive(null);
        // TODO tratamiento de errores del sistema
        if (msg.getTipo() == msg.OK)
        {
        	// TODO mensaje de configuracion�?
        	this.id = ((MensajeString)msg).getContenido();
        }
        else
        {
        	// TODO tratamiento de errores
        }
        
        // Disconnect
        this.desconectar();
		//TODO: Establecer conexion con tu Demonio*/
	}
	
	

	private boolean establecer ()
	{
		try {
			Mensaje msg = new MensajeSistema();
			this.conexion = new Socket(msg.HOST_SERVER,msg.PUERTO);
			//FIXME correcto tratamiento del error
			/*if (!this.conexion)
				return false;*/
				
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}


	private void desconectar()
	{
		try {
			this.conexion.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void send(Socket canal, Mensaje msg)
	{
		
		ObjectOutputStream salidaDatos;
		try {
			
			if (canal == null)
				canal = this.conexion;
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
				canal = this.conexion;
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

	@Override
	public void eliminarConexion() {

		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Mensaje enviarMensaje(Mensaje msg) {
	
		// FIXME SEND MESSAGE NO TIENE TIPO
		//msg.setTipo(msg.SEND_MESSAGE);
		msg.setOrigen(this.getId());
		this.establecer();
		this.send(null, msg);
		msg = this.receive(null);
		this.desconectar();
		return msg;
		


		
	}

	@Override
	public int estadoConexion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public Mensaje obtenerMensaje(boolean espera) {
		return obtenerMensaje(-1, espera);
	}
	
	@Override
	public Mensaje obtenerMensaje(int mascara, boolean espera) {
		Mensaje msg = new MensajeSistema();
		msg.setOrigen(this.getId());
		msg.setDestino(this.getId());
		if (espera)
			msg.setTipo(msg.READ_MESSAGE_WAIT);
		else 
			msg.setTipo(msg.READ_MESSAGE_NO_WAIT);
		msg.setMascara(mascara);
		this.establecer();
		this.send(null, msg);
		msg = this.receive(null);
		this.desconectar();
		return msg;

	}

	@Override
	public Config getConfig() {
		// TODO Auto-generated method stub
		return new ConfigCasino();
	}




}

