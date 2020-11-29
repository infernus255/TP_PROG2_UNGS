package dominio;

public class Medico {

	private Integer nroMatricula;
	private String nombre;
	private Double honorarios;
	private String especialidad;

	public Medico(String nombre, Integer nroMatricula, String especialidad, Double honorarios) {
		this.nombre = nombre;
		this.nroMatricula = nroMatricula;
		this.especialidad = especialidad;
		this.honorarios = honorarios;
	}

	/*
	 * private boolean validarHonorarios(Medico medico) { if(medico.honorarios <=0)
	 * { return false; } else { return true; } }
	 */
	public Double obtenerHonorarios() {
		return honorarios;
	}

	public String obtenerEspecialidad() {
		return especialidad;
	}

	public Integer obtenerMatricula() {
		return nroMatricula;
	}

	public String obtenerNombre() {
		return nombre;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medico other = (Medico) obj;
		if (nroMatricula == null) {
			if (other.nroMatricula != null)
				return false;
		} else if (!nroMatricula.equals(other.nroMatricula))
			return false;
		return true;
	}

	/*
	 * private boolean validarMatricula(Medico medico) { if
	 * (nroMatriculaespecialidad<0) { return false; }else { return false; } }
	 */
}