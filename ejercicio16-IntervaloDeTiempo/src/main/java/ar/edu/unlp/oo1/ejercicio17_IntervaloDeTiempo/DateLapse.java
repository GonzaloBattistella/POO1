package ar.edu.unlp.oo1.ejercicio17_IntervaloDeTiempo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import interfaceDateLapse.DateLapseInterface;

public class DateLapse implements DateLapseInterface{
	private LocalDate from;
	private Integer sizeInDays;
	
	public DateLapse(LocalDate from, Integer sizeDays) {
		this.from = from;
		this.sizeInDays = sizeDays;
	}

	public LocalDate getFrom() {
		return from;
	}
	
	public LocalDate getTo() {
		return this.from.plusDays(this.sizeInDays());
	}

	public Integer sizeInDays() {
		return sizeInDays;
	}
	
	public boolean includesDate(LocalDate other) {
		return (other.isEqual(this.from) || other.isAfter(from)) && (other.isEqual(getTo()) || other.isBefore(getTo()));
	}
	
	public boolean overlaps(DateLapse periodo) {
		return !this.getTo().isBefore(periodo.getFrom()) && !this.getFrom().isAfter(periodo.getTo());
	}
	
	public Integer cantDaysTo(DateLapse periodo) {
		//Retorna la cantidad de dias que hay entre la fecha actual y el inicio del periodo recibido como parametro.
		return (int) ChronoUnit.DAYS.between(LocalDate.now(), periodo.getTo());
	}
}
