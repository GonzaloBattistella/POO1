package ar.edu.unlp.oo1.ejercicio16_IntervaloDeTiempo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import interfaceDateLapse.DateLapseInterface;

public class DateLapse implements DateLapseInterface{
	private LocalDate from;
	private LocalDate to;
	
	public DateLapse(LocalDate from, LocalDate to) {
		this.from = from;
		this.to = to;
	}

	public LocalDate getFrom() {
		return from;
	}

	public LocalDate getTo() {
		return to;
	}
	
	public Integer sizeInDays() {
		return (int) ChronoUnit.DAYS.between(from, to); 	
	}
	
	public boolean includesDate(LocalDate other) {
		return (other.isEqual(from) || other.isAfter(from)) && (other.isEqual(to) || other.isBefore(to));
	}
	
	public boolean overlaps(DateLapse periodo) {
		return !this.getTo().isBefore(periodo.getFrom()) && !this.getFrom().isAfter(periodo.getTo());
	}
	
	public Integer cantDaysTo() {
		//Retorna la cantidad de dias que hay entre la fecha actual y el inicio del periodo recibido como parametro.
		return (int) ChronoUnit.DAYS.between(LocalDate.now(), this.getFrom());
	}
}
