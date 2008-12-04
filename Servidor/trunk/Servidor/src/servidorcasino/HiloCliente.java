/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorcasino;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import DAO.JugadorDAO;
import InterfazCliente.LoginJugador;
import InterfazCliente.Ruleta;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chaudhary
 */
public class HiloCliente implements Runnable {

    Socket socketCliente = null;
    DataInputStream entradaDatos;
    DataOutputStream salidaDatos;


    // El constructor recibe y guarda los parámetros que sean necesarios.
    // En este caso el socket del servidor, para la comunicacion cliente-servidor
    /**
     * 
     * @param cliente: socket del cliente asociado
     */
    public HiloCliente(Socket cliente) {
        this.socketCliente = cliente;

    }

    public void run() {
        try {
            //TODO: informar al servidor de que se ha conectado un nuevo Cliente
            System.out.println("EJECUTANTO NUEVO CLIENTE ");
            salidaDatos = (DataOutputStream) socketCliente.getOutputStream();

            //pedir login
            LoginJugador pantallaLogin = new LoginJugador();
            pantallaLogin.registraCliente(this);
            pantallaLogin.muestra();
        } catch (IOException ex) {
            Logger.getLogger(HiloCliente.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(HiloCliente.class.getName()+": run(): "+ex.getMessage());
        }


    }

    public void enviarDatosLogin(String sUsuario, String sPassword) {
        String datos = sUsuario + "-" + sPassword;
        System.out.println("DATOS LOGIN: [" + "]");
        try {
            //enviar al servidor
            for (int i = 0; i < datos.length(); i++) {
                salidaDatos.write((byte) datos.charAt(i));
            }
        } catch (IOException ex) {
            System.err.println(HiloCliente.class.getName()+": enviarDatosLogin(): "+ex.getMessage());
        }
    }
}
