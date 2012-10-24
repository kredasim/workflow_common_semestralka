package cz.cvut.fit.industry;

import static org.junit.Assert.assertNotNull;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.Deployment;
import org.junit.Test;

public class SignalEventTest extends AbstractActivitiTest {

private static final String DEFINITION_KEY = "signalEventTest";

	
	@Test
	@Deployment(resources = {"diagrams/SignalEventTest.bpmn"})
	public void processShouldStart() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(DEFINITION_KEY);
		assertNotNull(instance.getId());
	}
	
	@Test
	@Deployment(resources = {"diagrams/SignalEventTest.bpmn"})
	public void processShouldWaitForSignal() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(DEFINITION_KEY);

		assertNodeNotVisited(instance, "endevent1");
	}
	
	@Test
	@Deployment(resources = {"diagrams/SignalEventTest.bpmn"})
	public void processShouldReactOnSignal() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(DEFINITION_KEY);
		TaskService taskService = activitiRule.getTaskService();

		runtimeService.signalEventReceived("signal");
		
		assertNodeVisited(instance, "endevent1");
	}
}
