package com.gcexe.monitor.taskservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.gcexe.monitor.taskservice.task.TaskIPJob;
import com.gcexe.monitor.taskservice.task.TaskKeyJob;
import com.gcexe.monitor.taskservice.task.TaskTool;


@Controller
public class HomeController {
	
	@Autowired
	TaskTool quartzTool;
	
	
	
	@RequestMapping(value = "/startjob", method = RequestMethod.GET)
	public String startjob() {
		
		quartzTool.addJob("ip1", "ip", "ip1","ip", TaskIPJob.class, "*/50 * * * * ?");
		quartzTool.addJob("key1", "key", "key1","key", TaskKeyJob.class, "*/50 * * * * ?");	
		return "home";
	}
	@RequestMapping(value = "/stopjob", method = RequestMethod.GET)
	public String stopjob() {
		
		quartzTool.removeJob("ip1", "ip", "ip1","ip");
		quartzTool.removeJob("key1", "key", "key1","key");
		
		return "home";
	}
	
}
