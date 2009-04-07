/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestorLoginCliente;

/**
 *
 * @author David
 */
public class MensajeLogin {

    private int usuario;
	private String pass;
    private int id;

    public MensajeLogin(int usurio, String pass, int id) {
        this.usuario = usurio;
        this.pass = pass;
        this.id = id;
    }


    public MensajeLogin(MensajeLogin m) {
        this.usuario = m.getUsuario();
        this.pass = m.getPass();
        this.id = m.getId();
    }

    public int getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}

