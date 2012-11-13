package cz.cvut.fit.industry;

import static org.junit.Assert.assertNotNull;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.Deployment;
import org.junit.Test;

public class ConfirmCollaborationTest extends AbstractActivitiTest{
	private static final String DEFINITION_KEY = "confirmCollaboration";

	
	@Test
	@Deployment(resources = {"diagrams/03.00 - ConfirmCollaboration.bpmn"})
	public void processShouldStart() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(DEFINITION_KEY);
		assertNotNull(instance.getId());
	}
	
	@Test
	@Deployment(resources = {"diagrams/03.00 - ConfirmCollaboration.bpmn"})
	public void processShouldEnterExclusiveGateway1() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(DEFINITION_KEY);
		TaskService taskService = activitiRule.getTaskService();

		runtimeService.setVariable(instance.getId(), "exclusiveGatewayDesicion", "confirmed");
		completeTask(taskService, instance, "usertask1");
		assertNodeVisited(instance, "exclusivegateway1");
	}

	
	@Test
	@Deployment(resources = {"diagrams/03.00 - ConfirmCollaboration.bpmn"})
	public void processShouldConfirmCollaboration() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(DEFINITION_KEY);
		TaskService taskService = activitiRule.getTaskService();
		
		runtimeService.setVariable(instance.getId(), "exclusiveGatewayDesicion", "confirmed");

		completeTask(taskService, instance, "usertask1");
		assertNodeVisited(instance, "endeventConfirmed");
	}
	
	@Test
	@Deployment(resources = {"diagrams/03.00 - ConfirmCollaboration.bpmn"})
	public void processShouldCancelConfirmingCollaboration() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(DEFINITION_KEY);
		TaskService taskService = activitiRule.getTaskService();
		
		runtimeService.setVariable(instance.getId(), "exclusiveGatewayDesicion", "rejected");

		completeTask(taskService, instance, "usertask1");
		assertNodeVisited(instance, "endeventCanceled");
	}
	
	@Test
	@Deployment(resources = {"diagrams/03.00 - ConfirmCollaboration.bpmn"})
	public void processShouldStopWaitingForConfirmingCollaborationAfterSignal() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(DEFINITION_KEY);

		runtimeService.signalEventReceived("collaborationInitiatedSignal");
		assertNodeNotVisited(instance, "exclusivegateway1");
		assertNodeVisited(instance, "endeventCanceled");
	}

}
