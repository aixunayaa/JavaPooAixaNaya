package eje_05;

public class Autor {
	//los autores tienen nombre,
	//nacionalidad y fecha de nacimiento.
	private String nombre;
	private String nacionalidades;
	private Fecha fechaDeNacimiento;
	

	public Autor(String nombre, String nacionalidades, Fecha fechaDeNacimiento) {
		this.setFechaDeNacimiento(fechaDeNacimiento);
		this.setNacionalidades(nacionalidades);
		this.setNombre(nombre);
	}
	public String getNombre() {
		return nombre;
	}
	public String getNacionalidades() {
		return nacionalidades;
	}
	public Fecha getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	private void setNacionalidades(String nacionalidades) {
		this.nacionalidades = nacionalidades;
	}
	private void setFechaDeNacimiento(Fecha fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	
	
}
