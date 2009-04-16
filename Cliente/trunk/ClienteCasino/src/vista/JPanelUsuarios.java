/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.ControladorCliente;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
/**
 *
 * @author david
 */
public class JPanelUsuarios extends JPanel{

    public JScrollPane getJScrollPanelListaUsers() {
        return jScrollPanelListaUsers;
    }

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
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUsuariosLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPanelListaUsers,190, 190, 190)))
        );
        jPanelUsuariosLayout.setVerticalGroup(
            jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPanelListaUsers, javax.swing.GroupLayout.Alignment.TRAILING, 150, 150, Short.MAX_VALUE))
        );       
        
    }

    public javax.swing.JList getUsuarios() {
        return listaUsuarios;
    }
}
