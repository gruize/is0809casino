package comunicaciones.demonio;

public class Conectores {
	
	
	public Conectores() {
		Id = "";
		host = "local_host";
	}

	public Conectores(String id, String host) {
		super();
		Id = id;
		this.host = host;
	}

	private String Id;
	private String host;
	
	public String getId() {
		return Id;
	}
	public void setId(String id)    {
		synchronized (this)
		{
			Id = id;
		}
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		synchronized (this)
		{
			this.host = host;
		}
	}
	
	
}
