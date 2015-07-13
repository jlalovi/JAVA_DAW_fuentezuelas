package SorteoMultibombo;
import java.util.ArrayList;

import MetodosGenerales.Calculos;

/**
 * Clase Decimo
 * crea objetos que representan D�cimos con un determinado n�mero de cifras y reintegros. 
 * 
 * @author Javier Latorre - jlalovi@gmail.com
 * @version 19/02/2015
 * @since 09/01/2015
 *
 */
public class Decimo {
	
	//PROPIEDADES
	
		private int ncifras;           // N�mero de cifras que contendr� el D�cimo (sin contar reintegros).
		private int nreintegros;       // N�mero de reintegros que contendr� el D�cimo.
		
		private int cifra_inicio;      // Desde qu� cifra se quiere empezar a generar n�meros.
		private int cifra_fin;         // Hasta qu� cifra tope se quiere generar n�meros.
		private int reintegro_inicio;  // Desde qu� reintegro se quiere empezar a generar n�meros.
		private int reintegro_fin;     // Hasta qu� reintegro tope se quiere generar n�meros.
		
		private ArrayList<Integer> numero_completo; // N�mero completo almacenado en un ArrayList (cifras y reintegros).
	
	//CONSTRUCTORES
		
		/**
		 * Crea un objeto d�cimo vac�o. Al ser privado, s�lo lo puedo llamar desde esta clase.
		 */
		private Decimo() {
			this.numero_completo=new ArrayList<Integer>();
			this.ncifras=0;
			this.nreintegros=0;
			
			this.cifra_inicio=0;
			this.cifra_fin=9;
			this.reintegro_inicio=0;
			this.reintegro_fin=9;
		}
		
		/**
		 * Crea un objeto d�cimo que contendr� n cifras y n reintegros ambos entre el 0 y el 9.
		 */
		public Decimo(int ncifras, int nreintegros) {
			this();
			this.ncifras=ncifras;
			this.nreintegros=nreintegros;
		}
		
		/**
		 * Crea un objeto d�cimo que contendr� n cifras y n reintegros. El valor de las cifras ser� el especificado entre cifra_inicio y cifra_fin
		 * y el valor de los reintegros entre 0 y 9.
		 */
		public Decimo(int ncifras, int nreintegros, int cifra_inicio, int cifra_fin) {
			this(ncifras, nreintegros);
			this.cifra_inicio=cifra_inicio;
			this.cifra_fin=cifra_fin;
		}
		
		/**
		 * Crea un objeto d�cimo que contendr� n cifras y n reintegros. El valor de las cifras ser� el especificado entre cifra_inicio y cifra_fin
		 * y el valor de los reintegros ser� especificado en reintegro_inicio y reintegro_fin.
		 */
		public Decimo(int ncifras, int nreintegros, int cifra_inicio, int cifra_fin, int reintegro_inicio, int reintegro_fin) {
			this(ncifras, nreintegros, cifra_inicio, cifra_fin);
			this.reintegro_inicio=reintegro_inicio;
			this.reintegro_fin=reintegro_fin;		
		}

		/**
		 * Constructor de copia que crea un objeto d�cimo exactamente igual que el copiado.
		 */
		public Decimo(Decimo copia) {
			this.ncifras=copia.getNcifras();
			this.nreintegros=copia.getNreintegros();
			
			this.numero_completo=new ArrayList<Integer>();
			for (int i=0; i<copia.getNumero_completo().size(); i++) {
				this.numero_completo.add(copia.getNumero_completo().get(i));
			}
			
			this.cifra_inicio=copia.getCifra_inicio();
			this.cifra_fin=copia.getCifra_fin();
			this.reintegro_inicio=copia.getReintegro_inicio();
			this.reintegro_fin=copia.getReintegro_fin();
		}
		
	//M�TODOS
		
		//GETTERS Y SETTERS
		
		/**
		 * @return n�mero de cifras (sin contar los reintegros) que contiene el objeto d�cimo.
		 */
		public int getNcifras() {
			return ncifras;
		}
		/**
		 * Modifica el n�mero de cifras (sin contar los reintegros) que contiene el objeto d�cimo.
		 * @param ncifras
		 */
		public void setNcifras(int ncifras) {
			this.ncifras = ncifras;
		}
		/**
		 * @return n�mero de reintegros que contiene el objeto d�cimo.
		 */
		public int getNreintegros() {
			return nreintegros;
		}
		/**
		 * Modifica el n�mero de reintegros que contiene el objeto d�cimo.
		 * @param nreintegros
		 */
		public void setNreintegros(int nreintegros) {
			this.nreintegros = nreintegros;
		}
		/** 
		 * @return el valor de inicio de las cifras (sin contar los reintegros) que contiene el objeto d�cimo.
		 */
		public int getCifra_inicio() {
			return cifra_inicio;
		}
		/**
		 * Modifica el valor de inicio de las cifras (sin contar los reintegros) que contiene el objeto d�cimo.
		 * @param cifra_inicio
		 */
		public void setCifra_inicio(int cifra_inicio) {
			this.cifra_inicio = cifra_inicio;
		}
		/**
		 * @return el valor de finalizaci�n de las cifras (sin contar los reintegros) que contiene el objeto d�cimo.
		 */
		public int getCifra_fin() {
			return cifra_fin;
		}
		/**
		 * Moduifica el valor de finalizaci�n de las cifras (sin contar los reintegros) que contiene el objeto d�cimo.
		 * @param cifra_fin
		 */
		public void setCifra_fin(int cifra_fin) {
			this.cifra_fin = cifra_fin;
		}
		/**
		 * @return el valor de inicio de los reintegors que contiene el objeto d�cimo.
		 */
		public int getReintegro_inicio() {
			return reintegro_inicio;
		}
		/**
		 * Modifica el valor de inicio de los reintegors que contiene el objeto d�cimo.
		 * @param reintegro_inicio
		 */
		public void setReintegro_inicio(int reintegro_inicio) {
			this.reintegro_inicio = reintegro_inicio;
		}
		/**
		 * @return el valor de finalizaci�n de los reintegors que contiene el objeto d�cimo.
		 */
		public int getReintegro_fin() {
			return reintegro_fin;
		}
		/**
		 * Modifica el valor de finalizaci�n de los reintegors que contiene el objeto d�cimo.
		 * @param reintegro_fin
		 */
		public void setReintegro_fin(int reintegro_fin) {
			this.reintegro_fin = reintegro_fin;
		}		
		/**
		 * @return el valor de las cifras y reintegros, en ese orden, del objeto d�cimo.
		 */
		public ArrayList<Integer> getNumero_completo() {
			return numero_completo;
		}
		/**
		 * Modifica el valor de las cifras y reintegros, en ese orden, del objeto d�cimo.
		 * @param numero_completo
		 */
		public void setNumero_completo(ArrayList<Integer> numero_completo) {
			this.numero_completo = numero_completo;
		}
		
		//M�TODOS P�BLICOS (no getters o setters).
		
		/**
		 * Rellena aleatoriamente el objeto d�cimo, atendiendo a sus propiedades 'ncifras', 'nreintegros', 'cifra_inicio', 'cifra_fin', 
		 * 'reintegro_inicio' y 'reintegro_fin'. 
		 */
		public void aleatorio() {
			this.numero_completo.clear(); // En caso de que el d�cimo tuviese alg�n valor anteriormente, me aseguro de eliminarlos antes.
			int numero_aleatorio;
			for (int i=0; i<ncifras; i++) {
				numero_aleatorio=Calculos.numAleatorio(cifra_inicio, cifra_fin);
				numero_completo.add(numero_aleatorio);
			}
			for (int i=0; i<nreintegros; i++) {
				numero_aleatorio=Calculos.numAleatorio(reintegro_inicio, reintegro_fin);
				numero_completo.add(numero_aleatorio);
			}
		}
		
		/**
		 * Rellena manualmente el objeto d�cimo a partir de un vector de enteros introducido en la lista de par�metros.
		 * Al utilizar este m�todo se tendr� que tener en cuenta las propiedades del d�cimo ('ncifras', 'nreintegros', 'cifra_inicio', 'cifra_fin', 
		 * 'reintegro_inicio' y 'reintegro_fin'), para que los valores introducidos sean coherentes y para poder aplicar otros m�todos
		 * adecuadamente a este objeto d�cimo.
		 * @param decimoRellenado (con los valores ordenados, siendo en primer lugar las cifras y despu�s los reintegros).
		 */
		public void rellenar(int ... decimoRellenado) {
			this.numero_completo.clear(); // En caso de que el d�cimo tuviese alg�n valor anteriormente, me aseguro de eliminarlos antes.
			for (int i=0; i<decimoRellenado.length; i++) {
				numero_completo.add(decimoRellenado[i]);
			}
		}
		
		/**
		 * Comprueba si el objeto d�cimo es igual que el objeto d�cimo que se est� comparando.
		 * Se comparan s�lo si son iguales las propiedades 'ncifras', 'nreintegros' y 'numero_completo'.
		 * @param decimo
		 * @return 'true' si son iguales y 'false' si no lo son.
		 */
		public boolean equals(Decimo decimo) {
			boolean esIgual = true;
				if (this.ncifras!=decimo.getNcifras() || this.nreintegros!=decimo.getNreintegros())
					esIgual=false;
				for (int i=0; i<this.numero_completo.size() && esIgual==true; i++) {
					if (!this.numero_completo.get(i).equals(decimo.getNumero_completo().get(i)))
						esIgual=false;
				}
			return esIgual;
		}
		
		/**
		 * Se comprueba si las cifras de un objeto d�cimo son iguales a las de otro objeto d�cimo.
		 * Se comparan s�lo si son iguales las propiedades 'ncifras' y 'numero_completo' (l�s valores correspondientes a 'ncifras').
		 * @param decimo
		 * @return 'true' si son iguales y 'false' si no lo son.
		 */
		public boolean equalsNumero(Decimo decimo) {
			boolean esIgual = true;
				if (this.ncifras!=decimo.getNcifras())
					esIgual=false;
				for (int i=0; i<this.numero_completo.size()-this.nreintegros && esIgual==true; i++) {
					if (!this.numero_completo.get(i).equals(decimo.getNumero_completo().get(i)))
						esIgual=false;
				}
			return esIgual;
		}
		
		/**
		 * Se comprueba si los reintegros de un objeto d�cimo son iguales a las de otro objeto d�cimo.
		 * Se comparan s�lo si son iguales las propiedades 'nreintegros' y 'numero_completo' (l�s valores correspondientes a 'nreintegros').
		 * @param decimo
		 * @return 'true' si son iguales y 'false' si no lo son.
		 */
		public boolean equalsReintegro(Decimo decimo) {
			boolean esIgual = true;
				if (this.nreintegros!=decimo.getNreintegros())
					esIgual=false;
				for (int i=ncifras, j=decimo.getNcifras(); i<this.numero_completo.size() && j<decimo.getNumero_completo().size(); i++, j++) {
					if (!this.numero_completo.get(i).equals(decimo.getNumero_completo().get(j)))
						esIgual=false;
				}
			return esIgual;
		}
		
		@Override
		/**
		 * @return una cadena con el n�mero completo del objeto d�cimo con el siguiente formato: "[Numero: x x x ... n Reintegro/s: x x ... n]"
		 */		
		public String toString() {
			String resultado;
			resultado = "[N�mero: ";
			for (int i=0; i<ncifras; i++) {
				if(i<ncifras-1)
					resultado+= this.numero_completo.get(i) + " ";
				else {
					if (nreintegros==0)
						resultado+= this.numero_completo.get(i) + "]";
					else
						resultado+= this.numero_completo.get(i) + " ";
				}
			}
			if (nreintegros>0) {
				if (nreintegros==1)
					resultado+= " Reintegro: ";
				else
					resultado+= " Reintegros: ";
				
				for(int i=ncifras; i<numero_completo.size(); i++) {
					if(i<numero_completo.size()-1)
						resultado+= this.numero_completo.get(i) + " ";	
					else
						resultado+= this.numero_completo.get(i) + "]";
				}
			}
			return resultado;
		}
		
		
	
}
