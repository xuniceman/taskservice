package com.gcexe.monitor.taskservice.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class JMSToolImpl implements JMSTool {


	private JmsTemplate ipJmsQueueTemplate;
	
	private JmsTemplate keyTopicDestination;

	public void sendIPMessage(String str) {
		ipJmsQueueTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(str);
			}
		});
	}

	public void sendKeyMessage(String str) {
		keyTopicDestination.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(str);
			}
		});
	}

	
	public JmsTemplate getIpJmsQueueTemplate() {
		return ipJmsQueueTemplate;
	}

	public void setIpJmsQueueTemplate(JmsTemplate ipJmsQueueTemplate) {
		this.ipJmsQueueTemplate = ipJmsQueueTemplate;
	}

	public JmsTemplate getKeyTopicDestination() {
		return keyTopicDestination;
	}

	public void setKeyTopicDestination(JmsTemplate keyTopicDestination) {
		this.keyTopicDestination = keyTopicDestination;
	}

}
