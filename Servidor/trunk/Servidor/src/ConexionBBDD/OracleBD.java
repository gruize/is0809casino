package ConexionBBDD;

import java.sql.*;
import java.util.*;

import javax.swing.table.DefaultTableModel;

/**
 * Clase OracleBD.
 * Clase que implementa la interface InterfaceBD con los m�todos para el manejo b�sico
 * de la base de datos Oracle.
 * @author Joaqu�n L�pez Cabezas
 * @version 1.0
 *
 */
public class OracleBD{

	/**
	 * Atributo de tipo Connection con el que se establece la conexion y
	 * desconexion entre la base de datos y la aplicacion.
	 */
	private Connection conexion;
	
	/**
	 * Atributo de tipo String que contiene la url de la base de datos.
	 */
	private String urlBDOracle;
	
	/**
	 * Atributo de tipo String que contiene el nombre del usuario que 
	 * se conecta a la base de datos
	 */
	private String usuario;
	
	/**
	 * Atributo de tipo String que contiene la contrase�a del usuario que
	 * se conecta a la base de datos.
	 */
	private String contrasena;
	
	/**
	 * Atributo de tipo Statement para la sentencia SQL
	 */
	private Statement sentenciaSQL;
	
	/**
	 * Atributo de tipo ResultSet en el que se almacenan los resultados
	 * de la consulta
	 */
	private ResultSet resultadoConsulta;
	
	/**
	 * Constructor que inicializa los atributos a los valores que recibe por
	 * par�metro
	 * @param url Un String con la url de la base de datos. 
	 * @param user Un String con el nombre del usuario.
	 * @param password Un String con la contrase�a del usuario
	 */
	public OracleBD(String url,String user,String password){
		urlBDOracle=url;
		usuario=user;
		contrasena=password;
	}
	
	/**
	 * M�todo que conecta con la base de datos Oracle, indicando la url y el
	 * nombre y cotrase�a del usuario que se conecta.
	 * Despu�s, nos creamos la sentencia SQL para poder moverse hacia delante
	 * y hacia atr�s a trav�s de los datos, e incluso, saltar a una posici�n
	 * concreta del conjunto de resultados.
	 * Si se produce un error en la conexi�n se lanza ua excepci�n SQL
	 */
	public void conectar() throws SQLException{
		conexion=DriverManager.getConnection(urlBDOracle, usuario, contrasena);
		if(!(conexion==null)){
			sentenciaSQL=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}
		else{
			throw new SQLException();
		}
	}
	
	/**
	 * M�todo que cierra la conexi�n entre la base de datos Oracle y la aplicaci�n.
	 * Primero se cierra la sentencia SQL y despu�s la conexi�n.
	 * Si se produce alg�n error durante la desconexi�n se lanza una excepci�n SQL.
	 */
	public void desconectar() throws SQLException{
		if(!conexion.isClosed()){
			sentenciaSQL.close();
			conexion.close();
		}
		else{
			throw new SQLException();
		}
	}
	
	/**
	 * M�todo que ejecuta una consulta de selecci�n.
	 * Primero se construye la consulta con los datos que recibe por par�metro.
	 * Despu�s se conecta con la base de datos y se lanza la consulta.Si todo va
	 * bien, el resultado de la consulta se almacena en nustro ResultSet sino se 
	 * laza una excepci�n SQL y nos salimos.
	 * A contiuaci�n, recorremos el resultado de la consulta para ir obteniendo los
	 * datos que despu�s se cargar�n en el modelo de la tabla que finalmente devolveremos.
	 * Si todo sale bien, la tabla ir� cargada con los valores, sino la tabla valdr� null 
	 * @param tablas Un String con el nombre de las tablas que se van a consultar.
	 * @param campos Un String con los campos que se van a consulta.
	 * @param condicionWhere Un String con las condiciones de la consulta.
	 * @return Un ModeloDeTabla con los resultados de la consulta.Es un DefaultTableModel
	 * pero con las celdas no editables
	 */
	public DefaultTableModel ejecutarSelect(String tablas, String campos, String condicionWhere) throws SQLException{
		String consulta="SELECT "+campos+" FROM "+tablas;
		if(!condicionWhere.equals("")){
			consulta+=" WHERE "+condicionWhere;
		}
		System.out.println(consulta);
		conectar();
		resultadoConsulta=sentenciaSQL.executeQuery(consulta);
		if(resultadoConsulta==null){
			throw new SQLException();
		}		
		ArrayList<Object> listaResultados=new ArrayList<Object>();
		int numFilas = 0;
		//por cada fila del resultado de la consulta
		while (resultadoConsulta.next()) {
			//cojo los campos de la consulta(ej: CODIGO,NOMBRE,APES)
			StringTokenizer camposConsulta = new StringTokenizer(campos,",");
			//Voy a�adiendo al ArrayList los valores de los campos de cada fila
			while (camposConsulta.hasMoreTokens()){
				listaResultados.add(resultadoConsulta.getObject(camposConsulta.nextToken()));
			}
			numFilas++;
		}
		resultadoConsulta.close();
		desconectar();
		//Si hay filas con valores, se cargan en la tabla
		if (numFilas>0){
			DefaultTableModel tabla=new DefaultTableModel(numFilas,listaResultados.size()/numFilas);
			int k=0;
			for (int i=0; i<tabla.getRowCount(); i++){
				for(int j=0; j<tabla.getColumnCount(); j++) { 
					tabla.setValueAt(listaResultados.get(k++),i,j);
				}
			}
			return tabla;
		}
		return null;
	}
	
	public boolean consultarCliente(String tablas, String campos, String condicionWhere) throws SQLException {
		
		String consulta="SELECT "+campos+" FROM "+tablas;
		if(!condicionWhere.equals("")){
			consulta+=" WHERE "+condicionWhere;
		}
		System.out.println(consulta);
		conectar();
		resultadoConsulta=sentenciaSQL.executeQuery(consulta);
		if(resultadoConsulta==null){
			desconectar();
			return false;
		}
		desconectar();
		return true;
	}
	/**
	 * M�todo que ejecuta una consulta de actualizaci�n.
	 * Primero se construye la consulta y despu�s se lanza.Una vez realizada
	 * la consulta se muestra el n�mero de registros actualizados.
	 * Si se produce alg�n error se lanza una excepci�n SQL.
	 * @param tabla Un String con el nombre de la tabla que se va a actualizar.
	 * @param condicionSet Un String con la modificaci�n.
	 * @param condicionWhere Un String para coger el conjunto de tuplas que se van a actualizar.
	 */
	public void ejecutarUpdate(String tabla, String condicionSet, String condicionWhere) throws SQLException{
		String consulta="UPDATE "+tabla+" SET "+condicionSet;
		if(!condicionWhere.equals("")){
			consulta+=" WHERE "+condicionWhere;
		}
		conectar();
		int numActualizaciones=sentenciaSQL.executeUpdate(consulta);
		if(numActualizaciones==0){
			throw new SQLException();
		}
		desconectar();
	}
	
	/**
	 * M�todo que ejecuta una cosulta de inserci�n.
	 * Primero se construye la consulta y despu�s se lanza.
	 * Si el resultado de la consulta devuelve 0, significa que el nuevo 
	 * registro no ha sido insertado, sino devuelve 1 lo que significa 
	 * que la inserci�n se ha realizado correctametne.
	 * Si se produce alg�n error se lanza una excepci�n SQL.
	 * @param tabla Un Stirng con el nombre de la tabla en la que se va a insertar.
	 * @param valores Un String con los valores que se van a insertar en cada campo de la tabla.
	 */
	public void ejecutarInsert(String tabla, String valores) throws SQLException{
		String consulta="INSERT INTO "+tabla+" VALUES "+"("+valores+")";
		conectar();
		int numInserciones=sentenciaSQL.executeUpdate(consulta);
		if(numInserciones==0){
			throw new SQLException();
		}
		desconectar();
	}
	
	/**
	 * M�todo que ejecuta una consulta de borrado.
	 * Primero se construye la consulta y despu�s se lanza.
	 * Si el resultado de la consulta devuelve 0, significa que no se ha  
	 * podido llevar a cabo el borrado,en cualquier otro caso si. 
	 * Si se produce alg�n error se lanza una excepci�n SQL.
	 * @param tabla Un String con el nombre de la tabla en la que se va a borrar. 
	 * @param condicionWhere Un String con posibles condiciones de borrado.
	 */
	public void ejecutarDelete(String tabla, String condicionWhere) throws SQLException{
		String consulta="DELETE FROM "+tabla+" WHERE "+condicionWhere;
		conectar();
		int numBorrado=sentenciaSQL.executeUpdate(consulta);
		if(numBorrado==0){
			throw new SQLException();
		}
		desconectar();
	}
}
