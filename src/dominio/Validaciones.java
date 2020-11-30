package dominio;

public class Validaciones {
	
	public static void validarLenghtString(String texto,Integer tope, String mensaje) throws Exception {
		if(!(texto.length()>0 && texto.length()<tope)) {
			throw new Exception(mensaje);
		}
	}
	
	public static void validarPrecio(Double precio,Double tope,String mensaje) throws Exception {
		if(!(precio>=0.0 && precio<tope)) {
			throw new Exception(mensaje);
		}
	}
	
	public static void validarPorcentaje(Double porcentaje,String mensaje) throws Exception{
		if(!(porcentaje>0 && porcentaje<100)) {
			throw new Exception(mensaje);
		}
	}
	
	public static void validarFecha(Fecha fecha,Fecha topeInicio,Fecha topeFin,String mensaje) throws Exception{
		//if(!(fecha.esMayorIgual(topeInicio) && topeFin.esMenorIgual(fecha))) 
		if(!(topeInicio.esMayorIgual(fecha) && (topeFin.esMenorIgual(fecha))))
		{
			throw new Exception(mensaje);
		}
	}
	
	public static void validarNumeroPositivo(Integer numero) throws Exception{
		if(!(numero>0)) {
			throw new Exception("El numero debe ser mayor a 0");
		}
	}
	

}
