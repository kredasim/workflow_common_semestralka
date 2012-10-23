package cz.cvut.fit.industry;

import static org.junit.Assert.*;

import org.activiti.engine.ProcessEngine;
import org.junit.Test;

public class ActivitiLibraryIT {

	@Test
	public void test() {
		ActivitiLibrary activitiLibrary = ActivitiPortletLibraryFactory.getActivitiLibrary();
		activitiLibrary.initialize();
		ProcessEngine processEngine = activitiLibrary.getProcessEngine();
		assertNotNull(processEngine);
		activitiLibrary.close();
	}

}
