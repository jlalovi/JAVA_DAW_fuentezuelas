
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Principal {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Alumno a1 = new Alumno("Pepe", "P�rez", "1");
		Alumno a2 = new Alumno("Pepe", "P�rez", "2");
		Alumno a3 = new Alumno("Pepe", "P�rez", "3");

		Aula a = new Aula("1DAW");
		a.a�adeA�umno(a1);
		a.a�adeA�umno(a2);
		a.a�adeA�umno(a3);
		
		System.out.println(a);
		
		// Vamos a guardar "serializar" el aula
		FileOutputStream f = new FileOutputStream("aula.txt");
		ObjectOutputStream o = new ObjectOutputStream(f);
		
		o.writeObject(a); // Si aula no se "serializa" dar� un error de tipo exception, diciendo que aula NO es serializable. Para ello tendremos que serializar entonces Aula y Alumno
		
		a = null; // Elimino el contenido de Aula a para el siguiente ejemplo 
		
		System.out.println(a);
		
		// vamos a leer ("deserializar") el aula
		ObjectInputStream ol = new ObjectInputStream(new FileInputStream("aula.txt"));
		
		a=(Aula)ol.readObject();
		
		System.out.println(a);
		
	}

}
