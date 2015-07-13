
public class Consumidor {

	public static void main(String[] args) {
		
		//TESTEO DE CLASE 'EcuSeg'
		
		EcuSeg ecu1 = new EcuSeg(5, 6, 7);
		
		System.out.println(ecu1.getA());
		System.out.println(ecu1.getB());
		System.out.println(ecu1.getC());
		System.out.println(ecu1.solucionValida());
		double x[] = ecu1.resultado();
		System.out.println(x[0]);
		System.out.println(x[1]);
		
		ecu1.setABC(2, 5, 3);
		
		System.out.println(ecu1.getA());
		System.out.println(ecu1.getB());
		System.out.println(ecu1.getC());
		System.out.println(ecu1.solucionValida());
		double y[] = ecu1.resultado();
		System.out.println(y[0]);
		System.out.println(y[1]);

		EcuSeg ecu2 = new EcuSeg();
		System.out.println(ecu2.getA());
		System.out.println(ecu2.getB());
		System.out.println(ecu2.getC());
	}

}