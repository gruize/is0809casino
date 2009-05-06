package vista;

import java.awt.event.ItemEvent;
import modelo.NombreJuegos;
import controlador.ControladorCliente;
import java.awt.Choice;
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
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import modelo.mensajes.MensajeInfoSalas;
import modelo.mensajes.objetos.PeticionSala;

/**
 *
 * @author GabiPC
 */
public class VistaSalas extends javax.swing.JFrame implements Observer {

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
    private Choice jJuegos;
    private ControladorCliente controlador;
    private NombreJuegos juego;
    private OyenteRefrescar oyenteRefrescar;
    private OyenteSalir oyenteSalir;
    private OyenteEntrada oyenteEntrada;
    private OyenteVolver oyenteVolver;
    private OyenteSeleccion oyenteSeleccion;
    private int salonEntrar;
    private Vector<PeticionSala> peticionSala;
    private int eleccion;
    // End of variables declaration

    /** Creates new form VistaTemporal */
    public VistaSalas(ControladorCliente control) {
        super("Salas disponibles en el casino");
        controlador = control;
        juego = NombreJuegos.TODOS;
        salonEntrar = 0; //Por defecto
        eleccion = 0; //Por defecto
        inicializar();
        rellenarJuegos();
        agregarOyentes();
        rellenarDatos();
        controlador.getModelo().addObserver(this);
        controlador.pedirNumeroSalas();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                salir();
            }
        });
		setVisible(true);
        setResizable(false);
    }

    public Choice getJJuegos() {
        return jJuegos;
    }

    public void setJJuegos(Choice jJuegos) {
        this.jJuegos = jJuegos;
    }

    public int getSalonEntrar() {
        return salonEntrar;
    }

    public void setSalonEntrar(int salonEntrar) {
        this.salonEntrar = salonEntrar+1;
    }

    public NombreJuegos getJuego() {
        return juego;
    }

    public void setJuego(NombreJuegos juego) {
        this.juego = juego;
    }

    public JLabel getJLabelSaldo() {
        return jLabelSaldo;
    }

    public void setJLabelSaldo(JLabel jLabelSaldo) {
        this.jLabelSaldo = jLabelSaldo;
    }

    public JLabel getJLabelUser() {
        return jLabelUser;
    }

    public void setJLabelUser(JLabel jLabelUser) {
        this.jLabelUser = jLabelUser;
    }

    private void agregarOyentes() {
        oyenteRefrescar = new OyenteRefrescar();
        oyenteSalir = new OyenteSalir();
        oyenteEntrada = new OyenteEntrada();
        oyenteVolver = new OyenteVolver();
        oyenteSeleccion = new OyenteSeleccion();
        jButtonRefresh.addActionListener(oyenteRefrescar);
        jButtonSalir.addActionListener(oyenteSalir);
        jButtonNext.addActionListener(oyenteEntrada);
        jButtonBack.addActionListener(oyenteVolver);
        jJuegos.addItemListener(oyenteSeleccion);
    }

    private void inicializar(){

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
        jJuegos = new java.awt.Choice();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jLayeredPane1.setBackground(new java.awt.Color(0, 0, 0));
        jLayeredPane1.setOpaque(true);

        jJuegos.setBounds(360, 100, 300, 20);
        jLayeredPane1.moveToFront(jJuegos);
        jLayeredPane1.add(jJuegos,javax.swing.JLayeredPane.DEFAULT_LAYER);

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
        jButtonBack.setText("Volver atrÃƒÂ¡s");
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
        jContenedor.setBounds(80, 140, 860, 480);
        jContenedor.setOpaque(true);
        jSalas = new JScrollPane();
        jSalas.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jSalas.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jSalas.setBounds(80, 140, 860, 480);
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
    }

    private void rellenarDatos() {
        jLabelUser.setText(controlador.obtenerUsuario());
        jLabelSaldo.setText(Integer.toString(controlador.obtenerSaldo()));

    }

    private void rellenarJuegos() {
        jJuegos.add("---Elija un juego---");
        jJuegos.add(NombreJuegos.RULETA.toString());
        jJuegos.add(NombreJuegos.DADOS.toString());
    }

    private void rellenarSalas() {
        jContenedor.removeAll();
        System.out.println("eleccion: "+eleccion);
        switch(eleccion){
            case 0: {
                for(int i = 0; i < peticionSala.size(); i++){
                    System.out.println("sala"+ peticionSala.get(i).getJuego());
                    JPanel nuevaSala = new JPanel();
                    nuevaSala.setBackground(Color.BLACK);
                    nuevaSala.setOpaque(true);
                    nuevaSala.setPreferredSize(new Dimension(250,120));
                    nuevaSala.setSize(new Dimension(250,120));
                    nuevaSala.setBorder(null);
                    switch(peticionSala.get(i).getJuego()){
                        case RULETA: {
                            nuevaSala.setName("SalaRuleta"+i);
                            JButton botonNuevaSala = new JButton(new ImageIcon("./recursos/ruletaSala.jpg"));
                            botonNuevaSala.setPreferredSize(new Dimension(114,86));
                            botonNuevaSala.setName("BotonSalaRuleta"+i);
                            botonNuevaSala.setActionCommand("SalaRuleta"+i);
                            botonNuevaSala.addActionListener(new OyenteSalas());
                            botonNuevaSala.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
                            nuevaSala.add(botonNuevaSala);
                            JTextArea textoNuevaSala = new JTextArea("Mesas disponibles\n"+peticionSala.get(i).getNumMesas());
                            textoNuevaSala.setPreferredSize(new Dimension(114,86));
                            nuevaSala.add(textoNuevaSala);
                            jContenedor.add(nuevaSala);
                        }break;
                        case DADOS: {
                            // Crea un icono que referencie a la imagen en disco
                            ImageIcon iconoOriginal = new ImageIcon("./recursos/dadosSala.jpg");
                            // ancho en pixeles que tendra el icono escalado
                            int ancho = 114;
                            // alto (para que conserve la proporcion pasamos -1)
                            int alto = 86;
                            nuevaSala.setName("SalaDados"+i);
                                                                // Obtiene un icono en escala con las dimensiones especificadas
                            JButton botonNuevaSala = new JButton(new ImageIcon(iconoOriginal.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT)));
                            botonNuevaSala.setPreferredSize(new Dimension(114,86));
                            botonNuevaSala.setName("BotonSalaDaddos"+i);
                            botonNuevaSala.setActionCommand("SalaDados"+i);
                            botonNuevaSala.addActionListener(new OyenteSalas());
                            botonNuevaSala.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
                            nuevaSala.add(botonNuevaSala);
                            JTextArea textoNuevaSala = new JTextArea("Mesas disponibles\n"+peticionSala.get(i).getNumMesas());
                            textoNuevaSala.setPreferredSize(new Dimension(114,86));
                            nuevaSala.add(textoNuevaSala);
                            jContenedor.add(nuevaSala);
                        }break;
                    }
                }
                jSalas.getViewport().setView(jContenedor);
            }break;
            case 1: {
                for(int i = 0; i < peticionSala.size(); i++){
                    if(peticionSala.get(i).getJuego().equals(NombreJuegos.RULETA)){
                        JPanel nuevaSala = new JPanel();
                        nuevaSala.setBackground(Color.BLACK);
                        nuevaSala.setOpaque(true);
                        nuevaSala.setPreferredSize(new Dimension(250,120));
                        nuevaSala.setSize(new Dimension(250,120));
                        nuevaSala.setBorder(null);
                        nuevaSala.setName("SalaRuleta"+i);
                        JButton botonNuevaSala = new JButton(new ImageIcon("./recursos/ruletaSala.jpg"));
                        botonNuevaSala.setPreferredSize(new Dimension(114,86));
                        botonNuevaSala.setName("BotonSalaRuleta"+i);
                        botonNuevaSala.setActionCommand("SalaRuleta"+i);
                        botonNuevaSala.addActionListener(new OyenteSalas());
                        botonNuevaSala.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
                        nuevaSala.add(botonNuevaSala);
                        JTextArea textoNuevaSala = new JTextArea("Mesas disponibles\n"+peticionSala.get(i).getNumMesas());
                        textoNuevaSala.setPreferredSize(new Dimension(114,86));
                        nuevaSala.add(textoNuevaSala);
                        jContenedor.add(nuevaSala);
                    }
                }
                jSalas.getViewport().setView(jContenedor);
            }break;
            case 2: {
                for(int i = 0; i < peticionSala.size(); i++){
                    if(peticionSala.get(i).getJuego().equals(NombreJuegos.DADOS)){
                        // Crea un icono que referencie a la imagen en disco
                        ImageIcon icono = new ImageIcon("./recursos/dadosSala.jpg");
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
                        JButton botonNuevaSala = new JButton(new ImageIcon(icono.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT)));
                        botonNuevaSala.setPreferredSize(new Dimension(114,86));
                        botonNuevaSala.setName("BotonSalaDaddos"+i);
                        botonNuevaSala.setActionCommand("SalaDados"+i);
                        botonNuevaSala.addActionListener(new OyenteSalas());
                        botonNuevaSala.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
                        nuevaSala.add(botonNuevaSala);
                        JTextArea textoNuevaSala = new JTextArea("Mesas disponibles\n"+ peticionSala.get(i).getNumMesas());
                        textoNuevaSala.setPreferredSize(new Dimension(114,86));
                        nuevaSala.add(textoNuevaSala);
                        jContenedor.add(nuevaSala);
                }
                }
                jSalas.getViewport().setView(jContenedor);
            }break;
        }
    }

    private void modificarEntrada(NombreJuegos nuevo, int salon){
        setJuego(nuevo);
        setSalonEntrar(salon);
    }

    public void update(Observable o, Object arg) {
        if (arg instanceof MensajeInfoSalas) {
            MensajeInfoSalas mensaje = (MensajeInfoSalas)arg;
            peticionSala = mensaje.getSalas();
            rellenarSalas();
        }
    }

    class OyenteSalas implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            jButtonNext.setVisible(true);
            if(e.getActionCommand().contains("SalaRuleta")){
                modificarEntrada(NombreJuegos.RULETA,Integer.parseInt((e.getActionCommand()).substring(10)));
            }else{
                if(e.getActionCommand().contains("SalaDados")){
                    modificarEntrada(NombreJuegos.DADOS,Integer.parseInt((e.getActionCommand()).substring(9)));
                }
            }
        }

    }

    class OyenteRefrescar implements ActionListener {

        public void actionPerformed(ActionEvent e) {
             controlador.pedirNumeroSalas();
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
           controlador.setSala(salonEntrar);
           VistaMesas vistaMesas = new VistaMesas(controlador);
           vistaMesas.setJuego(juego);
           vistaMesas.setVisible(true);
        }

    }

    class OyenteVolver implements ActionListener {

        public void actionPerformed(ActionEvent e) {
           if(controlador.cerrarConexion()){
                dispose();
                VistaLogin vistalogin =new VistaLogin(controlador);
                vistalogin.setVisible(true);
           }
        }

    }
    class OyenteSeleccion implements ItemListener {

        public void itemStateChanged(ItemEvent e) {
            if(e.getSource() == jJuegos)
                switch(jJuegos.getSelectedIndex()){
                    case 0: setJuego(NombreJuegos.TODOS);
                            eleccion = 0;
                    break;
                    case 1: setJuego(NombreJuegos.RULETA);
                            eleccion = 1;
                    break;
                    case 2: setJuego(NombreJuegos.DADOS);
                            eleccion = 2;
                    break;
                }
            controlador.pedirNumeroSalas();
        }

    }

    private void salir() {
        if (JOptionPane.showConfirmDialog(this,"¿Desea abandonar el juego?",
                "Cierre del juego",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
				if(controlador.cerrarConexion()){
                    System.exit(0);
                }


    }

}