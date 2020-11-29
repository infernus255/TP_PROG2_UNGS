package dominio;

public class Atencion {
	protected Double importe;
	protected Fecha fecha;

	public Atencion(Double importe, Fecha fecha) {
		this.importe = importe;
		this.fecha = fecha;
	}

	public Fecha obtenerFecha() {
		return fecha;
	}
}
