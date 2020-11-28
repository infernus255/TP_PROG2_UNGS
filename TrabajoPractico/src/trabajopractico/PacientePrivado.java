package trabajopractico;

import java.util.HashMap;

public abstract class PacientePrivado extends Paciente {
	 private HashMap <Fecha,Consulta> consultas;
	 
	public PacientePrivado(String nombre, Integer nroHistoriaClinica, Fecha nacimiento) {
		super(nombre,nroHistoriaClinica,nacimiento);		
		
		consultas= new HashMap <Fecha,Consulta>();
		
	}
	
	
	public boolean agregarConsultaGuardia(Integer matricula) {
		if(!atenciones.)
		return false;
	}
	public boolean agregarConsultaConsultorio(Integer matricula) {
		
		return false;
	}
	}
	

