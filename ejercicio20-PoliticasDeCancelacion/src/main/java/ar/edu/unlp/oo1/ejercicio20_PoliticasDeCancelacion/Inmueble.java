package ar.edu.unlp.oo1.ejercicio20_PoliticasDeCancelacion;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.oo1.ejercicio16_IntervaloDeTiempo.DateLapse;


public class Inmueble {
	private String direccion;
	private String descripcion;
	private double precioNoche;
	private PoliticaCancelacion politica;
	private List<Reserva> reservas;
	
	public Inmueble(String direccion, String descripcion, double precioNoche, PoliticaCancelacion politica) {
		this.direccion = direccion;
		this.descripcion = descripcion;
		this.precioNoche = precioNoche;
		this.politica = politica;
		this.reservas = new ArrayList<Reserva>();
	}
	
	
	//Getters & Setters
	
	public PoliticaCancelacion getPolitica() {
		return politica;
	}
	
	public void setPolitica(PoliticaCancelacion politica) {
		this.politica = politica;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioNoche() {
		return precioNoche;
	}

	public void setPrecioNoche(double precioNoche) {
		this.precioNoche = precioNoche;
	}

	public String getDireccion() {
		return direccion;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}
	
	//Metodos	
	
	public boolean estaDisponible(DateLapse periodo) {
		return this.reservas.stream().noneMatch(r -> r.getPeriodo().overlaps(periodo));
	}
	
	public void agregarReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	public double cancelarReserva(Reserva reserva) {
		this.reservas.remove(reserva); //Borro la reserva de la lista de reservas
		
		return this.politica.calcularReembolso(reserva, precioNoche); //Retorno el valor del reembolso para el inquilino.
	}
	
	public double calcularTotalReservas(DateLapse periodo) {
		return this.reservas.stream().filter(r -> r.getPeriodo().overlaps(periodo)).mapToDouble(r -> r.calcularPrecio(this.precioNoche)).sum();
	}
}
