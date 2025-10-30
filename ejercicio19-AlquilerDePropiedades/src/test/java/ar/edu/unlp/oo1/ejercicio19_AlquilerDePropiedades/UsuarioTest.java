package ar.edu.unlp.oo1.ejercicio19_AlquilerDePropiedades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.oo1.ejercicio16_IntervaloDeTiempo.DateLapse;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;


public class UsuarioTest {
	private Usuario user;
	private Inmueble depto;
	private Inmueble casa;
	
	@BeforeEach
	void setUp() {
		this.user = new Usuario("Gonzalo Battistella", "10 esq 63", "44333222");
		this.depto = new Inmueble("12 e 49 y 50", "Departamento 2 habitaciones", 30);
		this.casa = new Inmueble("53 e 3 y 4", "Casa con patio, 2 habitaciones", 45);
	}
	
	
	@Test
	void testAgregarPropiedad() {
		assertTrue(this.user.agregarPropiedad(casa)); //Lista vacia
		assertTrue(this.user.agregarPropiedad(depto));//Inmueble, no se encuentra en la lista.
		assertFalse(this.user.agregarPropiedad(casa)); //Inmueble repetido, no se agrega.
	}
	
	@Test
	void testReservar() {
		DateLapse periodo = new DateLapse(LocalDate.of(2025, 10, 29), LocalDate.of(2025, 11, 4));
		DateLapse periodoOverlap = new DateLapse(LocalDate.of(2025, 11, 3), LocalDate.of(2025, 11, 10));
		
		assertTrue(this.user.reservar(casa, periodo)); //Lista Vacia
		assertTrue(this.user.reservar(depto, periodo)); //Propiedad Disponible
		assertFalse(this.user.reservar(casa, periodoOverlap)); //Propiedad Ocupada
	}
	
	@Test
	void testCalcularRetribucionEnPeriodo() {
		DateLapse periodo = new DateLapse(LocalDate.of(2025, 10, 29), LocalDate.of(2025, 11, 4)); //6 dias
		DateLapse periodoOut = new DateLapse(LocalDate.of(2025, 11, 11), LocalDate.of(2025, 11, 29));
		
		//Lista de Propiedades Vacia
		assertEquals(0, this.user.calcularRetribucionEnPeriodo(periodo));
		
		this.user.agregarPropiedad(casa);
		this.user.agregarPropiedad(depto);
		
		this.user.reservar(casa, periodo);
		this.user.reservar(depto, periodo);
		
		//Propiedades Fuera de Periodo
		assertEquals(0, this.user.calcularRetribucionEnPeriodo(periodoOut));
		
		//Propiedades dentro de Periodo
		// precio x Noche depto = 30 x 6(cant dias del periodo) = 180
		// precio x noche casa = 45 x 6 = 270
		// retribucion = 75% del total = 180 + 270 = 450 * 0.75 = 337.5
		assertEquals(337.5, this.user.calcularRetribucionEnPeriodo(periodo));
	}
}
