package com.gcexe.monitor.taskservice.jms;

import java.util.ArrayList;
import java.util.List;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.region.policy.ConstantPendingMessageLimitStrategy;
import org.apache.activemq.broker.region.policy.PolicyEntry;
import org.apache.activemq.broker.region.policy.PolicyMap;

public class ActiveMQMonitor {
		
	/** 
     * 创建一个配置策略 
     * @param strategy 
     * @return 
     */  
    private PolicyEntry createPolicyEntry(ConstantPendingMessageLimitStrategy strategy) {  
        PolicyEntry policy = new PolicyEntry();  
        policy.setAdvisoryForDelivery(true);  
        policy.setAdvisoryForDiscardingMessages(true);  
        policy.setAdvisoryForSlowConsumers(true);  
        policy.setAdvisoryWhenFull(true);  
        policy.setProducerFlowControl(false);  
        policy.setPendingMessageLimitStrategy(strategy);  
        return policy;  
    }  
	public static void main(String[] args) {
		
//		BrokerService answer = new BrokerService();
//		//创建持久化信息  
//        answer.setPersistent(false);  
//        //设置采用JMX管理  
//        answer.setUseJmx(true);     
//        answer.setDestinationPolicy(pMap);  
//        //绑定url  
//        answer.addConnector("tcp://localhost:61619");  
//        answer.setDeleteAllMessagesOnStartup(true);  
//        
//        
//        
//        
//        ConstantPendingMessageLimitStrategy strategy = new ConstantPendingMessageLimitStrategy();  
//        strategy.setLimit(10);  
//        
//        PolicyEntry tempQueueEntry = createPolicyEntry(strategy);  
//        tempQueueEntry.setTempQueue(true);  
//        
//        PolicyEntry tempTopicEntry = createPolicyEntry(strategy);  
//        tempTopicEntry.setTempTopic(true);  
//        
//        PolicyMap pMap = new PolicyMap();  
//        final List<PolicyEntry> policyEntries = new ArrayList<PolicyEntry>();  
//        policyEntries.add(tempQueueEntry);  
//        policyEntries.add(tempTopicEntry);  
//        pMap.setPolicyEntries(policyEntries);  
        
	}

}
