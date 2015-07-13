
public class MainEmail {

	public static void main(String[] args) {
	
		//TESTEO
		
		//Email correo1 = new Email();
		//correo1.enviarEmail(); Test del error en proceso de ejecución
		
		Email correo2 = new Email("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor"
				+ "\nincididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco"
				+ "\nlaboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate"
				+ "\nvelit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt"
				+ "\nin culpa qui officia deserunt mollit anim id est laborum.", "alguien@gmail.com", "pepe@pepe.pe");
		correo2.enviarEmail();
		
		System.out.println("\n\n*************************************************************************************************");
		
		Email correo3 = new Email("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor"
				+ "\nincididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco"
				+ "\nlaboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate"
				+ "\nvelit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt"
				+ "\nin culpa qui officia deserunt mollit anim id est laborum.", 
				"alguien@gmail.com", "pepe@pepe.pe", "otrapersona@ueah.es", "quevieneel@numeroconrima.ea", "ultimo@si.es");
		correo3.setAsunto("Prueba2");
		correo3.setDestinatariosCC("otrocorreo@hotmail.es", "yotromás@quesi.ou");
		correo3.enviarEmail();
		
	}
	
}
