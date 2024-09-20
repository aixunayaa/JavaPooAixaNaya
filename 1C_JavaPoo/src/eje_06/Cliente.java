package eje_06;

import java.util.ArrayList;

public class Cliente<Pelicula> {

	private String dni;
	private String nombre;
	private double saldo;
	private ArrayList<Pelicula> historial;
	private TipoServicio tipo;
	
	public Cliente(String dni, String nombre, TipoServicio tipo) {
		setDni(dni);
		setNombre(nombre);
		setSaldo(0);
		setTipo(tipo);
		this.historial = new ArrayList<Pelicula>();
	}
	
	public void agregarHistorial(Pelicula pelicula) {
		this.historial.add(pelicula);
	}
	
	public boolean esDeudor() {
		return this.getSaldo() > 0;
	}
	
	public String getDni() {
		return dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public TipoServicio getTipo() {
		return tipo;
	}

	private void setDni(String dni) {
		this.dni = dni;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	private void setTipo(TipoServicio tipo) {
		this.tipo = tipo;
	}
}
