package ar.edu.unlp.oo1.ejercicio14_VolumenYSuperficieSolidos;

public class Esfera extends Pieza{
	private double radio;
	
	public Esfera(String material, String color, double radio) {
		super(material, color);
		this.radio = radio;
	}
		
	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public double getVolumen() {
		return 4/3 * Math.PI * Math.pow(radio, 3);
	}
	
	public double getSuperficie() {
		return 4 * Math.PI * Math.pow(radio, 2);
	}
}
