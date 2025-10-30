package ar.edu.unlp.oo1.ejercicio12_JobScheduler;

import java.util.List;

public class LIFO {
	public LIFO() {}
	
	public JobDescription next(List<JobDescription> jobs) {
		if (jobs == null || jobs.isEmpty()) {
			return null;
		}
		
		return jobs.remove(jobs.size() - 1); //Retorno el Job y lo elimino de la lista.
	}

}
