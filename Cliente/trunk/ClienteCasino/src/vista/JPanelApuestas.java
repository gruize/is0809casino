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
public class JPanelApuestas extends JPanel{

    private ControladorCliente controlador;
    private java.awt.Button botonApostar;
    private java.awt.Button button0;
    private java.awt.Button button1;
    private java.awt.Button button10;
    private java.awt.Button button11;
    private java.awt.Button button12;
    private java.awt.Button button13;
    private java.awt.Button button14;
    private java.awt.Button button15;
    private java.awt.Button button16;
    private java.awt.Button button17;
    private java.awt.Button button18;
    private java.awt.Button button19;
    private java.awt.Button button19a36;
    private java.awt.Button button1a18;
    private java.awt.Button button1ero12;
    private java.awt.Button button2;
    private java.awt.Button button20;
    private java.awt.Button button21;
    private java.awt.Button button22;
    private java.awt.Button button23;
    private java.awt.Button button24;
    private java.awt.Button button25;
    private java.awt.Button button26;
    private java.awt.Button button27;
    private java.awt.Button button28;
    private java.awt.Button button29;
    private java.awt.Button button2a1Fila1;
    private java.awt.Button button2a1Fila2;
    private java.awt.Button button2a1Fila3;
    private java.awt.Button button2do12;
    private java.awt.Button button3;
    private java.awt.Button button30;
    private java.awt.Button button31;
    private java.awt.Button button32;
    private java.awt.Button button33;
    private java.awt.Button button34;
    private java.awt.Button button35;
    private java.awt.Button button36;
    private java.awt.Button button3ro12;
    private java.awt.Button button4;
    private java.awt.Button button5;
    private java.awt.Button button6;
    private java.awt.Button button7;
    private java.awt.Button button8;
    private java.awt.Button button9;
    private java.awt.Button buttonImpar;
    private java.awt.Button buttonNegro;
    private java.awt.Button buttonPares;
    private java.awt.Button buttonRojo;
    private java.awt.Choice choiceCantidad;
    private java.awt.Choice choiceValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private java.awt.Label labelTotalApostado;
    private java.awt.Label labelValor;

     public JPanelApuestas(ControladorCliente control) {

       controlador = control;
       botonApostar = new java.awt.Button();
        labelTotalApostado = new java.awt.Label();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        button3 = new java.awt.Button();
        button4 = new java.awt.Button();
        button5 = new java.awt.Button();
        button6 = new java.awt.Button();
        button7 = new java.awt.Button();
        button8 = new java.awt.Button();
        button9 = new java.awt.Button();
        button10 = new java.awt.Button();
        button11 = new java.awt.Button();
        button12 = new java.awt.Button();
        button13 = new java.awt.Button();
        button14 = new java.awt.Button();
        button15 = new java.awt.Button();
        button16 = new java.awt.Button();
        button17 = new java.awt.Button();
        button18 = new java.awt.Button();
        button19 = new java.awt.Button();
        button20 = new java.awt.Button();
        button21 = new java.awt.Button();
        button22 = new java.awt.Button();
        button23 = new java.awt.Button();
        button24 = new java.awt.Button();
        button25 = new java.awt.Button();
        button26 = new java.awt.Button();
        button27 = new java.awt.Button();
        button28 = new java.awt.Button();
        button29 = new java.awt.Button();
        button30 = new java.awt.Button();
        button31 = new java.awt.Button();
        button32 = new java.awt.Button();
        button33 = new java.awt.Button();
        button34 = new java.awt.Button();
        button35 = new java.awt.Button();
        button36 = new java.awt.Button();
        button2a1Fila1 = new java.awt.Button();
        button2a1Fila2 = new java.awt.Button();
        button2a1Fila3 = new java.awt.Button();
        button1ero12 = new java.awt.Button();
        button2do12 = new java.awt.Button();
        button3ro12 = new java.awt.Button();
        button1a18 = new java.awt.Button();
        buttonPares = new java.awt.Button();
        buttonNegro = new java.awt.Button();
        buttonRojo = new java.awt.Button();
        buttonImpar = new java.awt.Button();
        button19a36 = new java.awt.Button();
        button0 = new java.awt.Button();
        choiceCantidad = new java.awt.Choice();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        choiceValor = new java.awt.Choice();
        jLabel5 = new javax.swing.JLabel();
        labelValor = new java.awt.Label();
        jLabel2 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        botonApostar.setActionCommand("Apostar");
        botonApostar.setFont(new java.awt.Font("Dialog", 1, 10));
        botonApostar.setLabel("APOSTAR");
        botonApostar.setName("buttonApostar"); // NOI18N


        labelTotalApostado.setAlignment(java.awt.Label.CENTER);
        labelTotalApostado.setBackground(new java.awt.Color(236, 233, 216));
        labelTotalApostado.setName("labeltotalApostado"); // NOI18N
        labelTotalApostado.setText("000");

        button1.setFont(new java.awt.Font("Dialog", 0, 10));
        button1.setLabel("1");


        button2.setFont(new java.awt.Font("Dialog", 0, 10));
        button2.setLabel("2");


        button3.setFont(new java.awt.Font("Dialog", 0, 10));
        button3.setLabel("3");


        button4.setFont(new java.awt.Font("Dialog", 0, 10));
        button4.setLabel("4");


        button5.setFont(new java.awt.Font("Dialog", 0, 10));
        button5.setLabel("5");


        button6.setFont(new java.awt.Font("Dialog", 0, 10));
        button6.setLabel("6");


        button7.setFont(new java.awt.Font("Dialog", 0, 10));
        button7.setLabel("7");


        button8.setFont(new java.awt.Font("Dialog", 0, 10));
        button8.setLabel("8");


        button9.setFont(new java.awt.Font("Dialog", 0, 10));
        button9.setLabel("9");


        button10.setFont(new java.awt.Font("Dialog", 0, 10));
        button10.setLabel("10");


        button11.setFont(new java.awt.Font("Dialog", 0, 10));
        button11.setLabel("11");


        button12.setFont(new java.awt.Font("Dialog", 0, 10));
        button12.setLabel("12");


        button13.setFont(new java.awt.Font("Dialog", 0, 10));
        button13.setLabel("13");


        button14.setFont(new java.awt.Font("Dialog", 0, 10));
        button14.setLabel("14");


        button15.setFont(new java.awt.Font("Dialog", 0, 10));
        button15.setLabel("15");


        button16.setFont(new java.awt.Font("Dialog", 0, 10));
        button16.setLabel("16");


        button17.setFont(new java.awt.Font("Dialog", 0, 10));
        button17.setLabel("17");


        button18.setFont(new java.awt.Font("Dialog", 0, 10));
        button18.setLabel("18");


        button19.setFont(new java.awt.Font("Dialog", 0, 10));
        button19.setLabel("19");


        button20.setFont(new java.awt.Font("Dialog", 0, 10));
        button20.setLabel("20");


        button21.setFont(new java.awt.Font("Dialog", 0, 10));
        button21.setLabel("21");


        button22.setFont(new java.awt.Font("Dialog", 0, 10));
        button22.setLabel("22");


        button23.setFont(new java.awt.Font("Dialog", 0, 10));
        button23.setLabel("23");


        button24.setFont(new java.awt.Font("Dialog", 0, 10));
        button24.setLabel("24");


        button25.setFont(new java.awt.Font("Dialog", 0, 10));
        button25.setLabel("25");


        button26.setFont(new java.awt.Font("Dialog", 0, 10));
        button26.setLabel("26");


        button27.setFont(new java.awt.Font("Dialog", 0, 10));
        button27.setLabel("27");


        button28.setFont(new java.awt.Font("Dialog", 0, 10));
        button28.setLabel("28");


        button29.setFont(new java.awt.Font("Dialog", 0, 10));
        button29.setLabel("29");


        button30.setFont(new java.awt.Font("Dialog", 0, 10));
        button30.setLabel("30");


        button31.setFont(new java.awt.Font("Dialog", 0, 10));
        button31.setLabel("31");


        button32.setFont(new java.awt.Font("Dialog", 0, 10));
        button32.setLabel("32");


        button33.setFont(new java.awt.Font("Dialog", 0, 10));
        button33.setLabel("33");


        button34.setFont(new java.awt.Font("Dialog", 0, 10));
        button34.setLabel("34");


        button35.setFont(new java.awt.Font("Dialog", 0, 10));
        button35.setLabel("35");


        button36.setFont(new java.awt.Font("Dialog", 0, 10));
        button36.setLabel("36");


        button2a1Fila1.setActionCommand("button1fila");
        button2a1Fila1.setFont(new java.awt.Font("Dialog", 0, 10));
        button2a1Fila1.setLabel("2a1");
        button2a1Fila1.setName("button1fila"); // NOI18N


        button2a1Fila2.setActionCommand("button2fila");
        button2a1Fila2.setFont(new java.awt.Font("Dialog", 0, 10));
        button2a1Fila2.setLabel("2a1");
        button2a1Fila2.setName("button2fila"); // NOI18N


        button2a1Fila3.setActionCommand("button3fila");
        button2a1Fila3.setFont(new java.awt.Font("Dialog", 0, 10));
        button2a1Fila3.setLabel("2a1");
        button2a1Fila3.setName("button3fila"); // NOI18N


        button1ero12.setActionCommand("button1ero12");
        button1ero12.setFont(new java.awt.Font("Dialog", 0, 10));
        button1ero12.setLabel("1ero12");
        button1ero12.setName("button1ero12"); // NOI18N


        button2do12.setActionCommand("button2do12");
        button2do12.setFont(new java.awt.Font("Dialog", 0, 10));
        button2do12.setLabel("2do12");


        button3ro12.setActionCommand("button3ro12");
        button3ro12.setFont(new java.awt.Font("Dialog", 0, 10));
        button3ro12.setLabel("3ro12");
        button3ro12.setName("button3ro12"); // NOI18N


        button1a18.setActionCommand("button1a18");
        button1a18.setFont(new java.awt.Font("Dialog", 0, 10));
        button1a18.setLabel("1 a 18");
        button1a18.setName("button1a18"); // NOI18N


        buttonPares.setActionCommand("buttonPares");
        buttonPares.setFont(new java.awt.Font("Dialog", 0, 10));
        buttonPares.setLabel("Pares");
        buttonPares.setName("buttonPares"); // NOI18N


        buttonNegro.setActionCommand("buttonNegro");
        buttonNegro.setBackground(new java.awt.Color(0, 0, 0));
        buttonNegro.setFont(new java.awt.Font("Dialog", 0, 10));
        buttonNegro.setName("buttonNegro"); // NOI18N


        buttonRojo.setActionCommand("buttonRojo");
        buttonRojo.setBackground(new java.awt.Color(255, 0, 0));
        buttonRojo.setFont(new java.awt.Font("Dialog", 0, 10));
        buttonRojo.setForeground(new java.awt.Color(255, 0, 0));
        buttonRojo.setLabel("Rojo");
        buttonRojo.setName("buttonRojo"); // NOI18N


        buttonImpar.setActionCommand("buttonImpar");
        buttonImpar.setFont(new java.awt.Font("Dialog", 0, 10));
        buttonImpar.setLabel("Impar");
        buttonImpar.setName("buttonImpar"); // NOI18N


        button19a36.setActionCommand("button19a36");
        button19a36.setFont(new java.awt.Font("Dialog", 0, 10));
        button19a36.setLabel("19 a 36");
        button19a36.setName("button19a36"); // NOI18N

        button0.setActionCommand("button0");
        button0.setBackground(new java.awt.Color(255, 255, 255));
        button0.setFont(new java.awt.Font("Dialog", 0, 10));
        button0.setLabel("0");


        jLabel1.setText("Total apostado:");

        jLabel3.setText("Valor de la ficha:");

        jLabel4.setText("Nº de fichas:");


        jLabel5.setText("Valor apostado:");

        labelValor.setAlignment(java.awt.Label.CENTER);
        labelValor.setBackground(new java.awt.Color(236, 233, 216));
        labelValor.setName("labeltotalApostado"); // NOI18N
        labelValor.setText("---");

        javax.swing.GroupLayout jPanelApuestasLayout = new javax.swing.GroupLayout(this);
        setLayout(jPanelApuestasLayout);
        jPanelApuestasLayout.setHorizontalGroup(
            jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelApuestasLayout.createSequentialGroup()
                .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelApuestasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(button2a1Fila3, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                                .addComponent(button2a1Fila2, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                                .addComponent(button2a1Fila1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE))
                            .addComponent(button0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(button1ero12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelApuestasLayout.createSequentialGroup()
                                    .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelApuestasLayout.createSequentialGroup()
                                            .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanelApuestasLayout.createSequentialGroup()
                                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanelApuestasLayout.createSequentialGroup()
                                            .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelApuestasLayout.createSequentialGroup()
                                            .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(button12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanelApuestasLayout.createSequentialGroup()
                                            .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(button10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanelApuestasLayout.createSequentialGroup()
                                            .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanelApuestasLayout.createSequentialGroup()
                                    .addComponent(button1a18, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(buttonPares, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanelApuestasLayout.createSequentialGroup()
                                .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1))
                                .addGap(4, 4, 4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelApuestasLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(labelValor, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanelApuestasLayout.createSequentialGroup()
                                    .addComponent(button15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelApuestasLayout.createSequentialGroup()
                                    .addComponent(button13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelApuestasLayout.createSequentialGroup()
                                    .addComponent(button14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelApuestasLayout.createSequentialGroup()
                                    .addComponent(buttonNegro, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(buttonRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(labelTotalApostado, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button2do12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelApuestasLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(28, 28, 28)
                        .addComponent(choiceValor, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel4)
                        .addGap(10, 10, 10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanelApuestasLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(buttonImpar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button19a36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(choiceCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelApuestasLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanelApuestasLayout.createSequentialGroup()
                                    .addComponent(button27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelApuestasLayout.createSequentialGroup()
                                    .addComponent(button26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelApuestasLayout.createSequentialGroup()
                                    .addComponent(button25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(button3ro12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanelApuestasLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(botonApostar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelApuestasLayout.setVerticalGroup(
            jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelApuestasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelApuestasLayout.createSequentialGroup()
                        .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelApuestasLayout.createSequentialGroup()
                                .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelApuestasLayout.createSequentialGroup()
                                .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelApuestasLayout.createSequentialGroup()
                                .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(button15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelApuestasLayout.createSequentialGroup()
                                .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(button27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button2do12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button1ero12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button3ro12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button19a36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonImpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonNegro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonPares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button1a18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonRojo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelApuestasLayout.createSequentialGroup()
                        .addComponent(button2a1Fila1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button2a1Fila2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button2a1Fila3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelApuestasLayout.createSequentialGroup()
                        .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(choiceCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(choiceValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelTotalApostado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelApuestasLayout.createSequentialGroup()
                .addContainerGap(211, Short.MAX_VALUE)
                .addComponent(botonApostar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
     }
}
