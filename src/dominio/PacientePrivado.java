package dominio;

import java.util.HashMap;
import java.util.Map;

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
			saldo = saldo + consulta.importe;
			return true;
		}
		return false;
	}

	public boolean agregarAtencionGuardia(Fecha fecha) {
		if (!atenciones.containsKey(fecha)) {
			Atencion atencion = new Atencion(0.0, fecha);
			atenciones.put(fecha, atencion);
			return true;
		}
		return false;
	}

	public Map<Fecha, String> obtenerAtencionesConsultorio() {
		Map<Fecha, String> atencionesConsultorio = new HashMap<Fecha, String>();
		for (Atencion atencion : atenciones.values()) {
			if (validarClaseAtencion(atencion, "Consultorio")) {
				Consultorio consultorio = (Consultorio) atencion;
				atencionesConsultorio.put(consultorio.obtenerFecha(), consultorio.obtenerEspecialidad());
			}
		}
		return atencionesConsultorio;
	}

	private boolean validarClaseAtencion(Atencion atencion, String tipo) {
		if (atencion.getClass().getSimpleName().equals(tipo)) {
			return true;
		} else {
			return false;
		}
	}
}
