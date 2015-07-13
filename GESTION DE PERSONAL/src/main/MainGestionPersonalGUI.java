package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JList;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;

import javax.swing.JMenuItem;

import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import java.util.ArrayList;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

import Empleados.Empleado;
import Empleados.Tecnico;
import GestionPersonal.Empresa;
import InfoDialogo.InfoDialogo;
import MetodosEstaticos.BaseDatosEmpleadosMySQL;
import MetodosEstaticos.ComprobarDNI;
import MetodosEstaticos.Verificar;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainGestionPersonalGUI {

	private JFrame frame;
	private JSplitPane splitPane_vertical;
	private JPanel panel_izq;
	private JPanel panel_dcho;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JSplitPane splitPane_horizontal;
	private JPanel panel_ordenar;
	private JPanel panel_lista;
	private JButton btnA;
	private JButton btnB;
	private JButton btnC;
	private JButton btnD;
	private JButton btnN;
	private JButton btnAd;
	private JButton btnPr;
	private JButton btnAn;
	private JButton btnBe;
	private JButton btnTe;
	private JMenu mnBuscar;
	private JList<Empleado> list;
	private DefaultListModel<Empleado> listModel;
	private JMenuItem mntmAdministrativo;
	private JMenuItem mntmAnalista;
	private JMenuItem mntmProgramador;
	private JMenuItem mntmBecario;
	private JMenuItem mntmEmpleado;
	private JMenu mnVer;
	private JMenuItem mntmVersin;
	private JPanel panel_nombre;
	private JLabel lblNombre;
	private JTextField tfNombre;
	private JPanel panel_apellido1;
	private JLabel lblApellido1;
	private JTextField tfApellido1;
	private JPanel panel_apellido2;
	private JLabel lblApellido2;
	private JTextField tfApellido2;
	private JPanel panel_centro_trabajo;
	private JLabel lblCentroTrabajo;
	private JPanel panel_puesto_trabajo;
	private JLabel lblPuestoTrabajo;
	private JPanel panel_dni;
	private JLabel lblDni;
	private JTextField tfDni;
	private JRadioButton rb1;
	private JRadioButton rb2;
	private JRadioButton rb3;
	private JComboBox<String> comboBox;
	private JPanel panel_capacidades;
	private JLabel lblCapacidades;
	private JCheckBox cbPHP;
	private JCheckBox cbJavaScript;
	private JCheckBox cbJAVA;
	private JCheckBox cbC;
	private JCheckBox cbRuby;
	private JCheckBox cbRails;
	private JCheckBox cbSCSS;
	private JCheckBox cbMarcas;
	private JCheckBox cbGitHub;
	private JCheckBox cbPhotoshop;
	private JCheckBox cbProjectManager;
	private JButton btnGuardar;
	private JButton btnEditar;
	private JButton btnBorrar;
	private JMenuItem mntmEmpleadoPorNombre;
	private JMenuItem mntmEmpleadoBorrado;
	private JButton btnCancelar;
	private JButton btnCalcularNomina;
	private JMenuItem mntmEmpleadoBorradoPor;
	private boolean lista_empleados_borrados;
	private JButton btnRecuperar;
	private boolean empleado_nuevo=false;

	/**
	 * Main de la aplicación.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGestionPersonalGUI window = new MainGestionPersonalGUI(); 
					window.frame.setVisible(true); // Importante para hacer visible la aplicación!!!!
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor de la aplicación.
	 */
	public MainGestionPersonalGUI() {
		initialize(); // Inicializo la Interfaz gráfica.
	}

	/**
	 * Método para inicializar la interfaz gráfica con todos sus procesos.
	 */
	private void initialize() {
		
		final Empresa empresa= new Empresa();
		BaseDatosEmpleadosMySQL.cargar(empresa); // Cargo los datos de los empleados de la empresa.
		
		frame = new JFrame(); // Instancio el nuevo JFrame en la variable frame.
		frame.setResizable(false);
		frame.setTitle("GESTION DE PERSONAL"); // Título de la ventana.
		frame.setSize(800, 600); // Tamaño de la ventana en pixeles.
		frame.setLocationRelativeTo(null); // Para centrar la ventana.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Finalizar procesos en ejecución al cerrar aplicación.

		//Utilizo 'UIManager', para cambiar los estilos por defecto de los siguientes componentes cuando están deshabilitados, por razones de contraste.
		UIManager.put("RadioButton.disabledText",Color.DARK_GRAY);
		UIManager.put("ComboBox.disabledForeground", Color.DARK_GRAY);
		UIManager.put("CheckBox.disabledText", Color.DARK_GRAY);
		
		
		// MENÚ
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Nuevo");
		menuBar.add(mnArchivo);

		mntmAdministrativo = new JMenuItem("Administrativo");
		mntmAdministrativo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empleado_nuevo=true;
				mostrarPanelDcho();
				ocultarBotonesSuperiores();
				edicionPanelDcho(true);
				tfDni.setEditable(true);
				reiniciarCampos();
				comboBox.setSelectedItem("Administrativo");
				btnCancelar.setVisible(false);
				comboBox.setEnabled(false);
				edicionCheckBoxes(false); // Los Administrativos no pueden tener capacidades
			}
		});
		mnArchivo.add(mntmAdministrativo);
		
		mntmAnalista = new JMenuItem("Analista");
		mntmAnalista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empleado_nuevo=true;
				mostrarPanelDcho();
				ocultarBotonesSuperiores();
				edicionPanelDcho(true);
				tfDni.setEditable(true);
				reiniciarCampos();
				comboBox.setSelectedItem("Analista");
				btnCancelar.setVisible(false);
				comboBox.setEnabled(false);
			}
		});
		mnArchivo.add(mntmAnalista);
		
		mntmProgramador = new JMenuItem("Programador");
		mntmProgramador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empleado_nuevo=true;
				mostrarPanelDcho();
				ocultarBotonesSuperiores();
				edicionPanelDcho(true);
				tfDni.setEditable(true);
				reiniciarCampos();
				comboBox.setSelectedItem("Programador");
				btnCancelar.setVisible(false);
				comboBox.setEnabled(false);
			}
		});
		mnArchivo.add(mntmProgramador);
		
		mntmBecario = new JMenuItem("Becario");
		mntmBecario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empleado_nuevo=true;
				mostrarPanelDcho();
				ocultarBotonesSuperiores();
				edicionPanelDcho(true);
				tfDni.setEditable(true);
				reiniciarCampos();
				comboBox.setSelectedItem("Becario");
				btnCancelar.setVisible(false);
				comboBox.setEnabled(false);
			}
		});
		mnArchivo.add(mntmBecario);
		
		mnBuscar = new JMenu("Buscar empleado");
		menuBar.add(mnBuscar);
		
		mntmEmpleado = new JMenuItem("por DNI");
		mntmEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista_empleados_borrados=false;
				String dni = JOptionPane.showInputDialog(frame, "Introduce el DNI del empleado a buscar", "DNI empleado", JOptionPane.PLAIN_MESSAGE);
				if (dni!=null) { // Si no se ha salido del JOptionPane anterior
					listModel.clear();
					if (empresa.obtenerEmpleadoDNI(dni)!=null) // Si existe un empleado con ese DNI, se almacena en el JList
						listModel.addElement(empresa.obtenerEmpleadoDNI(dni));
					else // En caso contrario
						JOptionPane.showMessageDialog(frame, "El DNI es incorrecto o no se encuentra en la BBDD de empleados", "DNI no encontrado", JOptionPane.INFORMATION_MESSAGE);
				}
				if (listModel.getSize()>0)
					list.setSelectedValue(listModel.firstElement(), true);
			}
		});
		mnBuscar.add(mntmEmpleado);
		
		mntmEmpleadoPorNombre = new JMenuItem("por Nombre");
		mntmEmpleadoPorNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empleado_nuevo=false;
				lista_empleados_borrados=false;
				String fragmento_busqueda = JOptionPane.showInputDialog(frame, "Introduce el fragmento de búsqueda a comprar", "Buscar empleado", JOptionPane.PLAIN_MESSAGE);
				if (fragmento_busqueda!=null) {
					listModel.clear();
					ArrayList<Empleado> lista_ordenada = empresa.obtenerEmpleados(fragmento_busqueda);							
					for (Empleado elemento_lista : lista_ordenada) {
						listModel.addElement(elemento_lista);
					}					
				}
				if (listModel.getSize()>0)
					list.setSelectedValue(listModel.firstElement(), true);
			}
		});
		mnBuscar.add(mntmEmpleadoPorNombre);
		
		mntmEmpleadoBorrado = new JMenuItem("Borrados");
		mntmEmpleadoBorrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empleado_nuevo=false;
				lista_empleados_borrados=true;
				listModel.clear();
				ArrayList<Empleado> lista_ordenada = empresa.arrayEmpleadosBorradosNombre();							
				for (Empleado elemento_lista : lista_ordenada) {
					listModel.addElement(elemento_lista);
				}
				if (listModel.getSize()>0)
					list.setSelectedValue(listModel.firstElement(), true);
			}
		});
		mnBuscar.add(mntmEmpleadoBorrado);
		
		mntmEmpleadoBorradoPor = new JMenuItem("Borrado por DNI");
		mntmEmpleadoBorradoPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empleado_nuevo=false;
				lista_empleados_borrados=true;
				String dni = JOptionPane.showInputDialog(frame, "Introduce el DNI del empleado borrado a buscar", "DNI empleado borrado", JOptionPane.PLAIN_MESSAGE);
				if (dni!=null) { // Si no se ha salido del JOptionPane anterior
					listModel.clear();
					if (empresa.obtenerEmpleadoBorradoDNI(dni)!=null) // Si existe un empleado con ese DNI, se almacena en el JList
						listModel.addElement(empresa.obtenerEmpleadoBorradoDNI(dni));
					else // En caso contrario
						JOptionPane.showMessageDialog(frame, "El DNI es incorrecto o no se encuentra en la BBDD de empleados borrados", "DNI no encontrado", JOptionPane.INFORMATION_MESSAGE);
				}
				if (listModel.getSize()>0)
					list.setSelectedValue(listModel.firstElement(), true);
			}
		});
		mnBuscar.add(mntmEmpleadoBorradoPor);
		
		mnVer = new JMenu("Version");
		menuBar.add(mnVer);
		
		mntmVersin = new JMenuItem("Info");
		mntmVersin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoDialogo info=new InfoDialogo();
				info.setVisible(true);
			}
		});
		mnVer.add(mntmVersin);
				
		
		// PANELES
		// Divido el Contenedor principal en 2 paneles: 'panel_izq' y 'panel_dcho'
		splitPane_vertical = new JSplitPane();
		frame.getContentPane().add(splitPane_vertical);		
			
			//PANEL IZQUIERDO (LISTA DE EMPLEADOS Y BOTONES PARA ORDENARLOS)
			panel_izq = new JPanel();
			panel_izq.setPreferredSize(new Dimension(150, 10));
			splitPane_vertical.setLeftComponent(panel_izq);
			panel_izq.setLayout(new BoxLayout(panel_izq, BoxLayout.X_AXIS));
			
			splitPane_horizontal = new JSplitPane();
			splitPane_horizontal.setMinimumSize(new Dimension(300, 25));
			splitPane_horizontal.setBorder(null);
			splitPane_horizontal.setEnabled(false);
			splitPane_horizontal.setOrientation(JSplitPane.VERTICAL_SPLIT);
			panel_izq.add(splitPane_horizontal);
				
				// PANEL DE ORDENAR LISTA
				panel_ordenar = new JPanel();
				panel_ordenar.setPreferredSize(new Dimension(0, 25));
				splitPane_horizontal.setLeftComponent(panel_ordenar);
				panel_ordenar.setLayout(new GridLayout(2, 5, 0, 0));
					
					//BOTÓN EMPLEADOS ALFABÉTICAMENTE+
					btnA = new JButton("A");
					btnA.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							empleado_nuevo=false;
							lista_empleados_borrados=false;
							listModel.clear();
							ArrayList<Empleado> lista_ordenada = empresa.arrayEmpleadosNombre();							
							for (Empleado elemento_lista : lista_ordenada) {
								listModel.addElement(elemento_lista);
							}
							if (listModel.getSize()>0)
								list.setSelectedValue(listModel.firstElement(), true);
						}
					});
					btnA.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnA.setFocusable(false);
					btnA.setToolTipText("Mostrar empleados de la A a la Z");
					panel_ordenar.add(btnA);
					
					//BOTÓN EMPLEADOS ALFABÉTICAMENTE-
					btnB = new JButton("Z");
					btnB.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							empleado_nuevo=false;
							lista_empleados_borrados=false;
							listModel.clear();
							ArrayList<Empleado> lista_ordenada = empresa.arrayEmpleadosNombre();						
							for (int i=lista_ordenada.size()-1; i>=0; i--)  {
								listModel.addElement(lista_ordenada.get(i));
							}
							if (listModel.getSize()>0)
								list.setSelectedValue(listModel.firstElement(), true);
						}
					});
					btnB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnB.setFocusable(false);
					btnB.setToolTipText("Mostrar empleados de la Z a la A");
					panel_ordenar.add(btnB);
					
					//BOTÓN EMPLEADOS POR DNI
					btnC = new JButton("DNI");
					btnC.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							empleado_nuevo=false;
							lista_empleados_borrados=false;
							listModel.clear();
							ArrayList<Empleado> lista_ordenada = empresa.arrayEmpleadosDNI();							
							for (Empleado elemento_lista : lista_ordenada) {
								listModel.addElement(elemento_lista);
							}
							if (listModel.getSize()>0)
								list.setSelectedValue(listModel.firstElement(), true);
						}
					});
					btnC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnC.setFocusable(false);
					btnC.setToolTipText("Mostrar empleados ordenados por DNI");
					panel_ordenar.add(btnC);
					
					//BOTÓN EMPLEADOS POR N+
					btnD = new JButton("N+");
					btnD.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							empleado_nuevo=false;
							lista_empleados_borrados=false;
							listModel.clear();
							// Como no consigo entender el rederer del JList para hacer un toString personalizado en este caso, sólo ordeno Nóminas, sin decir su valor
							ArrayList<Empleado> lista_ordenada = empresa.arrayEmpleadosNomina(1, 2000);	
							for (Empleado elemento_lista : lista_ordenada) {
								listModel.addElement(elemento_lista);
							}
							if (listModel.getSize()>0)
								list.setSelectedValue(listModel.firstElement(), true);
						}
					});
					btnD.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnD.setFocusable(false);
					btnD.setToolTipText("Mostrar empleados por N\u00F3mina m\u00E1s alta");
					panel_ordenar.add(btnD);
					
					//BOTÓN EMPLEADOS POR N-
					btnN = new JButton("N-");
					btnN.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							empleado_nuevo=false;
							lista_empleados_borrados=false;
							listModel.clear();
							// Como no consigo entender el rederer del JList para hacer un toString personalizado en este caso, sólo ordeno Nóminas, 
							// sin decir su valor. No obstante, tengo el método que calcula la nómina del empleado seleccionado en el Panel Derecho.
							ArrayList<Empleado> lista_ordenada = empresa.arrayEmpleadosNomina(1, 2000);							
							for (int i=lista_ordenada.size()-1; i>=0; i--)  {
								listModel.addElement(lista_ordenada.get(i));
							}
							if (listModel.getSize()>0)
								list.setSelectedValue(listModel.firstElement(), true);
						}
					});
					btnN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnN.setFocusable(false);
					btnN.setToolTipText("Mostrar empleados por N\u00F3mina m\u00E1s baja");
					panel_ordenar.add(btnN);
					
					//BOTÓN EMPLEADOS ADMINISTRATIVOS
					btnAd = new JButton("Ad");
					btnAd.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							empleado_nuevo=false;
							lista_empleados_borrados=false;
							listModel.clear();
							ArrayList<Empleado> lista_ordenada = empresa.arrayEmpleadosNombre();							
							for (Empleado elemento_lista : lista_ordenada) {
								if (elemento_lista.getClass().getSimpleName().equals("Administrativo"))
									listModel.addElement(elemento_lista);
							}
							if (listModel.getSize()>0)
								list.setSelectedValue(listModel.firstElement(), true);
						}
					});
					btnAd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnAd.setFocusable(false);
					btnAd.setToolTipText("Mostrar Empleados Administrativos"); // Ordenados alfabéticamente
					panel_ordenar.add(btnAd);
					
					//BOTÓN EMPLEADOS PROGRAMADORES
					btnPr = new JButton("Pr");
					btnPr.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							empleado_nuevo=false;
							lista_empleados_borrados=false;
							listModel.clear();
							ArrayList<Empleado> lista_ordenada = empresa.arrayEmpleadosNombre();							
							for (Empleado elemento_lista : lista_ordenada) {
								if (elemento_lista.getClass().getSimpleName().equals("Programador"))
									listModel.addElement(elemento_lista);
							}
							if (listModel.getSize()>0)
								list.setSelectedValue(listModel.firstElement(), true);
						}
					});
					btnPr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnPr.setFocusable(false);
					btnPr.setToolTipText("Mostrar Empleados Programadores");
					panel_ordenar.add(btnPr);
					
					//BOTÓN EMPLEADOS ANALISTAS
					btnAn = new JButton("An");
					btnAn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							empleado_nuevo=false;
							lista_empleados_borrados=false;
							listModel.clear();
							ArrayList<Empleado> lista_ordenada = empresa.arrayEmpleadosNombre();							
							for (Empleado elemento_lista : lista_ordenada) {
								if (elemento_lista.getClass().getSimpleName().equals("Analista"))
									listModel.addElement(elemento_lista);
							}
							if (listModel.getSize()>0)
								list.setSelectedValue(listModel.firstElement(), true);
						}
					});
					btnAn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnAn.setFocusable(false);
					btnAn.setToolTipText("Mostrar Empleados Analistas");
					panel_ordenar.add(btnAn);
					
					//BOTÓN EMPLEADOS BECARIOS
					btnBe = new JButton("Bc");
					btnBe.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							empleado_nuevo=false;
							lista_empleados_borrados=false;
							listModel.clear();
							ArrayList<Empleado> lista_ordenada = empresa.arrayEmpleadosNombre();							
							for (Empleado elemento_lista : lista_ordenada) {
								if (elemento_lista.getClass().getSimpleName().equals("Becario"))
									listModel.addElement(elemento_lista);
							}
							if (listModel.getSize()>0)
								list.setSelectedValue(listModel.firstElement(), true);
						}
					});
					btnBe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnBe.setFocusable(false);
					btnBe.setToolTipText("Mostrar Empleados Becarios");
					panel_ordenar.add(btnBe);
					
					//BOTÓN EMPLEADOS TÉCNICOS
					btnTe = new JButton("Tc");
					btnTe.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							empleado_nuevo=false;
							lista_empleados_borrados=false;
							listModel.clear();
							ArrayList<Empleado> lista_ordenada = empresa.arrayEmpleadosNombre();							
							for (Empleado elemento_lista : lista_ordenada) {
								if (elemento_lista.getClass().getSuperclass().getSimpleName().equals("Tecnico"))
									listModel.addElement(elemento_lista);
							}
							if (listModel.getSize()>0)
								list.setSelectedValue(listModel.firstElement(), true);
						}
					});
					btnTe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnTe.setFocusable(false);
					btnTe.setToolTipText("Mostrar Empleados T\u00E9cnicos");
					panel_ordenar.add(btnTe);
				
				// PANEL DE LISTA
				panel_lista = new JPanel();
				panel_lista.setBackground(Color.GRAY);
				panel_lista.setPreferredSize(new Dimension(0, 0));
				splitPane_horizontal.setRightComponent(panel_lista);
				panel_lista.setLayout(new BorderLayout(0, 0));
				
				listModel = new DefaultListModel<Empleado>();
				list = new JList<Empleado>(listModel);
				list.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {						
						autorrellenarCampos();					
					}
				});
				list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
				list.setLayoutOrientation(JList.VERTICAL);
				list.setVisibleRowCount(-1);
				
				panel_lista.add(new JScrollPane(list)); // Si como parámetro se pone sólo 'list', se crea la lista sin el scroll.
			
			//PANEL DERECHO (EDITAR EMPLEADOS / CREAR NUEVOS EMPLEADOS)
			panel_dcho = new JPanel();
			panel_dcho.setBackground(new Color(230, 230, 250));
			splitPane_vertical.setRightComponent(panel_dcho);
				
				// DNI
				panel_dni = new JPanel();
				panel_dni.setVisible(false);
				panel_dni.setBounds(44, 87, 179, 54);
				panel_dni.setBackground(new Color(230, 230, 250));
				panel_dni.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				
				lblDni = new JLabel("DNI");
				panel_dni.add(lblDni);
				
				tfDni = new JTextField();
				tfDni.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						String fragmento_texto = tfDni.getText();
						if (fragmento_texto.length()>=9) { // No más de 9 caracteres.
							Toolkit.getDefaultToolkit().beep();
							tfDni.setText(fragmento_texto.substring(0, fragmento_texto.length()-1));
						}
					}
				});
				tfDni.setFont(new Font("Monospaced", Font.PLAIN, 13)); // Todos los textfields los he puesto con una fuente 'Monospaced', para que todas las letras ocupen el mismo espacio
				tfDni.setEditable(false);
				tfDni.setColumns(20);
				panel_dni.add(tfDni);
			
				// NOMBRE
				panel_nombre = new JPanel();
				panel_nombre.setVisible(false);
				panel_nombre.setBounds(233, 87, 186, 54);
				panel_nombre.setBackground(new Color(230, 230, 250));
				panel_nombre.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				
				lblNombre = new JLabel("Nombre");
				panel_nombre.add(lblNombre);
				
				tfNombre = new JTextField();
				tfNombre.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						String fragmento_texto = tfNombre.getText();
						if (fragmento_texto.length()>=20) { // No más de 20 caracteres.
							Toolkit.getDefaultToolkit().beep();
							tfNombre.setText(fragmento_texto.substring(0, fragmento_texto.length()-1));
						}
					}
				});
				tfNombre.setFont(new Font("Monospaced", Font.PLAIN, 13));
				tfNombre.setEditable(false);
				panel_nombre.add(tfNombre);
				tfNombre.setColumns(20);
				
				// APELLIDO 1
				panel_apellido1 = new JPanel();
				panel_apellido1.setVisible(false);
				panel_apellido1.setBounds(44, 152, 179, 55);
				panel_apellido1.setBackground(new Color(230, 230, 250));
				panel_apellido1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				
				lblApellido1 = new JLabel("Apellido 1");
				panel_apellido1.add(lblApellido1);
				
				tfApellido1 = new JTextField();
				tfApellido1.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						String fragmento_texto = tfApellido1.getText();
						if (fragmento_texto.length()>=20) { // No más de 20 caracteres.
							Toolkit.getDefaultToolkit().beep();
							tfApellido1.setText(fragmento_texto.substring(0, fragmento_texto.length()-1));
						}
					}
				});
				tfApellido1.setFont(new Font("Monospaced", Font.PLAIN, 13));
				tfApellido1.setEditable(false);
				tfApellido1.setColumns(20);
				panel_apellido1.add(tfApellido1);
				
				// APELLIDO 2
				panel_apellido2 = new JPanel();
				panel_apellido2.setVisible(false);
				panel_apellido2.setBounds(233, 152, 186, 55);
				panel_apellido2.setBackground(new Color(230, 230, 250));
				panel_apellido2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				
				lblApellido2 = new JLabel("Apellido 2");
				panel_apellido2.add(lblApellido2);
				
				tfApellido2 = new JTextField();
				tfApellido2.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						String fragmento_texto = tfApellido2.getText();
						if (fragmento_texto.length()>=20) { // No más de 20 caracteres.
							Toolkit.getDefaultToolkit().beep();
							tfApellido2.setText(fragmento_texto.substring(0, fragmento_texto.length()-1));
						}
					}
				});
				tfApellido2.setFont(new Font("Monospaced", Font.PLAIN, 13));
				tfApellido2.setEditable(false);
				tfApellido2.setColumns(20);
				panel_apellido2.add(tfApellido2);
				
				// CENTRO DE TRABAJO
				panel_centro_trabajo = new JPanel();
				panel_centro_trabajo.setVisible(false);
				panel_centro_trabajo.setBounds(44, 259, 276, 30);
				panel_centro_trabajo.setBackground(new Color(230, 230, 250));
				panel_centro_trabajo.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				
				lblCentroTrabajo = new JLabel("Centro de Trabajo");
				panel_centro_trabajo.add(lblCentroTrabajo);
				
				rb1 = new JRadioButton("1");
				rb1.setEnabled(false);
				rb1.setFocusPainted(false);
				rb1.setBackground(new Color(230, 230, 250));
				panel_centro_trabajo.add(rb1);
				
				rb2 = new JRadioButton("2");
				rb2.setEnabled(false);
				rb2.setFocusPainted(false);
				rb2.setBackground(new Color(230, 230, 250));
				panel_centro_trabajo.add(rb2);
				
				rb3 = new JRadioButton("3");
				rb3.setEnabled(false);
				rb3.setFocusPainted(false);
				rb3.setBackground(new Color(230, 230, 250));
				panel_centro_trabajo.add(rb3);
				
				//Agrupación de radio buttons
				ButtonGroup centros = new ButtonGroup();
					centros.add(rb1);
					centros.add(rb2);
					centros.add(rb3);
				
				// PUESTO DE TRABAJO
				panel_puesto_trabajo = new JPanel();
				panel_puesto_trabajo.setVisible(false);
				panel_puesto_trabajo.setBounds(44, 218, 276, 30);
				panel_puesto_trabajo.setBackground(new Color(230, 230, 250));
				panel_puesto_trabajo.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				
				lblPuestoTrabajo = new JLabel("Puesto de Trabajo");
				panel_puesto_trabajo.add(lblPuestoTrabajo);				
				
				panel_dcho.setLayout(null);
				panel_dcho.add(panel_puesto_trabajo);
				
				comboBox = new JComboBox<String>();
				comboBox.setEnabled(false);
				comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Administrativo", "Analista", "Programador", "Becario"}));
				comboBox.setLocale(new Locale("es", "ES"));
				panel_puesto_trabajo.add(comboBox);
				panel_dcho.add(panel_dni);
				panel_dcho.add(panel_centro_trabajo);
				panel_dcho.add(panel_apellido2);
				panel_dcho.add(panel_apellido1);
				panel_dcho.add(panel_nombre);
				
				// CAPACIDADES
				panel_capacidades = new JPanel();
				panel_capacidades.setVisible(false);
				panel_capacidades.setBackground(new Color(230, 230, 250));
				panel_capacidades.setBounds(44, 300, 375, 141);
				panel_dcho.add(panel_capacidades);
				panel_capacidades.setLayout(null);
				
				lblCapacidades = new JLabel("Capacidades");
				lblCapacidades.setBounds(5, 9, 96, 14);
				panel_capacidades.add(lblCapacidades);
				
					//CHECKBOXES DE CAPACIDADES
					cbPHP = new JCheckBox("PHP");
					cbPHP.setEnabled(false);
					cbPHP.setBounds(122, 80, 96, 22);
					cbPHP.setFocusPainted(false);
					panel_capacidades.add(cbPHP);
					
					cbJavaScript = new JCheckBox("JavaScript");
					cbJavaScript.setEnabled(false);
					cbJavaScript.setBounds(5, 80, 115, 22);
					cbJavaScript.setFocusPainted(false);
					panel_capacidades.add(cbJavaScript);
					
					cbJAVA = new JCheckBox("JAVA");
					cbJAVA.setEnabled(false);
					cbJAVA.setBounds(5, 105, 115, 22);
					cbJAVA.setName("");
					cbJAVA.setFocusPainted(false);
					panel_capacidades.add(cbJAVA);
					
					cbC = new JCheckBox("C++");
					cbC.setEnabled(false);
					cbC.setBounds(122, 105, 96, 22);
					cbC.setName("");
					cbC.setFocusPainted(false);
					panel_capacidades.add(cbC);
					
					cbRuby = new JCheckBox("Ruby");
					cbRuby.setEnabled(false);
					cbRuby.setBounds(122, 55, 96, 22);
					cbRuby.setName("");
					cbRuby.setFocusPainted(false);
					panel_capacidades.add(cbRuby);
					
					cbRails = new JCheckBox("Rails");
					cbRails.setEnabled(false);
					cbRails.setBounds(122, 30, 96, 22);
					cbRails.setName("");
					cbRails.setFocusPainted(false);
					panel_capacidades.add(cbRails);
					
					cbSCSS = new JCheckBox("SCSS");
					cbSCSS.setEnabled(false);
					cbSCSS.setBounds(5, 55, 115, 22);
					cbSCSS.setName("");
					cbSCSS.setFocusPainted(false);
					panel_capacidades.add(cbSCSS);
					
					cbMarcas = new JCheckBox("HTML&CSS");
					cbMarcas.setEnabled(false);
					cbMarcas.setBounds(5, 30, 115, 22);
					cbMarcas.setName("");
					cbMarcas.setFocusPainted(false);
					panel_capacidades.add(cbMarcas);
					
					cbGitHub = new JCheckBox("Github");
					cbGitHub.setEnabled(false);
					cbGitHub.setBounds(220, 55, 136, 22);
					cbGitHub.setName("");
					cbGitHub.setFocusPainted(false);
					panel_capacidades.add(cbGitHub);
					
					cbPhotoshop = new JCheckBox("Photoshop");
					cbPhotoshop.setEnabled(false);
					cbPhotoshop.setBounds(220, 80, 136, 22);
					cbPhotoshop.setName("");
					cbPhotoshop.setFocusPainted(false);
					panel_capacidades.add(cbPhotoshop);
					
					cbProjectManager = new JCheckBox("Project Manager");
					cbProjectManager.setEnabled(false);
					cbProjectManager.setBounds(220, 30, 136, 22);
					cbProjectManager.setName("");
					cbProjectManager.setFocusPainted(false);
					panel_capacidades.add(cbProjectManager);
				
				// BOTÓN CALCULAR NÓMINA
				btnCalcularNomina = new JButton("Calcular Nomina");
				btnCalcularNomina.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Empleado empleado = list.getSelectedValue();
						int[] mes_año = pedirFechaJOptionPane();
						if (mes_año[0]!=0) { // Para controlar el pulsar el botón cancelar (ver método 'pedirFechaJOptionPane').
							Double nomina = empleado.calculaNomina(mes_año[0], mes_año[1]);
							String mensaje = "A " + empleado.getNombre() + " " + empleado.getApe1() + " " + empleado.getApe2() + ", le corresponde una nómina de " + nomina + "€ en el mes y año indicados.";
							JOptionPane.showMessageDialog(frame, mensaje, "Nomina", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
				btnCalcularNomina.setVisible(false);
				btnCalcularNomina.setFocusPainted(false);
				btnCalcularNomina.setBounds(24, 30, 139, 23);
				panel_dcho.add(btnCalcularNomina);
				
				// BOTÓN EDITAR
				btnEditar = new JButton("Editar");
				btnEditar.setVisible(false);
				btnEditar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						edicionPanelDcho(true);
						mostrarPanelDcho();
						// Oculto los siguientes botones que no tienen sentido en esta función de Edición.
						btnCalcularNomina.setVisible(false);
						btnEditar.setVisible(false);
						btnBorrar.setVisible(false);
						btnRecuperar.setVisible(false);
						if (list.getSelectedValue()!=null) {
							if (list.getSelectedValue().getClass().getSimpleName().equals("Administrativo")) { // No se podrán editar las capacidades de un Administrativo
								edicionCheckBoxes(false);
							}
						}
					}
				});
				btnEditar.setFocusPainted(false);
				btnEditar.setBounds(231, 30, 89, 23);
				panel_dcho.add(btnEditar);
				
				// BOTÓN BORRAR
				btnBorrar = new JButton("Borrar");
				btnBorrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int borrar = JOptionPane.showConfirmDialog(frame, "¿Estás seguro de que deseas borrar el empleado?", "Borrar empleado", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null);
						if (borrar==0) { // Entero correspondiente a 'Si', con el resto de opciones, no se ejecuta ningún método.
							String dni = tfDni.getText();
							BaseDatosEmpleadosMySQL.modificar("UPDATE empleados "
																+ "SET borrado=true "
																+ "WHERE dni='" + dni + "'");
							BaseDatosEmpleadosMySQL.cargar(empresa);
							listModel.clear();
							autorrellenarCampos();
							ocultarBotonesSuperiores();
						}
					}
				});
				btnBorrar.setVisible(false);
				btnBorrar.setFocusPainted(false);
				btnBorrar.setBounds(330, 30, 89, 23);
				panel_dcho.add(btnBorrar);
				
				// BOTÓN RECUPERAR (Ojo!!!!! Este botón lo he puesto el la misma posición de 'BOTÓN BORRAR'. Depende de esi el empleado está borrado o no).
				btnRecuperar = new JButton("Recuperar");
				btnRecuperar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int recuperar = JOptionPane.showConfirmDialog(frame, "¿Estás seguro de que deseas resuperar el empleado borrado?", "Recuperar empleado", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
						if (recuperar==0) { // Entero correspondiente a 'Si', con el resto de opciones, no se ejecuta ningún método.
							String dni = tfDni.getText();
							BaseDatosEmpleadosMySQL.modificar("UPDATE empleados "
																+ "SET borrado=false "
																+ "WHERE dni='" + dni + "'");
							BaseDatosEmpleadosMySQL.cargar(empresa);
							listModel.clear();
							autorrellenarCampos();
							ocultarBotonesSuperiores();
						}
					}
				});
				btnRecuperar.setVisible(false);
				btnRecuperar.setBounds(330, 30, 99, 23);
				panel_dcho.add(btnRecuperar);
				
				// BOTÓN CANCELAR
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setVisible(false);
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						autorrellenarCampos();
					}
				});
				btnCancelar.setFocusPainted(false);
				btnCancelar.setBounds(231, 467, 89, 23);
				panel_dcho.add(btnCancelar);

				// BOTÓN GUARDAR
				btnGuardar = new JButton("Guardar");
				btnGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (tfDni.getText().equals("") || // Si Alguno de los siguientes campos está vacío muestro mensaje de error en JOptionPane.
								tfNombre.getText().equals("") || 
								tfApellido1.getText().equals("")) { //Permito que el campo Apellido2 esté vacío. Soy así de respetuoso con los 'guiris'.
								JOptionPane.showMessageDialog(frame, "Los campos 'DNI', 'Nombre' y/o 'Apellido 1' NO pueden estar vacíos.", "Error!", JOptionPane.ERROR_MESSAGE);
						}
						else if (comprobarDNI(empresa)) { //Compruebo que el dni introducido es correcto (En caso de que pulse guardar desde el campo de texto de DNI)
							int salvar = JOptionPane.showConfirmDialog(frame, "¿Estás seguro de guardar los cambios?", "Guardar cambios", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
							if (salvar==0) { // Entero correspondiente a 'Si', con el resto de opciones, no se ejecuta ningún método.
								guardarCambios();
								BaseDatosEmpleadosMySQL.cargar(empresa);
								listModel.clear();
								autorrellenarCampos();
							}
						}	
					}
				});
				btnGuardar.setVisible(false);
				btnGuardar.setFocusPainted(false);
				btnGuardar.setBounds(330, 467, 89, 23);
				panel_dcho.add(btnGuardar);

	}
	
	/**
	 * Comprueba que el DNI introducido en el campo de texto DNI es correcto. En caso contrario muestra un mensaje de error
	 * en un JOptionPane, borra el contenido de dicho campo y devuelve un booleano false.
	 * 
	 * @param empresa Para realizar la última comprobación. Saber si el DNI está registrado en la empresa.
	 * @return true: dni correcto. false: dni incorrecto
	 */
	private boolean comprobarDNI(Empresa empresa) {
		String dni=tfDni.getText();
		if (ComprobarDNI.tipoError(dni)==1) {
			JOptionPane.showMessageDialog(frame, "El DNI debe estar formado al menos por 2 caracteres. Introduce de nuevo un valor.", "Error!", JOptionPane.ERROR_MESSAGE);
			tfDni.setText(""); // Sí, me parece poco bestia lo de borrar todo el contenido si hay error... Pero no hay tiempo para hacer algo mejor
			return false;
		}
		else if (ComprobarDNI.tipoError(dni)==2) {
			JOptionPane.showMessageDialog(frame, "Uno o más números del DNI NO son números, sino algún otro carácter. Introduce de nuevo un valor.", "Error!", JOptionPane.ERROR_MESSAGE);
			tfDni.setText("");
			return false;
		}
		else if (ComprobarDNI.tipoError(dni)==3) {
			JOptionPane.showMessageDialog(frame, "No se ha introducido una letra al final del DNI. Introduce de nuevo un valor.", "Error!", JOptionPane.ERROR_MESSAGE);
			tfDni.setText("");
			return false;
		}							
		else if (ComprobarDNI.tipoError(dni)==4) {
			JOptionPane.showMessageDialog(frame, "La letra control del número del DNI no es correcta. Introduce de nuevo un valor.", "Error!", JOptionPane.ERROR_MESSAGE);
			tfDni.setText("");
			return false;
		}							
		else if (empresa.existeEmpleadoDNI(dni) || empresa.existeEmpleadoBorradoDNI(dni)) {
			if (empleado_nuevo) {
				JOptionPane.showMessageDialog(frame, "El DNI introducido ya existe en la Base de Datos y este debe ser único por empleado. Introduce de nuevo un valor o busca entre los empleados borrados para recuperarlo si es el caso.", "Error!", JOptionPane.ERROR_MESSAGE);
				tfDni.setText("");
				return false;
			}
			return true;
		}
		else
			return true;
	}
	
	/**
	 * @return JOptionPane que pide mes y año y controla que estén bien introducidos. Devuelve un vector de dos posiciones
	 * 	       int[0]=mes e int[1]=año. Si ambos valores son = a 0, es que se ha cancelado o salido del JOptionPane.
	 */
	private int[] pedirFechaJOptionPane() {
		boolean fecha_correcta=false;
		int[] mesYaño = {0,0};
		while (fecha_correcta==false) {
			String seleccion = JOptionPane.showInputDialog(frame, "Introduce el mes y año en el formato mm/aaaa", "Mes y año de la Nómina", JOptionPane.PLAIN_MESSAGE);
			if (seleccion==null)
				break; // Si se presiona cancelar o salir de la ventana, salgo del bucle sin hacer ninguna operación.
			if (Verificar.esVacio(seleccion)) {
				JOptionPane.showMessageDialog(frame, "¡El campo no puede estar vacío!", "Error!", JOptionPane.ERROR_MESSAGE);
			}
			else {									
				if (seleccion.indexOf('/')==-1) {
					JOptionPane.showMessageDialog(frame, "No has introducido la '/'", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				else if (Verificar.nChars(seleccion, '/')>1) {
					ImageIcon javi1 = new ImageIcon("images/javi.png");
					JOptionPane.showMessageDialog(frame, "¡No me vas a pillar! ¡Sigue buscando errores! ¡Y no introduzcas más de una '/' de nuevo!", "Error!", JOptionPane.ERROR_MESSAGE, javi1);
				}
				else {
					String[] mes_año = seleccion.split("/");
					if (seleccion.indexOf('/')==0 || seleccion.indexOf('/')==seleccion.length()-1) {
						JOptionPane.showMessageDialog(frame, "¡Pon valores numéricos antes y después de la '/'!", "Error!", JOptionPane.ERROR_MESSAGE);
					}
					else if (Verificar.esNumero(mes_año[0])==false || Verificar.esNumero(mes_año[1])==false) {
						JOptionPane.showMessageDialog(frame, "¡Asegúrate de Introducir números!", "Error!", JOptionPane.ERROR_MESSAGE);
					}
					else if (Verificar.esIntervalo(Integer.parseInt(mes_año[0]), 1, 12)==false // Compruebo que el mes es entre 1-12
					         || Verificar.esIntervalo(Integer.parseInt(mes_año[1]), 2000, 3000)==false){ // Compruebo que el año es entre 2000 y 3000
						JOptionPane.showMessageDialog(frame, "Introduce un mes entre 1-12 y año entre 2000-3000", "Error!", JOptionPane.ERROR_MESSAGE);
					}
					else {
						fecha_correcta=true;
						mesYaño[0] = Integer.parseInt(mes_año[0]);
						mesYaño[1] = Integer.parseInt(mes_año[1]);								
					}
				}
			}								
		}//fin while
		return mesYaño;
	}
	
	/**
	 * Oculta TODOS los componentes del panel derecho
	 */
	@SuppressWarnings("unused") // Ya se usará...
	private void ocultarPanelDcho() {
		btnCancelar.setVisible(false);
		btnGuardar.setVisible(false);
		panel_puesto_trabajo.setVisible(false);
		panel_dni.setVisible(false);
		panel_nombre.setVisible(false);
		panel_apellido1.setVisible(false);
		panel_apellido2.setVisible(false);
		panel_centro_trabajo.setVisible(false);
		panel_capacidades.setVisible(false);
		btnCalcularNomina.setVisible(false);
		btnEditar.setVisible(false);
		btnBorrar.setVisible(false);
		btnRecuperar.setVisible(false);
	}
	/**
	 * Oculta los botones superiores del Panel Derecho
	 */
	private void ocultarBotonesSuperiores() {
		btnCalcularNomina.setVisible(false);
		btnEditar.setVisible(false);
		btnBorrar.setVisible(false);
		btnRecuperar.setVisible(false);
	}
	
	/**
	 * Muestra todos los componentes esenciales del panel derecho. No son esenciales 'btnCalcularNomina', 'btnEditar' y 'btnBorrar'.
	 */
	private void mostrarPanelDcho() {
		btnCancelar.setVisible(true);
		btnGuardar.setVisible(true);
		panel_puesto_trabajo.setVisible(true);
		panel_dni.setVisible(true);
		panel_nombre.setVisible(true);
		panel_apellido1.setVisible(true);
		panel_apellido2.setVisible(true);
		panel_centro_trabajo.setVisible(true);
		panel_capacidades.setVisible(true);
	}
	/**
	 * Deshabilita o habilita todos los componentes esenciales del panel derecho. No son esenciales 'btnCalcularNomina', 'btnEditar' y 'btnBorrar'.
	 * El DNI tendrá siempre su 'setEditable' en falso al utilizar este método.
	 * @param bool 'true' o 'false'
	 */
	private void edicionPanelDcho(boolean bool) {
		btnCancelar.setEnabled(bool);
		btnGuardar.setEnabled(bool);
		cbProjectManager.setEnabled(bool);
		cbPhotoshop.setEnabled(bool);
		cbGitHub.setEnabled(bool);
		cbMarcas.setEnabled(bool);
		cbSCSS.setEnabled(bool);
		cbRails.setEnabled(bool);
		cbRuby.setEnabled(bool);
		cbC.setEnabled(bool);
		cbJAVA.setEnabled(bool);
		cbJavaScript.setEnabled(bool);
		cbPHP.setEnabled(bool);
		comboBox.setEnabled(bool);
		rb3.setEnabled(bool);
		rb2.setEnabled(bool);
		rb1.setEnabled(bool);
		tfApellido2.setEditable(bool);
		tfApellido1.setEditable(bool);
		tfNombre.setEditable(bool);
		// tfDni.setEditable(bool); El DNI podrá editarse sólo en el caso de crear un empleado nuevo.
		tfDni.setEditable(false);
	}
	
	/**
	 * Método para deshabilitar o habilitar todos los componentes checkboxes del Panel Derecho
	 * @param bool 'true' o 'false'
	 */
	private void edicionCheckBoxes(boolean bool) {
		cbProjectManager.setEnabled(bool);
		cbPhotoshop.setEnabled(bool);
		cbGitHub.setEnabled(bool);
		cbMarcas.setEnabled(bool);
		cbSCSS.setEnabled(bool);
		cbRails.setEnabled(bool);
		cbRuby.setEnabled(bool);
		cbC.setEnabled(bool);
		cbJAVA.setEnabled(bool);
		cbJavaScript.setEnabled(bool);
		cbPHP.setEnabled(bool);
	}

	/**
	 * Selecciona o deselecciona todos los componentes checkbox.
	 * @param bool 'true' o 'false'
	 */
	private void setCheckBoxes(boolean bool){
		cbPHP.setSelected(bool);
		cbJavaScript.setSelected(bool);
		cbJAVA.setSelected(bool);
		cbC.setSelected(bool);
		cbRuby.setSelected(bool);
		cbRails.setSelected(bool);
		cbSCSS.setSelected(bool);
		cbMarcas.setSelected(bool);
		cbGitHub.setSelected(bool);
		cbPhotoshop.setSelected(bool);
		cbProjectManager.setSelected(bool);
	}
	
	/**
	 * A partir de los datos del empleado del JList seleccionado, se mostrarán y rellenarán los datos del Panel Derecho
	 */
	private void autorrellenarCampos() {
		Empleado empleado = list.getSelectedValue(); // guardo en esta variable temporal el empleado seleccionado
		mostrarPanelDcho(); 
		// Estos tres botones no forman parte de los componentes 'esenciales' del método, pero se muestran en esta situación:
			btnCalcularNomina.setVisible(true);
			btnEditar.setVisible(true);
			if (lista_empleados_borrados) { // Si el empleado seleccionado forma parte de la lista de empleados borrados, 'Botón Recuperar'
				btnRecuperar.setVisible(true);
				btnBorrar.setVisible(false);
			}
			else { // En caso contrario 'Botón Borrar'
				btnBorrar.setVisible(true);
				btnRecuperar.setVisible(false);
			}
			
		edicionPanelDcho(false); // Me aseguro de que no se puede editar nada hasta que se presione el botón 'Editar'.
		
		if (empleado!=null) { // Para que no salte error cuando empleado sea = null.
			//CAMPOS DE TEXTO
			tfNombre.setText(empleado.getNombre());
			tfApellido1.setText(empleado.getApe1());
			tfApellido2.setText(empleado.getApe2());
			tfDni.setText(empleado.getDNI());
			
			//COMBOBOX
			comboBox.setSelectedItem(empleado.getClass().getSimpleName());
			
			//RADIO BUTTONS
			if (empleado.getCentro_trabajo().equals("1"))
				rb1.setSelected(true);
			else if (empleado.getCentro_trabajo().equals("2"))
				rb2.setSelected(true);
			else if (empleado.getCentro_trabajo().equals("3"))
				rb3.setSelected(true);
			
			//CHECKBOXES
			setCheckBoxes(false); // Para no guardar los checkboxes activados de otros empleados, los vuelvo a desactivar.
			if (empleado.getClass().getSuperclass().getSimpleName().equals("Tecnico")) { // Si el empleado es un técnico							
				for (String capacidad : ((Tecnico)empleado).getCapacidades()) { // Hago casting sobre empleado para obtener el método de 'getCapacidades'
					if (capacidad.equals("PHP"))
						cbPHP.setSelected(true);
					if (capacidad.equals("JavaScript"))
						cbJavaScript.setSelected(true);
					if (capacidad.equals("JAVA"))
						cbJAVA.setSelected(true);
					if (capacidad.equals("C++"))
						cbC.setSelected(true);
					if (capacidad.equals("Ruby"))
						cbRuby.setSelected(true);
					if (capacidad.equals("Rails"))
						cbRails.setSelected(true);
					if (capacidad.equals("SCSS"))
						cbSCSS.setSelected(true);
					if (capacidad.equals("HTML&CSS"))
						cbMarcas.setSelected(true);
					if (capacidad.equals("GitHub"))
						cbGitHub.setSelected(true);
					if (capacidad.equals("Photoshop"))
						cbPhotoshop.setSelected(true);
					if (capacidad.equals("Project_Manager"))
						cbProjectManager.setSelected(true);
				}
			}								
		}
	}
	
	/**
	 * Al presionar el botón de guardar, creo un nuevo empleado a partir de los campos rellenados y lo almaceno en la BBDD.
	 * En caso contrario, checqueo todos los campos, sean o no modificados y los sobreescribo por los existentes en la BBDD.
	 */
	private void guardarCambios() {
		
		//CAMPOS DE TEXTO
		String nombre = tfNombre.getText();
		String ape1 = tfApellido1.getText();
		String ape2 = tfApellido2.getText();
		String dni = tfDni.getText(); // El dni lo obtengo NO para modificarlo, sino para el querySQL que pasaré como parámeto al métododo 'BaseDatosEmpleadosMySQL.modificar(querySQL)';
		
		//COMBOBOX
		String puesto_trabajo = (String) comboBox.getSelectedItem();
		
		//RADIO BUTTONS
		String centro_trabajo;
		if (rb1.isSelected())
			centro_trabajo="1";
		else if (rb2.isSelected())
			centro_trabajo="2";
		else
			centro_trabajo="3";
		
		if (empleado_nuevo) {
			BaseDatosEmpleadosMySQL.modificar("INSERT INTO empleados (nombre, ape1, ape2, dni, centro_trabajo, puesto_trabajo, borrado)"
												+ "VALUES"
													+ "('" + nombre + "', '" + ape1 + "', '" + ape2 + "', '" + dni + "', '" + centro_trabajo + "', '" + puesto_trabajo + "', false)");
		}
		else {
			BaseDatosEmpleadosMySQL.modificar("UPDATE empleados "
												+ "SET nombre='" + nombre + "'," + "ape1='" + ape1 + "'," + "ape2='" + ape2 + "'," +  "centro_trabajo='" + centro_trabajo + "'," +  "puesto_trabajo='" + puesto_trabajo + "'"
												+ "WHERE dni='" + dni + "'");
		}
	
		//CHECKBOXES
		BaseDatosEmpleadosMySQL.modificar("DELETE FROM conocimientos_empleado "
											+ "WHERE dni_empleado = '" + dni + "'"); //Borro antes, en caso de que las hubiese, las capacidades que ya tuviese agregadas.
		if (cbPHP.isSelected())
			aplicarCheckboxQuery(dni, 0); // Los valores vienen especificados en el SQL
		if (cbJavaScript.isSelected())
			aplicarCheckboxQuery(dni, 1);
		if (cbJAVA.isSelected())
			aplicarCheckboxQuery(dni, 2);
		if (cbC.isSelected())
			aplicarCheckboxQuery(dni, 3);
		if (cbRuby.isSelected())
			aplicarCheckboxQuery(dni, 4);
		if (cbRails.isSelected())
			aplicarCheckboxQuery(dni, 5);
		if (cbSCSS.isSelected())
			aplicarCheckboxQuery(dni, 6);
		if (cbMarcas.isSelected())
			aplicarCheckboxQuery(dni, 7);
		if (cbGitHub.isSelected())
			aplicarCheckboxQuery(dni, 8);
		if (cbPhotoshop.isSelected())
			aplicarCheckboxQuery(dni, 9);
		if (cbProjectManager.isSelected())
			aplicarCheckboxQuery(dni, 10);
	}

	/**
	 * Modifica la capacidad indicada por su valor, del empleado con un dni, en la BBDD de SQL.
	 * @param dni
	 * @param valor_capacidad (declarados en el SQL. Cada valor corresponde con una capacidad determinada)
	 */
	private void aplicarCheckboxQuery(String dni, int valor_capacidad) {
		BaseDatosEmpleadosMySQL.modificar("INSERT INTO conocimientos_empleado (dni_empleado, codigo_capacidad)"
											+ "VALUES"
											+ "( '" + dni + "', " + valor_capacidad + ")");
	}
	
	/**
	 * Reiniciará todos los campos del Panel derecho a valor nulo o por defecto
	 */
	private void reiniciarCampos() {
		
		//CAMPOS DE TEXTO
		tfNombre.setText("");
		tfApellido1.setText("");
		tfApellido2.setText("");
		tfDni.setText("");
		
		//COMBOBOX
		comboBox.setSelectedItem("Administrativo");
		
		//RADIO BUTTONS
		rb1.setSelected(true);
		rb2.setSelected(false);
		rb3.setSelected(false);
		
		//CHECKBOXES
		setCheckBoxes(false);
	}
}
