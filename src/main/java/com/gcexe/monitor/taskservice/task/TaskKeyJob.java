package com.gcexe.monitor.taskservice.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gcexe.monitor.taskservice.jms.JMSTool;

public class TaskKeyJob implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {

		@SuppressWarnings("resource")
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:jms-context.xml");
		JMSTool jmsTool = (JMSTool) app.getBean("jsmTool");
		jmsTool.sendKeyMessage("key queues.....");

		System.out.println("添加任务=======key消息加入队列");
	}

}
