package dominio;

public class Atencion {
	protected Double importe;
	protected Fecha fecha;
	protected Boolean pagado;

	public Atencion(Double importe, Fecha fecha) {
		this.importe = importe;
		this.fecha = fecha;
		pagado = false;
	}

	public Fecha obtenerFecha() {
		return fecha;
	}

	public Boolean pagar() {
		pagado = true;
	}
}
