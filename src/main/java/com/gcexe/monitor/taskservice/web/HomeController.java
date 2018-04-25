package com.gcexe.monitor.taskservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gcexe.monitor.taskservice.task.TaskTool;
import com.gcexe.monitor.taskservice.jms.JMSTool;


@Controller
public class HomeController {
	
	@Autowired
	TaskTool quartzTool;
	
	@Autowired
	JMSTool jmsTool;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
//		quartzTool.addJob("ping1", "ping", "ping1","ping", TaskJob.class, "*/1 * * * * ?");
		
		jmsTool.sendMessage("hell world!");
		
		return "home";
	}
	
}
