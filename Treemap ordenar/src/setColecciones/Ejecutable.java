package setColecciones;

public class Ejecutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ColeccionesSets miscolecciones=new ColeccionesSets();
		int i=1;
		
		System.out.println("Coleccion  con repeticiones desordenada");
		System.out.println(miscolecciones.getNumerosRepe());
//		for (Integer numero : miscolecciones.getNumerosRepe()) {
//			System.out.println(i+"-"+numero);
//			i++;
//		}
		
		i=1;
		System.out.println("Coleccion sin repeticiones desordenada");
		System.out.println(miscolecciones.getNumeros());
//		for (Integer numero : miscolecciones.getNumeros()) {
//			System.out.println(i+"-"+numero);
//			i++;
//		}
		
		i=1;
		System.out.println("Coleccion sin repeticiones ordenada");
		System.out.println(miscolecciones.getNumerosOrdenados());
//		for (Integer numero : miscolecciones.getNumerosOrdenados()) {
//			System.out.println(i+"-"+numero);
//			i++;
//		}
	}

}
