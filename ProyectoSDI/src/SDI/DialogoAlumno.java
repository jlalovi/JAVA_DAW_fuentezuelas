package SDI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoAlumno extends JDialog { // Ojo!!!! Esto es un JDialog, generado también en 'Other'

	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textEdad;
	private Alumno miAlumno;
	
	public enum BotonPulsado {
		OK,
		CANCELAR
	}	
	private BotonPulsado resultado;

	// Se ha borrado el MAIN generado automáticamente aquí!!!!
	
	//getter para BotonPulsado
	public BotonPulsado getResultado() {
		return resultado;
	}

	//getter creado para miAlumno
	public Alumno getMiAlumno() {
		return miAlumno;
	}

	/**
	 * Create the dialog.
	 */
	public DialogoAlumno(JFrame padre, String titulo, boolean modal, Alumno al) { // Al constructor le he modificado los parámetros!!!
		super(padre, titulo, modal); // Llamo a los parámetros de padre.
		
		miAlumno=al; // Ojo!!! mejor no hacerlo así pasando por referencia, hacerlo bien hecho con setters/getters
					 // En este caso no es necesario tener una propiedad miAlumno
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblNombre = new JLabel("Nombre");
			contentPanel.add(lblNombre);
		}
		{
			textNombre = new JTextField();
			contentPanel.add(textNombre);
			textNombre.setColumns(10);
		}
		{
			JLabel lblApellidos = new JLabel("Apellidos");
			contentPanel.add(lblApellidos);
		}
		{
			textApellidos = new JTextField();
			contentPanel.add(textApellidos);
			textApellidos.setColumns(10);
		}
		{
			JLabel lblEdad = new JLabel("Edad");
			contentPanel.add(lblEdad);
		}
		{
			textEdad = new JTextField();
			contentPanel.add(textEdad);
			textEdad.setColumns(10);
		}
		//Pasamos los datos del alumno a los textfields:
		textNombre.setText(this.miAlumno.getNombre());
		textApellidos.setText(this.miAlumno.getApellidos());
		textEdad.setText((this.miAlumno.getEdad()+""));
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						miAlumno.setNombre(textNombre.getText());
						miAlumno.setApellidos(textApellidos.getText());
						miAlumno.setEdad(Integer.parseInt(textEdad.getText()));
						DialogoAlumno.this.setVisible(false);
						
						resultado=BotonPulsado.OK;
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DialogoAlumno.this.setVisible(false);
						
						resultado=BotonPulsado.CANCELAR;
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
