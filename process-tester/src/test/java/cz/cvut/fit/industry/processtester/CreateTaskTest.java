package cz.cvut.fit.industry.processtester;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.drools.KnowledgeBaseFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.ProcessInstance;
import org.jbpm.task.TaskService;
import org.junit.Test;

/**
 * Test for process 01 - Create task
 */
public class CreateTaskTest extends IndustryJUnitTestCase {

	private static final String[] PROCESSES = { "01 - Create task.bpmn2", "01.02 - mock.bpmn2" };

	public CreateTaskTest() {
		super(true);
		setPersistence(true);
	}

	@Test
	public void testProcess() {
		validateProcesses(PROCESSES);
		StatefulKnowledgeSession ksession = createKnowledgeSession(PROCESSES);
		TaskService taskService = getTaskService(ksession);
		
		// debug loggery
		//KnowledgeRuntimeLogger fileLog    = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test_filename");
		KnowledgeRuntimeLogger consoleLog = KnowledgeRuntimeLoggerFactory.newConsoleLogger(ksession);
		KnowledgeRuntimeLogger threadedFileLogger = KnowledgeRuntimeLoggerFactory.newThreadedFileLogger(ksession, "test_log", 1000);
		
		List<String> courses = new ArrayList<String>();
		courses.add("BI-CAO");
		courses.add("BI-MLO");
		courses.add("BI-OMO");
		
		
		// mapa promenych procesu
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("owner", OWNER);	
		vars.put("courses", courses);
		ProcessInstance processInstance = ksession.startProcess("industry.impl.CreateTask", vars);

		assertProcessInstanceActive(processInstance.getId(), ksession);
		
		assertNodeTriggered(processInstance.getId(), "01 - Enter task information");
		
		executeHumanTask(taskService, OWNER, LANG, "enterTaskInfo");
		
		assertEquals(courses.size(), taskService.getTasksAssignedAsPotentialOwner(OWNER, LANG).size());
		
		for(String course : courses) {
			executeHumanTask(taskService, OWNER, LANG, "approveTask");
		}
		
		assertNodeTriggered(processInstance.getId(), "Check amount of credit");
		consoleLog.close();
		threadedFileLogger.close();
		ksession.dispose();
	}
	
}