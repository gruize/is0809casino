package ConexionBBDD;

import java.sql.*;
import java.util.*;

import javax.swing.table.DefaultTableModel;

/**
 * Clase OracleBD.
 * Clase que implementa la interface InterfaceBD con los métodos para el manejo básico
 * de la base de datos Oracle.
 * @author Joaquín López Cabezas
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
	 * Atributo de tipo String que contiene la contraseña del usuario que
	 * se conecta a la base de datos.
	 */
	private String contraseña;
	
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
	 * parámetro
	 * @param url Un String con la url de la base de datos. 
	 * @param user Un String con el nombre del usuario.
	 * @param password Un String con la contraseña del usuario
	 */
	public OracleBD(String url,String user,String password){
		urlBDOracle=url;
		usuario=user;
		contraseña=password;
	}
	
	/**
	 * Método que conecta con la base de datos Oracle, indicando la url y el
	 * nombre y cotraseña del usuario que se conecta.
	 * Después, nos creamos la sentencia SQL para poder moverse hacia delante
	 * y hacia atrás a través de los datos, e incluso, saltar a una posición
	 * concreta del conjunto de resultados.
	 * Si se produce un error en la conexión se lanza ua excepción SQL
	 */
	public void conectar() throws SQLException{
		conexion=DriverManager.getConnection(urlBDOracle, usuario, contraseña);
		if(!(conexion==null)){
			sentenciaSQL=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}
		else{
			throw new SQLException();
		}
	}
	
	/**
	 * Método que cierra la conexión entre la base de datos Oracle y la aplicación.
	 * Primero se cierra la sentencia SQL y después la conexión.
	 * Si se produce algún error durante la desconexión se lanza una excepción SQL.
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
	 * Método que ejecuta una consulta de selección.
	 * Primero se construye la consulta con los datos que recibe por parámetro.
	 * Después se conecta con la base de datos y se lanza la consulta.Si todo va
	 * bien, el resultado de la consulta se almacena en nustro ResultSet sino se 
	 * laza una excepción SQL y nos salimos.
	 * A contiuación, recorremos el resultado de la consulta para ir obteniendo los
	 * datos que después se cargarán en el modelo de la tabla que finalmente devolveremos.
	 * Si todo sale bien, la tabla irá cargada con los valores, sino la tabla valdrá null 
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
			//Voy añadiendo al ArrayList los valores de los campos de cada fila
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
	
	/**
	 * Método que ejecuta una consulta de actualización.
	 * Primero se construye la consulta y después se lanza.Una vez realizada
	 * la consulta se muestra el número de registros actualizados.
	 * Si se produce algún error se lanza una excepción SQL.
	 * @param tabla Un String con el nombre de la tabla que se va a actualizar.
	 * @param condicionSet Un String con la modificación.
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
	 * Método que ejecuta una cosulta de inserción.
	 * Primero se construye la consulta y después se lanza.
	 * Si el resultado de la consulta devuelve 0, significa que el nuevo 
	 * registro no ha sido insertado, sino devuelve 1 lo que significa 
	 * que la inserción se ha realizado correctametne.
	 * Si se produce algún error se lanza una excepción SQL.
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
	 * Método que ejecuta una consulta de borrado.
	 * Primero se construye la consulta y después se lanza.
	 * Si el resultado de la consulta devuelve 0, significa que no se ha  
	 * podido llevar a cabo el borrado,en cualquier otro caso si. 
	 * Si se produce algún error se lanza una excepción SQL.
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
