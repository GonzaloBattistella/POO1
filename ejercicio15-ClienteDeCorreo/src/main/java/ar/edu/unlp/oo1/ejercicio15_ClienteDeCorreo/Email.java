package ar.edu.unlp.oo1.ejercicio15_ClienteDeCorreo;

import java.util.ArrayList;
import java.util.List;

public class Email {
	private String titulo;
	private String cuerpo;
	private List<Archivo> adjuntos;
	
	public Email(String titulo, String cuerpo) {
		this.cuerpo = cuerpo;
		this.titulo = titulo;
		this.adjuntos = new ArrayList<Archivo>();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public List<Archivo> getAdjuntos() {
		return this.adjuntos;
	}
	
	public void agregarAdjunto(Archivo archivo) {
		this.adjuntos.add(archivo);
	}
	
	public Integer getTamañoAdjuntos() {
		return this.adjuntos.stream().mapToInt(a -> a.tamaño()).sum();
	}
	
	public Integer getTamaño() {
		return this.cuerpo.length() + this.titulo.length() + this.getTamañoAdjuntos();
	}
	
	public boolean contieneTexto(String texto) {
		return this.cuerpo.contains(texto) || this.titulo.contains(texto);
	}
	
}
