package ar.edu.unlp.oo1.ejercicio19_AlquilerDePropiedades;

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
	
	public boolean reservar(Inmueble propiedad, DateLapse periodo) {
		if (propiedad.estaDisponible(periodo)) {
			Reserva reserva = new Reserva(this, propiedad, periodo);
			this.reservas.add(reserva);
			propiedad.agregarReserva(reserva);
			return true;
		}
		return false;
	}
	
	
	public boolean cancelarReserva(Reserva reserva) {
		if (this.reservas.contains(reserva)) {
			this.reservas.remove(reserva);
			return true;
		}
		
		return false;
	}
	
	public double calcularRetribucionEnPeriodo(DateLapse periodo) {
		double total = this.propiedades.stream().mapToDouble(p -> p.calcularTotalReservas(periodo)).sum();
		
		return total * 0.75; // 75% del total de las ganancias.
	}
}
