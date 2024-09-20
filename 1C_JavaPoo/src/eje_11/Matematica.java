package eje_11;

public class Matematica {

	public static double obtenerPromedio(double sumaTotal, int cantidad) {
		double promedio = 0;
		if (cantidad > 0) {
			promedio = sumaTotal / cantidad;
		}
		return promedio;
	}

}
