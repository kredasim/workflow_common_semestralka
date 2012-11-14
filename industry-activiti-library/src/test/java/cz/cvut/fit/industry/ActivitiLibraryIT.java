package cz.cvut.fit.industry;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import model.ContactType;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.TaskQuery;
import org.activiti.engine.test.Deployment;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ActivitiLibraryIT {

	private ActivitiLibrary activitiLibrary;
	private ProcessEngine processEngine;

	@After
	public void cleanup() {
		if (activitiLibrary != null)
			activitiLibrary.close();
	}

	@Before
	public void init() {
		activitiLibrary = ActivitiLibraryFactory.createActivitiLibrary();
		activitiLibrary.initialize();
		processEngine = activitiLibrary.getProcessEngine();
	}

	@Test
	public void testInitialize() {
		assertNotNull(processEngine);
	}

	@Test
	public void testStartProcess() {
		ProcessInstance processInstance = activitiLibrary.getRuntimeService()
				.startProcessInstanceByKey("mainProcess");
		assertNotNull(processInstance);
	}

	@Test
	public void testCooperationWithJPA() {
		/*
		 * model.ContactType ct = new model.ContactType();
		 * ct.setContactTypeID(50); 
		 * 
		 */
		
		

		ProcessInstance processInstance = activitiLibrary.getRuntimeService()
				.startProcessInstanceByKey("DatabaseTestProcess");
		EntityManagerFactory entityManagerFactory = activitiLibrary
				.getContext().getBean(EntityManagerFactory.class);
		assertNotNull(entityManagerFactory);

		/*
		 * ContactType ctFromProcess =
		 * (ContactType)activitiLibrary.getRuntimeService
		 * ().getVariable(processInstance.getId(),"task");
		 * System.out.println("CONTACT NAME - " + ctFromProcess.getName());
		 */
		EntityManager em = entityManagerFactory.createEntityManager();

		TaskService taskService = activitiLibrary.getTaskService();

		TaskQuery taskqery1 = taskService.createTaskQuery().taskDefinitionKey(
				"usertask1");
		String humanTaskId = taskService.createTaskQuery()
				.taskDefinitionKey("usertask1")
				.processInstanceId(processInstance.getId()).singleResult()
				.getId();

		/*
		 * EntityTransaction tx = em.getTransaction(); tx.begin();
		 * em.persist(task); tx.commit(); em.close(); //
		 */

		// taskService.complete(humanTaskId, variables);
	}

	@Test
	public void testCreateTaskShoulPutTestingTaskIntoDb() {
		ProcessInstance processInstance = activitiLibrary.getRuntimeService()
				.startProcessInstanceByKey("createTask");
		EntityManagerFactory entityManagerFactory = activitiLibrary
				.getContext().getBean(EntityManagerFactory.class);
		assertNotNull(entityManagerFactory);

		TaskService taskService = activitiLibrary.getTaskService();
		
		String humanTaskId = taskService.createTaskQuery()
				.taskDefinitionKey("usertask1")
				.processInstanceId(processInstance.getId()).singleResult()
				.getId();
		
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("task", "task");
		taskService.complete(humanTaskId, variables);
	}

}
