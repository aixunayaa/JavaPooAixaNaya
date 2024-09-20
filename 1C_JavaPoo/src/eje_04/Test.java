package eje_04;

public class Test {

	public static void main(String[] args) {

		Duenio duenio = new Duenio("Juan");
		Perro pichichus = new Perro("Pichichus");
		Perro sultan = new Perro("Sultan");
		
		duenio.adoptar(pichichus);
		duenio.adoptar(sultan);
		
		duenio.ponerCollarEnPerchero(new Collar("Pichichus"));
		duenio.ponerCollarEnPerchero(new Collar("Sultan"));		
		
		System.out.println("Pudo pasear: "+ duenio.salirDePaseo("Felipe"));
		System.out.println("Pudo pasear: "+ duenio.salirDePaseo("Pichichus"));
		System.out.println("Pudo pasear: "+ duenio.salirDePaseo("Sultan"));
		
	}

}