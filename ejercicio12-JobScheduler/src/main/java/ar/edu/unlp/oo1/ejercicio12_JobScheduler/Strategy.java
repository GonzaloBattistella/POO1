package ar.edu.unlp.oo1.ejercicio12_JobScheduler;

import java.util.ArrayList;

public interface Strategy {
	public JobDescription next(ArrayList<JobDescription> jobs);
}
