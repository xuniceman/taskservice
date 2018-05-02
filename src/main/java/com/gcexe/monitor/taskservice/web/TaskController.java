package com.gcexe.monitor.taskservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.gcexe.monitor.taskservice.task.TaskIPJob;

import com.gcexe.monitor.taskservice.task.TaskTool;


@Controller
@RequestMapping("task")
public class TaskController {
	
	@Autowired
	TaskTool quartzTool;
	
	@RequestMapping(value = "/startjob", method = RequestMethod.GET)
	public String startjob() {
		
		quartzTool.addJob("ip1", "ip", "ip1","ip", TaskIPJob.class, "0/1 * * * * ?");
	
		return "home";
	}
	@RequestMapping(value = "/stopjob", method = RequestMethod.GET)
	public String stopjob() {
		
		quartzTool.removeJob("ip1", "ip", "ip1","ip");

		
		return "home";
	}
	
}
