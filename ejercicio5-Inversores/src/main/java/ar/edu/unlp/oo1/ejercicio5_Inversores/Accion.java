package ar.edu.unlp.oo1.ejercicio5_Inversores;

public class Accion implements Inversion{
	private String nombre;
	private Integer cantAcciones;
	private double valorUnitario;
	
	//CONSTRUCTOR
	public Accion(String nombre, Integer cantAcciones, double valorUnitario) {
		super();
		this.nombre = nombre;
		this.cantAcciones = cantAcciones;
		this.valorUnitario = valorUnitario;
	}
	
	

	//Getters & Setters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantAcciones() {
		return cantAcciones;
	}

	public void setCantAcciones(Integer cantAcciones) {
		this.cantAcciones = cantAcciones;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	//Metodos
	
	public double calcularValorActual() {
		return  this.cantAcciones * this.valorUnitario;
	}
		
}
