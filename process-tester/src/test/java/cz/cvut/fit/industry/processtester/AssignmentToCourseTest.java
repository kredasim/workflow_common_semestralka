package cz.cvut.fit.industry.processtester;

import java.util.HashMap;
import java.util.Map;

import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.ProcessInstance;
import org.jbpm.task.TaskService;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a sample file to launch a process.
 */
public class AssignmentToCourseTest extends IndustryJUnitTestCase {

	private static final String TASK_APPROVE_TASK = "01 - Approve task";
	private static final String PROCESS_ID = "industry.impl.AssignmentToCourse";
	private static final String PROCESS_FILE_NAME = "01.02 - Assignment to course.bpmn2";
	private StatefulKnowledgeSession ksession; // knowledge session for all
												// tests
	private TaskService taskService;

	public AssignmentToCourseTest() {
		super(true);
		setPersistence(true);
	}

	@Before
	public void getKnowlegdeSession() {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource(PROCESS_FILE_NAME),
				ResourceType.BPMN2);

		kbuilder.newKnowledgeBase();

		ksession = createKnowledgeSession(PROCESS_FILE_NAME);
		taskService = getTaskService(ksession);
	}

	@Test
	public void testProcessStart() {
		ProcessInstance processInstance = ksession.startProcess(PROCESS_ID);

		assertProcessInstanceActive(processInstance.getId(), ksession);
		assertNodeTriggered(processInstance.getId(), "gate1");
		assertNodeTriggered(processInstance.getId(), TASK_APPROVE_TASK);
		assertNodeTriggered(processInstance.getId(),
				"Guarantator doesnt respond");
	}

	@Test
	public void testAproveTaskGuarantatorDenied() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("owner", "Pepik");
		vars.put("aproved", "denied");
		ProcessInstance processInstance = ksession.startProcess(PROCESS_ID,
				vars);
		executeHumanTask(taskService, "Pepik", LANG, TASK_APPROVE_TASK);

		assertNodeTriggered(processInstance.getId(), "Denied?");
		assertNodeTriggered(processInstance.getId(), "Denied");
	}

	@Test
	public void testAproveTaskGuarantatorReturned() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("owner", "Pepik");
		vars.put("aproved", "returned");
		ProcessInstance processInstance = ksession.startProcess(PROCESS_ID,
				vars);
		executeHumanTask(taskService, "Pepik", LANG, TASK_APPROVE_TASK);

		assertNodeTriggered(processInstance.getId(), "Returned?");
		assertNodeTriggered(processInstance.getId(), "Returned");
	}

	@Test
	public void testAproveTaskGuarantatorAccepted() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("owner", "Pepik");
		vars.put("aproved", "accepted");
		ProcessInstance processInstance = ksession.startProcess(PROCESS_ID,
				vars);
		executeHumanTask(taskService, "Pepik", LANG, TASK_APPROVE_TASK);

		assertNodeTriggered(processInstance.getId(), "Accepted");
	}

	@Test
	public void testTimeEvent() {
		ProcessInstance processInstance = ksession.startProcess(PROCESS_ID);

		try {
			Thread.sleep(3002);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNodeTriggered(processInstance.getId(),
				"Inform university Referent");
		assertNodeTriggered(processInstance.getId(), "End notification");
	}

}