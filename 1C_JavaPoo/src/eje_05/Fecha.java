package eje_05;

public class Fecha {

	// para usar en los calculos de conversion de fechas
	private static int JGREG = 15 + 31 * (10 + 12 * 1582);
	private static double HALFSECOND = 0.5;
	private int dia;
	private int mes;
	private int anio;

	public Fecha(Fecha otraFecha) {
		this(otraFecha.dia, otraFecha.mes, otraFecha.anio);
	}

	public Fecha(int dia, int mes, int anio) {
		setAnio(anio);
		setMes(mes);
		setDia(dia);
	}

	private boolean anioBisiesto(int anio) {
		return (anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0;
	}

	private int bisiesto(int anio) {
		int diaExtra = 0;
		if (anioBisiesto(anio))
			diaExtra = 1;
		return diaExtra;
	}

	public int diferenciaEnDias(Fecha otraFecha) {
		return (int) (aJuliano(this) - aJuliano(otraFecha));
	}

	public int enDias() {
		return (int) aJuliano(this);
	}

	public boolean esAnterior(Fecha otraFecha) {
		return fechaCompleta() < otraFecha.fechaCompleta();
	}

	private int fechaCompleta() {
		return (this.anio * 100 + this.mes) * 100 + this.dia;
	}

	private void setAnio(int anio) {
		this.anio = anio;
	}

	private void setDia(int dia) {
		int tope = topeMes();
		if (dia < 1) {
			this.dia = 1;
		} else if (dia > tope) {
			this.dia = tope;
		} else {
			this.dia = dia;
		}
	}

	private void setMes(int mes) {
		if (mes < 1) {
			this.mes = 1;
		} else if (mes > 12) {
			this.mes = 12;
		} else {
			this.mes = mes;
		}
	}

	public static Fecha sumarDias(Fecha unaFecha, int cantDias) {
		return deJuliano(aJuliano(unaFecha) + cantDias);
	}

	public Fecha sumarDias(int cantDias) {
		return deJuliano(aJuliano(this) + cantDias);
	}

	private int topeMes() {
		return topeMes(mes, anio);
	}

	private int topeMes(int mes, int anio) {
		int tope = 0;
		switch (mes) {
		case 4:
		case 6:
		case 9:
		case 11:
			tope = 30;
			break;
		case 2:
			tope = 28 + bisiesto(anio);
			break;
		default:
			tope = 31;
		}
		return tope;
	}

	@Override
	public String toString() {
		return "[" + anio + "-" + mes + "-" + dia + "]";
	}

	/**
	 * Convierte la fecha en un numero secuencial
	 * 
	 * Algoritmo adaptado desde "Numerical Recipes in C", 2nd ed., Cambridge
	 * University Press 1992
	 */
	public static double aJuliano(Fecha fecha) {
		int anioJuliano = fecha.anio;
		if (fecha.anio < 0)
			anioJuliano++;
		int mesJuliano = fecha.mes;
		if (fecha.mes > 2) {
			mesJuliano++;
		} else {
			anioJuliano--;
			mesJuliano += 13;
		}

		double fechaEnJuliano = (Math.floor(365.25 * anioJuliano) + Math.floor(30.6001 * mesJuliano) + fecha.dia
				+ 1720995.0);
		if (fecha.dia + 31 * (fecha.mes + 12 * fecha.anio) >= JGREG) {
			int ajuste = (int) (0.01 * anioJuliano);
			fechaEnJuliano += 2 - ajuste + (0.25 * ajuste);
		}
		return Math.floor(fechaEnJuliano);
	}

	/**
	 * Convierte un numero secuencial en fecha
	 * 
	 * Algoritmo adaptado desde "Numerical Recipes in C", 2nd ed., Cambridge
	 * University Press 1992
	 */
	public static Fecha deJuliano(double fechaEnJuliano) {
		int jalpha, ja, jb, jc, jd, je, anioAux, mesAux, diaAux;
		double jAux = fechaEnJuliano + HALFSECOND / 86400.0;
		ja = (int) jAux;
		if (ja >= JGREG) {
			jalpha = (int) (((ja - 1867216) - 0.25) / 36524.25);
			ja = ja + 1 + jalpha - jalpha / 4;
		}

		jb = ja + 1524;
		jc = (int) (6680.0 + ((jb - 2439870) - 122.1) / 365.25);
		jd = 365 * jc + jc / 4;
		je = (int) ((jb - jd) / 30.6001);
		diaAux = jb - jd - (int) (30.6001 * je);
		mesAux = je - 1;
		if (mesAux > 12)
			mesAux = mesAux - 12;
		anioAux = jc - 4715;
		if (mesAux > 2)
			anioAux--;
		if (anioAux <= 0)
			anioAux--;

		return new Fecha(anioAux, mesAux, diaAux);
	}

}
