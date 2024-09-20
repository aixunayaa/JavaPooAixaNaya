package eje_11;

import java.util.ArrayList;

public class Piloto {

	public static final int VUELTAS_MINIMAS = 10;
	private String nombre;
	private int dni;
	private ArrayList<Vuelta> vueltas;

	public Piloto(String nombre, int dni) {
		setNombre(nombre);
		setDni(dni);
		vueltas = new ArrayList<>();
	}

	public void agregarVuelta(double segundos) {
		vueltas.add(new Vuelta(segundos));
	}

	public double calcularVueltaPromedio() {
		double segundos = 0;
		for (Vuelta vuelta : vueltas) {
			segundos += vuelta.getSegundos();
		}
		return Matematica.obtenerPromedio(segundos, vueltas.size());
	}

	public boolean esElegible(double tiempoLimite) {
		return vueltas.size() >= VUELTAS_MINIMAS && calcularVueltaPromedio() <= tiempoLimite;
	}

	public int getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	private void setDni(int dni) {
		this.dni = dni;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String toString() {
		return "Piloto [nombre=" + nombre + ", dni=" + dni + ", vueltas=" + vueltas.size() + ", promedio de vuelta="
				+ calcularVueltaPromedio() + "]";
	}
}
