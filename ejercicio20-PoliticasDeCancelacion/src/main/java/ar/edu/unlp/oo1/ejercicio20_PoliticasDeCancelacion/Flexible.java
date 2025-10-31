package ar.edu.unlp.oo1.ejercicio20_PoliticasDeCancelacion;

public class Flexible implements PoliticaCancelacion{
	
	public Flexible() {
	}
	
	public double calcularReembolso(Reserva reserva, double precioNoche) {
		if(!reserva.enCurso()) {
			return reserva.calcularPrecio(precioNoche);
		}
		
		return 0;
	}
}
