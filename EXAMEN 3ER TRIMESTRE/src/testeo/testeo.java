package testeo;

import clasesEstaticas.BBDD_SQL;
import discoteca.Disco;
import discoteca.Discoteca;

public class testeo {

	public static void main(String[] args) {
		
		//BBDD Y COLECCIÓN DE OBJETOS
		
		Discoteca discoteca = new Discoteca();
		
		BBDD_SQL.cargarDiscos(discoteca);
		BBDD_SQL.cargarCanciones(discoteca);
		
		
		System.out.println(discoteca);
		System.out.println(discoteca.getDiscos().get(1).getCanciones()); // Prueba canciones primer disco
		
		System.out.println(discoteca.getDiscos().get(1).calcularTiempoTotal()); // Prueba método de calcular tiempo total
		

	}

}
