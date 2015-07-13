package Formularios;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * 
 * Ejercicio de clase de una Calculadora con operaciones b�sicas y su interfaz gr�fica relaizada con el 'GridBagLayout'.
 * Las operaciones con las que trabajo en la calculadora s�lo admiten enteros, de ah�, que en vez de poner a prueba la
 * divisi�n, me he decantado por el m�dulo '%'. Quer�a centrarme m�s en investigar la interfaz con 'GridBagLayout' que
 * en controlar n�meros de tipo 'double' y los posibles errores m�tem�ticos que ya hemos controlado en otros ejercicios
 * como el de dividir entre 0.
 * 
 * @author Javier Latorre L�pez-Villalta - jlalovi@gmail.com
 *
 */
public class CalculadoraExtendida extends JFrame implements ActionListener {

	//PROPIEDADES
	private JButton btnBoton;
	private JButton btnSumar;
	private JButton btnRestar;
	private JButton btnMultiplicar;
	private JButton btnModulo;
	private JButton btnIgual;
	private JTextField txtResultado;
	private JTextField txtOperaciones;
	private String resultado_acumulado; // Cada vez que se realiza una operaci�n, el resultado se almacenar� en esta variable
	private String numero = ""; // Cada vez que se realiza una operaci�n, este n�mero opera con el resultado operado.
	private boolean primer_numero; // Relacionado con la variable anterior, para saber si es el primer n�mero con el que se opera o no.
	private boolean restar, modulo, sumar, multiplicar, igual; // Operadores que comenzar�n con un valor falso por defecto.
	private boolean reiniciar; // En caso de error.
	
	//CONSTRUCTOR
	
	/**
	 * Constructor �nico y por defecto de la "Calculadora Extendida"
	 */
    public CalculadoraExtendida()  {
    
    	this.resultado_acumulado = "0"; // El resultado acumulado ser� 0 al inicio de la calculadora.
    	this.numero = "0"; // El n�mero acumulado ser� 0 al inicio de la calculadora y se reiniciar� cada vez que se presione un signo.
    	this.primer_numero = true; // Al iniciar la calculadora, esta suposici�n ser� verdadera.
    	this.sumar=false;
    	this.multiplicar=false;
    	this.restar=false;
    	this.modulo=false;
    	this.igual=false;
    	this.reiniciar=false;
    	
        // configuraci�n
        
    	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); // para averiguar el tama�o de la pantalla
   
        this.setBounds(0,0, 400,500); // Los dos primeros valores los igualo a 0 para luego centrarlos con el siguiente m�todo 'setLocation'
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setTitle("Calculadora est�ndar");
        
        this.setLayout(new GridBagLayout());  // me crea un layout
        
        // dise�o del formulario
        CrearDisenno();
        
        this.setVisible(true); // Es recomendable que este m�todo se ponga al final, porque si no se pueden perder datos.
        
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Salir del programa 
        // setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * M�todo privado para configurar el dise�o y distribuci�n de los componentes de la calculadora utilizando el GridBagLayout
     */
    private void CrearDisenno() {
    	
        GridBagConstraints restriccionBag= new GridBagConstraints();  // Restricciones del GRID
        
        //Botones del 0 al 9
        for (int i = 0; i < 10; i++) {
            this.btnBoton= new JButton(i+"");
            this.btnBoton.setFont(new Font ("Arial", Font.BOLD,25));
            this.btnBoton.setBackground(Color.getHSBColor(45,105,255));
            this.btnBoton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.btnBoton.setActionCommand(i+""); //El valor del bot�n, que tiene que ser cadena, de ah� el casting
            this.btnBoton.setFocusable(false);
            restriccionBag.gridx=i%3; //obtengo valores entre 0 y 2 (las 3 columnas que quiero)
            restriccionBag.weightx=0.1;
            restriccionBag.weighty=0.1;    
            restriccionBag.fill=GridBagConstraints.BOTH;
            this.btnBoton.addActionListener(this);
			this.getContentPane().add(this.btnBoton, restriccionBag);
		}
        
        //Bot�n Sumar
        restriccionBag.gridx=1;
		this.btnSumar = new JButton("+");
		this.btnSumar.addActionListener(this);
		this.getContentPane().add(this.btnSumar, restriccionBag);
		this.btnSumar.setFont(new Font("Arial", Font.BOLD, 25));
		this.btnSumar.setFocusable(false);
		this.btnSumar.setBackground(Color.getHSBColor(272,125,255));
		this.btnSumar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		//Bot�n Restar
        restriccionBag.gridx=2;
		this.btnRestar = new JButton("-");
		this.btnRestar.addActionListener(this);
		this.getContentPane().add(this.btnRestar, restriccionBag);
		this.btnRestar.setFont(new Font("Arial", Font.BOLD, 25));
		this.btnRestar.setFocusable(false);
		this.btnRestar.setBackground(Color.getHSBColor(272,125,255));
		this.btnRestar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		//Bot�n Multiplicar
        restriccionBag.gridx=0;
		this.btnMultiplicar = new JButton("*");
		this.btnMultiplicar.addActionListener(this);
		this.getContentPane().add(this.btnMultiplicar, restriccionBag);
		this.btnMultiplicar.setFont(new Font("Arial", Font.BOLD, 25));
		this.btnMultiplicar.setFocusable(false);
		this.btnMultiplicar.setBackground(Color.getHSBColor(272,125,255));
		this.btnMultiplicar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		//Bot�n M�dulo
        restriccionBag.gridx=1;
		this.btnModulo = new JButton("%");
		this.btnModulo.addActionListener(this);
		this.getContentPane().add(this.btnModulo, restriccionBag);
		this.btnModulo.setFont(new Font("Arial", Font.BOLD, 25));
		this.btnModulo.setFocusable(false);
		this.btnModulo.setBackground(Color.getHSBColor(272,125,255));
		this.btnModulo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		//Bot�n Igual
		restriccionBag.gridx=2;
		this.btnIgual = new JButton("=");
		this.btnIgual.addActionListener(this);
		this.getContentPane().add(this.btnIgual, restriccionBag);
		this.btnIgual.setFont(new Font("Arial", Font.BOLD, 25));
		this.btnIgual.setFocusable(false);
		this.btnIgual.setBackground(Color.getHSBColor(272,125,255));
		this.btnIgual.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		//Pantallas de resultados:
		restriccionBag.gridx=0;
		restriccionBag.gridwidth=3;
		restriccionBag.weightx=0.01;
        restriccionBag.weighty=0.01;		
        
			//Pantalla Operaciones		
			this.txtOperaciones = new JTextField(25);
			this.txtOperaciones.addActionListener(this);
			this.getContentPane().add(this.txtOperaciones, restriccionBag);
			this.txtOperaciones.setText("0");
			this.txtOperaciones.setEditable(false);
			this.txtOperaciones.setFont(new Font("Arial", Font.PLAIN, 20));
			this.txtOperaciones.setBackground(new Color(246,247,216));
			this.txtOperaciones.setBorder(null);
			this.txtOperaciones.setHorizontalAlignment(JTextField.RIGHT);
			
			//Pantalla Resultado
			this.txtResultado = new JTextField(25);
			this.txtResultado.addActionListener(this);
			this.getContentPane().add(this.txtResultado, restriccionBag);
			this.txtResultado.setText("0");
			this.txtResultado.setEditable(false);
			this.txtResultado.setFont(new Font("SansSerif", Font.PLAIN, 40));
			this.txtResultado.setBackground(new Color(246,247,216));
			this.txtResultado.setBorder(null);
			this.txtResultado.setHorizontalAlignment(JTextField.RIGHT);
    }
    
    /**
     * Acciones de cada uno de los botones de la calculadora.
     */
	@Override
	public void actionPerformed(ActionEvent e) {
	
		char valor = e.getActionCommand().charAt(0); //Valor pulsado
		char ultimo_valor = this.txtOperaciones.getText().charAt(this.txtOperaciones.getText().length()-1); // �ltimo d�gito de la cadena mostrada en 'txtOperaciones'
		
		// Si el valor pulsado es un n�mero
		if (valor>=48 && valor<=57) {
			if (reiniciar || igual) { //Reinicio los valores por defecto si se ha realizado una operaci�n anteriormente con '=' o si ha habido un error.
				this.resultado_acumulado = "0";
		    	this.numero = "";
		    	this.txtOperaciones.setText("0");
		    	this.txtResultado.setText("0");
		    	this.primer_numero = true;
				this.reiniciar=false; //'reinicio' el 'reiniciar' ;)
				this.igual=false; //y reinicio el 'igual'
			}
			
			if (this.txtOperaciones.getText().charAt(0)=='0') { // Para que el valor por defecto a 0 se sustituya por otro valor
				this.txtOperaciones.setText(valor+""); // Pantalla de Operaciones acumuladas
				numero=valor+""; // N�mero con el que se operar� una vez se introduzca el signo
			}
			else {
				this.txtOperaciones.setText(this.txtOperaciones.getText()+valor); // Pantalla de Operaciones acumuladas
				numero+=valor; // N�mero con el que se operar� una vez se introduzca el signo
			}
		}
		
		// Si el valor pulsado NO es n�mero, y reiniciar=true, muestra el siguiente mensaje y un pitido.
		else if (reiniciar) {
			this.txtOperaciones.setText("Clickea un n�mero para reiniciar");
			Toolkit.getDefaultToolkit().beep();
		}
		
		// Si el valor pulsado NO es un n�mero, se comprueba que el �ltimo valor introducido S� lo era.
		else if (ultimo_valor>=48 && ultimo_valor<=57) {
			this.igual=false; //Reinicio el 'igual' en caso de que estuviese en 'true'
			
			if (this.numero.length()>9) {
				this.resultado_acumulado="--Err--";
				this.reiniciar=true;
			}
			else {
				this.txtOperaciones.setText(this.txtOperaciones.getText()+" "+valor+" "); // Pantalla de Operaciones acumuladas
				if(!this.primer_numero) {
					// Utilizo valores tipo long por si acaso multiplican cantidades grandes como 999999999*999999999, para que se realice
					// la operaci�n correctamente y luego se compare en la condici�n final mostrando que tiene m�s de 9 cifras, y con ello
					// el error y el reinicio de la calculadora.
					if (sumar) {
						this.resultado_acumulado=Long.toString((Long.parseLong(this.resultado_acumulado) + Long.parseLong(this.numero)));
						this.sumar=false;
					}
					if (restar) {
						this.resultado_acumulado=Long.toString((Long.parseLong(this.resultado_acumulado) - Long.parseLong(this.numero)));
						this.restar=false;
					}
					if (multiplicar) {
						this.resultado_acumulado=Long.toString((Long.parseLong(this.resultado_acumulado) * Long.parseLong(this.numero)));
						this.multiplicar=false;
					}
					if (modulo) {
						if (Long.parseLong(this.numero)==0) {   // Si el divisor del M�dulo es 0, devuelvo un error.
							this.resultado_acumulado="--Err--";
							this.reiniciar=true;
							this.modulo=false;
						}
						else {
							this.resultado_acumulado=Long.toString((Long.parseLong(this.resultado_acumulado) % Long.parseLong(this.numero)));
							this.modulo=false;
						}
					}
				}
				else {
					this.resultado_acumulado=numero;
					this.primer_numero=false;
				}
				
				// Registro la operaci�n que se realizar� en el siguiente n�mero
				if (valor=='+') {
					this.sumar=true;
				}
				else if (valor=='-') {
					this.restar=true;
				}
				else if (valor=='*') {
					this.multiplicar=true;
				}
				else if (valor=='%') {
					this.modulo=true;
				}
				else if (valor=='=') {
					this.txtOperaciones.setText(this.resultado_acumulado);
					this.igual=true;
				}
				numero=""; // Despu�s de un signo, el n�mero vuelve a estar vac�o para almacenar el n�mero de la siguiente operaci�n si la hay.
			}				
		}
		
		// En caso de no ser ninguna de las opciones anteriores, devuelvo un pitido de error.
		else {
			Toolkit.getDefaultToolkit().beep();
		}
		
		if (this.resultado_acumulado.length()>9) { // Como no permito m�s de 9 cifras en mi calculadora, muestro un mensaje de error.
			this.resultado_acumulado="--Err--";
			this.reiniciar=true;
		}
		this.txtResultado.setText(this.resultado_acumulado); // Resultado final y acumulado mostrado por pantalla.		
	}
}
