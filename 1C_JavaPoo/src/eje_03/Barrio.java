package eje_03;

import java.util.ArrayList;

public class Barrio {
	private String nombre;
	private ArrayList<Propiedad> propiedades;

	public Barrio(String nombre) {
		setNombre(nombre);
		propiedades = new ArrayList<>();
	}

	public void agregarPropiedad(Propiedad propiedad) {
		if (propiedad != null) {
			propiedades.add(propiedad);
		}
	}

	public void agregarPropiedad(TipoPropiedad tipo, String domicilio, double precio) {
		Propiedad propiedad = buscarPropiedad(domicilio);
		if (propiedad != null) {
			System.out.println("La propiedad " + propiedad + " ya existe en catalogo");
		} else {
			agregarPropiedad(new Propiedad(tipo, domicilio, precio));
		}
	}

	private Propiedad buscarPropiedad(String domicilio) {
		Propiedad propiedad = null;
		int index = 0;
		while (index < propiedades.size() && propiedad == null) {
			if (propiedades.get(index).getDomicilio().equals(domicilio)) {
				propiedad = propiedades.get(index);
			} else {
				index++;
			}
		}
		return propiedad;
	}

	public int cantidadPropiedades() {
		return propiedades.size();
	}

	public String getNombre() {
		return nombre;
	}

	private void mostrarPropiedad(Propiedad propiedad) {
		System.out.println(propiedad.getDomicilio() + " $" + propiedad.getPrecio());
	}

	public void mostrarPropiedades() {
		for (Propiedad propiedad : propiedades) {
			mostrarPropiedad(propiedad);
		}
	}

	public void mostrarPropiedades(TipoPropiedad tipoRequerido) {
		for (Propiedad propiedad : propiedades) {
			if (propiedad.getTipo() == tipoRequerido) {
				mostrarPropiedad(propiedad);
			}
		}
	}

	public Propiedad removerPropiedad(String domicilio) {
		Propiedad propiedad = buscarPropiedad(domicilio);
		if (propiedad != null) {
			propiedades.remove(propiedad);
		}
		return propiedad;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
}