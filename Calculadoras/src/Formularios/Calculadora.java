package Formularios;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Manejadores.ManejadorBotonSuma;

public class Calculadora extends JFrame implements KeyListener {

	//PROPIEDADES
	
	JLabel lblNumero1, lblNumero2, lblResultado;
	JTextField txtNumero1, txtNumero2, txtResultado;
	JButton btnSumar;
	
	//CONSTRUCTOR
	
	public Calculadora() {
		//Creamos los componentes
		lblNumero1= new JLabel("Numero1");
		//lblNumero1.setBounds(10,10,60,60); // Absolute layout
		lblNumero2= new JLabel("Numero2");
		lblResultado= new JLabel("Resultado");


		txtNumero1= new JTextField(5);
		//txtNumero1.setBounds(10,80,60,60); // Absolute layout
		txtNumero2= new JTextField(5);
		txtResultado= new JTextField(10);

		btnSumar = new JButton("SUMAR");
		
		//Configuración del frame
		this.setVisible(true);
		// this.setLayout(null); // Absolute layout, el que trae por defecto. Esto implica que tengamos que utilizar el setBounds en cada elemento para posicionarlo y darle tamaño.
		//this.setLayout(new FlowLayout(FlowLayout.LEFT,30,60)); // Flow layout. Parámetro vacío del 'new FlowLayout()' está centrado por defecto.
		this.setLayout(new GridLayout(4,2)); // Grid Layout (filas, columnas) Distribuidas en la ventana y sin posibilidad de darles tamaño.
		this.setBounds(50, 50, 600, 700); // x, y Posición donde empieza la esquina superior izq de la ventana. width, height
		
		//Instertar componentes
		this.getContentPane().add(lblNumero1);
		this.getContentPane().add(txtNumero1);
		this.getContentPane().add(lblNumero2);
		this.getContentPane().add(txtNumero2);
		this.getContentPane().add(lblResultado);
		this.getContentPane().add(txtResultado);
		this.getContentPane().add(btnSumar);
		
		//Crear evento y manejador
			//HAY 3 FORMAS:
			// 1. Clase que implemente ActionListener, que esté creada externa al MAIN
			// 2. Clase que implemente ActionListener, que esté creada dentro del MAIN
			// 3. Clase ANONIMA que implemente ActionListener, que esté creada dentro del MAIN
		
		// btnSumar.addActionListener(new ManejadorBotonSuma(this)); // Clase 1.
		btnSumar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtResultado.setText(Integer.parseInt(txtNumero1.getText())
									+Integer.parseInt(txtNumero2.getText())+"");
			}
			
		}); // Clase 3. Es la que se suele utilizar, sobre todo con el 'Windows Builder', lo malo, es que no se puede reutilizar como la anterior.
		
		txtNumero1.addKeyListener(this); // Clase 2. En este ejemplo, me va a venir bien para controlar el error
		txtNumero2.addKeyListener(this); // Lo mismo para el text box 2.
		
	}

	@Override
	public void keyTyped(KeyEvent e) {  // Accedo al caráter presionado por teclado
		String digitos ="0123456789";
		if(digitos.indexOf(e.getKeyChar())==-1) { // Si lo que he pulsado NO es un número
			Toolkit.getDefaultToolkit().beep();
			e.consume();
		}
	}

	// Accedo a la tecla presionada por teclado (Esto es muy lioso porque hay que controlar qué valor de tecla está cogiendo),
	// así que pasamos de ellas por el momento. No obstante, tienen que estar implementadas debido a la interface implementada.
	@Override
	public void keyPressed(KeyEvent e) {   
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
