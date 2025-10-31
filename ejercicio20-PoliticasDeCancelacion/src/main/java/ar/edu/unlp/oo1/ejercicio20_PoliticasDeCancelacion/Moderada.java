package ar.edu.unlp.oo1.ejercicio20_PoliticasDeCancelacion;

public class Moderada implements PoliticaCancelacion{
	
	public Moderada() {}
	
	public double calcularReembolso(Reserva reserva, double precioNoche) {
		int cantDias = reserva.getPeriodo().cantDaysTo();
		
		if(cantDias >= 7) {
			return reserva.calcularPrecio(precioNoche);
		}
		else if(cantDias >= 2) {
			return (reserva.calcularPrecio(precioNoche)/2);
		}
		
		return 0;
	}
}
