import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JSpinner;
import javax.swing.border.LineBorder;


public class DialogoEmpleados extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JTextField textDNI;
	private JScrollPane scrollPane;
	private JComboBox comboBox2;
	private JComboBox comboBox;
	private JEditorPane editorPane;
	private Empleado miEmpleado; //Creamos un empleado de la clase Empleado
	
	//__________BASE DE DATOS__________
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/ProyectoProgramacion";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "root";
	
			   
	//___________________________________
	
	//GETTERS & SETTERS
	public Empleado getMiEmpleado() {
		return miEmpleado;
	}

	public void setMiEmpleado(Empleado miEmpleado) {
		this.miEmpleado = miEmpleado;
	}

	/**
	 * Create the dialog.
	 */
	public DialogoEmpleados(JFrame frame, String Titulo, boolean modal) { //Lo del paréntesis es para que funcione la tabla cuando metamos empleados nuevos
		//Dónde saldrá la ventana ejecutarse
		setBounds(550, 100, 320, 450); //Las dos primeras son las coordenadas X e Y. Las otras dos son el ancho y el alto... (X,Y,ancho,alto)
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(204, 255, 204));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nombre");
			lblNewLabel.setBounds(10, 11, 100, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			textNombre = new JTextField();
			textNombre.setBounds(120, 8, 170, 20);
			contentPanel.add(textNombre);
			textNombre.setColumns(10);
		}
		{
			JLabel lblPrimerApellido = new JLabel("Primer Apellido");
			lblPrimerApellido.setBounds(10, 36, 100, 14);
			contentPanel.add(lblPrimerApellido);
		}
		{
			textApellido1 = new JTextField();
			textApellido1.setBounds(120, 33, 170, 20);
			contentPanel.add(textApellido1);
			textApellido1.setColumns(10);
		}
		{
			JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
			lblSegundoApellido.setBounds(10, 61, 100, 14);
			contentPanel.add(lblSegundoApellido);
		}
		{
			textApellido2 = new JTextField();
			textApellido2.setBounds(120, 58, 170, 20);
			contentPanel.add(textApellido2);
			textApellido2.setColumns(10);
		}
		{
			JLabel lblDni = new JLabel("DNI");
			lblDni.setBounds(10, 86, 100, 14);
			contentPanel.add(lblDni);
		}
		{
			textDNI = new JTextField();
			textDNI.setBounds(120, 83, 170, 20);
			contentPanel.add(textDNI);
			textDNI.setColumns(10);
		}
		{
			JLabel lblCentroDeTrabajo = new JLabel("Centro");
			lblCentroDeTrabajo.setBounds(10, 112, 100, 14);
			contentPanel.add(lblCentroDeTrabajo);
		}
		{
			//__________COMBOBOX 2__________
			
			String[] centroString = {"1", "2", "3"}; //Creamos un vector de String con las opciones que tendrá el combobox
			//Create the combo box, select item at index 4 -- Indices start at 0, so 4 specifies the pig
			comboBox2 = new JComboBox(centroString); //Creamos el combobox
			comboBox2.setBounds(120, 110, 170, 20);
			//__addActionListener__
			comboBox2.addActionListener(new ActionListener() { //Añadimos acción o evento
				
				public void actionPerformed (ActionEvent e) {	
					String op2 = (String)((JComboBox)e.getSource()).getSelectedItem(); //Aquí guardamos lo que se ha escrito en un String	
					JOptionPane.showMessageDialog(DialogoEmpleados.this, "Ha elegido " + op2); //Aquí decimos que muestre un mensaje
					}
				
				});
					
			contentPanel.add(comboBox2); //Se añade al panel
		}
		{
			JLabel lblCategora = new JLabel("Categor\u00EDa");
			lblCategora.setBounds(10, 170, 100, 14);
			contentPanel.add(lblCategora);
		}
		{
			//__________COMBOBOX 1__________
			
			String[] categoriasString = {"Administrativo", "Programador", "Analista", "Técnico Becario"}; //Creamos un vector de String con las opciones que tendrá el combobox
			//Create the combo box, select item at index 4 -- Indices start at 0, so 4 specifies the pig
			comboBox = new JComboBox(categoriasString); //Creamos el combobox
			comboBox.setBounds(120, 167, 170, 20);
			comboBox.addActionListener(new ActionListener() { //Añadimos acción o evento
				
				public void actionPerformed (ActionEvent e) {	
					String op = (String)((JComboBox)e.getSource()).getSelectedItem(); //Aquí guardamos lo que se ha escrito en un String	
					JOptionPane.showMessageDialog(DialogoEmpleados.this, "Ha elegido " + op); //Aquí decimos que muestre un mensaje
					}
				
				});
					
			contentPanel.add(comboBox); //Se añade al panel
		}
		{
			JLabel lblTecnologasQueDomina = new JLabel("Tecnolog\u00EDas que domina");
			lblTecnologasQueDomina.setBounds(10, 230, 157, 14);
			contentPanel.add(lblTecnologasQueDomina);
		}
		
		editorPane = new JEditorPane();
		editorPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		editorPane.setBounds(10, 255, 280, 100);
		contentPanel.add(editorPane);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 204, 102));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					
					//Acción al clickar
					public void actionPerformed(ActionEvent arg0) {
						//setMiEmpleado(new Empleado(textNombre.getText(),textApellido1.getText(),textApellido2.getText(),textDNI.getText())); //Aquí hay que meter lo que haya en el constructor de la clase Empleado
						
						insertarDatos(); //Llamamos al método que inserta los datos en la base de datos
						
						DialogoEmpleados.this.setVisible(false);
					}
					
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					
					//Acción al clickar
					public void actionPerformed(ActionEvent arg0) {
						DialogoEmpleados.this.setVisible(false); //Esto es para cerrarlo
					}
					
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	//____________________________________________________________Método para guardar en la base de datos____________________________________________________________
	public void insertarDatos() {
		
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
		   System.out.println("Inserting records into the table...");
		   stmt = conn.createStatement();
		      
		   String sql = "INSERT INTO empresarios " + "VALUES ('"+textNombre.getText()+"','"+textApellido1.getText()+"','"+textApellido2.getText()+"','"+textDNI.getText()+"','"+comboBox2.getSelectedItem().toString()+"','"+comboBox.getSelectedItem().toString()+"','"+editorPane.getText()+"')";
		   stmt.executeUpdate(sql);
		   
		   System.out.println("Inserted records into the table...");
		   
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
	
}
