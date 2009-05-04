package modelo.mensajes;

import java.io.Serializable;

public class MensajeChat implements Serializable {

	private int _tio;
	private String _men;
    private int _mesa;
    private int _sala;
    private String _usuario;



   	public MensajeChat(int _tio,int _sala,int _mesa, String _men, String _usuario) {
		super();
        this._sala = _sala;
        this._mesa = _mesa;
		this._tio = _tio;
		this._men = _men;
        this._usuario = _usuario;
	}

	public MensajeChat(MensajeChat m) {
        this._sala = m.get_sala();
        this._mesa = m.get_mesa();
		this._tio = m.get_tio();
		this._men = m.get_men();

	}

    public int get_sala() {
        return _sala;
    }

    public void set_sala(int _sala) {
        this._sala = _sala;
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

    public String get_usuario() {
        return _usuario;
    }

    public void set_usuario(String _usuario) {
        this._usuario = _usuario;
    }
}

