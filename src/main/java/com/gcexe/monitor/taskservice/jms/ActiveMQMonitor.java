package com.gcexe.monitor.taskservice.jms;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.openmbean.CompositeData;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.apache.activemq.broker.jmx.BrokerViewMBean;
import org.apache.activemq.broker.jmx.QueueViewMBean;
import org.apache.activemq.command.Message;

public class ActiveMQMonitor {

	public static void main(String[] args) throws Exception {
		JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi");
		JMXConnector connector = JMXConnectorFactory.connect(url, null);
		connector.connect();
		MBeanServerConnection connection = connector.getMBeanServerConnection();

		ObjectName name = new ObjectName("mydomain:brokerName=mybroker,type=Broker");
		BrokerViewMBean mBean = (BrokerViewMBean) MBeanServerInvocationHandler.newProxyInstance(connection, name,
				BrokerViewMBean.class, true);
		// mBean.removeTopic("ipTopic");
		// mBean.removeTopic("keyTopic");
		for (ObjectName topicName : mBean.getQueues()) {
			QueueViewMBean topicMBean = (QueueViewMBean) MBeanServerInvocationHandler.newProxyInstance(connection,
					topicName, QueueViewMBean.class, true);

			// 消息队列名称
			System.out.println("队列名称 --- " + topicMBean.getName());
			// 待消费数
			System.out.println("待消费数量：" + topicMBean.getQueueSize());
			// 入队数
			System.out.println("入队列的数量：" + topicMBean.getEnqueueCount());
			// 出队数
			System.out.println("出队列的数量：" + topicMBean.getDequeueCount());
			// 消费者数
			System.out.println("消费者数：" + topicMBean.getConsumerCount());
			System.out.println(topicMBean.getMemoryUsageByteCount());
			System.out.println(topicMBean.getMemoryLimit());
			System.out.println(topicMBean.getMemoryPercentUsage());
			CompositeData[] datas = topicMBean.browse();
			for (int i = 0; i < datas.length; i++) {
				CompositeData data = datas[i];
				String value = "";

				value = (String) data.get("JMSMessageID");
				System.out.println(value + "+++" + data.get("JMSRedelivered"));
				if(!(boolean)data.get("JMSRedelivered"))
				{
					topicMBean.removeMessage(value);
				}
			}
		}

	}

}
