package eje_10;

public class Test {

	public static void main(String[] args) {
		Carrera instituto = new Carrera("Ort Argentina - Analistas de Sistemas");
		
		instituto.registrarAlumno("Sol Gomez", "solgomez@ort.edu.ar");
		instituto.registrarAlumno("Manuel Lopez", "manuellopez@ort.edu.ar");
		instituto.registrarAlumno("Roberto Perez", "robertoperez@ort.edu.ar");
		
		instituto.agregarABolsaDeTrabajo("Sol Gomez");
		instituto.agregarABolsaDeTrabajo("Manuel Lopez");
		instituto.agregarABolsaDeTrabajo("Roberto Perez");

		instituto.agregarABolsaDeTrabajo("Sol Gomez");
		instituto.agregarNotaFinal("Sol Gomez", "Matematicas", 9);
		instituto.agregarNotaFinal("Sol Gomez", "Fundamentos", 7);
		instituto.agregarNotaFinal("Sol Gomez", "THP", 8);
		instituto.agregarNotaFinal("Sol Gomez", "Ingles", 6);
		instituto.agregarNotaFinal("Sol Gomez", "Sistemas Operativos", 7);
		instituto.agregarNotaFinal("Manuel Lopez", "Sistemas Operativos", 9);
		instituto.agregarNotaFinal("Manuel Lopez", "Fundamentos", 10);
		instituto.agregarNotaFinal("Roberto Perez", "Matematicas", 4);
		instituto.agregarNotaFinal("Roberto Perez", "Fundamentos", 4);
		instituto.agregarNotaFinal("Roberto Perez", "THP", 4);
		instituto.agregarNotaFinal("Roberto Perez", "Ingles", 4);
		instituto.agregarNotaFinal("Roberto Perez", "Sistemas Operativos", 5);
		
		System.out.println("Candidatos con 7 o mas");
		for (Candidato candidato: instituto.obtenerCandidatos(7.0)) {
			System.out.println(candidato);
		}
		System.out.println("Candidatos con 4 o mas");
		for (Candidato candidato: instituto.obtenerCandidatos(4.0)) {
			System.out.println(candidato);
		}

	}

}