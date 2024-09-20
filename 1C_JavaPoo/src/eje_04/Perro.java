package eje_04;

public class Perro {

	private String nombre;
	private Collar collar;
	private Duenio duenio;

	public Perro(String nombre) {
		setNombre(nombre);
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void colocateElCollar(Collar collar) {
		this.collar = collar;
		moverCola();
	}

	private void moverCola() {
		System.out.println(nombre + " mueve la cola!");
		;
	}

	public Collar sacateElCollar() {
		Collar collar = null;
		if (this.collar != null) {
			collar = this.collar;
			this.collar = null;
		}
		return collar;
	}

	public boolean pedirSalirAPasear() {
		boolean salgoAPasear = false;
		if (!duenio.estaPaseando())
			salgoAPasear = this.duenio.salirDePaseo(this);
		return salgoAPasear;
	}

}
