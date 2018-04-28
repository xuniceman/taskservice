package com.gcexe.monitor.taskservice.jms;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.apache.activemq.broker.jmx.BrokerViewMBean;
import org.apache.activemq.broker.jmx.TopicViewMBean;


public class ActiveMQMonitor {

	public static void main(String[] args) throws Exception {
		JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:11099/jmxrmi");
		JMXConnector connector = JMXConnectorFactory.connect(url, null);
		connector.connect();
		MBeanServerConnection connection = connector.getMBeanServerConnection();

		ObjectName name = new ObjectName("myDomain:brokerName=broker,type=Broker");
		BrokerViewMBean mBean = (BrokerViewMBean) MBeanServerInvocationHandler.newProxyInstance(connection, name,
				BrokerViewMBean.class, true);
//		mBean.removeTopic("ipTopic");
//		mBean.removeTopic("keyTopic");
		
		 
		for (ObjectName topicName : mBean.getTopics()) {
			TopicViewMBean topicMBean = (TopicViewMBean) MBeanServerInvocationHandler.newProxyInstance(connection,
					topicName, TopicViewMBean.class, true);
//			// 消息队列名称
//			System.out.println("队列名称 --- " + topicMBean.getName());
//			// 待消费数
//			System.out.println("待消费数量：" + topicMBean.getQueueSize());
//			// 入队数
//			System.out.println("入队列的数量：" + topicMBean.getEnqueueCount());
//			// 出队数
//			System.out.println("出队列的数量：" + topicMBean.getDequeueCount());
//			// 消费者数
//			System.out.println("消费者数：" + topicMBean.getConsumerCount());
			System.out.println(topicMBean.browseMessages().size());
			
			
//			for (int i = 0; i < datas.length; i++) {
//				CompositeData data = datas[i];
//				String value = "";
//				// mq中消息数据存储方式为key-value形式，
//				// 获取消息内容可根据key来取得，不同的消息类型有不同的key: Text Message key - Text; Map Message key -
//				// ContentMap
//				if (data.containsKey("Text")) {
//					value = (String) data.get("Text");
//				} else if (data.containsKey("ContentMap")) {
//					value = (String) data.get("ContentMap");
//				}
//				System.out.println(value);
//				System.out.println(data.containsValue("{task_id=15, user_id=0, site_name=www.baidu.com, priority=9}"));
//			}
		} 

	}

}
