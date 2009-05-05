package vista;

import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import modelo.Apuesta;
import java.awt.BorderLayout;

import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;



public class TapizPanel extends javax.swing.JPanel {

	private Image imgFondo;
	private MesaPanel mesa;
    private static int ancho=393;
    private static int alto=286;
    private JLabel jLabel80;
    private JLabel jLabel78;
    private JLabel jLabel74;
    private JLabel jLabel71;
    private JLabel jLabel69;
    private JLabel jLabel67;
    private JLabel jLabel65;
    private JLabel jLabel4;
    private JLabel jLabel2;
    private JLabel jLabel61;
    private JLabel jLabel59;
    private JLabel jLabel55;
    private JLabel jLabel53;
    private JLabel jLabel51;
    private JLabel jLabel49;
    private JLabel jLabel48;
    private JLabel jLabel46;
    private JLabel jLabel44;
    private JLabel jLabel42;
    private JLabel jLabel40;
    private JLabel jLabel38;
    private JLabel jLabel36;
    private JLabel jLabel34;
    private JLabel jLabel32;
    private JLabel jLabel30;
    private JLabel jLabel28;
    private JLabel jLabel26;
    private JLabel jLabel24;
    private JLabel jLabel22;
    private JLabel jLabel160;
    private JLabel jLabel159;
    private JLabel jLabel158;
    private JLabel jLabel157;
    private JLabel jLabel156;
    private JLabel jLabel155;
    private JLabel jLabel154;
    private JLabel jLabel153;
    private JLabel jLabel152;
    private JLabel jLabel151;
    private JLabel jLabel150;
    private JLabel jLabel149;
    private JLabel jLabel148;
    private JLabel jLabel146;
    private JLabel jLabel144;
    private JLabel jLabel142;
    private JLabel jLabel140;
    private JLabel jLabel138;
    private JLabel jLabel136;
    private JLabel jLabel134;
    private JLabel jLabel132;
    private JLabel jLabel130;
    private JLabel jLabel128;
    private JLabel jLabel127;
    private JLabel jLabel125;
    private JLabel jLabel123;
    private JLabel jLabel121;
    private JLabel jLabel119;
    private JLabel jLabel117;
    private JLabel jLabel115;
    private JLabel jLabel95;
    private JLabel jLabel19;
    private JLabel jLabel17;
    private JLabel jLabel15;
    private JLabel jLabel13;
    private JLabel jLabel11;
    private JLabel jLabel8;
    private JLabel jLabel5;
    private JLabel jLabel7;
    private JLabel jLabel6;
    private JLabel jLabel3;
    private JLabel jLabel1;
	/**
	* Auto-generated main method to display this
	* JPanel inside a new JFrame.
	*/

	public TapizPanel(MesaPanel m) {
		super();
		setSize(ancho,alto);
	    preInit();
		initGUI();
		mesa=m;

	}

	private void preInit(){
        imgFondo = new ImageIcon(getClass().getResource("tapete.png")).getImage();
}
    public void paintComponent(Graphics g) {
		   if (imgFondo != null) {
		                g.drawImage(imgFondo, 0, 0, ancho, alto, this);
		            }

		  }

	private void initGUI() {
		try {

			this.setLayout(null);
			setPreferredSize(new Dimension(ancho,alto));
			{
				jLabel1 = new JLabel();
				this.add(jLabel1);
				jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel1.setBounds(66, 50, 16, 18);
				jLabel1.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel1MouseClicked(evt);
					}
				});
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3);
				jLabel3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel3.setBounds(66, 87, 16, 18);
				jLabel3.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel3MouseClicked(evt);
					}
				});
			}
			{
				jLabel5 = new JLabel();
				this.add(jLabel5);
				jLabel5.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel5.setBounds(66, 124, 16, 18);
				jLabel5.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel5MouseClicked(evt);
					}
				});
			}
			{
				jLabel6 = new JLabel();
				this.add(jLabel6);
				jLabel6.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel6.setBounds(44, 87, 16, 18);
				jLabel6.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel6MouseClicked(evt);
					}
				});
			}
			{
				jLabel7 = new JLabel();
				this.add(jLabel7);
				jLabel7.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel7.setBounds(92, 50, 16, 18);
				jLabel7.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel7MouseClicked(evt);
					}
				});
			}
			{
				jLabel8 = new JLabel();
				this.add(jLabel8);
				jLabel8.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel8.setBounds(79, 69, 16, 18);
				jLabel8.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel8MouseClicked(evt);
					}
				});
			}
			{
				jLabel11 = new JLabel();
				this.add(jLabel11);
				jLabel11.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel11.setBounds(92, 86, 16, 18);
				jLabel11.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel11MouseClicked(evt);
					}
				});
			}
			{
				jLabel13 = new JLabel();
				this.add(jLabel13);
				jLabel13.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel13.setBounds(78, 106, 16, 18);
				jLabel13.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel13MouseClicked(evt);
					}
				});
			}
			{
				jLabel15 = new JLabel();
				this.add(jLabel15);
				jLabel15.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel15.setBounds(93, 123, 16, 18);
				jLabel15.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel15MouseClicked(evt);
					}
				});
			}
			{
				jLabel17 = new JLabel();
				this.add(jLabel17);
				jLabel17.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel17.setBounds(104, 106, 16, 18);
				jLabel17.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel17MouseClicked(evt);
					}
				});
			}
			{
				jLabel19 = new JLabel();
				this.add(jLabel19);
				jLabel19.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel19.setBounds(103, 69, 16, 18);
				jLabel19.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel19MouseClicked(evt);
					}
				});
			}
			{
				jLabel22 = new JLabel();
				this.add(jLabel22);
				jLabel22.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel22.setBounds(139, 123, 16, 18);
				jLabel22.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel22MouseClicked(evt);
					}
				});
			}
			{
				jLabel24 = new JLabel();
				this.add(jLabel24);
				jLabel24.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel24.setBounds(117, 123, 16, 18);
				jLabel24.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel24MouseClicked(evt);
					}
				});
			}
			{
				jLabel26 = new JLabel();
				this.add(jLabel26);
				jLabel26.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel26.setBounds(127, 106, 16, 18);
				jLabel26.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel26MouseClicked(evt);
					}
				});
			}
			{
				jLabel28 = new JLabel();
				this.add(jLabel28);
				jLabel28.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel28.setBounds(150, 106, 16, 18);
				jLabel28.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel28MouseClicked(evt);
					}
				});
			}
			{
				jLabel30 = new JLabel();
				this.add(jLabel30);
				jLabel30.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel30.setBounds(138, 86, 16, 18);
				jLabel30.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel30MouseClicked(evt);
					}
				});
			}
			{
				jLabel32 = new JLabel();
				this.add(jLabel32);
				jLabel32.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel32.setBounds(115, 86, 16, 18);
				jLabel32.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel32MouseClicked(evt);
					}
				});
			}
			{
				jLabel34 = new JLabel();
				this.add(jLabel34);
				jLabel34.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel34.setBounds(124, 69, 16, 18);
				jLabel34.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel34MouseClicked(evt);
					}
				});
			}
			{
				jLabel36 = new JLabel();
				this.add(jLabel36);
				jLabel36.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel36.setBounds(149, 69, 16, 18);
				jLabel36.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel36MouseClicked(evt);
					}
				});
			}
			{
				jLabel38 = new JLabel();
				this.add(jLabel38);
				jLabel38.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel38.setBounds(138, 50, 16, 18);
				jLabel38.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel38MouseClicked(evt);
					}
				});
			}
			{
				jLabel40 = new JLabel();
				this.add(jLabel40);
				jLabel40.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel40.setBounds(116, 50, 16, 18);
				jLabel40.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel40MouseClicked(evt);
					}
				});
			}
			{
				jLabel42 = new JLabel();
				this.add(jLabel42);
				jLabel42.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel42.setBounds(229, 50, 16, 18);
				jLabel42.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel42MouseClicked(evt);
					}
				});
			}
			{
				jLabel44 = new JLabel();
				this.add(jLabel44);
				jLabel44.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel44.setBounds(207, 50, 16, 18);
				jLabel44.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel44MouseClicked(evt);
					}
				});
			}
			{
				jLabel46 = new JLabel();
				this.add(jLabel46);
				jLabel46.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel46.setBounds(184, 49, 16, 18);
				jLabel46.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel46MouseClicked(evt);
					}
				});
			}
			{
				jLabel48 = new JLabel();
				this.add(jLabel48);
				jLabel48.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel48.setBounds(161, 50, 16, 18);
				jLabel48.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel48MouseClicked(evt);
					}
				});
			}
			{
				jLabel49 = new JLabel();
				this.add(jLabel49);
				jLabel49.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel49.setBounds(240, 70, 16, 18);
				jLabel49.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel49MouseClicked(evt);
					}
				});
			}
			{
				jLabel51 = new JLabel();
				this.add(jLabel51);
				jLabel51.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel51.setBounds(218, 70, 16, 18);
				jLabel51.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel51MouseClicked(evt);
					}
				});
			}
			{
				jLabel53 = new JLabel();
				this.add(jLabel53);
				jLabel53.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel53.setBounds(196, 70, 16, 18);
				jLabel53.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel53MouseClicked(evt);
					}
				});
			}
			{
				jLabel55 = new JLabel();
				this.add(jLabel55);
				jLabel55.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel55.setBounds(172, 69, 16, 18);
				jLabel55.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel55MouseClicked(evt);
					}
				});
			}
			{
				jLabel59 = new JLabel();
				this.add(jLabel59);
				jLabel59.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel59.setBounds(229, 86, 16, 18);
				jLabel59.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel59MouseClicked(evt);
					}
				});
			}
			{
				jLabel61 = new JLabel();
				this.add(jLabel61);
				jLabel61.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel61.setBounds(207, 86, 16, 18);
				jLabel61.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel61MouseClicked(evt);
					}
				});
			}
			{
				jLabel65 = new JLabel();
				this.add(jLabel65);
				jLabel65.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel65.setBounds(239, 106, 16, 18);
				jLabel65.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel65MouseClicked(evt);
					}
				});
			}
			{
				jLabel67 = new JLabel();
				this.add(jLabel67);
				jLabel67.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel67.setBounds(217, 106, 16, 18);
				jLabel67.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel67MouseClicked(evt);
					}
				});
			}
			{
				jLabel69 = new JLabel();
				this.add(jLabel69);
				jLabel69.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel69.setBounds(195, 106, 16, 18);
				jLabel69.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel69MouseClicked(evt);
					}
				});
			}
			{
				jLabel71 = new JLabel();
				this.add(jLabel71);
				jLabel71.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel71.setBounds(171, 106, 16, 18);
				jLabel71.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel71MouseClicked(evt);
					}
				});
			}
			{
				jLabel74 = new JLabel();
				this.add(jLabel74);
				jLabel74.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel74.setBounds(228, 123, 16, 18);
				jLabel74.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel74MouseClicked(evt);
					}
				});
			}
			{
				jLabel78 = new JLabel();
				this.add(jLabel78);
				jLabel78.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel78.setBounds(183, 123, 16, 18);
				jLabel78.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel78MouseClicked(evt);
					}
				});
			}
			{
				jLabel80 = new JLabel();
				this.add(jLabel80);
				jLabel80.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel80.setBounds(160, 123, 16, 18);
				jLabel80.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel80MouseClicked(evt);
					}
				});
			}


			{
				jLabel95 = new JLabel();
				this.add(jLabel95);
				jLabel95.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel95.setBounds(161, 86, 16, 18);
				jLabel95.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel95MouseClicked(evt);
					}
				});
			}

			{
				jLabel115 = new JLabel();
				this.add(jLabel115);
				jLabel115.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel115.setBounds(263, 70, 16, 18);
				jLabel115.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel115MouseClicked(evt);
					}
				});
			}
			{
				jLabel117 = new JLabel();
				this.add(jLabel117);
				jLabel117.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel117.setBounds(286, 71, 16, 18);
				jLabel117.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel117MouseClicked(evt);
					}
				});
			}
			{
				jLabel119 = new JLabel();
				this.add(jLabel119);
				jLabel119.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel119.setBounds(308, 71, 16, 18);
				jLabel119.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel119MouseClicked(evt);
					}
				});
			}
			{
				jLabel121 = new JLabel();
				this.add(jLabel121);
				jLabel121.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel121.setBounds(251, 50, 16, 18);
				jLabel121.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel121MouseClicked(evt);
					}
				});
			}
			{
				jLabel123 = new JLabel();
				this.add(jLabel123);
				jLabel123.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel123.setBounds(275, 51, 16, 18);
				jLabel123.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel123MouseClicked(evt);
					}
				});
			}
			{
				jLabel125 = new JLabel();
				this.add(jLabel125);
				jLabel125.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel125.setBounds(297, 51, 16, 18);
				jLabel125.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel125MouseClicked(evt);
					}
				});
			}
			{
				jLabel127 = new JLabel();
				this.add(jLabel127);
				jLabel127.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel127.setBounds(319, 51, 16, 18);
				jLabel127.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel127MouseClicked(evt);
					}
				});
			}
			{
				jLabel128 = new JLabel();
				this.add(jLabel128);
				jLabel128.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel128.setBounds(251, 123, 16, 18);
				jLabel128.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel128MouseClicked(evt);
					}
				});
			}
			{
				jLabel130 = new JLabel();
				this.add(jLabel130);
				jLabel130.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel130.setBounds(275, 123, 16, 18);
				jLabel130.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel130MouseClicked(evt);
					}
				});
			}
			{
				jLabel132 = new JLabel();
				this.add(jLabel132);
				jLabel132.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel132.setBounds(297, 123, 16, 18);
				jLabel132.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel132MouseClicked(evt);
					}
				});
			}
			{
				jLabel134 = new JLabel();
				this.add(jLabel134);
				jLabel134.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel134.setBounds(319, 123, 16, 18);
				jLabel134.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel134MouseClicked(evt);
					}
				});
			}
			{
				jLabel136 = new JLabel();
				this.add(jLabel136);
				jLabel136.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel136.setBounds(308, 106, 16, 18);
				jLabel136.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel136MouseClicked(evt);
					}
				});
			}
			{
				jLabel138 = new JLabel();
				this.add(jLabel138);
				jLabel138.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel138.setBounds(286, 106, 16, 18);
				jLabel138.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel138MouseClicked(evt);
					}
				});
			}
			{
				jLabel140 = new JLabel();
				this.add(jLabel140);
				jLabel140.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel140.setBounds(263, 106, 16, 18);
				jLabel140.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel140MouseClicked(evt);
					}
				});
			}
			{
				jLabel142 = new JLabel();
				this.add(jLabel142);
				jLabel142.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel142.setBounds(252, 86, 16, 18);
				jLabel142.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel142MouseClicked(evt);
					}
				});
			}
			{
				jLabel144 = new JLabel();
				this.add(jLabel144);
				jLabel144.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel144.setBounds(276, 86, 16, 18);
				jLabel144.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel144MouseClicked(evt);
					}
				});
			}
			{
				jLabel146 = new JLabel();
				this.add(jLabel146);
				jLabel146.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel146.setBounds(298, 86, 16, 18);
				jLabel146.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel146MouseClicked(evt);
					}
				});
			}
			{
				jLabel148 = new JLabel();
				this.add(jLabel148);
				jLabel148.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel148.setBounds(320, 86, 16, 18);
				jLabel148.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel148MouseClicked(evt);
					}
				});
			}
			{
				jLabel149 = new JLabel();
				this.add(jLabel149);
				jLabel149.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel149.setBounds(340, 52, 16, 18);
				jLabel149.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel149MouseClicked(evt);
					}
				});
			}
			{
				jLabel150 = new JLabel();
				this.add(jLabel150);
				jLabel150.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel150.setBounds(340, 87, 16, 18);
				jLabel150.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel150MouseClicked(evt);
					}
				});
			}
			{
				jLabel151 = new JLabel();
				this.add(jLabel151);
				jLabel151.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel151.setBounds(340, 122, 16, 18);
				jLabel151.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel151MouseClicked(evt);
					}
				});
			}
			{
				jLabel152 = new JLabel();
				this.add(jLabel152);
				jLabel152.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel152.setBounds(84, 153, 62, 18);
				jLabel152.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel152MouseClicked(evt);
					}
				});
			}
			{
				jLabel153 = new JLabel();
				this.add(jLabel153);
				jLabel153.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel153.setBounds(168, 153, 72, 18);
				jLabel153.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel153MouseClicked(evt);
					}
				});
			}
			{
				jLabel154 = new JLabel();
				this.add(jLabel154);
				jLabel154.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel154.setBounds(259, 153, 72, 18);
				jLabel154.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel154MouseClicked(evt);
					}
				});
			}
			{
				jLabel155 = new JLabel();
				this.add(jLabel155);
				jLabel155.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel155.setBounds(78, 191, 30, 26);
				jLabel155.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel155MouseClicked(evt);
					}
				});
			}
			{
				jLabel156 = new JLabel();
				this.add(jLabel156);
				jLabel156.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel156.setBounds(120, 191, 35, 26);
				jLabel156.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel156MouseClicked(evt);
					}
				});
			}
			{
				jLabel157 = new JLabel();
				this.add(jLabel157);
				jLabel157.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel157.setBounds(169, 191, 27, 26);
				jLabel157.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel157MouseClicked(evt);
					}
				});
			}
			{
				jLabel158 = new JLabel();
				this.add(jLabel158);
				jLabel158.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel158.setBounds(213, 191, 30, 26);
				jLabel158.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel158MouseClicked(evt);
					}
				});
			}
			{
				jLabel159 = new JLabel();
				this.add(jLabel159);
				jLabel159.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel159.setBounds(255, 191, 35, 26);
				jLabel159.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel159MouseClicked(evt);
					}
				});
			}
			{
				jLabel160 = new JLabel();
				this.add(jLabel160);
				jLabel160.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel160.setBounds(306, 191, 27, 26);
				jLabel160.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel160MouseClicked(evt);
					}
				});
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2);
				jLabel2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel2.setBounds(182, 86, 16, 18);
				jLabel2.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel2MouseClicked(evt);
					}
				});
			}
			{
				jLabel4 = new JLabel();
				this.add(jLabel4);
				jLabel4.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				jLabel4.setBounds(206, 124, 16, 18);
				jLabel4.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel4MouseClicked(evt);
					}
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	//APUESTA 3
	private void jLabel1MouseClicked(MouseEvent evt) {
		System.out.println("jLabel1.mouseClicked, event="+evt);
		//TODO add your code for jLabel1.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(3,Apuesta.tipoAp.NUMERO);
			}
		}
	}


	//APUESTA 2
	private void jLabel3MouseClicked(MouseEvent evt) {
		System.out.println("jLabel3.mouseClicked, event="+evt);
		//TODO add your code for jLabel3.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(2,Apuesta.tipoAp.NUMERO);
			}
		}

	}

	//APUESTA 1
	private void jLabel5MouseClicked(MouseEvent evt) {
		System.out.println("jLabel5.mouseClicked, event="+evt);
		//TODO add your code for jLabel5.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel5.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel5.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel5.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel5.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel5.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(1,Apuesta.tipoAp.NUMERO);
			}
		}
	}
	//APUESTA 0
	private void jLabel6MouseClicked(MouseEvent evt) {
		System.out.println("jLabel6.mouseClicked, event="+evt);
		//TODO add your code for jLabel6.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel6.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel6.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel6.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel6.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel6.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(0,Apuesta.tipoAp.NUMERO);
			}
		}
	}
	//APUESTA 6
	private void jLabel7MouseClicked(MouseEvent evt) {
		System.out.println("jLabel7.mouseClicked, event="+evt);
		//TODO add your code for jLabel7.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel7.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel7.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel7.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel7.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel7.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(6,Apuesta.tipoAp.NUMERO);
			}
		}
	}
	//APUESTA 2-3-5-6
	private void jLabel8MouseClicked(MouseEvent evt) {
		System.out.println("jLabel8.mouseClicked, event="+evt);
		//TODO add your code for jLabel8.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel8.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel8.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel8.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel8.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel8.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(2,Apuesta.tipoAp.CUADRO);
			}
		}
	}
	//APUESTA 5
	private void jLabel11MouseClicked(MouseEvent evt) {
		System.out.println("jLabel11.mouseClicked, event="+evt);
		//TODO add your code for jLabel11.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel11.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel11.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel11.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel11.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel11.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(5,Apuesta.tipoAp.NUMERO);
			}
		}
	}

	//APUESTA 1-2-5-4
	private void jLabel13MouseClicked(MouseEvent evt) {
		System.out.println("jLabel13.mouseClicked, event="+evt);
		//TODO add your code for jLabel13.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel13.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel13.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel13.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel13.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel13.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(1,Apuesta.tipoAp.CUADRO);
			}
		}
	}

	//APUESTA 4
	private void jLabel15MouseClicked(MouseEvent evt) {
		System.out.println("jLabel15.mouseClicked, event="+evt);
		//TODO add your code for jLabel15.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel15.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel15.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel15.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel15.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel15.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(4,Apuesta.tipoAp.NUMERO);
			}
		}
	}

	//APUESTA 5-8-4-7
	private void jLabel17MouseClicked(MouseEvent evt) {
		System.out.println("jLabel17.mouseClicked, event="+evt);
		//TODO add your code for jLabel17.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel17.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel17.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel17.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel17.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel17.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(3,Apuesta.tipoAp.CUADRO);
			}
		}
	}
	//17
	private void jLabel2MouseClicked(MouseEvent evt) {
		System.out.println("jLabel2.mouseClicked, event="+evt);
		//TODO add your code for jLabel2.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(17,Apuesta.tipoAp.NUMERO);
			}
		}
	}
	//19
	private void jLabel4MouseClicked(MouseEvent evt) {
		System.out.println("jLabel4.mouseClicked, event="+evt);
		//TODO add your code for jLabel4.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel4.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel4.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel4.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel4.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel4.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(19,Apuesta.tipoAp.NUMERO);
			}
		}
	}
	//APUESTA 6-9-5-8
	private void jLabel19MouseClicked(MouseEvent evt) {
		System.out.println("jLabel19.mouseClicked, event="+evt);
		//TODO add your code for jLabel19.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel19.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel19.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel19.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel19.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel19.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(4,Apuesta.tipoAp.CUADRO);
			}
		}
	}


	//APUESTA 10
	private void jLabel22MouseClicked(MouseEvent evt) {
		System.out.println("jLabel22.mouseClicked, event="+evt);
		//TODO add your code for jLabel22.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel22.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel22.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel22.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel22.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel22.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(10,Apuesta.tipoAp.NUMERO);
			}
		}
	}

	//APUESTA 7
	private void jLabel24MouseClicked(MouseEvent evt) {
		System.out.println("jLabel24.mouseClicked, event="+evt);
		//TODO add your code for jLabel24.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel24.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel24.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel24.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel24.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel24.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(7,Apuesta.tipoAp.NUMERO);
			}
		}
	}


	private void jLabel26MouseClicked(MouseEvent evt) {
		System.out.println("jLabel26.mouseClicked, event="+evt);
		//TODO add your code for jLabel26.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel26.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel26.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel26.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel26.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel26.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(5,Apuesta.tipoAp.CUADRO);
			}
		}
	}


	//APUESTA 10-11-13-14
	private void jLabel28MouseClicked(MouseEvent evt) {
		System.out.println("jLabel28.mouseClicked, event="+evt);
		//TODO add your code for jLabel28.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel28.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel28.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel28.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel28.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel28.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(7,Apuesta.tipoAp.CUADRO);
			}
		}
	}


	//APUESTA11
	private void jLabel30MouseClicked(MouseEvent evt) {
		System.out.println("jLabel30.mouseClicked, event="+evt);
		//TODO add your code for jLabel30.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel30.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel30.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel30.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel30.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel30.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(11,Apuesta.tipoAp.NUMERO);
			}
		}
	}


	//APUESTA8
	private void jLabel32MouseClicked(MouseEvent evt) {
		System.out.println("jLabel32.mouseClicked, event="+evt);
		//TODO add your code for jLabel32.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel32.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel32.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel32.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel32.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel32.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(8,Apuesta.tipoAp.NUMERO);
			}
		}
	}

	//APUESTA 8-9-11-12
	private void jLabel34MouseClicked(MouseEvent evt) {
		System.out.println("jLabel34.mouseClicked, event="+evt);
		//TODO add your code for jLabel34.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel34.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel34.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel34.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel34.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel34.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(6,Apuesta.tipoAp.CUADRO);
			}
		}
	}

	//APUESTA 11-12-14-15
	private void jLabel36MouseClicked(MouseEvent evt) {
		System.out.println("jLabel36.mouseClicked, event="+evt);
		//TODO add your code for jLabel36.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel36.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel36.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel36.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel36.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel36.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(8,Apuesta.tipoAp.CUADRO);
			}
		}
	}


	//12
	private void jLabel38MouseClicked(MouseEvent evt) {
		System.out.println("jLabel38.mouseClicked, event="+evt);
		//TODO add your code for jLabel38.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel38.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel38.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel38.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel38.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel38.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(12,Apuesta.tipoAp.NUMERO);
			}
		}
	}


	//APUESTA 9
	private void jLabel40MouseClicked(MouseEvent evt) {
		System.out.println("jLabel40.mouseClicked, event="+evt);
		//TODO add your code for jLabel40.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel40.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel40.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel40.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel40.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel40.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(9,Apuesta.tipoAp.NUMERO);
			}
		}
	}

	//24
	private void jLabel42MouseClicked(MouseEvent evt) {
		System.out.println("jLabel42.mouseClicked, event="+evt);
		//TODO add your code for jLabel42.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel42.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel42.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel42.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel42.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel42.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(24,Apuesta.tipoAp.NUMERO);
			}
		}
	}


	//21
	private void jLabel44MouseClicked(MouseEvent evt) {
		System.out.println("jLabel44.mouseClicked, event="+evt);
		//TODO add your code for jLabel44.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel44.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel44.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel44.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel44.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel44.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(21,Apuesta.tipoAp.NUMERO);
			}
		}
	}

	//18
	private void jLabel46MouseClicked(MouseEvent evt) {
		System.out.println("jLabel46.mouseClicked, event="+evt);
		//TODO add your code for jLabel46.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel46.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel46.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel46.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel46.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel46.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(18,Apuesta.tipoAp.NUMERO);
			}
		}
	}


	//15
	private void jLabel48MouseClicked(MouseEvent evt) {
		System.out.println("jLabel48.mouseClicked, event="+evt);
		//TODO add your code for jLabel48.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel48.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel48.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel48.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel48.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel48.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(15,Apuesta.tipoAp.NUMERO);
			}
		}
	}
	//23-24-26-27
	private void jLabel49MouseClicked(MouseEvent evt) {
		System.out.println("jLabel49.mouseClicked, event="+evt);
		//TODO add your code for jLabel49.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel49.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel49.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel49.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel49.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel49.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(16,Apuesta.tipoAp.CUADRO);
			}
		}
	}



	private void jLabel51MouseClicked(MouseEvent evt) {
		System.out.println("jLabel51.mouseClicked, event="+evt);
		//TODO add your code for jLabel51.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel51.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel51.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel51.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel51.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel51.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(14,Apuesta.tipoAp.CUADRO);
			}
		}
	}


	//17-18-20-21
	private void jLabel53MouseClicked(MouseEvent evt) {
		System.out.println("jLabel53.mouseClicked, event="+evt);
		//TODO add your code for jLabel53.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel53.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel53.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel53.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel53.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel53.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(12,Apuesta.tipoAp.CUADRO);
			}
		}
	}

	//14-15-17-18
	private void jLabel55MouseClicked(MouseEvent evt) {
		System.out.println("jLabel55.mouseClicked, event="+evt);
		//TODO add your code for jLabel55.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel55.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel55.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel55.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel55.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel55.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(10,Apuesta.tipoAp.CUADRO);
			}
		}
	}




	//23
	private void jLabel59MouseClicked(MouseEvent evt) {
		System.out.println("jLabel59.mouseClicked, event="+evt);
		//TODO add your code for jLabel59.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel59.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel59.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel59.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel59.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel59.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(23,Apuesta.tipoAp.NUMERO);
			}
		}
	}


	//20
	private void jLabel61MouseClicked(MouseEvent evt) {
		System.out.println("jLabel61.mouseClicked, event="+evt);
		//TODO add your code for jLabel61.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel61.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel61.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel61.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel61.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel61.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(20,Apuesta.tipoAp.NUMERO);
			}
		}
	}

	//22-23-25-26
	private void jLabel65MouseClicked(MouseEvent evt) {
		System.out.println("jLabel65.mouseClicked, event="+evt);
		//TODO add your code for jLabel65.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel65.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel65.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel65.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel65.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel65.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(15,Apuesta.tipoAp.CUADRO);
			}
		}
	}


	//19-20-22-23
	private void jLabel67MouseClicked(MouseEvent evt) {
		System.out.println("jLabel67.mouseClicked, event="+evt);
		//TODO add your code for jLabel67.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel67.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel67.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel67.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel67.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel67.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(13,Apuesta.tipoAp.CUADRO);
			}
		}
	}


	//16-17-19-20
	private void jLabel69MouseClicked(MouseEvent evt) {
		System.out.println("jLabel69.mouseClicked, event="+evt);
		//TODO add your code for jLabel69.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel69.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel69.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel69.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel69.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel69.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(11,Apuesta.tipoAp.CUADRO);
			}
		}
	}


	//APUESTA 13-14-16-17
	private void jLabel71MouseClicked(MouseEvent evt) {
		System.out.println("jLabel71.mouseClicked, event="+evt);
		//TODO add your code for jLabel71.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel71.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel71.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel71.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel71.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel71.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(9,Apuesta.tipoAp.CUADRO);
			}
		}
	}




	//22
	private void jLabel74MouseClicked(MouseEvent evt) {
		System.out.println("jLabel74.mouseClicked, event="+evt);
		//TODO add your code for jLabel74.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel74.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel74.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel74.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel74.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel74.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(22,Apuesta.tipoAp.NUMERO);
			}
		}
	}


	//16
	private void jLabel78MouseClicked(MouseEvent evt) {
		System.out.println("jLabel78.mouseClicked, event="+evt);
		//TODO add your code for jLabel78.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel78.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel78.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel78.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel78.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel78.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(16,Apuesta.tipoAp.NUMERO);
			}
		}
	}


	//13
	private void jLabel80MouseClicked(MouseEvent evt) {
		System.out.println("jLabel80.mouseClicked, event="+evt);
		//TODO add your code for jLabel80.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel80.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel80.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel80.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel80.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel80.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(13,Apuesta.tipoAp.NUMERO);
			}
		}
	}

	//14
	private void jLabel95MouseClicked(MouseEvent evt) {
		System.out.println("jLabel95.mouseClicked, event="+evt);
		//TODO add your code for jLabel95.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel95.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel95.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel95.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel95.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel95.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(14,Apuesta.tipoAp.NUMERO);
			}
		}
	}


	//26-27-29-30
	private void jLabel115MouseClicked(MouseEvent evt) {
		System.out.println("jLabel115.mouseClicked, event="+evt);
		//TODO add your code for jLabel115.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel115.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel115.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel115.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel115.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel115.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(18,Apuesta.tipoAp.CUADRO);
			}
		}
	}


	//29-30-32-33
	private void jLabel117MouseClicked(MouseEvent evt) {
		System.out.println("jLabel117.mouseClicked, event="+evt);
		//TODO add your code for jLabel117.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel117.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel117.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel117.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel117.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel117.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(20,Apuesta.tipoAp.CUADRO);
			}
		}
	}


	//32-33-35-36
	private void jLabel119MouseClicked(MouseEvent evt) {
		System.out.println("jLabel119.mouseClicked, event="+evt);
		//TODO add your code for jLabel119.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel119.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel119.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel119.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel119.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel119.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(22,Apuesta.tipoAp.CUADRO);
			}
		}
	}


	//27
	private void jLabel121MouseClicked(MouseEvent evt) {
		System.out.println("jLabel121.mouseClicked, event="+evt);
		//TODO add your code for jLabel121.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel121.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel121.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel121.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel121.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel121.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(27,Apuesta.tipoAp.NUMERO);
			}
		}
	}

	//30
	private void jLabel123MouseClicked(MouseEvent evt) {
		System.out.println("jLabel123.mouseClicked, event="+evt);
		//TODO add your code for jLabel123.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel123.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel123.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel123.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel123.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel123.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(30,Apuesta.tipoAp.NUMERO);
			}
		}
	}

		//33
	private void jLabel125MouseClicked(MouseEvent evt) {
		System.out.println("jLabel125.mouseClicked, event="+evt);
		//TODO add your code for jLabel125.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel125.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel125.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel125.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel125.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel125.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(33,Apuesta.tipoAp.NUMERO);
			}
		}
	}

	//36
	private void jLabel127MouseClicked(MouseEvent evt) {
		System.out.println("jLabel127.mouseClicked, event="+evt);
		//TODO add your code for jLabel127.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel127.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel127.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel127.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel127.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel127.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(36,Apuesta.tipoAp.NUMERO);
			}
		}
	}
	//25
	private void jLabel128MouseClicked(MouseEvent evt) {
		System.out.println("jLabel128.mouseClicked, event="+evt);
		//TODO add your code for jLabel128.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel128.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel128.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel128.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel128.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel128.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(25,Apuesta.tipoAp.NUMERO);
			}
		}
	}

	//28
	private void jLabel130MouseClicked(MouseEvent evt) {
		System.out.println("jLabel130.mouseClicked, event="+evt);
		//TODO add your code for jLabel130.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel130.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel130.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel130.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel130.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel130.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(28,Apuesta.tipoAp.NUMERO);
			}
		}
	}

	//31
	private void jLabel132MouseClicked(MouseEvent evt) {
		System.out.println("jLabel132.mouseClicked, event="+evt);
		//TODO add your code for jLabel132.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel132.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel132.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel132.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel132.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel132.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(31,Apuesta.tipoAp.NUMERO);
			}
		}
	}


	//34
	private void jLabel134MouseClicked(MouseEvent evt) {
		System.out.println("jLabel134.mouseClicked, event="+evt);
		//TODO add your code for jLabel134.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel134.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel134.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel134.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel134.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel134.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(34,Apuesta.tipoAp.NUMERO);
			}
		}
	}


	//31-32-35-34
	 private void jLabel136MouseClicked(MouseEvent evt) {
		System.out.println("jLabel136.mouseClicked, event="+evt);
		//TODO add your code for jLabel136.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel136.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel136.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel136.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel136.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel136.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(21,Apuesta.tipoAp.CUADRO);
			}
		}
	}
	//28-29-31-32
	private void jLabel138MouseClicked(MouseEvent evt) {
		System.out.println("jLabel138.mouseClicked, event="+evt);
		//TODO add your code for jLabel138.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel138.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel138.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel138.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel138.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel138.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(19,Apuesta.tipoAp.CUADRO);
			}
		}
	}

	//25-26-28-29
	private void jLabel140MouseClicked(MouseEvent evt) {
		System.out.println("jLabel140.mouseClicked, event="+evt);
		//TODO add your code for jLabel140.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel140.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel140.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel140.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel140.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel140.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(17,Apuesta.tipoAp.CUADRO);
			}
		}
	}

	//26
	private void jLabel142MouseClicked(MouseEvent evt) {
		System.out.println("jLabel142.mouseClicked, event="+evt);
		//TODO add your code for jLabel142.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel142.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel142.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel142.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel142.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel142.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(26,Apuesta.tipoAp.NUMERO);
			}
		}
	}


	//29
	private void jLabel144MouseClicked(MouseEvent evt) {
		System.out.println("jLabel144.mouseClicked, event="+evt);
		//TODO add your code for jLabel144.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel144.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel144.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel144.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel144.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel144.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(29,Apuesta.tipoAp.NUMERO);
			}
		}
	}

	//32
	private void jLabel146MouseClicked(MouseEvent evt) {
		System.out.println("jLabel146.mouseClicked, event="+evt);
		//TODO add your code for jLabel146.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel146.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel146.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel146.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel146.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel146.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(32,Apuesta.tipoAp.NUMERO);
			}
		}
	}

	//35
	private void jLabel148MouseClicked(MouseEvent evt) {
		System.out.println("jLabel148.mouseClicked, event="+evt);
		//TODO add your code for jLabel148.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel148.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel148.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel148.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel148.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel148.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(35,Apuesta.tipoAp.NUMERO);
			}
		}
	}
	//APUESTA FILA3
	private void jLabel149MouseClicked(MouseEvent evt) {
		System.out.println("jLabel149.mouseClicked, event="+evt);
		//TODO add your code for jLabel149.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel149.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel149.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel149.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel149.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel149.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(3,Apuesta.tipoAp.LINEA);
			}
		}
	}
	//APUESTA FILA2
	private void jLabel150MouseClicked(MouseEvent evt) {
		System.out.println("jLabel150.mouseClicked, event="+evt);
		//TODO add your code for jLabel150.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel150.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel150.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel150.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel150.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel150.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(2,Apuesta.tipoAp.LINEA);
			}
		}
	}
	//APUESTA FILA1
	private void jLabel151MouseClicked(MouseEvent evt) {
		System.out.println("jLabel151.mouseClicked, event="+evt);
		//TODO add your code for jLabel151.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel151.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel151.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel151.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel151.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel151.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(1,Apuesta.tipoAp.LINEA);
			}
		}
	}
	//APUESTA 1ºDOCENA
	private void jLabel152MouseClicked(MouseEvent evt) {
		System.out.println("jLabel152.mouseClicked, event="+evt);
		//TODO add your code for jLabel152.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel152.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel152.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel152.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel152.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel152.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(1,Apuesta.tipoAp.DOCENA);
			}
		}
	}
	//APUESTA 2ºDOCENA
	private void jLabel153MouseClicked(MouseEvent evt) {
		System.out.println("jLabel153.mouseClicked, event="+evt);
		//TODO add your code for jLabel153.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel153.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel153.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel153.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel153.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel153.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(2,Apuesta.tipoAp.DOCENA);
			}
		}
	}
	//APUESTA 3ºDOCENA
	private void jLabel154MouseClicked(MouseEvent evt) {
		System.out.println("jLabel154.mouseClicked, event="+evt);
		//TODO add your code for jLabel154.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel154.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel154.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel154.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel154.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel154.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(3,Apuesta.tipoAp.DOCENA);
			}
		}
	}
	//APUESTA 1 AL 18
	private void jLabel155MouseClicked(MouseEvent evt) {
		System.out.println("jLabel155.mouseClicked, event="+evt);
		//TODO add your code for jLabel155.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel155.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel155.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel155.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel155.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel155.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(1,Apuesta.tipoAp.FALTAPASA);
			}
		}
	}
	//APUESTA PAR
	private void jLabel156MouseClicked(MouseEvent evt) {
		System.out.println("jLabel156.mouseClicked, event="+evt);
		//TODO add your code for jLabel156.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel156.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel156.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel156.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel156.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel156.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(2,Apuesta.tipoAp.PARIMPAR);
			}
		}
	}
	//APUESTA ROJO
	private void jLabel157MouseClicked(MouseEvent evt) {
		System.out.println("jLabel157.mouseClicked, event="+evt);
		//TODO add your code for jLabel157.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel157.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel157.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel157.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel157.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel157.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(1,Apuesta.tipoAp.COLOR);
			}
		}
	}
	//APUESTA NEGRO
	private void jLabel158MouseClicked(MouseEvent evt) {
		System.out.println("jLabel158.mouseClicked, event="+evt);
		//TODO add your code for jLabel158.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel158.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel158.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel158.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel158.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel158.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(2,Apuesta.tipoAp.COLOR);
			}
		}
	}
	//APUESTA IMPAR
	private void jLabel159MouseClicked(MouseEvent evt) {
		System.out.println("jLabel159.mouseClicked, event="+evt);
		//TODO add your code for jLabel159.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel159.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel159.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel159.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel159.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel159.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(1,Apuesta.tipoAp.PARIMPAR);
			}
		}
	}
	//APUESTA 19 AL 36
	private void jLabel160MouseClicked(MouseEvent evt) {
		System.out.println("jLabel160.mouseClicked, event="+evt);
		//TODO add your code for jLabel160.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel160.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/trasparente.png")));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel160.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ficha_roja.png")));
					if(mesa.dameFichaApuesta()==2)
						jLabel160.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_blanca.png")));
					if(mesa.dameFichaApuesta()==3)
						jLabel160.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha.png")));
					if(mesa.dameFichaApuesta()==4)
						jLabel160.setIcon(new ImageIcon(getClass().getClassLoader().getResource("./recursos/ficha_azul.png")));
				}

				mesa.casillaPulsada(2,Apuesta.tipoAp.FALTAPASA);
			}
		}
	}



}


