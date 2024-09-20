package eje_11;

public class ResumenCarrera {

	private String fechaHora;
	private int cantidadPilotos;

	public ResumenCarrera(String fechaHora, int cantidadPilotos) {
	
		this.fechaHora = fechaHora;
		this.cantidadPilotos = cantidadPilotos;
	}

	@Override
	public String toString() {
		return "ResumenCarrera [fechaHora=" + fechaHora + ", cantidadPilotos=" + cantidadPilotos + "]";
	}

}
