package JDBCExample;

//STEP 1. Import required packages
import java.sql.*;

public class JDBCExample {
 // JDBC driver name and database URL
 //static final String JDBC_DRIVER = "com.mysql.jdbc";
 static final String DB_URL = "jdbc:mysql://localhost/gestion_empleados"; // Esta String indica de qué tipo es el servidor de la la BBDD 
 																		 // (en este caso mysql) y la ruta del servidor donde está la BBDD.

 //  Database credentials
 static final String USER = "root";
 static final String PASS = "root";
 
 public static void main(String[] args) {
	 
 Connection conn = null; // Objeto Connection, que establece la conexión entre la BBDD y este programa.
 Statement stmt = null;  // Objeto Statement, para indicar la sentencia de consulta que se quiere realiar en la BBDD
 
 try{
    //STEP 2: Register JDBC driver
    //Class.forName(JDBC_DRIVER); // Esta línea antiguamente cargaba la clase con el driver 'com.mysql.jdbc.Driver'. No obstante, ya no es necesaria.

    //STEP 3: Open a connection
    System.out.println("Conectando a la Base de Datos...");
    conn = DriverManager.getConnection(DB_URL, USER, PASS); // DriveManager tiene un método estático que crea un objeto de tipo Conection
    System.out.println("Conexión exitosa...");
    
    //STEP 4: Execute a query
    System.out.println("Creando sentencia...");
    stmt = conn.createStatement(); // El objeto Conection tiene un método estático que devuelve un Objeto de tipo Statement.

    String sql = "select e.dni, e.nombre, e.ape1, e.ape2, e.centro_trabajo, e.puesto_trabajo, p.permite_capacidades, c.descripcion, e.borrado "+
					"from empleados e "+
						"left join conocimientos_empleado ce ON e.dni=ce.dni_empleado "+
							"left join capacidades c ON c.codigo=ce.codigo_capacidad "+
				        "left join puestos p ON p.puesto_trabajo=e.puesto_trabajo "+
				        "order by dni";
    
    ResultSet rs = stmt.executeQuery(sql); //El objeto Statement tiene un método estático que devuelve un Objeto de tipo ResultSet.
    
    //STEP 5: Extract data from result set
    while(rs.next()){ // Este método recorre la tabla fila a fila. El método devuelve true, si después de desplazarse una fila, existe otra fila a continuación
       
       //Retrieve by column name
       String dni = rs.getString("dni");
       String nombre = rs.getString("nombre");
       String ape1 = rs.getString("ape1");
       String ape2 = rs.getString("ape2");
       String centro_trabajo = rs.getString("centro_trabajo");
       String puesto_trabajo = rs.getString("puesto_trabajo");
       boolean permite_capacidades = rs.getBoolean("permite_capacidades");
       String capacidad = rs.getString("descripcion");
       boolean borrado = rs.getBoolean("borrado");
       

       //Muestro los resultados por consola en este ejemplo (Aquí lo que puedo hacer es trabajar con dichos datos obtenidos y hacer lo que quiera con ellos)
       System.out.print("DNI: " + dni);
       System.out.print(", NOMBRE: " + nombre);
       System.out.print(", APELLIDO1: " + ape1);
       System.out.print(", APELLIDO2: " + ape2);
       System.out.print(", CENTRO: " + centro_trabajo);
       System.out.print(", PUESTO: " + puesto_trabajo);
       System.out.print(", CAPACIDADES?: " + permite_capacidades);
       System.out.print(", CAPACIDAD: " + capacidad);
       System.out.println(", BORRADO?: " + borrado);
    }
    rs.close(); // Ojo con liberar de memoria el ResultSet una vez finalizado el proceso
    
 }catch(SQLException se){
    //Handle errors for JDBC
    se.printStackTrace();
    
 }catch(Exception e){
    //Handle errors for Class.forName
    e.printStackTrace();
    
 }finally{
    //finally block used to close resources
    try{
       if(stmt!=null)
          conn.close();
    }catch(SQLException se){
    }// do nothing
    try{
       if(conn!=null)
          conn.close();
    }catch(SQLException se){
       se.printStackTrace();
    }//end finally try
 }//end try
 
 System.out.println("Gracias por utilizar la BBDD!"); // Mensaje final para indicar que se han pasado por todos los procesos y ha concluído el programa
 
}//end main
}//end JDBCExample