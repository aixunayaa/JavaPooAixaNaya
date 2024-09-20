package eje_11;

import java.util.ArrayList;

public class OrganizadoraDeCarreras {

	private ArrayList<Carrera> carreras;

	public OrganizadoraDeCarreras() {
		carreras = new ArrayList<>();
	}

	public void agregarCarrera(String fechaHora, Dificultad dificultad, int cantidadDeVueltas) {
		if (fechaHoraValida(fechaHora)) {
			Carrera carrera = buscarCarrera(fechaHora);
			if (carrera == null) {
				carreras.add(new Carrera(fechaHora, dificultad, cantidadDeVueltas));
			}
		}
	}

	private Carrera buscarCarrera(String fechaHora) {
		Carrera carrera = null;
		int index = 0;
		while (index < carreras.size() && carrera == null) {
			if (carreras.get(index).getFechaYHora().equals(fechaHora)) {
				carrera = carreras.get(index);
			} else {
				index++;
			}
		}
		return carrera;
	}

	public void computarVuelta(String fechaHoraCarrera, String nombrePiloto, double tiempoVuelta) {
		Carrera carrera = buscarCarrera(fechaHoraCarrera);
		if (carrera != null) {
			if (!carrera.registrarVuelta(nombrePiloto, tiempoVuelta)) {
				System.out.println("HUbo un error al registrar la vuelta de " + nombrePiloto);
			}
		} else {
			System.out.println("No hay carrera para la fecha " + fechaHoraCarrera);
		}
	}

	private boolean fechaHoraValida(String fh) {
		return fh != null && !fh.isEmpty();
	}

	public void mostrarMenorPromedioPorCarrera() {
		for (Carrera carrera : carreras) {
			System.out.println(carrera.getFechaYHora());
			carrera.mostrarMenorPromedio();
			System.out.println();
		}
	}

	public void mostrarPromediosPorDebajoDe(String fechaHora, double tiempoLimite) {
		Carrera carrera = buscarCarrera(fechaHora);
		if (carrera == null) {
			System.out.println("No encontre la carrera en " + fechaHora);
		} else {
			System.out.println("Pilotos con tiempo menor a " + tiempoLimite + " y al menos " + Piloto.VUELTAS_MINIMAS + " vueltas");
			for (Piloto piloto : carrera.buscarPilotosPorDebajoDe(tiempoLimite)) {
				System.out.println(piloto);
			}
		}
		
	}

	public ArrayList<ResumenCarrera> pilotosPorCarrera() {
		ArrayList<ResumenCarrera> resumenCarreras = new ArrayList<>();
		for (Carrera carrera : carreras) {
			resumenCarreras.add(carrera.getResumen());
		}
		return resumenCarreras;
	}

	public void registrarPiloto(String fechaHoraCarrera, String nombrePiloto, int dniPiloto) {
		Carrera carrera = buscarCarrera(fechaHoraCarrera);
		if (carrera != null) {
			if (!carrera.registrarPiloto(nombrePiloto, dniPiloto)) {
				System.out.println("El piloto ya está registrado");
			}
		} else {
			System.out.println("No hay carrera para la fecha " + fechaHoraCarrera);
		}
	}
}
