package eje_08;

public class Turno {

	private Paciente paciente;
	private boolean presente;

	/**
	 * Constructor de turno
	 * 
	 * @param paciente
	 * @param presente
	 */
	public Turno(Paciente paciente) {
		setPaciente(paciente);
		this.presente = false;
	}

	/**
	 * Da el presente del paciente (true)
	 */
	public void darPresente() {
		presente = true;
	}

	/**
	 * @return El paciente del turno
	 */
	public Paciente getPaciente() {
		return paciente;
	}

	/**
	 * @return El presente del turno
	 */
	public boolean estaPresente() {
		return presente;
	}

	/**
	 * Indica si el paciente del turno tiene el mismo dni que el recibido.
	 * 
	 * @param dni
	 *            El dni a comparar
	 * @return True si el turno es del paciente del dni recibido.
	 */
	public boolean mismoPaciente(int dni) {
		return this.paciente.mismoDni(dni);
	}

	/**
	 * @param paciente
	 *            El paciente del turno
	 */
	private void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return "Turno [paciente=" + paciente + ", presente=" + presente + "]";
	}

}
