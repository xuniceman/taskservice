package com.gcexe.monitor.taskservice.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;

import org.apache.activemq.broker.jmx.BrokerViewMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class JMSToolImpl implements JMSTool {

	@Autowired
	JmsTemplate jmsTopicTemplate;

	public void sendMessage(String str) {
		jmsTopicTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(str);
			}
		});
	
	}

	
	public Object receiveMessage() {		
		try {
			ObjectMessage message = (ObjectMessage)jmsTopicTemplate.receive();
			//jmsTopicTemplate.
			
			return message.getObject();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void ss () {
		//BrokerViewMBean b;
	}
	
	
	
	
	
	
	
	

}
