
package bbdd.gestorBBDD;

import bbdd.beans.*;
import java.util.ArrayList;

/**
 *
 * @author Ambrin Chaudhary y Joaquin Lopez
 */
public interface InterfazBBDD {

    /**
     * Comprueba si existe el usuario
     * @param usuario nombre de usuario
     * @param pswd contraseña
     * @return "id" del usuario si existe, y su contraseña es correcta. 
     *         -1 en otro caso
     */
    public int comprobarUsuario(String usuario, String pswd);

    // ========== CLIENTES =========
    /**
     * Devuelve todos los clientes dados de alta en el casino
     * @return
     */
    public ArrayList getClientes();

    /**
     * Busca un cliente por su nombre de usuario
     * @param usuario nombre de usuario
     * @return objeto cliente
     */
    public Clientes getClientePorUsuario(String usuario);

    /**
     * Busca un cliente por su código
     * @param codigo
     * @return
     */
    public Clientes getClientePorCodigo(int codigo);

    /**
     * Inserta en BBDD un nuevo cliente
     * @param cliente
     * @return resultado de la operación
     */
    public boolean insertarCliente(Clientes cliente);

    /**
     * Modifica un cliente. El objeto pasado por parámetro, debe existir en BBDD, y debe 
     * tener sus atributos ya modificados
     * @param cliente objeto modificado.
     */
    public boolean modificarCliente(Clientes cliente);

    /**
     * Borra el cliente de BBDD 
     * @param cliente
     */
    public void borrarCliente(Clientes cliente);

    //   ============= JUEGOS ============
    /**
     * Devuelve todos los juegos que hay en el casino
     * @return
     */
    public ArrayList getJuegos();

    /**
     * Busca un juego por su código
     * @param codigo
     * @return
     */
    public Juegos getJuegoPorCodigo(int codigo);

    /**
     * Busca un juego por su nombre
     * @param nombreJuego nombre del juego
     * @return
     */
    public Juegos getJuegoPorNombre(String nombreJuego);

    /**
     * Inserta un juego en BBDD
     * @param juego
     * @return resultado de la operacion
     */
    public boolean insertarJuego(Juegos juego);

    /**
     * Actualiza un juego
     * @param juego objeto ya modificado, listo para guardar en BBDD
     */
    public boolean modificarJuego(Juegos juego);

    /**
     * Borra un juego
     * @param juego
     */
    public void borrarJuego(Juegos juego);
    
    // ========= SALAS ============
    
    /**
     * Devuelve todas las salas del casino
     * @return
     */
    public ArrayList getSalas();
    
    /**
     * Busca una sala a partir de su codigo
     * @param codigo
     * @return
     */
    public Salas getSalaPorCodigo(int codigo);
    
    /**
     * Inserta una nueva sala
     * @param sala
     * @return resultado de la operacion
     */
    public boolean insertarSala(Salas sala);
    
    /**
     * Actualiza una sala
     * @param sala
     */
    public boolean modificarSala(Salas sala);
    
    /**
     * Borra una sala
     * @param sala
     */
    public void borrarSala(Salas sala);
    
    // ========= MESAS =============
    /**
     * Devuelve todas las mesas del casino
     * @return
     */
    public ArrayList getMesas();
    
    /**
     * Busca una mesa a partir de su codigo
     * @param codigo
     * @return
     */
    public Mesas getMesa(int codigo);
    
    /**
     * Inserta una mesa
     * @param mesa
     */
    public boolean insertarMesa(Mesas mesa);
    
    /**
     * Actualiza una mesa 
     * @param mesa 
     */
   public boolean modificarMesa(Mesas mesa);
   
   /**
    * Borra una mesa
    * @param mesa
    */
   public void borrarMesa(Mesas mesa);
   
   // ========= PARTIDAS ==========
   
   /**
    * Devuelve todas las partidas del casino
    * @return
    */
   public ArrayList getPartidas();
   
   /**
    * Busca una partida a partir de su codigo
    * @param codigo
    * @return
    */
   public Partidas getPartida(int codigo);
   
   /**
    * Inserta una partida
    * @param partida
    * @return
    */
   public boolean insertarPartida(Partidas partida);
   
   /**
    * Actualiza una partida
    * @param partida
    */
   public boolean modificarPartida(Partidas partida);
   
   /**
    * Borra una partida
    * @param partida
    */
   public void borrarPartida(Partidas partida);
   
   // ====== PARTICIPANTES ==============
  
   /**
    * Busca un jugador en una partida concreta
    * @param idJug
    * @param idPartida
    * @return
    */
   public Participantes getParticipante(int idJug, int idPartida);
   
   /**
    * Devuelve todos los participantes del casino
    * @return
    */
   public ArrayList getParticipantes();
   
  
   /**
    * Devuelve todas las partidas en las que está participando un jugador
    * @param idJugador identificador del jugador
    * @return
    */
   public ArrayList getPartidasPorParticipante(int idJugador);
   
   /**
    * Devuelve todos los jugadores que estén participando en una partida
    * @param idPartida identificador de la partida
    * @return
    */
   public ArrayList getJugadoresPorPartida(int idPartida);
   
  /**
   * Inserta un nuevo participante
   * @param participante
   * @return
   */ 
   public boolean insertarParticipante(Participantes participante);
   
   /**
    * Actualiza un participante
    * @param participante
    */
   public boolean modificarParticipante(Participantes participante);
   
   /**
    * Borra un participante
    * @param participante 
    */
   public void borrarParticipante(Participantes participante);
   
}
