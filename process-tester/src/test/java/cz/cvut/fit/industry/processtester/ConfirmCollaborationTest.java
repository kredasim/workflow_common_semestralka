package cz.cvut.fit.industry.processtester;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.ProcessInstance;
import org.jbpm.task.TaskService;
import org.jbpm.task.query.TaskSummary;
import org.jbpm.test.JbpmJUnitTestCase;
import org.junit.Before;
import org.junit.Test;

public class ConfirmCollaborationTest extends JbpmJUnitTestCase {

	private static final String LANG = "en-UK";
	private StatefulKnowledgeSession ksession;		// knowledge session for all tests
	private TaskService taskService;
	
	public ConfirmCollaborationTest() {
		super(true);
		setPersistence(true);
	}
	
	@Before
	public void getKnowlegdeSession() {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("03.00 - Confirm collaboration.bpmn2"), ResourceType.BPMN2);
		
		kbuilder.newKnowledgeBase();
				
		ksession = createKnowledgeSession("03.00 - Confirm collaboration.bpmn2");
		taskService = getTaskService(ksession);
	}

	@Test
	public void testProcessStart() {
		ProcessInstance processInstance = ksession.startProcess("industry.impl.ConfirmCollaboration");		
		
		assertProcessInstanceActive(processInstance.getId(), ksession);
		assertNodeTriggered(processInstance.getId(), "01 - Confirm collaboration");
	}
	
	@Test
	public void testLookForATaskFinishedTest() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("owner", "Pepik");
		vars.put("denied", "yes");
			
		ProcessInstance processInstance = ksession.startProcess("industry.impl.ApplyingForTask", vars);		
			
		assertNodeTriggered(processInstance.getId(), "01 - Look for a task");
		executeHumanTask(taskService, "Pepik", LANG);
		
		assertNodeTriggered(processInstance.getId(), "Selected");
	}
	
	
	private void executeHumanTask(TaskService taskService, String owner, String lang){
		List<TaskSummary> list = taskService.getTasksAssignedAsPotentialOwner(owner, lang);
		TaskSummary task = list.get(0);
		System.out.println(task.getName());
		System.out.println(owner + " is executing task: " + task.getName());
		taskService.start(task.getId(), owner);
		taskService.complete(task.getId(), owner, null);	// null jsou data, ktere dostaneme z tasku
	}
	
}

