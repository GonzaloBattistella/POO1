package ar.edu.unlp.oo1.ejercicio19_AlquilerDePropiedades;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import ar.edu.unlp.oo1.ejercicio16_IntervaloDeTiempo.DateLapse;

public class InmuebleTest {
	private Usuario user;
	private Inmueble casa;
	
	@BeforeEach
	void setUp() {
		this.user = new Usuario("Gonzalo Battistella", "10 y 63", "44333222");
		this.casa = new Inmueble("53 e 3 y 4", "Casa con patio, 2 habitaciones", 45);
	}
	
	@Test
	void estaDisponibleTest() {
		DateLapse periodo = new DateLapse(LocalDate.of(2025, 11, 1), LocalDate.of(2025, 11, 6));
		this.user.agregarPropiedad(casa);
		this.user.reservar(casa, periodo); //Creo la reserva de un inmueble. La lista de reservas del inmueble contiene dicha reserva.
		
		//Periodo no se superpone con otras reservas.
		DateLapse periodoOK = new DateLapse(LocalDate.of(2025, 11, 7), LocalDate.of(2025, 11, 10));
		assertTrue(this.casa.estaDisponible(periodoOK));
		
		//Superposicion en Limite Inferior
		DateLapse periodoOverlapInf = new DateLapse(LocalDate.of(2025, 10, 29), LocalDate.of(2025, 11, 3));
		assertFalse(this.casa.estaDisponible(periodoOverlapInf));
		
		//Superposicion en Limite Superior
		DateLapse periodoOverlapSup = new DateLapse(LocalDate.of(2025, 11, 4), LocalDate.of(2025, 11, 11));
		assertFalse(this.casa.estaDisponible(periodoOverlapSup));
	}
	
	@Test
	void calcularTotalReservasTest() {
		DateLapse periodo = new DateLapse(LocalDate.of(2025, 10, 29), LocalDate.of(2025, 11, 3)); //5 dias
		DateLapse periodo2 = new DateLapse(LocalDate.of(2025, 11, 8), LocalDate.of(2025, 11, 13)); //5 dias
		DateLapse periodoReserva1 = new DateLapse(LocalDate.of(2025, 11, 5), LocalDate.of(2025, 11, 10)); //5 dias
		DateLapse periodoReserva2 = new DateLapse(LocalDate.of(2025, 11, 11), LocalDate.of(2025, 11, 20)); //9 dias
		
		//Sin reservas
		assertEquals(0, this.casa.calcularTotalReservas(periodo));
		
		//Agrego reservas
		this.user.reservar(casa, periodoReserva1);
		this.user.reservar(casa, periodoReserva2);
		
		//Reservas fuera de periodo
		assertEquals(0, this.casa.calcularTotalReservas(periodo));
		
		//Reservas En periodo
		//totalReserva1 = 45 * 5 = 225
		//totalReserva2 = 45 * 9 = 405
		//TotalReservas = 225 + 405 = 630
		assertEquals(630, this.casa.calcularTotalReservas(periodo2));
	}
}
