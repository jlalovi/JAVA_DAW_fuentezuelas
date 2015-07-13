package MetodosEstaticos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Empleados.Administrativo;
import Empleados.Analista;
import Empleados.Becario;
import Empleados.Programador;
import GestionPersonal.Empresa;

/**
 * 
 * 
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 15/05/2015
 * @since 15/05/2015
 */
public class BaseDatosEmpleadosMySQL {
	
	// Esta String indica de qué tipo es el servidor de la la BBDD
	static final String DB_URL = "jdbc:mysql://localhost/gestion_empleados";  


	// Acceso a la BBDD
	static final String USER = "root";
	static final String PASS = "root";
	
	/**
	 * Permite cargar todos los datos de la base de datos almacenados en el servidor MySQL y crear los objetos necesarios
	 * en el lado del cliente para aprovechar los métodos que ya realicé para este proyecto en versiones anteriores.
	 * 
	 * @param empresa
	 */
	public static void cargar(Empresa empresa) {
		
		
		//Propiedades de empleados que obtendré de la BBDD de MySQL fila a fila.
		String nombre;
		String ape1;
		String ape2;
		String dni;
		String centro_trabajo;
		String puesto_trabajo;
		boolean permite_capacidades;
		String capacidad;
		boolean borrado;
		
		Connection conn = null; // Objeto Connection, que establece la conexión entre la BBDD y este programa.
		Statement stmt = null;  // Objeto Statement, para indicar la sentencia de consulta que se quiere realiar en la BBDD
		 
		 try{
		    
			// DriveManager tiene un método estático que crea un objeto 'Connection'
		    conn = DriverManager.getConnection(DB_URL, USER, PASS); 
		    
		    // El objeto 'Connection' tiene un método que devuelve un objeto 'Statement'.
		    stmt = conn.createStatement(); 
		    
		    // Almaceno la sentencia que quiero ejecutar en MySQL en 'sql'
		    String sql = "select e.dni, e.nombre, e.ape1, e.ape2, e.centro_trabajo, e.puesto_trabajo, p.permite_capacidades, c.descripcion, e.borrado "+
					"from empleados e "+
						"left join conocimientos_empleado ce ON e.dni=ce.dni_empleado "+
							"left join capacidades c ON c.codigo=ce.codigo_capacidad "+
				        "left join puestos p ON p.puesto_trabajo=e.puesto_trabajo "+
				        "order by dni";
		    
		    // El objeto 'Statement' tiene un método que devuelve un objeto 'ResultSet'. Dicho método manipula el 'sql' guardado anteriormente que paso como parámetro.
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    // Reinicio la empresa, sustituyendo los datos que pudiese haber por los de la BBDD.
		    empresa.getEmpleados_borrados().clear();
		    empresa.getEmpleados().clear();
		    
		    // Este método recorre el 'ResultSet' fila a fila. El método devuelve true, si después de desplazarse una fila, existe otra fila a continuación.
		    while(rs.next()){
		       
		       //Almaceno temporalmente los datos de cada una de las columnas de la fila que estoy iterando.
		       dni = rs.getString("dni");
		       nombre = rs.getString("nombre");
		       ape1 = rs.getString("ape1");
		       ape2 = rs.getString("ape2");
		       centro_trabajo = rs.getString("centro_trabajo");
		       puesto_trabajo = rs.getString("puesto_trabajo");
		       permite_capacidades = rs.getBoolean("permite_capacidades");
		       capacidad = rs.getString("descripcion");
		       borrado = rs.getBoolean("borrado");
		       
		       //Creo Empleados y/o añado capacidades a partir de los datos anteriores recogidos temporalmente en esta iteración
		       if (!empresa.existeEmpleadoDNI(dni) &&
		    	   !empresa.existeEmpleadoBorradoDNI(dni))   { // Compruebo que el empleado NO existe en la BBDD de la empresa
		    	   if (!borrado) { //En caso de que el booleano borrado=false, añado al Arraylist de empleados
		    		   if ("Administrativo".equals(puesto_trabajo)) {
			    		   empresa.añadirEmpleado(new Administrativo(nombre, ape1, ape2, dni, centro_trabajo));
			    	   }
		    		   if ("Programador".equals(puesto_trabajo)) {
			    		   empresa.añadirEmpleado(new Programador(nombre, ape1, ape2, dni, centro_trabajo));
			    	   }
		    		   if ("Analista".equals(puesto_trabajo)) {
			    		   empresa.añadirEmpleado(new Analista(nombre, ape1, ape2, dni, centro_trabajo));
			    	   }
		    		   if ("Becario".equals(puesto_trabajo)) {
			    		   empresa.añadirEmpleado(new Becario(nombre, ape1, ape2, dni, centro_trabajo));
			    	   }
		    	   } // fin 'if !borrado'
		    	   if (borrado) { //En caso de que el booleano borrado=true, añado al Arraylist de empleados_borrados
		    		   if ("Administrativo".equals(puesto_trabajo)) {
			    		   empresa.añadirEmpleadoBorrado(new Administrativo(nombre, ape1, ape2, dni, centro_trabajo));
			    	   }
		    		   if ("Programador".equals(puesto_trabajo)) {
			    		   empresa.añadirEmpleadoBorrado(new Programador(nombre, ape1, ape2, dni, centro_trabajo));
			    	   }
		    		   if ("Analista".equals(puesto_trabajo)) {
			    		   empresa.añadirEmpleadoBorrado(new Analista(nombre, ape1, ape2, dni, centro_trabajo));
			    	   }
		    		   if ("Becario".equals(puesto_trabajo)) {
			    		   empresa.añadirEmpleadoBorrado(new Becario(nombre, ape1, ape2, dni, centro_trabajo));
			    	   }
		    	   } // fin 'if borrado'
		       } // fin crear nuevos empleados
		       
		       // Se añaden las capacidades en función de si el empleado las permite y de si se encuentra entre los 'borrados' o no
		       if (permite_capacidades){ // En caso de que el empleado permita capacidades
		    	   if (empresa.existeEmpleadoDNI(dni)) { // Si forma parte de los NO borrados:
		    		   empresa.añadirCapacidadTecnico(dni, capacidad);  
		    	   }
		    	   else if (empresa.existeEmpleadoBorradoDNI(dni)) { // Si forma parte de los borrados
		    		   empresa.añadirCapacidadTecnicoBorrado(dni, capacidad); 
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
