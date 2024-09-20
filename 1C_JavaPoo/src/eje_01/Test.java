package eje_01;

public class Test {

	public static void main(String[] args) {
		// Creamos e instanciamos nuestro objeto de tipo Agenda
		Agenda agenda;
		agenda = new Agenda();

		agenda.listarPersonas();

		System.out.println("Alta de personas a la agenda");
		System.out.println(
				agenda.agregarPersona("99999999", "Ignacio", "Gonzalez", new Domicilio("Cordoba", 5443, "Palermo")));
		System.out.println(
				agenda.agregarPersona("32341111", "Lionel", "Messi", new Domicilio("Santa Fe", 3221, "Recoleta")));
		System.out.println(
				agenda.agregarPersona("12345678", "Nicolas", "Suarez", new Domicilio("Yatay", 240, "Almagro")));
		System.out.println(
				agenda.agregarPersona("98765432", "Maria", "Gomez", new Domicilio("Avellaneda", 1240, "Caballito")));

		System.out.println("Intentamos agregar a otra persona con mismo dni que Suarez Nicolas a la agenda");
		System.out.println(agenda.agregarPersona("12345678", "Gomez", "Nicolas",
				new Domicilio("Carlos Pellegrini", 350, "Monserrat")));

		System.out.println("Intentamos eliminar una persona de la agenda con un dni no registrado");
		System.out.println(agenda.removerPersona("22222222"));

		System.out.println("Intentamos eliminar una persona de la agenda con un dni registrado");
		System.out.println(agenda.removerPersona("12345678"));

		System.out.println("Modificar direccion no exitoso");
		System.out.println(agenda.modificarDomicilio("444444444", new Domicilio("Carlos Gardel", 120, "Abasto")));

		System.out.println("Modificar direccion exitoso");
		System.out.println(agenda.modificarDomicilio("32341111", new Domicilio("Alvarez Jonte", 5401, "Monte Castro")));

		System.out.println("Mostramos el ultimo elemento de la lista");
		System.out.println(agenda.devolverUltimo());

		agenda.listarPersonas();

		System.out.println("Eliminamos todos los elementos 1 a 1");
		agenda.eliminarTodosElementosAMano();
		agenda.listarPersonas();

	}

}
