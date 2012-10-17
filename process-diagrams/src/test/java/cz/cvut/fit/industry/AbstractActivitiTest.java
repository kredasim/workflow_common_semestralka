package cz.cvut.fit.industry;

import static org.junit.Assert.fail;

import org.activiti.engine.HistoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.junit.Rule;

public class AbstractActivitiTest {

	@Rule
	public ActivitiRule activitiRule = new ActivitiRule("activiti.cfg.xml");

	public AbstractActivitiTest() {
		super();
	}

	// asserts how many times process should be in node
	protected void assertNodeVisitedTimes(ProcessInstance instance, String activityId, int howMany) {
		HistoryService historyService = activitiRule.getHistoryService();
		long count = historyService.createHistoricActivityInstanceQuery().processInstanceId(instance.getId()).activityId(activityId).count();
		if(count < howMany ) 
			fail("Node "+activityId+" not visited " + howMany + " times but only " + count + " times.");
	}
	
	protected void assertNodeVisited(ProcessInstance instance, String activityId) {
		assertNodeVisitedTimes(instance, activityId, 1);
	}
	
	protected void assertNodeNotVisited(ProcessInstance instance, String activityId) {
		assertNodeVisitedTimes(instance, activityId, 0);
	}
	
	protected void completeTask(TaskService taskService, ProcessInstance instance, String taskName) {
		Task taskInstance = taskService.createTaskQuery().taskDefinitionKey(taskName)
				.processInstanceId(instance.getId()).singleResult();
			
		taskService.complete(taskInstance.getId());
	}

}