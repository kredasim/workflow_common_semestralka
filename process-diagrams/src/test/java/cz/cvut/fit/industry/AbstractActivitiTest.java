package cz.cvut.fit.industry;

import static org.junit.Assert.fail;

import org.activiti.engine.HistoryService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.ActivitiRule;
import org.junit.Rule;

public class AbstractActivitiTest {

	@Rule
	public ActivitiRule activitiRule = new ActivitiRule("activiti.cfg.xml");

	public AbstractActivitiTest() {
		super();
	}

	protected void assertNodeVisited(ProcessInstance instance, String activityId) {
		HistoryService historyService = activitiRule.getHistoryService();
		long count = historyService.createHistoricActivityInstanceQuery().processInstanceId(instance.getId()).activityId(activityId).count();
		if(count < 1 ) fail("Node "+activityId+" not visited");
	}

}