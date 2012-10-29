package cz.cvut.fit.industry;

import static org.junit.Assert.*;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ActivitiLibraryIT {

	private ActivitiLibrary activitiLibrary;
	private ProcessEngine processEngine;

	@After
	public void cleanup() {
		if(activitiLibrary!=null)
			activitiLibrary.close();
	}
	
	@Before
	public void init() {
		activitiLibrary = ActivitiLibraryFactory.createActivitiLibrary();
		activitiLibrary.initialize();
		processEngine = activitiLibrary.getProcessEngine();
	}
	
	@Test
	public void testInitialize() {
		assertNotNull(processEngine);
	}
	
	@Test
	public void testStartProcess() {
		ProcessInstance processInstance = activitiLibrary.getRuntimeService().startProcessInstanceByKey("mainProcess");
		assertNotNull(processInstance);
	}

}
