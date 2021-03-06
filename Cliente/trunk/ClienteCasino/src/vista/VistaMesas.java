package vista;

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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import modelo.mensajes.MensajeExpulsion;
import modelo.mensajes.MensajeInfoMesas;
import modelo.mensajes.objetos.PeticionMesa;
import modelo.mensajes.objetos.PeticionSala;

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
    private Choice jOrden;
    private ControladorCliente controlador;
    private NombreJuegos juego;
    private OyenteRefrescar oyenteRefrescar;
    private OyenteSalir oyenteSalir;
    private OyenteEntrada oyenteEntrada;
    private OyenteVolver oyenteVolver;
    private OyenteSeleccion oyenteSeleccion;
    private int mesaEntrar;
    private int orden;
    private Vector<PeticionMesa> peticionMesa;
    // End of variables declaration

    /** Creates new form VistaTemporal */
    public VistaMesas(ControladorCliente control) {
        super("Mesas disponibles");
        controlador = control;
        inicializar();
        juego = null;
        mesaEntrar = 0;
        peticionMesa = new Vector<PeticionMesa>();
        rellenarOrdenes();
        agregarOyentes();
        rellenarDatos();
        controlador.getModelo().addObserver(this);
        controlador.pedirNumeroMesas();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                salir();
            }
        });
        setVisible(true);
        setResizable(false);

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

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
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
        jOrden.addItemListener(oyenteSeleccion);
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
        jOrden = new java.awt.Choice();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jLayeredPane1.setBackground(new java.awt.Color(0, 0, 0));
        jLayeredPane1.setOpaque(true);

        jOrden.setBounds(360, 100, 300, 20);
        jLayeredPane1.moveToFront(jOrden);
        jLayeredPane1.add(jOrden,javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTapete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTapete.setIcon(new ImageIcon(getClass().getResource("/recursos/mesaVaciaPaint.PNG"))); // NOI18N
        jTapete.setBounds(0, 50, 1020, 600);
        jLayeredPane1.add(jTapete, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonNext.setBackground(new java.awt.Color(0, 0, 0));
        jButtonNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/3flecha_derecha-cubed1-thumb.gif"))); // NOI18N
        jButtonNext.setText("Siguiente");
        jButtonNext.setBorder(null);
        jButtonNext.setBorderPainted(false);
        jButtonNext.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNext.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButtonNext.setBounds(880, 660, 70, 75);
        jButtonNext.setVisible(false);
        jLayeredPane1.add(jButtonNext, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonBack.setBackground(new java.awt.Color(0, 0, 0));
        jButtonBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/3flecha_izquierda-cubeg1-thumb.gif"))); // NOI18N
        jButtonBack.setText("Volver atrÃ¡s");
        jButtonBack.setBorder(null);
        jButtonBack.setBorderPainted(false);
        jButtonBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonBack.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButtonBack.setBounds(90, 660, 70, 75);
        jLayeredPane1.add(jButtonBack, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonRefresh.setBackground(new java.awt.Color(0, 0, 0));
        jButtonRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/TgC_boton142.gif"))); // NOI18N
        jButtonRefresh.setText("Refrescar");
        jButtonRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRefresh.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButtonRefresh.setBounds(390, 660, 110, 75);
        jLayeredPane1.add(jButtonRefresh, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonSalir.setBackground(new java.awt.Color(0, 0, 0));
        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/TgC_boton142.gif"))); // NOI18N
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

    private void rellenarOrdenes() {
        //orden = 0;
        jOrden.add("---Elija un orden---");
        //orden = 1;
        jOrden.add("Nº de jugadores.Decreciente");
        //orden = 2;
        jOrden.add("Nº de jugadores.Creciente");
        //orden = 3;
        jOrden.add("Apuesta minima.Decreciente");
        //orden = 4;
        jOrden.add("Apuesta minima.Creciente");
    }

    private void rellenarDatos() {
        jLabelUser.setText(controlador.obtenerUsuario());
        jLabelSaldo.setText(Double.toString(controlador.obtenerSaldo()));
    }

    public void update(Observable o, Object arg) {
        if (arg instanceof MensajeInfoMesas) {
            MensajeInfoMesas mensaje = (MensajeInfoMesas)arg;
            peticionMesa = mensaje.getMesas();
            rellenarMesas();
        } else if (arg instanceof MensajeExpulsion) {
             JOptionPane.showMessageDialog(null,"¡¡ESTAS EXPULSADO!!","Expulsion de usuario",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    private void rellenarMesas() {
         jContenedor.removeAll();

        switch(orden){
            //Ningun orden
            case 0: {
                for (int i = 0; i < peticionMesa.size(); i++){
                    JPanel nuevaMesa = new JPanel();
                    nuevaMesa.setBackground(Color.BLACK);
                    nuevaMesa.setOpaque(true);
                    nuevaMesa.setPreferredSize(new Dimension(250,120));
                    nuevaMesa.setSize(new Dimension(250,120));
                    nuevaMesa.setName("Mesa"+i);
                    nuevaMesa.setBorder(null);
                    JButton botonNuevaSala = new JButton(new ImageIcon(getClass().getResource("/recursos/mesas.jpg")));
                    botonNuevaSala.setPreferredSize(new Dimension(114,86));
                    botonNuevaSala.setName("BotonMesa"+i);
                    botonNuevaSala.setActionCommand(Integer.toString(peticionMesa.get(i).getIdMesa()));
                    botonNuevaSala.addActionListener(new OyenteMesas());
                    botonNuevaSala.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
                    nuevaMesa.add(botonNuevaSala);
                    JTextArea textoNuevaMesa = new JTextArea("Usuarios: \n"+peticionMesa.get(i).getNumJugadores()+"\nApuestaMinima: \n"+peticionMesa.get(i).getApuestaMin());
                    textoNuevaMesa.setPreferredSize(new Dimension(114,86));
                    nuevaMesa.add(textoNuevaMesa);
                    jContenedor.add(nuevaMesa);
                }
            }break;
            //Nº Jugadores. Creciente
            case 1: {
                Vector<PeticionMesa> auxpeticionMesa = new Vector<PeticionMesa>(peticionMesa);
                while(!auxpeticionMesa.isEmpty()){
                    int index = 0;
                    PeticionMesa tmp = auxpeticionMesa.get(index);
                    for(int i = 1; i < auxpeticionMesa.size(); i++){
                        if(tmp.getNumJugadores() < auxpeticionMesa.get(i).getNumJugadores()){
                            index = i;
                            tmp = auxpeticionMesa.get(index);
                        }
                    }
                    JPanel nuevaMesa = new JPanel();
                    nuevaMesa.setBackground(Color.BLACK);
                    nuevaMesa.setOpaque(true);
                    nuevaMesa.setPreferredSize(new Dimension(250,120));
                    nuevaMesa.setSize(new Dimension(250,120));
                    nuevaMesa.setName("Mesa"+tmp.getIdMesa());
                    nuevaMesa.setBorder(null);
                    JButton botonNuevaSala = new JButton(new ImageIcon(getClass().getResource("/recursos/mesas.jpg")));
                    botonNuevaSala.setPreferredSize(new Dimension(114,86));
                    botonNuevaSala.setName("BotonMesa"+index);
                    botonNuevaSala.setActionCommand(Integer.toString(auxpeticionMesa.get(index).getIdMesa()));
                    botonNuevaSala.addActionListener(new OyenteMesas());
                    botonNuevaSala.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
                    nuevaMesa.add(botonNuevaSala);
                    JTextArea textoNuevaMesa = new JTextArea("Usuarios: \n"+tmp.getNumJugadores()+"\nApuestaMinima: \n"+tmp.getApuestaMin());
                    textoNuevaMesa.setPreferredSize(new Dimension(114,86));
                    nuevaMesa.add(textoNuevaMesa);
                    jContenedor.add(nuevaMesa);
                    auxpeticionMesa.remove(tmp);
                }
            }break;
            //Nº Jugadores. Decreciente
            case 2: {
                Vector<PeticionMesa> auxpeticionMesa = new Vector<PeticionMesa>(peticionMesa);
                while(!auxpeticionMesa.isEmpty()){
                    int index = 0;
                    PeticionMesa tmp = auxpeticionMesa.get(index);
                    for(int i = 1; i < auxpeticionMesa.size(); i++){
                        if(tmp.getNumJugadores() > auxpeticionMesa.get(i).getNumJugadores()){
                            index = i;
                            tmp = auxpeticionMesa.get(index);
                        }
                    }
                    JPanel nuevaMesa = new JPanel();
                    nuevaMesa.setBackground(Color.BLACK);
                    nuevaMesa.setOpaque(true);
                    nuevaMesa.setPreferredSize(new Dimension(250,120));
                    nuevaMesa.setSize(new Dimension(250,120));
                    nuevaMesa.setName("Mesa"+tmp.getIdMesa());
                    nuevaMesa.setBorder(null);
                    JButton botonNuevaSala = new JButton(new ImageIcon(getClass().getResource("/recursos/mesas.jpg")));
                    botonNuevaSala.setPreferredSize(new Dimension(114,86));
                    botonNuevaSala.setName("BotonMesa"+index);
                    botonNuevaSala.setActionCommand(Integer.toString(auxpeticionMesa.get(index).getIdMesa()));
                    botonNuevaSala.addActionListener(new OyenteMesas());
                    botonNuevaSala.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
                    nuevaMesa.add(botonNuevaSala);
                    JTextArea textoNuevaMesa = new JTextArea("Usuarios: \n"+tmp.getNumJugadores()+"\nApuestaMinima: \n"+tmp.getApuestaMin());
                    textoNuevaMesa.setPreferredSize(new Dimension(114,86));
                    nuevaMesa.add(textoNuevaMesa);
                    jContenedor.add(nuevaMesa);
                    auxpeticionMesa.remove(tmp);
                }
            }break;
            //Apuesta minima. Creciente
            case 3: {
                Vector<PeticionMesa> auxpeticionMesa = new Vector<PeticionMesa>(peticionMesa);
                while(!auxpeticionMesa.isEmpty()){
                    int index = 0;
                    PeticionMesa tmp = auxpeticionMesa.get(index);
                    for(int i = 1; i < auxpeticionMesa.size(); i++){
                        if(tmp.getApuestaMin() > auxpeticionMesa.get(i).getApuestaMin()){
                            index = i;
                            tmp = auxpeticionMesa.get(index);
                        }
                    }
                    JPanel nuevaMesa = new JPanel();
                    nuevaMesa.setBackground(Color.BLACK);
                    nuevaMesa.setOpaque(true);
                    nuevaMesa.setPreferredSize(new Dimension(250,120));
                    nuevaMesa.setSize(new Dimension(250,120));
                    nuevaMesa.setName("Mesa"+tmp.getIdMesa());
                    nuevaMesa.setBorder(null);
                    JButton botonNuevaSala = new JButton(new ImageIcon(getClass().getResource("/recursos/mesas.jpg")));
                    botonNuevaSala.setPreferredSize(new Dimension(114,86));
                    botonNuevaSala.setName("BotonMesa"+index);
                    botonNuevaSala.setActionCommand(Integer.toString(auxpeticionMesa.get(index).getIdMesa()));
                    botonNuevaSala.addActionListener(new OyenteMesas());
                    botonNuevaSala.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
                    nuevaMesa.add(botonNuevaSala);
                    JTextArea textoNuevaMesa = new JTextArea("Usuarios: \n"+tmp.getNumJugadores()+"\nApuestaMinima: \n"+tmp.getApuestaMin());
                    textoNuevaMesa.setPreferredSize(new Dimension(114,86));
                    nuevaMesa.add(textoNuevaMesa);
                    jContenedor.add(nuevaMesa);
                    auxpeticionMesa.remove(tmp);
                }
            }break;
            //Apuesta minima. Decreciente
            case 4: {
                Vector<PeticionMesa> auxpeticionMesa = new Vector<PeticionMesa>(peticionMesa);
                while(!auxpeticionMesa.isEmpty()){
                    int index = 0;
                    PeticionMesa tmp = auxpeticionMesa.get(index);
                    for(int i = 1; i < auxpeticionMesa.size(); i++){
                        if(tmp.getApuestaMin() < auxpeticionMesa.get(i).getApuestaMin()){
                            index = i;
                            tmp = auxpeticionMesa.get(index);
                        }
                    }
                    JPanel nuevaMesa = new JPanel();
                    nuevaMesa.setBackground(Color.BLACK);
                    nuevaMesa.setOpaque(true);
                    nuevaMesa.setPreferredSize(new Dimension(250,120));
                    nuevaMesa.setSize(new Dimension(250,120));
                    nuevaMesa.setName("Mesa"+tmp.getIdMesa());
                    nuevaMesa.setBorder(null);
                    JButton botonNuevaSala = new JButton(new ImageIcon(getClass().getResource("/recursos/mesas.jpg")));
                    botonNuevaSala.setPreferredSize(new Dimension(114,86));
                    botonNuevaSala.setName("BotonMesa"+index);
                    botonNuevaSala.setActionCommand(Integer.toString(auxpeticionMesa.get(index).getIdMesa()));
                    botonNuevaSala.addActionListener(new OyenteMesas());
                    botonNuevaSala.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
                    nuevaMesa.add(botonNuevaSala);
                    JTextArea textoNuevaMesa = new JTextArea("Usuarios: \n"+tmp.getNumJugadores()+"\nApuestaMinima: \n"+tmp.getApuestaMin());
                    textoNuevaMesa.setPreferredSize(new Dimension(114,86));
                    nuevaMesa.add(textoNuevaMesa);
                    jContenedor.add(nuevaMesa);
                    auxpeticionMesa.remove(tmp);
                }
            }break;
        }
        jSalas.getViewport().setView(jContenedor);
    }

    private void rellenarMesasColoreado(int mesa) {
         jContenedor.removeAll();
        switch(orden){
            //Ningun orden
            case 0: {
                for (int i = 0; i < peticionMesa.size(); i++){
                    JPanel nuevaMesa = new JPanel();
                    if(peticionMesa.get(i).getIdMesa() == mesa)
                        nuevaMesa.setBackground(new Color(128,128,128));
                    else
                        nuevaMesa.setBackground(Color.BLACK);
                    nuevaMesa.setOpaque(true);
                    nuevaMesa.setPreferredSize(new Dimension(250,120));
                    nuevaMesa.setSize(new Dimension(250,120));
                    nuevaMesa.setName("Mesa"+i);
                    nuevaMesa.setBorder(null);
                    JButton botonNuevaSala = new JButton(new ImageIcon(getClass().getResource("/recursos/mesas.jpg")));
                    botonNuevaSala.setPreferredSize(new Dimension(114,86));
                    botonNuevaSala.setName("BotonMesa"+i);
                    botonNuevaSala.setActionCommand(Integer.toString(peticionMesa.get(i).getIdMesa()));
                    botonNuevaSala.addActionListener(new OyenteMesas());
                    botonNuevaSala.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
                    nuevaMesa.add(botonNuevaSala);
                    JTextArea textoNuevaMesa = new JTextArea("Usuarios: \n"+peticionMesa.get(i).getNumJugadores()+"\nApuestaMinima: \n"+peticionMesa.get(i).getApuestaMin());
                    textoNuevaMesa.setPreferredSize(new Dimension(114,86));
                    nuevaMesa.add(textoNuevaMesa);
                    jContenedor.add(nuevaMesa);
                }
            }break;
            //Nº Jugadores. Creciente
            case 1: {
                Vector<PeticionMesa> auxpeticionMesa = new Vector<PeticionMesa>(peticionMesa);
                while(!auxpeticionMesa.isEmpty()){
                    int index = 0;
                    PeticionMesa tmp = auxpeticionMesa.get(index);
                    for(int i = 1; i < auxpeticionMesa.size(); i++){
                        if(tmp.getNumJugadores() < auxpeticionMesa.get(i).getNumJugadores()){
                            index = i;
                            tmp = auxpeticionMesa.get(index);
                        }
                    }
                    JPanel nuevaMesa = new JPanel();
                    if(tmp.getIdMesa() == mesa)
                        nuevaMesa.setBackground(new Color(128,128,128));
                    else
                        nuevaMesa.setBackground(Color.BLACK);
                    nuevaMesa.setOpaque(true);
                    nuevaMesa.setPreferredSize(new Dimension(250,120));
                    nuevaMesa.setSize(new Dimension(250,120));
                    nuevaMesa.setName("Mesa"+tmp.getIdMesa());
                    nuevaMesa.setBorder(null);
                    JButton botonNuevaSala = new JButton(new ImageIcon(getClass().getResource("/recursos/mesas.jpg")));
                    botonNuevaSala.setPreferredSize(new Dimension(114,86));
                    botonNuevaSala.setName("BotonMesa"+index);
                    botonNuevaSala.setActionCommand(Integer.toString(auxpeticionMesa.get(index).getIdMesa()));
                    botonNuevaSala.addActionListener(new OyenteMesas());
                    botonNuevaSala.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
                    nuevaMesa.add(botonNuevaSala);
                    JTextArea textoNuevaMesa = new JTextArea("Usuarios: \n"+tmp.getNumJugadores()+"\nApuestaMinima: \n"+tmp.getApuestaMin());
                    textoNuevaMesa.setPreferredSize(new Dimension(114,86));
                    nuevaMesa.add(textoNuevaMesa);
                    jContenedor.add(nuevaMesa);
                    auxpeticionMesa.remove(tmp);
                }
            }break;
            //Nº Jugadores. Decreciente
            case 2: {
                Vector<PeticionMesa> auxpeticionMesa = new Vector<PeticionMesa>(peticionMesa);
                while(!auxpeticionMesa.isEmpty()){
                    int index = 0;
                    PeticionMesa tmp = auxpeticionMesa.get(index);
                    for(int i = 1; i < auxpeticionMesa.size(); i++){
                        if(tmp.getNumJugadores() > auxpeticionMesa.get(i).getNumJugadores()){
                            index = i;
                            tmp = auxpeticionMesa.get(index);
                        }
                    }
                    JPanel nuevaMesa = new JPanel();
                    if(tmp.getIdMesa() == mesa)
                        nuevaMesa.setBackground(new Color(128,128,128));
                    else
                        nuevaMesa.setBackground(Color.BLACK);
                    nuevaMesa.setOpaque(true);
                    nuevaMesa.setPreferredSize(new Dimension(250,120));
                    nuevaMesa.setSize(new Dimension(250,120));
                    nuevaMesa.setName("Mesa"+tmp.getIdMesa());
                    nuevaMesa.setBorder(null);
                    JButton botonNuevaSala = new JButton(new ImageIcon(getClass().getResource("/recursos/mesas.jpg")));
                    botonNuevaSala.setPreferredSize(new Dimension(114,86));
                    botonNuevaSala.setName("BotonMesa"+index);
                    botonNuevaSala.setActionCommand(Integer.toString(auxpeticionMesa.get(index).getIdMesa()));
                    botonNuevaSala.addActionListener(new OyenteMesas());
                    botonNuevaSala.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
                    nuevaMesa.add(botonNuevaSala);
                    JTextArea textoNuevaMesa = new JTextArea("Usuarios: \n"+tmp.getNumJugadores()+"\nApuestaMinima: \n"+tmp.getApuestaMin());
                    textoNuevaMesa.setPreferredSize(new Dimension(114,86));
                    nuevaMesa.add(textoNuevaMesa);
                    jContenedor.add(nuevaMesa);
                    auxpeticionMesa.remove(tmp);
                }
            }break;
            //Apuesta minima. Creciente
            case 3: {
                Vector<PeticionMesa> auxpeticionMesa = new Vector<PeticionMesa>(peticionMesa);
                while(!auxpeticionMesa.isEmpty()){
                    int index = 0;
                    PeticionMesa tmp = auxpeticionMesa.get(index);
                    for(int i = 1; i < auxpeticionMesa.size(); i++){
                        if(tmp.getApuestaMin() > auxpeticionMesa.get(i).getApuestaMin()){
                            index = i;
                            tmp = auxpeticionMesa.get(index);
                        }
                    }
                    JPanel nuevaMesa = new JPanel();
                    if(tmp.getIdMesa() == mesa)
                        nuevaMesa.setBackground(new Color(128,128,128));
                    else
                        nuevaMesa.setBackground(Color.BLACK);
                    nuevaMesa.setOpaque(true);
                    nuevaMesa.setPreferredSize(new Dimension(250,120));
                    nuevaMesa.setSize(new Dimension(250,120));
                    nuevaMesa.setName("Mesa"+tmp.getIdMesa());
                    nuevaMesa.setBorder(null);
                    JButton botonNuevaSala = new JButton(new ImageIcon(getClass().getResource("/recursos/mesas.jpg")));
                    botonNuevaSala.setPreferredSize(new Dimension(114,86));
                    botonNuevaSala.setName("BotonMesa"+index);
                    botonNuevaSala.setActionCommand(Integer.toString(auxpeticionMesa.get(index).getIdMesa()));
                    botonNuevaSala.addActionListener(new OyenteMesas());
                    botonNuevaSala.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
                    nuevaMesa.add(botonNuevaSala);
                    JTextArea textoNuevaMesa = new JTextArea("Usuarios: \n"+tmp.getNumJugadores()+"\nApuestaMinima: \n"+tmp.getApuestaMin());
                    textoNuevaMesa.setPreferredSize(new Dimension(114,86));
                    nuevaMesa.add(textoNuevaMesa);
                    jContenedor.add(nuevaMesa);
                    auxpeticionMesa.remove(tmp);
                }
            }break;
            //Apuesta minima. Decreciente
            case 4: {
                Vector<PeticionMesa> auxpeticionMesa = new Vector<PeticionMesa>(peticionMesa);
                while(!auxpeticionMesa.isEmpty()){
                    int index = 0;
                    PeticionMesa tmp = auxpeticionMesa.get(index);
                    for(int i = 1; i < auxpeticionMesa.size(); i++){
                        if(tmp.getApuestaMin() < auxpeticionMesa.get(i).getApuestaMin()){
                            index = i;
                            tmp = auxpeticionMesa.get(index);
                        }
                    }
                    JPanel nuevaMesa = new JPanel();
                    if(tmp.getIdMesa() == mesa)
                        nuevaMesa.setBackground(new Color(128,128,128));
                    else
                        nuevaMesa.setBackground(Color.BLACK);
                    nuevaMesa.setOpaque(true);
                    nuevaMesa.setPreferredSize(new Dimension(250,120));
                    nuevaMesa.setSize(new Dimension(250,120));
                    nuevaMesa.setName("Mesa"+tmp.getIdMesa());
                    nuevaMesa.setBorder(null);
                    JButton botonNuevaSala = new JButton(new ImageIcon(getClass().getResource("/recursos/mesas.jpg")));
                    botonNuevaSala.setPreferredSize(new Dimension(114,86));
                    botonNuevaSala.setName("BotonMesa"+index);
                    botonNuevaSala.setActionCommand(Integer.toString(auxpeticionMesa.get(index).getIdMesa()));
                    botonNuevaSala.addActionListener(new OyenteMesas());
                    botonNuevaSala.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
                    nuevaMesa.add(botonNuevaSala);
                    JTextArea textoNuevaMesa = new JTextArea("Usuarios: \n"+tmp.getNumJugadores()+"\nApuestaMinima: \n"+tmp.getApuestaMin());
                    textoNuevaMesa.setPreferredSize(new Dimension(114,86));
                    nuevaMesa.add(textoNuevaMesa);
                    jContenedor.add(nuevaMesa);
                    auxpeticionMesa.remove(tmp);
                }
            }break;
        }
        jSalas.getViewport().setView(jContenedor);
    }
    
    private void modificarEntrada(int mesa){
        setMesaEntrar(mesa);
        rellenarMesasColoreado(mesa);
    }

    class OyenteMesas implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            jButtonNext.setVisible(true);
            modificarEntrada(Integer.parseInt(e.getActionCommand()));
        }
    }

    class OyenteRefrescar implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            controlador.pedirNumeroMesas();
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
            controlador.setMesa(mesaEntrar);
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

    class OyenteSeleccion implements ItemListener {

        public void itemStateChanged(ItemEvent e) {
            if(e.getSource() == jOrden)
                switch(jOrden.getSelectedIndex()){
                    //Ninguno
                    case 0:{
                        setOrden(0);
                        
                    }break;
                    //NÂº de jugadores.Creciente
                    case 1:{
                        setOrden(1);
                    }break;
                    //NÂº de jugadores.Decreciente
                    case 2:{
                        setOrden(2);
                    }break;
                    //ApuestaMinima.Creciente
                    case 3:{
                        setOrden(3);
                    }break;
                    //ApuestaMinima.Decreciente
                    case 4:{
                        setOrden(4);
                    }break;
                }
            controlador.pedirNumeroMesas();
            rellenarMesas();
            }

    }

    private void salir() {
        System.out.println("OK");
        if (JOptionPane.showConfirmDialog(this,"Â¿Desea abandonar el juego?",
                "Cierre del juego",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
				if(controlador.cerrarConexion()){
                    System.exit(0);
                }

    }
}