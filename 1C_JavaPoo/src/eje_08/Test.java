package eje_08;

import java.util.ArrayList;

public class Test {

	final static int CANTIDAD_TURNOS = 5;
	static AgendaMedica agendaMedica;

	public static void main(String[] args) {

		agendaMedica = new AgendaMedica(CANTIDAD_TURNOS);

		System.out.println("Registro de turnos");
		registrarTurno(11111111, "Gonzalez", "Francisco", "4122-3333");
		registrarTurno(11111111, "Gonzalez", "Francisco", "4122-3333");
		registrarTurno(22222222, "Juarez", "Juana", "4344-5666");
		registrarTurno(33333333, "Gimenez", "Florencia", "1333-3333");
		registrarTurno(44444444, "Gonzalez", "Pablo", "2222-2222");
		registrarTurno(55555555, "Sabbatini", "Gabriela", "15 2233-2222");
		registrarTurno(66666666, "Quedafuera", "Juan", "15 2233-2211");

		agendaMedica.listarTurnos();

		System.out.println("Dar el Presente");
		darPresente(11111111);
		darPresente(44444444);
		darPresente(0);

		agendaMedica.listarTurnos();

		System.out.println("Anulaciones de turnos");
		anularTurno(0);
		anularTurno(22222222);
		anularTurno(55555555);

		agendaMedica.listarTurnos();

		System.out.println();
		
		System.out.println("Pacientes ausentes");
		ArrayList<Paciente> pacientesAusentes = agendaMedica.obtenerAusentes();
		if (pacientesAusentes.size() > 0) {
			for (Paciente paciente : pacientesAusentes) {
				System.out.println(paciente);
			}
		} else {
			System.out.println("No hubo pacientes ausentes");
		}

	}
	
	private static void anularTurno(int dni) {
		if (agendaMedica.anularTurno(dni))
			System.out.println("Turno anulado para el DNI " + dni + "\n");
		else
			System.out.println("No existe un turno para el DNI " + dni + "\n");
	}

	private static void darPresente(int dni) {
		if (agendaMedica.darPresente(dni))
			System.out.println("Presente confirmado para el DNI " + dni + "\n");
		else
			System.out.println("No existe un turno para el DNI " + dni + "\n");
	}

	private static void registrarTurno(int dni, String apellido, String nombre, String telefono) {
		ResultadoRegistracion resultado = agendaMedica.registrarTurno(dni, apellido, nombre, telefono);
		System.out.println("Registrando turno para " + nombre + ", " + apellido + " - dni: " + dni + " - tel: " + telefono);
		System.out.println("resultado de la operacion: " + resultado + "\n");
	}

}
