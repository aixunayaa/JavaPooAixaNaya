package eje_09;

import java.util.ArrayList;
import eje_05.Fecha;


public class Deposito {
	private String descripcion;
	private ArrayList<Producto> productos;
	private boolean refrigerado;
	private Fecha hoy;

	public Deposito(String descripcion, boolean refrigerado, Fecha hoy) {
		setDescripcion(descripcion);
		this.refrigerado = refrigerado;
		this.setHoy(hoy);
		productos = new ArrayList<>();
	}

	public void agregar(String nombre, int cantidad, Fecha fechaVencimiento) {
		productos.add(new Producto(nombre, cantidad, fechaVencimiento));
	}

	public String getDescripcion() {
		return descripcion;
	}

	public boolean isRefrigerado() {
		return refrigerado;
	}

	public void mostrar() {
		System.out.println("Productos en " + descripcion + "\n");
		for (Producto producto : productos) {
			System.out.println(producto);
		}
	}

	public void setDescripcion(String descripcion) {
		if (descripcion == null || descripcion.isEmpty())
			descripcion = "deposito";
		this.descripcion = descripcion;
	}

	public Ingrediente obtenerFaltante(String nombre, int cantidadRequerida) {
		// Recorre la coleccion buscando en todo el stock hasta recorrerlo
		// completo o verificar que la cantidad deseada alcanza.
		int pos = 0;
		Producto producto;
		// solo se crea si hace falta
		Ingrediente ingrediente = null;
		while (pos < productos.size() && cantidadRequerida > 0) {
			producto = productos.get(pos);
			if (producto.getNombre().equals(nombre) && producto.estaVencido(hoy)) {
				cantidadRequerida -= producto.getCantidad();
			}
			pos++;
		}
		// Si hay faltante creo el requerido
		if (cantidadRequerida > 0)
			ingrediente = new Ingrediente(nombre, cantidadRequerida, refrigerado);
		// devuelvo el ingrediente (si hace falta) o null
		return ingrediente;
	}

	private void setHoy(Fecha hoy) {
		this.hoy = hoy;
	}

}
