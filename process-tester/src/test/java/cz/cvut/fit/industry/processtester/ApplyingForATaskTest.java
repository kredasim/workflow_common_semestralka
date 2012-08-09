package cz.cvut.fit.industry.processtester;

import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.ProcessInstance;
import org.jbpm.task.TaskService;
import org.jbpm.test.JbpmJUnitTestCase;
import org.junit.Before;
import org.junit.Test;

public class ApplyingForATaskTest extends JbpmJUnitTestCase {
	
	private static final String LANG = "en-UK";
	private StatefulKnowledgeSession ksession;		// knowledge session for all tests
	private TaskService taskService;

	
	public ApplyingForATaskTest() {
		super(true);
		setPersistence(true);
	}
	
	@Before
	public void getKnowlegdeSession() {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("02 - Applying for a task.bpmn2"), ResourceType.BPMN2);
		
		kbuilder.newKnowledgeBase();
				
		ksession = createKnowledgeSession("02 - Applying for a task.bpmn2");
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
}
