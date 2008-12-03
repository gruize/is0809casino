package Comunicacion.InterfazConexion;

import java.util.Vector;

public class Conexion implements InterfazConexion{

	public String HOST = "local_host";
	private boolean esServidor;
	private Vector tabla; 
	
	public Conexion(boolean esServidor)
	{
		this.esServidor = esServidor;
		this.tabla = new Vector();
		if (! this.esServidor)
			this.tabla.addElement(new Conectores("",HOST));
		//TODO: Establecer conexion con tu Demonio
	}
	
	@Override
	public void crearConexion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarConexion() {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mensaje obtenerMensaje() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		
	}
	
	private String obtenerId(){
		//TODO: hacerlo.
		return " ";
	}
}
