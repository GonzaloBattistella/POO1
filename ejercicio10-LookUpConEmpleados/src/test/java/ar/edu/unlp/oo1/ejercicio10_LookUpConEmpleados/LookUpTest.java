package ar.edu.unlp.oo1.ejercicio10_LookUpConEmpleados;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LookUpTest {
	private Gerente Alan;
	
	@BeforeEach
	void setUp() throws Exception{
		this.Alan = new Gerente("Alan Turing");
	}
	
	@Test
	void aportesTest() {
		assertEquals(2850, this.Alan.aportes());
	}
	
	@Test
	void sueldoBasicoTest() {
		assertEquals(67850, this.Alan.sueldoBasico());
	}

}
