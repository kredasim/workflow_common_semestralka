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

public class ApplyingForATaskTest extends IndustryJUnitTestCase {

	private static final String TASK_VIEW_DETAIL_AND_APPLY = "02 - View detail and apply for the task";
	private static final String TASK_LOOK_FOR_A_TASK = "01 - Look for a task";
	private static final String PROCESS_ID = "industry.impl.ApplyingForTask";
	private static final String PROCESS_FILE_NAME = "02 - Applying for a task.bpmn2";
	private StatefulKnowledgeSession ksession; // knowledge session for all
												// tests
	private TaskService taskService;

	public ApplyingForATaskTest() {
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
		assertNodeTriggered(processInstance.getId(), TASK_LOOK_FOR_A_TASK);
	}

	@Test
	public void testLookForATaskFinished() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("owner", OWNER);

		ProcessInstance processInstance = ksession.startProcess(PROCESS_ID,
				vars);
		executeHumanTask(taskService, OWNER, LANG, TASK_LOOK_FOR_A_TASK);

		assertNodeTriggered(processInstance.getId(), "Selected");
	}

	@Test
	public void testSelectedEnd() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("owner", OWNER);
		vars.put("selected", "end");

		ProcessInstance processInstance = ksession.startProcess(PROCESS_ID,
				vars);

		executeHumanTask(taskService, OWNER, LANG, TASK_LOOK_FOR_A_TASK);

		assertNodeTriggered(processInstance.getId(), "Selected");
		assertNodeTriggered(processInstance.getId(), "end");
	}

	@Test
	public void testSelectedDetail() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("owner", OWNER);
		vars.put("selected", "detail");

		ProcessInstance processInstance = ksession.startProcess(PROCESS_ID,
				vars);

		executeHumanTask(taskService, OWNER, LANG, TASK_LOOK_FOR_A_TASK);
		
		assertNodeTriggered(processInstance.getId(),
				TASK_VIEW_DETAIL_AND_APPLY);
	}

	@Test
	public void testSelectedDetailAppliedNo() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("owner", OWNER);
		vars.put("selected", "detail");
		vars.put("applied", "no");
		
		ProcessInstance processInstance = ksession.startProcess(PROCESS_ID,
				vars);

		executeHumanTask(taskService, OWNER, LANG, TASK_LOOK_FOR_A_TASK);
		executeHumanTask(taskService, OWNER, LANG, TASK_VIEW_DETAIL_AND_APPLY);

		assertNodeTriggered(processInstance.getId(), "Applied?");
	}

	@Test
	public void testSelectedDetailAppliedYes() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("owner", OWNER);
		vars.put("selected", "detail");
		vars.put("applied", "yes");

		ProcessInstance processInstance = ksession.startProcess(PROCESS_ID,
				vars);

		executeHumanTask(taskService, OWNER, LANG, TASK_LOOK_FOR_A_TASK);
		executeHumanTask(taskService, OWNER, LANG, TASK_VIEW_DETAIL_AND_APPLY);

		
		assertNodeTriggered(processInstance.getId(), "gate2");
		assertNodeTriggered(processInstance.getId(), "Add to candidates");
	}

	@Test
	public void testSelectedApply() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("owner", OWNER);
		vars.put("selected", "apply");

		ProcessInstance processInstance = ksession.startProcess(PROCESS_ID,
				vars);

		executeHumanTask(taskService, OWNER, LANG, TASK_LOOK_FOR_A_TASK);

		assertNodeTriggered(processInstance.getId(), "Selected");
		assertNodeTriggered(processInstance.getId(), "gate2");
		assertNodeTriggered(processInstance.getId(), "Add to candidates");
	}
}
