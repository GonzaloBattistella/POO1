package ar.edu.unlp.oo1.ejercicio13_ImplementarInversores;

public class Accion implements Inversion{
	private String nombre;
	private Integer cantAcciones;
	private double valorUnitario;
	
	public Accion(String nombre, Integer cantAcciones, double valorUnitario) {
		this.nombre = nombre;
		this.cantAcciones = cantAcciones;
		this.valorUnitario = valorUnitario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Integer getCantAcciones() {
		return cantAcciones;
	}
	
	public double calcularValorActual() {
		return this.cantAcciones * this.valorUnitario;
	}
}
