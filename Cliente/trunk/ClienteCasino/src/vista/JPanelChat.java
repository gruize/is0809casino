/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author gabi
 */
public class JPanelChat extends javax.swing.JPanel {

    //Constantes declaration - do not modify
    static String BLOQUEO = "BloqueoChat";
    static String DESBLOQUEO = "DesbloqueoChat";
    //End of constantes declaration
    // Variables declaration - do not modify
    private javax.swing.JTextArea areaTextoChat;
    private javax.swing.JButton botonBloquear;
    private javax.swing.JButton botonEnviar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField textfieldFrase;
    // End of variables declaration
    
    
    /** Creates new form JPanelChatTemporal */
    public JPanelChat() {
        initComponents();
    }

    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTextoChat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        textfieldFrase = new javax.swing.JTextField();
        botonEnviar = new javax.swing.JButton();
        botonBloquear = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        areaTextoChat.setColumns(20);
        areaTextoChat.setRows(5);
        areaTextoChat.setBorder(null);
        jScrollPane1.setViewportView(areaTextoChat);

        jScrollPane2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        textfieldFrase.setBorder(null);
        jScrollPane2.setViewportView(textfieldFrase);

        botonEnviar.setText("Enviar");
        botonEnviar.setActionCommand("enviarMensajeChat");
        botonEnviar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        botonBloquear.setText("Bloquear");
        botonBloquear.setActionCommand(BLOQUEO);
        botonBloquear.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonBloquear, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(botonEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonBloquear, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }

    public JTextArea getAreaTextoChat() {
        return areaTextoChat;
    }

    public void setAreaTextoChat(JTextArea areaTextoChat) {
        this.areaTextoChat = areaTextoChat;
    }

    public JButton getBotonBloquear() {
        return botonBloquear;
    }

    public void setBotonBloquear(JButton botonBloquear) {
        this.botonBloquear = botonBloquear;
    }

    public JButton getBotonEnviar() {
        return botonEnviar;
    }

    public void setBotonEnviar(JButton botonEnviar) {
        this.botonEnviar = botonEnviar;
    }

    public JTextField getTextfieldFrase() {
        return textfieldFrase;
    }

    public void setTextfieldFrase(String texto) {
        this.textfieldFrase.setText(texto);
    }

    
}

