package generadorXML;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 * Clase que contiene un m�todo est�tico para generar archivos en formato XML.
 * 
 * Modificaci�n de: https://geekytheory.com/crear-fichero-xml-desde-java/
 *
 */
public class XMLGenerator {
	
	/**
	 * Crea un archivo XML cuyo nodo raiz ser� el que se indique en el constructor y sus nodos ser�n: <feed> y dentro
	 * de este <titulo>, <enlace> y <descripcion>.
	 * El n�mero de nodos <feed> y sus valores en <titulo>, <enlace> y <descripcion>, depender� de los ArrayList indicados
	 * en los par�metros del constructor
	 * 
	 * @param archivo : Nombre del archivo y su ruta, sin la extensi�n XML
	 * @param key : ArrayList<String> de las llaves o nodos del archivo XML
	 * @param value
	 * @throws Exception
	 */
	public static void generate(String archivo, ArrayList<String> titulo, ArrayList<String> enlace, ArrayList<String> descripcion) throws Exception{
		 
        if(titulo.isEmpty() || enlace.isEmpty() || descripcion.isEmpty() || 
           titulo.size()!=enlace.size() || titulo.size()!=descripcion.size() || descripcion.size()!=enlace.size() ){
            System.out.println("ERROR empty ArrayList");
            return;
        }else{
 
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, archivo, null);
            document.setXmlVersion("1.0");
 
            //Main Node
            Element raiz = document.getDocumentElement();
            
            // En cada iteraci�n creo un nodo feed con sus correspondientes hijos (t�tulo, enlace, descripci�n) y sus valores.
            for(int i=0; i<titulo.size();i++){
            	
                //Nodo raiz
                Element feedNode = document.createElement("feed"); 
                
                //Nodo t�tulo
                Element tituloNode = document.createElement("titulo"); 
                Text tituloValue = document.createTextNode(titulo.get(i));
                tituloNode.appendChild(tituloValue);
                
                //Nodo enlace
                Element enlaceNode = document.createElement("enlace"); 
                Text enlaceValue = document.createTextNode(enlace.get(i));                
                enlaceNode.appendChild(enlaceValue);
                
                //Nodo descripci�n
                Element descripcionNode = document.createElement("descripcion"); 
                Text descripcionValue = document.createTextNode(descripcion.get(i));                
                descripcionNode.appendChild(descripcionValue);
                
                //Indico que los nodos 't�tulo', 'enlace' y 'descripci�n' son hijos directos de 'feed'
                feedNode.appendChild(tituloNode);
                feedNode.appendChild(enlaceNode);
                feedNode.appendChild(descripcionNode);
                
                //Indico que el nodo 'feed' es hijo directo del nodo ra�z
                raiz.appendChild(feedNode); //pegamos el elemento a la raiz "Documento"
            }
            
            //Generate XML
            Source source = new DOMSource(document);
            
            //Indicamos donde lo queremos almacenar
            Result result = new StreamResult(new java.io.File(archivo+".xml")); //nombre del archivo
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            
            //Las siguientes dos l�neas son para que se autoindente el archivo XML y cu�ntos espacios de indentaci�n.
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            
            transformer.transform(source, result);
        }
    }
}
