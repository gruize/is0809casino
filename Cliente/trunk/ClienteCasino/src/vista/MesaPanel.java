package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import modelo.Apuesta;


public class MesaPanel extends javax.swing.JPanel {
	//bloquea el tapiz
	private boolean terminar=true;
	private ImageIcon imgFondo;
	private TapizPanel tapiz;
    private static int ancho=430;
    private static int alto=800;
    private static int valorNegra=50;
    private static int valorRoja=10;
    private static int valorBlanca=20;
    private static int valorAzul=100;
    private JTextField casilla;
    private JLabel labelCasilla;
    private JLabel ficha_roja;
    private JLabel ficha_selecionada;
    private JTextField totalTextField;
    private JLabel fichaNegra;
    private JLabel ficha_blanca;
    private JLabel ficha_azul;
    private JCheckBox apostar;
    private JCheckBox quitar;
    private JTextField apuestaTextField;
    //tipoFicha 0=ninguna ficha.1=rojo,2=blanco,3=negro,4=azul
	private int tipoFicha=0;
	private double apuestaTotal=0;
	private double apuestaCasilla=0;
	private double saldoUsuario;
	//lista de las apuestas del usuario
	private Apuesta[] listaApuestas;
	private int numApuestas;
	/**
	* Auto-generated main method to display this
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.getContentPane().add(new MesaPanel());

		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();


		frame.setVisible(true);
	}

    public double getSaldoUsuario() {
        return saldoUsuario;
    }

    public void setSaldoUsuario(double saldoUsuario) {
        this.saldoUsuario = saldoUsuario;
    }

	public MesaPanel() {
		super();
		preInit();
		initGUI();
		listaApuestas=new Apuesta[160];
		numApuestas=0;
	}
	public void nuevaApuesta(){
		numApuestas++;
	}
	private void initGUI() {
		try {

			setPreferredSize(new Dimension(ancho, alto));
			this.setLayout(null);
			this.setBackground(new java.awt.Color(255,255,255));
			{
				tapiz = new TapizPanel(this);
				this.add(tapiz);
				tapiz.setBounds(26, 439, 377, 264);
			}
			{
				totalTextField = new JTextField();
				this.add(totalTextField);
				totalTextField.setBounds(258, 308, 46, 21);
				totalTextField.setEditable(false);
			}
			{
				apuestaTextField = new JTextField();
				this.add(getApuestaTextField());
				apuestaTextField.setBounds(258, 368, 46, 21);
				apuestaTextField.setEditable(false);
			}
			{
				quitar = new JCheckBox();
				this.add(getQuitar());
				quitar.setBounds(270, 725, 20, 20);
				quitar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						quitarActionPerformed(evt);
					}
				});

			}
			{
				apostar = new JCheckBox();
				this.add(getApostar());
				apostar.setBounds(270, 746, 20, 20);
				apostar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						apostarActionPerformed(evt);
					}
				});
				apostar.setSelected(true);
			}
			{
				fichaNegra = new JLabel();
				this.add(fichaNegra);
				fichaNegra.setBounds(157, 724, 21, 23);
				fichaNegra.setIcon(new ImageIcon(getClass().getResource("/recursos/ficha.png")));
				fichaNegra.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						fichaNegraMouseClicked(evt);
					}
				});
			}
			{
				ficha_azul = new JLabel();
				this.add(ficha_azul);
				ficha_azul.setIcon(new ImageIcon(getClass().getResource("/recursos/ficha_azul.png")));
				ficha_azul.setBounds(220, 724, 21, 23);
				ficha_azul.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						ficha_azulMouseClicked(evt);
					}
				});
			}
			{
				ficha_blanca = new JLabel();
				this.add(ficha_blanca);
				ficha_blanca.setIcon(new ImageIcon(getClass().getResource("/recursos/ficha_blanca.png")));
				ficha_blanca.setBounds(94, 724, 21, 23);
				ficha_blanca.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						ficha_blancaMouseClicked(evt);
					}
				});
			}
			{
				ficha_roja = new JLabel();
				this.add(ficha_roja);
				ficha_roja.setIcon(new ImageIcon(getClass().getResource("/recursos/ficha_roja.png")));
				ficha_roja.setBounds(38, 724, 21, 23);
				ficha_roja.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						ficha_rojaMouseClicked(evt);
					}
				});
			}
			{
				ficha_selecionada = new JLabel();
				this.add(ficha_selecionada);
				ficha_selecionada.setIcon(new ImageIcon(getClass().getResource("/recursos/trasparente.png")));
				ficha_selecionada.setBounds(170, 419, 23, 17);
			}
				this.totalTextField.setText(Double.toString(apuestaTotal));
				this.apuestaTextField.setText(Double.toString(apuestaCasilla));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void preInit(){
        imgFondo = new ImageIcon(getClass().getResource("/recursos/mesa.png"));
}
    public void paintComponent(Graphics g) {
		   if (imgFondo != null) {
		                g.drawImage(imgFondo.getImage(), 0, 0, ancho, alto, this);
		            }

		  }

    public JTextField getApuestaTextField() {
    	return apuestaTextField;
    }

    public JCheckBox getQuitar() {
    	return quitar;
    }

    public JCheckBox getApostar() {
    	return apostar;
    }

    private void ficha_rojaMouseClicked(MouseEvent evt) {
    	System.out.println("ficha_roja.mouseClicked, event="+evt);
    	//TODO add your code for ficha_roja.mouseClicked
    	ficha_selecionada.setIcon(new ImageIcon(getClass().getResource("/recursos/ficha_roja.png")));
    	tipoFicha=1;
    }

    private void ficha_blancaMouseClicked(MouseEvent evt) {
    	System.out.println("ficha_blanca.mouseClicked, event="+evt);
    	//TODO add your code for ficha_blanca.mouseClicked
    	ficha_selecionada.setIcon(new ImageIcon(getClass().getResource("/recursos/ficha_blanca.png")));
    	tipoFicha=2;
    }

    private void fichaNegraMouseClicked(MouseEvent evt) {
    	System.out.println("fichaNegra.mouseClicked, event="+evt);
    	//TODO add your code for fichaNegra.mouseClicked
    	ficha_selecionada.setIcon(new ImageIcon(getClass().getResource("/recursos/ficha.png")));
    	tipoFicha=3;
    }

    private void ficha_azulMouseClicked(MouseEvent evt) {
    	System.out.println("ficha_azul.mouseClicked, event="+evt);
    	//TODO add your code for ficha_azul.mouseClicked
    	ficha_selecionada.setIcon(new ImageIcon(getClass().getResource("/recursos/ficha_azul.png")));
    	tipoFicha=4;
    }
    public void casillaPulsada(int casilla,Apuesta.tipoAp tipo){

    	Apuesta apuesta=null;
    	int num=0;

    	for(int i=0;i<numApuestas;i++){
    		if(listaApuestas[i].getCasilla()==casilla && listaApuestas[i].getTipo().toString().equals(tipo.toString()) ){
    			apuesta=listaApuestas[i];
    			apuestaCasilla=apuesta.getValorApostado();
    			num=i;
    		}
    	}
    	if(apuesta==null){//sino esta en  la lista
    		apuesta=new Apuesta(casilla,tipo,0);
    		apuestaCasilla=0;
    		num=numApuestas;
    		numApuestas++;
    	}
    	this.apuestaTextField.setText(Double.toString(apuestaCasilla));
	    	if(tipoFicha==1){
	    		if(this.quitar.isSelected()){
	    			apuestaTotal = apuestaTotal - apuestaCasilla ;
	    			saldoUsuario= saldoUsuario + apuestaCasilla ;
	    			apuestaCasilla = 0 ;

	    		}
	    		else{
	    			apuestaTotal = apuestaTotal + valorRoja;
	    			apuestaCasilla = apuestaCasilla + valorRoja;
	    			saldoUsuario= saldoUsuario - valorRoja;
	    		}
	    	}
	    	if(tipoFicha==2){
	    		if(this.quitar.isSelected()){
	    			apuestaTotal = apuestaTotal - apuestaCasilla ;
	    			saldoUsuario= saldoUsuario + apuestaCasilla ;
	    			apuestaCasilla = 0 ;
	    		}
	    		else{
	    			apuestaTotal = apuestaTotal + valorBlanca;
	    			apuestaCasilla = apuestaCasilla + valorBlanca;
	    			saldoUsuario= saldoUsuario - valorBlanca;
	    		}
	    	}
	    	if(tipoFicha==3){
	    		if(this.quitar.isSelected()){
	    			apuestaTotal = apuestaTotal - apuestaCasilla ;
	    			saldoUsuario= saldoUsuario + apuestaCasilla ;
	    			apuestaCasilla = 0 ;
	    		}
	    		else{
	    			apuestaTotal = apuestaTotal + valorNegra;
	    			apuestaCasilla = apuestaCasilla + valorNegra;
	    			saldoUsuario= saldoUsuario - valorNegra;
	    		}
	    	}
	    	if(tipoFicha==4){
	    		if(this.quitar.isSelected()){
	    			apuestaTotal = apuestaTotal - apuestaCasilla ;
	    			saldoUsuario= saldoUsuario + apuestaCasilla ;
	    			apuestaCasilla = 0 ;
	    		}
	    		else{
	    			apuestaTotal = apuestaTotal + valorAzul;
	    			apuestaCasilla = apuestaCasilla + valorAzul;
	    			saldoUsuario= saldoUsuario - valorAzul;
	    		}
	    	}
	    	apuesta.setValorApostado(apuestaCasilla);
	    	listaApuestas[num]=apuesta;
	    	this.totalTextField.setText(Double.toString(apuestaTotal));
	    	this.apuestaTextField.setText(Double.toString(apuestaCasilla));
    }

    //si el usuario ha termiando de apostar
    public boolean aTerminado(){
    	return this.terminar;
    }
    public boolean quitarApuesta(){
    	return this.quitar.isSelected();
    }

    private void quitarActionPerformed(ActionEvent evt) {
    	System.out.println("quitar.actionPerformed, event="+evt);
    	//TODO add your code for quitar.actionPerformed
    	if(this.apostar.isSelected())
    		apostar.setSelected(false);
    	else
    		apostar.setSelected(true);
    }

    private void apostarActionPerformed(ActionEvent evt) {
    	System.out.println("apostar.actionPerformed, event="+evt);
    	//TODO add your code for apostar.actionPerformed
    	if(this.quitar.isSelected())
    		quitar.setSelected(false);
    	else
    		quitar.setSelected(true);
    }
    public int dameFichaApuesta(){
    	return tipoFicha;
    }
    public boolean tieneDinero(){
    	if(tipoFicha==1)
    		if(saldoUsuario>=valorRoja)	return true;
    		else return false;
    	if(tipoFicha==2)
    		if(saldoUsuario>=valorBlanca)	return true;
    		else return false;
    	if(tipoFicha==3)
    		if(saldoUsuario>=valorNegra)	return true;
    		else return false;
    	if(tipoFicha==4)
    		if(saldoUsuario>=valorAzul)	return true;
    		else return false;
    	return false;


    }
    public Apuesta[] dameApuestas(){
    	return this.listaApuestas;
    }
    public Apuesta[] terminarYdameListaApuestas(){
    	this.terminar=true;
    	return this.listaApuestas;
    }
    public void empezar(double saldo){
    	this.terminar=false;
    	this.saldoUsuario=saldo;
    	this.totalTextField.setText("0");
    	this.apuestaTextField.setText("0");
    }
    public void setSaldoUsuario(int saldo){
    	saldoUsuario=saldo;
    }
    public int dameNumApuestas(){
    	return numApuestas;
    }
    public void limpiarTapete(){
    	this.remove(tapiz);
    	{
    	tapiz = new TapizPanel(this);
		this.add(tapiz);
		tapiz.setBounds(26, 439, 377, 264);
    	}
        getFicha_selecionada().setIcon(null);
        this.apuestaTotal=0.0;
    }

    public JLabel getFicha_selecionada() {
        return ficha_selecionada;
    }
    public void setTerminar(boolean t){
    	this.terminar=t;
    }
}
