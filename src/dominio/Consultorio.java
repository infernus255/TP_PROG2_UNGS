package dominio;

public class Consultorio extends Atencion {
	private String nombreMedico;
	private String especialidad;

	public Consultorio(Double importe, Fecha fecha, String nombreMedico, String especialidad) throws Exception {
		super(importe, fecha);

		Validaciones.validarLenghtString(nombreMedico, 50, "El nombre del medico debe estar entre 0 y 50");
		Validaciones.validarLenghtString(especialidad, 50, "El especialidad debe estar entre 0 y 50");

		this.nombreMedico = nombreMedico;
		this.especialidad = especialidad;
	}

	public String obtenerEspecialidad() {
		return especialidad;
	}
}
