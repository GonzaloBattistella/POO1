package interfaceDateLapse;

import java.time.LocalDate;

public interface DateLapseInterface {
	public LocalDate getFrom();
	public LocalDate getTo();
	public Integer sizeInDays();
	public boolean includesDate(LocalDate other);
}
