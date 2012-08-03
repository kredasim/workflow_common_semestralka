package cz.cvut.fit.industry.processtester;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.jbpm.task.TaskService;
import org.jbpm.task.query.TaskSummary;
import org.jbpm.task.service.ContentData;
import org.jbpm.task.utils.ContentMarshallerHelper;
import org.jbpm.test.JbpmJUnitTestCase;

public abstract class IndustryJUnitTestCase extends JbpmJUnitTestCase {

	protected static final String OWNER = "Pepik";
	protected static final String LANG = "en-UK";

	public IndustryJUnitTestCase() {
		super();
	}

	public IndustryJUnitTestCase(boolean setupDataSource) {
		super(setupDataSource);
	}

	protected static void validateProcesses(String... process) {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		for(String proc : process) {
			kbuilder.add(ResourceFactory.newClassPathResource(proc), ResourceType.BPMN2);
		}
		for (KnowledgeBuilderError error : kbuilder.getErrors()) {
			System.out.println("error:" + error.getMessage());
		}
		kbuilder.newKnowledgeBase();
	}

	protected void executeHumanTask(TaskService taskService, String owner,
			String lang, String taskName) {
		executeHumanTask(taskService, owner, lang, taskName, null);
	}

	protected void executeHumanTask(TaskService taskService, String owner,
			String lang, String taskName, Map<String, Object> inputdata) {
		ContentData contentData = null;
		if (inputdata != null) {
			contentData = ContentMarshallerHelper
					.marshal(inputdata, null, null);
		}
		List<TaskSummary> list = taskService.getTasksAssignedAsPotentialOwner(
				owner, lang);
		for (TaskSummary task : list) {
			if (taskName.equals(task.getName())) {
				System.out.println(task.getName());
				System.out.println(owner + " is executing task: "
						+ task.getName());
				taskService.start(task.getId(), owner);
				taskService.complete(task.getId(), owner, contentData); // null
																		// jsou
																		// data,
																		// ktere
																		// dostaneme
																		// z
																		// tasku
				return;
			}
		}
		fail("Task \"" + taskName + "\" for user " + owner
				+ " not found. Tasks count in queue: " + list.size() +"expected:"+ list.get(0).getName() );

	}

}
