package eje_11;

public class Test {

	public static void main(String[] args) {
		OrganizadoraDeCarreras correcaminos = new OrganizadoraDeCarreras();
		
		correcaminos.agregarCarrera("2021-05-25 10:00", Dificultad.PRINCIPIANTE, 18);
		
		correcaminos.registrarPiloto("2021-05-25 10:00", "Perez, Manuel", 92157345);
		correcaminos.registrarPiloto("2021-05-25 10:00", "Gomez, Luna", 2457148);
		correcaminos.registrarPiloto("2021-05-25 10:00", "Lopez, Raul", 39458712);
		
		correcaminos.computarVuelta("2021-05-25 10:00", "Perez, Manuel", 58.12); 
		correcaminos.computarVuelta("2021-05-25 10:00", "Perez, Manuel", 60.01); 
		
		for (int i=0; i < 18; i++) {
			correcaminos.computarVuelta("2021-05-25 10:00", "Lopez, Raul", 55 + Math.random());
		}

		for (ResumenCarrera resumen : correcaminos.pilotosPorCarrera()) {
			System.out.println(resumen);
		}
		
		correcaminos.mostrarPromediosPorDebajoDe("2021-05-25 10:00", 58.0);
		
		correcaminos.mostrarMenorPromedioPorCarrera();
	}

}