package eje_10;

public class Candidato {
	private String nombre;
	private String email;

	public Candidato(String nombre, String email) {
		this.nombre = nombre;
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Candidato [nombre=" + nombre + ", email=" + email + "]";
	}

}