package ar.edu.unlp.oo1.ejercicio10_LookUpConEmpleados;

public class Empleado {
	private String nombre;
	
	public Empleado (String nombre) {
		this.nombre = nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public double montoBasico() {
		return 35000;
	}
	
	public double aportes() {
		return 13500;
	}
	
	public double sueldoBasico() {
		return this.montoBasico() + this.aportes();
	}
}
