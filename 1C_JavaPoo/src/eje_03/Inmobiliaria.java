package eje_03;

import java.util.ArrayList;

public class Inmobiliaria {
	private ArrayList<Barrio> barrios;

	public Inmobiliaria() {
		barrios = new ArrayList<>();
	}

	private Barrio agregarBarrio(String nombreBarrio) {
		Barrio barrio;
		barrio = new Barrio(nombreBarrio);
		barrios.add(barrio);
		return barrio;
	}

	public void agregarPropiedad(TipoPropiedad tipo, String nombreBarrio, String domicilio, double precio) {
		if (barrioValido(nombreBarrio) && domicilioValido(domicilio)) {
			Barrio barrio = buscarBarrio(nombreBarrio);
			if (barrio == null) {
				barrio = agregarBarrio(nombreBarrio);
			}
			barrio.agregarPropiedad(tipo, domicilio, precio);
		} else {
			System.out.println("Hay un error en los datos de la propiedad (Barrio o Domicilio erróneos)");
		}

	}

	private boolean barrioValido(String nombreBarrio) {
		return !nombreBarrio.isEmpty();
	}

	public Propiedad borrarPropiedad(String domicilio) {
		Propiedad propiedad = null;
		if (domicilioValido(domicilio)) {
			int index = 0;
			while (index < barrios.size() && propiedad == null) {
				propiedad = barrios.get(index).removerPropiedad(domicilio);
				if (propiedad == null) {
					index++;
				}
			}
		} else {
			System.out.println("El domicilio indicado es invalido");
		}
		return propiedad;
	}

	private Barrio buscarBarrio(String nombreBarrio) {
		Barrio barrio = null;
		int index = 0;
		while (index < barrios.size() && barrio == null) {
			if (barrios.get(index).getNombre().equals(nombreBarrio)) {
				barrio = barrios.get(index);
			} else {
				index++;
			}
		}
		return barrio;
	}

	private void cambiarPropiedadDeBarrio(String domicilio, Barrio barrio) {
		Propiedad propiedad = borrarPropiedad(domicilio);
		if (propiedad != null) {
			barrio.agregarPropiedad(propiedad);
		} else {
			System.out.println("No se encontro ninguna propiedad en " + domicilio);
		}
	}

	public void cambiarPropiedadDeBarrio(String domicilio, String barrioDestino) {
		if (domicilioValido(domicilio) && barrioValido(barrioDestino)) {
			Barrio barrio = buscarBarrio(barrioDestino);
			if (barrio == null) {
				barrio = agregarBarrio(barrioDestino);
			}
			cambiarPropiedadDeBarrio(domicilio, barrio);
		} else {
			System.out.println("Hay un error en los datos de la propiedad (Barrio o Domicilio erroneos)");
		}
	}

	private boolean domicilioValido(String domicilio) {
		return !domicilio.isEmpty();
	}

	public void mostrarBarrioMaxProp() {
		ArrayList<Barrio> barriosMasProps = obtenerBarrioMaxProp();
		if (!barriosMasProps.isEmpty()) {
			System.out.println("* Barrio/s con mayor cantidad de propiedades (" + barriosMasProps.get(0).cantidadPropiedades() + "):");
			for (Barrio barrio : barriosMasProps) {
				System.out.println(barrio.getNombre());
			}
		} else {
			System.out.println("No hay datos cargados.");
		}
	}

	public void mostrarPropiedades() {
		System.out.println("* Propiedades registradas:");
		for (Barrio barrio : barrios) {
			barrio.mostrarPropiedades();
		}
	}

	private ArrayList<Barrio> obtenerBarrioMaxProp() {
		ArrayList<Barrio> maxBarrio = new ArrayList<>();
		int max = 0;
		int cant;
		for (Barrio barrio : barrios) {
			cant = barrio.cantidadPropiedades();
			if (cant >= max) {
				if (cant > max) {
					maxBarrio.clear();
					max = cant;
				}
				maxBarrio.add(barrio);
			}
		}
		return maxBarrio;
	}
}
