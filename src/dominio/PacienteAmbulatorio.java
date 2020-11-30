package dominio;

import java.util.HashMap;

public class PacienteAmbulatorio extends Paciente {

	// coleccion< medico , tratamiento>
	private HashMap<Medico, HashMap<String, Boolean>> tratamientos;

	public PacienteAmbulatorio(String nombre, Integer nroHistoriaClinica, Fecha nacimiento) {
		super(nombre, nroHistoriaClinica, nacimiento);
		tratamientos = new HashMap<Medico, HashMap<String, Boolean>>();
	}

	public boolean agregarTratamiento(Medico medico, String tratamiento) {
			if (tratamientos.containsKey(medico)) {
				HashMap<String, Boolean> tratamientosXMedico = tratamientos.get(medico);
				if (!tratamientosXMedico.containsKey(tratamiento)) {
					saldo = saldo + medico.obtenerHonorarios();
					return tratamientosXMedico.put(tratamiento, false);
				}
			} else {
				HashMap<String, Boolean> tratamientosXMedicoNew = new HashMap<String, Boolean>();
				tratamientosXMedicoNew.put(tratamiento, false);
				tratamientos.put(medico, tratamientosXMedicoNew);
				saldo = saldo + medico.obtenerHonorarios();
				return true;
			}
		return false;
	}

	public void pagarSaldo() throws Exception {
		if (!tratamientos.isEmpty()) {
			for (HashMap<String, Boolean> tratamientosXMedicos : tratamientos.values()) {
				for (String tratamiento : tratamientosXMedicos.keySet()) {
					tratamientosXMedicos.put(tratamiento, true);
				}
			}
			saldo = 0.0;

		}
		else {
			throw new Exception("No hay atenciones para pagar");
		}
	}

}
//