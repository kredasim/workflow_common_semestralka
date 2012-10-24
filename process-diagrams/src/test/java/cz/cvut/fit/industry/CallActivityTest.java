package cz.cvut.fit.industry;

import static org.junit.Assert.assertNotNull;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.Deployment;
import org.junit.Test;

public class CallActivityTest extends AbstractActivitiTest{
private static final String DEFINITION_KEY = "callActivityTestProcess";

	
	@Test
	@Deployment(resources = {"diagrams/CallActivityTestProcess.bpmn", "diagrams/Mock-ConfirmCollaboration.bpmn"})
	public void processShouldGetIntoCallactivity1() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(DEFINITION_KEY);
		
		assertNodeVisited(instance, "callactivity1");
	}
}
