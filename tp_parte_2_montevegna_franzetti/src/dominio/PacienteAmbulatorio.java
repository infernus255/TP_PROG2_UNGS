package dominio;

import java.util.HashMap;

public class PacienteAmbulatorio extends Paciente{
	
	//coleccion< medico , tratamiento>
	private HashMap< Medico , String> tratamientos;
	
	public PacienteAmbulatorio(String nombre, Integer nroHistoriaClinica, Fecha nacimiento) {
		super(nroHistoriaClinica,nacimiento,nombre);
		tratamientos=new HashMap< Medico , String>();
	}
}
