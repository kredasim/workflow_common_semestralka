package cz.cvut.fit.industry;

import static org.junit.Assert.assertNotNull;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
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

}
