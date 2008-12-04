package AplicacionPruebaBBDD;

import java.io.FileInputStream;

import java.sql.SQLException;

import java.util.Properties;
import javax.swing.JOptionPane;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;

import ConexionBBDD.Modelo;
import Entidades.Cliente;
import Entidades.Cuenta;
import Entidades.Juego;
import Entidades.Mesa;
import Entidades.Participante;
import Entidades.Partida;
import Entidades.Ronda;
import Entidades.Sala;
import Excepciones.SinResultadosException;




/**
 * Clase Aplicacion.
 * Clase desde la que se lanza la aplicacion.
 * Primero se lee el archivo de propiedades de la conexion con la base de datos,
 * en caso de no encontrarlo o no poder leerlo se lanza una excepcion y finaliza
 * la aplicacion.Si todo va bien se crea el modelo.
 * @author Joaquín López Cabezas
 *
 */

public class Aplicacion {
	public static void main(String[] args) throws SQLException {	
		/********** DATOS DE PRUEBA **********/
		//Modelo modelo=new Modelo();
		//Juego j=new Juego(1,"Pepito",3,"Todo vale");
		//Cliente c=new Cliente("Pepito","Perez Pereira","99999999Z","Mi login","Mi password","Calla del olvido","666666666",new Date());
		//Sala s=new Sala(2,1,"Sala 1");
		//Mesa m=new Mesa(3,2,1,1,0,0);
		//Cuenta cu=new Cuenta("0000",21,0,0);
		//Partida p=new Partida(1,3,15,1);
		//Ronda r=new Ronda(1,1,1,1);
		//Participante participante=new Participante(1,1);
		/************ Insert*****/
		//modelo.insertCliente(c);
		//modelo.insertJuego(j);
		//modelo.insertSalas(s);
		//modelo.insertMesa(m);
		//modelo.insertCuenta(cu);
		//modelo.insertPartida(p);
		//modelo.insertRonda(r);
		//modelo.insertParticipante(participante);
		/*********** Select ******/
		/*try {
			j=modelo.selectJuego(3);
		} catch (SinResultadosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Juego = "+j.getCodigo()+", "+j.getNombre()+", "+j.getJugadoresMin()+", "+j.getReglas());*/
		//c=modelo.selectCliente(2);
		//System.out.println("Cliete= "+c.getCodgo()+", "+c.getNombre()+", "+c.getApellidos()+", "+c.getDni()+", "+c.getUsuario()+", "+c.getPassword()+", "+c.getDireccion()+", "+c.getTelefono()+", "+c.getFechaIngreso());
		//s=modelo.selectSala(4);
		//System.out.println("Sala = "+s.getCodigo()+", "+s.getJuego()+", "+s.getNombre());
		//m=modelo.selectMesa(4);
		//System.out.println("Mesa = "+m.getCodigo()+", "+m.getSala()+", "+m.getPuesto()+", "+m.getJugadores()+", "+m.getApuestaMin()+", "+m.getApuestaMax());
		//cu=modelo.selectCuenta("0000");
		//System.out.println("Cuenta = "+cu.getNumero()+", "+cu.getCliente()+", "+cu.getSaldoIni()+", "+cu.getSaldoAct());
		//p=modelo.selectPartida(1);
		//System.out.println("Partida = "+p.getCodigo()+", "+p.getMesa()+", "+p.getNumJugadores()+", "+p.getGanador());
		//r=modelo.selectRonda(1);
		//System.out.println("Ronda = "+r.getPartida()+", "+r.getRonda()+", "+r.getValorMesa()+", "+r.getGanador());
		//participante=modelo.selectParticipante(1,1);
		//System.out.println("Participante = "+participante.getPartida()+", "+participante.getJugador());
		/********** SelecAll *******/
		DefaultTableModel tabla=new DefaultTableModel();
		//tabla=modelo.selectAllClientes();
		//System.out.println("Numero de clientes= "+tabla.getRowCount());
		/*try {
			tabla=modelo.selectAllJuegos();
		} catch (SinResultadosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Numero de juegos= "+tabla.getRowCount());*/
		//tabla=modelo.selectAllSalas();
		//System.out.println("Numero de salas= "+tabla.getRowCount());
		//tabla=modelo.selectAllMesas();
		//System.out.println("Numero de mesas= "+tabla.getRowCount());
		//tabla=modelo.selectAllCuentas();
		//System.out.println("Numero de cuetnas= "+tabla.getRowCount());
		//tabla=modelo.selectAllPartidas();
		//System.out.println("Numero de partidas= "+tabla.getRowCount());
		//tabla=modelo.selectAllRondas();
		//System.out.println("Numero de rondas= "+tabla.getRowCount());
		//tabla=modelo.selectAllParticipantes();
		//System.out.println("Numero de participnates= "+tabla.getRowCount());
		/********* Update ********/
		//Juego jmodif=new Juego(1,"Pepito Modificado",3,"Todo vale");
		//Cliente cmodif=new Cliente(2,"Pepito modif","Perez Pereira modif","99999999Z","Mi login modif","Mi password","Calla del olvido modif","666666666",new Date()); 
		//Sala smodif=new Sala(4,3,"Sala 1 modificado");
		//Mesa mmodif=new Mesa(3,25,1,1,210.25,10.30);
		//Cuenta ccuenta=new Cuenta("0000",21,10.20,10.20);
		//Partida pmodif=new Partida(1,3,10,1);
		//Rondas rmodif=new Rondas(1,2,2,2);
		//Participante participantemodif=new Participante(1,2);
		//modelo.updateJuego(jmodif);
		//modelo.updateCliente(cmodif);
		//modelo.updateSala(smodif);
		//modelo.updateMesa(mmodif);
		//modelo.updateCuentas(cmodif);
		//modelo.updatePartidas(pmodif);
		//modelo.updateRondas(rmodif);
		//modelo.updateParticipantes(participantemodif);
		//modelo.deleteJuego(1);
		//modelo.deleteCliente(21);
		//modelo.deleteSala(2);
		//modelo.deleteMesa(3);
		//modelo.deleteCuenta("0000");
		//modelo.deletePartida(1);
		//modelo.deleteRonda(1);
		//modelo.deleteParticipantes(1,1);
	}

}
