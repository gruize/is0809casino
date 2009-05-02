package vista;

import modelo.NombreJuegos;
import controlador.ControladorCliente;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

/**
 *
 * @author GabiPC
 */
public class VistaMesas extends javax.swing.JFrame implements Observer{

    // Variables declaration - do not modify
    private JButton jButtonNext;
    private JButton jButtonBack;
    private JButton jButtonRefresh;
    private JButton jButtonSalir;
    private JLayeredPane jLayeredPane1;
    private JScrollPane jSalas;
    private JPanel jContenedor;
    private JLabel jTapete;
    private JLabel jLabel1;
    private JLabel jLabelUser;
    private JLabel jLabel2;
    private JLabel jLabelSaldo;
    private ControladorCliente controlador;
    private NombreJuegos juego;
    private OyenteRefrescar oyenteRefrescar;
    private OyenteSalir oyenteSalir;
    private OyenteEntrada oyenteEntrada;
    private OyenteVolver oyenteVolver;
    private int mesaEntrar;
    // End of variables declaration

    /** Creates new form VistaTemporal */
    public VistaMesas(ControladorCliente control) {
        super("Mesas disponibles");
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
        juego = null;
        mesaEntrar = 0;
    }

    public NombreJuegos getJuego() {
        return juego;
    }

    public void setJuego(NombreJuegos juego) {
        this.juego = juego;
    }

    public int getMesaEntrar() {
        return mesaEntrar;
    }

    public void setMesaEntrar(int mesaEntrar) {
        this.mesaEntrar = mesaEntrar;
    }

    private void agregarOyentes() {
        oyenteRefrescar = new OyenteRefrescar();
        oyenteSalir = new OyenteSalir();
        oyenteEntrada = new OyenteEntrada();
        oyenteVolver = new OyenteVolver();
        jButtonRefresh.addActionListener(oyenteRefrescar);
        jButtonSalir.addActionListener(oyenteSalir);
        jButtonNext.addActionListener(oyenteEntrada);
        jButtonBack.addActionListener(oyenteVolver);
    }

    private void inicializar() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jTapete = new javax.swing.JLabel();
        jButtonNext = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jButtonRefresh = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelUser = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelSaldo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jLayeredPane1.setBackground(new java.awt.Color(0, 0, 0));
        jLayeredPane1.setOpaque(true);

        jTapete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTapete.setIcon(new javax.swing.ImageIcon("./recursos/mesaVaciaPaint.PNG")); // NOI18N
        jTapete.setBounds(0, 50, 1020, 600);
        jLayeredPane1.add(jTapete, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonNext.setBackground(new java.awt.Color(0, 0, 0));
        jButtonNext.setIcon(new javax.swing.ImageIcon("./recursos/3flecha_derecha-cubed1-thumb.gif")); // NOI18N
        jButtonNext.setText("Siguiente");
        jButtonNext.setBorder(null);
        jButtonNext.setBorderPainted(false);
        jButtonNext.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNext.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButtonNext.setBounds(880, 660, 70, 75);
        jButtonNext.setVisible(false);
        jLayeredPane1.add(jButtonNext, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonBack.setBackground(new java.awt.Color(0, 0, 0));
        jButtonBack.setIcon(new javax.swing.ImageIcon("./recursos/3flecha_izquierda-cubeg1-thumb.gif")); // NOI18N
        jButtonBack.setText("Volver atrás");
        jButtonBack.setBorder(null);
        jButtonBack.setBorderPainted(false);
        jButtonBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonBack.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButtonBack.setBounds(90, 660, 70, 75);
        jLayeredPane1.add(jButtonBack, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonRefresh.setBackground(new java.awt.Color(0, 0, 0));
        jButtonRefresh.setIcon(new javax.swing.ImageIcon("./recursos/TgC_boton142.gif")); // NOI18N
        jButtonRefresh.setText("Refrescar");
        jButtonRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRefresh.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButtonRefresh.setBounds(390, 660, 110, 75);
        jLayeredPane1.add(jButtonRefresh, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonSalir.setBackground(new java.awt.Color(0, 0, 0));
        jButtonSalir.setIcon(new javax.swing.ImageIcon("./recursos/TgC_boton142.gif")); // NOI18N
        jButtonSalir.setText("Salir");
        jButtonSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSalir.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButtonSalir.setBounds(520, 660, 110, 75);
        jLayeredPane1.add(jButtonSalir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario: ");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel1.setBounds(540, 20, 80, 20);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabelUser.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jLabelUser.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUser.setBounds(600, 20, 110, 30);
        jLayeredPane1.add(jLabelUser, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Saldo actual: ");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel2.setBounds(720, 20, 90, 20);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabelSaldo.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jLabelSaldo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSaldo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSaldo.setBounds(810, 20, 110, 30);
        jLayeredPane1.add(jLabelSaldo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jContenedor = new JPanel();
        jContenedor.setLayout(new GridLayout(0,3));
        jContenedor.setBackground(Color.BLACK);
        jContenedor.setBounds(80, 100, 860, 480);
        jContenedor.setOpaque(true);
        jSalas = new JScrollPane();
        jSalas.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jSalas.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jSalas.setBounds(80, 100, 860, 480);
        jSalas.getViewport().setView(jContenedor);
        jLayeredPane1.add(jSalas,javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.moveToFront(jSalas);
        jLayeredPane1.moveToFront(jContenedor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();

        rellenarMesas();
    }

    private void rellenarDatos() {
        jLabelUser.setText(controlador.obtenerUsuario());
        jLabelSaldo.setText(Integer.toString(controlador.obtenerSaldo()));
    }

    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void rellenarMesas() {
        //Preguntar al controlador por el numero de salas que hay
        //El controlador manda un mensaje al servidor
        //El servidor le comunica los datos de las salas
        //Se recibe el mensaje y se cambiaria el estado de la vista
        //En el metodo update se trataria el mensaje y se dibujarian las salas
        /**
         * Eliminar todas las salas existentes y visibles
         */
        rellenarDatos();
         jContenedor.removeAll();
        /**
         * Generar todas las nuevas salas.
         */
        //int numeroMesas = controlador.getNumeroMesas();
        int numeroMesas = 16;
        for(int i=1; i <= numeroMesas; i++) {
            JPanel nuevaMesa = new JPanel();
            nuevaMesa.setBackground(Color.BLACK);
            nuevaMesa.setOpaque(true);
            nuevaMesa.setPreferredSize(new Dimension(250,120));
            nuevaMesa.setSize(new Dimension(250,120));
            nuevaMesa.setName("Mesa"+i);
            nuevaMesa.setBorder(null);
            JButton botonNuevaSala = new JButton(new ImageIcon("./recursos/mesas.jpg"));
            botonNuevaSala.setPreferredSize(new Dimension(114,86));
            botonNuevaSala.setName("BotonMesa"+i);
            botonNuevaSala.setActionCommand(Integer.toString(i));
            botonNuevaSala.addActionListener(new OyenteMesas());
            botonNuevaSala.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
            nuevaMesa.add(botonNuevaSala);
            JTextArea textoNuevaMesa = new JTextArea("Usuarios: \n"+//controlador.getNumeroMesas(i)
                    "Los dice el controlador\nApuestaMinima: \nLa dice el controlador");
            textoNuevaMesa.setPreferredSize(new Dimension(114,86));
            nuevaMesa.add(textoNuevaMesa);
            jContenedor.add(nuevaMesa);
        }
        jSalas.getViewport().setView(jContenedor);
    }

    private void modificarEntrada(int mesa){
        setMesaEntrar(mesa);
    }

    class OyenteMesas implements ActionListener {

        public void actionPerformed(ActionEvent e) {            
            jButtonNext.setVisible(true);
            modificarEntrada(Integer.parseInt(e.getActionCommand()));
        }

    }

    class OyenteRefrescar implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            /**
             * Preguntar al controlador por el numero de salas que hay
             * El controlador manda un mensaje al servidor
             * El servidor le comunica los datos de las salas
             * Se recibe el mensaje y se cambiaria el estado de la vista
             */
            rellenarMesas();
        }
    }

    class OyenteSalir implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            salir();
        }

    }

    class OyenteEntrada implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            dispose();
            //Obtener el id de la mesa
            controlador.solicitudEntrarEnMesa(mesaEntrar);
            switch(juego){
                case RULETA: {
                    VistaRuleta vistaJuego = new VistaRuleta(controlador);
                    vistaJuego.setVisible(true);
                }break;
                case DADOS: {
                    VistaDados vistaJuego = new VistaDados(controlador);
                    vistaJuego.setVisible(true);
                }break;
                default: {
                    System.out.println("Fallo Juego en mesa = null");
                }
            }
        }

    }

    class OyenteVolver implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            dispose();            
            VistaSalas vista = new VistaSalas(controlador);
            vista.setVisible(true);
        }

    }

    private void salir() {
        System.out.println("OK");
        if (JOptionPane.showConfirmDialog(this,"¿Desea abandonar el juego?",
                "Cierre del juego",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
				if(controlador.cerrarConexion()){
                    System.exit(0);
                }

    }
}
