/*
 * InterfazChat2.java
 *
 * Created on 2 de abril de 2009, 11:43
 */

package InterfazCliente;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 *
 * @author  Javier Garcia
 */
public class InterfazChat extends javax.swing.JPanel {

    /** Creates new form InterfazChat2 */
    public InterfazChat(String[] usuarios) {
        initComponents();
        cargarUsuarios(usuarios);
      
    }
    //BLOQUEAR USUARIO
    public void bloquearUsuario(String usuario) {
      this.escribirFraseChat(usuario, "HA SIDO BLOQUEADO");
      
    }
    //CARGAR LISTA DE USUARIOS 
        private void cargarUsuarios(String[]lista){
            this.listaUsuarios.setListData(lista);     
        }
    //ENVIAR FRASE CHAT
        public String enviarFraseChat(){
            String aux=this.textfieldFrase.getText();
            this.textfieldFrase.setText("");
            return aux;
            
        }
    //ESCRIBIR FRASE DE CHAT
        public void escribirFraseChat(String usuario,String frase){
            this.areaTextoChat.append(usuario+": "+frase+"\n");
        }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textfieldFrase = new javax.swing.JTextField();
        botonEnviar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTextoChat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaUsuarios = new javax.swing.JList();
        botonBloquear = new javax.swing.JButton();

        textfieldFrase.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                presionarEnter(evt);
            }
        });

        botonEnviar.setText("Enviar");
        botonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarActionPerformed(evt);
            }
        });

        areaTextoChat.setColumns(20);
        areaTextoChat.setEditable(false);
        areaTextoChat.setRows(5);
        jScrollPane1.setViewportView(areaTextoChat);

        jScrollPane2.setViewportView(listaUsuarios);

        botonBloquear.setText("Bloquear");
        botonBloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBloquearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonBloquear)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textfieldFrase, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(botonEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonBloquear)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEnviar)
                    .addComponent(textfieldFrase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void presionarEnter(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_presionarEnter
// TODO add your handling code here:
    if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        this.escribirFraseChat("javi",this.enviarFraseChat());
    }
    
}//GEN-LAST:event_presionarEnter

private void botonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnviarActionPerformed
// TODO add your handling code here:
    this.escribirFraseChat("javi",this.enviarFraseChat());
}//GEN-LAST:event_botonEnviarActionPerformed
//boton bloquear
private void botonBloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBloquearActionPerformed
// TODO add your handling code here:
    String usuario=(String)this.listaUsuarios.getSelectedValue();
    bloquearUsuario(usuario);
}//GEN-LAST:event_botonBloquearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTextoChat;
    private javax.swing.JButton botonBloquear;
    private javax.swing.JButton botonEnviar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList listaUsuarios;
    private javax.swing.JTextField textfieldFrase;
    // End of variables declaration//GEN-END:variables

}
