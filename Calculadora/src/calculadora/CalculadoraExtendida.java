package calculadora;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * 
 * Ejercicio de clase de una Calculadora con operaciones b�sicas y su interfaz gr�fica relaizada con el 'GridBagLayout'.
 * He utilizado la clase 'BigDecimal' para realizar operaciones con los n�meros. Me habr�a gustado ordenar un poco m�s
 * el c�digo y experimentar m�s con la interfaz gr�fica, pero debido a la carga lectiva en otras asignaturas y el carecer
 * del tiempo suficiente, no he podido hacer mucho m�s.
 * 
 * @author Javier Latorre L�pez-Villalta - jlalovi@gmail.com
 *
 */
public class CalculadoraExtendida extends JFrame implements ActionListener {

	//PROPIEDADES
	private JButton btnNumero;
	private JButton btnSumar;
	private JButton btnRestar;
	private JButton btnMultiplicar;
	private JButton btnDividir;
	private JButton btnModulo;
	private JButton btnBorrar;
	private JButton btnDecimal;
	private JButton btnIgual;
	private JTextField txtResultado;
	private JTextField txtOperaciones;
	private String resultado_acumulado; // Cada vez que se realiza una operaci�n, el resultado se almacenar� en esta variable
	private String numero = ""; // Cada vez que se realiza una operaci�n, este n�mero opera con el resultado operado.
	private boolean primer_numero; // Relacionado con la variable anterior, para saber si es el primer n�mero con el que se opera o no.
	private Operador op;
	BigDecimal valor_acumulado;
	BigDecimal valor_nuevo;
	
	//CONSTRUCTOR
	
	/**
	 * Constructor �nico y por defecto de la "Calculadora Extendida"
	 */
    public CalculadoraExtendida()  {
    
    	this.resultado_acumulado = "0"; // El resultado acumulado ser� 0 al inicio de la calculadora.
    	this.numero = "0"; // El n�mero acumulado ser� 0 al inicio de la calculadora y se reiniciar� cada vez que se presione un signo.
    	this.primer_numero = true; // Al iniciar la calculadora, esta suposici�n ser� verdadera.
    	op = Operador.NULL;
    	
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
            this.btnNumero= new JButton(i+"");
            this.btnNumero.setFont(new Font ("Arial", Font.BOLD,25));
            this.btnNumero.setBackground(Color.getHSBColor(45,105,255));
            this.btnNumero.setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.btnNumero.setActionCommand(i+""); //El valor del bot�n, que tiene que ser cadena, de ah� el casting
            this.btnNumero.setFocusable(false);
            restriccionBag.gridx=i%3; //obtengo valores entre 0 y 2 (las 3 columnas que quiero)
            restriccionBag.weightx=0.1;
            restriccionBag.weighty=0.1;    
            restriccionBag.fill=GridBagConstraints.BOTH;
            this.btnNumero.addActionListener(this);
			this.getContentPane().add(this.btnNumero, restriccionBag);
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
		
		//Bot�n Dividir
        restriccionBag.gridx=1;
		this.btnDividir = new JButton("/");
		this.btnDividir.addActionListener(this);
		this.getContentPane().add(this.btnDividir, restriccionBag);
		this.btnDividir.setFont(new Font("Arial", Font.BOLD, 25));
		this.btnDividir.setFocusable(false);
		this.btnDividir.setBackground(Color.getHSBColor(272,125,255));
		this.btnDividir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		//Bot�n M�dulo
        restriccionBag.gridx=2;
		this.btnModulo = new JButton("%");
		this.btnModulo.addActionListener(this);
		this.getContentPane().add(this.btnModulo, restriccionBag);
		this.btnModulo.setFont(new Font("Arial", Font.BOLD, 25));
		this.btnModulo.setFocusable(false);
		this.btnModulo.setBackground(Color.getHSBColor(272,125,255));
		this.btnModulo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		//Bot�n Borrar
        restriccionBag.gridx=0;
		this.btnBorrar = new JButton("C");
		this.btnBorrar.addActionListener(this);
		this.getContentPane().add(this.btnBorrar, restriccionBag);
		this.btnBorrar.setFont(new Font("Arial", Font.BOLD, 25));
		this.btnBorrar.setFocusable(false);
		this.btnBorrar.setBackground(new Color(233,168,132));
		this.btnBorrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		//Bot�n Decimal
        restriccionBag.gridx=1;
		this.btnDecimal = new JButton(".");
		this.btnDecimal.addActionListener(this);
		this.getContentPane().add(this.btnDecimal, restriccionBag);
		this.btnDecimal.setFont(new Font("Arial", Font.BOLD, 25));
		this.btnDecimal.setFocusable(false);
		this.btnDecimal.setBackground(Color.getHSBColor(272,125,255));
		this.btnDecimal.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
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
		
		// Si el valor pulsado es un n�mero o '.' decimal
		if (valor>=48 && valor<=57 || valor=='.') {
			
			//Reinicio los valores por defecto si se ha realizado una operaci�n anteriormente con '=', si ha habido un error o si .
			if (op==Operador.RESETEAR || op==Operador.REINICIAR) {
				this.resultado_acumulado = "0";
		    	this.numero = "";
		    	this.txtOperaciones.setText("0");
		    	this.txtResultado.setText("0");
		    	this.primer_numero = true;
				op=Operador.NULL;
			}
			
			if (this.numero.indexOf('.')!=-1 && valor=='.');
			else if (this.txtOperaciones.getText().charAt(0)=='0' && this.numero.indexOf('.')==-1) { // Para que el valor por defecto a 0 se sustituya por otro valor (siempre y cuando no vaya acompa�ado de un decimal)
				if (valor=='.') { // El 0 no se elimina si se a�ade un '.'
					this.txtOperaciones.setText(this.txtOperaciones.getText()+valor); // Pantalla de Operaciones acumuladas
					this.numero+=valor; // N�mero con el que se operar� una vez se introduzca el signo
				}
				else {
					this.txtOperaciones.setText(valor+""); // Pantalla de Operaciones acumuladas
					this.numero=valor+""; // N�mero con el que se operar� una vez se introduzca el signo
				}				
			}
			else {
				this.txtOperaciones.setText(this.txtOperaciones.getText()+valor); // Pantalla de Operaciones acumuladas
				this.numero+=valor; // N�mero con el que se operar� una vez se introduzca el signo
			}
			
			if (this.numero.charAt(0)=='.') { // Por si acaso se pulsa un decimal sin el '0' a la izquierda, ya que BigDecimal dar�a error
				this.numero="0.";
				this.txtOperaciones.setText(this.txtOperaciones.getText().substring(0, this.txtOperaciones.getText().length()-2)+" 0.");
			}
			
		}
		
		// Si el valor pulsado NO es n�mero, y reiniciar=true, muestra el siguiente mensaje y un pitido.
		else if (op==Operador.RESETEAR) {
			this.txtOperaciones.setText("Clickea un n�mero para reiniciar");
			Toolkit.getDefaultToolkit().beep();
		}
		
		// Si el valor pulsado NO es un n�mero, se comprueba que el �ltimo valor introducido S� lo era.
		else if (ultimo_valor>=48 && ultimo_valor<=57) {
			
			if (this.numero.length()>16) { // No permito m�s de 16 d�gitos (contando el '.' decimal)
				this.resultado_acumulado="--Err--";
				op=Operador.RESETEAR;
			}
			
			else {
				
				String pantalla = this.txtOperaciones.getText();
				
				if (ultimo_valor>=48 && ultimo_valor<=57 && valor!='=' && valor!='C')  // Si el �ltimo valor introducido fue un n�mero (y ahora el valor es diferente a n�mero)
					this.txtOperaciones.setText(pantalla+" "+valor+" "); // A�ado el signo en la cadena
				
				if(!this.primer_numero && ultimo_valor>=48 && ultimo_valor<=57) { // Me aseguro de que se entra en este paso s� NO se ha introducido todav�a un primer valor y si es n�mero
					
					if (op!=Operador.NULL && op!=Operador.REINICIAR) {
						valor_acumulado = new BigDecimal(resultado_acumulado);
						valor_nuevo = new BigDecimal(numero);
					}
					
					if (op==Operador.SUMA) {
						this.resultado_acumulado=valor_acumulado.add(valor_nuevo) + "";
						op=Operador.NULL;
					}
					if (op==Operador.RESTA) {
						this.resultado_acumulado=valor_acumulado.subtract(valor_nuevo) + "";
						op=Operador.NULL;
					}
					if (op==Operador.MULTIPLICACION) {
						this.resultado_acumulado=valor_acumulado.multiply(valor_nuevo) + "";
						op=Operador.NULL;
					}
					if (op==Operador.DIVISION) {
						if (new BigDecimal(numero).equals(new BigDecimal("0"))) {   // Si el divisor de DIVISI�N es 0, devuelvo un error y reseteo.
							this.resultado_acumulado="--Err--";
							op=Operador.RESETEAR;
						}
						else {
							this.resultado_acumulado= valor_acumulado.divide(valor_nuevo, 6, RoundingMode.HALF_UP) + "";
							op=Operador.NULL;
						}
					}
					if (op==Operador.MODULO) {
						if (Long.parseLong(this.numero)==0) {   // Si el divisor del M�DULO es 0, devuelvo un error y reseteo.
							this.resultado_acumulado="--Err--";
							op=Operador.RESETEAR;
						}
						else {
							this.resultado_acumulado=valor_acumulado.remainder(valor_nuevo) + "";
							op=Operador.NULL;
						}
					}
					if (this.resultado_acumulado.indexOf('.')!=-1) { // Quito los malditos ceros a la derecha que quedan debido al uso del 'BigDecimal'
						while (this.resultado_acumulado.charAt(this.resultado_acumulado.length()-1)=='0') {
							this.resultado_acumulado=this.resultado_acumulado.substring(0,this.resultado_acumulado.length()-1);
						}
						if (this.resultado_acumulado.charAt(this.resultado_acumulado.length()-1)=='.') // Si llego al punto, tambi�n lo quito
							this.resultado_acumulado=this.resultado_acumulado.substring(0,this.resultado_acumulado.length()-1);
					}
				}
				else {
					this.resultado_acumulado=numero;
					this.primer_numero=false;
				}
				
				// Registro la operaci�n que se realizar� en el siguiente n�mero
				if (valor=='+') {
					op=Operador.SUMA;
				}
				else if (valor=='-') {
					op=Operador.RESTA;
				}
				else if (valor=='*') {
					op=Operador.MULTIPLICACION;
				}
				else if (valor=='/') {
					op=Operador.DIVISION;
				}
				else if (valor=='%') {
					op=Operador.MODULO;
				}
				else if (valor=='C') {
					this.txtOperaciones.setText("0");
					this.resultado_acumulado="0";
					op=Operador.REINICIAR;
				}
				else if (valor=='=') {
					//this.txtOperaciones.setText(this.resultado_acumulado);
					op=Operador.REINICIAR;
				}
				numero=""; // Despu�s de un signo, el n�mero vuelve a estar vac�o para almacenar el n�mero de la siguiente operaci�n si la hay.
			}				
		}
		
		// En caso de no ser ninguna de las opciones anteriores, devuelvo un pitido de error.
		else {
			Toolkit.getDefaultToolkit().beep();
		}
		
		if (this.resultado_acumulado.length()>16) { // Como no permito m�s de 16 cifras en mi calculadora, muestro un mensaje de error.
			this.resultado_acumulado="--Err--";
			op=Operador.RESETEAR;
		}
		this.txtResultado.setText(this.resultado_acumulado); // Resultado final y acumulado mostrado por pantalla.		
	}
}