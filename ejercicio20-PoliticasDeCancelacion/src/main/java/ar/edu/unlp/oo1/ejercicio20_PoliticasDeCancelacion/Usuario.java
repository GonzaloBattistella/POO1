package ar.edu.unlp.oo1.ejercicio20_PoliticasDeCancelacion;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.oo1.ejercicio16_IntervaloDeTiempo.DateLapse;

public class Usuario {
	private String nombre;
	private String direccion;
	private String dni;
	private List<Inmueble> propiedades;
	private List<Reserva> reservas;
	
	public Usuario (String nombre, String direccion, String dni) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
		this.propiedades = new ArrayList<Inmueble>();
		this.reservas = new ArrayList<Reserva>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Inmueble> getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(List<Inmueble> propiedades) {
		this.propiedades = propiedades;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getDni() {
		return dni;
	}
	
	public boolean agregarPropiedad(Inmueble unInmueble) {
		if (!this.propiedades.contains(unInmueble)) { //Si la propiedad no se encuentra en la lista, se agrega.
			this.propiedades.add(unInmueble);
			return true;
		}
		
		return false;
	}
	
	public boolean eliminarInmueble(Inmueble unInmueble) {
		return this.propiedades.remove(unInmueble);
	}
	
	public boolean reservar(Inmueble inmueble, DateLapse periodo) {
		if (inmueble.estaDisponible(periodo)) {
			Reserva reserva = new Reserva(this, inmueble, periodo);
			this.reservas.add(reserva);
			inmueble.agregarReserva(reserva);
			return true;
		}
		return false;
	}
	
	
	public double cancelarReserva(Reserva reserva) {
		this.reservas.remove(reserva);
		return reserva.getInmueble().cancelarReserva(reserva);
	}
	
	public double calcularRetribucionEnPeriodo(DateLapse periodo) {
		double total = this.propiedades.stream().mapToDouble(p -> p.calcularTotalReservas(periodo)).sum();
		
		return total * 0.75; // 75% del total de las ganancias.
	}
}