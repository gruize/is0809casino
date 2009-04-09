package GestorChatServidor;

import java.io.Serializable;

public class MensajeChat implements Serializable{
	
	private int _tio;
	private String _men;
    private int _mesa;

   	public MensajeChat(int _tio,int _mesa, String _men) {
		super();
        this._mesa = _mesa;
		this._tio = _tio;
		this._men = _men;
	}
	public MensajeChat(MensajeChat m) {
        this._mesa = m.get_mesa();
		this._tio = m.get_tio();
		this._men = m.get_men();
	}
	public int get_tio() {
		return _tio;
	}
	public void set_tio(int _tio) {
		this._tio = _tio;
	}
	public String get_men() {
		return _men;
	}
	public void set_men(String _men) {
		this._men = _men;
	}
     public void set_mesa(int _mesa) {
        this._mesa = _mesa;
    }
    public int get_mesa() {
        return _mesa;
    }
}
