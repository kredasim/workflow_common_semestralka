package cz.cvut.fit.industry;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javassist.expr.Instanceof;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricDetail;
import org.activiti.engine.history.HistoricVariableUpdate;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.Deployment;
import org.junit.Test;

public class CreateTaskTest extends AbstractActivitiTest {

	private static final String DEFINITION_KEY = "createTask";
	private static final String SAMPLE_NAME = "stuff";
	private static final String TASK_BEAN_NAME = "task";

	@Test
	@Deployment(resources = { "diagrams/01-CreateTask.bpmn" })
	public void processShouldAcceptTaskParams() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		TaskService taskService = activitiRule.getTaskService();
		FormService formService = activitiRule.getFormService();
		Map<String, Object> startParams = new HashMap<String, Object>();
		startParams.put(TASK_BEAN_NAME, new model.Task());
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(
				DEFINITION_KEY, startParams);
		Task task = taskService.createTaskQuery()
				.taskDefinitionKey("usertask1")
				.processInstanceId(instance.getId()).singleResult();
		Map<String, String> params = new HashMap<String, String>();
		formService.submitTaskFormData(task.getId(), params);
		assertNodeVisited(instance, "usertask3");
		model.Task storedTask = (model.Task) runtimeService.getVariable(
				instance.getId(), TASK_BEAN_NAME);
		assertEquals(SAMPLE_NAME, storedTask.getName());
	}

	@Test
	@Deployment(resources = { "diagrams/01-CreateTask.bpmn" })
	public void processShouldExecuteEnterTaskInfo() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		TaskService taskService = activitiRule.getTaskService();
		ProcessInstance instance = runtimeService
				.startProcessInstanceByKey(DEFINITION_KEY);
		assertEquals(1,
				taskService.createTaskQuery().taskDefinitionKey("usertask1")
						.processInstanceId(instance.getId()).count());
	}

	@Test
	@Deployment(resources = { "diagrams/01-CreateTask.bpmn" })
	public void processShouldStart() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		ProcessInstance instance = runtimeService
				.startProcessInstanceByKey(DEFINITION_KEY);
		assertNotNull(instance.getId());
	}

	@Test
	@Deployment(resources = { "diagrams/01-CreateTask.bpmn","diagrams/Mock-AssignCourse.bpmn" })
	public void nodeEnterTaskInfoShouldGetTaskInfo() {
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		TaskService taskService = activitiRule.getTaskService();
		ProcessInstance instance = runtimeService
				.startProcessInstanceByKey(DEFINITION_KEY);
		model.Task task = new model.Task();
		Map<String, Object> taskInfoMap = new HashMap<String, Object>();
		taskInfoMap.put("task", task);
		taskService.complete(
				taskService.createTaskQuery().taskDefinitionKey("usertask1")
						.processInstanceId(instance.getId()).singleResult()
						.getId(), taskInfoMap);
		/*
		List<HistoricDetail> list = activitiRule.getHistoryService()
				.createHistoricDetailQuery()
				.processInstanceId(instance.getId()).list();
		Boolean haveFoundData = false;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			HistoricDetail historicDetail = (HistoricDetail) iterator.next();
			if (historicDetail instanceof HistoricVariableUpdate) {
				HistoricVariableUpdate historicVariableUpdate = (HistoricVariableUpdate) historicDetail;
				Object retrievTask = historicVariableUpdate.getValue();
				if (retrievTask instanceof model.Task) {
					haveFoundData = true;
				}

			}
		}
		assertTrue(haveFoundData);
		*/
		Object retrievTask = runtimeService.getVariable(instance.getId(),"task");
		assertTrue(retrievTask instanceof model.Task);
		// assertEquals(1,
		// taskService.createTaskQuery().taskDefinitionKey("Assign Course").processInstanceId(instance.getId()).count());
	}

}
