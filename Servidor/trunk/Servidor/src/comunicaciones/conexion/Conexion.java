package comunicaciones.conexion;


import java.net.*;
import java.io.*;

/**
 * Implemetnacion de InterfazConexion basada en sockets
 * @author Francisco Huertas y Gabriela Ruiz
 * @version 0.1.227
 */
public class Conexion implements InterfazConexion{
	
	private String id;
	private Socket conexion;
	//private boolean creada;
	/**
	 * Constructor de la clase conexion
	 * @param esServidor Indica si es un servidor
	 */
	public Conexion(boolean esServidor)
	{
        
		// establecemos conexion
		if (!this.establecer())
        {
        	// TODO check wrong connection
        }
		Mensaje msg = new MensajeSistema();
        

        
        // configuramos el mesanje de conxion
		
        msg.setTipo(msg.CREATE_CONNECTION);
        // FIXME esto no se sabe muy bien
        // no hace falta extablecer xq no hay id
        //datos.setOrigen("");
       
        // enviamos el mesnajes de conexion

        this.send(null,msg);
        // recibimos las respuesta
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
        
        // desconectamos
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
	public Mensaje obtenerMensaje(boolean mascara) {
		Mensaje msg = new MensajeSistema();
		msg.setOrigen(this.getId());
		msg.setTipo(msg.READ_MESSAGE_NO_WAIT);
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

