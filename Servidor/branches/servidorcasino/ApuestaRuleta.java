/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servidorcasino;

/**
 *
 * @author Administrador
 */
public class ApuestaRuleta {
    //tipo de apuesta: A un numero, a un color,  a una docena....
    private int _tipo;
    //Casilla donde se apuesta: al 21, al Rojo , a la 2º Docena...
    private int _casilla;
    //Cantidad a postada
    private int _cantidad;

    public ApuestaRuleta() {
        this._tipo = 0;
        this._casilla = 0;
        this._cantidad =0;
    }

    public ApuestaRuleta(int _tipo, int _casilla, int _cantidad) {
        this._tipo = _tipo;
        this._casilla = _casilla;
        this._cantidad = _cantidad;
    }

    public int get_cantidad() {
        return _cantidad;
    }

    public void set_cantidad(int _cantidad) {
        this._cantidad = _cantidad;
    }

    public int get_casilla() {
        return _casilla;
    }

    public void set_casilla(int _casilla) {
        this._casilla = _casilla;
    }

    public int get_tipo() {
        return _tipo;
    }

    public void set_tipo(int _tipo) {
        this._tipo = _tipo;
    }
    
    
}
