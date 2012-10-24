package cz.cvut.fit.industry;

import static org.junit.Assert.assertNotNull;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.Deployment;
import org.junit.Test;

public class SignalBoundaryEventTest extends AbstractActivitiTest {
private static final String DEFINITION_KEY = "signalBoundaryTest";

	
	@Test
	@Deployment(resources = {"diagrams/SignalBoundaryEventTest.bpmn"})
	public void processShouldStart() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(DEFINITION_KEY);
		assertNotNull(instance.getId());
	}
	
	@Test
	@Deployment(resources = {"diagrams/SignalBoundaryEventTest.bpmn"})
	public void processShouldWaitForSignal() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(DEFINITION_KEY);
		TaskService taskService = activitiRule.getTaskService();

		runtimeService.setVariable(instance.getId(), "exclusiveGatewayDesicion", "confirmed");
		completeTask(taskService, instance, "usertask1");
		assertNodeNotVisited(instance, "exclusivegateway1");
	}
}
