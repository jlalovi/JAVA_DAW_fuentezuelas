package main;

import generadorXML.XMLGenerator;

import java.util.ArrayList;

import lecturaRSS.Feed;
import lecturaRSS.FeedMessage;
import lecturaRSS.RSSFeedParser;
import MySQL.*;


public class Main {
  	public static void main(String[] args) throws Exception {

  		// Variable que almacena la URL del RSS que se quiere tratar (Se puede cambiar por la que quieras para probar)
  		String urlrss = "https://www.meneame.net/rss?status=queued";
  		
  		// En esta variable almacenaré los valores de cada nodo.
  		ArrayList<ArrayList<String>> nodos = new ArrayList<ArrayList<String>>(); 
  		
	    RSSFeedParser parser = new RSSFeedParser(urlrss); // URL donde se encuentra el archivo RSS
	    Feed feed = parser.readFeed(); // Este método devuelve un objeto feed a partir de la URL anterior. Almaceno ese objeto feed en la variable 'feed'
	    
	    MySQL.modificar("DELETE FROM feed"); // Antes de guardar los datos en la BBDD borro los que hubiese anteriormente
	    
	    System.out.println("Entradas registradas en MySQL desde el RSS:");
    	System.out.println("==========================================");
    	
	    for (FeedMessage message : feed.getMessages()) { // Recorro una a una las entradas del feed
	    	
	    	// En cada iteración almaceno temporalmente los valores de cada tupla
	    	String titulo = message.getTitle().replaceAll("'", "´");   
	    	String enlace = message.getLink().replaceAll("'", "´");
	    	String descripcion = message.getDescription().replaceAll("'", "´");
	    	
	    	// imprimo por consola los títulos para comprobar si se han grabado en MySQL
	    	System.out.println(titulo);
	    	
	    	// En cada iteración inserto los datos correspondientes en la BBDD de MySQL
	    	MySQL.modificar("INSERT INTO feed(titulo, enlace, descripcion) "
					+ "VALUES "
					+ "('" + titulo + "', '" + enlace + "', '" + descripcion + "')");
	    }
	    
	    //Almaceno los valores de todos los nodos recogidos en la BBDD a través del método anterior:
	    nodos = MySQL.cargar();
	    
	    //Creo el Archivo XML a partir de los nodos que he almacenado:
	    XMLGenerator.generate("rssfeeds", nodos.get(0), nodos.get(1), nodos.get(2));
	    
	}
}