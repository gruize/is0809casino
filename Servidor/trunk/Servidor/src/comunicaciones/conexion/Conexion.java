package comunicaciones.conexion;


import java.net.*;
import java.io.*;


public class Conexion implements InterfazConexion{

	private String id;
	private Socket conexion;
	private boolean creada;
	public Conexion(boolean esServidor)
	{
        
		// establecemos conexion
		if (!this.establecer())
        {
        	// TODO check wrong connection
        }
		Mensaje datos = new MensajeSistema();
        
        ObjectOutputStream salidaDatos;
        ObjectInputStream entradaDatos;
        
        // configuramos el mesanje de conxion
		
        datos.setTipo(datos.CREATE_CONNECTION);
        // FIXME esto no se sabe muy bien
        // no hace falta extablecer xq no hay id
        //datos.setOrigen("");
       
        try {

            // enviamos el mesnajes de conexion
        	salidaDatos = new ObjectOutputStream(conexion.getOutputStream());
            salidaDatos.writeObject(datos);
            salidaDatos.close();
            // recibimos las respuesta
            entradaDatos = new ObjectInputStream(conexion.getInputStream());
            datos = (MensajeString)entradaDatos.readObject();
            entradaDatos.close();
            // TODO tratamiento de errores del sistema
            if (datos.getTipo() == datos.OK)
            {
            	// TODO mensaje de configuracion¿?
            	this.id = ((MensajeString)datos).getContenido();
            }
            else
            {
            	// TODO tratamiento de errores
            }
        } catch( IOException e ) {
            System.out.println( e );
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
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
	@Override
	public void eliminarConexion() {

		// TODO Auto-generated method stub
		
	}

	@Override
	public Mensaje enviarMensaje(Mensaje message) {
		try {
			Socket socketCliente = new Socket(InetAddress.getLocalHost(),message.PUERTO);
			ObjectOutputStream salidaDatos = new ObjectOutputStream(socketCliente.getOutputStream());
			salidaDatos.writeObject(message);
			salidaDatos.close();
			ObjectInputStream entradaDatos = new ObjectInputStream(socketCliente.getInputStream());
			Mensaje msg = (Mensaje) entradaDatos.readObject();
			entradaDatos.close();
			return msg;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		msg.setTipo(msg.GET_MESSAGE);
		
		msg.setOrigen(this.id);
		msg.setMascara(mascara);
		Mensaje respuesta = enviarMensaje(msg);
		// TODO Auto-generated method stub
		return respuesta;
	}
}
