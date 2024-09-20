package eje_12;

import java.util.ArrayList;

import eje_05.Fecha;

public class Test {

	public static void main(String[] args) {
		Fecha fecha = new Fecha(1, 7, 2022);
		Fecha hoy = new Fecha(25, 5, 2022);
		Fecha fechaVencida = new Fecha(1, 4, 2022);
		
		Chef chef = new Chef();
		chef.almacenarProducto(new Producto("Garbanzos", 365, fecha), false);
		chef.almacenarProducto(new Producto("Carne", 10, fecha), true);
		chef.almacenarProducto(new Producto("Tomate", 10, fecha), true);
		chef.almacenarProducto(new Producto("Harina", 365, fecha), false);
		chef.almacenarProducto(new Producto("Huevos", 10, fecha), false);
		chef.almacenarProducto(new Producto("Leche", 2, fechaVencida), true);
		chef.almacenarProducto(new Producto("Leche", 2, fecha), true);
		
		chequear(chef, "Garbanzos", false, hoy);
		chequear(chef, "Carne", true, hoy);
		chequear(chef, "Tomate", true, hoy);
		chequear(chef, "Harina", false, hoy);
		chequear(chef, "Huevos", false, hoy);
		chequear(chef, "Leche", true, hoy);

		ArrayList<Producto> productosVencidos = chef.extraerProductosVencidos(hoy);
		System.out.println("Cantidad de productos vencidos: " + productosVencidos.size());
		listarVencidos(productosVencidos);	
	}

	private static void listarVencidos(ArrayList<Producto> productosVencidos) {
		for (Producto producto : productosVencidos) {
			System.out.println(producto);
		}
		
	}

	private static void chequear(Chef chef, String producto, boolean refrigerado, Fecha hoy) {
		System.out.println("Chequeando " + producto);
		System.out.println(chef.chequearProducto(producto, refrigerado, hoy));
	}
}
