package dominio;

import java.util.HashMap;

public class PacienteObraSocial extends Paciente {
	private String obraSocial;
	private Double descuento;
	private HashMap<Fecha, Internacion> internaciones;

	public PacienteObraSocial(String nombre, Integer nroHistoriaClinica, Fecha nacimiento, String obraSocial, Double descuento) {
		super(nombre, nroHistoriaClinica, nacimiento);
		this.obraSocial = obraSocial;
		this.descuento=descuento;
		internaciones=new HashMap<Fecha, Internacion>();
	}

	public String obtenerObraSocial() {
		return this.obraSocial;
	}

	public boolean agregarInternacion(String area,
			Fecha fechaIngreso, 
			Double importe,
			Integer nroHabitacion
			) {
		if(!internaciones.containsKey(fechaIngreso)) {
			if(area.equals("cardiologia")||area.equals("general")||area.equals("pediatria"))
			{
				Internacion internacion= new Internacion(importe, 
						fechaIngreso, 
						obraSocial, 
						area, 
						descuento,
						nroHabitacion);
			}
		}
		return false;
	}

}
