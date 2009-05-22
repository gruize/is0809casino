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
       
    // borrarJugador("kk");
        obtenerTodosLosJugadores();

    }

    /**
     * Crea un nuevo cliente del casino
     */
    private static void crearJugador() {
        Clientes jugador = new Clientes();
        
        jugador.setNombre("prueba");
        jugador.setApellidos("prueba");
        jugador.setDni("12345678Z");
        jugador.setUsuario("m");
        jugador.setPassword("m");
        jugador.setFechaingreso(new java.util.Date());
        jugador.setFecharecarga(new java.util.Date());
        jugador.setNumerocuenta("012893872223879236");
        jugador.setDireccion("EspaÃ±a");
        jugador.setTelefono("916664455");
        jugador.setSaldo(1000);

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
    private static void borrarJugador(String user) {
        
        bbdd.borrarCliente(bbdd.getClientePorUsuario(user));
    }

    private static void mostrarDatos(ArrayList lista) {
        String s = "  ";
        int espacio=20;
        for (int i = 0; i < lista.size(); i++) {
            Clientes jugador = (Clientes) lista.get(i);

            System.out.print("********* Codigo:" + jugador.getCodigo() + separador(espacio-10));
            System.out.print("Nombre:" + jugador.getNombre() + separador(espacio-jugador.getNombre().length()));
            System.out.print("Apellidos:" + jugador.getApellidos() + separador(espacio-jugador.getApellidos().length()));
            System.out.print("DNI:" + jugador.getDni() + separador(espacio-9));
            System.out.print("Usuario:" + jugador.getUsuario() + separador(espacio-jugador.getUsuario().length()));
            System.out.print("Pswd:" + jugador.getPassword() + separador(espacio-jugador.getPassword().length()));
            System.out.print("Direccion:" + jugador.getDireccion() + separador(espacio-jugador.getDireccion().length()));
            System.out.print("Fecha Ingreso:" + jugador.getFechaingreso() + separador(espacio-11));
            System.out.print("NÂº Cuenta:" + jugador.getNumerocuenta() + separador(espacio-jugador.getNumerocuenta().length()));
            System.out.print("Recargas: " + jugador.getRecargas() + separador(espacio-10));
            System.out.print("Saldo: " + jugador.getSaldo() + separador(espacio-7));
            System.out.println("Telefono:" + jugador.getTelefono() + separador(espacio-9));
        }
    }

    /**
     * crea una cadena vacia de "numEspacios" caracteres
     * @param numEspeacios
     * @return
     */
    private static String separador(int numEspeacios){

        String res="";
        for (int i=0; i<numEspeacios; i++)
            res+=" ";

        return res;
    }

}
