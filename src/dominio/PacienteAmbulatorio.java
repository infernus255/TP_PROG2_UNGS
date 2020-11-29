package dominio;

import java.util.HashMap;
import java.util.HashSet;

public class PacienteAmbulatorio extends Paciente {

	// coleccion< medico , tratamiento>
	private HashMap<Medico, HashSet<String>> tratamientos;

	public PacienteAmbulatorio(String nombre, Integer nroHistoriaClinica, Fecha nacimiento) {
		super(nombre, nroHistoriaClinica, nacimiento);
		tratamientos = new HashMap<Medico, HashSet<String>>();
	}

	public boolean agregarTratamiento(Medico medico, String tratamiento) {
		if (!tratamientos.isEmpty()) {
			if (tratamientos.containsKey(medico)) {
				HashSet<String> tratamientosXMedico = tratamientos.get(medico);
				if (!tratamientosXMedico.contains(tratamiento)) {
					saldo = saldo + medico.obtenerHonorarios();
					return tratamientosXMedico.add(tratamiento);
				}
			} else {
				HashSet<String> tratamientosXMedicoNew = new HashSet<String>();
				tratamientosXMedicoNew.add(tratamiento);
				tratamientos.put(medico, tratamientosXMedicoNew);
				saldo = saldo + medico.obtenerHonorarios();
				return true;
			}
		}
		return false;
	}

}
//