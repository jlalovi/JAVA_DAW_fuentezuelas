// ecuacion de segundo grado
// Error de compilación: 'd', 'x1' y 'x2' tienen que ser de tipo double.
// Error de compilación: 'b' no está inicializado.
// Error lógico/en tiempo de ejecución. Si a=0, la solución no es real.

public class debug08 { public static void main (String args[]){ double a=1,b=-3,c=2; double x1,x2, d; d=((b*b)-4*a*c); if(d<0) System.out.println("No existen soluciones reales"); else{ x1=(-b+Math.pow((Math.pow(b,2)-4*a*c),(1/2)))/2*a; x2=(-b-Math.pow((Math.pow(b,2)-4*a*c),(1/2)))/2*a; System.out.println("Solución 1: " + x1); System.out.println("Solucion 2: " + x2); } } }