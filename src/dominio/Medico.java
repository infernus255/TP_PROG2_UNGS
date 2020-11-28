package dominio;

public class Medico {
	 
	 private Integer nroMatricula;
	 private String nombre;
	 private Double honorarios;
	 private String especialidad;

	 
	 public Medico(String nombre, Integer nroMatricula, String especialidad, Double honorarios) {
	  this.nombre=nombre;
	  this.nroMatricula=nroMatricula;
	  this.especialidad=especialidad;
	  this.honorarios=honorarios;
	 }
	 
	/*private boolean validarHonorarios(Medico medico) {
	  if(medico.honorarios <=0) {
	   return false;
	  }
	  else {
	   return true;
	  }
	 }
	*/
	 public double obtenerHonorarios() {
	  return honorarios;
	 }
	 
	 public String obtenerEspecialidad() {
	  return especialidad; 
	 }
	 public Integer obtenerMatricula() {
	  return nroMatricula;
	 }
	 public String obtenerNombre() {
		 return nombre;
	 }
	 
	/* private boolean validarMatricula(Medico medico) {
	  if (nroMatriculaespecialidad<0) {
	   return false;
	  }else {
	   return false;
	  }
	 }
	 */
	}