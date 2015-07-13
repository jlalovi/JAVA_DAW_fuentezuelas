
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader entrada=null;
		PrintWriter salida=null;
		FileReader file;
		
		try {
			file = new FileReader("datos.txt");
			entrada = new BufferedReader(file);
			salida = new PrintWriter("copia_datos.txt"); // archivo donde voy a copiar el contenido le�do. El booleano indica si quieres a�adir la informaci�n en el archivo (true) o sobreescribir (false)
			String linea; // El BufferedReader lee l�nea a l�nea. Sino se lee una l�nea, se devolver� un null.

			while ((linea=entrada.readLine())!=null) {
				System.out.println(linea); // Imprimo por consola el resultado
				salida.println(linea); // Copio cada l�nea.
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
