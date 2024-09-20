package eje_09;

import java.util.ArrayList;

public class Receta {
	private int codigo;
	private String nombre;
	private ArrayList<Ingrediente> ingredientes;

	public Receta(int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
		ingredientes = new ArrayList<>();
	}

	public int getCodigo() {
		return codigo;
	}

	public void agregarIngrediente(String producto, int cantidad, boolean esRefrigerado) {
		ingredientes.add(new Ingrediente(producto, cantidad, esRefrigerado));
	}

	public void mostrar() {
		for (Ingrediente ingrediente : ingredientes) {
			System.out.println(ingrediente);
		}
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	@Override
	public String toString() {
		return "Receta [codigo=" + codigo + ", nombre=" + nombre + "]";
	}

}
