package eje_01;

import java.util.ArrayList;

public class Agenda {
	private ArrayList<Persona> personas;

	/*
	 * Constructor público que instancia vacía la colección de personas (el
	 * ArrayList)
	 */
	public Agenda() {
		personas = new ArrayList<>();
	}

	/*
	 * Método privado buscarPersona() que busca en la colección la persona con el
	 * dni recibido por parámetro. Si la encuentra la devuelve, sino devuelve null
	 */
	private Persona buscarPersona(String dniBuscado) {
		Persona personaADevolver = null;
		
		int indice = 0;
		Persona personaActual;
		int cantPersonas = this.personas.size();
		
		while (indice < cantPersonas && personaADevolver == null) {
			personaActual = this.personas.get(indice);
			
			if(personaActual.getDni().equals(dniBuscado)) {
				personaADevolver = personaActual;
			} else {
				indice++;
			}
		}
		
		return personaADevolver;
	}

	/*
	 * Método público agregarPersona() que recibe por parámetro todos los datos
	 * necesarios para registrar una persona. Si no existe la persona con el dni
	 * recibido crea una nueva instancia de Persona con todos los datos recibidos y
	 * la agrega a la colección. Devuelve un booleano indicando si la acción se pudo
	 * realizar (si se agregó la persona) o no.
	 */
	public boolean agregarPersona(String dni, String nombre, String apellido, Domicilio domicilio) {
		boolean pude = false;

		if (this.buscarPersona(dni) == null) {
			//pude = this.personas.add(new Persona(dni, nombre, apellido, domicilio));
			Persona personaAgregar = new Persona(dni, nombre, apellido, domicilio);
			this.personas.add(personaAgregar);
			pude = true;
			//pude = this.personas.add(personaAgregar);
		}
		
		return pude;
	}

	/*
	 * Método público removerPersona(), que recibe como parámetro el número de dni
	 * de una persona. Si encuentra en la colección una persona con el mismo dni
	 * recibido la extrae de la colección y la devuelve. Cuando no la encuentra
	 * devuelve null.
	 */
	public Persona removerPersona(String dni) {
		Persona persona;
		persona = buscarPersona(dni);
		if (persona != null) {
			this.personas.remove(persona);
		}
        return persona;
	}

	/*
	 * Método público modificarDomicilio() que recibe por parámetro un dni y un
	 * domicilio. Si encuentra en la lista a la persona con ese dni modifica su
	 * domicilio con el recibido por parámetro. Retorna un booleano indicando si la
	 * operación fue exitosa o no.
	 */
	public boolean modificarDomicilio(String dni, Domicilio domicilio) {
		Persona persona;
		boolean sePudoModificar = false;
		persona = this.buscarPersona(dni);
		if (persona != null) {
			persona.setDomicilio(domicilio);
			sePudoModificar = true;
		}
		return sePudoModificar ;
	}

	/*
	 * Método público devolverUltimo() que no recibe parámetros y devuelve el último
	 * elemento de la lista (si es que ésta contiene elementos).
	 */
	public Persona devolverUltimo() {
		Persona ultimaPersona = new Persona();
		if (!this.personas.isEmpty()){  
			ultimaPersona = this.personas.get(this.personas.size()-1);
		}
	      return ultimaPersona;
	}

	/*
	 * Método público listarPersonas() que emite por pantalla en formato de listado
	 * a cada persona encontrada en la colección (con sus respectivos atributos).
	 */
	public void listarPersonas() {
		for (Persona persona: this.personas){ 
			persona.toString();
		}
	}

	public String toString() {
		return "Agenda [personas=" + personas + "]";
	}

	/*
	 * Método público eliminarTodosElementosAMano() que no recibe parámetros y
	 * elimina todos los elementos de la lista (sin utilizar el método clear).
	 */
	public void eliminarTodosElementosAMano() {

	}

}

