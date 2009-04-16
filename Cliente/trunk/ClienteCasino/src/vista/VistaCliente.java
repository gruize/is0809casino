/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

/**
 *
 * @author david
 */
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import java.util.Observer;
import java.util.Observable;
import controlador.ControladorCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodListener;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class VistaCliente extends JFrame implements Observer  {

        private ControladorCliente controlador;
        private JPanelChat PanelChat;
        private JPanelApuestas PanelApuestas;
        private JPanelUsuarios PanelUsuarios;
        private JPanelRuleta PanelRuleta;
        private OyenteBloquearChat bloquearChat;
        private OyenteApostar apostar;
        private OyenteEnviarMensajeChat enviarMensajeChat;
        private OyenteListaJugadores listaJugadores;
        private OyenteChat mensajesChat;
        private OyenteCerrarVentana cerrarVentana;
        private OyenteValoresApuesta valoresApuesta;
        private OyenteCantidadApuesta cantidadApuesta;

     public VistaCliente(ControladorCliente control) {
        super("Cliente Casino");
        controlador = control;
        inicializar();
        ponerOyentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setExtendedState(MAXIMIZED_BOTH);
        setSize(1024,768);
		setVisible(false);
        setResizable(false);
     }
     private void inicializar() {

         PanelUsuarios = new JPanelUsuarios(controlador);
         PanelRuleta = new JPanelRuleta(controlador);
         PanelApuestas = new JPanelApuestas(controlador);
         PanelChat = new JPanelChat(controlador);
     
         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelApuestas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(PanelRuleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelRuleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelApuestas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

     pack();
     add(PanelApuestas);
     add(PanelChat);
     add(PanelRuleta);
     add(PanelUsuarios);

     }
     
     private void ponerOyentes() {
       //bloquearChat = new OyenteBloquearChat();
       apostar = new OyenteApostar();
       enviarMensajeChat = new OyenteEnviarMensajeChat();
       listaJugadores = new OyenteListaJugadores();
       mensajesChat = new OyenteChat();
       cerrarVentana = new OyenteCerrarVentana();
       valoresApuesta = new OyenteValoresApuesta();
       cantidadApuesta = new OyenteCantidadApuesta();

       PanelChat.getBotonBloquear().addActionListener(bloquearChat);
       PanelChat.getBotonEnviar().addActionListener(enviarMensajeChat);
       //TODO: Elegir una de las dos lista de jugadores, ya que se repitan es inncecesario y antiestetico.
       PanelChat.getListaUsuarios().addListSelectionListener(listaJugadores);
       PanelUsuarios.getUsuarios().addListSelectionListener(listaJugadores);
       PanelApuestas.getBotonApostar().addActionListener(apostar);

       //Botones de valores a los que apostar.
       PanelApuestas.getButton0().addActionListener(valoresApuesta);
       PanelApuestas.getButton1().addActionListener(valoresApuesta);
       PanelApuestas.getButton2().addActionListener(valoresApuesta);
       PanelApuestas.getButton3().addActionListener(valoresApuesta);
       PanelApuestas.getButton4().addActionListener(valoresApuesta);
       PanelApuestas.getButton5().addActionListener(valoresApuesta);
       PanelApuestas.getButton6().addActionListener(valoresApuesta);
       PanelApuestas.getButton7().addActionListener(valoresApuesta);
       PanelApuestas.getButton8().addActionListener(valoresApuesta);
       PanelApuestas.getButton9().addActionListener(valoresApuesta);
       PanelApuestas.getButton10().addActionListener(valoresApuesta);
       PanelApuestas.getButton11().addActionListener(valoresApuesta);
       PanelApuestas.getButton12().addActionListener(valoresApuesta);
       PanelApuestas.getButton13().addActionListener(valoresApuesta);
       PanelApuestas.getButton14().addActionListener(valoresApuesta);
       PanelApuestas.getButton15().addActionListener(valoresApuesta);
       PanelApuestas.getButton16().addActionListener(valoresApuesta);
       PanelApuestas.getButton17().addActionListener(valoresApuesta);
       PanelApuestas.getButton18().addActionListener(valoresApuesta);
       PanelApuestas.getButton19().addActionListener(valoresApuesta);
       PanelApuestas.getButton20().addActionListener(valoresApuesta);
       PanelApuestas.getButton21().addActionListener(valoresApuesta);
       PanelApuestas.getButton22().addActionListener(valoresApuesta);
       PanelApuestas.getButton23().addActionListener(valoresApuesta);
       PanelApuestas.getButton24().addActionListener(valoresApuesta);
       PanelApuestas.getButton25().addActionListener(valoresApuesta);
       PanelApuestas.getButton26().addActionListener(valoresApuesta);
       PanelApuestas.getButton27().addActionListener(valoresApuesta);
       PanelApuestas.getButton28().addActionListener(valoresApuesta);
       PanelApuestas.getButton29().addActionListener(valoresApuesta);
       PanelApuestas.getButton30().addActionListener(valoresApuesta);
       PanelApuestas.getButton31().addActionListener(valoresApuesta);
       PanelApuestas.getButton32().addActionListener(valoresApuesta);
       PanelApuestas.getButton33().addActionListener(valoresApuesta);
       PanelApuestas.getButton34().addActionListener(valoresApuesta);
       PanelApuestas.getButton35().addActionListener(valoresApuesta);
       PanelApuestas.getButton36().addActionListener(valoresApuesta);
       PanelApuestas.getButton19a36().addActionListener(valoresApuesta);
       PanelApuestas.getButton1a18().addActionListener(valoresApuesta);
       PanelApuestas.getButton1ero12().addActionListener(valoresApuesta);
       PanelApuestas.getButton2do12().addActionListener(valoresApuesta);
       PanelApuestas.getButton3ro12().addActionListener(valoresApuesta);
       PanelApuestas.getButtonImpar().addActionListener(valoresApuesta);
       PanelApuestas.getButtonPares().addActionListener(valoresApuesta);
       PanelApuestas.getButtonRojo().addActionListener(valoresApuesta);
       PanelApuestas.getButtonNegro().addActionListener(valoresApuesta);
       PanelApuestas.getButton2a1Fila1().addActionListener(valoresApuesta);
       PanelApuestas.getButton2a1Fila2().addActionListener(valoresApuesta);
       PanelApuestas.getButton2a1Fila3().addActionListener(valoresApuesta);
       PanelApuestas.getChoiceCantidad().addItemListener(cantidadApuesta);
       PanelApuestas.getChoiceValor().addItemListener(cantidadApuesta);

       addWindowListener(cerrarVentana);
     }
        


     public void update(Observable o, Object arg) {
        //if(obj instanceof
        //Hacer lo que sea.
    }

    class OyenteCantidadApuesta implements ItemListener{

        public void itemStateChanged(ItemEvent e) {
            PanelApuestas.getLabelTotalApostado().setText(Integer.toString(Integer.parseInt(PanelApuestas.getChoiceCantidad().getSelectedItem())*Integer.parseInt(PanelApuestas.getChoiceValor().getSelectedItem())));
        }


    }

    class OyenteBloquearChat implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            if(JOptionPane.showConfirmDialog(PanelChat, "Confirme que desea bloquear el chat", "Bloqueo del Chat", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
                PanelChat.setVisible(false);
                //TODO: Añadir un boton de Desbloqueo para el chat.
            }
        }

    }

    class OyenteApostar implements ActionListener{

        public void actionPerformed(ActionEvent e) {
          if(PanelApuestas.getLabelTotalApostado().getText().equals("000") || (PanelApuestas.getLabelTotalApostado().getText().equals("0"))){
            JOptionPane.showMessageDialog(PanelApuestas,"La apuesta debe ser mayor que 0.","Fallo al apostar",JOptionPane.ERROR_MESSAGE);    
          }else{
              if(PanelApuestas.getLabelValor().getText().equals("---")){
                  JOptionPane.showMessageDialog(PanelApuestas,"Debe elegir algun valor.","Fallo al apostar",JOptionPane.ERROR_MESSAGE);
              }else{
                if(JOptionPane.showConfirmDialog(PanelApuestas, "Confirme la conformidad de su apuesta\nValor: " + PanelApuestas.getLabelValor().getText() + "\nCantidad: " + PanelApuestas.getLabelTotalApostado().getText(), "Confirmacion de la apuesta", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    controlador.realizarApuesta(Integer.parseInt(PanelApuestas.getLabelTotalApostado().getText()),PanelApuestas.getLabelValor().getText());
                    reinicializarValores();
                }
             }
          }
        }

    }

    class OyenteEnviarMensajeChat implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            if(PanelChat.getTextfieldFrase().getText().equals("")){
                JOptionPane.showMessageDialog(PanelChat,"Debe escribir un mensaje","Error en el envio",JOptionPane.ERROR_MESSAGE);
            }else{
                String mensaje = PanelChat.getTextfieldFrase().getText();
                controlador.enviarMensajeChat(mensaje);
            }
        }

    }

    class OyenteValoresApuesta implements ActionListener{

        public void actionPerformed(ActionEvent e) {                        
            PanelApuestas.getLabelTotalApostado().setText(Integer.toString(Integer.parseInt(PanelApuestas.getChoiceCantidad().getSelectedItem())*Integer.parseInt(PanelApuestas.getChoiceValor().getSelectedItem())));
            PanelApuestas.getLabelValor().setText(e.getActionCommand().substring(6));
        }

    }

    class OyenteListaJugadores implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent e) {
            JList listaJug = PanelUsuarios.getUsuarios();
            //TODO: Aun x hacer
        }

    }

    class OyenteChat implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent e) {
           
        }

    }



    class OyenteCerrarVentana extends WindowAdapter{

		public void windowClosing(WindowEvent e){
            salir();
		}

	}

    private void salir() {
        if (JOptionPane.showConfirmDialog(this,"¿Desea abandonar el juego?",
                "Cierre del juego",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
            try {
				if(controlador.desconectar())
					controlador.desconectarCliente();
			}
            catch (IOException e1) {
                e1.printStackTrace();
			}
            System.exit(0);

    }

    private void reinicializarValores() {
        PanelApuestas.getLabelTotalApostado().setText("000");
        PanelApuestas.getLabelValor().setText("---");
        PanelApuestas.getChoiceCantidad().select(0);
        PanelApuestas.getChoiceValor().select(0);
    }
}
