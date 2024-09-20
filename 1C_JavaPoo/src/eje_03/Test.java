package eje_03;

public class Test {

	public static void main(String[] args) {
		Inmobiliaria inmobiliaria = new Inmobiliaria();
		inmobiliaria.agregarPropiedad(TipoPropiedad.CASA, "Caballito", "Yatay 240", 987654);
		inmobiliaria.agregarPropiedad(TipoPropiedad.CASA, "Belgrano", "Av. del Libertador 6796", 987654);
		inmobiliaria.agregarPropiedad(TipoPropiedad.CASA, "Belgrano", "La Pampa 1715", 165100);
		inmobiliaria.mostrarPropiedades();
		inmobiliaria.cambiarPropiedadDeBarrio("Yatay240", "Almagro");
		inmobiliaria.mostrarPropiedades();
		inmobiliaria.cambiarPropiedadDeBarrio("Yatay 240", "Almagro");
		inmobiliaria.mostrarPropiedades();
		inmobiliaria.mostrarBarrioMaxProp();
		borrarPropiedad(inmobiliaria, "Quiroga 874");
		borrarPropiedad(inmobiliaria, "La Pampa 1715");
		inmobiliaria.mostrarPropiedades();
		inmobiliaria.mostrarBarrioMaxProp();
	}

	private static void borrarPropiedad(Inmobiliaria inmobiliaria, String domicilio) {
		System.out.println("Se intenta borrar la propiedad de " + domicilio);
		Propiedad prop = inmobiliaria.borrarPropiedad(domicilio);
		if (prop == null) {
			System.out.println("No se pudo borrar la propiedad de " + domicilio);
		} else {
			System.out.println("Se borro " + prop);
		}
	}

}
