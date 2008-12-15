package ConexionBBDD;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Entidades.Cliente;
import Entidades.Juego;
import Entidades.Mesa;
import Entidades.Participante;
import Entidades.Partida;
import Entidades.Sala;
import Excepciones.*;


/**
 * Clase Modelo.
 * Clase que se comunica con la base de datos realizando consultas SQL.
 * @author Joaqu�n L�pez Cabezas
 * @version 1.0
 *
 */

public class BBDD {
	
	/**
	 * Atributo de tipo InterfaceBD.Es la referencia a la base de datos
	 * con la que se trabaja en este caso Oracle
	 */
	private OracleBD baseDatos;
	
	
	/**
	 * Constructor
	 * @param propiedadesConexion Un Properties que contiene la informacion
	 * de la conexion con la base de datos,procedente del achivo BaseDatos.properties.
	 * Aqui se configura cogiendo el driver, url,usuario,contrase�a.
	 * @throws SQLException 
	 */
	public BBDD() {
		
			
		String driverBD = "oracle.jdbc.driver.OracleDriver";
		if (driverBD != null) {
			String url="jdbc:oracle:thin:@147.96.21.102:1521:xe";
			String usuario = "SYSTEM";
			String contraseña = "casinois0809ñ";
			if (driverBD.equals("oracle.jdbc.driver.OracleDriver")) {
				System.setProperty("jdbc.drivers", driverBD);
				if (driverBD.equals("oracle.jdbc.driver.OracleDriver")){
					baseDatos = new OracleBD(url,usuario,contraseña);
				}
				
			}
			else {
				
			}
		}		
		else {
			
		}
	}
	
	public DefaultTableModel selectAllJuegos() throws SQLException, SinResultadosException {
		
		DefaultTableModel tablaDatos=new DefaultTableModel();
		tablaDatos=baseDatos.ejecutarSelect("JUEGOS","CODIGO,NOMBRE,JUGADORESMIN,REGLAS","");
		//System.out.println(tablaDatos.getValueAt(0,0).toString());
		if(tablaDatos==null){
			throw new SinResultadosException();
		}
		return tablaDatos;
		
	}
	
	public DefaultTableModel selectAllClientes() throws SQLException, SinResultadosException
	{
		DefaultTableModel tablaDatos=new DefaultTableModel();
		tablaDatos=baseDatos.ejecutarSelect("CLIENTES","CODIGO,NOMBRE,APELLIDOS,DNI,USUARIO,PASSWORD,DIRECCION,TELEFONO,FECHA_INGRESO","");
		System.out.println(tablaDatos.getValueAt(0,0).toString());
		if(tablaDatos==null){
			throw new SinResultadosException();
		}
		return tablaDatos;
		
	}
	
	public DefaultTableModel selectAllSalas() throws SQLException, SinResultadosException
	{
		DefaultTableModel tablaDatos=new DefaultTableModel();
		tablaDatos=baseDatos.ejecutarSelect("SALAS","CODIGO,JUEGO,NOMBRE","");
		System.out.println(tablaDatos.getValueAt(0,0).toString());
		if(tablaDatos==null){
			throw new SinResultadosException();
		}
		return tablaDatos;
		
	}
	
	public DefaultTableModel selectAllMesas() throws SQLException, SinResultadosException
	{
		DefaultTableModel tablaDatos=new DefaultTableModel();
		tablaDatos=baseDatos.ejecutarSelect("MESAS","CODIGO,SALA,PUESTOS,JUGADORES,APUESTAMIN,APUESTAMAX","");
		System.out.println(tablaDatos.getValueAt(0,0).toString());
		if(tablaDatos==null){
			throw new SinResultadosException();
		}
		return tablaDatos;
		
	}
	
	public DefaultTableModel selectAllCuentas() throws SQLException, SinResultadosException
	{
		DefaultTableModel tablaDatos=new DefaultTableModel();
		tablaDatos=baseDatos.ejecutarSelect("CUENTAS","NUMERO,CLIENTE,SALDOINI,SALDOACT","");
		System.out.println(tablaDatos.getValueAt(0,0).toString());
		if(tablaDatos==null){
			throw new SinResultadosException();
		}
		return tablaDatos;
		
	}
	
	public DefaultTableModel selectAllPartidas() throws SQLException, SinResultadosException
	{
		DefaultTableModel tablaDatos=new DefaultTableModel();
		tablaDatos=baseDatos.ejecutarSelect("PARTIDAS","CODIGO,MESA,NUMJUGADORES,GANADOR","");
		System.out.println(tablaDatos.getValueAt(0,0).toString());
		if(tablaDatos==null){
			throw new SinResultadosException();
		}
		return tablaDatos;
		
	}
	
	public DefaultTableModel selectAllParticipantes() throws SQLException, SinResultadosException
	{
		DefaultTableModel tablaDatos=new DefaultTableModel();
		tablaDatos=baseDatos.ejecutarSelect("PARTICIPANTES","PARTIDA,JUGADOR","");
		System.out.println(tablaDatos.getValueAt(0,0).toString());
		if(tablaDatos==null){
			throw new SinResultadosException();
		}
		return tablaDatos;
		
	}
	/**
	public DefaultTableModel selectAllRondas() throws SQLException
	{
		DefaultTableModel tablaDatos=new DefaultTableModel();
		tablaDatos=baseDatos.ejecutarSelect("RONDAS","RONDA,PARTIDA,VALOR_MESA,GANADOR","");
		if(tablaDatos==null){
			throw new SQLException();
		}
		return tablaDatos;
		
	}
	 * @throws SinResultadosException */
	
	public Juego selectJuego(int codigo) throws SQLException, SinResultadosException{
		DefaultTableModel tablaDatos=new DefaultTableModel();
		tablaDatos=baseDatos.ejecutarSelect("JUEGOS","CODIGO,NOMBRE,JUGADORESMIN,REGLAS","CODIGO = "+codigo);
		if(tablaDatos==null){
			throw new SinResultadosException();
		}
		Juego juego=new Juego();
		juego.setCodigo(((BigDecimal)tablaDatos.getValueAt(0,0)).intValue());
		juego.setNombre(tablaDatos.getValueAt(0,1).toString());
		juego.setJugadoresMin(((BigDecimal)tablaDatos.getValueAt(0,2)).intValue());
		juego.setReglas(tablaDatos.getValueAt(0,3).toString());
		
		return juego;
	}
	
	public Cliente selectCliente(String idUsuario,String password) throws SQLException,SinResultadosException{
		
		DefaultTableModel tablaDatos = new DefaultTableModel();
		tablaDatos = baseDatos.ejecutarSelect("CLIENTES","CODIGO,NOMBRE,APELLIDOS,DNI,USUARIO,PASSWORD," +
		"DIRECCION,FECHAINGRESO,NUMEROCUENTA,SALDOINI,SALDOACTUAL,TELEFONO","USUARIO = '"+idUsuario+"' AND PASSWORD = '"+password+"'");
		if(tablaDatos==null){
			throw new SinResultadosException();
		}
		Cliente cliente = new Cliente();
		cliente.setCodigo(((BigDecimal)tablaDatos.getValueAt(0,0)).intValue());
		cliente.setNombre(tablaDatos.getValueAt(0,1).toString());
		cliente.setApellidos(tablaDatos.getValueAt(0,2).toString());
		cliente.setDni(tablaDatos.getValueAt(0,3).toString());
		cliente.setUsuario(tablaDatos.getValueAt(0,4).toString());
		cliente.setPassword(tablaDatos.getValueAt(0,5).toString());
		cliente.setDireccion(tablaDatos.getValueAt(0,6).toString());
		cliente.setFechaIngreso((Date) tablaDatos.getValueAt(0,7));
		cliente.setNumero(tablaDatos.getValueAt(0,8).toString());
		cliente.setSaldoIni(((BigDecimal)tablaDatos.getValueAt(0,9)).doubleValue());
		cliente.setSaldoAct(((BigDecimal)tablaDatos.getValueAt(0,10)).doubleValue());
		cliente.setTelefono(tablaDatos.getValueAt(0,11).toString());
		
		return cliente;
		
	}
	
	public Cliente selectCliente(int codigo) throws SQLException, SinResultadosException{
		DefaultTableModel tablaDatos=new DefaultTableModel();
		tablaDatos = baseDatos.ejecutarSelect("CLIENTES","CODIGO,NOMBRE,APELLIDOS,DNI,DIRECCION,USUARIO,PASSWORD,TELEFONO,FECHA_INGRESO","CODIGO = "+codigo);
		if(tablaDatos==null){
			throw new SinResultadosException();
		}
		Cliente cliente =new Cliente();
		cliente.setCodigo(((BigDecimal)tablaDatos.getValueAt(0,0)).intValue());
		cliente.setNombre(tablaDatos.getValueAt(0,1).toString());
		cliente.setApellidos(tablaDatos.getValueAt(0,2).toString());
		cliente.setDni(tablaDatos.getValueAt(0,3).toString());
		cliente.setUsuario(tablaDatos.getValueAt(0,4).toString());
		cliente.setPassword(tablaDatos.getValueAt(0,5).toString());
		cliente.setDireccion(tablaDatos.getValueAt(0,6).toString());
		cliente.setTelefono(tablaDatos.getValueAt(0,7).toString());
		cliente.setFechaIngreso((Date) tablaDatos.getValueAt(0,8));
		return cliente;
	}
	
	public Sala selectSala(int codigo) throws SQLException, SinResultadosException{
		DefaultTableModel tablaDatos=new DefaultTableModel();
		tablaDatos=baseDatos.ejecutarSelect("SALAS","CODIGO,JUEGO,NOMBRE","CODIGO = "+codigo);
		if(tablaDatos==null){
			throw new SinResultadosException();
		}
		Sala sala=new Sala();
		sala.setCodigo(((BigDecimal)tablaDatos.getValueAt(0,0)).intValue());
		sala.setJuego(((BigDecimal)tablaDatos.getValueAt(0,1)).intValue());
		sala.setNombre(tablaDatos.getValueAt(0,2).toString());
		
		return sala;
	}
	
	public Mesa selectMesa(int codigo) throws SQLException, SinResultadosException{
		DefaultTableModel tablaDatos=new DefaultTableModel();
		tablaDatos=baseDatos.ejecutarSelect("MESAS","CODIGO,SALA,PUESTOS,JUGADORES,APUESTAMIN,APUESTAMAX","CODIGO = "+codigo);
		if(tablaDatos==null){
			throw new SinResultadosException();
		}
		Mesa mesa=new Mesa();
		mesa.setCodigo(((BigDecimal)tablaDatos.getValueAt(0,0)).intValue());
		mesa.setSala(((BigDecimal)tablaDatos.getValueAt(0,1)).intValue());
		mesa.setPuesto(((BigDecimal)tablaDatos.getValueAt(0,2)).intValue());
		mesa.setJugadores(((BigDecimal)tablaDatos.getValueAt(0,3)).intValue());
		mesa.setApuestaMin(((Number)tablaDatos.getValueAt(0,4)).doubleValue());
		//mesa.setApuestaMin(((Integer)tablaDatos.getValueAt(0,4)).doubleValue());
		mesa.setApuestaMax(((Number)tablaDatos.getValueAt(0,5)).doubleValue());
		//mesa.setApuestaMax(((Integer)tablaDatos.getValueAt(0,5)).doubleValue());
		
		return mesa;
	}
	
	public Partida selectPartida(int codigo) throws SQLException, SinResultadosException{
		DefaultTableModel tablaDatos=new DefaultTableModel();
		tablaDatos=baseDatos.ejecutarSelect("PARTIDAS","CODIGO,MESA,NUMJUGADORES,GANADOR","CODIGO = "+codigo);
		if(tablaDatos==null){
			throw new SinResultadosException();
		}
		Partida partida=new Partida();
		partida.setCodigo(((BigDecimal)tablaDatos.getValueAt(0,0)).intValue());
		partida.setMesa(((BigDecimal)tablaDatos.getValueAt(0,1)).intValue());
		partida.setNumJugadores(((BigDecimal)tablaDatos.getValueAt(0,2)).intValue());
		partida.setGanador(((BigDecimal)tablaDatos.getValueAt(0,3)).intValue());
		return partida;
	}
	
	public Participante selectParticipante(int partida, int jugador) throws SQLException, SinResultadosException{
		DefaultTableModel tablaDatos=new DefaultTableModel();
		tablaDatos=baseDatos.ejecutarSelect("PARTICIPANTES","PARTIDA,JUGADOR","PARTIDA = "+partida+" AND JUGADOR = "+jugador);
		if(tablaDatos==null){
			throw new SinResultadosException();
		}
		Participante participante=new Participante();
		participante.setPartida(((BigDecimal)tablaDatos.getValueAt(0,0)).intValue());
		participante.setJugador(((BigDecimal)tablaDatos.getValueAt(0,1)).intValue());
		return participante;
	}
	
	/**
	public Rondas selectRonda(int r) throws SQLException{
		DefaultTableModel tablaDatos=new DefaultTableModel();
		tablaDatos=baseDatos.ejecutarSelect("RONDAS","RONDA,PARTIDA,VALOR_MESA,GANADOR","RONDA = "+r);
		if(tablaDatos==null){
			throw new SQLException();
		}
		Rondas ronda=new Rondas();
		ronda.setRonda(((Integer)tablaDatos.getValueAt(0,0)).intValue());
		ronda.setPartida(((Integer)tablaDatos.getValueAt(0,1)).intValue());
		ronda.setValorMesa(((Integer)tablaDatos.getValueAt(0,2)).intValue());
		ronda.setGanador(((Integer)tablaDatos.getValueAt(0,3)).intValue());
		
		return ronda;
	}*/
	
	public void deleteJuego(int codigo) throws SQLException{
		baseDatos.ejecutarDelete("JUEGOS","CODIGO = "+codigo);
	}
	
	public void deleteCliente(int codigo) throws SQLException{
		baseDatos.ejecutarDelete("CLIENTES","CODIGO = "+codigo);
	}
	
	public void deleteSala(int codigo) throws SQLException{
		baseDatos.ejecutarDelete("SALAS","CODIGO = "+codigo);
	}
	
	public void deleteMesa(int codigo) throws SQLException{
		baseDatos.ejecutarDelete("MESAS","CODIGO = "+codigo);
	}
	
	public void deleteCuenta(String cuenta) throws SQLException{
		baseDatos.ejecutarDelete("CUENTAS","NUMERO = '"+cuenta+"'");
	}
	
	public void deletePartida(int codigo) throws SQLException{
		baseDatos.ejecutarDelete("PARTIDAS","CODIGO = "+codigo);
	}
	
	public void deleteParticipantes(int partida, int jugador) throws SQLException{
		baseDatos.ejecutarDelete("PARTICIPANTES","PARTIDA = "+partida+" AND JUGADOR = "+jugador);
	}
	
	/**
	public void deleteRonda(int ronda) throws SQLException{
		baseDatos.ejecutarDelete("RONDAS","RONDA = "+ronda);
	}
	*/
        public void updateSaldoCliente(int cliente, int saldo) throws SQLException{
		
		String valores="SALDOACTUAL = '"+saldo+"'";
		baseDatos.ejecutarUpdate("CLIENTES",valores,"CODIGO = "+cliente);
	}
	
	public void updateJuego(Juego juego) throws SQLException{
		String valores="NOMBRE = '"+juego.getNombre()+"', JUGADORESMIN = "+juego.getJugadoresMin()+", REGLAS = '"+juego.getReglas()+"'";
		baseDatos.ejecutarUpdate("JUEGOS",valores,"CODIGO = "+juego.getCodigo());
	}
	
	public void updateCliente(Cliente cliente) throws SQLException{
		SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
		String fecha=formatoFecha.format(cliente.getFechaIngreso());
		String valores="NOMBRE = '"+cliente.getNombre()+"', APELLIDOS = '"+cliente.getApellidos()+"', DNI = '"+cliente.getDni()+"', USUARIO = '"+cliente.getUsuario()+"', PASSWORD = '"+cliente.getPassword()+"', DIRECCION = '"+cliente.getDireccion()+"', TELEFONO = '"+cliente.getTelefono()+"', FECHA_INGRESO = '"+fecha+"'";
		baseDatos.ejecutarUpdate("CLIENTES",valores,"CODIGO = "+cliente.getCodigo());
	}
	
	public void updateSala(Sala sala) throws SQLException{
		String valores="JUEGO = "+sala.getJuego()+", NOMBRE = '"+sala.getNombre()+"'";
		baseDatos.ejecutarUpdate("SALAS",valores,"CODIGO = "+sala.getCodigo());
	}
	
	public void updateMesa(Mesa mesa) throws SQLException{
		String valores="SALA = "+mesa.getSala()+", PUESTOS = "+mesa.getPuesto()+", JUGADORES = "+mesa.getJugadores()+", APUESTAMIN = "+mesa.getApuestaMin()+", APUESTAMAX = "+mesa.getApuestaMax();
		baseDatos.ejecutarUpdate("MESAS",valores,"CODIGO = "+mesa.getCodigo());
	}
	
	public void updatePartidas(Partida partida) throws SQLException{
		String valores="MESA = "+partida.getMesa()+", NUMJUGADORES = "+partida.getNumJugadores()+", GANADOR = "+partida.getGanador();
		baseDatos.ejecutarUpdate("PARTIDAS",valores,"CODIGO = "+partida.getCodigo());
	}
	
	public void updateParticipantes(Participante participantes) throws SQLException{
		String valores="PARTIDA = "+participantes.getPartida()+", JUGADOR = "+participantes.getJugador();
		baseDatos.ejecutarUpdate("PARTICIPANTES",valores,"PARTIDA = "+participantes.getPartida()+" AND JUGADOR = "+participantes.getJugador());
	}
	
	/**
	public void updateRondas(Rondas ronda) throws SQLException{
		String valores="PARTIDA = "+ronda.getPartida()+", VALOR_MESA = "+ronda.getValorMesa()+", GANADOR = "+ronda.getGanador();
		baseDatos.ejecutarUpdate("RONDAS",valores,"RONDA = "+ronda.getRonda());
	}
	*/
	
	public void insertJuego(Juego juego) throws SQLException{
		String valoresTabla=/*"'"+juego.getCodigo()+"','"*/"S_JUEGOS.NEXTVAL, '"+juego.getNombre()+"','"+juego.getJugadoresMin()+"','"+juego.getReglas()+"'";
		baseDatos.ejecutarInsert("JUEGOS",valoresTabla);
	}
	
	public void insertCliente(Cliente cliente) throws SQLException{
		SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
		String fecha=formatoFecha.format(cliente.getFechaIngreso());
		String valoresTabla=/*"'"+cliente.getCodgo()+"','"*/"S_CLIENTES.NEXTVAL, '"+cliente.getNombre()+"','"+cliente.getApellidos()+"','"+cliente.getDni()+"','"+cliente.getUsuario()+"','"+cliente.getPassword()+"','"+cliente.getDireccion()+"','"+cliente.getTelefono()+"','"+fecha+"'";
		baseDatos.ejecutarInsert("CLIENTES",valoresTabla);
	}
	
	public void insertSalas(Sala sala) throws SQLException{
		String valoresTabla=/*"'"+sala.getCodigo()+"','"*/"S_SALAS.NEXTVAL, '"+sala.getJuego()+"','"+sala.getNombre()+"'";
		baseDatos.ejecutarInsert("SALAS",valoresTabla);
	}
	
	public void insertMesa(Mesa mesa) throws SQLException{
		String valoresTabla=/*"'"+mesa.getCodigo()+"','"*/"S_MESAS.NEXTVAL, '"+mesa.getSala()+"','"+mesa.getPuesto()+"','"+mesa.getJugadores()+"','"+mesa.getApuestaMin()+"','"+mesa.getApuestaMax()+"'";
		baseDatos.ejecutarInsert("MESAS",valoresTabla);
	}
	
	public void insertPartida(Partida partida) throws SQLException{
		String valoresTabla=/*"'"+partida.getCodigo()+*/"S_PARTIDAS.NEXTVAL, '"+partida.getMesa()+"','"+partida.getNumJugadores()+"','"+partida.getGanador()+"'";
		baseDatos.ejecutarInsert("PARTIDAS",valoresTabla);
	}
	
	public void insertParticipante(Participante participante) throws SQLException {
		String valoresTabla="'"+participante.getPartida()+"','"+participante.getJugador()+"'";
		baseDatos.ejecutarInsert("PARTICIPANTES",valoresTabla);
	}
	
	public boolean comprobarJugador(String idUsuario, String password)throws SQLException {
                return baseDatos.consultarCliente("CLIENTES","USUARIO,PASSWORD","USUARIO = '"+idUsuario+"' AND PASSWORD = '"+password+"'"); 
	}
	
	/**
	public void insertRonda(Rondas ronda) throws SQLException{
		String valoresTabla="'"+ronda.getRonda()+"','"+ronda.getPartida()+"','"+ronda.getValorMesa()+"','"+ronda.getGanador()+"'";
		baseDatos.ejecutarInsert("RONDAS",valoresTabla);
	}
	*/
	
	
}
