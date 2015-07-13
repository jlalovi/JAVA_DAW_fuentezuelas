import java.util.Scanner;

public class Main {

	public static void main(String[] args) {		//
		Scanner entrada = new Scanner(System.in);	//
		System.out.println("Introduce a,b");		//
		int a=Integer.parseInt(entrada.nextLine());	//
		int b=Integer.parseInt(entrada.nextLine());	//
		entrada.close();							//
		System.out.println(calcula(a,b));			//		
	}												//
	public static boolean calcula(int a, int b) {	//
		int c=a+b;									//
		boolean aux=false;							// 1
		
		if(a==b) {									// 2
			do {									// 3
				a++;								//
			}while(a<15);							// 4
		}
		else {										//
			for (int i=0;i<a;i++) {					// 5 
				i*=a;								// 6
			}										//
		}
		while(a>b){									// 7
			while(c>2*a){							// 8
				aux=true;							// 9
				a++;								//
			}										//
			b++;									// 10
		}											//
		return aux;									// 11
	}
}
