package ar.edu.unlp.oo1.ejercicio11_CuentaConGanchos;

public class CajaDeAhorro extends Cuenta{
	public CajaDeAhorro() {
		super();
	}
	
	private double getCostoAdicional(double monto) {
		return monto * 0.002;
	}
	
	protected boolean puedeExtraer(double monto) {
		if(this.getSaldo() > (monto + this.getCostoAdicional(monto))) {
			return true;
		}
		
		return false;
	}
}
