package ar.edu.unlp.oo1.ejercicio9_RedAlumbrado;

import java.util.ArrayList;
import java.util.List;

public class Farola {
	private boolean estado;
	private List<Farola> vecinas;
	
	
	/*
	* Crear una farola. Debe inicializarla como apagada
	*/
	public Farola() {
		this.estado = false;
		this.vecinas = new ArrayList<Farola>();
	}

	/*
	* Crea la relación de vecinos entre las farolas. La relación de vecinos entre las farolas es recíproca, es decir el receptor del mensaje será vecino de otraFarola, al igual que otraFarola también se convertirá en vecina del receptor del mensaje
	*/
	public void pairWithNeighbor( Farola otraFarola ) {
		if(!this.vecinas.contains(otraFarola)) {
			this.vecinas.add(otraFarola);
		}
		
		if(!otraFarola.getNeighbors().contains(this)) {
			otraFarola.getNeighbors().add(this);
		}
	}

	/*
	* Retorna sus farolas vecinas
	*/
	public List<Farola> getNeighbors (){
		return this.vecinas;
	}


	/*
	* Si la farola no está encendida, la enciende y propaga la acción.
	*/
	public void turnOn() {
		if(!this.estado){
			this.estado = true;
			for(Farola f: vecinas) {
				f.turnOn();
			}
		}
	}

	/*
	* Si la farola no está apagada, la apaga y propaga la acción.
	*/
	public void turnOff() {
	  if(this.estado) {
		  this.estado = false;
		  for(Farola f: vecinas) {
			  f.turnOff();
		  }
	  }	
	}

	/*
	* Retorna true si la farola está encendida.
	*/
	public boolean isOn() {
		return this.estado;
	}
	/*
	* Retorna true si la farola está apagada.
	*/
	public boolean isOff() {
		if(! this.estado) {
			return true;
		}
		
		return false;
	}

}
