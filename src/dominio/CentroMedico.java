package dominio;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.lang.Exception;

public class CentroMedico {

	private HashMap<Integer, Medico> medicos;
	private HashMap<String, Double> especialidades;
	private HashMap<Integer, Paciente> pacientes;
	private HashMap<String, Double> obrasSociales;
	private HashMap<Integer, Boolean> habitaciones;
	// validar los descuentos entre 1 y 99

	private String cuit;
	private String nombre;
	private Double costoDiaInternacion;

	public CentroMedico(String nombre, String cuit, Double costoDiaInternacion) throws Exception {
		this.cuit = cuit;
		this.nombre = nombre;
		this.costoDiaInternacion = costoDiaInternacion;

		medicos = new HashMap<Integer, Medico>();
		pacientes = new HashMap<Integer, Paciente>();
		especialidades = new HashMap<String, Double>();
		obrasSociales = new HashMap<String, Double>();
		habitaciones=new HashMap<Integer, Boolean>();
		crearHabitaciones(100);
	}

	public boolean agregarEspecialidad(String nombre, Double valor) {
		if (!especialidades.containsKey(nombre)) {
			especialidades.put(nombre, valor);
			return true;
		}

		return false;
	}

	public boolean agregarMedico(String nombre, Integer matricula, String nomEspecialidad, Double honorarios) {
		if (!medicos.containsKey(matricula)) {
			Medico medico = new Medico(nombre, matricula, nomEspecialidad, honorarios);
			medicos.put(matricula, medico);
			return true;
		}
		return false;
	}

	public boolean agregarPacientePrivado(String nombre, Integer historiaClinica, Fecha nac) {
		if (!pacientes.containsKey(historiaClinica)) {
			PacientePrivado paciente = new PacientePrivado(nombre, historiaClinica, nac);
			pacientes.put(historiaClinica, paciente);
			return true;
		}
		return false;
	}

	public boolean agregarPacienteAmbulatorio(String nombre, Integer nroHistoriaClinica, Fecha nac) {
		if (!pacientes.containsKey(nroHistoriaClinica)) {
			PacienteAmbulatorio paciente = new PacienteAmbulatorio(nombre, nroHistoriaClinica, nac);
			pacientes.put(nroHistoriaClinica, paciente);
			return true;
		}
		return false;
	}

	public boolean agregarPacienteObraSocial(String nombre, Integer historiaClinica, Fecha nac, String obraSocial,
			Double descuento) {
		if (!pacientes.containsKey(historiaClinica)) {
			// si existe se actualiza si no, lo agrega
			obrasSociales.put(obraSocial, descuento);
			PacienteObraSocial paciente = new PacienteObraSocial(nombre, historiaClinica, nac, obraSocial, descuento);
			pacientes.put(historiaClinica, paciente);
			return true;
		}
		return false;
	}

	// atencion consultorio
	public boolean agregarAtencion(Integer historiaClinica, Fecha fecha, Integer matricula) {
		if (pacientes.containsKey(historiaClinica)) {
			if (validarClasePaciente(pacientes.get(historiaClinica), "PacientePrivado")) {
				PacientePrivado paciente = (PacientePrivado) pacientes.get(historiaClinica);
				if (medicos.containsKey(matricula)) {
					Medico medico = medicos.get(matricula);
					return paciente.agregarAtencionConsultorio(fecha, medico);
				}
			}
		}
		return false;
	}

	// atencion guardia
	public boolean agregarAtencion(Integer historiaClinica, Fecha fecha) {
		if (pacientes.containsKey(historiaClinica)) {
			if (validarClasePaciente(pacientes.get(historiaClinica), "PacientePrivado")) {
				PacientePrivado paciente = (PacientePrivado) pacientes.get(historiaClinica);
				return paciente.agregarAtencionGuardia(fecha);
			}
		}
		return false;
	}

	private void crearHabitaciones(Integer cantidad) throws Exception {
	try {
		if (habitaciones.isEmpty()) {
			for (int i = 1; i < cantidad; i++) {
				habitaciones.put(i, false);
				i++;
			}
		}
	} catch (Exception e) {
		throw new Exception("fallo al crear habitaciones");
	}

	}

	private Integer obtenerHabitacionVacia() throws Exception {
		if (habitaciones.containsValue(false) && !habitaciones.isEmpty()) {
			Integer cont = 0;
			Iterator<Boolean> iterator = habitaciones.values().iterator();
			while (iterator.hasNext()) {
				cont++;
				if ((Boolean) iterator.next() == false) {
					break;
				}
				;
			}
			return cont;
		} else {
			throw new Exception("No hay habitaciones vacias o esta vacio");
		}

	}

	// atencion internacion
	public boolean agregarInternacion(Integer historiaClinica, String area, Fecha fechaIngreso) throws Exception {
		if (pacientes.containsKey(historiaClinica)) {
			if (validarClasePaciente(pacientes.get(historiaClinica), "PacienteObraSocial")) {
				PacienteObraSocial paciente = (PacienteObraSocial) pacientes.get(historiaClinica);

				return paciente.agregarInternacion(area, fechaIngreso, costoDiaInternacion, obtenerHabitacionVacia());
			}
		}
		return false;
	}

	public boolean altaInternacion(Integer historiaClinica, Fecha fechaAlta) throws ParseException {
		if (pacientes.containsKey(historiaClinica)) {
			if (validarClasePaciente(pacientes.get(historiaClinica), "PacienteObraSocial")) {
				PacienteObraSocial paciente = (PacienteObraSocial) pacientes.get(historiaClinica);
				return paciente.darAlta(fechaAlta);
			}
		}
		return false;
	}

	public boolean agregarTratamiento(Integer historiaClinica, Integer matricula, String tratamiento) {
		if (pacientes.containsKey(historiaClinica)) {
			if (validarClasePaciente(pacientes.get(historiaClinica), "PacienteAmbulatorio")) {
				PacienteAmbulatorio paciente = (PacienteAmbulatorio) pacientes.get(historiaClinica);
				return paciente.agregarTratamiento(medicos.get(matricula), tratamiento);
			}
		}
		return false;
	}

	public Double getSaldo(Integer historiaClinica) throws Exception {
		if (pacientes.containsKey(historiaClinica)) {
			Paciente paciente = pacientes.get(historiaClinica);
			return paciente.obtenerSaldo();
		}
		throw new Exception("No existe el paciente");
	}

	public void pagarSaldo(Integer historiaClinica) throws Exception {
		if (pacientes.containsKey(historiaClinica)) {
			Paciente paciente = pacientes.get(historiaClinica);
			paciente.pagarSaldo();
		}
		else {
			throw new Exception("No existe el paciente");
		}
	}

	public List<Integer> listaInternacion() throws Exception {
		if (pacientes.isEmpty()) {
			throw new Exception("no hay pacientes");
		}
		List<Integer> list = new ArrayList<Integer>();
		for (Paciente paciente : pacientes.values()) {
			if (validarClasePaciente(paciente, "PacienteObraSocial")) {
				PacienteObraSocial pacienteOS = (PacienteObraSocial) paciente;
				if (pacienteOS.hayInternacionActiva()) {
					list.add(paciente.nroHistoriaClinica);
				}
			}
		}
		return list;
	}

	// <fecha,especialidad>
	public Map<Fecha, String> atencionesEnConsultorio(Integer historiaClinica) {
		Map<Fecha, String> atencionesConsultorio = new HashMap<Fecha, String>();
		if (pacientes.containsKey(historiaClinica)) {
			if (validarClasePaciente(pacientes.get(historiaClinica), "PacientePrivado")) {
				PacientePrivado paciente = (PacientePrivado) pacientes.get(historiaClinica);
				atencionesConsultorio = paciente.obtenerAtencionesConsultorio();
			}
		}
		return atencionesConsultorio;
	}

	private boolean validarClasePaciente(Paciente paciente, String tipo) {
		if (paciente.getClass().getSimpleName().equals(tipo)) {
			return true;
		} else {
			return false;
		}
	}

	// AGREGAR VALIDACION EXISTENCIA DE COLECCIONES EN LOS METODOS
}