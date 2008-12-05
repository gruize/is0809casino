/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servidorcasino;

/**
 *
 * @author Administrador
 */
public class ApuestaRuleta implements Apuesta {
    //tipo de apuesta: 0-> numero, 1->color, 2->par....
    private String _tipo;
    //color
    private String _color;
    //Casilla donde se apuesta: al 21, al Rojo , a la 2º Docena...
    private int _casilla;
    //Cantidad a postada
    private int _cantidad;

    public ApuestaRuleta() {
        this._tipo = "";
        this._casilla = 0;
        this._cantidad =0;
    }

    //apuesta a un número
    public ApuestaRuleta(String tipo, int casilla, int cantidad) {
        this._tipo = tipo;
        this._casilla = casilla;
        this._cantidad = cantidad;
    }
    //apuesta a un color
    public ApuestaRuleta(String tipo, String color, int cantidad){
        this._tipo=tipo;
        this._color=color;
        this._cantidad=cantidad;
        
    }

    public String get_color() {
        return _color;
    }

    public void set_color(String _color) {
        this._color = _color;
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

    public String get_tipo() {
        return _tipo;
    }

    public void set_tipo(String _tipo) {
        this._tipo = _tipo;
    }
    
    
}
