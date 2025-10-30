package ar.edu.unlp.oo1.ejercicio15_ClienteDeCorreo;

import java.util.ArrayList;
import java.util.List;

public class ClienteDeCorreo {
	private Carpeta inbox;
	private List<Carpeta> carpetas;
	
	public ClienteDeCorreo () {
		this.carpetas = new ArrayList<Carpeta>();
		this.inbox = new Carpeta("inbox");
	}
	
	public List<Carpeta> getCarpetas(){
		List<Carpeta> carpetas = new ArrayList<Carpeta>(this.carpetas);
		carpetas.add(inbox);
		
		return carpetas;
	}
	
	public void recibir(Email email) {
		this.inbox.agregarEmail(email);
	}
	
	public void crearCarpeta(String nombre) {
		this.carpetas.add(new Carpeta(nombre));
	}
	
	public Integer espacioOcupado() {
		return this.getCarpetas().stream().mapToInt(c -> c.getEspacioCarpeta()).sum();
	}
	
	public Email buscar(String texto){
		return this.getCarpetas().stream().map(c -> c.buscarEmail(texto)).filter(e -> e != null).findFirst().orElse(null);
	}
}