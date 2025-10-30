package ar.edu.unlp.oo1.ejercicio19_AlquilerDePropiedades;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.oo1.ejercicio16_IntervaloDeTiempo.DateLapse;

public class Inmueble {
	private String direccion;
	private String descripcion;
	private double precioNoche;
	private List<Reserva> reservas;
	
	public Inmueble(String direccion, String descripcion, double precioNoche) {
		this.direccion = direccion;
		this.descripcion = descripcion;
		this.precioNoche = precioNoche;
		this.reservas = new ArrayList<Reserva>();
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
	
	public boolean estaDisponible(DateLapse periodo) {
		return this.reservas.stream().noneMatch(r -> r.getPeriodo().overlaps(periodo));
	}
	
	public void agregarReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	public void cancelarReserva(Reserva reserva) {
		this.reservas.remove(reserva);
	}
	
	public double calcularTotalReservas(DateLapse periodo) {
		return this.reservas.stream().filter(r -> r.getPeriodo().overlaps(periodo)).mapToDouble(r -> r.calcularPrecio(this.precioNoche)).sum();
	}
}
