package cz.cvut.fit.industry.processtester;

import java.util.ArrayList;
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
import org.junit.Test;

/**
 * This is a sample file to launch a process.
 */
public class CreateTaskTest extends JbpmJUnitTestCase {

	private static final String OWNER = "Pepik";
	private static final String LANG = "en-UK";
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
		
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		assertNodeTriggered(processInstance.getId(), "Check amount of credit");
		consoleLog.close();
		threadedFileLogger.close();
		ksession.dispose();
	}

	private void validateProcesses(String... process) {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		for(String proc : process) {
			kbuilder.add(ResourceFactory.newClassPathResource(proc), ResourceType.BPMN2);
		}
		for(KnowledgeBuilderError error : kbuilder.getErrors()) {
			System.out.println("error:"+error.getMessage());
		}
		kbuilder.newKnowledgeBase();
	}
	
	private void executeHumanTask(TaskService taskService, String owner, String lang, String taskName){
		List<TaskSummary> list = taskService.getTasksAssignedAsPotentialOwner(owner, lang);
		for(TaskSummary task : list) {
			if(taskName.equals(task.getName())) {
				System.out.println(task.getName());
				System.out.println(owner + " is executing task: " + task.getName());
				taskService.start(task.getId(), owner);
				taskService.complete(task.getId(), owner, null);	// null jsou data, ktere dostaneme z tasku
				return;
			}
		}
		fail("Task \""+taskName+"\" for user "+owner+" not found. Tasks count in queue: "+list.size());
	}
	
}