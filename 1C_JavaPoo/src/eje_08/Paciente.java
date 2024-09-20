package eje_08;

public class Paciente {
	private int dni;
	private String apellido;
	private String nombre;
	private String telefono;

	/**
	 * Constructor de Paciente
	 * 
	 * @param dni
	 * @param apellido
	 * @param nombre
	 * @param telefono
	 */
	public Paciente(int dni, String apellido, String nombre, String telefono) {
		setDni(dni);
		setApellido(apellido);
		setNombre(nombre);
		setTelefono(telefono);
	}

	/**
	 * @return El apellido del paciente
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @return El dni del paciente
	 */
	public int getDni() {
		return dni;
	}

	/**
	 * @return El nombre del paciente
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return El telefono del paciente
	 */
	public String getTelefono() {
		return telefono;
	}

	public boolean mismoDni(int dni) {
		return this.dni == dni;
	}

	/**
	 * @param apellido
	 *            El apellido del paciente
	 */
	private void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @param dni
	 *            El dni del paciente
	 */
	private void setDni(int dni) {
		this.dni = dni;
	}

	/**
	 * @param nombre
	 *            El nombre del paciente
	 */
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param telefono
	 *            El telefono del paciente
	 */
	private void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Paciente [dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre + ", telefono=" + telefono
				+ "]";
	}

}