/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

/**
 *
 * @author david
 */

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



import java.util.Observer;
import java.util.Observable;
import controlador.ControladorCliente;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class VistaRuleta extends JFrame implements Observer  {

        private ControladorCliente controlador;
        private JPanelChat PanelChat;
        private JPanelApuestas PanelApuestas;
        private JPanelUsuarios PanelUsuarios;
        private JPanelRuleta PanelRuleta;
        private JPanelCjtoApuestas PanelCjtoApuestas;
        private OyenteBloquearChat bloquearChat;
        private OyenteApostar apostar;
        private OyenteEnviarMensajeChat enviarMensajeChat;
        private OyenteListaJugadores listaJugadores;
        private OyenteChat mensajesChat;
        private OyenteCerrarVentana cerrarVentana;
        private OyenteValoresApuesta valoresApuesta;
        private OyenteCantidadApuesta cantidadApuesta;       

     public VistaRuleta(ControladorCliente control) {
        super("Cliente Casino");
        controlador = control;
        inicializar();
        ponerOyentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024,768);		
        setResizable(false);      
        //Añadimos los observables
        controlador.getModelo().addObserver(this);
     }

     private void inicializar() {

         Color colorCasino = new Color(0,0,0);
                  

         PanelUsuarios = new JPanelUsuarios(controlador);
         PanelUsuarios.setBackground(colorCasino);

         PanelRuleta = new JPanelRuleta();

         PanelApuestas = new JPanelApuestas(controlador);
         PanelApuestas.setBackground(colorCasino);

         PanelChat = new JPanelChat();
         PanelChat.setBackground(colorCasino);

         PanelCjtoApuestas = new JPanelCjtoApuestas(controlador);
         PanelCjtoApuestas.setBackground(colorCasino);

         
     
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(PanelChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)                    

                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(PanelUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PanelCjtoApuestas)
                        .addContainerGap()))

                    
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                    .addComponent(PanelCjtoApuestas,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelApuestas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

     pack();

     add(PanelApuestas);
     add(PanelChat);
     add(PanelRuleta);
     add(PanelUsuarios);
     add(PanelCjtoApuestas);

     }
     
     private void ponerOyentes() {

       ponerOyentesChat();
       apostar = new OyenteApostar();      
       cerrarVentana = new OyenteCerrarVentana();
       valoresApuesta = new OyenteValoresApuesta();
       cantidadApuesta = new OyenteCantidadApuesta();
       
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
        
     private void ponerOyentesChat(){
        bloquearChat = new OyenteBloquearChat();
        enviarMensajeChat = new OyenteEnviarMensajeChat();
        mensajesChat = new OyenteChat();
        listaJugadores = new OyenteListaJugadores();

        PanelChat.getBotonBloquear().addActionListener(bloquearChat);
        PanelChat.getBotonEnviar().addActionListener(enviarMensajeChat);
        //TODO: Elegir una de las dos lista de jugadores, ya que se repitan es inncecesario y antiestetico.
        PanelChat.getListaUsuarios().addListSelectionListener(listaJugadores);
     }

     public void update(Observable o, Object arg) {
        //if(obj instanceof
        //Hacer lo que sea.
         //Actualizamos el chat si llega algun mensaje,
         String mensaje="Escrito por el usuario: "+controlador.getModelo().getUsuario()+" con id: "+ controlador.getJugador().getId()+ "\n"+
                            controlador.getModelo().getmensajechat()+"\n";
         PanelChat.setAreaTextoChat(mensaje);

    }

    class OyenteCantidadApuesta implements ItemListener{

        public void itemStateChanged(ItemEvent e) {
            PanelApuestas.getLabelTotalApostado().setText(Integer.toString(Integer.parseInt(PanelApuestas.getChoiceCantidad().getSelectedItem())*Integer.parseInt(PanelApuestas.getChoiceValor().getSelectedItem())));
        }


    }

    class OyenteBloquearChat implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals(PanelChat.BLOQUEO)){
                if(JOptionPane.showConfirmDialog(PanelChat, "Confirme que desea bloquear el chat", "Bloqueo del Chat", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
                    bloqueoChat();
                }
            }else{
                if(JOptionPane.showConfirmDialog(PanelChat, "Confirme que desea desbloquear el chat", "Desbloqueo del Chat", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
                    desbloqueoChat();
                }
            }
        }

    }

    private void bloqueoChat(){
        PanelChat.getBotonBloquear().setActionCommand(PanelChat.DESBLOQUEO);
        PanelChat.getBotonBloquear().setText("Desbloquear");
        PanelChat.getAreaTextoChat().setVisible(false);
        PanelChat.getBotonEnviar().setVisible(false);
        PanelChat.getTextfieldFrase().setVisible(false);
        PanelChat.getListaUsuarios().setVisible(false);
        //controlador.inhabilitarChat();
    }

    private void desbloqueoChat(){
        PanelChat.getBotonBloquear().setActionCommand(PanelChat.BLOQUEO);
        PanelChat.getBotonBloquear().setText("Bloquear");
        PanelChat.getAreaTextoChat().setVisible(true);
        PanelChat.getBotonEnviar().setVisible(true);
        PanelChat.getTextfieldFrase().setVisible(true);
        PanelChat.getListaUsuarios().setVisible(true);
        //controlador.habilitarChat();

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
                    PanelCjtoApuestas.getListaApuestas().setText(PanelCjtoApuestas.getListaApuestas().getText() + "\nApuesta a: " + PanelApuestas.getLabelValor().getText() + "\nun total del: " + PanelApuestas.getLabelTotalApostado().getText() + "\n" );
                    controlador.realizarApuesta(Integer.parseInt(PanelApuestas.getLabelTotalApostado().getText()),PanelApuestas.getLabelValor().getText());
                    reinicializarValores();
                }
             }
          }
        }

    }

    class OyenteEnviarMensajeChat implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            if(!PanelChat.getTextfieldFrase().getText().equals("")){
               String mensaje = PanelChat.getTextfieldFrase().getText();
               controlador.enviarMensajeChat(mensaje);
               PanelChat.setTextfieldFrase("");
            }
            else
                 JOptionPane.showMessageDialog(PanelChat,"Debe escribir un mensaje","Error en el envio",JOptionPane.ERROR_MESSAGE);
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
                "Cierre del juego",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
            try{
				if(controlador.desconectar())
					controlador.desconectarCliente();
			}
            catch (IOException e1) {
                e1.printStackTrace();
			}
            System.exit(0);
        }
    }

    private void reinicializarValores() {
        PanelApuestas.getLabelTotalApostado().setText("000");
        PanelApuestas.getLabelValor().setText("---");
        PanelApuestas.getChoiceCantidad().select(0);
        PanelApuestas.getChoiceValor().select(0);
    }
}
