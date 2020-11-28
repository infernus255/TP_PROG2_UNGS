package dominio;

public class Internacion extends Atencion{
	private String obraSocial;
	private String area;
	private Double descuento;
	private Integer nroHabitacion;
	private Fecha fechaAlta;
	public Internacion(Double importe, Fecha fecha, String obraSocial, String area, Double descuento,Integer nroHabitacion) {
		super(importe, fecha);
		this.obraSocial = obraSocial;
		this.area = area;
		this.descuento = descuento;
		this.nroHabitacion = nroHabitacion;
		this.fechaAlta = null;
	}
	
	

	
}
