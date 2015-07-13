package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Clase para interactuar con la BBDD MySQL
 * 
 * @author Javier Latorre -> jlalovi@gmail.com
 */
public class MySQL {
	
	// Esta String indica de qué tipo es el servidor de la la BBDD
	static final String DB_URL = "jdbc:mysql://localhost/rss_data";  


	// Acceso a la BBDD
	static final String USER = "root";
	static final String PASS = "root";
	
	/**
	 * Permite cargar todos los datos de la base de datos almacenados en el servidor MySQL, almacenar los valores
	 * que corresponden a cada fila en 3 ArrayList diferentes correspondientes a sus nodos (titulo, enlace y descripcion)
	 * y devuelve dichos ArrayList dentro de otro ArrayList..
	 * 
	 */
	public static ArrayList<ArrayList<String>> cargar() {
		
		//Valores de los Nodos que obtendré de la BBDD de MySQL fila a fila.
		ArrayList<String> titulo = new ArrayList<String>();
		ArrayList<String> enlace = new ArrayList<String>();
		ArrayList<String> descripcion = new ArrayList<String>();
		
		Connection conn = null; // Objeto Connection, que establece la conexión entre la BBDD y este programa.
		Statement stmt = null;  // Objeto Statement, para indicar la sentencia de consulta que se quiere realiar en la BBDD
		 
		 try{
		    
			// DriveManager tiene un método estático que crea un objeto 'Connection'
		    conn = DriverManager.getConnection(DB_URL, USER, PASS); 
		    
		    // El objeto 'Connection' tiene un método que devuelve un objeto 'Statement'.
		    stmt = conn.createStatement(); 
		    
		    // Almaceno la sentencia que quiero ejecutar en MySQL en 'sql'
		    String sql = "SELECT titulo, enlace, descripcion "+
					"FROM feed";
		    
		    // El objeto 'Statement' tiene un método que devuelve un objeto 'ResultSet'. Dicho método manipula el 'sql' guardado anteriormente que paso como parámetro.
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    // Este método recorre el 'ResultSet' fila a fila. El método devuelve true, si después de desplazarse una fila, existe otra fila a continuación.
		    while(rs.next()){
		    
		    //Almaceno temporalmente los datos de cada una de las columnas de la fila que estoy iterando.
		    titulo.add(rs.getString("titulo").replaceAll("´", "'"));
		    enlace.add(rs.getString("enlace").replaceAll("´", "'"));
		    descripcion.add(rs.getString("descripcion").replaceAll("´", "'"));

		    }
		    rs.close(); // Ojo con liberar de memoria el ResultSet una vez finalizado el proceso
		    
		 }catch(SQLException se){
		    //Control de errores para 'JDBC'
		    se.printStackTrace();
		    
		 }catch(Exception e){
		    //Control de errores para 'Class.forName'
		    e.printStackTrace();
		    
		 }finally{
		    // Cierro la conexión en caso de no haber iniciado una sentencia o la conexión
		    try{
		       if(stmt!=null)
		          conn.close();
		    }catch(SQLException se){
		    }
		    try{
		       if(conn!=null)
		          conn.close();
		    }catch(SQLException se){
		       se.printStackTrace();
		    }
		 }//end try
		
		 ArrayList<ArrayList<String>> nodos = new ArrayList<ArrayList<String>>();
		 nodos.add(titulo);
		 nodos.add(enlace);
		 nodos.add(descripcion);
		 
		 return nodos;
		 
	}
	
	/**
	 * Permite enviar una sentencia SQL de modificación especificada a la BBSS. Para ello, evidentemente, hay que
	 * conocer la BBDD que se está manipulando, para saber exactamente qué sentencia escribir.
	 * 
	 * @param sentenciaSQL ¡Sólo puede ser una de tipo DELETE, UPDATE o INSERT!
	 */
	public static void modificar(String sentenciaSQL) {
				
		Connection conn = null; // Objeto Connection, que establece la conexión entre la BBDD y este programa.
		Statement stmt = null;  // Objeto Statement, para indicar la sentencia de consulta que se quiere realiar en la BBDD
		 
		 try{
		    
			// DriveManager tiene un método estático que crea un objeto 'Connection'
		    conn = DriverManager.getConnection(DB_URL, USER, PASS);
		    
		    // El objeto 'Connection' tiene un método que devuelve un objeto 'Statement'.
		    stmt = conn.createStatement();
		    
		    // El objeto 'Statement' tiene un método que ejecuta la sentencia SQL pasada por el parámetro.
		    stmt.executeUpdate(sentenciaSQL);
		    
		 }catch(SQLException se){
		    //Control de errores para 'JDBC'
		    se.printStackTrace();
		    
		 }catch(Exception e){
		    //Control de errores para 'Class.forName'
		    e.printStackTrace();
		    
		 }finally{
		    // Cierro la conexión en caso de no haber iniciado una sentencia o la conexión
		    try{
		       if(stmt!=null)
		          conn.close();
		    }catch(SQLException se){
		    }
		    try{
		       if(conn!=null)
		          conn.close();
		    }catch(SQLException se){
		       se.printStackTrace();
		    }
		 }//end try
		
	}

}