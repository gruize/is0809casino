/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.ControladorCliente;
import javax.swing.JPanel;
/**
 *
 * @author david
 */
public class JPanelUsuarios extends JPanel{

    private javax.swing.JScrollPane jScrollPanelListaUsers;
    private javax.swing.JList listaUsuarios;
    private ControladorCliente controlador;

    public JPanelUsuarios(ControladorCliente control){

        jScrollPanelListaUsers = new javax.swing.JScrollPane();
        listaUsuarios = new javax.swing.JList();
        jScrollPanelListaUsers.setViewportView(listaUsuarios);

        javax.swing.GroupLayout jPanelUsuariosLayout = new javax.swing.GroupLayout(this);
        setLayout(jPanelUsuariosLayout);
        jPanelUsuariosLayout.setHorizontalGroup(
            jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 261, Short.MAX_VALUE)
            .addGroup(jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUsuariosLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPanelListaUsers, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)))
        );
        jPanelUsuariosLayout.setVerticalGroup(
            jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 289, Short.MAX_VALUE)
            .addGroup(jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPanelListaUsers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
        );

    }
}
