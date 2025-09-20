package ar.edu.unlp.oo1.ejercicio4_BalanzaMejorada;

import java.time.LocalDate;
import java.util.ArrayList;

public class Ticket {
	private LocalDate fecha;
	private ArrayList<Producto> productos;
	
	public Ticket(ArrayList<Producto> productos) {
		this.fecha = LocalDate.now(); 
		this.productos = new ArrayList<Producto>();
		for (Producto p : productos) {
			this.productos.add(new Producto(p.getDescripcion(), p.getPeso(), p.getPrecioPorKilo()));
		}
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public ArrayList<Producto> getProductos(){
		return this.productos;
	}
	
	//Metodos
	public double getPrecioTotal() {
		return productos.stream().mapToDouble(p -> p.getPrecio()).sum();
	}
	
	public double getPesoTotal() {
		return productos.stream().mapToDouble(p -> p.getPeso()).sum();
	}
	
	public int getCantidadDeProductos() {
		return this.productos.size();
	}
	
	public double impuesto() {
		return this.getPrecioTotal() * 0.21;
	}
}
