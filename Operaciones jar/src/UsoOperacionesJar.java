import matematicas.Operaciones;


public class UsoOperacionesJar {

	public static void main(String[] args) {
		
		Operaciones op=new Operaciones();
		System.out.println(op.suma(10.0,2.0));
		System.out.println(op.resta(10.0,2.0));
		System.out.println(op.multiplicacion(10.0,2.0));
		System.out.println(op.division(10.0,2.0));
		System.out.println(op.exponenciacion(10.0,2.0));

	}

}
