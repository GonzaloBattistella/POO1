package ar.edu.unlp.oo1.ejercicio17_IntervaloDeTiempo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;                    

public class DateLapseTest {
	private DateLapse periodo;
	private LocalDate from;
		
	@BeforeEach
	void setUp() {
			from = LocalDate.of(2020, 1, 1);
			periodo = new DateLapse(from, 9);
		}
		
		@Test
		void sizeInDaysTest() {
			assertEquals(9, periodo.sizeInDays());
		}
		
		@Test
		void includesDateTest() {
			LocalDate fechaIntermedia = LocalDate.of(2020, 1, 5);
			LocalDate fechaFueraRango = LocalDate.of(2020, 1, 15);
			
			assertTrue(periodo.includesDate(fechaIntermedia));
			assertTrue(periodo.includesDate(from));
			assertTrue(periodo.includesDate(periodo.getTo()));
			assertFalse(periodo.includesDate(fechaFueraRango));
			
		}
}
