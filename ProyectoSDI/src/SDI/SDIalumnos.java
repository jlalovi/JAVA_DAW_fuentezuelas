package SDI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JList;

import SDI.DialogoAlumno.BotonPulsado;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SDIalumnos extends JFrame {

	private JPanel contentPane;
	private JList<Alumno> list;
	
	private DefaultListModel<Alumno> ModeloAlumno; // Esto lo estamos creando para crear una colección de alumnos en el JList

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SDIalumnos frame = new SDIalumnos();
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
	public SDIalumnos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAlumnos = new JMenu("Alumnos");
		menuBar.add(mnAlumnos);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alumno aux=new Alumno(); // Constructor vacío para alumno en la siguiente línea
				DialogoAlumno yo = new DialogoAlumno(SDIalumnos.this, "Creando nuevo alumno", true, aux); // aux para alumno vacío
				
				yo.setVisible(true);
				ModeloAlumno.addElement(yo.getMiAlumno()); // El getter de esto se ha creado en 'DialogoAlumno'
				
				if (yo.getResultado()==BotonPulsado.OK) { // Este if no hace falta en este ejemplo, es para introducir el uso de botones definidos.	
				}
				
				
				
			}
		});
		mnAlumnos.add(mntmNuevo);
		
		JMenuItem mntmBorrar = new JMenuItem("Borrar");
		mntmBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModeloAlumno.removeElement(list.getSelectedValue()); // Si no se selecciona ningún valor, no pasa nada.
			}
		});
		mnAlumnos.add(mntmBorrar);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnAlumnos.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		ModeloAlumno=new DefaultListModel<Alumno>();
		list = new JList(ModeloAlumno);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
					Alumno aux=list.getSelectedValue();
					DialogoAlumno editar=new DialogoAlumno(SDIalumnos.this, "Editando alumno", true, aux);
					editar.setVisible(true);
				}
			}
		});
		contentPane.add(list, BorderLayout.CENTER);
	}

}
