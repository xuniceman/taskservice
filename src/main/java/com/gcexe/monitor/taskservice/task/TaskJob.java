package com.gcexe.monitor.taskservice.task;



import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TaskJob implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("添加任务");
	}
	
}
