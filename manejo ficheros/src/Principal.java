
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Principal {

	public static void main(String[] args) throws IOException {

		FileReader entrada=null; // Si no existe el archivo, la variable 'entrada' debe ser null para cerrar el canal de lectura con el 'finally'.
		FileWriter salida=null;
		
		try {
			entrada = new FileReader("datos.txt"); //Si el archivo no est� en la carpeta del proyecto, se pone la ruta completa.
			salida = new FileWriter("copia_datos.txt",false); // archivo donde voy a copiar el contenido le�do. El booleano indica si quieres a�adir la informaci�n en el archivo (true) o sobreescribir (false)
			int c; // El FileReader lee caracter a caracter y lo traduce en un entero. Si devuelve un -1 es que ya no hay m�s car�cteres.
			
			while ((c=entrada.read())!=-1) {
				System.out.print((char)c); // Hago un casting para traducir el n�mero entero que devuelve el FileReader de nuevo en caracteres.
				salida.write(c); // Copio cada caracter en el archivo
			}
		}
		finally {
			if (entrada!=null) {
				entrada.close();
			}
			if (salida!=null) {
				salida.close();
			}
		}

	}

}
