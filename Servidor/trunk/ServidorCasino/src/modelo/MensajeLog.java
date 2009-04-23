/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author Fiutten
 */
public class MensajeLog {

    private String usuario;
    private String password;

    public MensajeLog(String usu,String pass) {
        usuario = usu;
        password = pass;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

}
