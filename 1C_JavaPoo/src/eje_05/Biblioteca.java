package eje_05;

import java.util.ArrayList;

public class Biblioteca {

	private ArrayList<Ejemplar> ejemplares;
	private ArrayList<Ejemplar> prestados;
	private ArrayList <Autor> autores;
	private ArrayList<Editorial> editoriales;
	private ArrayList<Lector> lectores;
	
	private Fecha fechaHoy;
	
	public Biblioteca(Fecha fechaHoy){
		// no puedo usar los meotods de arrayist. 
		ejemplares = new ArrayList<>();
		prestados = new ArrayList<>();
		lectores = new ArrayList<>();
		this.fechaHoy = fechaHoy;
	}
	
	public ResultadoPrestamo prestar(Libro libro, Lector lector) {
		ResultadoPrestamo resultado = ResultadoPrestamo.PRESTAMO_EXITOSO ;
		Ejemplar ejemplarEncontrado;
		if(lector.tieneMulta(fechaHoy)) {
			resultado = ResultadoPrestamo.MULTA_VIGENTE;
		}else if (!lector.tieneEspacioPrestamo()) {
			resultado = ResultadoPrestamo.TOPE_PRESTAMOS_ALCANZADO;
		} else if (this.buscarEjemplar(libro) == null) {
			resultado = ResultadoPrestamo.NO_HAY_EJEMPLARES;
		}else {
			//
			ejemplarEncontrado = this.buscarEjemplar(libro);
			ejemplarEncontrado.setEstado(Estado.PRESTADO);
			ejemplarEncontrado.setFecha(fechaHoy);
			
			lector.agregarPrestamo(ejemplarEncontrado);
			this.removerEjemplar(ejemplarEncontrado);
			prestados.add(ejemplarEncontrado);
		}		
		
		return resultado;
	}
	private boolean removerEjemplar(Ejemplar ejemplar) {
		return this.ejemplares.remove(ejemplar);
	}
	
	private Ejemplar buscarEjemplar (Libro libro) {
		// SUPONEMOS QUE ES LA MISMA INSTANCIA DEL LIBRO
		Ejemplar ejemplarEncontrado = null;
				
		int pos= 0;
		int cantidadElementos = this.ejemplares.size();
		
		while(pos < cantidadElementos && ejemplarEncontrado == null) {
			Ejemplar ejemplarAux = this.ejemplares.get(pos);
			// chequea las direcciones de memoria
			if(ejemplarAux.getLibro() == libro) {
				ejemplarEncontrado = ejemplarAux;
			}else {
				pos++;
			}
		}
		return ejemplarEncontrado;
		
	}
}