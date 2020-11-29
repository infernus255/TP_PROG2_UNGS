package dominio;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;

public abstract class Paciente {
	protected int nroHistoriaClinica;
	protected Fecha nacimiento;
	protected String nombre;
	protected Double saldo;

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
		this.saldo = 0.0;

	}

	public Integer obtenerNroHistoriaClinica() {
		return nroHistoriaClinica;
	}

	public Fecha obtenerFechaNacimiento() {
		return nacimiento;
	}

	public Integer obtenerEdad() throws ParseException {
		LocalDate fechaAux = LocalDate.now();
		Fecha fechaActual = new Fecha(fechaAux.getDayOfMonth(), fechaAux.getMonthValue(), fechaAux.getYear());
		return nacimiento.obtenerDias(fechaActual) / 365;
	}

	public double obtenerSaldo() {
		return saldo;
	}

	public abstract void pagarSaldo() throws Exception;

}