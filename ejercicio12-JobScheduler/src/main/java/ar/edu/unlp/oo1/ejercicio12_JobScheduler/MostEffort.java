package ar.edu.unlp.oo1.ejercicio12_JobScheduler;

import java.util.List;

public class MostEffort {
	public MostEffort() {}
	
	public JobDescription next(List<JobDescription> jobs) {
		if(jobs == null || jobs.isEmpty()) {
			return null;
		}
		
		JobDescription job = jobs.stream().max((a, b) -> Double.compare(a.getEffort(), b.getEffort())).orElse(null);
		jobs.remove(job);
		return job;
	}
}
