package eje_10;

import java.util.ArrayList;

public class Carrera {
	private static final int TOPE_CANDIDATOS = 20;
	private String nombre;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Alumno> bolsaDeTrabajo;

	public Carrera(String nombre) {
		setNombre(nombre);
		this.alumnos = new ArrayList<>();
		this.bolsaDeTrabajo = new ArrayList<>();
	}

	public void agregarABolsaDeTrabajo(String nombre) {
		Alumno alumno = buscarAlumno(alumnos, nombre);
		if (alumno != null) {
			Alumno postulante = buscarAlumno(bolsaDeTrabajo, nombre);
			if (postulante == null) {
				bolsaDeTrabajo.add(alumno);
			} else {
				System.out.println("El alumno ya se registro en la bolsa de trabajo");
			}
		} else {
			informaAlumnoInexistente();
		}
	}

	public void agregarNotaFinal(String nombreAlumno, String materia, int notaFinal) {
		Alumno alumno = buscarAlumno(alumnos, nombreAlumno);
		if (alumno != null) {
			if (alumno.agregarNotaFinal(materia, notaFinal)) {
				System.out.println("Nota agregada correctamente a " + nombreAlumno);
			} else {
				System.out.println("El alumno " + nombreAlumno + " ya tenia nota para " + materia);
			}
		} else {
			informaAlumnoInexistente();
		}
	}

	private Alumno buscarAlumno(ArrayList<Alumno> coleccion, String nombre) {
		Alumno alumno = null;
		int index = 0;
		while (index < coleccion.size() && alumno == null) {
			if (nombre.equals(coleccion.get(index).getNombre())) {
				alumno = coleccion.get(index);
			} else {
				index++;
			}
		}
		return alumno;
	}

	private boolean emailValido(String email) {
		return email != null && email.contains("@");
	}

	public String getNombre() {
		return nombre;
	}

	private void informaAlumnoInexistente() {
		System.out.println("El alumno no existe");
	}

	private boolean nombreValido(String nombre) {
		return nombre != null && !nombre.isEmpty();
	}

	public ArrayList<Candidato> obtenerCandidatos(double notaMinimaAcordada) {
		ArrayList<Candidato> candidatos = new ArrayList<>();
		ResumenAlumno resumen;
		Alumno alumno;
		int index = 0;
		while (index < bolsaDeTrabajo.size() && candidatos.size() < TOPE_CANDIDATOS) {
			alumno = bolsaDeTrabajo.get(index);
			resumen = alumno.obtenerResumen();
			if (resumen.getNotasAprobadas() >= 5 && resumen.getPromedioNotas() >= notaMinimaAcordada) {
				candidatos.add(new Candidato(alumno.getNombre(), alumno.getEmail()));
			}
			index++;
		}
		return candidatos;
	}

	public void registrarAlumno(String nombre, String email) {
		if (nombreValido(nombre) && emailValido(email)) {
			Alumno alumno = buscarAlumno(alumnos, nombre);
			if (alumno == null) {
				alumnos.add(new Alumno(nombre, email));
			}
		} else {
			System.out.println("Datos invalidos");
		}

	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.isEmpty()) {
			nombre = "Carrera Sin Nombre";
		}
		this.nombre = nombre;
	}

}