/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.mensajes;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author GabiPC
 */
public class MensajeResultadosAnteriores implements Serializable{

    private int idmesa;
    private Vector<String> resultados;

    public MensajeResultadosAnteriores(int idmesa, Vector<String> resultados) {
        this.idmesa = idmesa;
        this.resultados = resultados;
    }

    public Vector<String> getResultados() {
        return resultados;
    }

    public void setResultados(Vector<String> resultados) {
        this.resultados = resultados;
    }
  
    public int getIdmesa() {
        return idmesa;
    }

    public void setIdmesa(int idmesa) {
        this.idmesa = idmesa;
    }
}
