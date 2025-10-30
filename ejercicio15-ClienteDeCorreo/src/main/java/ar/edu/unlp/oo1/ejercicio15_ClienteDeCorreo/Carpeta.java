package ar.edu.unlp.oo1.ejercicio15_ClienteDeCorreo;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {
	private String nombre;
	private List<Email> emails;
	
	public Carpeta(String nombre) {
		this.nombre = nombre;
		this.emails = new ArrayList<Email>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Email> getEmails() {
		return emails;
	}
	
	public void agregarEmail(Email email) {
		this.emails.add(email);
	}
	
	public void mover(Email email, Carpeta destino) {
		this.emails.remove(email);
		destino.agregarEmail(email);
	}
	
	public Integer getEspacioCarpeta() {
		return this.emails.stream().mapToInt(e -> e.getTamaño()).sum();
	}
	
	public Email buscarEmail(String texto) {
		return this.emails.stream().filter(e -> e.contieneTexto(texto)).findFirst().orElse(null);
	}
}
