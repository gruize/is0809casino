/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author david
 */
public class JPanelRuleta extends JPanel{

    private JLabel jLabel2;

    public JPanelRuleta() {
       
       jLabel2 = new javax.swing.JLabel();

       setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        //jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("vista/ruleta.gif"))); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon("./recursos/ruleta.gif"));

        javax.swing.GroupLayout jPanelRuletaLayout = new javax.swing.GroupLayout(this);
        setLayout(jPanelRuletaLayout);
        jPanelRuletaLayout.setHorizontalGroup(
            jPanelRuletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRuletaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelRuletaLayout.setVerticalGroup(
            jPanelRuletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
        );
       
    }
}
