package eje_04;

import java.util.ArrayList;

public class Perchero {

	private static final int TOPE_COLLARES = 3;
	private ArrayList<Collar> collares;
	
	public Perchero() {
		collares = new ArrayList<Collar>();
	}

	public Collar dameCollar(String nombre) {
		Collar collar = buscarCollar(nombre);
		if(collar != null) {
			collares.remove(collar);
		}
		return collar;
	}

	private Collar buscarCollar(String nombre) {
		Collar elementoAdevolver = null;
		int pos = 0;
		Collar elementoActual;
		int cantidadElementos = this.collares.size();
		while((pos < cantidadElementos) && (elementoAdevolver == null)) {
			elementoActual = collares.get(pos);
			if(elementoActual.getChapita().equals(nombre)) {
				elementoAdevolver = elementoActual;
			}
			pos++;
		}
		return elementoAdevolver;
	}

	public boolean colgarCollar(Collar collar) {
		boolean resultado = false;
		if(collar != null && collares.size() < TOPE_COLLARES) {
			collares.add(collar);
			resultado = true;
		}
		return resultado;
	}
	
}
