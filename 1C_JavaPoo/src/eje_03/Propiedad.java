package eje_03;

public class Propiedad {
	private TipoPropiedad tipo;
	private String domicilio;
	private double precio;

	public Propiedad(TipoPropiedad tipo, String domicilio, double precio) {
		this.tipo = tipo;
		setDomicilio(domicilio);
		setPrecio(precio);
	}

	public String getDomicilio() {
		return domicilio;
	}

	public double getPrecio() {
		return precio;
	}

	public TipoPropiedad getTipo() {
		return tipo;
	}

	private void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public void setPrecio(double precio) {
		// No se permite que el precio sea negativo.
		if (precio > 0)
			this.precio = precio;
	}

	@Override
	public String toString() {
		return "Propiedad [tipo=" + tipo + ", domicilio=" + domicilio + ", precio=" + precio + "]";
	}

}
