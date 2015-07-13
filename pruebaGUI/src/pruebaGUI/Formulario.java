package pruebaGUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*; // Se van a utilizar muchas librerías de swing, por lo que le pongo el * para seleccionar todas

public class Formulario extends JFrame implements ActionListener {
	
	private JPanel panel;
	private JLabel etiqueta;
	private JTextField textbox;
	private JButton boton;
	private JButton boton2;
	
	public Formulario() {
		
		// ELEMENTOS DEL FORMULARIO
		
		this.setTitle("Mi primer GUI"); //Este es el título de la ventana que se crea
		this.setSize(500, 80);
		
		panel = new JPanel(new FlowLayout()); // Creemos un panel para meterlo dentro del frame
		this.add(panel);
		
		etiqueta = new JLabel("Nombre");
		panel.add(etiqueta); // Añadimos la etiqueta al panel creado anteriormente.
		
		textbox = new JTextField(20); // El tamaño es como la propiedad 'size'
		panel.add(textbox);
		
		boton = new JButton("Saluda");
		panel.add(boton);
		
		boton2 = new JButton("Insulta");
		panel.add(boton2);

		this.setVisible(true); // Para que la ventana sea visible
		
		// CONTROLADOR DE EVENTOS
		
		boton.addActionListener(this);  // Cada elemento tiene un ActionListener por defecto (Boton, ser pulsado).
										// Entre paréntesis se pone la clase/método que se quiere llamar.
										// El addAcctionListener necesita implementar la interface 'ActionListener'
										// En este this, estoy llamando al ActionPerformed que está definido en la clase Formulario
		
		boton2.addActionListener(this);
		textbox.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object control=e.getSource(); // Si se ha pulsado un boton, devuelve JButon, si es un textbox, un JTextField, etc.
		
		String contenido_boton=e.getActionCommand(); // Esto almacenará el valor del comando, en el caso por ej de un botón, su contenido.
		
		if (control instanceof JButton) {
			if (control.equals(boton)) {
				JOptionPane.showMessageDialog(this, "Hola " + textbox.getText() + ". El botón pone " + contenido_boton);
			}
			else if (control.equals(boton2)) {
				JOptionPane.showMessageDialog(this, "Tu padre " + textbox.getText() + ". El botón pone " + contenido_boton);
			}			
		}
		else {
			JOptionPane.showMessageDialog(this, "Has presionado enter en el textbox");
		}
		
		
	}
}
