package principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;

import JDialogo.DialogoInfoDisco;
import clasesEstaticas.BBDD_SQL;
import clasesEstaticas.DefaultTableModelPersonal;
import discoteca.Discoteca;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



@SuppressWarnings("serial")
public class MainGestionDiscosGUI extends JFrame {

	private JPanel contentPane;
	private JTable table; //Tabla
	JScrollPane scrollPane;
	private JButton btnMostrarDetallesDel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGestionDiscosGUI frame = new MainGestionDiscosGUI();
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
	public MainGestionDiscosGUI() {
		setName("frame");
		
		final Discoteca discoteca= new Discoteca(); // Discoteca donde se almacenarán los discos.
		BBDD_SQL.cargarDiscos(discoteca); // Cargo discos a la discoteca
		BBDD_SQL.cargarCanciones(discoteca); // Cargo canciones a la discoteca
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Dónde saldrá la ventana al ejecutarse
		setBounds(100, 100, 800, 400);
		setTitle("GESTIÓN DISCOS Y CANCIONES DISCOTECA. EXAMEN 3er TRIMESTRE"); // Título de la ventana.
		setLocationRelativeTo(null); // Para centrar la ventana.
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		//SEPARACIÓN DE LA VENTANA DEL GUI EN UN 'SPLITPANE'
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setResizeWeight(0.75);
		contentPane.add(splitPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		splitPane.setRightComponent(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		// BOTÓN
		btnMostrarDetallesDel = new JButton("MOSTRAR DETALLES DEL DISCO");
		btnMostrarDetallesDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = table.getSelectedRow();
				if (fila!=-1){
					String codigo = table.getModel().getValueAt(fila, 0).toString();
					DialogoInfoDisco info=new DialogoInfoDisco(discoteca, codigo);
					info.setVisible(true);
				}	
				
			}
		});
		btnMostrarDetallesDel.setFocusPainted(false); // Quito esta cosa fea que estropea el diseño (más de lo que está)
		panel.add(btnMostrarDetallesDel, BorderLayout.CENTER);
		
		
		// TABLA
		scrollPane = new JScrollPane();		
		splitPane.setLeftComponent(scrollPane);
		
		table = new JTable(DefaultTableModelPersonal.cargarDiscos(discoteca)) {
			public boolean isCellEditable (int row, int column) {
			       return false;
			}
		};
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
				    e.consume();
				    int fila = table.getSelectedRow();
				    String codigo = table.getModel().getValueAt(fila, 0).toString();
					DialogoInfoDisco info=new DialogoInfoDisco(discoteca, codigo);
					info.setVisible(true);
				}
			}
		});

		table.setAutoCreateRowSorter(true); // Para ordenar las filas!!!!
		scrollPane.setViewportView(table);
		
		splitPane.setDividerLocation(300);
		
		
	}

}
