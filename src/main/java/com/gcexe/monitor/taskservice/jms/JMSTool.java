package com.gcexe.monitor.taskservice.jms;

public interface JMSTool {

	public void sendMessage(String str);

	public Object receiveMessage();
}
