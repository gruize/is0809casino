/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servidorcasino;

/**
 *
 * @author Administrador
 */
public interface Apuesta {




    public String get_color();

    public void set_color(String _color);

    public int get_cantidad() ;

    public void set_cantidad(int _cantidad);

    public int get_casilla();

    public void set_casilla(int _casilla);

    public String get_tipo() ;

    public void set_tipo(String _tipo) ;
    
}
