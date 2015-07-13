package clasesEstaticas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import discoteca.Cancion;
import discoteca.Disco;
import discoteca.Discoteca;

public class BBDD_SQL {

	// Esta String indica de qué tipo es el servidor de la la BBDD
	static final String DB_URL = "jdbc:mysql://localhost/Discoteca";  


	// Acceso a la BBDD
	static final String USER = "root";
	static final String PASS = "root";
	
	/**
	 * Crea objetos Disco a partir de la BBDD SQL y los almacena en la discoteca
	 * 
	 * @param discoteca
	 */
	public static void cargarDiscos(Discoteca discoteca) {
		
		//Propiedades de empleados que obtendré de la BBDD de MySQL fila a fila.
		String codigo;
		String titulo;
		String autor;
		String precio;
		
		Connection conn = null; // Objeto Connection, que establece la conexión entre la BBDD y este programa.
		Statement stmt = null;  // Objeto Statement, para indicar la sentencia de consulta que se quiere realiar en la BBDD
		 
		try{
		    
			// DriveManager tiene un método estático que crea un objeto 'Connection'
		    conn = DriverManager.getConnection(DB_URL, USER, PASS); 
		    
		    // El objeto 'Connection' tiene un método que devuelve un objeto 'Statement'.
		    stmt = conn.createStatement(); 
		    
		    // Almaceno la sentencia que quiero ejecutar en MySQL en 'sql'
		    String sql = "SELECT * FROM Discos";
		    
		    // El objeto 'Statement' tiene un método que devuelve un objeto 'ResultSet'. Dicho método manipula el 'sql' guardado anteriormente que paso como parámetro.
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    // Reinicio la discoteca, sustituyendo los datos que pudiese haber por los de la BBDD.
		    // discoteca.getDiscos().clear();
		    
		    // Este método recorre el 'ResultSet' fila a fila. El método devuelve true, si después de desplazarse una fila, existe otra fila a continuación.		    
		    while(rs.next()){
		    	
		    	codigo = rs.getString("Codigo");
		    	titulo = rs.getString("Titulo");
		    	autor = rs.getString("Autor");
		    	precio = rs.getString("Precio");
		    	
		    	discoteca.añadirDisco(new Disco(codigo, titulo, autor, precio)); // Añado los discos de la BBDD a discoteca.
		    	
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
	
	}
	
	/**
	 * Crea objetos Canción a partir de la BBDD SQL y las almacena en sus correspondientes DIscos.
	 * 
	 * @param discoteca
	 */
	public static void cargarCanciones(Discoteca discoteca) {
		
		//Propiedades de empleados que obtendré de la BBDD de MySQL fila a fila.
		String codigo_disco;
		int n_pista;
		String titulo;
		int duracion;
		
		Connection conn = null; // Objeto Connection, que establece la conexión entre la BBDD y este programa.
		Statement stmt = null;  // Objeto Statement, para indicar la sentencia de consulta que se quiere realiar en la BBDD
		 
		try{
		    
			// DriveManager tiene un método estático que crea un objeto 'Connection'
		    conn = DriverManager.getConnection(DB_URL, USER, PASS); 
		    
		    // El objeto 'Connection' tiene un método que devuelve un objeto 'Statement'.
		    stmt = conn.createStatement(); 
		    
		    // Almaceno la sentencia que quiero ejecutar en MySQL en 'sql'
		    String sql = "SELECT * FROM Canciones";
		    
		    // El objeto 'Statement' tiene un método que devuelve un objeto 'ResultSet'. Dicho método manipula el 'sql' guardado anteriormente que paso como parámetro.
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    // Reinicio la discoteca, sustituyendo los datos que pudiese haber por los de la BBDD.
		    // discoteca.getDiscos().clear();
		    
		    // Este método recorre el 'ResultSet' fila a fila. El método devuelve true, si después de desplazarse una fila, existe otra fila a continuación.		    
		    while(rs.next()){
		    	
		    	codigo_disco = rs.getString("Disco");
		    	n_pista = rs.getInt("NumPista");
		    	titulo = rs.getString("Titulo");
		    	duracion = rs.getInt("Duracion");
		    	
		    	Cancion cancion_nueva = new Cancion(codigo_disco, n_pista, titulo, duracion);
		    	
		    	for (Disco d: discoteca.getDiscos()) {
		    		if (d.getCodigo().equals(codigo_disco)) { // Añado canciones al disco del mismo código
		    			d.añadirCancion(cancion_nueva);
		    		}
				}
		    			    	
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
	
	}
	
}
