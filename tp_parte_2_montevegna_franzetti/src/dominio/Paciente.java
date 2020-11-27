package dominio;

import java.util.HashMap;

public abstract class Paciente  {
	
    int nroHistoriaClinica;
    Fecha nacimiento;
    String nombre;
    private HashMap <Fecha,Atencion> Atenciones;
    
    public Paciente(int nroHistoriaClinica, Fecha nacimiento, String nombre) {
    	this.nroHistoriaClinica=nroHistoriaClinica;
    	this.nacimiento=nacimiento;
    	this.nombre=nombre;
    	
    	Atenciones= new HashMap <Fecha,Atencion>();
    }
       
    public int obtenerNroHistoriaClinica() {
    	return this.nroHistoriaClinica;
    }
    public int obtenerFecha() {
    	return this.nroHistoriaClinica;
    }
    public Fecha obtenerEdad() {
    	return this.nacimiento;
    }

}

