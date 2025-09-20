package ar.edu.unlp.oo1.ejercicio5_Inversores;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PlazoFijo implements Inversion{
	private LocalDate fechaInicio;
	private double montoDepositado;
	private double porcentajeInteres;
	
	//CONSTRUCTOR
	public PlazoFijo(double montoDepositado, double porcentajeInteres) {
		super();
		this.fechaInicio = LocalDate.now();
		this.montoDepositado = montoDepositado;
		this.porcentajeInteres = porcentajeInteres; //Interes Diario.
	}
	
	
	//Getters && Setters
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public double getMontoDepositado() {
		return montoDepositado;
	}

	public void setMontoDepositado(double montoDepositado) {
		this.montoDepositado = montoDepositado;
	}

	public double getPorcentajeInteres() {
		return porcentajeInteres;
	}

	public void setPorcentajeInteres(double porcentajeInteres) {
		this.porcentajeInteres = porcentajeInteres;
	}
	
	//Metodos
	public Integer diasTranscurridos() {
		LocalDate hoy = LocalDate.now();
		return (int)ChronoUnit.DAYS.between(this.fechaInicio, hoy);
	} 
	
	
	public double calcularValorActual() {
		int cantDias = this.diasTranscurridos();
		return this.montoDepositado * Math.pow(1 + this.porcentajeInteres, cantDias);
	}
}
