package cz.cvut.fit.industry.processtester;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.ProcessInstance;
import org.jbpm.task.TaskService;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test for process 01 - Create task
 */
public class CreateTaskTest extends IndustryJUnitTestCase {

	private static final String[] PROCESSES = { "01 - Create task.bpmn2", "01.02 - mock.bpmn2" };
	private StatefulKnowledgeSession ksession;
	private TaskService taskService;
	private KnowledgeRuntimeLogger consoleLog;
	private KnowledgeRuntimeLogger threadedFileLogger;

	public CreateTaskTest() {
		super(true);
		setPersistence(true);
	}
	
	@BeforeClass
	public static void beforeClass() {
		validateProcesses(PROCESSES);
	}
	
	@Before
	public void before() {
		ksession = createKnowledgeSession(PROCESSES);
		taskService = getTaskService(ksession);
		
		consoleLog = KnowledgeRuntimeLoggerFactory.newConsoleLogger(ksession);
		threadedFileLogger = KnowledgeRuntimeLoggerFactory.newThreadedFileLogger(ksession, "test_log", 1000);
		System.out.println("Before in "+getClass().getCanonicalName());
	}
	
	@After
	public void after() {
		consoleLog.close();
		threadedFileLogger.close();
		ksession.dispose();
		System.out.println("After in "+getClass().getCanonicalName());
	}
	
	@Test
	public void processShouldStart() {
		validateProcesses(PROCESSES);
		ProcessInstance processInstance = ksession.startProcess("industry.impl.CreateTask");
		assertProcessInstanceActive(processInstance.getId(), ksession);
	}
	
	@Test
	public void processShouldExecuteHumanTaskNode() {
		ProcessInstance processInstance = ksession.startProcess("industry.impl.CreateTask");
		assertNodeTriggered(processInstance.getId(), "01 - Enter task information");
	}
	
	@Test
	public void processShouldContinueAfterHumanTask() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("owner", OWNER);	
		ProcessInstance processInstance = ksession.startProcess("industry.impl.CreateTask", vars);
		executeHumanTask(taskService, OWNER, LANG, "enterTaskInfo");
		assertNodeTriggered(processInstance.getId(), "Subject assignment", "Check amount of credit");
	}

	@Test
	public void processShouldExecuteSubprocess() {
		Map<String, Object> vars = new HashMap<String, Object>();
		List<String> courses = new ArrayList<String>();
		courses.add("BI-CAO");
		courses.add("BI-MLO");
		courses.add("BI-OMO");
		vars.put("courses", courses);
		vars.put("owner", OWNER);	
		ProcessInstance processInstance = ksession.startProcess("industry.impl.CreateTask", vars);
		executeHumanTask(taskService, OWNER, LANG, "enterTaskInfo");
		assertNodeTriggered(processInstance.getId(), "02 - Assign to course", "Check amount of credit");
	}
	
	@Test
	public void processShouldNotifyOnLowCredit() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("owner", OWNER);
		vars.put("enoughCredit", false);
		ProcessInstance processInstance = ksession.startProcess("industry.impl.CreateTask", vars);
		executeHumanTask(taskService, OWNER, LANG, "enterTaskInfo");
		assertNodeTriggered(processInstance.getId(), "Inform about low account balance");
	}
	
	@Test
	public void processShouldFinish() {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("owner", OWNER);
		vars.put("enoughCredit", false);
		ProcessInstance processInstance = ksession.startProcess("industry.impl.CreateTask", vars);
		executeHumanTask(taskService, OWNER, LANG, "enterTaskInfo");
		assertNodeTriggered(processInstance.getId(), "Publish task");
		assertProcessInstanceCompleted(processInstance.getId(), ksession);
	}
	
	
	
}