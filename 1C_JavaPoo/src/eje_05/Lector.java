package eje_05;

import java.util.ArrayList;

public class Lector {
/*
 * De los lectores se sabe su dni, su nombre, su dirección y su teléfono. Cada
Lector puede tener hasta un máximo de 3 préstamos vigentes.
 * */
	private final int MAXIMO_PRESTAMOS = 3;
	private String dni;
	private String nombre;
	private String domicilio;
	private String telefono;
	private int diasDeMulta;
	private ArrayList<Ejemplar> prestamos;
	
		
	public Lector(String dni, String MAXIMO_PRESTAMOS, String domicilio, String telefono) {
		this.setDni(dni);
		this.setDomicilio(domicilio);
		this.setNombre(nombre);
		this.setTelefono(telefono);
		this.prestamos = new ArrayList <>();
		diasDeMulta = 0;

	}
	public void procesarLibrosMultas(Fecha unaFecha) {
		int cantDias;
		for(Ejemplar unEjemplar: prestamos) {
			//
			cantDias = unEjemplar.getFecha().diferenciaEnDias(unaFecha);
			if(cantDias >= 7) {
				this.diasDeMulta +=  cantDias *2;
			}
		}
	}
	public boolean tieneEspacioPrestamo () {
		return this.prestamos.size() < MAXIMO_PRESTAMOS;
	}
	
	public boolean tieneMulta(Fecha hoy ) {
		boolean tieneMultas = false;	
		int cantDias, pos = 0;
		Ejemplar unEjemplar;
		while(pos < this.prestamos.size() && tieneMultas == false) {
			//
			unEjemplar = this.prestamos.get(pos);
			cantDias = unEjemplar.getFecha().diferenciaEnDias(hoy);
			tieneMultas = (cantDias >= 7);
		}
		
		return tieneMultas;
		
	}
	
	
	public boolean agregarPrestamo(Ejemplar ejemplar) {
		boolean exitoso = false;
		if(this.prestamos.size() < MAXIMO_PRESTAMOS ) {
			this.prestamos.add(ejemplar);
			exitoso = true;
		}
		return exitoso;		
	}
	
	public boolean quitarPrestamo(Ejemplar ejemplar) {
		return this.prestamos.remove(ejemplar);
	}
	
	private void setDni(String dni) {
		this.dni = dni;
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	private void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	private void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDni() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public String getTelefono() {
		return telefono;
	}
	
	

	
}
