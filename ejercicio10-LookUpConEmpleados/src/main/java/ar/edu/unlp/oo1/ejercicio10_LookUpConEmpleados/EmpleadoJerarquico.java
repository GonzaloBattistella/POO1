package ar.edu.unlp.oo1.ejercicio10_LookUpConEmpleados;

public class EmpleadoJerarquico extends Empleado{

	public EmpleadoJerarquico(String nombre) {
		super(nombre);
	}
	
	@Override
	public double montoBasico() {
		return 45000;
	}
	
	public double bonoPorCategoria() {
		return 8000;
	}
	
	
	@Override
	public double sueldoBasico() {
		return super.sueldoBasico() + this.bonoPorCategoria();
	}
	
}
