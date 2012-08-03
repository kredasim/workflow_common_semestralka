package cz.cvut.fit.industry.processtester;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.ProcessInstance;
import org.jbpm.task.TaskService;
import org.jbpm.task.query.TaskSummary;
import org.jbpm.test.JbpmJUnitTestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a sample file to launch a process.
 */
public class AssignmentToCourseTest extends JbpmJUnitTestCase {

	private static final String LANG = "en-UK";
	private StatefulKnowledgeSession ksession;		// knowledge session for all tests
	private TaskService taskService;
	
	public AssignmentToCourseTest() {
		super(true);
		setPersistence(true);
	}
	
	@Before
	public void getKnowlegdeSession() {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("01.02 - Assignment to course.bpmn2"), ResourceType.BPMN2);
		
		kbuilder.newKnowledgeBase();
				
		ksession = createKnowledgeSession("01.02 - Assignment to course.bpmn2");
		taskService = getTaskService(ksession);
	}

	@Test
	public void testProcessStart() {
		ProcessInstance processInstance = ksession.startProcess("industry.impl.AssignmentToCourse");		
		
		assertProcessInstanceActive(processInstance.getId(), ksession);
		assertNodeTriggered(processInstance.getId(), "gate1");
		assertNodeTriggered(processInstance.getId(), "01 - Approve task");
		assertNodeTriggered(processInstance.getId(), "Guarantator doesnt respond");
	}
	
	@Test
	public void testAproveTaskGuarantatorDenied() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("owner", "Pepik");
		vars.put("aproved", "denied");
		ProcessInstance processInstance = ksession.startProcess("industry.impl.AssignmentToCourse", vars);		
		executeHumanTask(taskService, "Pepik", LANG);
		
		assertNodeTriggered(processInstance.getId(), "Denied?");
		assertNodeTriggered(processInstance.getId(), "Denied");
	}
	
	@Test
	public void testAproveTaskGuarantatorReturned() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("owner", "Pepik");
		vars.put("aproved", "returned");
		ProcessInstance processInstance = ksession.startProcess("industry.impl.AssignmentToCourse", vars);		
		executeHumanTask(taskService, "Pepik", LANG);
		
		assertNodeTriggered(processInstance.getId(), "Denied?");
		assertNodeTriggered(processInstance.getId(), "Returned?");
		assertNodeTriggered(processInstance.getId(), "Returned");
	}
	
	@Test
	public void testAproveTaskGuarantatorAccepted() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("owner", "Pepik");
		vars.put("aproved", "accepted");
		ProcessInstance processInstance = ksession.startProcess("industry.impl.AssignmentToCourse", vars);		
		executeHumanTask(taskService, "Pepik", LANG);
		
		assertNodeTriggered(processInstance.getId(), "Denied?");
		assertNodeTriggered(processInstance.getId(), "Returned?");
		assertNodeTriggered(processInstance.getId(), "Accepted");
	}
	
	@Test
	public void testTimeEvent() {
		ProcessInstance processInstance = ksession.startProcess("industry.impl.AssignmentToCourse");
		
		assertNodeTriggered(processInstance.getId(), "Guarantator doesnt respond");
		
		try {
			Thread.sleep(3002);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNodeTriggered(processInstance.getId(), "Inform university Referent");
		assertNodeTriggered(processInstance.getId(), "End notification");
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