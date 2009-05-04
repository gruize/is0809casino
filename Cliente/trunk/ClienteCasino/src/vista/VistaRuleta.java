/*
 * FrameUso.java
 *
 * Created on 03-may-2009, 22:23:11
 */

package vista;

import controlador.ControladorCliente;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.Apuesta;
import modelo.mensajes.MensajeChat;
import modelo.mensajes.MensajeJugada;

/**
 *
 * @author GabiPC
 */
public class VistaRuleta extends javax.swing.JFrame implements Observer{

    private javax.swing.JButton jButtonFinish;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelSaldo;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLayeredPane jLayeredPane1;
    private vista.JPanelChat PanelChat;
    private vista.JPanelCjtoApuestasTemp jPanelCjtoApuestasTemp1;
    private javax.swing.JPanel jPanelDatos;
    private vista.JPanelUsuariosTemp jPanelUsuariosTemp1;
	private BufferedImage ImagenRuleta = null;
	private BufferedImage ImagenBola = null;
	private boolean gira=false;
	private MesaPanel mesa;
	private int bolaX, bolaY;
	private static int numVueltas = 3;
    private ControladorCliente controlador;
    private OyenteBloquearChat bloquearChat;
    private OyenteEnviarMensajeChat enviarMensajeChat;  
    private OyenteCerrarVentana cerrarVentana;
    private OyenteSalir exit;
    private OyenteTerminarApuestas terminarApuestas;
    private OyenteVolver oyenteVolver;
    private OyenteUsuarios oyenteUsuarios;
    private OyenteApuestas oyenteApuestas;

    /** Creates new form FrameUso */
    public VistaRuleta(ControladorCliente control) {
        super("Ruleta");
        controlador = control;
        inicializar();
        ponerOyentes();
        rellenarDatos();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                salir();
            }
        });
        setResizable(false);
        setLocation(200, 0);
    }

    public JPanelCjtoApuestasTemp getJPanelCjtoApuestasTemp1() {
        return jPanelCjtoApuestasTemp1;
    }

    public JPanelUsuariosTemp getJPanelUsuariosTemp1() {
        return jPanelUsuariosTemp1;
    }



    public void rellenarDatos(){
        getJLabelUsuario().setText(controlador.obtenerUsuario());
        getJLabelSaldo().setText(Integer.toString(controlador.obtenerSaldo()));
    }

	public void paint(Graphics g) {
        if(gira){
        if(ImagenRuleta==null)
              ImagenRuleta = loadImage("./recursos/ruleta.png");
        if(ImagenBola==null)
              ImagenBola = loadImage("./recursos/bola.png");
        //g.setColor(getBackground());
        Graphics2D g2 = (Graphics2D)g;
        Graphics2D g3 = (Graphics2D)g;
        for(int i=0;i<256*numVueltas;i++){
            g2.rotate(Math.PI/128.0,575,167);
            g2.drawImage(ImagenRuleta, 497, 89,this);
             try {
                  Thread.sleep(1);
              } catch (InterruptedException e) {}
        }
        g3.drawImage(ImagenBola,bolaX,bolaY,this);
        }
    }

    private void inicializar() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        PanelChat = new vista.JPanelChat();
        jPanelCjtoApuestasTemp1 = new vista.JPanelCjtoApuestasTemp();
        jPanelUsuariosTemp1 = new vista.JPanelUsuariosTemp();
        jButtonBack = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jPanelDatos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelSaldo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButtonFinish = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setBackground(new java.awt.Color(0, 0, 0));
        jLayeredPane1.setOpaque(true);
        PanelChat.setBounds(0, 230, 357, 179);
        jLayeredPane1.add(PanelChat, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPanelCjtoApuestasTemp1.setBounds(190, 420, 150, 200);
        jLayeredPane1.add(jPanelCjtoApuestasTemp1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPanelUsuariosTemp1.setBounds(20, 420, 150, 200);
        jLayeredPane1.add(jPanelUsuariosTemp1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonBack.setIcon(new javax.swing.ImageIcon("C:\\Documents and Settings\\GabiPC\\Escritorio\\II\\Practica IS\\Repositorio\\Cliente\\trunk\\ClienteCasino\\recursos\\3flecha_izquierda-cubeg1-thumb.gif")); // NOI18N
        jButtonBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonBack.setLabel("Volver");
        jButtonBack.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButtonBack.setBounds(40, 660, 73, 80);
        jLayeredPane1.add(jButtonBack, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonSalir.setIcon(new javax.swing.ImageIcon("C:\\Documents and Settings\\GabiPC\\Escritorio\\II\\Practica IS\\Repositorio\\Cliente\\trunk\\ClienteCasino\\recursos\\TgC_boton142.gif")); // NOI18N
        jButtonSalir.setText("Salir");
        jButtonSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSalir.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButtonSalir.setBounds(260, 660, 73, 80);
        jLayeredPane1.add(jButtonSalir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanelDatos.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario:");

        jLabelUsuario.setFont(new java.awt.Font("Century Gothic", 1, 16));
        jLabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUsuario.setText("Usuario");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Saldo actual");

        jLabelSaldo.setFont(new java.awt.Font("Century Gothic", 1, 16));
        jLabelSaldo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSaldo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSaldo.setText("Leuros");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18));
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("5 Segundos restantes");

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelDatosLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabelSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(25, 25, 25))
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanelDatos.setBounds(50, 20, 280, 190);
        jLayeredPane1.add(jPanelDatos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        mesa = new MesaPanel();
        mesa.setBounds(365, 0, 430, 800);
        jLayeredPane1.add(mesa, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonFinish.setIcon(new javax.swing.ImageIcon("C:\\Documents and Settings\\GabiPC\\Escritorio\\II\\Practica IS\\Repositorio\\Cliente\\trunk\\ClienteCasino\\recursos\\TgC_boton142.gif")); // NOI18N
        jButtonFinish.setText("Terminar");
        jButtonFinish.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonFinish.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButtonFinish.setBounds(400, 335, 80, 80);
        jButtonFinish.setContentAreaFilled(false);
        jLayeredPane1.add(jButtonFinish, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.moveToFront(jButtonFinish);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );

        getJButtonBack().setContentAreaFilled(false);
        getJButtonBack().setForeground(new Color(255,0,0));
        getJButtonSalir().setContentAreaFilled(false);
        getJButtonSalir().setForeground(new Color(255,0,0));

        pack();
    }

    private BufferedImage loadImage(String string) {
       URL url=null;
       try { // url = getClass().getClassLoader().getResource(string);
       return ImageIO.read(new File(string));
       } catch (Exception e) {
           System.out.println("No se pudo cargar la imagen " + string +" de "+url);
           System.out.println("El error fue : "+e.getClass().getName()+" "+e.getMessage());
           System.exit(0);
           return null;
       }
    }

    public void girarRuleta(int numRuleta) {


		switch (numRuleta){

			case 22 :  bolaX=525;
					   bolaY=120;
					   break;
			case 18 :  bolaX=530;
					   bolaY=115;
					   break;
			case 29 :  bolaX=543;
					   bolaY=110;
					   break;
			case 7  :  bolaX=553;
					   bolaY=107;
					   break;
			case 28 :  bolaX=563;
			   		   bolaY=107;
			   		   break;
			case 12 :  bolaX=573;
	   		   		   bolaY=107;
	   		   		   break;
			case 35 :  bolaX=580;
	   		   		   bolaY=107;
	   		   		   break;
			case 3  :  bolaX=590;
	   		   		   bolaY=110;
	   		   		   break;
			case 26 :  bolaX=596;
					   bolaY=115;
					   break;
			case 0  :  bolaX=607;
			   		   bolaY=117;
			   		   break;
			case 32 :  bolaX=614;
	   		   		   bolaY=124;
	   		   		   break;
			case 15 :  bolaX=618;
					   bolaY=132;
					   break;
			case 19 :  bolaX=620;
					   bolaY=142;
					   break;
			case 4  :  bolaX=623;
			   		   bolaY=152;
			   		   break;
			case 21 :  bolaX=624;
	   		   		   bolaY=162;
	   		   		   break;
			case 2  :  bolaX=624;
	   		   		   bolaY=172;
	   		   		   break;
			case 25 :  bolaX=624;
	   		   		   bolaY=182;
	   		   		   break;
			case 17 :  bolaX=622;
	   		   		   bolaY=190;
	   		   		   break;
			case 34 :  bolaX=614;
	   		   		   bolaY=196;
	   		           break;
			case  6 :  bolaX=610;
	   		   		   bolaY=207;
	   		   		   break;
			case  27:  bolaX=600;
	   		   		   bolaY=207;
	   		   		   break;
			case  13:  bolaX=590;
	   		   bolaY=210;
	   		   break;
			case  36:  bolaX=580;
	   		   bolaY=215;
	   		   break;
			case  11:  bolaX=570;
	   		   bolaY=216;
	   		   break;
			case  30:  bolaX=562;
	   		   bolaY=216;
	   		   break;
			case  8 :  bolaX=554;
	   		   bolaY=216;
	   		   break;
			case  23 :  bolaX=544;
	   		   bolaY=216;
	   		   break;
			case  10 :  bolaX=532;
	   		   bolaY=210;
	   		   break;
			case  5 :  bolaX=527;
	   		   bolaY=203;
	   		   break;
			case  24 :  bolaX=523;
	   		   bolaY=193;
	   		   break;
			case  16 :  bolaX=518;
	   		   			bolaY=186;
	   		   			break;
			case  33 :  bolaX=516;
	   			bolaY=177;
	   			break;
			case  1 :  bolaX=516;
   			bolaY=166;
   			break;
			case  20 :  bolaX=516;
   						bolaY=155;
   						break;
			case  14 :  bolaX=516;
				bolaY=145;
				break;
			case  31 :  bolaX=518;
			bolaY=135;
			break;
			case  9 :  bolaX=522;
			bolaY=130;
			break;
		}
		gira=true;
		repaint();

	}

    public JButton getJButtonBack() {
        return jButtonBack;
    }

    public JButton getJButtonSalir() {
        return jButtonSalir;
    }

    public JButton getJButtonFinish() {
        return jButtonFinish;
    }

    private void ponerOyentes() {
        bloquearChat = new OyenteBloquearChat();
        enviarMensajeChat = new OyenteEnviarMensajeChat();        
        cerrarVentana = new OyenteCerrarVentana();
        exit = new OyenteSalir();
        terminarApuestas = new OyenteTerminarApuestas();
        oyenteVolver = new OyenteVolver();
        oyenteUsuarios = new OyenteUsuarios();
        oyenteApuestas = new OyenteApuestas();

        PanelChat.getBotonBloquear().addActionListener(bloquearChat);
        PanelChat.getBotonEnviar().addActionListener(enviarMensajeChat);
        getJButtonSalir().addActionListener(exit);
        getJButtonFinish().addActionListener(terminarApuestas);                
        getJButtonBack().addActionListener(oyenteVolver);
    }

     public void update(Observable o, Object arg) {
         if (arg instanceof MensajeChat) {
               MensajeChat mensaje = (MensajeChat)arg;
               String textoadd = PanelChat.getAreaTextoChat().getText() + "\n" + mensaje.get_usuario() + ": " + mensaje.get_men();
               PanelChat.getAreaTextoChat().setText(textoadd);
         }else if (arg instanceof MensajeJugada){
             //TODO descomponer el mensaje
             /*
             * Puedo obtener...
             *              *
             * Para la ruleta:
             *  - mensaje diciendo que ya no se puede apostar más porque se va a lanzar la bola
             *  - mensaje de actualizacion de saldo, tras el lanzamiento de la bola
             *
             * Para los dados:
             *  - ...
             */
             //Despues de una jugada, debe actualizarse el saldo actual del jugador.
             getJLabelSaldo().setText(Integer.toString(controlador.obtenerSaldo()));
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
        //controlador.inhabilitarChat();
    }

    private void desbloqueoChat(){
        PanelChat.getBotonBloquear().setActionCommand(PanelChat.BLOQUEO);
        PanelChat.getBotonBloquear().setText("Bloquear");
        PanelChat.getAreaTextoChat().setVisible(true);
        PanelChat.getBotonEnviar().setVisible(true);
        PanelChat.getTextfieldFrase().setVisible(true);
        //controlador.habilitarChat();

    }

    class OyenteTerminarApuestas implements ActionListener{

        public void actionPerformed(ActionEvent e) {
                bloquearApuestas();                
        }

    }

    private void bloquearApuestas(){
        //TODO: X hacer bien
        /**
        Apuesta[] apuesta = new Apuesta[5];
        for(int i = 0; i < 5; i++){
            apuesta[i] = new Apuesta(i, tipoAp.NUMERO,proporcionAp.SIMPLE, 10 * i);
        }
        */
        Apuesta[] apuesta = mesa.terminarYdameListaApuestas();
        controlador.realizarApuesta(apuesta,mesa.dameNumApuestas());
        girarRuleta(3);
        getJButtonFinish().addActionListener(oyenteUsuarios);
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

    class OyenteCerrarVentana extends WindowAdapter{

		public void windowClosing(WindowEvent e){
            salir();
		}

	}

    class OyenteSalir implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            salir();
        }

    }

    class OyenteVolver implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            controlador.salirDeMesa();            
            dispose();
            VistaMesas vista = new VistaMesas(controlador);
            vista.setVisible(true);
        }

    }

    class OyenteUsuarios implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String[] jugadores = controlador.obtenerUsuariosEnMesa();
            getJPanelUsuariosTemp1().getlistaUsuarios().setListData(jugadores);
            getJButtonFinish().addActionListener(oyenteApuestas);
        }
    }

    class OyenteApuestas implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            String[] apuestasAnteriores = controlador.obtenerApuestasAnteriores();
            getJPanelCjtoApuestasTemp1().getListaResultados().setListData(apuestasAnteriores);
            getJButtonFinish().addActionListener(terminarApuestas);
        }

    }

    private void salir() {
        if (JOptionPane.showConfirmDialog(this,"¿Desea abandonar el juego?",
                "Cierre del juego",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
				if(controlador.cerrarConexion())
					System.exit(0);
        }
    }

    public JLabel getJLabelSaldo() {
        return jLabelSaldo;
    }

    public void setJLabelSaldo(JLabel jLabelSaldo) {
        this.jLabelSaldo = jLabelSaldo;
    }

    public JLabel getJLabelUsuario() {
        return jLabelUsuario;
    }

    public void setJLabelUsuario(JLabel jLabelUsuario) {
        this.jLabelUsuario = jLabelUsuario;
    }

}
