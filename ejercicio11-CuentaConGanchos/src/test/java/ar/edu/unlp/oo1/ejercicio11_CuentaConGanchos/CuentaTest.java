package ar.edu.unlp.oo1.ejercicio11_CuentaConGanchos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test; 

public class CuentaTest {
	private CajaDeAhorro cajaAhorro;
	private CuentaCorriente cuentaCorriente;
	
	@BeforeEach
	void setUp() throws Exception{
		this.cajaAhorro = new CajaDeAhorro();
		this.cuentaCorriente = new CuentaCorriente();
	}
	
	@Test
	void constructorTest() {
		assertEquals(this.cajaAhorro.getSaldo(), 0); //El saldo de una caja de Ahorro debe inicializrse en 0.
		assertEquals(this.cuentaCorriente.getSaldo(), 0); //El saldo de una cuenta corriente debe inicializarse en 0.
		assertEquals(this.cuentaCorriente.getDescubierto(), 0); //El descubierto Inicialmente debe ser 0.
	}
	
	@Test
	void depositarTest() {
		this.cajaAhorro.depositar(500);
		assertEquals(500, this.cajaAhorro.getSaldo());
		
		this.cuentaCorriente.depositar(600);
		assertEquals(600, this.cuentaCorriente.getSaldo());
	}
	
	@Test
	void CajaAhorroTest() {
		this.cajaAhorro.depositar(500);
		assertTrue(this.cajaAhorro.extraer(200), "Se deberia poder extraer, ya que el saldo es suficiente.");
		assertFalse(this.cajaAhorro.transferirACuenta(400, this.cuentaCorriente), "El saldo no es suficiente.");
		assertTrue(this.cajaAhorro.transferirACuenta(100, this.cuentaCorriente));
	}
	
	@Test
	void CuentaCorrienteTest() {
		this.cuentaCorriente.depositar(200);
		this.cuentaCorriente.setDescubierto(300);
		assertEquals(300, this.cuentaCorriente.getDescubierto());
		assertFalse(this.cuentaCorriente.extraer(600), "Excede el saldo y el descubierto otorgado");
		assertTrue(this.cuentaCorriente.extraer(300), "Se puede, ya que no excede el descubierto permitido");
		assertFalse(this.cuentaCorriente.transferirACuenta(300, this.cajaAhorro));
		assertTrue(this.cuentaCorriente.transferirACuenta(150, this.cajaAhorro));
	}
}
