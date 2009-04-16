/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.ControladorCliente;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author GabiPC
 */
class JPanelCjtoApuestas extends JPanel{

    private ControladorCliente controlador;
    private javax.swing.JTextArea listaApuestas;
    private javax.swing.JScrollPane jScrollPanelListaApuestas;
    

    public JPanelCjtoApuestas(ControladorCliente controlador) {

        jScrollPanelListaApuestas = new javax.swing.JScrollPane();
        listaApuestas = new javax.swing.JTextArea();
        jScrollPanelListaApuestas.setViewportView(listaApuestas);

        javax.swing.GroupLayout jPanelCjtoApuestasLayout = new javax.swing.GroupLayout(this);
        setLayout(jPanelCjtoApuestasLayout);
        jPanelCjtoApuestasLayout.setHorizontalGroup(
            jPanelCjtoApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 261, Short.MAX_VALUE)
            .addGroup(jPanelCjtoApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCjtoApuestasLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPanelListaApuestas, 190, 190, 190)))
        );
        jPanelCjtoApuestasLayout.setVerticalGroup(
            jPanelCjtoApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 289, Short.MAX_VALUE)
            .addGroup(jPanelCjtoApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPanelListaApuestas, javax.swing.GroupLayout.Alignment.TRAILING, 100, 289, Short.MAX_VALUE))
        );

    }

    public JScrollPane getJScrollPanelListaApuestas() {
        return jScrollPanelListaApuestas;
    }

    public JTextArea getListaApuestas() {
        return listaApuestas;
    }


    
}
