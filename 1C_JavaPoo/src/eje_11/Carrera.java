package eje_11;

import java.util.ArrayList;

public class Carrera {

	private String fechaYHora;
	private Dificultad dificultad;
	private int cantidadDeVueltas;
	private ArrayList<Piloto> pilotos;

	public Carrera(String fechaHora, Dificultad dificultad, int cantidadDeVueltas) {
		setFechaYHora(fechaHora);
		setCantidadDeVueltas(cantidadDeVueltas);
		this.dificultad = dificultad;
		pilotos = new ArrayList<>();
	}

	private Piloto buscarPiloto(String nombrePiloto) {
		Piloto piloto = null;
		int index = 0;
		while (index < pilotos.size() && piloto == null) {
			if (pilotos.get(index).getNombre().equals(nombrePiloto)) {
				piloto = pilotos.get(index);
			} else {
				index++;
			}
		}
		return piloto;
	}

	public ArrayList<Piloto> buscarPilotosPorDebajoDe(double tiempoEnSegundos) {
		ArrayList<Piloto> pilotosValidos = new ArrayList<>();
		for (Piloto piloto : pilotos) {
			if (piloto.esElegible(tiempoEnSegundos)) {
				pilotosValidos.add(piloto);
			}
		}
		return pilotosValidos;
	}

	public int getCantidadDeVueltas() {
		return cantidadDeVueltas;
	}

	public Dificultad getDificultad() {
		return dificultad;
	}

	public String getFechaYHora() {
		return fechaYHora;
	}

	public ResumenCarrera getResumen() {
		return new ResumenCarrera(fechaYHora, pilotos.size());
	}

	public void mostrarMenorPromedio() {
		double mejorTiempo = Double.MAX_VALUE;
		double vueltaPromedio;
		ArrayList<Piloto> masRapidos = new ArrayList<>();
		for (Piloto piloto : pilotos) {
			vueltaPromedio = piloto.calcularVueltaPromedio();
			if (vueltaPromedio != 0 && vueltaPromedio <= mejorTiempo) {
				if (vueltaPromedio < mejorTiempo) {
					masRapidos.clear();
					mejorTiempo = vueltaPromedio;
				}
				masRapidos.add(piloto);
			}
		}
		for (Piloto piloto : masRapidos) {
			System.out.println(piloto.getNombre() + " (" + piloto.getDni() + ")");
		}
	}


	public int pilotosPorCarrera() {
		return pilotos.size();
	}

	public boolean registrarPiloto(String nombrePiloto, int dniPiloto) {
		boolean ok = buscarPiloto(nombrePiloto) == null;
		if (ok) {
			pilotos.add(new Piloto(nombrePiloto, dniPiloto));
		}
		return ok;
	}

	public boolean registrarVuelta(String nombrePiloto, double tiempoVuelta) {
		Piloto piloto = buscarPiloto(nombrePiloto);
		if (piloto != null) {
			piloto.agregarVuelta(tiempoVuelta);
		}
		return piloto != null;
	}

	private void setCantidadDeVueltas(int cantidadDeVueltas) {
		if (cantidadDeVueltas < 1)
			cantidadDeVueltas = 1;
		this.cantidadDeVueltas = cantidadDeVueltas;
	}

	private void setFechaYHora(String fecha) {
		this.fechaYHora = fecha;
	}

}
