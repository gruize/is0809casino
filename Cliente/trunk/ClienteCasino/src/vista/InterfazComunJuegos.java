/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.ControladorCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author gabi
 */
public class InterfazComunJuegos extends javax.swing.JFrame implements Observer{

    // Variables declaration - do not modify
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelSaldo;
    private javax.swing.JLabel jLabelTiempo;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JList jListaUsuarios;
    private vista.JPanelChat jPanelChat1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jTapete;
    // End of variables declaration

    // Otras variables
    private ControladorCliente controlador;
    private OyenteVolver oyenteVolver;
    private OyenteSalir oyenteSalir;
    // End of otras variables

    public InterfazComunJuegos(ControladorCliente control) {
        super("Casino Online Juego");
        controlador = control;
        inicializar();
        agregarOyentes();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                salir();
            }
        });
        setVisible(true);
        setResizable(false);      
    }

    private void agregarOyentes() {
        oyenteVolver = new OyenteVolver();
        oyenteSalir = new OyenteSalir();
        jButtonBack.addActionListener(oyenteVolver);
        jButtonSalir.addActionListener(oyenteSalir);
    }
    
    private void inicializar() {

    jLayeredPane1 = new javax.swing.JLayeredPane();
        jTapete = new javax.swing.JLabel();
        jButtonSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListaUsuarios = new javax.swing.JList();
        jButtonBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanelChat1 = new vista.JPanelChat();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelTiempo = new javax.swing.JLabel();
        jLabelUser = new javax.swing.JLabel();
        jLabelSaldo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jLayeredPane1.setBackground(new java.awt.Color(0, 0, 0));
        jLayeredPane1.setOpaque(true);

        jTapete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTapete.setIcon(new javax.swing.ImageIcon("C:\\Documents and Settings\\GabiPC\\Escritorio\\II\\Practica IS\\Repositorio\\Cliente\\trunk\\ClienteCasino\\recursos\\mesaVaciaPaintJuegos.PNG")); // NOI18N
        jTapete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jTapete.setBounds(30, 50, 970, 460);
        jLayeredPane1.add(jTapete, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonSalir.setBackground(new java.awt.Color(0, 0, 0));
        jButtonSalir.setIcon(new javax.swing.ImageIcon("C:\\Documents and Settings\\GabiPC\\Escritorio\\II\\Practica IS\\Repositorio\\Cliente\\trunk\\ClienteCasino\\recursos\\TgC_boton142.gif")); // NOI18N
        jButtonSalir.setText("Salir");
        jButtonSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSalir.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButtonSalir.setBounds(910, 520, 90, 80);
        jLayeredPane1.add(jButtonSalir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jListaUsuarios.setBackground(new java.awt.Color(0, 0, 0));
        jListaUsuarios.setFont(new java.awt.Font("Tahoma", 1, 11));
        jListaUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        jListaUsuarios.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10", "Item 11", "Item 12", "Item 13", "Item 14" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListaUsuarios);

        jScrollPane1.setBounds(650, 540, 150, 160);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonBack.setBackground(new java.awt.Color(0, 0, 0));
        jButtonBack.setIcon(new javax.swing.ImageIcon("C:\\Documents and Settings\\GabiPC\\Escritorio\\II\\Practica IS\\Repositorio\\Cliente\\trunk\\ClienteCasino\\recursos\\3flecha_izquierda-cubeg1-thumb.gif")); // NOI18N
        jButtonBack.setText("VolverAtras");
        jButtonBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonBack.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButtonBack.setBounds(30, 520, 89, 80);
        jLayeredPane1.add(jButtonBack, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Usuarios:");
        jLabel1.setBounds(650, 520, 150, 19);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanelChat1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.darkGray, java.awt.Color.darkGray, new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
        jPanelChat1.setBounds(200, 520, 361, 183);
        jLayeredPane1.add(jPanelChat1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tiempo restante:");
        jLabel2.setBounds(760, 20, 120, 14);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuario:");
        jLabel3.setBounds(40, 20, 70, 19);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Saldo actual: ");
        jLabel4.setBounds(370, 20, 100, 14);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabelTiempo.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabelTiempo.setForeground(new java.awt.Color(255, 0, 0));
        jLabelTiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTiempo.setText("Segundos");
        jLabelTiempo.setBounds(880, 10, 100, 30);
        jLayeredPane1.add(jLabelTiempo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabelUser.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabelUser.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUser.setText("Usuario");
        jLabelUser.setBounds(100, 10, 150, 30);
        jLayeredPane1.add(jLabelUser, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabelSaldo.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabelSaldo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSaldo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSaldo.setText("1000 Leuros");
        jLabelSaldo.setBounds(470, 10, 150, 30);
        jLayeredPane1.add(jLabelSaldo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        
    }
    
    private void salir() {
        System.out.println("OK");
        if (JOptionPane.showConfirmDialog(this,"¿Desea abandonar el juego?",
                "Cierre del juego",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
				if(controlador.cerrarConexion()){
                    System.exit(0);
                }
    }    
    
    class OyenteVolver implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            dispose();            
            controlador.solicitudEntrarEnMesa(controlador.getModelo().getMesa());
            VistaMesas vista = new VistaMesas(controlador);
            vista.setVisible(true);
        }

    }
    
    class OyenteSalir implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            salir();
        }

    }
    
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
