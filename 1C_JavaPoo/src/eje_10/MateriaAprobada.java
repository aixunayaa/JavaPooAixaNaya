package eje_10;

public class MateriaAprobada {
	private String nombreMateria;
	private int notaFinal;

	public MateriaAprobada(String nombreMateria, int notaFinal) {
		setNombreMateria(nombreMateria);
		setNotaFinal(notaFinal);
	}

	public String getNombreMateria() {
		return nombreMateria;
	}

	public int getNotaFinal() {
		return notaFinal;
	}

	private void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}

	private void setNotaFinal(int notaFinal) {
		if (notaFinal < 0)
			notaFinal = 0;
		else if (notaFinal > 10)
			notaFinal = 10;
		this.notaFinal = notaFinal;
	}

}
