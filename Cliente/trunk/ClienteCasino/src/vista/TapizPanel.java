/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;


import java.awt.BorderLayout;

import java.awt.Dimension;

import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import modelo.Apuesta;






/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class TapizPanel extends javax.swing.JPanel {

	private ImageIcon imgFondo;
	private MesaPanel mesa;
    private static int ancho=393;
    private static int alto=286;
    private JLabel jLabel64;
    private JLabel jLabel91;
    private JLabel jLabel90;
    private JLabel jLabel89;
    private JLabel jLabel88;
    private JLabel jLabel87;
    private JLabel jLabel86;
    private JLabel jLabel85;
    private JLabel jLabel84;
    private JLabel jLabel83;
    private JLabel jLabel82;
    private JLabel jLabel81;
    private JLabel jLabel80;
    private JLabel jLabel79;
    private JLabel jLabel78;
    private JLabel jLabel77;
    private JLabel jLabel76;
    private JLabel jLabel75;
    private JLabel jLabel74;
    private JLabel jLabel73;
    private JLabel jLabel72;
    private JLabel jLabel71;
    private JLabel jLabel70;
    private JLabel jLabel69;
    private JLabel jLabel68;
    private JLabel jLabel67;
    private JLabel jLabel66;
    private JLabel jLabel65;
    private JLabel jLabel63;
    private JLabel jLabel62;
    private JLabel jLabel61;
    private JLabel jLabel60;
    private JLabel jLabel59;
    private JLabel jLabel58;
    private JLabel jLabel57;
    private JLabel jLabel56;
    private JLabel jLabel55;
    private JLabel jLabel54;
    private JLabel jLabel53;
    private JLabel jLabel52;
    private JLabel jLabel51;
    private JLabel jLabel50;
    private JLabel jLabel49;
    private JLabel jLabel48;
    private JLabel jLabel47;
    private JLabel jLabel46;
    private JLabel jLabel45;
    private JLabel jLabel44;
    private JLabel jLabel43;
    private JLabel jLabel42;
    private JLabel jLabel41;
    private JLabel jLabel40;
    private JLabel jLabel39;
    private JLabel jLabel38;
    private JLabel jLabel37;
    private JLabel jLabel36;
    private JLabel jLabel35;
    private JLabel jLabel34;
    private JLabel jLabel33;
    private JLabel jLabel32;
    private JLabel jLabel31;
    private JLabel jLabel30;
    private JLabel jLabel29;
    private JLabel jLabel28;
    private JLabel jLabel27;
    private JLabel jLabel26;
    private JLabel jLabel25;
    private JLabel jLabel24;
    private JLabel jLabel23;
    private JLabel jLabel22;
    private JLabel jLabel21;
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
    private JLabel jLabel147;
    private JLabel jLabel146;
    private JLabel jLabel145;
    private JLabel jLabel144;
    private JLabel jLabel143;
    private JLabel jLabel142;
    private JLabel jLabel141;
    private JLabel jLabel140;
    private JLabel jLabel139;
    private JLabel jLabel138;
    private JLabel jLabel137;
    private JLabel jLabel136;
    private JLabel jLabel135;
    private JLabel jLabel134;
    private JLabel jLabel133;
    private JLabel jLabel132;
    private JLabel jLabel131;
    private JLabel jLabel130;
    private JLabel jLabel129;
    private JLabel jLabel128;
    private JLabel jLabel127;
    private JLabel jLabel126;
    private JLabel jLabel125;
    private JLabel jLabel124;
    private JLabel jLabel123;
    private JLabel jLabel122;
    private JLabel jLabel121;
    private JLabel jLabel120;
    private JLabel jLabel119;
    private JLabel jLabel118;
    private JLabel jLabel117;
    private JLabel jLabel116;
    private JLabel jLabel115;
    private JLabel jLabel107;
    private JLabel jLabel114;
    private JLabel jLabel113;
    private JLabel jLabel112;
    private JLabel jLabel111;
    private JLabel jLabel110;
    private JLabel jLabel109;
    private JLabel jLabel108;
    private JLabel jLabel106;
    private JLabel jLabel105;
    private JLabel jLabel104;
    private JLabel jLabel103;
    private JLabel jLabel102;
    private JLabel jLabel101;
    private JLabel jLabel100;
    private JLabel jLabel99;
    private JLabel jLabel98;
    private JLabel jLabel97;
    private JLabel jLabel96;
    private JLabel jLabel95;
    private JLabel jLabel94;
    private JLabel jLabel93;
    private JLabel jLabel92;
    private JLabel jLabel20;
    private JLabel jLabel19;
    private JLabel jLabel18;
    private JLabel jLabel17;
    private JLabel jLabel16;
    private JLabel jLabel15;
    private JLabel jLabel14;
    private JLabel jLabel13;
    private JLabel jLabel12;
    private JLabel jLabel11;
    private JLabel jLabel10;
    private JLabel jLabel9;
    private JLabel jLabel8;
    private JLabel jLabel5;
    private JLabel jLabel7;
    private JLabel jLabel6;
    private JLabel jLabel4;
    private JLabel jLabel3;
    private JLabel jLabel2;
    private JLabel jLabel1;
    private JLabel apuesta3_2;
    private JLabel apuesta0_0;
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
        imgFondo = new ImageIcon("./recursos/tapete.png");
}
    public void paintComponent(Graphics g) {
		   if (imgFondo != null) {
		                g.drawImage(imgFondo.getImage(), 0, 0, ancho, alto, this);
		            }

		  }

	private void initGUI() {
		try {

			this.setLayout(null);
			setPreferredSize(new Dimension(ancho,alto));
			{
				apuesta0_0 = new JLabel();
				this.add(apuesta0_0);
				apuesta0_0.setIcon(new ImageIcon("./recursos/trasparente.png"));
				apuesta0_0.setBounds(46, 57, 17, 19);
				apuesta0_0.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						apuesta0_0MouseClicked(evt);
					}
				});
			}
			{
				apuesta3_2 = new JLabel();
				this.add(apuesta3_2);
				apuesta3_2.setIcon(new ImageIcon("./recursos/trasparente.png"));
				apuesta3_2.setBounds(66, 68, 16, 18);
				apuesta3_2.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						apuesta3_2MouseClicked(evt);
					}
				});
			}
			{
				jLabel1 = new JLabel();
				this.add(jLabel1);
				jLabel1.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel1.setBounds(66, 50, 16, 18);
				jLabel1.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel1MouseClicked(evt);
					}
				});
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2);
				jLabel2.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel2.setBounds(79, 50, 16, 18);
				jLabel2.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel2MouseClicked(evt);
					}
				});
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3);
				jLabel3.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel3.setBounds(66, 87, 16, 18);
				jLabel3.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel3MouseClicked(evt);
					}
				});
			}
			{
				jLabel4 = new JLabel();
				this.add(jLabel4);
				jLabel4.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel4.setBounds(66, 107, 16, 18);
				jLabel4.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel4MouseClicked(evt);
					}
				});
			}
			{
				jLabel5 = new JLabel();
				this.add(jLabel5);
				jLabel5.setIcon(new ImageIcon("./recursos/trasparente.png"));
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
				jLabel6.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel6.setBounds(44, 112, 16, 18);
				jLabel6.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel6MouseClicked(evt);
					}
				});
			}
			{
				jLabel7 = new JLabel();
				this.add(jLabel7);
				jLabel7.setIcon(new ImageIcon("./recursos/trasparente.png"));
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
				jLabel8.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel8.setBounds(79, 69, 16, 18);
				jLabel8.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel8MouseClicked(evt);
					}
				});
			}
			{
				jLabel9 = new JLabel();
				this.add(jLabel9);
				jLabel9.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel9.setBounds(92, 69, 16, 18);
				jLabel9.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel9MouseClicked(evt);
					}
				});
			}
			{
				jLabel10 = new JLabel();
				this.add(jLabel10);
				jLabel10.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel10.setBounds(80, 87, 16, 18);
				jLabel10.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel10MouseClicked(evt);
					}
				});
			}
			{
				jLabel11 = new JLabel();
				this.add(jLabel11);
				jLabel11.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel11.setBounds(92, 86, 16, 18);
				jLabel11.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel11MouseClicked(evt);
					}
				});
			}
			{
				jLabel12 = new JLabel();
				this.add(jLabel12);
				jLabel12.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel12.setBounds(92, 106, 16, 18);
				jLabel12.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel12MouseClicked(evt);
					}
				});
			}
			{
				jLabel13 = new JLabel();
				this.add(jLabel13);
				jLabel13.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel13.setBounds(78, 106, 16, 18);
				jLabel13.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel13MouseClicked(evt);
					}
				});
			}
			{
				jLabel14 = new JLabel();
				this.add(jLabel14);
				jLabel14.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel14.setBounds(79, 123, 16, 18);
				jLabel14.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel14MouseClicked(evt);
					}
				});
			}
			{
				jLabel15 = new JLabel();
				this.add(jLabel15);
				jLabel15.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel15.setBounds(93, 123, 16, 18);
				jLabel15.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel15MouseClicked(evt);
					}
				});
			}
			{
				jLabel16 = new JLabel();
				this.add(jLabel16);
				jLabel16.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel16.setBounds(105, 123, 16, 18);
				jLabel16.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel16MouseClicked(evt);
					}
				});
			}
			{
				jLabel17 = new JLabel();
				this.add(jLabel17);
				jLabel17.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel17.setBounds(104, 106, 16, 18);
				jLabel17.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel17MouseClicked(evt);
					}
				});
			}
			{
				jLabel18 = new JLabel();
				this.add(jLabel18);
				jLabel18.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel18.setBounds(105, 86, 16, 18);
				jLabel18.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel18MouseClicked(evt);
					}
				});
			}
			{
				jLabel19 = new JLabel();
				this.add(jLabel19);
				jLabel19.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel19.setBounds(103, 69, 16, 18);
				jLabel19.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel19MouseClicked(evt);
					}
				});
			}
			{
				jLabel20 = new JLabel();
				this.add(jLabel20);
				jLabel20.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel20.setBounds(105, 50, 16, 18);
				jLabel20.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel20MouseClicked(evt);
					}
				});
			}
			{
				jLabel21 = new JLabel();
				this.add(jLabel21);
				jLabel21.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel21.setBounds(150, 123, 16, 18);
				jLabel21.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel21MouseClicked(evt);
					}
				});
			}
			{
				jLabel22 = new JLabel();
				this.add(jLabel22);
				jLabel22.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel22.setBounds(139, 123, 16, 18);
				jLabel22.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel22MouseClicked(evt);
					}
				});
			}
			{
				jLabel23 = new JLabel();
				this.add(jLabel23);
				jLabel23.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel23.setBounds(128, 123, 16, 18);
				jLabel23.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel23MouseClicked(evt);
					}
				});
			}
			{
				jLabel24 = new JLabel();
				this.add(jLabel24);
				jLabel24.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel24.setBounds(117, 123, 16, 18);
				jLabel24.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel24MouseClicked(evt);
					}
				});
			}
			{
				jLabel25 = new JLabel();
				this.add(jLabel25);
				jLabel25.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel25.setBounds(116, 106, 16, 18);
				jLabel25.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel25MouseClicked(evt);
					}
				});
			}
			{
				jLabel26 = new JLabel();
				this.add(jLabel26);
				jLabel26.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel26.setBounds(127, 106, 16, 18);
				jLabel26.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel26MouseClicked(evt);
					}
				});
			}
			{
				jLabel27 = new JLabel();
				this.add(jLabel27);
				jLabel27.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel27.setBounds(139, 106, 16, 18);
				jLabel27.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel27MouseClicked(evt);
					}
				});
			}
			{
				jLabel28 = new JLabel();
				this.add(jLabel28);
				jLabel28.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel28.setBounds(150, 106, 16, 18);
				jLabel28.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel28MouseClicked(evt);
					}
				});
			}
			{
				jLabel29 = new JLabel();
				this.add(jLabel29);
				jLabel29.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel29.setBounds(150, 86, 16, 18);
				jLabel29.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel29MouseClicked(evt);
					}
				});
			}
			{
				jLabel30 = new JLabel();
				this.add(jLabel30);
				jLabel30.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel30.setBounds(138, 86, 16, 18);
				jLabel30.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel30MouseClicked(evt);
					}
				});
			}
			{
				jLabel31 = new JLabel();
				this.add(jLabel31);
				jLabel31.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel31.setBounds(127, 86, 16, 18);
				jLabel31.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel31MouseClicked(evt);
					}
				});
			}
			{
				jLabel32 = new JLabel();
				this.add(jLabel32);
				jLabel32.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel32.setBounds(115, 86, 16, 18);
				jLabel32.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel32MouseClicked(evt);
					}
				});
			}
			{
				jLabel33 = new JLabel();
				this.add(jLabel33);
				jLabel33.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel33.setBounds(114, 69, 16, 18);
				jLabel33.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel33MouseClicked(evt);
					}
				});
			}
			{
				jLabel34 = new JLabel();
				this.add(jLabel34);
				jLabel34.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel34.setBounds(124, 69, 16, 18);
				jLabel34.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel34MouseClicked(evt);
					}
				});
			}
			{
				jLabel35 = new JLabel();
				this.add(jLabel35);
				jLabel35.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel35.setBounds(136, 69, 16, 18);
				jLabel35.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel35MouseClicked(evt);
					}
				});
			}
			{
				jLabel36 = new JLabel();
				this.add(jLabel36);
				jLabel36.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel36.setBounds(149, 69, 16, 18);
				jLabel36.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel36MouseClicked(evt);
					}
				});
			}
			{
				jLabel37 = new JLabel();
				this.add(jLabel37);
				jLabel37.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel37.setBounds(149, 50, 16, 18);
				jLabel37.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel37MouseClicked(evt);
					}
				});
			}
			{
				jLabel38 = new JLabel();
				this.add(jLabel38);
				jLabel38.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel38.setBounds(138, 50, 16, 18);
				jLabel38.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel38MouseClicked(evt);
					}
				});
			}
			{
				jLabel39 = new JLabel();
				this.add(jLabel39);
				jLabel39.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel39.setBounds(127, 50, 16, 18);
				jLabel39.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel39MouseClicked(evt);
					}
				});
			}
			{
				jLabel40 = new JLabel();
				this.add(jLabel40);
				jLabel40.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel40.setBounds(116, 50, 16, 18);
				jLabel40.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel40MouseClicked(evt);
					}
				});
			}
			{
				jLabel41 = new JLabel();
				this.add(jLabel41);
				jLabel41.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel41.setBounds(240, 50, 16, 18);
				jLabel41.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel41MouseClicked(evt);
					}
				});
			}
			{
				jLabel42 = new JLabel();
				this.add(jLabel42);
				jLabel42.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel42.setBounds(229, 50, 16, 18);
				jLabel42.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel42MouseClicked(evt);
					}
				});
			}
			{
				jLabel43 = new JLabel();
				this.add(jLabel43);
				jLabel43.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel43.setBounds(218, 50, 16, 18);
				jLabel43.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel43MouseClicked(evt);
					}
				});
			}
			{
				jLabel44 = new JLabel();
				this.add(jLabel44);
				jLabel44.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel44.setBounds(207, 50, 16, 18);
				jLabel44.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel44MouseClicked(evt);
					}
				});
			}
			{
				jLabel45 = new JLabel();
				this.add(jLabel45);
				jLabel45.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel45.setBounds(196, 50, 16, 18);
				jLabel45.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel45MouseClicked(evt);
					}
				});
			}
			{
				jLabel46 = new JLabel();
				this.add(jLabel46);
				jLabel46.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel46.setBounds(184, 49, 16, 18);
				jLabel46.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel46MouseClicked(evt);
					}
				});
			}
			{
				jLabel47 = new JLabel();
				this.add(jLabel47);
				jLabel47.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel47.setBounds(172, 49, 16, 18);
				jLabel47.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel47MouseClicked(evt);
					}
				});
			}
			{
				jLabel48 = new JLabel();
				this.add(jLabel48);
				jLabel48.setIcon(new ImageIcon("./recursos/trasparente.png"));
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
				jLabel49.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel49.setBounds(240, 70, 16, 18);
				jLabel49.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel49MouseClicked(evt);
					}
				});
			}
			{
				jLabel50 = new JLabel();
				this.add(jLabel50);
				jLabel50.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel50.setBounds(229, 70, 16, 18);
				jLabel50.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel50MouseClicked(evt);
					}
				});
			}
			{
				jLabel51 = new JLabel();
				this.add(jLabel51);
				jLabel51.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel51.setBounds(218, 70, 16, 18);
				jLabel51.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel51MouseClicked(evt);
					}
				});
			}
			{
				jLabel52 = new JLabel();
				this.add(jLabel52);
				jLabel52.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel52.setBounds(207, 70, 16, 18);
				jLabel52.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel52MouseClicked(evt);
					}
				});
			}
			{
				jLabel53 = new JLabel();
				this.add(jLabel53);
				jLabel53.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel53.setBounds(196, 70, 16, 18);
				jLabel53.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel53MouseClicked(evt);
					}
				});
			}
			{
				jLabel54 = new JLabel();
				this.add(jLabel54);
				jLabel54.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel54.setBounds(184, 69, 16, 18);
				jLabel54.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel54MouseClicked(evt);
					}
				});
			}
			{
				jLabel55 = new JLabel();
				this.add(jLabel55);
				jLabel55.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel55.setBounds(172, 69, 16, 18);
				jLabel55.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel55MouseClicked(evt);
					}
				});
			}
			{
				jLabel56 = new JLabel();
				this.add(jLabel56);
				jLabel56.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel56.setBounds(161, 69, 16, 18);
				jLabel56.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel56MouseClicked(evt);
					}
				});
			}
			{
				jLabel57 = new JLabel();
				this.add(jLabel57);
				jLabel57.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel57.setBounds(161, 86, 16, 18);
				jLabel57.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel57MouseClicked(evt);
					}
				});
			}
			{
				jLabel58 = new JLabel();
				this.add(jLabel58);
				jLabel58.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel58.setBounds(240, 86, 16, 18);
				jLabel58.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel58MouseClicked(evt);
					}
				});
			}
			{
				jLabel59 = new JLabel();
				this.add(jLabel59);
				jLabel59.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel59.setBounds(229, 86, 16, 18);
				jLabel59.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel59MouseClicked(evt);
					}
				});
			}
			{
				jLabel60 = new JLabel();
				this.add(jLabel60);
				jLabel60.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel60.setBounds(218, 86, 16, 18);
				jLabel60.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel60MouseClicked(evt);
					}
				});
			}
			{
				jLabel61 = new JLabel();
				this.add(jLabel61);
				jLabel61.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel61.setBounds(207, 86, 16, 18);
				jLabel61.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel61MouseClicked(evt);
					}
				});
			}
			{
				jLabel62 = new JLabel();
				this.add(jLabel62);
				jLabel62.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel62.setBounds(196, 86, 16, 18);
				jLabel62.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel62MouseClicked(evt);
					}
				});
			}
			{
				jLabel63 = new JLabel();
				this.add(jLabel63);
				jLabel63.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel63.setBounds(185, 86, 16, 18);
				jLabel63.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel63MouseClicked(evt);
					}
				});
			}
			{
				jLabel64 = new JLabel();
				this.add(jLabel64);
				jLabel64.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel64.setBounds(172, 86, 16, 18);
				jLabel64.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel64MouseClicked(evt);
					}
				});
			}
			{
				jLabel65 = new JLabel();
				this.add(jLabel65);
				jLabel65.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel65.setBounds(239, 106, 16, 18);
				jLabel65.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel65MouseClicked(evt);
					}
				});
			}
			{
				jLabel66 = new JLabel();
				this.add(jLabel66);
				jLabel66.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel66.setBounds(228, 106, 16, 18);
				jLabel66.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel66MouseClicked(evt);
					}
				});
			}
			{
				jLabel67 = new JLabel();
				this.add(jLabel67);
				jLabel67.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel67.setBounds(217, 106, 16, 18);
				jLabel67.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel67MouseClicked(evt);
					}
				});
			}
			{
				jLabel68 = new JLabel();
				this.add(jLabel68);
				jLabel68.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel68.setBounds(206, 106, 16, 18);
				jLabel68.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel68MouseClicked(evt);
					}
				});
			}
			{
				jLabel69 = new JLabel();
				this.add(jLabel69);
				jLabel69.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel69.setBounds(195, 106, 16, 18);
				jLabel69.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel69MouseClicked(evt);
					}
				});
			}
			{
				jLabel70 = new JLabel();
				this.add(jLabel70);
				jLabel70.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel70.setBounds(183, 106, 16, 18);
				jLabel70.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel70MouseClicked(evt);
					}
				});
			}
			{
				jLabel71 = new JLabel();
				this.add(jLabel71);
				jLabel71.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel71.setBounds(171, 106, 16, 18);
				jLabel71.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel71MouseClicked(evt);
					}
				});
			}
			{
				jLabel72 = new JLabel();
				this.add(jLabel72);
				jLabel72.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel72.setBounds(160, 106, 16, 18);
				jLabel72.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel72MouseClicked(evt);
					}
				});
			}
			{
				jLabel73 = new JLabel();
				this.add(jLabel73);
				jLabel73.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel73.setBounds(239, 123, 16, 18);
				jLabel73.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel73MouseClicked(evt);
					}
				});
			}
			{
				jLabel74 = new JLabel();
				this.add(jLabel74);
				jLabel74.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel74.setBounds(228, 123, 16, 18);
				jLabel74.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel74MouseClicked(evt);
					}
				});
			}
			{
				jLabel75 = new JLabel();
				this.add(jLabel75);
				jLabel75.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel75.setBounds(217, 123, 16, 18);
				jLabel75.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel75MouseClicked(evt);
					}
				});
			}
			{
				jLabel76 = new JLabel();
				this.add(jLabel76);
				jLabel76.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel76.setBounds(206, 123, 16, 18);
				jLabel76.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel76MouseClicked(evt);
					}
				});
			}
			{
				jLabel77 = new JLabel();
				this.add(jLabel77);
				jLabel77.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel77.setBounds(195, 123, 16, 18);
				jLabel77.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel77MouseClicked(evt);
					}
				});
			}
			{
				jLabel78 = new JLabel();
				this.add(jLabel78);
				jLabel78.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel78.setBounds(183, 123, 16, 18);
				jLabel78.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel78MouseClicked(evt);
					}
				});
			}
			{
				jLabel79 = new JLabel();
				this.add(jLabel79);
				jLabel79.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel79.setBounds(171, 123, 16, 18);
				jLabel79.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel79MouseClicked(evt);
					}
				});
			}
			{
				jLabel80 = new JLabel();
				this.add(jLabel80);
				jLabel80.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel80.setBounds(160, 123, 16, 18);
				jLabel80.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel80MouseClicked(evt);
					}
				});
			}
			{
				jLabel81 = new JLabel();
				this.add(jLabel81);
				jLabel81.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel81.setBounds(239, 123, 16, 18);
				jLabel81.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel81MouseClicked(evt);
					}
				});
			}
			{
				jLabel82 = new JLabel();
				this.add(jLabel82);
				jLabel82.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel82.setBounds(228, 123, 16, 18);
				jLabel82.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel82MouseClicked(evt);
					}
				});
			}
			{
				jLabel83 = new JLabel();
				this.add(jLabel83);
				jLabel83.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel83.setBounds(217, 123, 16, 18);
				jLabel83.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel83MouseClicked(evt);
					}
				});
			}
			{
				jLabel84 = new JLabel();
				this.add(jLabel84);
				jLabel84.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel84.setBounds(206, 123, 16, 18);
				jLabel84.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel84MouseClicked(evt);
					}
				});
			}
			{
				jLabel85 = new JLabel();
				this.add(jLabel85);
				jLabel85.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel85.setBounds(195, 123, 16, 18);
				jLabel85.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel85MouseClicked(evt);
					}
				});
			}
			{
				jLabel86 = new JLabel();
				this.add(jLabel86);
				jLabel86.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel86.setBounds(183, 123, 16, 18);
				jLabel86.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel86MouseClicked(evt);
					}
				});
			}
			{
				jLabel87 = new JLabel();
				this.add(jLabel87);
				jLabel87.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel87.setBounds(171, 123, 16, 18);
				jLabel87.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel87MouseClicked(evt);
					}
				});
			}
			{
				jLabel88 = new JLabel();
				this.add(jLabel88);
				jLabel88.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel88.setBounds(239, 106, 16, 18);
				jLabel88.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel88MouseClicked(evt);
					}
				});
			}
			{
				jLabel89 = new JLabel();
				this.add(jLabel89);
				jLabel89.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel89.setBounds(228, 106, 16, 18);
				jLabel89.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel89MouseClicked(evt);
					}
				});
			}
			{
				jLabel90 = new JLabel();
				this.add(jLabel90);
				jLabel90.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel90.setBounds(217, 106, 16, 18);
				jLabel90.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel90MouseClicked(evt);
					}
				});
			}
			{
				jLabel91 = new JLabel();
				this.add(jLabel91);
				jLabel91.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel91.setBounds(206, 106, 16, 18);
				jLabel91.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel91MouseClicked(evt);
					}
				});
			}
			{
				jLabel92 = new JLabel();
				this.add(jLabel92);
				jLabel92.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel92.setBounds(195, 106, 16, 18);
				jLabel92.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel92MouseClicked(evt);
					}
				});
			}
			{
				jLabel93 = new JLabel();
				this.add(jLabel93);
				jLabel93.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel93.setBounds(183, 106, 16, 18);
				jLabel93.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel93MouseClicked(evt);
					}
				});
			}
			{
				jLabel94 = new JLabel();
				this.add(jLabel94);
				jLabel94.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel94.setBounds(171, 106, 16, 18);
				jLabel94.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel94MouseClicked(evt);
					}
				});
			}
			{
				jLabel95 = new JLabel();
				this.add(jLabel95);
				jLabel95.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel95.setBounds(172, 86, 16, 18);
				jLabel95.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel95MouseClicked(evt);
					}
				});
			}
			{
				jLabel96 = new JLabel();
				this.add(jLabel96);
				jLabel96.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel96.setBounds(185, 86, 16, 18);
				jLabel96.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel96MouseClicked(evt);
					}
				});
			}
			{
				jLabel97 = new JLabel();
				this.add(jLabel97);
				jLabel97.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel97.setBounds(207, 86, 16, 18);
				jLabel97.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel97MouseClicked(evt);
					}
				});
			}
			{
				jLabel98 = new JLabel();
				this.add(jLabel98);
				jLabel98.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel98.setBounds(196, 86, 16, 18);
				jLabel98.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel98MouseClicked(evt);
					}
				});
			}
			{
				jLabel99 = new JLabel();
				this.add(jLabel99);
				jLabel99.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel99.setBounds(218, 86, 16, 18);
				jLabel99.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel99MouseClicked(evt);
					}
				});
			}
			{
				jLabel100 = new JLabel();
				this.add(jLabel100);
				jLabel100.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel100.setBounds(229, 86, 16, 18);
				jLabel100.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel100MouseClicked(evt);
					}
				});
			}
			{
				jLabel101 = new JLabel();
				this.add(jLabel101);
				jLabel101.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel101.setBounds(240, 86, 16, 18);
				jLabel101.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel101MouseClicked(evt);
					}
				});
			}
			{
				jLabel102 = new JLabel();
				this.add(jLabel102);
				jLabel102.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel102.setBounds(240, 70, 16, 18);
				jLabel102.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel102MouseClicked(evt);
					}
				});
			}
			{
				jLabel103 = new JLabel();
				this.add(jLabel103);
				jLabel103.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel103.setBounds(229, 70, 16, 18);
				jLabel103.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel103MouseClicked(evt);
					}
				});
			}
			{
				jLabel104 = new JLabel();
				this.add(jLabel104);
				jLabel104.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel104.setBounds(218, 70, 16, 18);
				jLabel104.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel104MouseClicked(evt);
					}
				});
			}
			{
				jLabel105 = new JLabel();
				this.add(jLabel105);
				jLabel105.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel105.setBounds(207, 70, 16, 18);
				jLabel105.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel105MouseClicked(evt);
					}
				});
			}
			{
				jLabel106 = new JLabel();
				this.add(jLabel106);
				jLabel106.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel106.setBounds(196, 70, 16, 18);
				jLabel106.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel106MouseClicked(evt);
					}
				});
			}
			{
				jLabel108 = new JLabel();
				this.add(jLabel108);
				jLabel108.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel108.setBounds(172, 69, 16, 18);
				jLabel108.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel108MouseClicked(evt);
					}
				});
			}
			{
				jLabel109 = new JLabel();
				this.add(jLabel109);
				jLabel109.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel109.setBounds(172, 49, 16, 18);
				jLabel109.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel109MouseClicked(evt);
					}
				});
			}
			{
				jLabel110 = new JLabel();
				this.add(jLabel110);
				jLabel110.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel110.setBounds(184, 49, 16, 18);
				jLabel110.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel110MouseClicked(evt);
					}
				});
			}
			{
				jLabel111 = new JLabel();
				this.add(jLabel111);
				jLabel111.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel111.setBounds(196, 50, 16, 18);
				jLabel111.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel111MouseClicked(evt);
					}
				});
			}
			{
				jLabel112 = new JLabel();
				this.add(jLabel112);
				jLabel112.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel112.setBounds(207, 50, 16, 18);
				jLabel112.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel112MouseClicked(evt);
					}
				});
			}
			{
				jLabel113 = new JLabel();
				this.add(jLabel113);
				jLabel113.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel113.setBounds(218, 50, 16, 18);
				jLabel113.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel113MouseClicked(evt);
					}
				});
			}
			{
				jLabel114 = new JLabel();
				this.add(jLabel114);
				jLabel114.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel114.setBounds(229, 50, 16, 18);
				jLabel114.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel114MouseClicked(evt);
					}
				});
			}
			{
				jLabel107 = new JLabel();
				this.add(jLabel107);
				jLabel107.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel107.setBounds(251, 70, 16, 18);
				jLabel107.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel107MouseClicked(evt);
					}
				});
			}
			{
				jLabel115 = new JLabel();
				this.add(jLabel115);
				jLabel115.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel115.setBounds(263, 70, 16, 18);
				jLabel115.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel115MouseClicked(evt);
					}
				});
			}
			{
				jLabel116 = new JLabel();
				this.add(jLabel116);
				jLabel116.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel116.setBounds(275, 71, 16, 18);
				jLabel116.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel116MouseClicked(evt);
					}
				});
			}
			{
				jLabel117 = new JLabel();
				this.add(jLabel117);
				jLabel117.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel117.setBounds(286, 71, 16, 18);
				jLabel117.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel117MouseClicked(evt);
					}
				});
			}
			{
				jLabel118 = new JLabel();
				this.add(jLabel118);
				jLabel118.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel118.setBounds(297, 71, 16, 18);
				jLabel118.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel118MouseClicked(evt);
					}
				});
			}
			{
				jLabel119 = new JLabel();
				this.add(jLabel119);
				jLabel119.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel119.setBounds(308, 71, 16, 18);
				jLabel119.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel119MouseClicked(evt);
					}
				});
			}
			{
				jLabel120 = new JLabel();
				this.add(jLabel120);
				jLabel120.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel120.setBounds(319, 71, 16, 18);
				jLabel120.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel120MouseClicked(evt);
					}
				});
			}
			{
				jLabel121 = new JLabel();
				this.add(jLabel121);
				jLabel121.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel121.setBounds(251, 50, 16, 18);
				jLabel121.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel121MouseClicked(evt);
					}
				});
			}
			{
				jLabel122 = new JLabel();
				this.add(jLabel122);
				jLabel122.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel122.setBounds(263, 50, 16, 18);
				jLabel122.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel122MouseClicked(evt);
					}
				});
			}
			{
				jLabel123 = new JLabel();
				this.add(jLabel123);
				jLabel123.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel123.setBounds(275, 51, 16, 18);
				jLabel123.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel123MouseClicked(evt);
					}
				});
			}
			{
				jLabel124 = new JLabel();
				this.add(jLabel124);
				jLabel124.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel124.setBounds(286, 51, 16, 18);
				jLabel124.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel124MouseClicked(evt);
					}
				});
			}
			{
				jLabel125 = new JLabel();
				this.add(jLabel125);
				jLabel125.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel125.setBounds(297, 51, 16, 18);
				jLabel125.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel125MouseClicked(evt);
					}
				});
			}
			{
				jLabel126 = new JLabel();
				this.add(jLabel126);
				jLabel126.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel126.setBounds(308, 51, 16, 18);
				jLabel126.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel126MouseClicked(evt);
					}
				});
			}
			{
				jLabel127 = new JLabel();
				this.add(jLabel127);
				jLabel127.setIcon(new ImageIcon("./recursos/trasparente.png"));
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
				jLabel128.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel128.setBounds(251, 123, 16, 18);
				jLabel128.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel128MouseClicked(evt);
					}
				});
			}
			{
				jLabel129 = new JLabel();
				this.add(jLabel129);
				jLabel129.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel129.setBounds(263, 123, 16, 18);
				jLabel129.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel129MouseClicked(evt);
					}
				});
			}
			{
				jLabel130 = new JLabel();
				this.add(jLabel130);
				jLabel130.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel130.setBounds(275, 123, 16, 18);
				jLabel130.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel130MouseClicked(evt);
					}
				});
			}
			{
				jLabel131 = new JLabel();
				this.add(jLabel131);
				jLabel131.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel131.setBounds(286, 123, 16, 18);
				jLabel131.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel131MouseClicked(evt);
					}
				});
			}
			{
				jLabel132 = new JLabel();
				this.add(jLabel132);
				jLabel132.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel132.setBounds(297, 123, 16, 18);
				jLabel132.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel132MouseClicked(evt);
					}
				});
			}
			{
				jLabel133 = new JLabel();
				this.add(jLabel133);
				jLabel133.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel133.setBounds(308, 123, 16, 18);
				jLabel133.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel133MouseClicked(evt);
					}
				});
			}
			{
				jLabel134 = new JLabel();
				this.add(jLabel134);
				jLabel134.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel134.setBounds(319, 123, 16, 18);
				jLabel134.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel134MouseClicked(evt);
					}
				});
			}
			{
				jLabel135 = new JLabel();
				this.add(jLabel135);
				jLabel135.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel135.setBounds(319, 106, 16, 18);
				jLabel135.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel135MouseClicked(evt);
					}
				});
			}
			{
				jLabel136 = new JLabel();
				this.add(jLabel136);
				jLabel136.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel136.setBounds(308, 106, 16, 18);
				jLabel136.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel136MouseClicked(evt);
					}
				});
			}
			{
				jLabel137 = new JLabel();
				this.add(jLabel137);
				jLabel137.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel137.setBounds(297, 106, 16, 18);
				jLabel137.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel137MouseClicked(evt);
					}
				});
			}
			{
				jLabel138 = new JLabel();
				this.add(jLabel138);
				jLabel138.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel138.setBounds(286, 106, 16, 18);
				jLabel138.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel138MouseClicked(evt);
					}
				});
			}
			{
				jLabel139 = new JLabel();
				this.add(jLabel139);
				jLabel139.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel139.setBounds(275, 106, 16, 18);
				jLabel139.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel139MouseClicked(evt);
					}
				});
			}
			{
				jLabel140 = new JLabel();
				this.add(jLabel140);
				jLabel140.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel140.setBounds(263, 106, 16, 18);
				jLabel140.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel140MouseClicked(evt);
					}
				});
			}
			{
				jLabel141 = new JLabel();
				this.add(jLabel141);
				jLabel141.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel141.setBounds(251, 106, 16, 18);
				jLabel141.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel141MouseClicked(evt);
					}
				});
			}
			{
				jLabel142 = new JLabel();
				this.add(jLabel142);
				jLabel142.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel142.setBounds(252, 86, 16, 18);
				jLabel142.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel142MouseClicked(evt);
					}
				});
			}
			{
				jLabel143 = new JLabel();
				this.add(jLabel143);
				jLabel143.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel143.setBounds(265, 86, 16, 18);
				jLabel143.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel143MouseClicked(evt);
					}
				});
			}
			{
				jLabel144 = new JLabel();
				this.add(jLabel144);
				jLabel144.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel144.setBounds(276, 86, 16, 18);
				jLabel144.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel144MouseClicked(evt);
					}
				});
			}
			{
				jLabel145 = new JLabel();
				this.add(jLabel145);
				jLabel145.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel145.setBounds(287, 86, 16, 18);
				jLabel145.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel145MouseClicked(evt);
					}
				});
			}
			{
				jLabel146 = new JLabel();
				this.add(jLabel146);
				jLabel146.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel146.setBounds(298, 86, 16, 18);
				jLabel146.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel146MouseClicked(evt);
					}
				});
			}
			{
				jLabel147 = new JLabel();
				this.add(jLabel147);
				jLabel147.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel147.setBounds(309, 86, 16, 18);
				jLabel147.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel147MouseClicked(evt);
					}
				});
			}
			{
				jLabel148 = new JLabel();
				this.add(jLabel148);
				jLabel148.setIcon(new ImageIcon("./recursos/trasparente.png"));
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
				jLabel149.setIcon(new ImageIcon("./recursos/trasparente.png"));
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
				jLabel150.setIcon(new ImageIcon("./recursos/trasparente.png"));
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
				jLabel151.setIcon(new ImageIcon("./recursos/trasparente.png"));
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
				jLabel152.setIcon(new ImageIcon("./recursos/trasparente.png"));
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
				jLabel153.setIcon(new ImageIcon("./recursos/trasparente.png"));
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
				jLabel154.setIcon(new ImageIcon("./recursos/trasparente.png"));
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
				jLabel155.setIcon(new ImageIcon("./recursos/trasparente.png"));
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
				jLabel156.setIcon(new ImageIcon("./recursos/trasparente.png"));
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
				jLabel157.setIcon(new ImageIcon("./recursos/trasparente.png"));
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
				jLabel158.setIcon(new ImageIcon("./recursos/trasparente.png"));
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
				jLabel159.setIcon(new ImageIcon("./recursos/trasparente.png"));
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
				jLabel160.setIcon(new ImageIcon("./recursos/trasparente.png"));
				jLabel160.setBounds(306, 191, 27, 26);
				jLabel160.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel160MouseClicked(evt);
					}
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//APUESTA 00
	private void apuesta0_0MouseClicked(MouseEvent evt) {
		System.out.println("apuesta0_0.mouseClicked, event="+evt);
		//TODO add your code for apuesta0_0.mouseClicked
		apuesta0_0.setIcon(new ImageIcon("ficha.png"));


	}
	//APUESTA 3-2
	private void apuesta3_2MouseClicked(MouseEvent evt) {
		System.out.println("apuesta3_6.mouseClicked, event="+evt);
		//TODO add your code for apuesta3_6.mouseClicked
		apuesta3_2.setIcon(new ImageIcon("ficha.png"));
	}
	//APUESTA 3
	private void jLabel1MouseClicked(MouseEvent evt) {
		System.out.println("jLabel1.mouseClicked, event="+evt);
		//TODO add your code for jLabel1.mouseClicked
		jLabel1.setIcon(new ImageIcon("ficha.png"));
	}
	//APUESTA 3-6
	private void jLabel2MouseClicked(MouseEvent evt) {
		System.out.println("jLabel2.mouseClicked, event="+evt);
		//TODO add your code for jLabel2.mouseClicked
		jLabel2.setIcon(new ImageIcon("ficha.png"));
	}
	//APUESTA 2
	private void jLabel3MouseClicked(MouseEvent evt) {
		System.out.println("jLabel3.mouseClicked, event="+evt);
		//TODO add your code for jLabel3.mouseClicked
		jLabel3.setIcon(new ImageIcon("ficha.png"));
	}
	//APUESTA 2-1
	private void jLabel4MouseClicked(MouseEvent evt) {
		System.out.println("jLabel4.mouseClicked, event="+evt);
		//TODO add your code for jLabel4.mouseClicked

	}
	//APUESTA 1
	private void jLabel5MouseClicked(MouseEvent evt) {
		System.out.println("jLabel5.mouseClicked, event="+evt);
		//TODO add your code for jLabel5.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel5.setIcon(new ImageIcon("./recursos/trasparente.png"));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel5.setIcon(new ImageIcon("./recursos/ficha_roja.png"));
					if(mesa.dameFichaApuesta()==2)
						jLabel5.setIcon(new ImageIcon("./recursos/ficha_blanca.png"));
					if(mesa.dameFichaApuesta()==3)
						jLabel5.setIcon(new ImageIcon("./recursos/ficha.png"));
					if(mesa.dameFichaApuesta()==4)
						jLabel5.setIcon(new ImageIcon("./recursos/ficha_azul.png"));
				}

				mesa.casillaPulsada(1);
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
					jLabel6.setIcon(new ImageIcon("./recursos/trasparente.png"));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel6.setIcon(new ImageIcon("./recursos/ficha_roja.png"));
					if(mesa.dameFichaApuesta()==2)
						jLabel6.setIcon(new ImageIcon("./recursos/ficha_blanca.png"));
					if(mesa.dameFichaApuesta()==3)
						jLabel6.setIcon(new ImageIcon("./recursos/ficha.png"));
					if(mesa.dameFichaApuesta()==4)
						jLabel6.setIcon(new ImageIcon("./recursos/ficha_azul.png"));
				}

				mesa.casillaPulsada(0);
			}
		}
	}
	//APUESTA 6
	private void jLabel7MouseClicked(MouseEvent evt) {
		System.out.println("jLabel7.mouseClicked, event="+evt);
		//TODO add your code for jLabel7.mouseClicked
		jLabel7.setIcon(new ImageIcon("./recursos/ficha.png"));
	}
	//APUESTA 1-2-5-6
	private void jLabel8MouseClicked(MouseEvent evt) {
		System.out.println("jLabel8.mouseClicked, event="+evt);
		//TODO add your code for jLabel8.mouseClicked
		jLabel8.setIcon(new ImageIcon("./recursos/ficha.png"));
	}
	//APUESTA 5-6
	private void jLabel9MouseClicked(MouseEvent evt) {
		System.out.println("jLabel9.mouseClicked, event="+evt);
		//TODO add your code for jLabel9.mouseClicked
		jLabel9.setIcon(new ImageIcon("./recursos/ficha.png"));
	}
	//APUESTA 5-2
	private void jLabel10MouseClicked(MouseEvent evt) {
		System.out.println("jLabel10.mouseClicked, event="+evt);
		//TODO add your code for jLabel10.mouseClicked
		jLabel10.setIcon(new ImageIcon("./recursos/ficha.png"));
	}
	//APUESTA 5
	private void jLabel11MouseClicked(MouseEvent evt) {
		System.out.println("jLabel11.mouseClicked, event="+evt);
		//TODO add your code for jLabel11.mouseClicked
		jLabel11.setIcon(new ImageIcon("./recursos/ficha.png"));
	}
	//APUESTA 5-4
	private void jLabel12MouseClicked(MouseEvent evt) {
		System.out.println("jLabel12.mouseClicked, event="+evt);
		//TODO add your code for jLabel12.mouseClicked
		jLabel12.setIcon(new ImageIcon("./recursos/ficha.png"));
	}
	//APUESTA 1-2-5-4
	private void jLabel13MouseClicked(MouseEvent evt) {
		System.out.println("jLabel13.mouseClicked, event="+evt);
		//TODO add your code for jLabel13.mouseClicked
		jLabel13.setIcon(new ImageIcon("./recursos/ficha.png"));
	}
	//APUESTA 1-4
	private void jLabel14MouseClicked(MouseEvent evt) {
		System.out.println("jLabel14.mouseClicked, event="+evt);
		//TODO add your code for jLabel14.mouseClicked
		jLabel14.setIcon(new ImageIcon("./recursos/ficha.png"));
	}
	//APUESTA 4
	private void jLabel15MouseClicked(MouseEvent evt) {
		System.out.println("jLabel15.mouseClicked, event="+evt);
		//TODO add your code for jLabel15.mouseClicked
		jLabel15.setIcon(new ImageIcon("./recursos/ficha.png"));
	}
	//APUESTA 4-7
	private void jLabel16MouseClicked(MouseEvent evt) {
		System.out.println("jLabel16.mouseClicked, event="+evt);
		//TODO add your code for jLabel16.mouseClicked
		jLabel16.setIcon(new ImageIcon("./recursos/ficha.png"));
	}
	//APUESTA 5-8-4-7
	private void jLabel17MouseClicked(MouseEvent evt) {
		System.out.println("jLabel17.mouseClicked, event="+evt);
		//TODO add your code for jLabel17.mouseClicked
		jLabel17.setIcon(new ImageIcon("./recursos/ficha.png"));
	}
	//APUESTA 5-8
	private void jLabel18MouseClicked(MouseEvent evt) {
		System.out.println("jLabel18.mouseClicked, event="+evt);
		//TODO add your code for jLabel18.mouseClicked
		jLabel18.setIcon(new ImageIcon("./recursos/ficha.png"));
	}
	//APUESTA 6-9-5-8
	private void jLabel19MouseClicked(MouseEvent evt) {
		System.out.println("jLabel19.mouseClicked, event="+evt);
		//TODO add your code for jLabel19.mouseClicked
		jLabel19.setIcon(new ImageIcon("./recursos/ficha.png"));
	}
	//APUESTA 6-9
	private void jLabel20MouseClicked(MouseEvent evt) {
		System.out.println("jLabel20.mouseClicked, event="+evt);
		//TODO add your code for jLabel20.mouseClicked
		jLabel20.setIcon(new ImageIcon("./recursos/ficha.png"));
	}
	//APUESTA 10-13
	private void jLabel21MouseClicked(MouseEvent evt) {
		System.out.println("jLabel21.mouseClicked, event="+evt);
		//TODO add your code for jLabel21.mouseClicked
		jLabel21.setIcon(new ImageIcon("./recursos/ficha.png"));
	}
	//APUESTA 10
	private void jLabel22MouseClicked(MouseEvent evt) {
		System.out.println("jLabel22.mouseClicked, event="+evt);
		//TODO add your code for jLabel22.mouseClicked
		jLabel22.setIcon(new ImageIcon("./recursos/ficha.png"));
	}
	//APUESTA 10-7
	private void jLabel23MouseClicked(MouseEvent evt) {
		System.out.println("jLabel23.mouseClicked, event="+evt);
		//TODO add your code for jLabel23.mouseClicked
		jLabel23.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel24MouseClicked(MouseEvent evt) {
		System.out.println("jLabel24.mouseClicked, event="+evt);
		//TODO add your code for jLabel24.mouseClicked
		jLabel24.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel25MouseClicked(MouseEvent evt) {
		System.out.println("jLabel25.mouseClicked, event="+evt);
		//TODO add your code for jLabel25.mouseClicked
		jLabel25.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel26MouseClicked(MouseEvent evt) {
		System.out.println("jLabel26.mouseClicked, event="+evt);
		//TODO add your code for jLabel26.mouseClicked
		jLabel26.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel27MouseClicked(MouseEvent evt) {
		System.out.println("jLabel27.mouseClicked, event="+evt);
		//TODO add your code for jLabel27.mouseClicked
		jLabel27.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel28MouseClicked(MouseEvent evt) {
		System.out.println("jLabel28.mouseClicked, event="+evt);
		//TODO add your code for jLabel28.mouseClicked
		jLabel28.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel29MouseClicked(MouseEvent evt) {
		System.out.println("jLabel29.mouseClicked, event="+evt);
		//TODO add your code for jLabel29.mouseClicked
		jLabel29.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel30MouseClicked(MouseEvent evt) {
		System.out.println("jLabel30.mouseClicked, event="+evt);
		//TODO add your code for jLabel30.mouseClicked
		jLabel30.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel31MouseClicked(MouseEvent evt) {
		System.out.println("jLabel31.mouseClicked, event="+evt);
		//TODO add your code for jLabel31.mouseClicked
		jLabel31.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel32MouseClicked(MouseEvent evt) {
		System.out.println("jLabel32.mouseClicked, event="+evt);
		//TODO add your code for jLabel32.mouseClicked
		jLabel32.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel33MouseClicked(MouseEvent evt) {
		System.out.println("jLabel33.mouseClicked, event="+evt);
		//TODO add your code for jLabel33.mouseClicked
		jLabel33.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel34MouseClicked(MouseEvent evt) {
		System.out.println("jLabel34.mouseClicked, event="+evt);
		//TODO add your code for jLabel34.mouseClicked
		jLabel34.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel35MouseClicked(MouseEvent evt) {
		System.out.println("jLabel35.mouseClicked, event="+evt);
		//TODO add your code for jLabel35.mouseClicked
		jLabel35.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel36MouseClicked(MouseEvent evt) {
		System.out.println("jLabel36.mouseClicked, event="+evt);
		//TODO add your code for jLabel36.mouseClicked
		jLabel36.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel37MouseClicked(MouseEvent evt) {
		System.out.println("jLabel37.mouseClicked, event="+evt);
		//TODO add your code for jLabel37.mouseClicked
		jLabel37.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel38MouseClicked(MouseEvent evt) {
		System.out.println("jLabel38.mouseClicked, event="+evt);
		//TODO add your code for jLabel38.mouseClicked
		jLabel38.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel39MouseClicked(MouseEvent evt) {
		System.out.println("jLabel39.mouseClicked, event="+evt);
		//TODO add your code for jLabel39.mouseClicked
		jLabel39.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel40MouseClicked(MouseEvent evt) {
		System.out.println("jLabel40.mouseClicked, event="+evt);
		//TODO add your code for jLabel40.mouseClicked
		jLabel40.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel41MouseClicked(MouseEvent evt) {
		System.out.println("jLabel41.mouseClicked, event="+evt);
		//TODO add your code for jLabel41.mouseClicked
		jLabel41.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel42MouseClicked(MouseEvent evt) {
		System.out.println("jLabel42.mouseClicked, event="+evt);
		//TODO add your code for jLabel42.mouseClicked
		jLabel42.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel43MouseClicked(MouseEvent evt) {
		System.out.println("jLabel43.mouseClicked, event="+evt);
		//TODO add your code for jLabel43.mouseClicked
		jLabel43.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel44MouseClicked(MouseEvent evt) {
		System.out.println("jLabel44.mouseClicked, event="+evt);
		//TODO add your code for jLabel44.mouseClicked
		jLabel44.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel45MouseClicked(MouseEvent evt) {
		System.out.println("jLabel45.mouseClicked, event="+evt);
		//TODO add your code for jLabel45.mouseClicked
		jLabel45.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel46MouseClicked(MouseEvent evt) {
		System.out.println("jLabel46.mouseClicked, event="+evt);
		//TODO add your code for jLabel46.mouseClicked
		jLabel46.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel47MouseClicked(MouseEvent evt) {
		System.out.println("jLabel47.mouseClicked, event="+evt);
		//TODO add your code for jLabel47.mouseClicked
		jLabel47.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel48MouseClicked(MouseEvent evt) {
		System.out.println("jLabel48.mouseClicked, event="+evt);
		//TODO add your code for jLabel48.mouseClicked
		jLabel48.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel49MouseClicked(MouseEvent evt) {
		System.out.println("jLabel49.mouseClicked, event="+evt);
		//TODO add your code for jLabel49.mouseClicked
		jLabel49.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel50MouseClicked(MouseEvent evt) {
		System.out.println("jLabel50.mouseClicked, event="+evt);
		//TODO add your code for jLabel50.mouseClicked
		jLabel50.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel51MouseClicked(MouseEvent evt) {
		System.out.println("jLabel51.mouseClicked, event="+evt);
		//TODO add your code for jLabel51.mouseClicked
		jLabel51.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel52MouseClicked(MouseEvent evt) {
		System.out.println("jLabel52.mouseClicked, event="+evt);
		//TODO add your code for jLabel52.mouseClicked
		jLabel52.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel53MouseClicked(MouseEvent evt) {
		System.out.println("jLabel53.mouseClicked, event="+evt);
		//TODO add your code for jLabel53.mouseClicked
		jLabel53.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel54MouseClicked(MouseEvent evt) {
		System.out.println("jLabel54.mouseClicked, event="+evt);
		//TODO add your code for jLabel54.mouseClicked
		jLabel54.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel55MouseClicked(MouseEvent evt) {
		System.out.println("jLabel55.mouseClicked, event="+evt);
		//TODO add your code for jLabel55.mouseClicked
		jLabel55.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel56MouseClicked(MouseEvent evt) {
		System.out.println("jLabel56.mouseClicked, event="+evt);
		//TODO add your code for jLabel56.mouseClicked
		jLabel56.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel57MouseClicked(MouseEvent evt) {
		System.out.println("jLabel57.mouseClicked, event="+evt);
		//TODO add your code for jLabel57.mouseClicked
		jLabel57.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel58MouseClicked(MouseEvent evt) {
		System.out.println("jLabel58.mouseClicked, event="+evt);
		//TODO add your code for jLabel58.mouseClicked
		jLabel58.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel59MouseClicked(MouseEvent evt) {
		System.out.println("jLabel59.mouseClicked, event="+evt);
		//TODO add your code for jLabel59.mouseClicked
		jLabel59.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel60MouseClicked(MouseEvent evt) {
		System.out.println("jLabel60.mouseClicked, event="+evt);
		//TODO add your code for jLabel60.mouseClicked
		jLabel60.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel61MouseClicked(MouseEvent evt) {
		System.out.println("jLabel61.mouseClicked, event="+evt);
		//TODO add your code for jLabel61.mouseClicked
		jLabel61.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel62MouseClicked(MouseEvent evt) {
		System.out.println("jLabel62.mouseClicked, event="+evt);
		//TODO add your code for jLabel62.mouseClicked
		jLabel62.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel63MouseClicked(MouseEvent evt) {
		System.out.println("jLabel63.mouseClicked, event="+evt);
		//TODO add your code for jLabel63.mouseClicked
		jLabel63.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel64MouseClicked(MouseEvent evt) {
		System.out.println("jLabel64.mouseClicked, event="+evt);
		//TODO add your code for jLabel64.mouseClicked
		jLabel64.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel65MouseClicked(MouseEvent evt) {
		System.out.println("jLabel65.mouseClicked, event="+evt);
		//TODO add your code for jLabel65.mouseClicked
		jLabel65.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel66MouseClicked(MouseEvent evt) {
		System.out.println("jLabel66.mouseClicked, event="+evt);
		//TODO add your code for jLabel66.mouseClicked
		jLabel66.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel67MouseClicked(MouseEvent evt) {
		System.out.println("jLabel67.mouseClicked, event="+evt);
		//TODO add your code for jLabel67.mouseClicked
		jLabel67.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel68MouseClicked(MouseEvent evt) {
		System.out.println("jLabel68.mouseClicked, event="+evt);
		//TODO add your code for jLabel68.mouseClicked
		jLabel68.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel69MouseClicked(MouseEvent evt) {
		System.out.println("jLabel69.mouseClicked, event="+evt);
		//TODO add your code for jLabel69.mouseClicked
		jLabel69.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel70MouseClicked(MouseEvent evt) {
		System.out.println("jLabel70.mouseClicked, event="+evt);
		//TODO add your code for jLabel70.mouseClicked
		jLabel70.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel71MouseClicked(MouseEvent evt) {
		System.out.println("jLabel71.mouseClicked, event="+evt);
		//TODO add your code for jLabel71.mouseClicked
		jLabel71.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel72MouseClicked(MouseEvent evt) {
		System.out.println("jLabel72.mouseClicked, event="+evt);
		//TODO add your code for jLabel72.mouseClicked
		jLabel72.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel73MouseClicked(MouseEvent evt) {
		System.out.println("jLabel73.mouseClicked, event="+evt);
		//TODO add your code for jLabel73.mouseClicked
		jLabel73.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel74MouseClicked(MouseEvent evt) {
		System.out.println("jLabel74.mouseClicked, event="+evt);
		//TODO add your code for jLabel74.mouseClicked
		jLabel74.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel75MouseClicked(MouseEvent evt) {
		System.out.println("jLabel75.mouseClicked, event="+evt);
		//TODO add your code for jLabel75.mouseClicked
		jLabel75.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel76MouseClicked(MouseEvent evt) {
		System.out.println("jLabel76.mouseClicked, event="+evt);
		//TODO add your code for jLabel76.mouseClicked
		jLabel76.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel77MouseClicked(MouseEvent evt) {
		System.out.println("jLabel77.mouseClicked, event="+evt);
		//TODO add your code for jLabel77.mouseClicked
		jLabel77.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel78MouseClicked(MouseEvent evt) {
		System.out.println("jLabel78.mouseClicked, event="+evt);
		//TODO add your code for jLabel78.mouseClicked
		jLabel78.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel79MouseClicked(MouseEvent evt) {
		System.out.println("jLabel79.mouseClicked, event="+evt);
		//TODO add your code for jLabel79.mouseClicked
		jLabel79.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel80MouseClicked(MouseEvent evt) {
		System.out.println("jLabel80.mouseClicked, event="+evt);
		//TODO add your code for jLabel80.mouseClicked
		jLabel80.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel81MouseClicked(MouseEvent evt) {
		System.out.println("jLabel81.mouseClicked, event="+evt);
		//TODO add your code for jLabel81.mouseClicked
		jLabel81.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel82MouseClicked(MouseEvent evt) {
		System.out.println("jLabel82.mouseClicked, event="+evt);
		//TODO add your code for jLabel82.mouseClicked
		jLabel82.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel83MouseClicked(MouseEvent evt) {
		System.out.println("jLabel83.mouseClicked, event="+evt);
		//TODO add your code for jLabel83.mouseClicked
		jLabel83.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel84MouseClicked(MouseEvent evt) {
		System.out.println("jLabel84.mouseClicked, event="+evt);
		//TODO add your code for jLabel84.mouseClicked
		jLabel84.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel85MouseClicked(MouseEvent evt) {
		System.out.println("jLabel85.mouseClicked, event="+evt);
		//TODO add your code for jLabel85.mouseClicked
		jLabel85.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel86MouseClicked(MouseEvent evt) {
		System.out.println("jLabel86.mouseClicked, event="+evt);
		//TODO add your code for jLabel86.mouseClicked
		jLabel86.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel87MouseClicked(MouseEvent evt) {
		System.out.println("jLabel87.mouseClicked, event="+evt);
		//TODO add your code for jLabel87.mouseClicked
		jLabel87.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel88MouseClicked(MouseEvent evt) {
		System.out.println("jLabel88.mouseClicked, event="+evt);
		//TODO add your code for jLabel88.mouseClicked
		jLabel88.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel89MouseClicked(MouseEvent evt) {
		System.out.println("jLabel89.mouseClicked, event="+evt);
		//TODO add your code for jLabel89.mouseClicked
		jLabel89.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel90MouseClicked(MouseEvent evt) {
		System.out.println("jLabel90.mouseClicked, event="+evt);
		//TODO add your code for jLabel90.mouseClicked
		jLabel90.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel91MouseClicked(MouseEvent evt) {
		System.out.println("jLabel91.mouseClicked, event="+evt);
		//TODO add your code for jLabel91.mouseClicked
		jLabel91.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel92MouseClicked(MouseEvent evt) {
		System.out.println("jLabel92.mouseClicked, event="+evt);
		//TODO add your code for jLabel92.mouseClicked
		jLabel92.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel93MouseClicked(MouseEvent evt) {
		System.out.println("jLabel93.mouseClicked, event="+evt);
		//TODO add your code for jLabel93.mouseClicked
		jLabel93.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel94MouseClicked(MouseEvent evt) {
		System.out.println("jLabel94.mouseClicked, event="+evt);
		//TODO add your code for jLabel94.mouseClicked
		jLabel94.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel95MouseClicked(MouseEvent evt) {
		System.out.println("jLabel95.mouseClicked, event="+evt);
		//TODO add your code for jLabel95.mouseClicked
		jLabel95.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel96MouseClicked(MouseEvent evt) {
		System.out.println("jLabel96.mouseClicked, event="+evt);
		//TODO add your code for jLabel96.mouseClicked
		jLabel96.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel97MouseClicked(MouseEvent evt) {
		System.out.println("jLabel97.mouseClicked, event="+evt);
		//TODO add your code for jLabel97.mouseClicked
		jLabel97.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel98MouseClicked(MouseEvent evt) {
		System.out.println("jLabel98.mouseClicked, event="+evt);
		//TODO add your code for jLabel98.mouseClicked
		jLabel98.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel99MouseClicked(MouseEvent evt) {
		System.out.println("jLabel99.mouseClicked, event="+evt);
		//TODO add your code for jLabel99.mouseClicked
		jLabel99.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel100MouseClicked(MouseEvent evt) {
		System.out.println("jLabel100.mouseClicked, event="+evt);
		//TODO add your code for jLabel100.mouseClicked
		jLabel100.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel101MouseClicked(MouseEvent evt) {
		System.out.println("jLabel101.mouseClicked, event="+evt);
		//TODO add your code for jLabel101.mouseClicked
		jLabel101.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel102MouseClicked(MouseEvent evt) {
		System.out.println("jLabel102.mouseClicked, event="+evt);
		//TODO add your code for jLabel102.mouseClicked
		jLabel102.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel103MouseClicked(MouseEvent evt) {
		System.out.println("jLabel103.mouseClicked, event="+evt);
		//TODO add your code for jLabel103.mouseClicked
		jLabel103.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel104MouseClicked(MouseEvent evt) {
		System.out.println("jLabel104.mouseClicked, event="+evt);
		//TODO add your code for jLabel104.mouseClicked
		jLabel104.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel105MouseClicked(MouseEvent evt) {
		System.out.println("jLabel105.mouseClicked, event="+evt);
		//TODO add your code for jLabel105.mouseClicked
		jLabel105.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel106MouseClicked(MouseEvent evt) {
		System.out.println("jLabel106.mouseClicked, event="+evt);
		//TODO add your code for jLabel106.mouseClicked
		jLabel106.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel107MouseClicked(MouseEvent evt) {
		System.out.println("jLabel107.mouseClicked, event="+evt);
		//TODO add your code for jLabel107.mouseClicked
		jLabel107.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel108MouseClicked(MouseEvent evt) {
		System.out.println("jLabel108.mouseClicked, event="+evt);
		//TODO add your code for jLabel108.mouseClicked
		jLabel108.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel109MouseClicked(MouseEvent evt) {
		System.out.println("jLabel109.mouseClicked, event="+evt);
		//TODO add your code for jLabel109.mouseClicked
		jLabel109.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel110MouseClicked(MouseEvent evt) {
		System.out.println("jLabel110.mouseClicked, event="+evt);
		//TODO add your code for jLabel110.mouseClicked
		jLabel110.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel111MouseClicked(MouseEvent evt) {
		System.out.println("jLabel111.mouseClicked, event="+evt);
		//TODO add your code for jLabel111.mouseClicked
		jLabel111.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel112MouseClicked(MouseEvent evt) {
		System.out.println("jLabel112.mouseClicked, event="+evt);
		//TODO add your code for jLabel112.mouseClicked
		jLabel112.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel113MouseClicked(MouseEvent evt) {
		System.out.println("jLabel113.mouseClicked, event="+evt);
		//TODO add your code for jLabel113.mouseClicked
		jLabel113.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel114MouseClicked(MouseEvent evt) {
		System.out.println("jLabel114.mouseClicked, event="+evt);
		//TODO add your code for jLabel114.mouseClicked
		jLabel114.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel115MouseClicked(MouseEvent evt) {
		System.out.println("jLabel115.mouseClicked, event="+evt);
		//TODO add your code for jLabel115.mouseClicked
		jLabel115.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel116MouseClicked(MouseEvent evt) {
		System.out.println("jLabel116.mouseClicked, event="+evt);
		//TODO add your code for jLabel116.mouseClicked
		jLabel116.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel117MouseClicked(MouseEvent evt) {
		System.out.println("jLabel117.mouseClicked, event="+evt);
		//TODO add your code for jLabel117.mouseClicked
		jLabel117.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel118MouseClicked(MouseEvent evt) {
		System.out.println("jLabel118.mouseClicked, event="+evt);
		//TODO add your code for jLabel118.mouseClicked
		jLabel118.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel119MouseClicked(MouseEvent evt) {
		System.out.println("jLabel119.mouseClicked, event="+evt);
		//TODO add your code for jLabel119.mouseClicked
		jLabel119.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel120MouseClicked(MouseEvent evt) {
		System.out.println("jLabel120.mouseClicked, event="+evt);
		//TODO add your code for jLabel120.mouseClicked
		jLabel120.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel121MouseClicked(MouseEvent evt) {
		System.out.println("jLabel121.mouseClicked, event="+evt);
		//TODO add your code for jLabel121.mouseClicked
		jLabel121.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel122MouseClicked(MouseEvent evt) {
		System.out.println("jLabel122.mouseClicked, event="+evt);
		//TODO add your code for jLabel122.mouseClicked
		jLabel122.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel123MouseClicked(MouseEvent evt) {
		System.out.println("jLabel123.mouseClicked, event="+evt);
		//TODO add your code for jLabel123.mouseClicked
		jLabel123.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel124MouseClicked(MouseEvent evt) {
		System.out.println("jLabel124.mouseClicked, event="+evt);
		//TODO add your code for jLabel124.mouseClicked
		jLabel124.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel125MouseClicked(MouseEvent evt) {
		System.out.println("jLabel125.mouseClicked, event="+evt);
		//TODO add your code for jLabel125.mouseClicked
		jLabel125.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel126MouseClicked(MouseEvent evt) {
		System.out.println("jLabel126.mouseClicked, event="+evt);
		//TODO add your code for jLabel126.mouseClicked
		jLabel126.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel127MouseClicked(MouseEvent evt) {
		System.out.println("jLabel127.mouseClicked, event="+evt);
		//TODO add your code for jLabel127.mouseClicked
		jLabel127.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel128MouseClicked(MouseEvent evt) {
		System.out.println("jLabel128.mouseClicked, event="+evt);
		//TODO add your code for jLabel128.mouseClicked
		jLabel128.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel129MouseClicked(MouseEvent evt) {
		System.out.println("jLabel129.mouseClicked, event="+evt);
		//TODO add your code for jLabel129.mouseClicked
		jLabel129.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel130MouseClicked(MouseEvent evt) {
		System.out.println("jLabel130.mouseClicked, event="+evt);
		//TODO add your code for jLabel130.mouseClicked
		jLabel130.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel131MouseClicked(MouseEvent evt) {
		System.out.println("jLabel131.mouseClicked, event="+evt);
		//TODO add your code for jLabel131.mouseClicked
		jLabel131.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel132MouseClicked(MouseEvent evt) {
		System.out.println("jLabel132.mouseClicked, event="+evt);
		//TODO add your code for jLabel132.mouseClicked
		jLabel132.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel133MouseClicked(MouseEvent evt) {
		System.out.println("jLabel133.mouseClicked, event="+evt);
		//TODO add your code for jLabel133.mouseClicked
		jLabel133.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel134MouseClicked(MouseEvent evt) {
		System.out.println("jLabel134.mouseClicked, event="+evt);
		//TODO add your code for jLabel134.mouseClicked
		jLabel134.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel135MouseClicked(MouseEvent evt) {
		System.out.println("jLabel135.mouseClicked, event="+evt);
		//TODO add your code for jLabel135.mouseClicked
		jLabel135.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel136MouseClicked(MouseEvent evt) {
		System.out.println("jLabel136.mouseClicked, event="+evt);
		//TODO add your code for jLabel136.mouseClicked
		jLabel136.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel137MouseClicked(MouseEvent evt) {
		System.out.println("jLabel137.mouseClicked, event="+evt);
		//TODO add your code for jLabel137.mouseClicked
		jLabel137.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel138MouseClicked(MouseEvent evt) {
		System.out.println("jLabel138.mouseClicked, event="+evt);
		//TODO add your code for jLabel138.mouseClicked
		jLabel138.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel139MouseClicked(MouseEvent evt) {
		System.out.println("jLabel139.mouseClicked, event="+evt);
		//TODO add your code for jLabel139.mouseClicked
		jLabel139.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel140MouseClicked(MouseEvent evt) {
		System.out.println("jLabel140.mouseClicked, event="+evt);
		//TODO add your code for jLabel140.mouseClicked
		jLabel140.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel141MouseClicked(MouseEvent evt) {
		System.out.println("jLabel141.mouseClicked, event="+evt);
		//TODO add your code for jLabel141.mouseClicked
		jLabel141.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel142MouseClicked(MouseEvent evt) {
		System.out.println("jLabel142.mouseClicked, event="+evt);
		//TODO add your code for jLabel142.mouseClicked
		jLabel142.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel143MouseClicked(MouseEvent evt) {
		System.out.println("jLabel143.mouseClicked, event="+evt);
		//TODO add your code for jLabel143.mouseClicked
		jLabel143.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel144MouseClicked(MouseEvent evt) {
		System.out.println("jLabel144.mouseClicked, event="+evt);
		//TODO add your code for jLabel144.mouseClicked
		jLabel144.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel145MouseClicked(MouseEvent evt) {
		System.out.println("jLabel145.mouseClicked, event="+evt);
		//TODO add your code for jLabel145.mouseClicked
		jLabel145.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel146MouseClicked(MouseEvent evt) {
		System.out.println("jLabel146.mouseClicked, event="+evt);
		//TODO add your code for jLabel146.mouseClicked
		jLabel146.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel147MouseClicked(MouseEvent evt) {
		System.out.println("jLabel147.mouseClicked, event="+evt);
		//TODO add your code for jLabel147.mouseClicked
		jLabel147.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

	private void jLabel148MouseClicked(MouseEvent evt) {
		System.out.println("jLabel148.mouseClicked, event="+evt);
		//TODO add your code for jLabel148.mouseClicked
		jLabel148.setIcon(new ImageIcon("./recursos/ficha.png"));
	}
	//APUESTA FILA3
	private void jLabel149MouseClicked(MouseEvent evt) {
		System.out.println("jLabel149.mouseClicked, event="+evt);
		//TODO add your code for jLabel149.mouseClicked
		jLabel149.setIcon(new ImageIcon("./recursos/ficha.png"));
	}
	//APUESTA FILA2
	private void jLabel150MouseClicked(MouseEvent evt) {
		System.out.println("jLabel150.mouseClicked, event="+evt);
		//TODO add your code for jLabel150.mouseClicked
		jLabel150.setIcon(new ImageIcon("./recursos/ficha.png"));
	}
	//APUESTA FILA1
	private void jLabel151MouseClicked(MouseEvent evt) {
		System.out.println("jLabel151.mouseClicked, event="+evt);
		//TODO add your code for jLabel151.mouseClicked
		jLabel151.setIcon(new ImageIcon("./recursos/ficha.png"));
	}
	//APUESTA 1�DOCENA
	private void jLabel152MouseClicked(MouseEvent evt) {
		System.out.println("jLabel152.mouseClicked, event="+evt);
		//TODO add your code for jLabel152.mouseClicked
		jLabel152.setIcon(new ImageIcon("./recursos/ficha.png"));
	}
	//APUESTA 2�DOCENA
	private void jLabel153MouseClicked(MouseEvent evt) {
		System.out.println("jLabel153.mouseClicked, event="+evt);
		//TODO add your code for jLabel153.mouseClicked
		jLabel153.setIcon(new ImageIcon("./recursos/ficha.png"));
	}
	//APUESTA 3�DOCENA
	private void jLabel154MouseClicked(MouseEvent evt) {
		System.out.println("jLabel154.mouseClicked, event="+evt);
		//TODO add your code for jLabel154.mouseClicked
		jLabel154.setIcon(new ImageIcon("./recursos/ficha.png"));
	}
	//APUESTA 1 AL 18
	private void jLabel155MouseClicked(MouseEvent evt) {
		System.out.println("jLabel155.mouseClicked, event="+evt);
		//TODO add your code for jLabel155.mouseClicked
		jLabel155.setIcon(new ImageIcon("./recursos/ficha.png"));
	}
	//APUESTA PAR
	private void jLabel156MouseClicked(MouseEvent evt) {
		System.out.println("jLabel156.mouseClicked, event="+evt);
		//TODO add your code for jLabel156.mouseClicked
		if (mesa.tieneDinero() || mesa.quitarApuesta() ){
			if(!mesa.aTerminado()){
				if(mesa.quitarApuesta()){
					jLabel156.setIcon(new ImageIcon("./recursos/trasparente.png"));
				}
				else{
					if(mesa.dameFichaApuesta()==1)
						jLabel156.setIcon(new ImageIcon("./recursos/ficha_roja.png"));
					if(mesa.dameFichaApuesta()==2)
						jLabel156.setIcon(new ImageIcon("./recursos/ficha_blanca.png"));
					if(mesa.dameFichaApuesta()==3)
						jLabel156.setIcon(new ImageIcon("./recursos/ficha.png"));
					if(mesa.dameFichaApuesta()==4)
						jLabel156.setIcon(new ImageIcon("./recursos/ficha_azul.png"));
				}

				mesa.casillaPulsada(Apuesta.casillaAp.PAR,Apuesta.tipoAp.PARIDAD,Apuesta.proporcionAp.SIMPLE);
                //Prueba de funcionamiento
                System.out.println("Casilla pulsada par");
			}
		}
	}
	//APUESTA ROJO
	private void jLabel157MouseClicked(MouseEvent evt) {
		System.out.println("jLabel157.mouseClicked, event="+evt);
		//TODO add your code for jLabel157.mouseClicked
		jLabel157.setIcon(new ImageIcon("./recursos/ficha.png"));
	}
	//APUESTA NEGRO
	private void jLabel158MouseClicked(MouseEvent evt) {
		System.out.println("jLabel158.mouseClicked, event="+evt);
		//TODO add your code for jLabel158.mouseClicked
		jLabel158.setIcon(new ImageIcon("./recursos/ficha.png"));
	}
	//APUESTA IMPAR
	private void jLabel159MouseClicked(MouseEvent evt) {
		System.out.println("jLabel159.mouseClicked, event="+evt);
		//TODO add your code for jLabel159.mouseClicked
		jLabel159.setIcon(new ImageIcon("./recursos/ficha.png"));
	}
	//APUESTA 19 AL 36
	private void jLabel160MouseClicked(MouseEvent evt) {
		System.out.println("jLabel160.mouseClicked, event="+evt);
		//TODO add your code for jLabel160.mouseClicked
		jLabel160.setIcon(new ImageIcon("./recursos/ficha.png"));
	}

}

