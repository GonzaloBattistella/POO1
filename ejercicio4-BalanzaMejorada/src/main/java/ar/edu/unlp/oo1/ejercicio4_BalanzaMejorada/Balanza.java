package ar.edu.unlp.oo1.ejercicio4_BalanzaMejorada;

import java.util.ArrayList;

public class Balanza {
	
	private ArrayList<Producto> productos;
	
	public Balanza() {
		this.productos = new ArrayList<Producto>();
	}
	
	public ArrayList<Producto> getProductos(){
		return this.productos;
	}
	//Metodos 
	
	public void ponerEnCero() {
		this.productos.clear();
	}
	
	public void agregarProducto(Producto producto) {
		this.productos.add(producto);
	}
	
	public Ticket emitirTicket() {
		Ticket ticket = new Ticket(this.productos);
		this.ponerEnCero();
		return ticket;
	}
	
	public int getCantidadDeProductos() {
		return this.productos.size();
	}
	
	public double getPesoTotal() {
		return productos.stream().mapToDouble(p -> p.getPeso()).sum();
	}
	
	public double getPrecioTotal() {
		return productos.stream().mapToDouble(p -> p.getPrecio()).sum();
	}
}
