package eje_09;

import eje_05.Fecha;

public class Producto {
	private String nombre;
	private int cantidad;
	private Fecha fechaVencimiento;
	
	public Producto(String nombre, int cantidad, Fecha fechaVencimiento) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.fechaVencimiento = fechaVencimiento;
	}

	public int getCantidad() {
		return cantidad;
	}

	public Fecha getFechaVencimiento() {
		return fechaVencimiento;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", cantidad=" + cantidad + ", fechaVencimiento=" + fechaVencimiento + "]";
	}

	public boolean estaVencido(Fecha hoy) {
		return fechaVencimiento.diferenciaEnDias(hoy) < 0;
	}

}
