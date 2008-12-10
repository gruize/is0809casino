package comunicaciones.conexion;


import java.net.*;
import java.io.*;


public class Conexion implements InterfazConexion{

	private final String HOST = "local_host";
	private final int PUERTO = 10809;
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
        datos.setTipo(0);
        datos.setOrigen("localhost");
       
        try {

            // enviamos el mesnajes de conexion
        	salidaDatos = new ObjectOutputStream(conexion.getOutputStream());
            this.enviarMensaje(datos,"");
            salidaDatos.writeObject(datos);
            
            // recibimos las respuesta
            entradaDatos = new ObjectInputStream(conexion.getInputStream());
            datos = (MensajeString)entradaDatos.readObject();
            // TODO tratamiento de errores del sistema
            if (datos.getTipo() == datos.OK)
            {
            	// TODO aqui esta el id del conector
            	this.id = ((MensajeString)datos).getContenido();
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
	
	@Override
	public void crearConexion() {
		if (!this.establecer())
		{
			//TODO check wrong connection
		}
			 
		
		// TODO send things
		
		
		this.desconectar();

		
		// TODO Auto-generated method stub
		
	}
	private boolean establecer ()
	{
		try {
			this.conexion = new Socket(this.HOST,this.PUERTO);
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
		if (this.creada == true)
		{
			
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enviarMensaje(Mensaje message, String idDestino) {
		// TODO Auto-generated method stub
		
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
	public Mensaje obtenerMensaje(String mascara) {
		// TODO Auto-generated method stub
		return null;
	}
}
