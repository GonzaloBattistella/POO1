package ar.edu.unlp.oo1.ejercicio13_ImplementarInversores;

import java.util.ArrayList;
import java.util.List;

public class Inversor {
	private String nombre;
	private List<Inversion> Inversiones;
	
	public Inversor(String nombre) {
		this.nombre = nombre;
		this.Inversiones = new ArrayList<Inversion>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Inversion> getInversiones() {
		return Inversiones;
	}
	
	public double calcularValorTotalInversiones() {
		return this.Inversiones.stream().mapToDouble(i -> i.calcularValorActual()).sum();
	}
}
