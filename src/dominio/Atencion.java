package dominio;

public class Atencion {
	protected Double importe;
	protected Fecha fecha;
	protected boolean pagado;

	public Atencion(Double importe, Fecha fecha) {
		this.importe = importe;
		this.fecha = fecha;
		pagado = false;
	}

}
