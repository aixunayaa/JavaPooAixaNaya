package eje_06;

public class Test {

	public static void main(String[] args) {

		Empresa ortFlix = new Empresa("ORTFlix");
		System.out.println("Alta Cliente: " + ortFlix.darDeAlta("111111111", TipoServicio.STANDARD, "Jose"));
		System.out.println("Alta Cliente: " + ortFlix.darDeAlta("111111111", TipoServicio.STANDARD, "Jose"));
		ortFlix.publicarPelicula(new Pelicula("El club de la pelea", "01-05-1990", TipoServicio.STANDARD));
		System.out.println("Ver Pelicula: " + ortFlix.verPelicula("111111111", "El club de la pelea"));
		System.out.println("Baja Cliente: " + ortFlix.darDeBaja("222222222"));
		System.out.println("Baja Cliente: " + ortFlix.darDeBaja("111111111"));
		
	}

}