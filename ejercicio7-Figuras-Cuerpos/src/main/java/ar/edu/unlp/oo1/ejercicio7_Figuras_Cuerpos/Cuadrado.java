package ar.edu.unlp.oo1.ejercicio7_Figuras_Cuerpos;

public class Cuadrado implements Figura{
	private double lado;
	
	public Cuadrado() {}
	
	public Cuadrado(double lado) {
		this.lado = lado;
	}
	
	public double getPerimetro() {
		return this.lado * 4;
	}
	
	public double getArea() {
		return Math.pow(this.lado,2);
	}
	
	public double getLado() {
		return this.lado;
	}
	
	public void setLado(double lado) {
		this.lado = lado;
	}
	
}
