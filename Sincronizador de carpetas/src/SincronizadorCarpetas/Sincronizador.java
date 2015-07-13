package SincronizadorCarpetas;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
 
/**
 * Metodos para la sincronización de archivos, hacer comparaciones y mostrar informacion.
 * No necesito crear un constructor por defecto, puesto que tampoco necesito definir ninguna
 * propiedad, ya que las que necesito son para almacenar datos que luego se reiniciarán.
 * 
 * @author Javier Latorre -> jlalovi@gmail.com
 * 
 */
public class Sincronizador {

	/**
	 * Método principal para sincronizar los dos rutas especificadas en los parámetros una vez creado un objeto 'Sincronizador'
	 * en el contenedor del programa.
	 * 
	 * Los archivos y subcarpertas contenidas en ruta_origen se copiarán en ruta_destino si es que no existen.
	 * 
	 * En caso de que los archivos existan en ambas rutas, se comprobará si la fecha del origen es mayor a la de destino, 
	 * en caso afirmativo, se sobreescribirá el archivo origen con el destino.
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
			
			// Listado de archivos que se copiarán o sobreescribirán
			ArrayList<File> archivos_a_copiar = comparaRutas(archivos_origen, archivos_destino);
			
			// Copia o sobreescritura archivo a archivo
			for(File archivo_origen : archivos_a_copiar) {
				if(archivo_origen.isDirectory()) {
					copiarDirectorio(archivo_origen, directorio_destino.getAbsolutePath() + "/");
				}
				else {
					copiarArchivo(archivo_origen, directorio_destino.getAbsolutePath() + "/");				
				}
				// Igualo la fecha de modificación del archivo copiado con la del original.
				directorio_destino.setLastModified(archivo_origen.lastModified());
				
			}
		}
	}
	
	/**
	 * 
	 * Método que compara la lista de archivos en el directorio origen con el directorio destino (incluyendo subcarpetas)
	 * Se devolverá una lista de aquellos archivos que se copiarán sino existen en el destino, y en caso de existir, que 
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
					// Si ambos son directorios, entonces se sincronizarán (Recursividad)
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
				archivos_a_copiar.add(archivo_origen); //Si quiero que el archivo origen se copie a destino, lo añado a la lista.
			}
		}
		return archivos_a_copiar;
	}
	
	/**
	 * Método que copia o sobreescribe un archivo hacia un directorio destino
	 * 
	 * @param archivo que se copiará/sobreescribirá en el destino
	 * @param ruta_estino donde se copiará/sobreescribirá el archivo
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
			System.out.println("Se ha copiado con éxito: " + ruta_destino);
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Copia un directorio en la ruta destino.
	 * 
	 * @param directorio que se creará en la ruta destino
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