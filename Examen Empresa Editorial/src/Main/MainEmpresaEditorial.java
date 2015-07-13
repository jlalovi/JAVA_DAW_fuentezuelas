package Main;

import java.util.ArrayList;

import EmpresaEditorial.*;
import MetodosEstaticosGenerales.*;
import Publicaciones.*;

public class MainEmpresaEditorial {

	public static void main(String[] args) {
		
		//PROPIEDADES
		int opcion_menu;
		String isbn;
		String nombre_titulo;
		int npaginas;
		TapaLibro tipo_tapa;
		String nombre_completo;
		String dni;
		
		System.out.println("PRUEBA DE EXAMEN. EDITORIAL DE PUBLICACIONES");
		System.out.println("============================================\n");
		Editorial editorial= new Editorial();
		do {
			opcion_menu=Integer.parseInt((Preguntar.opciones(
				"Men� principal. Editorial de publicaciones.\n"
			  + "������������������������������������������\n"
			  + "Elige una de las siguientes opciones introduciendo el n�mero y presionando intro:\n"
			  + "  1.- A�adir libro.\n"
			  + "  2.- A�adir diario.\n"
			  + "  3.- A�adir Revista.\n"
			  + "  4.- Buscar ficha de publicaci�n.\n"
			  + "  5.- Listar todas las publicaciones.\n"
			  + "  6.- Borrar publicaci�n.\n"
			  + "  7.- A�adir publicaciones por defecto.\n"
			  + "  8.- Salir del programa.\n", "1,2,3,4,5,6,7,8")));
			
			//1.- A�adir libro:
			if (opcion_menu==1){
				do {
					isbn=Preguntar.cadena("Introduce el ISBN del libro", 10, 13, false); // Tama�o m�nimo de la cadena 10 y m�ximo 13, sin espacios.
					if (editorial.existeISBN(isbn)==false)
						System.out.println("El ISBN itroducido ya existe en la Base de Datos. Por favor, introduce otro diferente.");
				}while(editorial.existeISBN(isbn)==false);
				nombre_titulo=Preguntar.cadena("Introduce el t�tulo del libro:", 1, 30, true);
				npaginas=Preguntar.intervalo("Introduce el n�mero de p�ginas", 1, 999999); // N�mero de p�ginas entre 1 y 999.999 (pedazo de libro)
				String opcion_tapa = Preguntar.opciones("Introduce el tipo de tapa de libro. (D)ura, (B)landa", "d,b,D,B");
				if (opcion_tapa.equalsIgnoreCase("d"))
					tipo_tapa = TapaLibro.DURA;
				else
					tipo_tapa = TapaLibro.BLANDA;
				editorial.a�adirPublicacion(new Libro(isbn, npaginas, nombre_titulo, tipo_tapa));
				String sino="";
				do {
					nombre_completo=Preguntar.cadena("Introduce el nombre del autor del libro", 1, 50, true);
					do {
						dni=Preguntar.cadena("Introduce el nombre del autor del libro", 2, 9, true);
						if (ComprobarDNI.esCorrecto(dni)==false)
							System.out.println("El dni introducido no es correcto, por favor introd�celo de nuevo");
					}while(ComprobarDNI.esCorrecto(dni)==false);
					
				}while(sino.equalsIgnoreCase("s"));
			}
			
			//2.- A�adir diario:
			if (opcion_menu==2){
				
			}
			
			//3.- A�adir revista:
			if (opcion_menu==3){
				
			}
			
			//4.- Buscar ficha de publicaci�n:
			if (opcion_menu==1){
				
			}
			
			//5.- Listar todas las publicaciones:
			if (opcion_menu==1){
				
			}
			
			//6.- Borrar publicaci�n:
			if (opcion_menu==1){
				
			}
			
			//7.- A�adir publicaciones por defecto:
			if (opcion_menu==1){
				
			}
					
		//8.- Salir del programa:
		} while(opcion_menu!=8);
		
		System.out.println("�Gracias por utilizar el programa!\n"
				+ "Javier Latorre - jlalovi@gmail.com");	
		
		
		//TESTEO:
		
		//Creaci�n de publicaciones y autores
		
		Libro p1 = new Libro("1111111111x", 120, "Titulo Libro 1", TapaLibro.BLANDA);
			p1.a�adirAutor("11111111H", "Perico de los Palotes");
		Libro p2 = new Libro("2222222222f", 160, "Titulo Libro 2", TapaLibro.DURA);
			p2.a�adirAutor("22222222J", "Josefa L�pez Pereira");
			p2.a�adirAutor("33333333P", "Laura Ruiz de la Casa");
		Libro p3 = new Libro("3333333333j", 189, "Titulo Libro 3", TapaLibro.BLANDA);
			p3.a�adirAutor("44444444A", "Victor Hugo Charso");
		Libro p4 = new Libro("4444444444t", 100, "Titulo Libro 4", TapaLibro.DURA);
			p4.a�adirAutor("77777777B", "Carmen Puebla Domingo");
		
		Revista p5 = new Revista("4444444444r", 20, "Nombre publicacion 1");
		Revista p6 = new Revista("5555555555x", 10, "Nombre publicacion 2");
		Revista p7 = new Revista("6666666666z", 12, "Nombre publicacion 3");
		Revista p8 = new Revista("7777777777w", 10, "Nombre publicacion 4");
		
		Diario p9  = new Diario("8888888888b", 12, "Nombre publicacion 5");
		Diario p10 = new Diario("9999999999x", 10, "Nombre publicacion 6");
		Diario p11 = new Diario("1234545457w", 20, "Nombre publicacion 7");
		Diario p12 = new Diario("6345634543q", 25, "Nombre publicacion 8");
		
//		Editorial editorial = new Editorial();
		editorial.a�adirPublicaciones(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12);
		
		//To String.
		
//		System.out.println(p1);
//		System.out.println(p6);
		
		//Buscar e imprimir por isbn
		
//		System.out.println(editorial.buscarPublicacion("1111111111x"));
//		System.out.println(editorial.buscarPublicacion("6666666666z"));
//		editorial.borrarPublicacion("6666666666z");
//		System.out.println(editorial.buscarPublicacion("6666666666z")); // Comprobar si se ha borrado
		
//		System.out.println(editorial.listarPublicaciones());
		
		
	}

}
