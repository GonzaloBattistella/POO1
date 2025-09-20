package ar.edu.unlp.oo1.ejercicio3_Presupuestos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Presupuesto {
	private LocalDate fecha;
	private String cliente;
	private ArrayList<Item> items;
	
	public Presupuesto(String cliente) {
		this.cliente = cliente;
		this.fecha = LocalDate.now();
		this.items = new ArrayList<Item>();
	}
	
	//Getters & Setters
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	//Metodos
	public void agregarItem(Item item) {
		this.items.add(item);
	}
	
	
	public double calcularTotal() {
		double total = 0;
		
		for (Item item: items) {
			total += item.costo();
		}
		return total;
	}
}
