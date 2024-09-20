package eje_05;

public class Libro {

	private Genero genero;
	private String titulo;
	private Editorial editorial;
	private int anio;
	private Autor autor;
	// es un extra!! 
	private static int cantEjemplares = 0;
	// Cada libro tiene un título, un
	//género (novela, teatro, poesía, ensayo u otros), editorial, año y autor
	
	
	public Genero getGenero() {
		return genero;
	}
	public Libro(Genero genero, String titulo, Editorial editorial, int anio, Autor autor) {
	
		this.genero = genero;
		this.titulo = titulo;
		this.editorial = editorial;
		this.anio = anio;
		this.autor = autor;
	}
	public void incremarCantEjemplares() {
		cantEjemplares++;
	}
	public String getTitulo() {
		return titulo;
	}
	public Editorial getEditorial() {
		return editorial;
	}
	public int getAnio() {
		return anio;
	}
	public Autor getAutor() {
		return autor;
	}
	
	
}
