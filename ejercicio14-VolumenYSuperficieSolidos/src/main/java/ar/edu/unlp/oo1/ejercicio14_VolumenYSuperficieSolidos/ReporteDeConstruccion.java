package ar.edu.unlp.oo1.ejercicio14_VolumenYSuperficieSolidos;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeConstruccion {
	private List<Pieza> piezas;
	
	public ReporteDeConstruccion() {
		this.piezas = new ArrayList<Pieza>();
	}

	public List<Pieza> getPiezas() {
		return piezas;
	}

	public void agregarPieza(Pieza pieza) {
		this.piezas.add(pieza);
	}
	
	public double volumenDeMaterial(String material) {
		return this.piezas.stream().filter(p -> p.getMaterial().equals(material)).mapToDouble(p -> p.getVolumen()).sum();
	}
	
	public double superficieDeColor(String color) {
		return this.piezas.stream().filter(p -> p.getColor().equals(color)).mapToDouble(p -> p.getSuperficie()).sum();
	}
}
