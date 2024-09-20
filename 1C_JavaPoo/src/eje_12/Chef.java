package eje_12;

import java.util.ArrayList;

import eje_05.Fecha;

public class Chef {
	private static final double TEMPERATURA_AMBIENTE = 18.00;

	private Almacen refrigerados;
	private Almacen noRefrigerados;

	public Chef() {
		refrigerados = new Almacen(true, -2);
		noRefrigerados = new Almacen(false, TEMPERATURA_AMBIENTE);
	}

	public void almacenarProducto(Producto producto, boolean esRefrigerado) {
		if (esRefrigerado) {
			refrigerados.almacenarProducto(producto);
		} else {
			noRefrigerados.almacenarProducto(producto);
		}
	}

	public ArrayList<Producto> extraerProductosVencidos(Fecha hoy) {
		ArrayList<Producto> productosVencidos = new ArrayList<Producto>();
		sumarListaProductos(refrigerados.extraerProductosVencidos(hoy), productosVencidos);
		sumarListaProductos(noRefrigerados.extraerProductosVencidos(hoy), productosVencidos);
		return productosVencidos;
	}

	private void sumarListaProductos(ArrayList<Producto> productosASumar, ArrayList<Producto> productosResultante) {
		for (Producto producto : productosASumar) {
			productosResultante.add(producto);
		}
	}

	public EstadoProducto chequearProducto(String nombreProducto, boolean esRefrigerado, Fecha hoy) {
		EstadoProducto resultado = EstadoProducto.NO_ENCONTRADO;
		Producto producto;
		if (esRefrigerado) {
			producto = refrigerados.buscarProducto(nombreProducto);
		} else {
			producto = noRefrigerados.buscarProducto(nombreProducto);
		}
		if (producto != null) {
			if (producto.estaVencido(hoy)) {
				resultado = EstadoProducto.PARA_DESCARTE;
			} else {
				resultado = EstadoProducto.FRESCO;
			}
		}
		return resultado;
	}

}
