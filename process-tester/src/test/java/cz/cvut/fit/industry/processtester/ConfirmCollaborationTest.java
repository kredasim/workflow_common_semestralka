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

public class ConfirmCollaborationTest extends IndustryJUnitTestCase {

	private static final String TASK_CONFIRM_COLLABORATION = "01 - Confirm collaboration";
	private static final String PROCESS_ID = "industry.impl.ConfirmCollaboration";
	private static final String PROCESS_FILE_NAME = "03.00 - Confirm collaboration.bpmn2";
	private StatefulKnowledgeSession ksession;		// knowledge session for all tests
	private TaskService taskService;
	
	public ConfirmCollaborationTest() {
		super(true);
		setPersistence(true);
	}
	
	@Before
	public void getKnowlegdeSession() {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource(PROCESS_FILE_NAME), ResourceType.BPMN2);
		
		kbuilder.newKnowledgeBase();
				
		ksession = createKnowledgeSession(PROCESS_FILE_NAME);
		taskService = getTaskService(ksession);
	}

	@Test
	public void testProcessStart() {
		ProcessInstance processInstance = ksession.startProcess(PROCESS_ID);		
		
		assertProcessInstanceActive(processInstance.getId(), ksession);
		assertNodeTriggered(processInstance.getId(), TASK_CONFIRM_COLLABORATION);
	}
	
	@Test
	public void testDeniedDenied() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("owner", OWNER);
		vars.put("denied", "denied");
			
		ProcessInstance processInstance = ksession.startProcess(PROCESS_ID, vars);		
			
		executeHumanTask(taskService, OWNER, LANG, TASK_CONFIRM_COLLABORATION);
		
		assertNodeTriggered(processInstance.getId(), "Denied?");
		assertNodeTriggered(processInstance.getId(), "Denied");
	}
	
	@Test
	public void testDeniedConfirmed() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("owner", OWNER);
		vars.put("denied", "confirmed");
			
		ProcessInstance processInstance = ksession.startProcess(PROCESS_ID, vars);		

		executeHumanTask(taskService, OWNER, LANG, TASK_CONFIRM_COLLABORATION);
		
		assertNodeTriggered(processInstance.getId(), "Confirmed");
	}
	
}

