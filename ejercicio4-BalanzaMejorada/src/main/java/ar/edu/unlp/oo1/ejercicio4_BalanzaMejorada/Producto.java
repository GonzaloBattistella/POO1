package ar.edu.unlp.oo1.ejercicio4_BalanzaMejorada;

public class Producto {
	private double peso;
	private double precioPorKilo;
	private String descripcion;
	
	public Producto(String descripcion, double peso, double precioPorKilo) {
		this.descripcion = descripcion;
		this.peso = peso;
		this.precioPorKilo = precioPorKilo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPrecioPorKilo() {
		return precioPorKilo;
	}
	
	public double getPrecio() {
		return this.peso * this.precioPorKilo;
	}

	public void setPrecioPorKilo(double precioPorKilo) {
		this.precioPorKilo = precioPorKilo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
