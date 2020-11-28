package dominio;

public class PacienteObraSocial extends Paciente {
	private String ObraSocial;
	// descuento

	public PacienteObraSocial(String nombre, Integer nroHistoriaClinica, Fecha nacimiento, String ObraSocial) {
		super(nombre, nroHistoriaClinica, nacimiento);
		this.ObraSocial = ObraSocial;
	}

	public String obtenerObraSocial() {
		return this.ObraSocial;
	}

	@Override
	public boolean agregarAtencion() {
		// TODO Auto-generated method stub
		return false;
	}

}
