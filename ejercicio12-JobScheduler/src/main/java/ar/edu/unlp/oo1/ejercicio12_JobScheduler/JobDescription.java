package ar.edu.unlp.oo1.ejercicio12_JobScheduler;

public class JobDescription {

	private double effort;
	private int priority;
	
	public JobDescription() {
	}

	public JobDescription (double anEffort, int aPriority) {
		this.effort = anEffort;
		this.priority = aPriority;
	}

	public double getEffort() {
			return effort;
	}

	public int getPriority() {
		return priority;
	}

}
