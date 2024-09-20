package eje_10;

import java.util.ArrayList;

public class Alumno {private String nombre;
private String email;
private ArrayList<MateriaAprobada> materiasAprobadas;

public Alumno(String nombre, String email) {
	setNombre(nombre);
	setEmail(email);
	materiasAprobadas = new ArrayList<>();
}

public boolean agregarNotaFinal(String nombreMateria, int nota) {
	boolean ok = false;
	if (!materiaCargada(nombreMateria)) {
		materiasAprobadas.add(new MateriaAprobada(nombreMateria, nota));
		ok = true;
	}
	return ok;
}

public String getEmail() {
	return email;
}

public String getNombre() {
	return nombre;
}

private boolean materiaCargada(String nombreMateria) {
	int index = 0;
	while (index < materiasAprobadas.size()
			&& !nombreMateria.equals(materiasAprobadas.get(index).getNombreMateria())) {
		index++;
	}
	return index != materiasAprobadas.size();
}

public ResumenAlumno obtenerResumen() {
	double acum = 0;
	for (MateriaAprobada materiaAprobada : materiasAprobadas) {
		acum += materiaAprobada.getNotaFinal();
	}
	return new ResumenAlumno(materiasAprobadas.size(), acum / materiasAprobadas.size());
}

public void setEmail(String email) {
	this.email = email;
}

private void setNombre(String nombre) {
	this.nombre = nombre;
}

}
