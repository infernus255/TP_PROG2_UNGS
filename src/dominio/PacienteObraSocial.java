package dominio;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PacienteObraSocial extends Paciente {
	private String obraSocial;
	private Double descuento;
	private LinkedList<Internacion> internaciones;

	public PacienteObraSocial(String nombre, Integer nroHistoriaClinica, Fecha nacimiento, String obraSocial,
			Double descuento) {
		super(nombre, nroHistoriaClinica, nacimiento);
		this.obraSocial = obraSocial;
		this.descuento = descuento;
		internaciones = new LinkedList<Internacion>();
	}

	public String obtenerObraSocial() {
		return this.obraSocial;
	}

	// o(n)
	private boolean contieneFechaIngreso(Fecha fechaIngreso) {
		boolean alguno = false;
		for (Internacion internacion : internaciones) {
			alguno = alguno || (internacion.fecha.equals(fechaIngreso));
		}
		return alguno;
	}

	// o(1)
	public boolean hayInternacionActiva() {
		if(internaciones.isEmpty()) {
			return false;
		}
		return internaciones.getLast().obtenerFechaAlta() == null;
	}

	public boolean agregarInternacion(String area, Fecha fechaIngreso, Double importe, Integer nroHabitacion) {
			if (!contieneFechaIngreso(fechaIngreso) && !hayInternacionActiva()) {
				area=area.toUpperCase();
				if (area.equals("CARDIOLOGIA") || area.equals("GENERAL") || area.equals("PEDIATRIA")) {
					Internacion internacion = new Internacion(importe, fechaIngreso, obraSocial, area, descuento,
							nroHabitacion);
					internaciones.addLast(internacion);
					return true;
				}
			}
		return false;
	}

	public boolean darAlta(Fecha fechaAlta) throws ParseException {
		if (!internaciones.isEmpty()) {
			Internacion ultimaInternacion = internaciones.getLast();
			if (hayInternacionActiva() && ultimaInternacion.obtenerFechaIngreso().esMayorIgual(fechaAlta)) {
				ultimaInternacion.agregarFechaAlta(fechaAlta);
				// (porcentaje * fechaIngreso *costo diario)
				Double costoAlta = descuento * ultimaInternacion.obtenerFechaIngreso().obtenerDias(fechaAlta)
						* ultimaInternacion.obtenerImporte();
				ultimaInternacion.agregarImporte(costoAlta);
				saldo = saldo + costoAlta;
				return true;
			}
		}
		return false;
	}

	public void pagarSaldo() throws Exception {
		if (!internaciones.isEmpty()) {
			for (Internacion internacion : internaciones) {
				if (internacion.obtenerFechaAlta() != null)
					internacion.pagar();
			}
			saldo = 0.0;
		}
		else {
			throw new Exception("No hay atenciones para pagar");
		}
	}

	// al pagar hay que dar el alta

}
