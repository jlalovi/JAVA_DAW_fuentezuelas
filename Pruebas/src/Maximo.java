import java.io.*;

public class Maximo {

	public static void main(String[] args) throws NumberFormatException, IOException {  //
		BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in)); //
		
		int x,y,z,max;																	//
		
		System.out.println("Introduce x,y,z");											//
		x=Integer.parseInt(entrada.readLine());											//
		y=Integer.parseInt(entrada.readLine());											//
		z=Integer.parseInt(entrada.readLine());											// 1
		
		if (x>y && x>z)																	// 2,3
			max=x;																		// 4
		else																			//
				if (z>y)																// 5
					max=z;																// 6
				else																	//
					max=y;																// 7
		System.out.println("El máximo es " + max);										// 8
	}																					// 9
}
