package dominio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha {

	Integer dia;
	Integer mes;
	Integer anio;

	public Fecha(Integer dia, Integer mes, Integer anio) {
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anio == null) ? 0 : anio.hashCode());
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		result = prime * result + ((mes == null) ? 0 : mes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Fecha))
			return false;
		Fecha other = (Fecha) obj;
		if (anio == null) {
			if (other.anio != null)
				return false;
		} else if (!anio.equals(other.anio))
			return false;
		if (dia == null) {
			if (other.dia != null)
				return false;
		} else if (!dia.equals(other.dia))
			return false;
		if (mes == null) {
			if (other.mes != null)
				return false;
		} else if (!mes.equals(other.mes))
			return false;
		return true;
	}

	public String obtenerFecha() {
		StringBuilder str = new StringBuilder();
		str.append(dia);
		str.append("/");
		str.append(mes);
		str.append("/");
		str.append(anio);

		return str.toString();
	}

	// lo que hace esto es el this que es la fecha inicial
	// le resta a la fecha alta que es fecha, en breve entonces vas a hacer
	// fechaInicial >= fechaAlta
	public boolean esMayorIgual(Fecha fecha) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		StringBuilder fechaInicialStr = new StringBuilder();
		fechaInicialStr.append(this.anio);
		fechaInicialStr.append("-");
		fechaInicialStr.append(this.mes);
		fechaInicialStr.append("-");
		fechaInicialStr.append(this.dia);

		StringBuilder fechaFinalStr = new StringBuilder();
		fechaFinalStr.append(fecha.anio);
		fechaFinalStr.append("-");
		fechaFinalStr.append(fecha.mes);
		fechaFinalStr.append("-");
		fechaFinalStr.append(fecha.dia);
		Date fechaInicial = new Date();
		Date fechaFinal = new Date();

		fechaInicial = dateFormat.parse(fechaInicialStr.toString());
		fechaFinal = dateFormat.parse(fechaFinalStr.toString());

		int dias = (int) ((fechaFinal.getTime() - fechaInicial.getTime()) / 86400000);
		if (dias >= 0) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * @descripcion this seria tu fecha inicial entonces los dias es fechaFinal -
	 * fechaInicial= diferencia
	 */
	public int obtenerDias(Fecha fecha) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		StringBuilder fechaInicialStr = new StringBuilder();
		fechaInicialStr.append(this.anio);
		fechaInicialStr.append("-");
		fechaInicialStr.append(this.mes);
		fechaInicialStr.append("-");
		fechaInicialStr.append(this.dia);

		StringBuilder fechaFinalStr = new StringBuilder();
		fechaFinalStr.append(fecha.anio);
		fechaFinalStr.append("-");
		fechaFinalStr.append(fecha.mes);
		fechaFinalStr.append("-");
		fechaFinalStr.append(fecha.dia);
		Date fechaInicial = new Date();
		Date fechaFinal = new Date();

		fechaInicial = dateFormat.parse(fechaInicialStr.toString());
		fechaFinal = dateFormat.parse(fechaFinalStr.toString());

		int dias = (int) ((fechaFinal.getTime() - fechaInicial.getTime()) / 86400000);
		return dias;
	}

	public static void main(String[] args) {
		Fecha nueva = new Fecha(10, 02, 2020);
		if (nueva.getClass().getSimpleName().equals("Fecha")) {
			System.out.println(nueva.getClass().getSimpleName());
		}

	}
}
