package comunicaciones.demonio;

import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * Class that represents a connector that is a proccess with an ID your address (IP)
 * @author Francisco Huertas Ferrer and Gabriela Ruiz Escobar
 * @version 0.2.269
 */
public class Conectores {
	
	private String id;
	private InetAddress host;	
	/**
	 * Default constructor
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
	 * Parameterized constructor, the address format InetAddress
	 * @param id ID identified
	 * @param host Address identified
	 */
	public Conectores(String id, InetAddress host) {
		super();
		this.id = id;
		this.host = host;
	}

	/**
	 * Parameterized constructor, the address format String ipv4 ej. "192.168.1.2"
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
	 * Get ID
	 * @return
	 */
	public String getId() {
		return this.id;
	}
	/**
	 * Set ID
	 * @param id
	 */
	public void setId(String id)    {
		synchronized (this)
		{
			this.id = id;
		}
	}
	/**
	 * Get address
	 * @return
	 */
	public InetAddress getHost() {
		return host;
	}
	
	/**
	 * Set Address
	 * @param host
	 */
	public void setHost(InetAddress host) {
		synchronized (this)
		{
			this.host = host;
		}
	}
	
	
}
