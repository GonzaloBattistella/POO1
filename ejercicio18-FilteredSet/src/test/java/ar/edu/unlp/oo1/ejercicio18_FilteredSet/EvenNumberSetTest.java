package ar.edu.unlp.oo1.ejercicio18_FilteredSet;

import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EvenNumberSetTest {
	private Set<Integer> numbers;
	
	@BeforeEach
	void setUp() {
		this.numbers = new EvenNumberSet();
	}
	
	@Test
	void testAdd() {
		assertFalse(numbers.add(1));
		assertTrue(numbers.add(2));
		assertTrue(numbers.add(4));
		assertFalse(numbers.add(2)); //No se agrega porque ya existe en el set.
	}
}
