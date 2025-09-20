package ar.edu.unlp.oo1.ejercicio5_Inversores;

import java.util.ArrayList;

public class Inversor {
	private String nombre;
	private ArrayList<Inversion> inversiones;
	
	public Inversor(String nombre) {
		this.nombre = nombre;
		this.inversiones = new ArrayList<Inversion>();
	}
	

	//Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//Metodos
	public void agregarInversion(Inversion unaInversion) {
		this.inversiones.add(unaInversion);
	}
	
	public void eliminarInversion(Inversion unaInversion) {
		this.inversiones.remove(unaInversion);
	}
	
	public double calcularValorActualTotal() {
		return this.inversiones.stream().mapToDouble(inv -> inv.calcularValorActual()).sum();
	}
}
