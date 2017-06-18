/**
 * 
 */
package com.suse.www.test.activiti;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiTestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.impl.Log4jLoggerFactory;
import org.springframework.util.CollectionUtils;

import com.suse.www.mongo.entity.User;
import com.suse.www.test.util.Constants;;


/**
 * @author Administrator
 *
 */
public class TestActiviti extends  ActivitiTestCase {

	public static final String processFlowName = "请假流程";
	public static final String diagramsResource = "MyProcess.bpmn";
	public static final String processId = "helloWorld";
	
	Logger log = new Log4jLoggerFactory().getLogger("");
	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	/**
	 * 1.流程部署定义
	*/
	@Test
	public void deployFlow(){
		
		Deployment deployment = processEngine.getRepositoryService()
					.createDeployment()
					.name(processFlowName)
					.addClasspathResource(diagramsResource)
					.deploy();
		log.info(deployment.getId());
		log.info(deployment.getName());
		
	}
	/**
	 * 2.启动流程
	 */
	@Test
	public void flowStart(){
		
		RuntimeService runtimeService = processEngine.getRuntimeService();
		
		//使用流程定义中的key启动流程实例，可以对应diagramsResource中的id
		
		ProcessInstance processInstance = runtimeService
									.startProcessInstanceByKey(processId);
		//流程实例ID
		log.info("process ID:  "+processInstance.getId()); //10001
		//流程定义ID
		log.info("deployment ID:   "+processInstance.getDeploymentId());
		RepositoryService repositoryService	= processEngine.getRepositoryService();
		ProcessDefinition processDefinition = repositoryService
									.getProcessDefinition(processInstance.getDeploymentId());
		//流程定义ID
		log.info("process definition ID:  "+processDefinition.getKey());
		log.info("process definition key:   "+processDefinition.getKey());
		
	}
	/**
	 * 3.流程变量操作：设置流程变量
	 */
	@Test
	public void setFolwVariables(){ //流程启动的时候就赋值
		String processDefinitionKey = "";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 1);
		map.put("user", new User());
		String setFlowVariableValueMode = Constants.AFTERFLOWSTART;
		String taskId = "";
		Map<String, Object> mapVariable = new HashMap<String, Object>();
		switch (setFlowVariableValueMode.toUpperCase()) {
		case Constants.WHENFLOWSTART:
				this.doWhenFlowStartSetVariables(processDefinitionKey,map);
			break;
		case Constants.AFTERFLOWSTART:
				this.doAfterFlowStartSetVariables(taskId,mapVariable);
			break;
		default:
			this.doAfterFlowStartSetVariables(taskId,mapVariable);
			break;
		}
		
	}
	
	/**
	 * 3.流程变量操作：查询流程变量
	 */
	@Test
	public void getFlowVariables(){
		String taskId = "";
		List<String> listVariableName = new ArrayList<String>();
		listVariableName.add("createDate");
		listVariableName.add("createById");
		listVariableName.add("isLong");
		listVariableName.add("isFloat");
		listVariableName.add("user");
		listVariableName.add("createByName");
		
		this.doGetFlowVariables(taskId,listVariableName);
		
	}
	/**
	 * 4.查询当前人任务
	*/
	@Test
	public void findPersonTaskByAssignee(){
		
		String assignee = "张三" ;
		this.doFindMyPersonTask(assignee);
}
	/**
	 * 5.完成任务 将任务向下一布推送
	*/
	@Test
	public void completeTask(){
		String taskId = "";
		this.doCompleteTask(taskId);
	}
	/**
	 * 6.查询流程定义
	 */
	@Test
	public void findProcessDefinition(){
		Map<String , String> map = new HashMap<String, String>();
		map.put("deploymentId", "");
		map.put("processDefinitionId", "");
		map.put("processDefinitionKey", "");
		map.put("processDefinitionKeyLike", "");
		
		this.doFindProcessDefinition(map);
		
	}
	/**
	 * 7.删除流程定义
	 */
	@Test
	public void deleteProcessDefiniton(){
		
		String deploymentId = "";
		boolean cascade = true; //级联删除是否启动
		
		this.doDeleteProcessDefinition(deploymentId,cascade);
	}
	
	/**
	 * @param deploymentId
	 * @param cascade 级联删除是否启动
	 */
	private void doDeleteProcessDefinition(String deploymentId, boolean cascade) {
		RepositoryService repositoryService = processEngine.getRepositoryService();
		/**
		 * 只能删除没有启动的流程，如果为启动流程 则抛出异常
		 */
		repositoryService.deleteDeployment(deploymentId, cascade);
		
		log.info("删除流程定义 成功！");
		
	}
	/**
	 * @param map
	 */
	private List<ProcessDefinition> doFindProcessDefinition(Map<String, String> map) {

		if(CollectionUtils.isEmpty(map)){
			log.info("查询流程定义传入值为空！");
			throw new RuntimeException("查询流程定义传入值不能空！");
		}
		String deploymentId = map.get("deploymentId");
		String processDefinitionId = map.get("processDefinitionId");
		String processDefinitionKey = map.get("processDefinitionKey");
		String processDefinitionKeyLike = map.get("processDefinitionKeyLike");
		List<ProcessDefinition> listProcessDefinition = processEngine.getRepositoryService()
					.createProcessDefinitionQuery() 
					/** 指定查询条件 */
					.deploymentId(deploymentId)
					.processDefinitionId(processDefinitionId)
					.processDefinitionKey(processDefinitionKey)
					.processDefinitionKeyLike(processDefinitionKeyLike)
					/** 排序 */
					.orderByProcessDefinitionVersion().asc()
					/** 返回结果集 */
					.list();	//返回list集
//					.listPage(firstResult, maxResults) //分页查询
//					.count()	//返回结果集数量
//					.singleResult() //返回一个唯一结果
					
		 if ( !CollectionUtils.isEmpty(listProcessDefinition) ) {
			 log.info("----------------流程结果集 ------------------------");
			 for (ProcessDefinition processDefinition : listProcessDefinition){
				 log.info("流程定义ID:  "+processDefinition.getId());
				 log.info("流程定义的名称:  "+processDefinition.getName());
				 log.info("流程定义的key:  "+processDefinition.getKey());
				 log.info("流程定义的版本:  "+processDefinition.getVersion());
				 log.info("资源名称bpmn文件:  "+processDefinition.getResourceName());
				 log.info("资源名称png文件:  "+processDefinition.getDiagramResourceName());
				 log.info("部署ID:  "+processDefinition.getDeploymentId());
			 }
			 log.info("--------------------end--------------------");
		 }
		return listProcessDefinition;
	}
	/**
	 * @param taskId
	 */
	private void doCompleteTask(String taskId) {
		processEngine.getTaskService()	//获取任务service
			.complete(taskId);	//完成任务，参数为任务ID
		log.info("完成任务,任务ID： "+taskId);
		
	}
	/**
	 * @param assignee
	 */
	private List<Task> doFindMyPersonTask(String assignee) {
		 List<Task> listTask = processEngine.getTaskService()	//获取任务service
			 		.createTaskQuery()	//创建查询对象
			 		.taskAssignee(assignee)  // 指定要查询的人
			 		.list();
	 if ( !CollectionUtils.isEmpty(listTask) ) {
		 for (Task task : listTask) {
			log.info("待办任务ID:	"+task.getId());
			log.info("任务名称:	"+task.getName());
			log.info("任务创建时间:	"+task.getCreateTime());
			log.info("任务办理人:	"+task.getAssignee());
			log.info("流程实例ID:	"+task.getProcessInstanceId());
			log.info("流程定义ID:	"+task.getProcessDefinitionId());
			log.info("执行对象ID:	"+task.getExecutionId());
			
		}
	 }
	 return listTask;
	}
	
	/**
	 * @param taskId
	 * @param mapVariable
	 */
	private void doAfterFlowStartSetVariables(String taskId, Map<String, Object> mapVariable) {
		TaskService taskService = processEngine.getTaskService();
		mapVariable.put("createByName", "zhangsan");
		mapVariable.put("createDate", new Date());
		mapVariable.put("createById", 123);
		mapVariable.put("isLong", 456L);
		mapVariable.put("isFloat", 12.1);
		mapVariable.put("user", new User());
		if(CollectionUtils.isEmpty(mapVariable)){
			return;
		}
		for(String variableName : mapVariable.keySet()){
			taskService.setVariable(taskId, variableName, mapVariable.get(mapVariable));
		}
		
	}
	/**
	 * @param keyId
	 * @param map
	 */
	private void doWhenFlowStartSetVariables(String processDefinitionKey, Map<String, Object> map) {

		RuntimeService runtimeService = processEngine.getRuntimeService();
		
		runtimeService.startProcessInstanceByKey(processDefinitionKey, map);
	}

	/**
	 * @param taskId
	 * @param listVariableName
	 * @return mapQueryFlowVariablesValue
	 */
	private Map<String, Object>  doGetFlowVariables(String taskId, List<String> listVariableName) {
		Map<String, Object> mapQueryFlowVariablesValue = new HashMap<String, Object>();
		TaskService taskService = processEngine.getTaskService();
		for(String variableName:listVariableName ){
			mapQueryFlowVariablesValue.put(variableName, taskService.getVariable(taskId, variableName));
		}
		for( String variableName : mapQueryFlowVariablesValue.keySet()){
			log.info(variableName+" :  "+mapQueryFlowVariablesValue.get(variableName));
		}
		return mapQueryFlowVariablesValue; 
	}
}
