/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
/**
 *
 * @author GabiPC
 */
public class JPanelUsuariosTemp extends JPanel{

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaUsuarios;
    private javax.swing.JLabel jLabelTitulo;

    public JList getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(JList listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public JPanelUsuariosTemp(){

        jScrollPane1 = new javax.swing.JScrollPane();
        listaUsuarios = new javax.swing.JList();
        jLabelTitulo = new javax.swing.JLabel();

        listaUsuarios.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaUsuarios);

        jLabelTitulo.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Usuarios");
        jLabelTitulo.setForeground(new Color(51,153,0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(jLabelTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        this.setOpaque(false);
    }

    public javax.swing.JList getlistaUsuarios() {
        return listaUsuarios;
    }

    public JLabel getJLabelTitulo() {
        return jLabelTitulo;
    }

    public JScrollPane getJScrollPane1() {
        return jScrollPane1;
    }


}