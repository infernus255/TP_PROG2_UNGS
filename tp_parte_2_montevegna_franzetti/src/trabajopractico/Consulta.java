package trabajopractico;

public abstract class Consulta extends Atencion {
	private String nombreMedico;
	private String tipoConsulta;
	private String especialidad;
	
	public  Consulta(float importe, Fecha fecha, boolean pagado, String tipo, String nombreMedico,String especialidad,String tipoConsulta) {
		super(importe,fecha,pagado,tipo);
		this.nombreMedico=nombreMedico;
		this.especialidad=especialidad;
		this.tipoConsulta=tipoConsulta;
	}
}
