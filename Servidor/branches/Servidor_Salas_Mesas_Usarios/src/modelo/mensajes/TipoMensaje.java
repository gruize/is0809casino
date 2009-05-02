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
}
