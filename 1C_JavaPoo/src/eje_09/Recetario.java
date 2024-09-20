package eje_09;

import java.util.ArrayList;

public class Recetario {
	private ArrayList<Receta> recetas;

	public Recetario() {
		recetas = new ArrayList<>();
	}

	public void agregarReceta(int codigo, String nombre) {
		recetas.add(new Receta(codigo, nombre));
	}

	private Receta buscarReceta(int codigo) {
		Receta receta = null;
		int index = 0;
		while (receta == null && index < recetas.size()) {
			if (recetas.get(index).getCodigo() == codigo) {
				receta = recetas.get(index);
			} else {
				index++;
			}
		}
		return receta;
	}

	private Receta buscarReceta(String nombre) {
		Receta receta = null;
		int index = 0;
		while (receta == null && index < recetas.size()) {
			if (recetas.get(index).getNombre().equals(nombre)) {
				receta = recetas.get(index);
			} else {
				index++;
			}
		}
		return receta;
	}

	public void agregarIngredienteAReceta(int codigo, int cantidad, boolean esRefrigerado, String producto) {
		Receta receta = buscarReceta(codigo);
		if (receta != null) {
			receta.agregarIngrediente(producto, cantidad, esRefrigerado);
		}
	}

	public void mostrar() {
		for (Receta receta : recetas) {
			System.out.println(receta);
			receta.mostrar();
		}
	}

	public ArrayList<Ingrediente> prepararListadoAComprar(String nombreRecetaACocinar, Deposito deposito,
			int cantidadPorciones) {
		ArrayList<Ingrediente> ingredientes = new ArrayList<>();
		Receta receta = buscarReceta(nombreRecetaACocinar);
		if (receta != null) {
			obtenerIngredientesFaltantes(receta, deposito, cantidadPorciones, ingredientes);
		}
		return ingredientes;
	}

	private void obtenerIngredientesFaltantes(Receta receta, Deposito deposito, int cantidadPorciones,
			ArrayList<Ingrediente> ingredientes) {
		Ingrediente ingredienteFaltante;
		for (Ingrediente ingrediente : receta.getIngredientes()) {
			if (ingrediente.isRefrigerado() == deposito.isRefrigerado()) {
				ingredienteFaltante = deposito.obtenerFaltante(ingrediente.getProducto(), ingrediente.getCantidad() * cantidadPorciones);
				if (ingredienteFaltante != null) {
					ingredientes.add(ingredienteFaltante);
				}
			}
		}
	}

	public ArrayList<Receta> recetasPosiblesAPreparar(Deposito heladera, Deposito alacena, int cantidadPorciones) {
		ArrayList<Receta> recetasPosibles = new ArrayList<>();
		ArrayList<Ingrediente> ingredientes = new ArrayList<>();
		for (Receta receta : recetas) {
			obtenerIngredientesFaltantes(receta, heladera, cantidadPorciones, ingredientes); 
			if (ingredientes.isEmpty()) {
				obtenerIngredientesFaltantes(receta, alacena, cantidadPorciones, ingredientes); 
				if (ingredientes.isEmpty()) {
					recetasPosibles.add(receta);
				} else {
					ingredientes.clear();
				}
			}
		}
		return recetasPosibles;
	}

}
