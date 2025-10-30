package ar.edu.unlp.oo1.ejercicio13_ImplementarInversores;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PlazoFijo implements Inversion{
	private LocalDate fechaInicio;
	private double montoDepositado;
	private double interesDiario;
	
	public PlazoFijo(double montoDepositado, double porcentaje) {
		this.fechaInicio = LocalDate.now();
		this.montoDepositado = montoDepositado;
		this.interesDiario = porcentaje;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public double getMontoDepositado() {
		return montoDepositado;
	}

	public double getInteresDiario() {
		return this.interesDiario;
	}

	public double calcularValorActual() {
		long dias = ChronoUnit.DAYS.between(fechaInicio, LocalDate.now());
		return this.montoDepositado * Math.pow(1 + this.interesDiario, dias);
	} 
}
