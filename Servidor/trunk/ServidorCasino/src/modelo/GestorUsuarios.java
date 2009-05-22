/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import bbdd.gestorBBDD.GestorBBDDImp;
import bbdd.gestorBBDD.InterfazBBDD;

import bbdd.beans.Clientes;
import controlador.ControladorServidor;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultListModel;
import modelo.LogicaJuegos.JugadorConectado;
import org.apache.log4j.Logger;

/**
 *
 * @author Fiutten
 */
public class GestorUsuarios {

    //--------------------------------------------------------------------------
    //          ATRIBUTOS
    //--------------------------------------------------------------------------
    private static Vector<JugadorConectado> jugadores = null;
    private InterfazBBDD bbdd;
    private ControladorServidor controlador;
    private static DefaultListModel listaUsuarios;
    //PatrÃƒÆ’Ã‚Â³n Singleton
    private static GestorUsuarios instancia;

    //log4j
    private static Logger log = Logger.getLogger(GestorUsuarios.class);

    //--------------------------------------------------------------------------
    //          METODOS
    //--------------------------------------------------------------------------
    public static GestorUsuarios getInstancia(ControladorServidor c) {
        if (instancia == null) {
            instancia = new GestorUsuarios(c);
            listaUsuarios = new DefaultListModel();
        }
        return instancia;
    }

    public GestorUsuarios(ControladorServidor c) {

        jugadores = new Vector<JugadorConectado>();
        this.controlador = c;
        this.bbdd = new GestorBBDDImp();

    }

    public DefaultListModel estadisticasClientes() {
        DefaultListModel texto = new DefaultListModel();
        texto.addElement("CLIENTES:");
        ArrayList listaClientes = this.getListaUsuarios();
        for (int i = 0; i < listaClientes.size(); i++) {
            Clientes cliente = (Clientes) listaClientes.get(i);
            texto.addElement("");
            texto.addElement(" ------------------");
            texto.addElement("Codigo:" + cliente.getCodigo());
            texto.addElement("Nombre: " + cliente.getNombre());
            texto.addElement("Apellidos: " + cliente.getApellidos());
            texto.addElement("DNI: " + cliente.getDni());
            texto.addElement("Usuario: " + cliente.getUsuario());
            texto.addElement("Password: " + cliente.getPassword());
            texto.addElement("Direccion: " + cliente.getDireccion());
            texto.addElement("Numero de cuenta: " + cliente.getNumerocuenta());
            texto.addElement("Saldo: " + cliente.getSaldo());
            texto.addElement("Telefono: " + cliente.getTelefono());
            texto.addElement("Recargas: " + cliente.getRecargas());
            texto.addElement("Fecha de ingreso: " + cliente.getFechaingreso().toString());
        }
        return texto;
    }

    public ArrayList getListaUsuarios() {
        return bbdd.getClientes();
    }

    public DefaultListModel getUsuarios() {
        ArrayList usuarios = this.bbdd.getClientes();
        for (int i = 0; i < usuarios.size(); i++) {
            Clientes jugador = (Clientes) usuarios.get(i);
            listaUsuarios.addElement(jugador.getUsuario());
        }
        return listaUsuarios;
    }

    //======================================================================
    //          INSERTAR JUGADOR
    //======================================================================
    /**
     * Comprueba el login de un usuario
     * @param usuario nombre de usuario
     * @param password contraseÃƒÆ’Ã‚Â±a
     * @return identificador del usuario si los datos son correctos, y no estaba ya en el casino, -1 e.o.c
     */
    public int hacerLogin(String usuario, String password) {
        int id = -1;

        //No pueden llegar valores nulos
        if (usuario.equals("") || password.equals("")) {
            return -1;
        }
        id = bbdd.comprobarUsuario(usuario, password);
        if (id == -1) {//el jugador no existe, o los datos suministrados no son correctos

            log.info("GestorUsuarios : hacerLogin : El jugador con usuario=" + usuario + " y pass=" + password + " no estÃ¡ registrado o la password no es correcta");
            //devolverÃ¡ -1
        } else {
               //el jugador existe en BBDD. Comprobamos si se puede logear: 
            
            //Si el jugador aun no esta conectado devuelve resultado = -1
            if (getIndiceJugador(id) == -1) {
                if (!listaUsuarios.contains(usuario)) {
                    listaUsuarios.addElement(usuario);
                }
                insertarJugador(bbdd.getClientePorCodigo(id));
                log.info("GestorUsuarios : hacerLogin : Jugador con id=" + id + " logeado en el casino");
            } else { //ya esta conectado, devuelvo -1 hacia el comunicador

                id = -1;
                log.error("GestorUsuarios : hacerLogin : El jugador con id=" + id + " YA ESTABA. getIndiceJugador es != -1");
            }

        }
        return id;
    }

    /**
     * Cuando un jugador se logea y entra en el casino. AÃƒÆ’Ã‚Âºn no ha entrado en sala ni mesa
     * @param idSala
     * @param idMesa
     * @param c
     */
    public void insertarJugador(Clientes c) {
        JugadorConectado jugador = new JugadorConectado(c);
        jugadores.add(jugador);

    //aÃƒÆ’Ã‚Âºn no se inserta nada en BBDD, no se considera Participante porque aÃƒÆ’Ã‚Âºn no ha entrado en sala ni mesa
    }

    /**
     * Cuando el jugador entra en una sala.
     * @param idJugador
     * @param idSala
     */
    public void insertarJugadorEnSala(int idJugador, int idSala) {

        jugadores.get(getIndiceJugador(idJugador)).setIdSala(idSala);

        log.info("GestorUsuarios : insertarJugadorEnSala : Jugador=" + idJugador + " insertado en sala=" + idSala);
    }

    /**
     * Cuando el jugador selecciona una msea de juego
     * @param idJugador
     * @param idMesa
     */
    public boolean insertarJugadorEnMesa(int idJugador, int idMesa) {

        getJugadorConectado(idJugador).setIdMesa(idMesa);

        //Enviarselo al gestorSalas, y que llame a su gestorMesas y lo incluya en la mesa correspondiente
        if (GestorSalas.getInstance(controlador).insertarJugadorEnMesa(getJugadorConectado(idJugador).getIdSala(), idMesa, idJugador)) {
            log.info("GestorUsuarios : insertarJugadorEnMesa : Jugador=" + idJugador + " insertado en mesa=" + idMesa);
            return true;
        } else {
            log.info("GestorUsuarios : insertarJugadorEnMesa : Jugador=" + idJugador + " NO se ha insertado en mesa=" + idMesa);
            return false;
        }
    }

    //=======================================================================
    //              getters
    //=======================================================================
    /**
     * Busca la posicion del vector de jugadores donde se encuentra el jugador
     * @return posicion del jugador si estÃƒÆ’Ã‚Â¡ en la lista de jugadores del casino
     *          -1 si no lo encuentra
     */
    public int getIndiceJugador(int idJugador) {

        try {
            log.info("GestorUsuarios : getIndiceJugador : buscando la pos del jugador con id=" + idJugador);
            if (jugadores != null && jugadores.size() > 0) {

                int i = 0;
                boolean enc = false;
                while (!enc && i < jugadores.size()) {
                    enc = jugadores.get(i).getIdJugador() == idJugador;
                    i++;
                }

                if (enc) {
                    return i - 1;
                } else {
                    return -1; //el usuario aÃƒÆ’Ã‚Âºn no estÃƒÆ’Ã‚Â¡ registrado

                }
            } else {//es el primer jugador del casino, tampoco se ha insertado aÃƒÆ’Ã‚Âºn

                return -1;
            }

        } catch (Exception e) {
            log.error("GestorUsuarios : getIndiceJugador : error al buscar jugador. " + e.getMessage());
            return -1;
        }
    }

    /**
     * Busca un jugador de la lista de jugadores
     * @param idJugador
     */
    public JugadorConectado getJugadorConectado(int idJugador) {

        return jugadores.get(getIndiceJugador(idJugador));
    }

    //======================================================================
    //          ELIMINAR JUGADOR
    //======================================================================
    /**
     * 
     * Elimina al jugador de la mesa en la que se encontraba.
     * @param jugador
     * @return
     */
    public boolean eliminarJugadorEnMesa(int idJugador) {

        JugadorConectado j = getJugadorConectado(idJugador);
        //GestorSalas -> GestorMesas y que borre en de la mesa correspondiente
        GestorSalas.getInstance(controlador).eliminarJugadorDeMesa(j.getIdSala(), j.getIdMesa(), idJugador);

        //modificar el usuario
        getJugadorConectado(idJugador).setIdMesa(-1);

        return true;

    }

    /**
     * Elimina el jugador de una sala. No se llama al gestor de salas, solo se modifica
     * el jugador de esta clase
     * @param idJugador
     */
    public void eliminarJugadorEnSala(int idJugador) {
        getJugadorConectado(idJugador).setIdSala(-1);
    }

    /**
     * Cuando el jugador se desconecta del casino.
     * @return
     */
    public boolean desconectarJugador(int idJugador) {

        log.info("GestorUsuarios : desconectarJugador : se va a desconectar al jugador " + idJugador);
        try {
            //Si todavia no ha salido de  mesa o sala
            if (getJugadorConectado(idJugador).getIdMesa() != -1) {
                eliminarJugadorEnMesa(idJugador);
            }
            if (getJugadorConectado(idJugador).getIdSala() != -1) {
                eliminarJugadorEnSala(idJugador);
            }

            //eliminar de la lista de jugadores conectados
            jugadores.removeElement(getJugadorConectado(idJugador));

            log.info("GestorUsuarios : desconectarJugador : Jugador=" + idJugador + " desconectado correctamente");
            return true;

        } catch (Exception e) {
            log.error("GestorUsuarios : desconectarJugador : El jugador=" + idJugador + " NO se ha desconectado. Motivo: " + e.getMessage());
            return false;
        }
    }

    /**
     * Para el mÃƒÆ’Ã‚Â³dulo de chat. Se necesitan conocer todos los jugadores que estÃƒÆ’Ã‚Â¡n en una mesa
     *
     *
     */
    public Vector<Clientes> getJugadoresMesa(int idSala, int idMesa) {
        return GestorSalas.getInstance(controlador).getMesas(idSala).getJugadores_Mesa(idMesa);
    }

    /**
     * Busca en BBDD el nombre de un cliente a partir de su Id
     * @param idJugador
     * @return nombre de usuario (login)
     */
    public String getNombreUsuario(int idJugador) {
        return bbdd.getClientePorCodigo(idJugador).getUsuario();
    }

    public int getIdUsuario(String usuario) {
        return bbdd.getClientePorUsuario(usuario).getCodigo();
    }

    /**
     * Busca la info de un cliente desde BBDD
     * @param id
     * @return
     */
    public Clientes getClienteInfo(int id) {
        return bbdd.getClientePorCodigo(id);
    }
}