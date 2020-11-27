package dominio;

public class PacientePrivado extends Paciente {
	
	public PacientePrivado(String nombre, Integer nroHistoriaClinica, Fecha nacimiento) {
		super(nroHistoriaClinica,nacimiento,nombre);		
		
	}

}
