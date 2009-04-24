package vista;

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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

/**
 *
 * @author GabiPC
 */
public class VistaSalas extends javax.swing.JFrame implements Observer{

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
    private Juegos juego;
    private OyenteRefrescar oyenteRefrescar;
    private OyenteSalir oyenteSalir;
    private OyenteEntrada oyenteEntrada;
    // End of variables declaration

    /** Creates new form VistaTemporal */
    public VistaSalas(ControladorCliente control) {
        super("Salas disponibles en el casino");
        controlador = control;
        inicializar();
        agregarOyentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
        setResizable(false);
        juego = null;
    }

    public Juegos getJuego() {
        return juego;
    }

    public void setJuego(Juegos juego) {
        this.juego = juego;
    }

    private void agregarOyentes() {
        oyenteRefrescar = new OyenteRefrescar();
        oyenteSalir = new OyenteSalir();
        oyenteEntrada = new OyenteEntrada();
        jButtonRefresh.addActionListener(oyenteRefrescar);
        jButtonSalir.addActionListener(oyenteSalir);
        jButtonNext.addActionListener(oyenteEntrada);
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
        jLabel1.setBounds(540, 20, 50, 20);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabelUser.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jLabelUser.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUser.setText("jLabel2");
        jLabelUser.setBounds(600, 10, 110, 30);
        jLayeredPane1.add(jLabelUser, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Saldo actual: ");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel2.setBounds(760, 20, 70, 20);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabelSaldo.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jLabelSaldo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSaldo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSaldo.setText("jLabel2");
        jLabelSaldo.setBounds(840, 10, 110, 30);
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

        rellenarSalas();
    }

    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void rellenarSalas() {
        //Preguntar al controlador por el numero de salas que hay
        //El controlador manda un mensaje al servidor
        //El servidor le comunica los datos de las salas
        //Se recibe el mensaje y se cambiaria el estado de la vista
        //En el metodo update se trataria el mensaje y se dibujarian las salas
        /**
         * Eliminar todas las salas existentes y visibles
         */
         jContenedor.removeAll();
        /**
         * Generar todas las nuevas salas.
         */
        //int numeroSalasRuleta = controlador.getNumeroSalasRuleta();
        //int numeroSalasDados = controlador.getNumeroSalasDados();
        int numeroSalasRuleta = 16;
        int numeroSalasDados = 1;
        for(int i=0; i < numeroSalasRuleta; i++) {
            JPanel nuevaSala = new JPanel();
            nuevaSala.setBackground(Color.BLACK);
            nuevaSala.setOpaque(true);
            nuevaSala.setPreferredSize(new Dimension(250,120));
            nuevaSala.setSize(new Dimension(250,120));
            nuevaSala.setName("SalaRuleta"+i);
            nuevaSala.setBorder(null);
            JButton botonNuevaSala = new JButton(new ImageIcon("./recursos/ruletaSala.jpg"));
            botonNuevaSala.setPreferredSize(new Dimension(114,86));
            botonNuevaSala.setName("BotonSalaRuleta"+i);
            botonNuevaSala.setActionCommand("SalaRuleta"+i);
            botonNuevaSala.addActionListener(new OyenteSalas());
            botonNuevaSala.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
            nuevaSala.add(botonNuevaSala);
            JTextArea textoNuevaSala = new JTextArea("Mesas disponibles\n"+controlador.getNumeroMesas(i));
            textoNuevaSala.setPreferredSize(new Dimension(114,86));
            nuevaSala.add(textoNuevaSala);
            jContenedor.add(nuevaSala);
        }
        for(int i=0; i < numeroSalasDados; i++) {
            // Crea un icono que referencie a la imagen en disco
            ImageIcon iconoOriginal = new ImageIcon("./recursos/dadosSala.jpg");
            // ancho en pixeles que tendra el icono escalado
            int ancho = 114;
            // alto (para que conserve la proporcion pasamos -1)
            int alto = 86;
            JPanel nuevaSala = new JPanel();
            nuevaSala.setBackground(Color.BLACK);
            nuevaSala.setOpaque(true);
            nuevaSala.setPreferredSize(new Dimension(250,120));
            nuevaSala.setSize(new Dimension(250,120));
            nuevaSala.setName("SalaDados"+i);
            nuevaSala.setBorder(null);                                                             // Obtiene un icono en escala con las dimensiones especificadas
            JButton botonNuevaSala = new JButton(new ImageIcon(iconoOriginal.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT)));
            botonNuevaSala.setPreferredSize(new Dimension(114,86));
            botonNuevaSala.setName("BotonSalaDaddos"+i);
            botonNuevaSala.setActionCommand("SalaDados"+i);
            botonNuevaSala.addActionListener(new OyenteSalas());
            botonNuevaSala.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
            nuevaSala.add(botonNuevaSala);
            JTextArea textoNuevaSala = new JTextArea("Mesas disponibles\n"+controlador.getNumeroMesas(i));
            textoNuevaSala.setPreferredSize(new Dimension(114,86));
            nuevaSala.add(textoNuevaSala);
            jContenedor.add(nuevaSala);
        }

    }

    class OyenteSalas implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            jButtonNext.setVisible(true);
            if(e.getActionCommand().contains("SalaRuleta")){
                juego = Juegos.RULETA;
            }else{
                if(e.getActionCommand().contains("SalaDados")){
                    juego = Juegos.DADOS;
                }else{
                    juego = null;
                }
            }
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
            rellenarSalas();
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
           VistaMesas vistaMesas = new VistaMesas(controlador);
           vistaMesas.setJuego(juego);
           vistaMesas.setVisible(true);
        }

    }
    private void salir() {
        if (JOptionPane.showConfirmDialog(this,"¿Desea abandonar el juego?",
                "Cierre del juego",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
            //try {
				if(controlador.desconectar()){
					//controlador.desconectarCliente();
                    System.exit(0);
                }/**
			}
            catch (IOException e1) {
                e1.printStackTrace();
			}*/


    }
}