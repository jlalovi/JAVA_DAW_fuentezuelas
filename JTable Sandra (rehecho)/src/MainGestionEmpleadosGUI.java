import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JButton;

import java.sql.*;


public class MainGestionEmpleadosGUI extends JFrame {
	
	private JFrame frame; //***

	private JPanel contentPane;
	private JTable table; //Tabla
	private DefaultTableModel ModeloEmpresario; //Modelo de tabla
	private JTextField textField; //JTextField del botón "Buscar"
	private JTextField textField_1; //JTextField del botón "Eliminar"
	
	//__________BASE DE DATOS__________
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/ProyectoProgramacion";

	//  Database credentials
	static final String USER = "root";
    static final String PASS = "root";
    private JScrollPane scrollPane;
		   
	//___________________________________

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGestionEmpleadosGUI frame = new MainGestionEmpleadosGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public MainGestionEmpleadosGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Dónde saldrá la ventana al ejecutarse
		setBounds(100, 100, 1200, 400); //Las dos primeras son las coordenadas X e Y. Las otras dos son el ancho y el alto... (X,Y,ancho,alto)
		
		//Editamos el panel de fondo
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setResizeWeight(0.75);
		contentPane.add(splitPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 102));
		splitPane.setRightComponent(panel);
		
		//____BOTON "AÑADIR NUEVO EMPLEADO"____
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			
			//Acción al clikar...
			public void actionPerformed(ActionEvent arg0) {
				DialogoEmpleados e = new DialogoEmpleados(frame,"hola",true); //***Lo del paréntesis es por el constructor de la clase Empleados (lo que hemos metido para hacer fufar la tabla)
				e.setVisible(true);
				
				//Para la Tabla...
				//ModeloEmpresario = (DefaultTableModel) table.getModel();
				//ModeloEmpresario.addRow(new Object[] { e.getMiEmpleado().getNombre(), e.getMiEmpleado().getApellido1(), e.getMiEmpleado().getApellido2(), e.getMiEmpleado().getDNI()});
			}
		});
		panel.add(btnNuevo);
		
		scrollPane = new JScrollPane(); //DECLARACION SCROLLPANE (Si sigue dando error... vamos al diseño y hacemos click en el botón "convertir en local")
		
		//____BOTÓN "CARGAR"____
		
		JButton btnCargar = new JButton("Cargar Tabla");
		btnCargar.addActionListener(new ActionListener() {
			
			//Acción al clikar...
			public void actionPerformed(ActionEvent arg0) {
				table = new JTable(cargarBD());
				scrollPane.setViewportView(table);
			}
			
		});
		panel.add(btnCargar);
		
		//____BOTÓN "ORDENAR POR NOMBRE"____
		
		JButton btnOrdenarPorNombre = new JButton("Ordenar Por Nombre");
		btnOrdenarPorNombre.addActionListener(new ActionListener() {

			//Acción al clikar...
			public void actionPerformed(ActionEvent arg0) {
				table = new JTable(ordenarPorNombre());
				scrollPane.setViewportView(table);
			}
			
		});
		panel.add(btnOrdenarPorNombre);
		
		//____COMBOBOX "ORDENAR POR"____
		
		JComboBox comboBox = new JComboBox();
		
		String[] ordenString = {"Ordenar por Nombre", "Ordenar por Apellido 1", "Ordenar por Apellido 2", "Ordenar por Centro", "Ordenar por Categoría"}; //Creamos un vector de String con las opciones que tendrá el combobox
		//Create the combo box, select item at index 4 -- Indices start at 0, so 4 specifies the pig
		comboBox = new JComboBox(ordenString); //Creamos el combobox
		comboBox.setBounds(120, 110, 170, 20);
		comboBox.addActionListener(new ActionListener() { //Añadimos acción o evento
			public void actionPerformed (ActionEvent e) {
			
			}
		
		});
		panel.add(comboBox); //Se añade al panel
		
		//____BOTÓN "BUSCAR POR DNI"____
		
		JLabel lblBuscarPor = new JLabel("Buscar por DNI:");
		panel.add(lblBuscarPor);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			
			//Acción al clickar...
			public void actionPerformed(ActionEvent arg0) {
				table = new JTable(buscarPorDni()); //Generamos una tabla que llama al método
				scrollPane.setViewportView(table);
			}
			
		});
		panel.add(btnBuscar);
		
		//____BOTÓN "ELIMINAR MEDIANTE DNI"____
		
		JLabel lblEliminarPor = new JLabel("Eliminar mediante DNI:");
		panel.add(lblEliminarPor);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			
			//Acción al clickar...
			public void actionPerformed(ActionEvent arg0) {
				eliminarPorDni(); //Llamamos al método que elimina las filas de la tabla que tienen empleados con ese DNI
			}
			
		});
		panel.add(btnEliminar);
		
		//____TABLA____ TODO
		
		splitPane.setLeftComponent(scrollPane);
		
		table = new JTable();
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//				"Nombre", "Apellido 1", "Apellido 2", "DNI", "Centro", "Categor\u00EDa", "Tecnolog\u00EDas"
//			}
//		) {
//			boolean[] columnEditables = new boolean[] {
//				false, false, false, false, false, false, false
//			};
//			public boolean isCellEditable(int row, int column) {
//				return columnEditables[column];
//			}
//		});
		scrollPane.setViewportView(table);
		splitPane.setDividerLocation(300);
		
	}
	
	//____________________________________________________________Método para leer de la base de datos____________________________________________________________
	public DefaultTableModel cargarBD() {
		
		DefaultTableModel tableModel = new DefaultTableModel();
		
		Connection conn = null;
		Statement stmt = null;
		
		try{
		    //STEP 2: Register JDBC driver
		    Class.forName("com.mysql.jdbc.Driver");

		    //STEP 3: Open a connection
		    System.out.println("Connecting to a selected database...");
		    conn = DriverManager.getConnection(DB_URL, USER, PASS);
		    System.out.println("Connected database successfully...");
		      
		    //STEP 4: Execute a query
		    System.out.println("Creating statement...");
		    stmt = conn.createStatement();

		    String sql = "SELECT * FROM empresarios";
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    //Modelo de la tabla
		    String[] columnNames = {"Nombre","Apellido1","Apellido2","DNI","Centro","Categoría","Tecnologías"};
		    tableModel.setColumnIdentifiers(columnNames);
		    Object fila[] = new Object[7];
		    
		    //STEP 5: Extract data from result set
		    while(rs.next()){
		       //Retrieve by column name
		       fila[0] = rs.getObject(1);
		       fila[1] = rs.getObject(2);
		       fila[2] = rs.getObject(3);
		       fila[3] = rs.getObject(4);
		       fila[4] = rs.getObject(5);
		       fila[5] = rs.getObject(6);
		       fila[6] = rs.getObject(7);

		       tableModel.addRow(fila);
		    }
		    
		    rs.close();
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
		 System.out.println("Goodbye!");
		 
		 return tableModel;
	}
	
	//________________________________________Método que elimina una fila de la tabla pasándole el DNI del empleado________________________________________
	public void eliminarPorDni() {
		
		Connection conn = null;
		Statement stmt = null;
		
		try{
		    //STEP 2: Register JDBC driver
		    Class.forName("com.mysql.jdbc.Driver");

		    //STEP 3: Open a connection
		    System.out.println("Connecting to a selected database...");
		    conn = DriverManager.getConnection(DB_URL, USER, PASS);
		    System.out.println("Connected database successfully...");
		      
		    //STEP 4: Execute a query
		    System.out.println("Creating statement...");
		    stmt = conn.createStatement();
		    String sql = "DELETE FROM empresarios " + "WHERE dni = '"+textField_1.getText()+"'";
		    stmt.executeUpdate(sql);

		    System.out.println("Deleted records from the table...");

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
		System.out.println("Goodbye!");
	}
	
	//____________________________________________________________Método que busca un empleado por DNI____________________________________________________________
	public DefaultTableModel buscarPorDni() {
		
		DefaultTableModel tableModel = new DefaultTableModel();
		
		Connection conn = null;
		Statement stmt = null;
		
		try{
			//STEP 2: Register JDBC driver
		    Class.forName("com.mysql.jdbc.Driver");

		    //STEP 3: Open a connection
		    System.out.println("Connecting to a selected database...");
		    conn = DriverManager.getConnection(DB_URL, USER, PASS);
		    System.out.println("Connected database successfully...");
		     
		    //STEP 4: Execute a query
		    System.out.println("Creating statement...");
		    stmt = conn.createStatement();

		    String sql = "SELECT * FROM empresarios WHERE dni LIKE '"+textField.getText()+"%'";
		    ResultSet rs = stmt.executeQuery(sql);

		    //Ahora le paso el modelo de tabla (ya que en mi JTable me tiene que mostrar solo el empleado deseado)
		    String[] columnNames = {"Nombre","Apellido1","Apellido2","DNI","Centro","Categoría","Tecnologías"};
		    tableModel.setColumnIdentifiers(columnNames);
		    Object fila[] = new Object[7];
		    
		    //STEP 5: Extract data from result set
		    while(rs.next()){
		       //Retrieve by column name
		       fila[0] = rs.getObject(1);
		       fila[1] = rs.getObject(2);
		       fila[2] = rs.getObject(3);
		       fila[3] = rs.getObject(4);
		       fila[4] = rs.getObject(5);
		       fila[5] = rs.getObject(6);
		       fila[6] = rs.getObject(7);

		       tableModel.addRow(fila);
		    }
		    
		    rs.close();
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
		System.out.println("Goodbye!");
		
		return tableModel;
	}
	
	//____________________________________________________________Método que ordena la tabla por nombre____________________________________________________________
	
	public DefaultTableModel ordenarPorNombre() {
		
		DefaultTableModel tableModel = new DefaultTableModel();
		
		Connection conn = null;
		Statement stmt = null;
		
		try{
			//STEP 2: Register JDBC driver
		    Class.forName("com.mysql.jdbc.Driver");

		    //STEP 3: Open a connection
		    System.out.println("Connecting to a selected database...");
		    conn = DriverManager.getConnection(DB_URL, USER, PASS);
		    System.out.println("Connected database successfully...");
		     
		    //STEP 4: Execute a query
		    System.out.println("Creating statement...");
		    stmt = conn.createStatement();

		    String sql = "SELECT * FROM empresarios ORDER BY nombre ASC";
		    ResultSet rs = stmt.executeQuery(sql);

		    //Ahora le paso el modelo de tabla (ya que en mi JTable me tiene que mostrar solo el empleado deseado)
		    String[] columnNames = {"Nombre","Apellido1","Apellido2","DNI","Centro","Categoría","Tecnologías"};
		    tableModel.setColumnIdentifiers(columnNames);
		    Object fila[] = new Object[7];
		    
		    //STEP 5: Extract data from result set
		    while(rs.next()){
		       //Retrieve by column name
		       fila[0] = rs.getObject(1);
		       fila[1] = rs.getObject(2);
		       fila[2] = rs.getObject(3);
		       fila[3] = rs.getObject(4);
		       fila[4] = rs.getObject(5);
		       fila[5] = rs.getObject(6);
		       fila[6] = rs.getObject(7);

		       tableModel.addRow(fila);
		    }
		    
		    rs.close();
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
		System.out.println("Goodbye!");
		
		return tableModel;
	}
	
}
