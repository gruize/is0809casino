package comunicaciones.demonio;

import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * Clase que representa un conector es decir un proceso con un ID y su direccion (ip)
 * @author Francisco Huertas Ferrer y Gabriela Ruiz
 * @version 0.1.228
 */
public class Conectores {
	
	private String id;
	private InetAddress host;	
	/**
	 * Contructor predeterminado
	 */
	public Conectores() {
		super();
		try {
			this.id = "";
			this.host = this.host.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * conctructor parametrizado, la direccion en formato InetAddress
	 * @param id Id del identificado
	 * @param host Dirección del indentificado
	 */
	public Conectores(String id, InetAddress host) {
		super();
		this.id = id;
		this.host = host;
	}

	/**
	 * Contructor parametrizado, la direccion en formato String ipv4 ej. "192.168.1.2"
	 * @param id 
	 * @param host
	 */
	public Conectores(String id, String host)
	{
		super();
		try {
			this.id = id;
			this.host = InetAddress.getByName(host);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	/**
	 * Accedente del id
	 * @return
	 */
	public String getId() {
		return this.id;
	}
	/**
	 * mutador del id
	 * @param id
	 */
	public void setId(String id)    {
		synchronized (this)
		{
			this.id = id;
		}
	}
	/**
	 * Acccedente de la dirección
	 * @return
	 */
	public InetAddress getHost() {
		return host;
	}
	
	/**
	 * mutador de la dirección
	 * @param host
	 */
	public void setHost(InetAddress host) {
		synchronized (this)
		{
			this.host = host;
		}
	}
	
	
}
