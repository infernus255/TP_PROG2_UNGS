package trabajopractico;

import java.util.HashMap;

public class PacienteAmbulatorio extends Paciente{
	
	//coleccion< medico , tratamiento>
	private HashMap< Medico , String> tratamientos;
	
	public PacienteAmbulatorio(String nombre, Integer nroHistoriaClinica, Fecha nacimiento) {
		super(nombre,nroHistoriaClinica,nacimiento);
		tratamientos=new HashMap< Medico , String>();
	}



	
}
//