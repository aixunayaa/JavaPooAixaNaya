package eje_05;

public class Ejemplar {

	private Libro libro;
	private Fecha fecha;
	private Estado estado;
	private String identificador;
	
	public Ejemplar(Libro libro, String identificador) {
		this.setEstado(Estado.BIBLIOTECA);// le damos valor incial
		this.setIdentificador(identificador);
		this.setLibro(libro);
		this.libro.incremarCantEjemplares();

	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Libro getLibro() {
		return libro;
	}

	public String getIdentificador() {
		return identificador;
	}

	private void setLibro(Libro libro) {
		this.libro = libro;
	}

	private void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	
	
}
