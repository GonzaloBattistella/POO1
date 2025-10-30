package ar.edu.unlp.oo1.ejercicio12_JobScheduler;

import java.util.ArrayList;

public class JobScheduler {
    protected ArrayList<JobDescription> jobs;
    protected Strategy strategy;

    public JobScheduler (Strategy aStrategy) {
        this.jobs = new ArrayList<>();
        this.strategy = aStrategy;
    }

    public void schedule(JobDescription job) {
        this.jobs.add(job);
    }

    public void unschedule(JobDescription job) {
        if (job != null) {
            this.jobs.remove(job);
        }
    }

    public Strategy getStrategy() {
        return this.strategy; 
    }

    public ArrayList<JobDescription> getJobs(){
        return this.jobs;
    }

    
    public JobDescription next() {
    	return this.strategy.next(this.getJobs());
    }

}
