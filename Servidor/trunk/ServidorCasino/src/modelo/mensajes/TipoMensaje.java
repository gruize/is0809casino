/*
 * Tipos de mensajes que se envían al servidor
 */

package modelo.mensajes;

/**
 *
 * @author Chaudhary
 */
public class TipoMensaje {

    /**mensaje de chat*/
    public static int MENSAJE_CHAT=1;

    /** mensaje de jugada(de ruleta, dados, ...)*/
    public static int MENSAJE_JUGADA=2;

    /** mensaje de entrada en la mesa. Tanto de solicitud del cliente, como de confirmacion del servidor */
    public static int ENTRADA_MESA=3;

    /** salida de la mesa. Lo solicita el cliente, pero no recibe confirmación del servidor*/
    public static int SALIDA_MESA=4;

    /** Cierre de conexión */
    public static int CERRAR_CONEXION=5;

    /** Entrada en una sala por parte del cliente */
    public static final int ENTRADA_SALA=6;

    /** Salida de una sala */
    public static final int SALIDA_SALA=7;

    /** El servidor envía al cliente la información de todas las salas abiertas del casino */
    public static final int INFO_SALAS=8;

    /** El servidor envía al cliente la información de todas las mesas abiertas en una sala */
    public static final int INFO_MESAS=9;

    /** Cuando la ruleta para o inicia el juego */
    public static final int ESTADO_RULETA=10;

    /** Para enviar los nuevos saldos, o la info del cliente */
    public static final int INFO_CLIENTE=11;

    /** Para enviar los jugadores existentes en una mesa */
    public static final int USERS_MESA=12;

    /** Para enviar los resultados de partidas anteriores */
    public static final int RESULTS_PASADO=13;

    /** Para indicar la expulsion a un cliente */
    public static final int EXPULSAR=14;
}
