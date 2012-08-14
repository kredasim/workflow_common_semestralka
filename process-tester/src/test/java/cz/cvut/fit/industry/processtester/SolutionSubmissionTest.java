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

public class SolutionSubmissionTest extends IndustryJUnitTestCase{
	private static final String PROCESS_FILE_NAME = "04 - Solution submission.bpmn2";
	private static final String TASK_SUBMIT_SOLUTION = "01 - Submit solution";
	private static final String LANG = "en-UK";
	private StatefulKnowledgeSession ksession;		// knowledge session for all tests
	private TaskService taskService;

	
	public SolutionSubmissionTest() {
		super(true);
		setPersistence(true);
	}
	
	@Before
	public void getKnowlegdeSession() {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource(PROCESS_FILE_NAME), ResourceType.BPMN2);
		
		validateProcesses(PROCESS_FILE_NAME);
		
		kbuilder.newKnowledgeBase();
	
		ksession = createKnowledgeSession(PROCESS_FILE_NAME);
		taskService = getTaskService(ksession);
	}
	
	@Test
	public void testProcessStart() {
		ProcessInstance processInstance = ksession.startProcess("industry.impl.TaskSubmission");		
		
		assertProcessInstanceActive(processInstance.getId(), ksession);
		assertNodeTriggered(processInstance.getId(), TASK_SUBMIT_SOLUTION);
	}
	
	@Test
	public void testLookForATaskFinished() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("owner", OWNER);
			
		ProcessInstance processInstance = ksession.startProcess("industry.impl.ApplyingForTask", vars);		
		executeHumanTask(taskService, OWNER, LANG, TASK_SUBMIT_SOLUTION);
	}
}
