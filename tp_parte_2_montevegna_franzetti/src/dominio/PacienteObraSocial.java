package dominio;

public class PacienteObraSocial extends Paciente {
	private String ObraSocial;
	// descuento

	public PacienteObraSocial(String nombre, Integer nroHistoriaClinica, Fecha nacimiento, String ObraSocial) {
		super(nroHistoriaClinica, nacimiento, nombre);
		this.ObraSocial = ObraSocial;
	}

	public String obtenerObraSocial() {
		return this.ObraSocial;
	}

}