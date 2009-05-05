/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.mensajes;

import java.io.Serializable;

/**
 *
 * @author GabiPC
 */
public class MensajeResultadosAnteriores implements Serializable{

    private int idmesa;
    private String[] resultados;

    public MensajeResultadosAnteriores(int idmesa, String[] resultados) {
        this.idmesa = idmesa;
        this.resultados = resultados;
    }

    public int getIdmesa() {
        return idmesa;
    }

    public void setIdmesa(int idmesa) {
        this.idmesa = idmesa;
    }

    public String[] getResultados() {
        return resultados;
    }

    public void setResultados(String[] resultados) {
        this.resultados = resultados;
    }
    
}
