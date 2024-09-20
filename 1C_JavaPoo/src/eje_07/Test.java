package eje_07;

public class Test {

	public static void main(String[] args) {

		Aplicacion aplicacion;
		aplicacion = new Aplicacion();

		aplicacion.listarUsuarios();

		System.out.println("Alta de canciones");
		System.out.println(aplicacion.altaCancion("Dani California", "Red Hot Chilli Pepers", "ROCK"));
		System.out.println(aplicacion.altaCancion("Goteo", "Duki", "TRAP"));
		System.out.println(aplicacion.altaCancion("Snow", "Red Hot Chilli Pepers", "ROCK"));

		System.out.println("Cancion repetida");
		System.out.println(aplicacion.altaCancion("Dani California", "Red Hot Chilli Pepers", "TRAP"));

		System.out.println("Alta de usuarios");
		System.out.println(aplicacion.altaUsuario("elusuario@gmail.com", "Elu", 20, Categoria.ESTANDAR));
		System.out.println(aplicacion.altaUsuario("markzucker@outlook.com", "Zucker", 35, Categoria.PREMIUM));
		System.out.println(aplicacion.altaUsuario("mediavilla@live.com.ar", "Mediavilla", 50, Categoria.GRATUITO));

		System.out.println("Usuario repetido");
		System.out.println(aplicacion.altaUsuario("markzucker@outlook.com", "Zucker", 35, Categoria.ESTANDAR));

		aplicacion.listarUsuarios();

		System.out.println("Mediavilla escucha Snow y Dani California");
		System.out.println(aplicacion.escucharCancion("mediavilla@live.com.ar", "Snow", "Red Hot Chilli Pepers"));
		System.out.println(
				aplicacion.escucharCancion("mediavilla@live.com.ar", "Dani California", "Red Hot Chilli Pepers"));

		System.out.println("Zucker escucha Seminare");
		System.out.println(aplicacion.escucharCancion("markzucker@outlook.com", "Seminare", "Charly"));

		System.out.println("Anonymous escucha Goteo");
		System.out.println(aplicacion.escucharCancion("anonymous@anonymous.com", "Goteo", "Duki"));

		System.out.println("Lista de canciones escuchadas por Mediavilla");
		System.out.println(aplicacion.listarCancionesPorUsuario("mediavilla@live.com.ar"));

		System.out.println("Lista de canciones escuchadas por Anonymous");
		System.out.println(aplicacion.listarCancionesPorUsuario("anonymous@anonymous.com"));

	}

}
