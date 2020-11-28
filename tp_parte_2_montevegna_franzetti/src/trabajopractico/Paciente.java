package trabajopractico;

import java.util.HashMap;

public abstract class Paciente {
	protected int nroHistoriaClinica;
	protected Fecha nacimiento;
	protected String nombre;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Paciente))
			return false;
		Paciente other = (Paciente) obj;
		if (nacimiento == null) {
			if (other.nacimiento != null)
				return false;
		} else if (!nacimiento.equals(other.nacimiento))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (nroHistoriaClinica != other.nroHistoriaClinica)
			return false;
		return true;
	}

	public Paciente(String nombre, Integer nroHistoriaClinica, Fecha nacimiento) {
		this.nroHistoriaClinica = nroHistoriaClinica;
		this.nacimiento = nacimiento;
		this.nombre = nombre;

	}

	public int obtenerNroHistoriaClinica() {
		return this.nroHistoriaClinica;
	}

	public int obtenerFecha() {
		return this.nroHistoriaClinica;
	}

	public Fecha obtenerEdad() {
		return this.nacimiento;
	}

}