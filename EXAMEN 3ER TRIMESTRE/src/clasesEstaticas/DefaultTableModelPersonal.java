package clasesEstaticas;

import javax.swing.table.DefaultTableModel;

import discoteca.Cancion;
import discoteca.Disco;
import discoteca.Discoteca;

public class DefaultTableModelPersonal {

	public static DefaultTableModel cargarDiscos(Discoteca discoteca) {
		
	DefaultTableModel tableModel = new DefaultTableModel();
			
	//Modelo de la tabla
	String[] columnNames = {"Código","Titulo","Autor","Precio", "Duración Total"}; // Encabazo de las columnas
	tableModel.setColumnIdentifiers(columnNames);
	    
	Object fila[] = new Object[5]; // Cada fila tiene 4 campos (como columnas arriba)
	
	for (Disco elemento_disco : discoteca.getDiscos()) {
		fila[0] = elemento_disco.getCodigo();
		fila[1] = elemento_disco.getTitulo();
		fila[2] = elemento_disco.getAutor();
		fila[3] = elemento_disco.getPrecio();
		fila[4] = elemento_disco.calcularTiempoTotal();
		tableModel.addRow(fila);
	}	
		return tableModel;
	}
	
	public static DefaultTableModel cargarCanciones(Discoteca discoteca, String codigo) {
		
		DefaultTableModel tableModel = new DefaultTableModel();
		
		//Modelo de la tabla
		String[] columnNames = {"Disco","Pista","Título","Duración"}; // Encabazo de las columnas
		tableModel.setColumnIdentifiers(columnNames);
		    
		Object fila[] = new Object[4]; // Cada fila tiene 4 campos (como columnas arriba)
		
		// Disco en el que estoy interesado:
		Disco disco_canciones = null;
		for (Disco d: discoteca.getDiscos()) {
    		if (d.getCodigo().equals(codigo)) { // Añado canciones al disco del mismo código
    			disco_canciones=d; // Almaceno el disco en el que estoy interesado en esta variable temporal
    		}
		}
		for (Cancion elemento_cancion : disco_canciones.getCanciones()) {
			fila[0] = elemento_cancion.getCodigo_disco();
			fila[1] = elemento_cancion.getN_pista();
			fila[2] = elemento_cancion.getTitulo();
			fila[3] = elemento_cancion.getDuracion();
			tableModel.addRow(fila);
		}		
			return tableModel;
	}
	
}
