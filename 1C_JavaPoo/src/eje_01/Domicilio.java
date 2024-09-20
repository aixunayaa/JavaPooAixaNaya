package eje_01;


public class Domicilio {
	private String calle;
	private int nro;
	private String barrio;

	public Domicilio(String calle, int nro, String barrio) {
		this.calle = calle;
		this.nro = nro;
		this.barrio = barrio;
	}

	@Override
	public String toString() {
		return "Domicilio [calle=" + calle + ", nro=" + nro + ", barrio=" + barrio + "]";
	}
}
