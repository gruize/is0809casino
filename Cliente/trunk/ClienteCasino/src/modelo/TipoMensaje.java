/*
 * Tipos de mensajes que se envían al servidor
 */

package modelo;

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
}
