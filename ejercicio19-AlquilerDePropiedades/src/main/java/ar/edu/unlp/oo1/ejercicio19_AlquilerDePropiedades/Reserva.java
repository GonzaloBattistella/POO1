package ar.edu.unlp.oo1.ejercicio19_AlquilerDePropiedades;

import java.time.LocalDate;

import ar.edu.unlp.oo1.ejercicio16_IntervaloDeTiempo.DateLapse;

public class Reserva {
	private Usuario usuario;
	private Inmueble inmueble;
	private DateLapse periodo;
	
	public Reserva(Usuario usuario, Inmueble inmueble, DateLapse periodo) {
		this.usuario = usuario;
		this.inmueble = inmueble;
		this.periodo = periodo;
	}
	
	
	//Getters
	
	public Usuario getUsuario() {
		return usuario;
	}

	public Inmueble getInmueble() {
		return inmueble;
	}

	public DateLapse getPeriodo() {
		return periodo;
	}
	
	//Modulos
	
	public double calcularPrecio(double precioNoche) {
		return this.periodo.sizeInDays() * precioNoche;
	}
	
	public boolean enCurso() {
		return this.periodo.includesDate(LocalDate.now());
	}
	
	public boolean puedeCancelar() {
		if(!this.enCurso()) {
			return true;
		}
		return false;
	}
}