package ar.edu.unlp.oo1.ejercicio8_GenealogiaSalvaje;

import java.time.LocalDate;

public class Mamifero {
	private String identificador;
	private String especie;
	private LocalDate fechaNacimiento;
	private Mamifero padre;
	private Mamifero madre;
	
	public Mamifero() {}
	
	public Mamifero (String id) {
		this.identificador = id;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Mamifero getPadre() {
		return padre;
	}

	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}

	public Mamifero getMadre() {
		return madre;
	}

	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}
	
	public Mamifero getAbueloMaterno() {
		if(this.madre != null) {
			return this.madre.getPadre();
		}
		return null;
	}
	
	public Mamifero getAbuelaMaterna() {
		if(this.madre != null) {
			return this.madre.getMadre();
		}
		return null;
	}
	
	public Mamifero getAbueloPaterno() {
		if(this.padre != null) {
			return this.padre.getPadre();
		}
		return null;
	}
	
	public Mamifero getAbuelaPaterna() {
		if(this.madre != null) {
			return this.padre.getMadre();
		}
		return null;
	}
	
	public boolean tieneComoAncestroA(Mamifero unMamifero) {
		//Caso base: Si el padre o madre es el mamifero buscado
		if((this.getPadre() != null && this.getPadre().equals(unMamifero)) || (this.getMadre() != null && this.getMadre().equals(unMamifero))) {
			return true;
		}
		
		return (this.getPadre() != null && this.getPadre().tieneComoAncestroA(unMamifero)) || (this.getMadre() != null && this.getMadre().tieneComoAncestroA(unMamifero));
	}
}
