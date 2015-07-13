package MDI;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JDesktopPane;
import javax.swing.plaf.DesktopPaneUI;

import java.awt.BorderLayout;
import java.beans.PropertyVetoException;

public class MDIaplicacion {

	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmAbrir;
	private JMenuItem mntmCerrar;
	private JDesktopPane desktopPane;
	
	private static int DocumentoNumero; // Static para que sea una propiedad propia de la clase

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MDIaplicacion window = new MDIaplicacion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MDIaplicacion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Para crear un JInternalPanel sobre el DescktopPanel al pulsar el botón abrir
				JInternalFrame nuevo = new JInternalFrame("Documento"+ (++DocumentoNumero), true, true, true, true); // Añado el contador estático. El primer true=dimensionable, segundo true=cerrable, tercer true=maximizable, cuarto true=minimizable
				
				nuevo.setBounds(0,0,200,200);
				
				desktopPane.setLayout(new GridLayout(0,3)); // Para distribuir las 'JInternalFrame' en un gridlayout
				
				desktopPane.add(nuevo);
				
				nuevo.setVisible(true);
			}
		});
		mnArchivo.add(mntmAbrir);
		
		mntmCerrar = new JMenuItem("Cerrar");
		mntmCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					desktopPane.getSelectedFrame().setClosed(true); // 'getSelectedFrame' devuelve el desktopPane seleccionado.
				} catch (PropertyVetoException e1) {
					e1.printStackTrace();
				} 
			}
		});
		mnArchivo.add(mntmCerrar);
		
		desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
	}

}
