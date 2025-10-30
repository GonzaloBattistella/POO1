package ar.edu.unlp.oo1.ejercicio19_AlquilerDePropiedades;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import ar.edu.unlp.oo1.ejercicio16_IntervaloDeTiempo.DateLapse;

public class ReservaTest {
	private Usuario usuario;
	private Inmueble inmueble;
	private Reserva reserva;
	
	@BeforeEach
	void setUp() {
		this.usuario = new Usuario("Gonzalo", "12 y 54", "44555666");
		this.inmueble  = new Inmueble("11 y 64", "Casa con patio", 45);
	}
	
	@Test
	void enCursoTest() {
		//Limite Inferior
		DateLapse periodo1 = new DateLapse(LocalDate.of(2025, 10, 30), LocalDate.of(2025, 11, 2));
		this.reserva = new Reserva(usuario, inmueble, periodo1);
		assertTrue(this.reserva.enCurso());
		
		//Limite Superior
		DateLapse periodo2 = new DateLapse(LocalDate.of(2025, 10, 27), LocalDate.of(2025, 10, 30));
		this.reserva = new Reserva(usuario, inmueble, periodo2);
		assertTrue(this.reserva.enCurso());
		
		//Fuera de Periodo
		DateLapse periodo3 = new DateLapse(LocalDate.of(2025, 11, 3), LocalDate.of(2025, 11, 6));
		this.reserva = new Reserva(usuario, inmueble, periodo3);
		assertFalse(this.reserva.enCurso());
	}
	
	@Test
	void puedeCancelarTest() {
		//Hay una reserva en curso
		DateLapse periodo1 = new DateLapse(LocalDate.of(2025, 10, 27), LocalDate.of(2025, 11, 2));
		this.reserva = new Reserva(usuario, inmueble, periodo1);
		assertFalse(this.reserva.puedeCancelar());
		
		//NO hay Reserva en Curso
		DateLapse periodo2 = new DateLapse(LocalDate.of(2025, 11, 3), LocalDate.of(2025, 11, 8));
		this.reserva = new Reserva(usuario, inmueble, periodo2);
		assertTrue(this.reserva.puedeCancelar());
	}
}
