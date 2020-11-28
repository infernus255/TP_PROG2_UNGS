package dominio;

public class Consultorio extends Atencion {
	private String nombreMedico;
	private String especialidad;

	public Consultorio(Double importe, Fecha fecha, String nombreMedico, String especialidad) {
		super(importe, fecha);
		this.nombreMedico = nombreMedico;
		this.especialidad = especialidad;
	}
}
