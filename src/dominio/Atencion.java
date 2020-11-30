package dominio;

public class Atencion {
	protected Double importe;
	protected Fecha fecha;
	protected Boolean pagado;

	public Atencion(Double importe, Fecha fecha) throws Exception {

		Fecha topeInicio = new Fecha(1, 1, 2000);
		Fecha topeFin = new Fecha(1, 1, 2100);

		Validaciones.validarPrecio(importe,100000.0, "El importe debe ser mayor o igual a 0 y menor a 100000");
		Validaciones.validarFecha(fecha, topeInicio, topeFin, "Ingrese una fecha valida");

		this.importe = importe;
		this.fecha = fecha;
		pagado = false;
	}

	public Double obtenerImporte() {
		return importe;
	}

	public Fecha obtenerFecha() {
		return fecha;
	}
	
	public void agregarImporte(Double importe) throws Exception {
		Validaciones.validarPrecio(importe, 100000.0, "El importe debe estar entre 0 y 100000");
		this.importe = importe;
	}
	
	public Boolean pagar() {
		return pagado = true;
	}
}
