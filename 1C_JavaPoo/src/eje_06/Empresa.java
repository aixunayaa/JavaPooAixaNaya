package eje_06;

import java.util.ArrayList;

public class Empresa {

	private String nombre;
	private ArrayList<Cliente> clientes;
	private ArrayList<Cliente> listaNegra;
	private ArrayList<Pelicula> peliculas;

	public Empresa(String nombre) {
		setNombre(nombre);
		this.clientes = new ArrayList<Cliente>();
		this.listaNegra = new ArrayList<Cliente>();
		this.peliculas = new ArrayList<Pelicula>();
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	/**
	 * Este metodo recibe el arraylist de clientes deseado (aun cuando ambas
	 * colecciones de clientes son miembros de la clase) para evitar la misma
	 * busqueda en dos colecciones de exactametne el mismo tipo.
	 * 
	 * @param dni
	 * @param listaBuscar
	 * @return
	 */
	private Cliente buscarCliente(String dni, ArrayList<Cliente> listaBuscar) {
		Cliente elementoDevolver = null;
		int pos = 0;
		Cliente elementoActual = null;
		int cantidadElementos = listaBuscar.size();
		while ((pos < cantidadElementos) && (elementoDevolver == null)) {
			elementoActual = listaBuscar.get(pos);
			if (elementoActual.getDni().equals(dni)) {
				elementoDevolver = elementoActual;
			} else {
				pos++;
			}
		}
		return elementoDevolver;
	}

	public ResulAlta darDeAlta(String dni, TipoServicio tipo, String nombre) {
		Cliente clienteBuscado;
		ResulAlta resultado = ResulAlta.CLIENTE_EXISTENTE;

		clienteBuscado = buscarCliente(dni, this.clientes);

		if (clienteBuscado == null) {
			clienteBuscado = buscarCliente(dni, this.listaNegra);
			if (clienteBuscado == null) {
				resultado = ResulAlta.ALTA_OK;
				clientes.add(new Cliente(dni, nombre, tipo));
			} else {
				resultado = ResulAlta.CLIENTE_DEUDOR;
			}
		}
		return resultado;
	}

	private Pelicula buscarPelicula(String nombre) {
		Pelicula elementoDevolver = null;
		int pos = 0;
		Pelicula elementoActual = null;
		int cantidadElementos = this.peliculas.size();
		while ((pos < cantidadElementos) && (elementoDevolver == null)) {
			elementoActual = this.peliculas.get(pos);
			if (elementoActual.getNombre().equals(nombre)) {
				elementoDevolver = elementoActual;
			} else {
				pos++;
			}
		}
		return elementoDevolver;
	}

	public ResuVerPeli verPelicula(String dni, String nombrePeli) {
		ResuVerPeli resultado;
		Pelicula pelicula;
		Cliente cliente = buscarCliente(dni, this.clientes);
		if (cliente != null) {
			if (!cliente.esDeudor()) {
				pelicula = buscarPelicula(nombrePeli);
				if (pelicula != null) {
					if (verificarContenidoApto(cliente, pelicula)) {
						resultado = ResuVerPeli.OK;
						cliente.agregarHistorial(pelicula);
					} else {
						resultado = ResuVerPeli.CONTENIDO_NO_DISPONIBLE;
					}
				} else {
					resultado = ResuVerPeli.CONTENIDO_INEXISTENTE;
				}
			} else {
				resultado = ResuVerPeli.CLIENTE_DEUDOR;
			}
		} else {
			resultado = ResuVerPeli.CLIENTE_INEXISTENTE;
		}
		return resultado;
	}

	private boolean verificarContenidoApto(Cliente cliente, Pelicula pelicula) {
		return (cliente.getTipo() == TipoServicio.PREMIUM) || (cliente.getTipo() == pelicula.getTipo());
	}

	public boolean darDeBaja(String dni) {
		boolean resultado = false;
		Cliente cliente = buscarCliente(dni, this.clientes);
		if (cliente != null) {
			clientes.remove(cliente);
			if (cliente.esDeudor()) {
				this.listaNegra.add(cliente);
			}
			resultado = true;
		}
		return resultado;
	}

	public void depurarListaNegra(double importe) {
		Cliente cliente;
		int pos = 0;
		while (pos < listaNegra.size()) {
			cliente = listaNegra.get(pos);
			if (cliente.getSaldo() <= importe) {
				listaNegra.remove(cliente);
			} else {
				pos++;
			}
		}
	}

	public void publicarPelicula(Pelicula pelicula) {
		this.peliculas.add(pelicula);
	}

}
