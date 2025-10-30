package ar.edu.unlp.oo1.ejercicio14_VolumenYSuperficieSolidos;

public abstract class Pieza {
	private String material;
	private String color;
	
	public Pieza(String material, String color) {
		this.material = material;
		this.color = color;
	}
	
	public abstract double getVolumen();
	public abstract double getSuperficie();
	
	public String getMaterial() {
		return this.material;
	}
	
	public String getColor() {
		return this.color;
	}
}
