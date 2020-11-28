package dominio;

import java.util.HashMap;

public class PacientePrivado extends Paciente {
	private HashMap<Fecha, Atencion> atenciones;

	public PacientePrivado(String nombre, Integer nroHistoriaClinica, Fecha nacimiento) {
		super(nombre, nroHistoriaClinica, nacimiento);
		atenciones = new HashMap<Fecha, Atencion>();
	}

	public boolean agregarAtencionConsultorio(Fecha fecha, Medico medico) {
		if (!atenciones.containsKey(fecha)) {
			Consultorio consulta = new Consultorio(medico.obtenerHonorarios(), fecha, medico.obtenerNombre(),
					medico.obtenerEspecialidad());
			atenciones.put(fecha, consulta);
		}
		return false;
	}

	public boolean agregarAtencionGuardia(Fecha fecha) {
		if (!atenciones.containsKey(fecha)) {
			Atencion atencion = new Atencion(0.0,fecha);
			atenciones.put(fecha, atencion);
		}
		return false;
	}
}
