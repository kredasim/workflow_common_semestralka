package cz.cvut.fit.industry;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.Deployment;
import org.junit.Ignore;
import org.junit.Test;

public class AssignCourseTest extends AbstractActivitiTest {
	private static final String DEFINITION_KEY = "assignCourse";
	private static final String DEFINITION_KEY2 = "process1";
	
	@Test
	@Deployment(resources = {"diagrams/01.02-AssignCourse.bpmn"})
	public void processShouldStart() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(DEFINITION_KEY);
		assertNotNull(instance.getId());
	}
	@Test
	@Deployment(resources = {"diagrams/01.02-AssignCourse.bpmn"})
	public void processShouldExecuteApproveTaskAssigment() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(DEFINITION_KEY);
		assertNodeVisited(instance, "usertask1");
	}
	@Test
	@Deployment(resources = {"diagrams/01.02-AssignCourse.bpmn"})
	public void processShouldExecuteInformReferentForIndustry() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(DEFINITION_KEY);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNodeVisited(instance, "scripttask2");
	}
	@Test
	@Deployment(resources = {"diagrams/01.02-AssignCourse.bpmn"})
	public void processShouldExecuteScripttask1() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		TaskService taskService = activitiRule.getTaskService();
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(DEFINITION_KEY);
		runtimeService.setVariable(instance.getId(), "validationOutcome", "approved");
		completeTask(taskService, instance, "usertask1");
		assertNodeVisited(instance, "scripttask1");
	}
	@Test
	@Deployment(resources = {"diagrams/01.02-AssignCourse.bpmn"})
	public void processShouldExecuteEndevent3() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		TaskService taskService = activitiRule.getTaskService();
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(DEFINITION_KEY);
		runtimeService.setVariable(instance.getId(), "validationOutcome", "rejected");
		completeTask(taskService, instance, "usertask1");
		assertNodeVisited(instance, "endevent3");
	}
	@Test
	@Deployment(resources = {"diagrams/01.02-AssignCourse.bpmn"})
	public void processShouldExecuteUsertask3() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		TaskService taskService = activitiRule.getTaskService();
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(DEFINITION_KEY);
		runtimeService.setVariable(instance.getId(), "validationOutcome", "returned");
		completeTask(taskService, instance, "usertask1");
		assertNodeVisited(instance, "usertask3");
	}
	@Test
	@Deployment(resources = {"diagrams/01.02-AssignCourse.bpmn"})
	public void processShouldExecuteApproveTaskAssigmenFor2ndTime() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		TaskService taskService = activitiRule.getTaskService();
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(DEFINITION_KEY);
		runtimeService.setVariable(instance.getId(), "validationOutcome", "returned");		
		completeTask(taskService, instance, "usertask1");
		runtimeService.setVariable(instance.getId(), "modifyAction", "resend");
		completeTask(taskService, instance, "usertask3");
		assertNodeVisited(instance, "exclusivegateway2");
		assertNodeVisitedTimes(instance, "usertask1", 2);
	}
	@Test
	@Deployment(resources = {"diagrams/01.02-AssignCourse.bpmn"})
	public void processShouldExecuteEndevent2() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		TaskService taskService = activitiRule.getTaskService();
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(DEFINITION_KEY);
		runtimeService.setVariable(instance.getId(), "validationOutcome", "returned");		
		completeTask(taskService, instance, "usertask1");
		runtimeService.setVariable(instance.getId(), "modifyAction", "cancel");
		completeTask(taskService, instance, "usertask3");
		assertNodeVisited(instance, "endevent2");
	}

	@Test
	@Ignore
	@Deployment(resources = {"diagrams/TimerBoundaryEventTest.bpmn"})
	public void processShouldStart2() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(DEFINITION_KEY2);
		assertNotNull(instance.getId());
	}
	


}
