package ar.edu.unlp.oo1.ejercicio7_Figuras_Cuerpos;

import java.lang.Math;

public class Circulo implements Figura{
	private double radio;
	
	public Circulo() {}
	
	public Circulo(double radio)  {
		this.radio = radio;
	}
	
	public double getDiametro() {
		return this.radio * 2;
	}
	
	public double getPerimetro() {
		return Math.PI * this.getDiametro();
	}
	
	public double getArea() {
		return Math.PI * Math.pow(radio,2);
	}
	
	public double getRadio() {
		return  this.radio;
	}
	
	public void setRadio(double radio) {
		this.radio = radio;
	}
}
