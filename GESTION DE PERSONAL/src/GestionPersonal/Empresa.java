package GestionPersonal;

import java.util.ArrayList;
import java.util.Collections;

import Empleados.Empleado;
import Empleados.Tecnico;

/**
 * Esta clase construye objetos 'Empresa' que contiene m�todos que permite a�adir empleados, borrar empleados, 
 * recuperar empleados borrados, buscar empleados con diferentes criterios y listarlos tambi�n con diferentes 
 * criterios.
 * 
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 13/04/2015
 * @since 19/02/2015
 */
public class Empresa {

	//PROPIEDADES
	
	private ArrayList<Empleado> empleados;          // Empleados guardados en la BBDD de la empresa.
	private ArrayList<Empleado> empleados_borrados; // Copia de seguridad de los empleados que han sido borrados.
	
	//CONSTRUCTORES
	
	/**
	 * Contruye un objeto 'Empresa' con un ArrayList de empleados y otro de empleados borrados vac�os.
	 */
	public Empresa(){
		this.empleados = new ArrayList<Empleado>();
		this.empleados_borrados = new ArrayList<Empleado>();
	}
	
	//M�TODOS
	
	//M�TODOS P�BLICOS
	
	/**
	 * @return ArrayList de los empleados almacenados en 'Empresa'
	 */
	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	/**
	 * @return ArrayList de los empleados borrados almacenados en una copia de seguridad en 'Empresa'
	 */
	public ArrayList<Empleado> getEmpleados_borrados() {
		return empleados_borrados;
	}

	/**
	 * A�ade un objeto 'Empleado' nuevo al ArrayList de empleados de 'Empresa'
	 * @param empleado_nuevo es un objeto Empleado
	 */
	public void a�adirEmpleado(Empleado empleado_nuevo){
		empleados.add(empleado_nuevo);
	}
	
	/**
	 * A�ade un ArrayList de objetos 'Empleado' al ArrayList de 'Empleados' de 'Empresa'
	 * @param empleados_nuevos
	 */
	public void a�adirEmpleados(ArrayList<Empleado> empleados_nuevos){
		for (Empleado e: empleados_nuevos) {
			empleados.add(e);
		}
	}
	
	/**
	 * A�ade un Array de objetos 'Empleado' al ArrayList de 'Empleados' de 'Empresa'
	 * @param empleado_nuevo
	 */
	public void a�adirEmpleados(Empleado ... empleado_nuevo){
		for (int i=0; i<empleado_nuevo.length; i++) {
			empleados.add(empleado_nuevo[i]);
		}
	}
	
	/**
	 * A�ade un objeto 'Empleado' al ArrayList de empleados_borrados de 'Empresa'
	 * @param empleado_borrado es un objeto Empleado
	 */
	public void a�adirEmpleadoBorrado(Empleado empleado_borrado){
		empleados_borrados.add(empleado_borrado);
	}
	
	/**
	 * Mueve un empleado por su 'DNI' del ArrayList de 'empleados' al ArrayList de 'empleados_borrados'
	 * del objeto 'Empresa'.
	 * @param dni del objeto 'Empleado' que se quiere mover a 'empleados_borrados'
	 * @return true: El 'Empleado' ha sido encontrado y movido - false: El 'Empleado' no ha sido encontrado
	 * en el ArrayList de 'empleados'
	 */
	public boolean borrarEmpleado(String dni){
		boolean borrado=false;
		for (int i=0; i<this.empleados.size() && borrado==false; i++) {
			if (this.empleados.get(i).getDNI().equalsIgnoreCase(dni)) {
				this.empleados_borrados.add(empleados.get(i));
				this.empleados.remove(i);
				borrado=true;
			}				
		}
		return borrado;
	}
	
	/**
	 * Mueve un empleado por su 'DNI' del ArrayList de 'empleados_borrados' al ArrayList de 'empleados'
	 * del objeto 'Empresa'.
	 * @param dni del objeto 'Empleado' que se quiere mover a 'empleados'
	 * @return true: El 'Empleado' ha sido encontrado y movido - false: El 'Empleado' no ha sido encontrado
	 * en el ArrayList de 'empleados_borrados'
	 */
	public boolean recuperarEmpleado(String dni){
		boolean recuperado=false;
		for (int i=0; i<this.empleados_borrados.size() && recuperado==false; i++) {
			if (this.empleados_borrados.get(i).getDNI().equalsIgnoreCase(dni)) {
				this.empleados.add(empleados_borrados.get(i));
				this.empleados_borrados.remove(i);
				recuperado=true;
			}				
		}
		return recuperado;
	}
	
	/**
	 * Busca un 'Empleado' por su DNI en el ArrayList de 'empleados' de 'Empresa'.
	 * @param dni
	 * @return Informaci�n completa sobre el empleado. En caso de no encontrarlo, se devuelve un
	 * mensaje indicando que no se ha encontrado dicho 'Empleado'.
	 */
	public String buscarEmpleadoDNI(String dni){
		String respuesta="No se ha encontrado el empleado con el dni '" + dni + "'.";
		for (Empleado e:this.empleados) {
			if (e.getDNI().equalsIgnoreCase(dni)) {
				respuesta=e.mostrarDatosCompletos();
			}				
		}
		return respuesta;
	}
	
	/**
	 * Busca un 'Empleado' por su DNI y si lo encuentra lo devuelve. En caso contrario, devuelve un null.
	 * @param dni
	 * @return Empleado con dicho DNI, en caso de no encontrarse, devuelve un null.
	 */
	public Empleado obtenerEmpleadoDNI(String dni){
		Empleado empleado = null;
		for (Empleado e:this.empleados) {
			if (e.getDNI().equalsIgnoreCase(dni)) {
				empleado = e;
				break;
			}				
		}
		return empleado;
	}
	
	/**
	 * Busca un empleado_borrado por su DNI y si lo encuentra lo devuelve. En caso contrario, devuelve un null.
	 * @param dni
	 * @return Empleado con dicho DNI, en caso de no encontrarse, devuelve un null.
	 */
	public Empleado obtenerEmpleadoBorradoDNI(String dni){
		Empleado empleado_borrado = null;
		for (Empleado e:this.empleados_borrados) {
			if (e.getDNI().equalsIgnoreCase(dni)) {
				empleado_borrado = e;
				break;
			}				
		}
		return empleado_borrado;
	}
	
	/**
	 * Comprueba si existe un 'Empleado' con el DNI introducido en el m�todo. 
	 * @param dni
	 * @return true: existe - false: no existe.
	 */
	public boolean existeEmpleadoDNI(String dni){
		boolean existe=false;
		for (Empleado e:this.empleados) {
			if (e.getDNI().equalsIgnoreCase(dni)) {
				existe=true;
			}
		}
		return existe;
	}
	
	/**
	 * Comprueba si existe un 'Empleado' BORRADO con el DNI introducido en el m�todo. 
	 * @param dni
	 * @return true: existe - false: no existe.
	 */
	public boolean existeEmpleadoBorradoDNI(String dni){
		boolean existe=false;
		for (Empleado e:this.empleados_borrados) {
			if (e.getDNI().equalsIgnoreCase(dni)) {
				existe=true;
			}
		}
		return existe;
	}
	
	/**
	 * Comprueba en qu� posici�n del ArrayList se encuentra el 'Empleado' con el DNI introducido en el m�todo. 
	 * @param dni
	 * @return la posici�n donde se encuentra el empleado. '-1' sino se encuentra en el ArrayList.
	 */
	public int posicionEmpleadoDNI(String dni){
		int posicion=-1;
		int contador=0;
		for (Empleado e:this.empleados) {
			if (e.getDNI().equalsIgnoreCase(dni)) {
				posicion=contador;
			}
			contador++;
		}
		return posicion;
	}
	
	/**
	 * Comprueba en qu� posici�n del ArrayList se encuentra el 'Empleado' BORRADO con el DNI introducido en el m�todo. 
	 * @param dni
	 * @return la posici�n donde se encuentra el empleado. '-1' sino se encuentra en el ArrayList.
	 */
	public int posicionEmpleadoBorradoDNI(String dni){
		int posicion=-1;
		int contador=0;
		for (Empleado e:this.empleados_borrados) {
			if (e.getDNI().equalsIgnoreCase(dni)) {
				posicion=contador;
			}
			contador++;
		}
		return posicion;
	}
	
	/**
	 * Comprueba si el empleado es T�cnico a trav�s de su DNI. Si el empleado no existe en la base de datos
	 * se devuelve un falso.
	 * 
	 * @param dni del empleado a buscar
	 * @return true: es t�cnico. false: no lo es, o no se encuentra en la base de datos de empleados
	 */
	public boolean esTecnico(String dni) {
		boolean esTecnico=false;
		if (this.existeEmpleadoDNI(dni)) { // Primero compruebo si el DNI existe
			Empleado e_temp = this.getEmpleados().get(this.posicionEmpleadoDNI(dni)); // Localizo el empleado
			esTecnico = esTecnico(e_temp); // Ver sobrecarga 'esTecnico'
		}
		return esTecnico;
		
	}
	
	/**
	 * Comprueba si el empleado es T�cnico. Si el empleado no existe en la base de datos
	 * se devuelve un falso.
	 * 
	 * @param empleado
	 * @return true: es t�cnico. false: no lo es, o no se encuentra en la base de datos de empleados
	 */
	public boolean esTecnico(Empleado empleado) {
		boolean esTecnico=false;
		if (empleado.getClass().getSuperclass().getSimpleName().equals("Tecnico")) // Compruebo si empleado es t�cnico
				esTecnico=true;
		return esTecnico;
		
	}
	
	/**
	 * A�ade una nueva capacidad al ArrayList de 'capacidades' de un Empleado que es 'Tecnico', busc�ndolo por su DNI.
	 * En caso de no existir o no ser un t�cnico no se har� nada.
	 * @param nueva_capacidad
	 */
	public void a�adirCapacidadTecnico(String dni, String capacidad) {
		if (this.esTecnico(dni)) { // Compruebo que el empleado es t�cnico para realizar cambios
			Tecnico tec_temp = (Tecnico) this.getEmpleados().get(this.posicionEmpleadoDNI(dni)); // Casting temporal
			tec_temp.a�adirCapacidad(capacidad); // Si es t�cnico agrego cambios, sino, no hago nada.
		}
	}
	
	/**
	 * A�ade una nueva capacidad al ArrayList de 'capacidades' de un Empleado que es 'Tecnico'.
	 * En caso de no existir o no ser un t�cnico no se har� nada.
	 * @param nueva_capacidad
	 */
	public void a�adirCapacidadTecnico(Empleado empleado, String capacidad) {
		if (this.esTecnico(empleado)) { // Compruebo que el empleado es t�cnico para realizar cambios
			Tecnico tec_temp = (Tecnico)empleado; // Casting temporal
			tec_temp.a�adirCapacidad(capacidad); // Si es t�cnico agrego cambios, sino, no hago nada.
		}
	}
	
	/**
	 * Comprueba si el empleado_borrado es T�cnico a trav�s de su DNI. Si el empleado no existe en la base de datos
	 * se devuelve un falso.
	 * 
	 * @param dni del empleado a buscar
	 * @return true: es t�cnico. false: no lo es, o no se encuentra en la base de datos de empleados
	 */
	public boolean esTecnicoBorrado(String dni) {
		boolean esTecnico=false;
		if (this.existeEmpleadoBorradoDNI(dni)) { // Primero compruebo si el DNI existe
			Empleado e_temp = this.getEmpleados_borrados().get(this.posicionEmpleadoBorradoDNI(dni)); // Localizo el empleado
			esTecnico = esTecnico(e_temp); // Ver sobrecarga 'esTecnico'
		}
		return esTecnico;
		
	}
	
	/**
	 * A�ade una nueva capacidad al ArrayList de 'capacidades' de un empleado_borrado que es 'Tecnico', busc�ndolo por su DNI.
	 * En caso de no existir o no ser un t�cnico no se har� nada.
	 * @param nueva_capacidad
	 */
	public void a�adirCapacidadTecnicoBorrado(String dni, String capacidad) {
		if (this.esTecnicoBorrado(dni)) { // Compruebo que el empleado_borrado es t�cnico para realizar cambios
			Tecnico tec_temp = (Tecnico) this.getEmpleados_borrados().get(this.posicionEmpleadoBorradoDNI(dni)); // Casting temporal
			tec_temp.a�adirCapacidad(capacidad); // Si es t�cnico agrego cambios, sino, no hago nada.
		}
	}
	
	/**
	 * Devuelve una cadena con los datos completos de los objetos 'Empleado' del ArrayList 'empleados'
	 * cuyos nombres completos coincidan con el 'fragmento_busqueda' introducido en el m�todo.
	 * @param fragmento_busqueda
	 * @return cadena con todos los 'Empleado' que cumplan el criterio de b�squeda.
	 */
	public String buscarEmpleados(String fragmento_busqueda){
		String respuesta="";
		String respuesta_si="Los empleados que coinciden con el fragmento de b�squeda: '" + fragmento_busqueda + "', son:\n";
		String respuesta_no="No se ha encontrado ning�n empleado con el fragmento de b�squeda '" + fragmento_busqueda + "'.\n";		
		boolean no_hay_coincidencias=true;		
		Collections.sort(this.empleados);  // Quiero que la lista me aparezca ordenada por nombre de empleado.		
		fragmento_busqueda=fragmento_busqueda.trim().toUpperCase();		
		for (Empleado e:this.empleados) {
			if (e.getApe1().toUpperCase().indexOf(fragmento_busqueda)!=-1 ||
				e.getApe2().toUpperCase().indexOf(fragmento_busqueda)!=-1 ||
				e.getNombre().toUpperCase().indexOf(fragmento_busqueda)!=-1) {
					respuesta_si+=e.mostrarDatosCompletos() + "\n";
					no_hay_coincidencias=false;
			}
		}
		if (no_hay_coincidencias)
			respuesta=respuesta_no;
		else
			respuesta=respuesta_si;
		return respuesta;
	}
	
	/**
	 * Devuelve un ArrayList de empleados cuto nombre y/o apellidos coincidan con el 'fragmento_busqueda' introducido en el m�todo.
	 * @param fragmento_busqueda
	 * @return ArrayList con todos los Empleados que cumplan el criterio de b�squeda.
	 */
	public ArrayList<Empleado> obtenerEmpleados(String fragmento_busqueda){
		ArrayList<Empleado> empleados = new ArrayList<Empleado>(); 		
		Collections.sort(this.empleados);  // Quiero que la lista me aparezca ordenada por nombre de empleado.		
		fragmento_busqueda=fragmento_busqueda.trim().toUpperCase();		
		for (Empleado e:this.empleados) {
			if (e.getApe1().toUpperCase().indexOf(fragmento_busqueda)!=-1 ||
				e.getApe2().toUpperCase().indexOf(fragmento_busqueda)!=-1 ||
				e.getNombre().toUpperCase().indexOf(fragmento_busqueda)!=-1) {
				empleados.add(e);
			}
		}
		return empleados;
	}

	/**
	 * @return cadena con los datos de cada uno de los empleados de la empresa ordenados alfab�ticamente.
	 */
	public String listarEmpleadosNombre() {
		String cadena_ordenada="";
		Collections.sort(this.empleados);
		for (Empleado e : this.empleados) {
			cadena_ordenada+=e.toString()+"\n";
		}
		return cadena_ordenada;
	}
	
	/**
	 * @return ArrayList con los datos de cada uno de los empleados de la empresa ordenados alfab�ticamente.
	 */
	public ArrayList<Empleado> arrayEmpleadosNombre() {
		ArrayList<Empleado> array_ordenado = new ArrayList<Empleado>();
		Collections.sort(this.empleados);
		for (Empleado e : this.empleados) {
			array_ordenado.add(e);
		}
		return array_ordenado;
	}
	
	/**
	 * @return cadena con los datos de cada uno de los empleados de la empresa ordenados por DNI.
	 */
	public String listarEmpleadosDNI() {
		String cadena_ordenada="";
		Collections.sort(this.empleados, new ComparaEmpleadoDNI());
		for (Empleado e : this.empleados) {
			cadena_ordenada+=e.toStringDNI()+"\n";
		}
		return cadena_ordenada;
	}
	
	/**
	 * @return ArrayList con los datos de cada uno de los empleados de la empresa ordenados por DNI.
	 */
	public ArrayList<Empleado> arrayEmpleadosDNI() {
		ArrayList<Empleado> array_ordenado = new ArrayList<Empleado>();
		Collections.sort(this.empleados, new ComparaEmpleadoDNI());
		for (Empleado e : this.empleados) {
			array_ordenado.add(e);
		}
		return array_ordenado;
	}
	
	/**
	 * @param mes de la n�mina de referencia
	 * @param a�o de la n�mina de referencia
	 * @return cadena con los datos de cada uno de los empleados de la empresa en orden decreciente
	 * de n�mina, y a igual n�mina, ordenados alfab�ticamente.
	 */
	public String listarEmpleadosNomina(int mes, int a�o) {
		String cadena_ordenada="";
		Collections.sort(this.empleados, new ComparaEmpleadoNomina(mes, a�o));
		for (Empleado e : this.empleados) {
			cadena_ordenada+=e.toStringNomina(mes,a�o)+"\n";
		}
		return cadena_ordenada;
	}
	
	/**
	 * @param mes de la n�mina de referencia
	 * @param a�o de la n�mina de referencia
	 * @return ArrayList<String> con los datos de cada uno de los empleados de la empresa en orden decreciente
	 * de n�mina, y a igual n�mina, ordenados alfab�ticamente.
	 */
	public ArrayList<Empleado> arrayEmpleadosNomina(int mes, int a�o) {
		ArrayList<Empleado> array_ordenado = new ArrayList<Empleado>();
		Collections.sort(this.empleados, new ComparaEmpleadoNomina(mes, a�o));
		for (Empleado e : this.empleados) {
			array_ordenado.add(e);
		}
		return array_ordenado;
	}
	
	/**
	 * @return cadena con los datos de cada uno de los empleados borrados de la empresa ordenados alfab�ticamente.
	 */
	public String listarEmpleadosBorradosNombre() {
		String cadena_ordenada="";
		Collections.sort(this.empleados_borrados);
		for (Empleado e : this.empleados_borrados) {
			cadena_ordenada+=e.toString()+"\n";
		}
		return cadena_ordenada;
	}
	
	/**
	 * @return ArrayList con los datos de cada uno de los empleados de la empresa ordenados alfab�ticamente.
	 */
	public ArrayList<Empleado> arrayEmpleadosBorradosNombre() {
		ArrayList<Empleado> array_ordenado = new ArrayList<Empleado>();
		Collections.sort(this.empleados_borrados);
		for (Empleado e : this.empleados_borrados) {
			array_ordenado.add(e);
		}
		return array_ordenado;
	}
	
	/**
	 * @return cadena con los datos de cada uno de los empleados borrados de la empresa ordenados por DNI.
	 */
	public String listarEmpleadosBorradosDNI() {
		String cadena_ordenada="";
		Collections.sort(this.empleados_borrados, new ComparaEmpleadoDNI());
		for (Empleado e : this.empleados_borrados) {
			cadena_ordenada+=e.toStringDNI()+"\n";
		}
		return cadena_ordenada;
	}

}