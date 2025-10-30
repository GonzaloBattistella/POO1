package ar.edu.unlp.oo1.ejercicio14_VolumenYSuperficieSolidos;

public class Cilindro extends Pieza{
	private double radio;
	private double altura;
	
	public Cilindro(String material, String color, double radio, double altura) {
		super(material, color);
		this.radio = radio;
		this.altura = altura;
	}
	
	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getVolumen() {
		return Math.PI * Math.pow(radio, 2) * this.altura;
	}
	
	public double getSuperficie() {
		return (2 * Math.PI * this.radio * this.altura) + (2 * Math.PI * Math.pow(radio, 2));
	}
}
