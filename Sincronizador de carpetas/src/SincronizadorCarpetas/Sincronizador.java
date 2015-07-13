package SincronizadorCarpetas;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
 
/**
 * Metodos para la sincronizaci�n de archivos, hacer comparaciones y mostrar informacion.
 * No necesito crear un constructor por defecto, puesto que tampoco necesito definir ninguna
 * propiedad, ya que las que necesito son para almacenar datos que luego se reiniciar�n.
 * 
 * @author Javier Latorre -> jlalovi@gmail.com
 * 
 */
public class Sincronizador {

	/**
	 * M�todo principal para sincronizar los dos rutas especificadas en los par�metros una vez creado un objeto 'Sincronizador'
	 * en el contenedor del programa.
	 * 
	 * Los archivos y subcarpertas contenidas en ruta_origen se copiar�n en ruta_destino si es que no existen.
	 * 
	 * En caso de que los archivos existan en ambas rutas, se comprobar� si la fecha del origen es mayor a la de destino, 
	 * en caso afirmativo, se sobreescribir� el archivo origen con el destino.
	 * 
	 * NOTA: este sincronizador NO elimina archivos/directorios de la ruta destino si son eliminados de la ruta origen.
	 * 
	 * @param ruta_origen
	 * @param ruta_destino
	 */
	public void sincronizar(String ruta_origen, String ruta_destino) {
		File directorio_origen  = new File(ruta_origen);
		File directorio_destino = new File(ruta_destino);
		
		if(esDirectorio(directorio_origen) && esDirectorio(directorio_destino)) {
			
			File archivos_origen[]  = directorio_origen.listFiles();
			File archivos_destino[] = directorio_destino.listFiles();
			
			// Listado de archivos que se copiar�n o sobreescribir�n
			ArrayList<File> archivos_a_copiar = comparaRutas(archivos_origen, archivos_destino);
			
			// Copia o sobreescritura archivo a archivo
			for(File archivo_origen : archivos_a_copiar) {
				if(archivo_origen.isDirectory()) {
					copiarDirectorio(archivo_origen, directorio_destino.getAbsolutePath() + "/");
				}
				else {
					copiarArchivo(archivo_origen, directorio_destino.getAbsolutePath() + "/");				
				}
				// Igualo la fecha de modificaci�n del archivo copiado con la del original.
				directorio_destino.setLastModified(archivo_origen.lastModified());
				
			}
		}
	}
	
	/**
	 * 
	 * M�todo que compara la lista de archivos en el directorio origen con el directorio destino (incluyendo subcarpetas)
	 * Se devolver� una lista de aquellos archivos que se copiar�n sino existen en el destino, y en caso de existir, que 
	 * se sobreescriban si la fecha de destino es menor que la de origen.
	 * 
	 * @param origen Array con los archivos del directorio origen
	 * @param destino Array con los archivos del directorio destino
	 * @return Los archivos que se quieren copiar o sobreescribir
	 */
	private ArrayList<File> comparaRutas(File[] archivos_origen, File[] archivos_destino) {
		
		ArrayList<File> archivos_a_copiar = new ArrayList<File>();
		
		for(File archivo_origen : archivos_origen) {
			// Compruebo si debo copiar o no el archivo origen a destino
			boolean copiar = true;
			for(File archivo_destino : archivos_destino) {
				if(archivo_origen.getName().equals(archivo_destino.getName()))  {
					// Si ambos son directorios, entonces se sincronizar�n (Recursividad)
					if(archivo_origen.isDirectory() && archivo_destino.isDirectory()) {
						sincronizar(archivo_origen.getAbsolutePath(), archivo_destino.getAbsolutePath());
						copiar = false;
					}
					// Compruebo que la fecha del archivo origen es menor que la del archivo de origen
					if (archivo_origen.lastModified()/1000L==archivo_destino.lastModified()/1000L) {
						copiar = false;
					}
				}
			}
			if(copiar) {
				archivos_a_copiar.add(archivo_origen); //Si quiero que el archivo origen se copie a destino, lo a�ado a la lista.
			}
		}
		return archivos_a_copiar;
	}
	
	/**
	 * M�todo que copia o sobreescribe un archivo hacia un directorio destino
	 * 
	 * @param archivo que se copiar�/sobreescribir� en el destino
	 * @param ruta_estino donde se copiar�/sobreescribir� el archivo
	 */
	private void copiarArchivo(File archivo, String dirDestino) {
		String nombre = archivo.getName();
		File ruta_destino = new File(dirDestino + nombre);
		
		try {
			ruta_destino.createNewFile();
			
			InputStream in = new FileInputStream(archivo);
			OutputStream out = new FileOutputStream(ruta_destino);
			
			byte[] buffer = new byte[1024];
			int len;
			while( (len=in.read(buffer)) > 0 ) {
				out.write(buffer, 0, len);
			}
			in.close();
			out.close();
			System.out.println("Se ha copiado con �xito: " + ruta_destino);
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Copia un directorio en la ruta destino.
	 * 
	 * @param directorio que se crear� en la ruta destino
	 * @param ruta_destino La ruta hacia el directorio donde se escribira el directorio
	 */
	private void copiarDirectorio(File directorio, String ruta_destino) {
		String nombre_directorio = directorio.getName();
		File archivo_destino = new File(ruta_destino + nombre_directorio);
		
		archivo_destino.mkdir();
		File [] porCopiar = directorio.listFiles();
		
		for(File file : porCopiar) {
			if(file.isDirectory()) {
				copiarDirectorio(file, archivo_destino.getAbsolutePath() + "/");
			}
			else {
				copiarArchivo(file, archivo_destino.getAbsolutePath() + "/");
			}
		}
	}
	
	/**
	 * Valida si un archivo es un directorio o no
	 * 
	 * @param dir El archivo que se validara
	 * @return "true" en caso de que sea un directorio valido, en caso contrario devuelve "false"
	 */
	public boolean esDirectorio(File dir) {
		if(dir.isDirectory()) {
			return true;
		} 
		else {
			return false;
		}
	}
 
}