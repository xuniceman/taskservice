package com.gcexe.monitor.taskservice.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.stereotype.Component;
@Component("jmsMessageListener")
public class JMSMessageListener implements MessageListener {

	
	public void onMessage(Message message) {
		ObjectMessage msg = (ObjectMessage) message;
		try {
			System.out.println("消息内容："+ msg.getObject());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
