package calculadora;

public enum Operador {
	SUMA,
	RESTA,
	MULTIPLICACION,
	DIVISION,
	MODULO,
	REINICIAR, // Reinicio manual por parte del usuario o debido al operador de igualdad '='.
	RESETEAR,  // En el momento en que hay un error.
	NULL       // El valor por defecto. Sin operador en uso.
}