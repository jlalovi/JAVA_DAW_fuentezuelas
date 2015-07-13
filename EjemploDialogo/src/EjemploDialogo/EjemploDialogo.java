package EjemploDialogo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class EjemploDialogo {

	private JFrame frame;
	private JButton btnMostrarDilogoMensaje;
	private JButton btnMostrarDilogo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploDialogo window = new EjemploDialogo();
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
	public EjemploDialogo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnMostrarDilogoMensaje = new JButton("Mostrar Di\u00E1logo de mensaje");
		btnMostrarDilogoMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Esto es el texto del Message Dialog");
				JOptionPane.showMessageDialog(frame, "Contenido de la ventana emergente", "Título de ventana", JOptionPane.YES_NO_CANCEL_OPTION);
			}
		});
		frame.getContentPane().add(btnMostrarDilogoMensaje);
		
		btnMostrarDilogo = new JButton("Mostrar Di\u00E1logo 2");
		btnMostrarDilogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// En este caso el 'JOptionPane' devuelve un int que equivaldrá a botón presionado (-1 si se ha presionado la 'x' de cerrar ventana)
				int j= JOptionPane.showOptionDialog(frame, "Contenido de la ventana de diálogo", "Título de la ventana", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
				JOptionPane.showMessageDialog(frame, "Has pulsado el número "+j);
			}
		});
		frame.getContentPane().add(btnMostrarDilogo);
	}

}
