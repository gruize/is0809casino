/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebashibernatecasino;

import Beans.Clientes;
import DAO.DAOClientes;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author Chaudhary
 */
public class testJugadores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here


//        DAOClientes c=new DAOClientes();
//        ArrayList lista=c.getClientes();
//        mostrarDatos(lista);

        crearJugador();


    }

    private static void crearJugador() {
        Clientes jugador = new Clientes();
        
       // jugador.setCodigo(new BigDecimal(1));
        jugador.setNombre("Joaquin");
        jugador.setApellidos("Lopez Cabezas");
        jugador.setDni("9876543Y");
        jugador.setUsuario("juss");
        jugador.setPassword("juss");
        jugador.setFechaingreso(new java.util.Date());
        jugador.setNumerocuenta("123456789012345678");
        jugador.setDireccion("Toledo");
        jugador.setTelefono("666666666");
        jugador.setRecargas(2);

        //insertar en BBDD
        DAOClientes dao = new DAOClientes();
        dao.insertarNuevoCliente(jugador);

        //consultar todos los jugadores
        mostrarDatos(dao.getClientes());

    }

    private static void consultarJugador() {
    }

    private static void modificarJugador() {
    }

    private static void borrarJugador() {
    }

    private static void mostrarDatos(ArrayList lista) {
        String s = "  ";
        for (int i = 0; i < lista.size(); i++) {
            Clientes jugador = (Clientes) lista.get(i);

            System.out.print("Codigo:" + jugador.getCodigo() + s);
            System.out.print("Nombre:" + jugador.getNombre() + s);
            System.out.print("Apellidos:" + jugador.getApellidos() + s);
            System.out.print("DNI:" + jugador.getDni() + s);
            System.out.print("Usuario:" + jugador.getUsuario() + s);
            System.out.print("Pswd:" + jugador.getPassword() + s);
            System.out.print("Direccion:" + jugador.getDireccion() + s);
            System.out.print("Fecha Ingreso:" + jugador.getFechaingreso() + s);
            System.out.print("Nº Cuenta:" + jugador.getNumerocuenta() + s);
            System.out.print("Recargas: " + jugador.getRecargas() + s);
            System.out.println("Telefono:" + jugador.getTelefono() + s);
        }
    }
}
