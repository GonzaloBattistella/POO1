package ar.edu.unlp.oo1.ejercicio12_JobScheduler;

import java.util.ArrayList;

public class FIFO implements Strategy {
	public FIFO() {
	}
	
	public JobDescription next(ArrayList<JobDescription> jobs) {
		if (jobs == null || jobs.isEmpty()) {
			return null;
		}
		
		JobDescription job = jobs.get(0); //Obtengo el primero de la lista.
		jobs.remove(0); //Borro el primer job de la lista.
		return job;
	}
}
