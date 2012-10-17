package cz.cvut.fit.industry;

import static org.junit.Assert.assertNotNull;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.Deployment;
import org.junit.Test;

public class ChooseSolversTest extends AbstractActivitiTest{
	private static final String DEFINITION_KEY = "chooseSolvers";

	
	@Test
	@Deployment(resources = {"diagrams/03-ChooseSolvers.bpmn"})
	public void processShouldStart() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(DEFINITION_KEY);
		assertNotNull(instance.getId());
	}
	
	@Test
	@Deployment(resources = {"diagrams/03-ChooseSolvers.bpmn"})
	public void processShouldExecuteEnterTask01ChooseSolvers() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(DEFINITION_KEY);
		assertNodeVisited(instance, "usertask1");
	}
	
	@Test
	@Deployment(resources = {"diagrams/03-ChooseSolvers.bpmn"})
	public void processShouldExecuteEnterInitiateTask() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		TaskService taskService = activitiRule.getTaskService();
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(DEFINITION_KEY);
		
		Task taskInstance = taskService.createTaskQuery().taskDefinitionKey("usertask1")
				.processInstanceId(instance.getId()).singleResult();
		
		runtimeService.setVariable(instance.getId(), "exclusiveGatewayDesicion", "complete");
		
		taskService.complete(taskInstance.getId());
				
		assertNodeVisited(instance, "scripttask1");
	}
	
	@Test
	@Deployment(resources = {"diagrams/03-ChooseSolvers.bpmn"})
	public void processShouldExecuteEnterTaskCanceled() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		TaskService taskService = activitiRule.getTaskService();
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(DEFINITION_KEY);
		
		Task taskInstance = taskService.createTaskQuery().taskDefinitionKey("usertask1")
				.processInstanceId(instance.getId()).singleResult();
		
		runtimeService.setVariable(instance.getId(), "exclusiveGatewayDesicion", "canceled");		
		taskService.complete(taskInstance.getId());			
		assertNodeVisited(instance, "endevent1");
	}

}
