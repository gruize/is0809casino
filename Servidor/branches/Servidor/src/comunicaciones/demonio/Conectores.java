package comunicaciones.demonio;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Conectores {
	
	private String id;
	private InetAddress host;	
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

	public Conectores(String id, InetAddress host) {
		super();
		this.id = id;
		this.host = host;
	}

	public Conectores(String id, String host)
	{
		super();
		try {
			this.id = id;
			this.host = this.host.getByName(host);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	
	public String getId() {
		return this.id;
	}
	public void setId(String id)    {
		synchronized (this)
		{
			this.id = id;
		}
	}
	public InetAddress getHost() {
		return host;
	}
	public void setHost(InetAddress host) {
		synchronized (this)
		{
			this.host = host;
		}
	}
	
	
}
