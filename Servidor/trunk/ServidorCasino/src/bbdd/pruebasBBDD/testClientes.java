/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd.pruebasBBDD;

import bbdd.beans.Clientes;
import bbdd.DAO.DAOClientes;
import java.util.ArrayList;

import bbdd.gestorBBDD.GestorBBDDImp;
import bbdd.gestorBBDD.InterfazBBDD;

/**
 *
 * @author Ambrin Chaudhary y Joaquin Lopez
 */
public class testClientes {

    static InterfazBBDD bbdd = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        bbdd = new GestorBBDDImp();
       
       // modificarJugador();
        obtenerTodosLosJugadores();

    }

    /**
     * Crea un nuevo cliente del casino
     */
    private static void crearJugador() {
        Clientes jugador = new Clientes();
        
        jugador.setNombre("Prueba");
        jugador.setApellidos("sin apellidos");
        jugador.setDni("12345678Z");
        jugador.setUsuario("pp");
        jugador.setPassword("pp");
        jugador.setFechaingreso(new java.util.Date());
        jugador.setNumerocuenta("012893872223879236");
        jugador.setDireccion("españa");
        jugador.setTelefono("916799856");
        jugador.setRecargas(150);

        //insertar en BBDD
        bbdd.insertarCliente(jugador);
   


    }

    /**
     * muestra todos los clientes dados de alta en el casino
     */
    private static void obtenerTodosLosJugadores() {

        mostrarDatos(bbdd.getClientes());
    }

    /**
     * Obtiene un jugador, consultando por su nombre de usuario
     */
    private static void consultarJugador() {
        DAOClientes dao = new DAOClientes();
        Clientes cliente = dao.getClientePorUsuario("ambrin");
        ArrayList l = new ArrayList();
        l.add(cliente);
        mostrarDatos(l);
    }

    /**
     * modifica un jugador
     */
    private static void modificarJugador() {

        Clientes cliente = bbdd.getClientePorUsuario("pepe");
        cliente.setSaldo(1000);
        bbdd.modificarCliente(cliente);
       

    }

    /**
     * borra un jugador identificandole por su nomrbe de usuario
     */
    private static void borrarJugador() {
        
        bbdd.borrarCliente(bbdd.getClientePorUsuario("pp"));
    }

    private static void mostrarDatos(ArrayList lista) {
        String s = "  ";
        for (int i = 0; i < lista.size(); i++) {
            Clientes jugador = (Clientes) lista.get(i);

            System.out.print("********* Codigo:" + jugador.getCodigo() + s);
            System.out.print("Nombre:" + jugador.getNombre() + s);
            System.out.print("Apellidos:" + jugador.getApellidos() + s);
            System.out.print("DNI:" + jugador.getDni() + s);
            System.out.print("Usuario:" + jugador.getUsuario() + s);
            System.out.print("Pswd:" + jugador.getPassword() + s);
            System.out.print("Direccion:" + jugador.getDireccion() + s);
            System.out.print("Fecha Ingreso:" + jugador.getFechaingreso() + s);
            System.out.print("Nº Cuenta:" + jugador.getNumerocuenta() + s);
            System.out.print("Recargas: " + jugador.getRecargas() + s);
            System.out.print("Saldo: " + jugador.getSaldo() + s);
            System.out.println("Telefono:" + jugador.getTelefono() + s);
        }
    }
}
