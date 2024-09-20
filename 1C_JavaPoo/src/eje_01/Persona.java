package eje_01;

public class Persona {
	private String dni;
	private String apellido;
	private String nombre;
	private Domicilio domicilio;

	public Persona(String dni, String nombre, String apellido, Domicilio domicilio) {
		setDni(dni);
		setNombre(nombre);
		setApellido(apellido);
		setDomicilio(domicilio);
	}

	public Persona() {
		// TODO Auto-generated constructor stub
	}

	public String getApellido() {
		return apellido;
	}

	public String getDni() {
		return dni;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	private void setDni(String dni) {
		this.dni = dni;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", domicilio=" + domicilio
				+ "]";
	}


	/*
	 * Método público eliminarTodosElementosAMano() que no recibe parámetros y
	 * elimina todos los elementos de la lista (sin utilizar el método clear).
	 */
	public void eliminarTodosElementosAMano() {

	}

}
