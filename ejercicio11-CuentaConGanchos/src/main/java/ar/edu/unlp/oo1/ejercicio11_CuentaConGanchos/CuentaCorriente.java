package ar.edu.unlp.oo1.ejercicio11_CuentaConGanchos;

public class CuentaCorriente extends Cuenta{
	private double descubierto;
	
	public CuentaCorriente() {
		super();
		this.descubierto = 0;
	}
	
	
	public double getDescubierto() {
		return this.descubierto;
	}
	
	public void setDescubierto(double descubierto) {
		this.descubierto = descubierto;
	}
	
	protected boolean puedeExtraer(double monto) {
		if((this.getSaldo() + this.descubierto) > monto) {
			return true;
		}
		
		return false;
	}
}
