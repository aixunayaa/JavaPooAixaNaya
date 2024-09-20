package eje_06;
public class Pelicula {

	private String nombre;
	private String fecha;
	private TipoServicio tipo;
	
	public Pelicula(String nombre, String fecha, TipoServicio tipo) {
		setNombre(nombre);
		setFecha(fecha);
		setTipo(tipo);
	}

	public String getFecha() {
		return fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public TipoServicio getTipo() {
		return tipo;
	}

	private void setFecha(String fecha) {
		this.fecha = fecha;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private void setTipo(TipoServicio tipo) {
		this.tipo = tipo;
	}
	
}