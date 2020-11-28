package dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Set;

public class CentroMedico {

	private HashMap<Integer, Medico> medicos;
	private HashMap<String, Double> especialidades;
	private HashMap<Integer, Paciente> pacientes;
	private HashMap<String, Double> obrasSociales;
	private HashMap<Integer,Boolean> habitaciones;
	// validar los descuentos entre 1 y 99

	private Integer cuit;
	private String nombre;
	private Double costoDiaInternacion;

	public CentroMedico(String nombre, Integer cuit, Double costoDiaInternacion) {
		this.cuit = cuit;
		this.nombre = nombre;
		this.costoDiaInternacion = costoDiaInternacion;

		medicos = new HashMap<Integer, Medico>();
		pacientes = new HashMap<Integer, Paciente>();
		especialidades = new HashMap<String, Double>();
		obrasSociales = new HashMap<String, Double>();
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
			PacienteObraSocial paciente = new PacienteObraSocial(nombre, historiaClinica, nac, obraSocial,descuento);
			pacientes.put(historiaClinica, paciente);
			return true;
		}
		return false;
	}

//atencion consultorio
	public boolean agregarAtencion(Integer historiaClinica, Fecha fecha, Integer matricula) {
		if (!pacientes.containsKey(historiaClinica)) {
			if (validarClasePaciente(pacientes.get(historiaClinica), "PacientePrivado")) {
				PacientePrivado paciente = (PacientePrivado) pacientes.get(historiaClinica);
				if (!medicos.containsKey(matricula)) {
					Medico medico = medicos.get(matricula);
					return paciente.agregarAtencionConsultorio(fecha, medico);		
				}
			}
		}
		return false;
	}

	//atencion guardia
		public boolean agregarAtencion(Integer historiaClinica, Fecha fecha) {
			if (!pacientes.containsKey(historiaClinica)) {
				if (validarClasePaciente(pacientes.get(historiaClinica), "PacientePrivado")) {
					PacientePrivado paciente = (PacientePrivado) pacientes.get(historiaClinica);
						return paciente.agregarAtencionGuardia(fecha);		
				}
			}
			return false;
		}
		
		private void crearHabitaciones(Integer cantidad) {
			 if(habitaciones.isEmpty()) {
				   for(int i=1;i<cantidad ; i++) {
				    habitaciones.put(i,false);
				    i++;
				   }
				  }
		}
		
		private Integer obtenerHabitacionVacia() throws Exception {
				if(habitaciones.containsValue(false) && !habitaciones.isEmpty() ) {
					Integer cont=0;
					Iterator iterator = habitaciones.values().iterator();
					while(iterator.hasNext()) {
						cont++;
						if((Boolean)iterator.next()==false) {
							break;
						};
					}
					return cont;
				}
				else {
					throw new Exception("No hay habitaciones vacias o esta vacio");
				}

		}
		
	//atencion internacion
		public boolean agregarAtencion(Integer historiaClinica,String area, Fecha fechaIngreso) {
			if (!pacientes.containsKey(historiaClinica)) {
				if (validarClasePaciente(pacientes.get(historiaClinica), "PacienteObraSocial")) {
					PacienteObraSocial paciente = (PacienteObraSocial) pacientes.get(historiaClinica);
						
					return paciente.agregarInternacion(area,
							fechaIngreso,
							costoDiaInternacion,
							obtenerHabitacionVacia();
							);		
				}
			}
			return false;
		}
		
	public boolean validarClasePaciente(Paciente paciente, String tipo) {
		if (paciente.getClass().getSimpleName().equals(tipo)) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * public boolean agregarAtencion(int historiaClinica,Fecha fecha,int
	 * matricula){ AtencionConsultorio atencion= new
	 * AtencionConsultorio(historiaClinica,fecha,matricula); double
	 * preciohonorarios=medicos.get(matricula).obtenerhonorarios();
	 * 
	 * atencion.sumarimporte(preciohonorarios); if(pacientes.get(historiaClinica)
	 * instanceof Privado){
	 * pacientes.get(historiaClinica).agregarAtencionpaciente(atencion);
	 * 
	 * return true; } return false;}
	 */

	/*
	 * String nombre; int historiaClinica; Fecha nac; String ObraSocial; int
	 * descuento;
	 */
	// centro.agregarPacienteObraSocial("Carlos", 222, new Fecha(15,1,1940), "Pami",
// 0.3);

	/*
	 * public void agregarPacienteObraSocial(String nombre, int historiaClinica,
	 * Fecha nac, String osocial, double p){ if
	 * (!pacientes.containsKey(historiaClinica)){ Obrasocial paciente=new
	 * Obrasocial(nombre,historiaClinica,nac);
	 * pacientes.put(historiaClinica,paciente); return true; } return false; } }
	 */

	// atenci�n en consultorio.

	/*
	 * public boolean agregarAtencion(int historiaClinica, Fecha fecha) { //atencion
	 * por guardia Guardia guardia = new Guardia(historiaClinica,fecha); int
	 * precio=0; if(pacientes.get(historiaClinica) instanceof PacientePrivado) {
	 * pacientes.put(F, atenciones); return true; } else { return false; } }
	 */
	public boolean agregarInternacion(int historiaClinica, String area, Fecha fingreso) {
		// void agregarInternacion(int historiaClinica, String area, Fecha fingreso)
		Internacion internacion = new Internacion(historiaClinica, area, fingreso);
		if (pacientes.get(historiaClinica) instanceof PacienteObraSocial) {
			pacientes.get(historiaClinica).agregarInternacion(historiaClinica, area, fingreso);
			return true;
		} else {
			return false;
		}
	}

}