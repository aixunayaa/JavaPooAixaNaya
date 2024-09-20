package eje_04;

import java.util.ArrayList;

public class Duenio {

	private String nombre;
	private ArrayList<Perro> perros;
	private Perro perroPaseando;
	private Perchero perchero;
	private boolean paseando;
	
	public Duenio(String nombre) {
		setNombre(nombre);
		perros = new ArrayList<Perro>();
		perchero = new Perchero();
		paseando = false;
	}
	
	public boolean ponerCollarEnPerchero(Collar collar) {
		return this.perchero.colgarCollar(collar);
	}
	
	public void adoptar(Perro perro) {
		this.perros.add(perro);
	}
	
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public boolean salirDePaseo(String nombre) {
		boolean resultado = false;
		Perro perro = buscarPerro(nombre);
		if (perro != null)
			resultado = salirDePaseo(perro);
		return resultado;
	}
	
	public boolean salirDePaseo(Perro perro) {
		if(perro != null && perroPaseando == null) {
			Collar collar = perchero.dameCollar(perro.getNombre());
			if(collar != null) {
				perro.colocateElCollar(collar);
				paseando = true;
				perroPaseando = perro;
			}
		}
		return paseando;
	}

	private Perro buscarPerro(String nombre) {
		Perro elementoAdevolver = null;
		int pos = 0;
		Perro elementoActual;
		int cantidadElementos = this.perros.size();
		while((pos < cantidadElementos) && (elementoAdevolver == null)) {
			elementoActual = perros.get(pos);
			if(elementoActual.getNombre().equals(nombre)) {
				elementoAdevolver = elementoActual;
			}
			pos++;
		}
		return elementoAdevolver;
	}
	
	public boolean regresarPaseo() {
		boolean resultado = false;
		if(perroPaseando != null) {
			Collar collar = perroPaseando.sacateElCollar();
			boolean pudoColgarCollar = perchero.colgarCollar(collar);
			if(pudoColgarCollar) {
				perroPaseando = null;
				paseando = false;
				resultado = true;
			}
		}
		return resultado;
	}

	public boolean estaPaseando() {
		return paseando;
	}

}
